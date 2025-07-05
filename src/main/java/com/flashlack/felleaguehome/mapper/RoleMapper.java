package com.flashlack.felleaguehome.mapper;

import com.flashlack.felleaguehome.model.entity.RoleDO;
import jakarta.validation.constraints.NotBlank;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 角色数据访问对象（RoleMapper）接口。
 *
 * @author FLSHLACK
 */
@Mapper
public interface RoleMapper {

    // 查询角色信息根据角色UUID
    @Select("SELECT * FROM home_role WHERE role_uuid = #{roleUuid}")
    RoleDO getRoleByUuid(String roleUuid);

    /**
     * 插入新的角色记录到 home_role 表。
     */
    @Insert("INSERT INTO home_role (" +
            "role_uuid, role_name, description" +
            ") VALUES (" +
            "#{roleUuid}, #{roleName}, #{description}" +
            ")")
    void save(RoleDO roleDO);

    /**
     * 根据角色名称获取角色信息。
     * @param roleName 角色名称
     * @return RoleDO 角色数据对象
     */
    @Select("SELECT * FROM home_role WHERE role_name = #{roleName}")
    RoleDO getRoleByName(@NotBlank String roleName);
}
