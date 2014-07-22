CREATE TABLE `authorities` (
  `username` varchar(100) NOT NULL,
  `authority` varchar(50) NOT NULL,
  `created_time` timestamp NULL DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `updated_time` timestamp NULL DEFAULT NULL,
  `updated_by` varchar(100) DEFAULT NULL,
  UNIQUE KEY `ix_auth_username` (`username`,`authority`),
  CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `thing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(500) NOT NULL,
  `name` varchar(150) NOT NULL,
  `rate` bigint(50) NOT NULL,
  `number_of_votes` bigint(20) DEFAULT NULL,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `created_by` varchar(100) NOT NULL,
  `updated_by` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_jpo6dujb9bu42rmu2mmqrb8i4` (`rate`)
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=latin1;


CREATE TABLE `users` (
  `username` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `created_time` timestamp NULL DEFAULT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `updated_time` timestamp NULL DEFAULT NULL,
  `updated_by` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
