drop table if exists `t_code`;
create table `t_code`(
	`entity_pro_define` text,
	`entity_setter` text not null,
	`entity_getter` text not null,
	`entity_dao` text,
	`entity_service` text
)ENGINE=InnoDB DEFAULT charset=utf8;
insert into `t_code`(`entity_pro_define`,`entity_setter`,`entity_getter`,`entity_dao`,`entity_service`) values('',' public void set##PROPERTY_NAME_FirstUp##(##PROPERTY_TYPE## ##PROPERTY_NAME##) {\n		this.##PROPERTY_NAME## = ##PROPERTY_NAME##;\n	}','public ##PROPERTY_TYPE## get##PROPERTY_NAME_FirstUp##() {\n		return ##PROPERTY_NAME##;\n	}','','');