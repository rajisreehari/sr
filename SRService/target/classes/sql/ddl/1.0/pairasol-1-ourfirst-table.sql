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

CREATE TABLE `social` (
  `username` varchar(100) NOT NULL,
  `network_name` varchar(100) NOT NULL,
  `twitter_oauth_access_token` varchar(400) NOT NULL,
  `twitter_oauth_access_token_secret` varchar(400) NOT NULL,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `created_by` varchar(100) NOT NULL,
  `updated_by` varchar(100) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `thing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(500) NOT NULL COMMENT 'Use for display and searching.',
  `name` varchar(150) NOT NULL COMMENT 'The name of the thing and this field get''s posted to twitter if the creator decides to tweet.',
  `rate` bigint(50) NOT NULL COMMENT 'This is the current voting rate of the thing.',
  `author_vote` bigint(50) DEFAULT NULL COMMENT 'this is the vote the author of the thing posted when the thing was created.',
  `number_of_votes` bigint(20) DEFAULT NULL COMMENT 'The number of people that have voted on this thing',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `created_by` varchar(100) NOT NULL,
  `updated_by` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_jpo6dujb9bu42rmu2mmqrb8i4` (`rate`)
) ENGINE=InnoDB AUTO_INCREMENT=165 DEFAULT CHARSET=latin1;

CREATE TABLE `thing_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `thing_id` bigint(20) NOT NULL,
  `comment` varchar(400) NOT NULL,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `created_by` varchar(100) NOT NULL,
  `updated_by` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

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
