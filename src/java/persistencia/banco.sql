-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema rodoviaria
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema rodoviaria
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `rodoviaria` DEFAULT CHARACTER SET utf8 ;
USE `rodoviaria` ;

-- -----------------------------------------------------
-- Table `rodoviaria`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rodoviaria`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(60) NOT NULL,
  `cpf` VARCHAR(15) NOT NULL,
  `rg` VARCHAR(15) NOT NULL,
  `dataNascimento` DATETIME NOT NULL,
  `email` VARCHAR(30) NULL,
  `telefone` VARCHAR(15) NOT NULL,
  `celular` VARCHAR(15) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rodoviaria`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rodoviaria`.`funcionario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(60) NOT NULL,
  `cargo` VARCHAR(30) NOT NULL,
  `cpf` VARCHAR(15) NOT NULL,
  `rg` VARCHAR(15) NOT NULL,
  `dataNascimento` DATETIME NOT NULL,
  `email` VARCHAR(30) NULL,
  `telefone` VARCHAR(15) NOT NULL,
  `celular` VARCHAR(15) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rodoviaria`.`venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rodoviaria`.`venda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `destino` VARCHAR(45) NULL,
  `origem` VARCHAR(45) NULL,
  `formaPagamento` VARCHAR(45) NULL,
  `funcionario_id` INT NOT NULL,
  `cliente_id` INT NOT NULL,
  `valor` VARCHAR(45) NULL,
  `dataCompra` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `fk_venda_funcionario_idx` (`funcionario_id` ASC),
  INDEX `fk_venda_cliente1_idx` (`cliente_id` ASC),
  CONSTRAINT `fk_venda_funcionario`
    FOREIGN KEY (`funcionario_id`)
    REFERENCES `rodoviaria`.`funcionario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_cliente1`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `rodoviaria`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
