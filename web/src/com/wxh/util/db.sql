CREATE TABLE `goddess` (
	`id` INT (11) NOT NULL AUTO_INCREMENT,
	`user_name` VARCHAR (30) NOT NULL,
	`sex` INT (11) DEFAULT NULL,
	`age` INT (11) DEFAULT NULL,
	`birthday` date DEFAULT NULL,
	`email` VARCHAR (30) DEFAULT NULL,
	`mobile` VARCHAR (11) DEFAULT NULL,
	`create_user` VARCHAR (30) DEFAULT NULL,
	`create_date` date DEFAULT NULL,
	`update_user` VARCHAR (30) DEFAULT NULL,
	`update_date` date DEFAULT NULL,
	`isdel` INT (11) DEFAULT NULL,
	PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

INSERT INTO `goddess` ( `id`, `user_name`, `sex`, `age`, `birthday`, `email`, `mobile`, `create_user`, `create_date`, `update_user`, `update_date`, `isdel` ) VALUES ( 1, '小溪', 1, 22, '2009-10-12', 'xiaoxi@163.com', '15021331215', 'ADMIN', '2016-11-08', 'ADMIN', '2016-11-08', 0 );

