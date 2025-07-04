create table "home_role"
(
    role_uuid   varchar(36) not null
        primary key,
    role_name   varchar(50) not null
        unique,
    description text        not null
);

comment on table home_role is '角色表';

comment on column home_role.role_uuid is '角色唯一标识';

comment on column home_role.role_name is '角色名称';

comment on column home_role.description is '角色描述';


