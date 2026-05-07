create table if not exists doner_order (
                                           id bigserial primary key,
                                           delivery_name varchar(50) not null,
    delivery_street varchar(50) not null,
    delivery_city varchar(50) not null,
    delivery_state varchar(2) not null,
    delivery_zip varchar(10) not null,
    cc_number varchar(16) not null,
    cc_expiration varchar(5) not null,
    cc_cvv varchar(3) not null,
    placed_at timestamp not null
    );

create table if not exists doner (
                                     id bigserial primary key,
                                     name varchar(50) not null,
    doner_order bigint not null,
    doner_order_key bigint not null,
    created_at timestamp not null,
    constraint fk_doner_order
    foreign key (doner_order) references doner_order(id)
    );

create table if not exists ingredient (
                                          id varchar(4) not null primary key,
    name varchar(25) not null,
    type varchar(10) not null
    );

create table if not exists ingredient_ref (
                                              ingredient varchar(4) not null,
    doner bigint not null,
    doner_key bigint not null,
    constraint fk_ingredient_ref_ingredient
    foreign key (ingredient) references ingredient(id),
    constraint fk_ingredient_ref_doner
    foreign key (doner) references doner(id)
    );