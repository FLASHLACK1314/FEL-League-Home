package com.flashlack.felleaguehome.mapper;

import com.flashlack.felleaguehome.model.RoleDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 角色数据访问对象（RoleMapper）接口。
 * @author FLSHLACK
 */
@Mapper
public interface RoleMapper {

    // 查询角色信息根据角色UUID
    @Select("SELECT * FROM role WHERE role_uuid = #{roleUuid}")
    RoleDO getRoleByUuid(String roleUuid);

}
