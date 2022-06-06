drop table if exists link CASCADE;
drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start with 1 increment by 1;
create table link (id bigint not null, created_at timestamp, encoded varchar(255), url varchar(255), primary key (id));