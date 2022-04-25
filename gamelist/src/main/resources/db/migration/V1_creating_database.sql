create table game (
    id bigint not null auto_increment,
    name varchar(255) not null,
    description varchar(255) not null,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp,
    primary key (id)
);

