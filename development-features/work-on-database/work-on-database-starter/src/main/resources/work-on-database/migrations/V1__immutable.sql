CREATE TABLE guestbook_entry
(
    id                  uuid not null,
    creation_time       bigint not null,
    update_time         bigint not null,
    visit_time          bigint not null,
    full_name           varchar(255),
    primary key (id)
)