package com.flashlack.felleaguehome.mapper;

import com.flashlack.felleaguehome.model.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 用户数据访问对象（UserMapper）接口。
 *
 * @author FLASHLACK
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM home_user WHERE user_name = #{username}")
    UserDO getUserByUsername(String username);

    @Select("SELECT * FROM home_user WHERE email = #{email}")
    UserDO getUserByEmail(String email);

    @Select("SELECT * FROM home_user WHERE qq_account = #{qq}")
    UserDO getUserByQq(String qq);
}
