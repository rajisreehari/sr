CREATE TABLE `rate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rate_five` varchar(255) DEFAULT NULL,
  `rate_four` varchar(255) DEFAULT NULL,
  `rate_one` varchar(255) DEFAULT NULL,
  `rate_six` varchar(255) DEFAULT NULL,
  `rate_three` varchar(255) DEFAULT NULL,
  `rate_two` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `thing` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_1o63bshp5acxjv9blljyn7k1i` (`thing`),
  CONSTRAINT `FK_1o63bshp5acxjv9blljyn7k1i` FOREIGN KEY (`thing`) REFERENCES `thing` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE `thing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(500) NOT NULL,
  `name` varchar(150) NOT NULL,
  `rate` bigint(20) DEFAULT NULL,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `created_by` varchar(45) NOT NULL,
  `updated_by` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_jpo6dujb9bu42rmu2mmqrb8i4` (`rate`),
  CONSTRAINT `FK_jpo6dujb9bu42rmu2mmqrb8i4` FOREIGN KEY (`rate`) REFERENCES `rate` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
