package hu.lamsoft.experiment.parkhouse.service.customer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.lamsoft.experiment.parkhouse.persistence.mapper.CustomerMapper;
import hu.lamsoft.experiment.parkhouse.persistence.model.Customer;
import hu.lamsoft.experiment.parkhouse.service.customer.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public Customer findById(Long id) {
		return customerMapper.findCustomerById(id);
	}

	@Override
	public List<Customer> findAll() {
		return customerMapper.getAllCustomers();
	}

	@Override
	public Customer create(Customer customer) {
		customerMapper.insertCustomer(customer);
		return customer;
	}

	@Override
	public Customer update(Customer customer) {
		customerMapper.updateCustomer(customer);
		return customer;
	}

}
