CREATE TABLE IF NOT EXISTS `game` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY (`id`),
  `name` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `image` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  `release_date` date NOT NULL,
  `developer` varchar(255) NOT NULL,
  `publisher` varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS `genre` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY (`id`),
  `name` varchar(255) NOT NULL
);


CREATE TABLE IF NOT EXISTS `platform` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY (`id`),
  `name` varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY (`id`),
  `name` varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS `game_platform` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY (`id`),
  `game_id` int(11) NOT NULL,
  `platform_id` int(11) NOT NULL,
  FOREIGN KEY (`game_id`) REFERENCES `game`(`id`),
  FOREIGN KEY (`platform_id`) REFERENCES `platform`(`id`)
);



CREATE TABLE IF NOT EXISTS `game_genre` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY (`id`),
  `game_id` int(11) NOT NULL,
  `genre_id` int(11) NOT NULL
);

CREATE TABLE IF NOT EXISTS `game_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY (`id`),
  `user_id` int(11) NOT NULL,
  `game_id` int(11) NOT NULL
);

CREATE TABLE IF NOT EXISTS `game_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY (`id`),
  `game_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL
);