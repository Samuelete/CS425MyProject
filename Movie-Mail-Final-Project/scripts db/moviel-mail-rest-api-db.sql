CREATE TABLE `bank_system` (
  `bank_system_id` bigint NOT NULL AUTO_INCREMENT,
  `accoun_number` varchar(255) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `routing_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`bank_system_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `customers` (
  `customer_id` bigint NOT NULL AUTO_INCREMENT,
  `city` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `street` varchar(255) NOT NULL,
  `zip_code` varchar(255) NOT NULL,
  `accoun_number` varchar(255) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `routing_number` varchar(255) DEFAULT NULL,
  `customer_number` int NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `card_number` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `expire_date` date DEFAULT NULL,
  `shopping_cart_shopping_card_id` bigint DEFAULT NULL,
  `watchlist_watchlist_id` bigint DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `UK_8fhfjvj4rcaaef7a67bsde1u1` (`street`),
  UNIQUE KEY `UK_t74y58jagthxqxysuw9l0jx6y` (`customer_number`),
  KEY `FKjtgtcuhpyipfu4j8yiuhhbi1c` (`shopping_cart_shopping_card_id`),
  KEY `FKqxvwqcw9k6qmxec86pafm1ffq` (`watchlist_watchlist_id`),
  CONSTRAINT `FKjtgtcuhpyipfu4j8yiuhhbi1c` FOREIGN KEY (`shopping_cart_shopping_card_id`) REFERENCES `shopping_cart` (`shopping_card_id`),
  CONSTRAINT `FKqxvwqcw9k6qmxec86pafm1ffq` FOREIGN KEY (`watchlist_watchlist_id`) REFERENCES `watchlist` (`watchlist_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `customers_dvds` (
  `customer_customer_id` bigint NOT NULL,
  `dvd_list_rented_dvd_id` bigint NOT NULL,
  UNIQUE KEY `UK_c6nwiq5nyvl8r0od3td8capwi` (`dvd_list_rented_dvd_id`),
  KEY `FK5js4e7ssdhdxkm1skai184i90` (`customer_customer_id`),
  CONSTRAINT `FK5js4e7ssdhdxkm1skai184i90` FOREIGN KEY (`customer_customer_id`) REFERENCES `customers` (`customer_id`),
  CONSTRAINT `FKt3d4r9ut2wsxipvsbhd5mbq91` FOREIGN KEY (`dvd_list_rented_dvd_id`) REFERENCES `dvds` (`dvd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `customers_subscription` (
  `customer_customer_id` bigint NOT NULL,
  `subscriptions_base_price` int NOT NULL,
  UNIQUE KEY `UK_fwpls445jm8m9jl0kv0hd4n6v` (`subscriptions_base_price`),
  KEY `FKm60p685n37lsxc6q0fi0va3g3` (`customer_customer_id`),
  CONSTRAINT `FKjqe9901diblnhxv51tvk34i63` FOREIGN KEY (`subscriptions_base_price`) REFERENCES `subscription` (`base_price`),
  CONSTRAINT `FKm60p685n37lsxc6q0fi0va3g3` FOREIGN KEY (`customer_customer_id`) REFERENCES `customers` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `dvds` (
  `dvd_id` bigint NOT NULL AUTO_INCREMENT,
  `bar_code` varchar(255) NOT NULL,
  `filmmaker` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `most_popular` int NOT NULL,
  `rate` double NOT NULL,
  `year_of_release` int NOT NULL,
  PRIMARY KEY (`dvd_id`),
  UNIQUE KEY `UK_8e6789lgi2u0497nebau12n6e` (`bar_code`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `employee` (
  `employee_id` bigint NOT NULL AUTO_INCREMENT,
  `employee_number` varchar(255) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY `UK_oosi3suv54trvclvanif87cnt` (`employee_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `epay` (
  `epay_id` bigint NOT NULL AUTO_INCREMENT,
  `card_number` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `expire_date` date DEFAULT NULL,
  PRIMARY KEY (`epay_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `orders` (
  `order_id` bigint NOT NULL AUTO_INCREMENT,
  `date_order` date DEFAULT NULL,
  `order_number` bigint NOT NULL,
  `purchase_description` varchar(255) NOT NULL,
  `customer_id` bigint DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `UK_nthkiu7pgmnqnu86i2jyoe2v7` (`order_number`),
  KEY `FKpxtb8awmi0dk6smoh2vp1litg` (`customer_id`),
  CONSTRAINT `FKpxtb8awmi0dk6smoh2vp1litg` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `shopping_cart` (
  `shopping_card_id` bigint NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`shopping_card_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `shopping_cart_dvds` (
  `shopping_cart_shopping_card_id` bigint NOT NULL,
  `dvds_on_cart_dvd_id` bigint NOT NULL,
  UNIQUE KEY `UK_rgnnsrmwx49de49dqp2x1uw07` (`dvds_on_cart_dvd_id`),
  KEY `FKt1ojuuhygihpt19u77mnhli0a` (`shopping_cart_shopping_card_id`),
  CONSTRAINT `FKt1ojuuhygihpt19u77mnhli0a` FOREIGN KEY (`shopping_cart_shopping_card_id`) REFERENCES `shopping_cart` (`shopping_card_id`),
  CONSTRAINT `FKtpak89h6dxxarrbgrvx8celsu` FOREIGN KEY (`dvds_on_cart_dvd_id`) REFERENCES `dvds` (`dvd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `subscription` (
  `base_price` int NOT NULL AUTO_INCREMENT,
  `dvd_at_home` int NOT NULL,
  `dvd_monthly` int NOT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`base_price`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `watchlist` (
  `watchlist_id` bigint NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`watchlist_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `watchlist_dvds` (
  `watchlist_watchlist_id` bigint NOT NULL,
  `watch_list_dvds_dvd_id` bigint NOT NULL,
  UNIQUE KEY `UK_b220vxmd6msa91v44hi8rflip` (`watch_list_dvds_dvd_id`),
  KEY `FKbqielt4gbrdj8yu7gydqner42` (`watchlist_watchlist_id`),
  CONSTRAINT `FKbqielt4gbrdj8yu7gydqner42` FOREIGN KEY (`watchlist_watchlist_id`) REFERENCES `watchlist` (`watchlist_id`),
  CONSTRAINT `FKdy4khxmng96wvcdl15swhf4qw` FOREIGN KEY (`watch_list_dvds_dvd_id`) REFERENCES `dvds` (`dvd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
