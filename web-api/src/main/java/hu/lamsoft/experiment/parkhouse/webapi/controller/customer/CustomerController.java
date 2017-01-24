package hu.lamsoft.experiment.parkhouse.webapi.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.lamsoft.experiment.parkhouse.persistence.model.Customer;
import hu.lamsoft.experiment.parkhouse.persistence.model.Vehicle;
import hu.lamsoft.experiment.parkhouse.service.customer.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(path = "/customer/{id}", method = RequestMethod.GET)
	public Customer getCustomer(@PathVariable(value = "id", required = true) Long id) {
		return customerService.findById(id);
	}
	
	@RequestMapping(path = "/customers", method = RequestMethod.GET)
	public List<Customer> getCustomers() {
		return customerService.findAll();
	}
	
	@RequestMapping(path = "/customer/{customerId}/vehicles", method = RequestMethod.GET)
	public List<Vehicle> getCustomerVehicles(@PathVariable(value = "id", required = true) Long id) {
		return customerService.findById(id).getVehicles();
	}
	
	@RequestMapping(path = "/customer", method = RequestMethod.POST)
	public Customer createUser(@RequestParam(value = "firstName", required = true) String firstName,
			@RequestParam(value = "lastName", required = true) String lastName,
			@RequestParam(value = "email", required = true) String email) {
		Customer customer = Customer.builder().firstName(firstName).lastName(lastName).email(email).build();
		customerService.create(customer);
		return customer;
	}
	
	@RequestMapping(path = "/customer/{id}", method = RequestMethod.PUT)
	public Customer updateUser(@PathVariable(value = "id", required = true) Long id,
			@RequestParam(value = "firstName", required = true) String firstName,
			@RequestParam(value = "lastName", required = true) String lastName,
			@RequestParam(value = "email", required = false) String email) {
		Customer customer = customerService.findById(id);
		if(firstName != null) {
			customer.setFirstName(firstName);
		}
		if(lastName != null) {
			customer.setLastName(lastName);
		}
		if(email != null) {
			customer.setEmail(email);
		}
		customerService.update(customer);
		return customer;
	}
	
}
