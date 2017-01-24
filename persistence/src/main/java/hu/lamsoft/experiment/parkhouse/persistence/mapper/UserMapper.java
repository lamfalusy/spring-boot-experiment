package hu.lamsoft.experiment.parkhouse.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import hu.lamsoft.experiment.parkhouse.persistence.model.User;

@Mapper
public interface UserMapper {

	@Select("SELECT * FROM user WHERE id = #{id}")
    public User findUserById(Long id);
	
	@Select("SELECT * FROM user")
    public List<User> getAllUsers();

	@Insert("INSERT into user(firstname,lastname,email) VALUES(#{firstName}, #{lastName}, #{email})")
    public int insertUser(User user);

	@Update("UPDATE user SET firstname=#{firstName}, lastname=#{lastName}, email=#{email} WHERE id=#{id}")
    public int updateUser(User user);
	
}
