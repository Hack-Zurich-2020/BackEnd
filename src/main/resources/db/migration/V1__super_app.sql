CREATE TABLE `restaurants`
(
    `id`           int    NOT NULL auto_increment,
    `category_ids` varchar(255) DEFAULT NULL,
    `name`         varchar(255) DEFAULT NULL,
    `longitude`    double NOT NULL,
    `latitude`     double NOT NULL,
    `orders_count` int    NOT NULL,
    `score`        double NOT NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE `foods`
(
    `id`              bigint NOT NULL auto_increment,
    `category_ids`    varchar(255) DEFAULT NULL,
    `nutrition_facts` varchar(255) DEFAULT NULL,
    `amount`          int    NOT NULL,
    `price`           int    NOT NULL,
    `restaurant_id`   int    NOT NULL,
    `ingredients`     varchar(255) DEFAULT NULL,
    `type`            int    NOT NULL,
    `name`            varchar(255) DEFAULT NULL,
    `orders_count`    int    NOT NULL,
    `score`           double NOT NULL,
    PRIMARY KEY (`id`),
    KEY `restaurant_id` (`restaurant_id`),
    CONSTRAINT `foods_restaurant_map` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`id`)
);
CREATE TABLE `users`
(
    `id`            int          NOT NULL AUTO_INCREMENT,
    `user_name`     varchar(255) NOT NULL,
    `health_params` varchar(255) DEFAULT NULL,
    `balance`       int          NOT NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE `orders`
(
    `id`              varchar(255) NOT NULL,
    `nutrition_facts` varchar(255) DEFAULT NULL,
    `waste_amount`    int          NOT NULL,
    `waste_cause`      int          NOT NULL,
    `foods_map`       varchar(255) DEFAULT NULL,
    `user_id`         int          NOT NULL,
    `is_finalized`    boolean      NOT NULL,
    PRIMARY KEY (`id`),
    KEY `user_id` (`user_id`),
    CONSTRAINT `orders_user_map` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);