
 create table users(
      username varchar(50) not null primary key,
      password varchar(50) not null,
      enabled boolean not null);

create table authorities (
      username varchar(50) not null,
      authority varchar(50) not null,
      constraint fk_authorities_users foreign key(username) references users(username));
      create unique index ix_auth_username on authorities (username,authority);
      
INSERT INTO `spring_security`.`users` (`username`, `password`, `enabled`) VALUES ('user', '123', '1');
INSERT INTO `spring_security`.`users` (`username`, `password`, `enabled`) VALUES ('admin', '123', '1');
INSERT INTO `spring_security`.`authorities` (`username`, `authority`) VALUES ('admin', 'ROLE_USER');
INSERT INTO `spring_security`.`authorities` (`username`, `authority`) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO `spring_security`.`authorities` (`username`, `authority`) VALUES ('user', 'ROLE_USER');

update users
	set password='$2a$10$v2mn8oxqOg/h9f5Puo7MweshRscU5NUb27wMiMalLoXc/0pFwTBCK'
    where username='admin';
    
update users
	set password='$2a$10$v2mn8oxqOg/h9f5Puo7MweshRscU5NUb27wMiMalLoXc/0pFwTBCK'
    where username='user';