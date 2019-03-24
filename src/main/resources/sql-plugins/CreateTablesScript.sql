drop table if exists assessment cascade;
drop table if exists dish cascade;
drop table if exists person cascade;
drop table if exists restaurant cascade;
drop sequence if exists global_seq;

create table assessment (
      id                  int4 not null,
      assessment_value    int4,
      date_time           timestamp default now(),
      id_person           int4,
      id_restaurant       int4,
      primary key (id)
);

create table dish (
      id                  int4 not null,
      dish_name           varchar(255),
      dish_price          int8,
      id_restaurant       int4 not null,
      primary key (id)
);

create table person (
      id                  int4 not null,
      email               varchar(255),
      password            varchar(255),
      person_name         varchar(255),
      status              varchar(255),
      primary key (id)
);

create table restaurant (
      id                  int4 not null,
      restaurant_name     varchar(255),
      primary key (id)
);

create sequence global_seq start 100000 increment 1;

alter table assessment add constraint FKr49sjwclub57pccve5mvwpyjd foreign key (id_person) references person;
alter table assessment add constraint FKsc553rnmh6to41bojqh94qtc0 foreign key (id_restaurant) references restaurant;
alter table dish add constraint FK5wuanccx4wcy5vlamwbq8rvcd foreign key (id_restaurant) references restaurant;