create table "user"
(
    user_uuid  varchar(36)  not null
        primary key,
    username   varchar(50)  not null
        unique,
    password   varchar(100) not null,
    email      varchar(100) not null
        unique,
    qq_account varchar(20) not null
        unique,
    role_uuid  varchar(36)  not null
);

comment on table "user" is '用户表';
comment on column "user".user_uuid is '用户唯一标识';
comment on column "user".username is '用户名';
comment on column "user".password is '用户密码';
comment on column "user".email is '用户邮箱';
comment on column "user".qq_account is '用户QQ账号';
comment on column "user".role_uuid is '用户角色标识';

ALTER TABLE "user"
    ADD CONSTRAINT fk_user_role FOREIGN KEY (role_uuid) REFERENCES "role" (role_uuid);