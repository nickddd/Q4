--drop table services if exists;
--drop table customers if exists;
--drop table subscription if exists;

-- MySQL Workbench Forward Engineering

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
SET Mode =MYSQL;


-- -----------------------------------------------------
-- Table `mydb`.`services`
-- -----------------------------------------------------
CREATE TABLE `services` (
  `service_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`service_id`));


-- -----------------------------------------------------
-- Table `mydb`.`customers`
-- -----------------------------------------------------
CREATE TABLE `customers` (
  `customer_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`customer_id`));


-- -----------------------------------------------------
-- Table `mydb`.`subscription`
-- -----------------------------------------------------
CREATE TABLE `subscriptions` (
  `service_id` INT NOT NULL,
  `customer_id` INT NOT NULL,
  PRIMARY KEY (`service_id`, `customer_id`),

  CONSTRAINT `fk_subscription_services`
    FOREIGN KEY (`service_id`)
    REFERENCES `services` (`service_id`)
    ON DELETE CASCADE ON UPDATE CASCADE
   ,
  CONSTRAINT `fk_subscription_customers1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `customers` (`customer_id`)
   ON DELETE CASCADE ON UPDATE CASCADE
    );

