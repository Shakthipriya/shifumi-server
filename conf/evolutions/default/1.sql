# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table game (
  id                        bigint not null,
  player_owner_id           bigint,
  player_guest_id           bigint,
  constraint pk_game primary key (id))
;

create table player (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_player primary key (id))
;

create sequence game_seq;

create sequence player_seq;

alter table game add constraint fk_game_playerOwner_1 foreign key (player_owner_id) references player (id) on delete restrict on update restrict;
create index ix_game_playerOwner_1 on game (player_owner_id);
alter table game add constraint fk_game_playerGuest_2 foreign key (player_guest_id) references player (id) on delete restrict on update restrict;
create index ix_game_playerGuest_2 on game (player_guest_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists game;

drop table if exists player;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists game_seq;

drop sequence if exists player_seq;

