package com.flashlack.felleaguehome.mapper;

import com.flashlack.felleaguehome.model.entity.UserDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 用户数据访问对象（UserMapper）接口。
 *
 * @author FLASHLACK
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM home_user WHERE user_name = #{userName}")
    UserDO getUserByUsername(String username);

    @Select("SELECT * FROM home_user WHERE email = #{email}")
    UserDO getUserByEmail(String email);

    @Select("SELECT * FROM home_user WHERE qq_account = #{qqAccount}")
    UserDO getUserByQqAccount(String qq);

    @Insert("INSERT INTO home_user (" +
            "user_uuid, user_name, password, email, qq_account, role_uuid" +
            ") VALUES (" +
            "#{userUuid}, #{userName}, #{password}, #{email}, #{qqAccount}, #{roleUuid}" +
            ")")
    void save(UserDO userDO);
}
