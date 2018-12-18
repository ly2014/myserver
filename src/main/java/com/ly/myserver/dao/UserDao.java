package com.ly.myserver.dao;

import com.ly.myserver.model.User;
import org.apache.ibatis.annotations.*;

/**
 * @author ying
 * @date 2018-12-18 19:31
 */
@Mapper
public interface UserDao {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "unum", column = "u_number"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "onlineStatus", column = "u_online_status"),
            @Result(property = "status", column = "u_status")
    })
    @Select("select * from p_user where username = #{username}")
    User getByUsername(String username);

    @Delete("delete from p_user where id = #{id}")
    void deleteById(int id);
}
