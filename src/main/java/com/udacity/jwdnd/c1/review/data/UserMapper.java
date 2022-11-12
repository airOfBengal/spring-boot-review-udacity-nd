package com.udacity.jwdnd.c1.review.data;


import com.udacity.jwdnd.c1.review.models.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("select * from users where username = #{username}")
    public User getUser(String username);

    @Insert("insert into users (username, salt, password, firstname, lastname) values(#{username}, #{salt}, #{password}, #{firstname}, #{lastname})")
    @Options(useGeneratedKeys = true, keyProperty = "userid")
    public Integer insert(User user);

    @Delete("delete from users where userid = #{userid}")
    public void delete(Integer userid);
}
