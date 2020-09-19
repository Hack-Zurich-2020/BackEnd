CREATE TABLE `orders`
(
    `id`              varchar(255) NOT NULL,
    `nutrition_facts` varchar(255) DEFAULT NULL,
    `waste_amount`    int          NOT NULL,
    `wast_cause`      int          NOT NULL,
    `foods_map`       varchar(255) DEFAULT NULL,
    `user_id`         varchar(255) NOT NULL,
    `is_finalized`    boolean      NOT NULL,
    PRIMARY KEY (`id`),
    KEY `user_id` (`user_id`),
    CONSTRAINT `orders_user_map` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);