CREATE DATABASE IF NOT EXISTS `thanos_reservations`;
USE `thanos_reservations`;

CREATE TABLE IF NOT EXISTS `user_type` (
  `id` INT NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `defaul_permission` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `block` (
  `id` INT NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `num_room` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `classroom` (
  `id` INT NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `capacity` INT NOT NULL DEFAULT 0,
  `computer` CHAR(1) NOT NULL DEFAULT 'N',
  `video_beams` CHAR(1) NOT NULL DEFAULT 'N',
  `block_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_classroom_block_idx` (`block_id` ASC),
  CONSTRAINT `fk_classroom_block`
    FOREIGN KEY (`block_id`)
    REFERENCES `block` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `person` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NULL,
  `code` VARCHAR(15) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(15) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL,
  `user` VARCHAR(45) NOT NULL,
  `password` BLOB NOT NULL,
  `permissions` VARCHAR(100) NULL,
  `user_type_id` INT NOT NULL,
  `person_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_user_type1_idx` (`user_type_id` ASC),
  INDEX `fk_user_person1_idx` (`person_id` ASC),
  CONSTRAINT `fk_user_user_type1`
    FOREIGN KEY (`user_type_id`)
    REFERENCES `user_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_person1`
    FOREIGN KEY (`person_id`)
    REFERENCES `person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `reservation` (
  `id` INT NOT NULL,
  `date_init` VARCHAR(45) NOT NULL,
  `date_end` VARCHAR(45) NOT NULL,
  `observations` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `user_reservation` (
  `user_id` INT NOT NULL,
  `classroom_id` INT NOT NULL,
  `reservation_id` INT NOT NULL,
  INDEX `fk_user_reservation_user1_idx` (`user_id` ASC),
  INDEX `fk_user_reservation_classroom1_idx` (`classroom_id` ASC),
  INDEX `fk_user_reservation_reservation1_idx` (`reservation_id` ASC),
  CONSTRAINT `fk_user_reservation_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_reservation_classroom1`
    FOREIGN KEY (`classroom_id`)
    REFERENCES `classroom` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_reservation_reservation1`
    FOREIGN KEY (`reservation_id`)
    REFERENCES `reservation` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
