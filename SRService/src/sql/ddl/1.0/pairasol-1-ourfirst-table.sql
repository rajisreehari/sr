CREATE TABLE `authorities` (
  `username` varchar(100) NOT NULL,
  `authority` varchar(50) NOT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `updated_by` varchar(100) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  UNIQUE KEY `ix_auth_username` (`username`,`authority`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `social` (
  `username` varchar(100) NOT NULL,
  `network_name` varchar(100) NOT NULL,
  `twitter_oauth_access_token` varchar(400) NOT NULL,
  `twitter_oauth_access_token_secret` varchar(400) NOT NULL,
  `created_by` varchar(100) NOT NULL,
  `updated_by` varchar(100) NOT NULL,
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `thing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(500) NOT NULL COMMENT 'Use for display and searching.',
  `name` varchar(140) NOT NULL COMMENT 'The name of the thing and this field get''s posted to twitter if the creator decides to tweet.',
  `created_by` varchar(100) NOT NULL,
  `updated_by` varchar(100) NOT NULL,
  `rate` bigint(50) NOT NULL COMMENT 'This is the current voting rate of the thing.',
  `author_vote` bigint(50) DEFAULT NULL COMMENT 'this is the vote the author of the thing posted when the thing was created.',
  `number_of_votes` bigint(20) DEFAULT NULL COMMENT 'The number of people that have voted on this thing',
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `main_image_path` varchar(250) DEFAULT NULL,
  `thumb_image_path` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_jpo6dujb9bu42rmu2mmqrb8i4` (`rate`)
) ENGINE=InnoDB AUTO_INCREMENT=233 DEFAULT CHARSET=latin1;

CREATE TABLE `thing_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `thing_id` bigint(20) NOT NULL,
  `comment` varchar(400) NOT NULL,
  `created_by` varchar(100) NOT NULL,
  `updated_by` varchar(100) NOT NULL,
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `main_image_path` varchar(250) DEFAULT NULL,
  `thumb_image_path` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `created_by` varchar(100) DEFAULT NULL,
  `updated_by` varchar(100) DEFAULT NULL,
  `first_name` varchar(200) DEFAULT NULL,
  `last_name` varchar(200) DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `date_of_birth` datetime DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  `main_image_path` varchar(250) DEFAULT NULL,
  `thumb_image_path` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
