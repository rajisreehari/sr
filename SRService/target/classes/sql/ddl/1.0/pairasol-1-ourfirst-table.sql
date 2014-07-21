CREATE TABLE `thing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(500) NOT NULL,
  `name` varchar(150) NOT NULL,
  `rate` bigint(20) NOT NULL,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `created_by` varchar(45) NOT NULL,
  `updated_by` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_jpo6dujb9bu42rmu2mmqrb8i4` (`rate`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=latin1;
