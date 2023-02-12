CREATE TABLE ehcache_test
(
    id                  uuid not null,
    creation_time       bigint not null,
    update_time         bigint not null,
    name                varchar(255),
    description         varchar(255),
    primary key (id)
)