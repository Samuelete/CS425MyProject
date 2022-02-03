CREATE TABLE `customer` (
  `customer_id` bigint NOT NULL AUTO_INCREMENT,
  `customer_number` int NOT NULL,
  `full_name` varchar(255) NOT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `UK_mo8uc9hxwlycihsxq6ucdxs1c` (`customer_number`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `dvd` (
  `dvd_id` bigint NOT NULL AUTO_INCREMENT,
  `bar_code` varchar(255) NOT NULL,
  `filmmaker` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `most_popular` int NOT NULL,
  `rate` double NOT NULL,
  `year_of_release` int NOT NULL,
  PRIMARY KEY (`dvd_id`),
  UNIQUE KEY `UK_14l7uct7pxs4fhyonjk7vi70u` (`bar_code`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `customer_dvd` (
  `customer_customer_id` bigint NOT NULL,
  `dvd_list_rented_dvd_id` bigint NOT NULL,
  UNIQUE KEY `UK_753bv82geyxc9qcfuicra17pn` (`dvd_list_rented_dvd_id`),
  KEY `FK7k40b8747smtt8qtal6jqd04m` (`customer_customer_id`),
  CONSTRAINT `FK3e3yr6nn1w9l07xkxm40o3m7h` FOREIGN KEY (`dvd_list_rented_dvd_id`) REFERENCES `dvd` (`dvd_id`),
  CONSTRAINT `FK7k40b8747smtt8qtal6jqd04m` FOREIGN KEY (`customer_customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
