package hu.lamsoft.experiment.parkhouse.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import hu.lamsoft.experiment.parkhouse.persistence.model.Customer;

@Mapper
public interface CustomerMapper {

	@Select("SELECT c.id, c.firstname, c.lastname, c.email, v.id, v.registration_number, v.weight_in_kg, v.number_of_wheels FROM customer c LEFT JOIN vehicle v ON v.owner_fk = c.id WHERE c.id = #{id}")
    public Customer findCustomerById(Long id);
	
	@Select("SELECT c.id, c.firstname, c.lastname, c.email, v.id, v.registration_number, v.weight_in_kg, v.number_of_wheels FROM customer c LEFT JOIN vehicle v ON v.owner_fk = c.id")
    public List<Customer> getAllCustomers();

	@Insert("INSERT into customer(firstname,lastname,email) VALUES(#{firstName}, #{lastName}, #{email})")
    public int insertCustomer(Customer customer);

	@Update("UPDATE customer SET firstname=#{firstName}, lastname=#{lastName}, email=#{email} WHERE id=#{id}")
    public int updateCustomer(Customer customer);
	
}
