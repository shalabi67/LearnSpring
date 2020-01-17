


CREATE TABLE IF NOT EXISTS `CUSTOMER` (
	`id` bigint NOT NULL PRIMARY KEY,
    `user_id` varchar(50) NOT NULL,
	`first_name` varchar(50) not null,
	`last_name` varchar(50) not null,
    `email` varchar(100) not null,
    `phone_number` varchar(25)
);


