CREATE TABLE bi_one_to_many_a
(
    id                  uuid not null,
    creation_time       bigint not null,
    update_time         bigint not null,
    example_col         varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE bi_one_to_many_b
(
    id                      uuid not null,
    creation_time           bigint not null,
    update_time             bigint not null,
    example_col             varchar(255),
    bi_one_to_many_a_id     uuid not null,
    PRIMARY KEY (id),
    FOREIGN KEY (bi_one_to_many_a_id) REFERENCES bi_one_to_many_a(id)
);

CREATE TABLE uni_one_to_many_a
(
    id                  uuid not null,
    creation_time       bigint not null,
    update_time         bigint not null,
    example_col         varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE uni_one_to_many_b
(
    id                      uuid not null,
    creation_time           bigint not null,
    update_time             bigint not null,
    example_col             varchar(255),
    uni_one_to_many_b_id    uuid not null,
    PRIMARY KEY (id),
    FOREIGN KEY (uni_one_to_many_b_id) REFERENCES uni_one_to_many_a(id)
);


CREATE TABLE bi_one_to_one_a
(
    id                  uuid not null,
    creation_time       bigint not null,
    update_time         bigint not null,
    example_col         varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE bi_one_to_one_b
(
    id                      uuid not null,
    creation_time           bigint not null,
    update_time             bigint not null,
    example_col             varchar(255),
    bi_one_to_one_a_id      uuid not null,
    PRIMARY KEY (id),
    FOREIGN KEY (bi_one_to_one_a_id) REFERENCES bi_one_to_one_a(id)
);

CREATE TABLE uni_one_to_one_a
(
    id                  uuid not null,
    creation_time       bigint not null,
    update_time         bigint not null,
    example_col         varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE uni_one_to_one_b
(
    id                      uuid not null,
    creation_time           bigint not null,
    update_time             bigint not null,
    example_col             varchar(255),
    uni_one_to_one_a        uuid not null,
    PRIMARY KEY (id),
    FOREIGN KEY (uni_one_to_one_a) REFERENCES uni_one_to_one_a(id)
);