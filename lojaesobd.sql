-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema lojaeso
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema lojaeso
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lojaeso` DEFAULT CHARACTER SET utf8 ;
USE `lojaeso` ;

-- -----------------------------------------------------
-- Table `lojaeso`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lojaeso`.`clientes` (
  `idclientes` INT NOT NULL,
  `clientesnome` VARCHAR(45) NOT NULL,
  `clientestel` INT(11) NOT NULL,
  `clientesemail` VARCHAR(45) NOT NULL,
  `clientescpf` INT(11) NOT NULL,
  PRIMARY KEY (`idclientes`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lojaeso`.`produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lojaeso`.`produtos` (
  `idprodutos` INT NOT NULL,
  `produtosqtd` INT(4) NULL,
  `produtosdsc` VARCHAR(45) NOT NULL,
  `clientes_idclientes` INT NOT NULL,
  `produtosnome` VARCHAR(45) NULL,
  PRIMARY KEY (`idprodutos`, `clientes_idclientes`),
  INDEX `fk_produtos_clientes_idx` (`clientes_idclientes` ASC),
  CONSTRAINT `fk_produtos_clientes`
    FOREIGN KEY (`clientes_idclientes`)
    REFERENCES `lojaeso`.`clientes` (`idclientes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
