CREATE TABLE `restaurants`
(
    `id`           int    NOT NULL auto_increment,
    `category_ids` varchar(255) DEFAULT NULL,
    `name`         varchar(255) DEFAULT NULL,
    `longitude`    double NOT NULL,
    `latitude`     double NOT NULL,
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
    PRIMARY KEY (`id`),
    KEY `restaurant_id` (`restaurant_id`),
    CONSTRAINT `foods_restaurant_map` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`id`)
);
CREATE TABLE `users`
(
    `id`            varchar(255) NOT NULL,
    `health_params` varchar(255) DEFAULT NULL
);