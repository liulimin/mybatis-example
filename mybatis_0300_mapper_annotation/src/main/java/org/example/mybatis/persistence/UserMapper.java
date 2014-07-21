package org.example.mybatis.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.mybatis.domain.User;

public interface UserMapper {

	@Insert("insert into t_user(userName,password,comment) values(#{userName},#{password},#{comment})")
	public int insert(User user);

	@Update("update t_user set userName=#{userName},password=#{password},comment=#{comment}	where userName=#{userName}")
	public int update(User user);

	@Delete("delete from t_user where userName=#{userName}")
	public int delete(String userName);

	@Select("select * from t_user order by userName asc")
	public List<User> selectAll();

	@Select("select count(*) c from t_user")
	public int countAll();

	@Select("select * from t_user where userName=#{userName}")
	public User findByUserName(String userName);
}
