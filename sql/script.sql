--
-- Execute this script before before run the app 
-- Database: MySQL
-- 
-- Author: Loiane Groner
-- http://loianegroner.com (English)
-- http://loiane.com (Portuguese)
--

DROP SCHEMA IF EXISTS `blog_ibatis` ;
CREATE SCHEMA IF NOT EXISTS `blog_ibatis` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `blog_ibatis` ;

-- -----------------------------------------------------
-- Table `blog_ibatis`.`Blog`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blog_ibatis`.`Blog` ;

CREATE  TABLE IF NOT EXISTS `blog_ibatis`.`Blog` (
  `idBlog` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `url` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idBlog`) ,
  UNIQUE INDEX `idBlog_UNIQUE` (`idBlog` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `blog_ibatis`.`Author`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blog_ibatis`.`Author` ;

CREATE  TABLE IF NOT EXISTS `blog_ibatis`.`Author` (
  `idAuthor` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `email` VARCHAR(45) NOT NULL ,
  `idBlog` INT NOT NULL ,
  PRIMARY KEY (`idAuthor`) ,
  INDEX `fk_Author_Blog` (`idBlog` ASC) ,
  CONSTRAINT `fk_Author_Blog`
    FOREIGN KEY (`idBlog` )
    REFERENCES `blog_ibatis`.`Blog` (`idBlog` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
INSERT_METHOD = LAST
PACK_KEYS = 1;


-- -----------------------------------------------------
-- Table `blog_ibatis`.`Post`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blog_ibatis`.`Post` ;

CREATE  TABLE IF NOT EXISTS `blog_ibatis`.`Post` (
  `idPost` INT NOT NULL AUTO_INCREMENT ,
  `title` VARCHAR(45) NOT NULL ,
  `idBlog` INT NOT NULL ,
  PRIMARY KEY (`idPost`) ,
  INDEX `fk_Post_Blog1` (`idBlog` ASC) ,
  CONSTRAINT `fk_Post_Blog1`
    FOREIGN KEY (`idBlog` )
    REFERENCES `blog_ibatis`.`Blog` (`idBlog` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `blog_ibatis`.`Tag`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blog_ibatis`.`Tag` ;

CREATE  TABLE IF NOT EXISTS `blog_ibatis`.`Tag` (
  `idTag` INT NOT NULL AUTO_INCREMENT ,
  `value` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idTag`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `blog_ibatis`.`Post_Tag`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blog_ibatis`.`Post_Tag` ;

CREATE  TABLE IF NOT EXISTS `blog_ibatis`.`Post_Tag` (
  `id_Post_Tag` INT NOT NULL AUTO_INCREMENT ,
  `idPost` INT NOT NULL ,
  `idTag` INT NOT NULL ,
  PRIMARY KEY (`id_Post_Tag`) ,
  INDEX `fk_Post_Tag_Post1` (`idPost` ASC) ,
  INDEX `fk_Post_Tag_Tag1` (`idTag` ASC) ,
  CONSTRAINT `fk_Post_Tag_Post1`
    FOREIGN KEY (`idPost` )
    REFERENCES `blog_ibatis`.`Post` (`idPost` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Post_Tag_Tag1`
    FOREIGN KEY (`idTag` )
    REFERENCES `blog_ibatis`.`Tag` (`idTag` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

INSERT INTO `blog_ibatis`.`blog` (`idBlog`, `name`, `url`) VALUES ('1', 'Loiane Groner', 'http://loianegroner.com');

INSERT INTO `blog_ibatis`.`author` (`idAuthor`, `name`, `email`, `idBlog`) VALUES ('1', 'Loiane', 'loianeg@gmail.com', '1');

INSERT INTO `blog_ibatis`.`post` (`idPost`, `title`, `idBlog`) VALUES ('1', 'iBatis Introduction', '1');
INSERT INTO `blog_ibatis`.`post` (`idPost`, `title`, `idBlog`) VALUES ('2', 'IBatis XML Configuration', '1');
INSERT INTO `blog_ibatis`.`post` (`idPost`, `title`, `idBlog`) VALUES ('3', 'iBatis and Spring Integration', '1');

INSERT INTO `blog_ibatis`.`tag` (`idTag`, `value`) VALUES ('1', 'ibatis');
INSERT INTO `blog_ibatis`.`tag` (`idTag`, `value`) VALUES ('2', 'Spring');

INSERT INTO `blog_ibatis`.`post_tag` (`id_Post_Tag`, `idPost`, `idTag`) VALUES ('1', '1', '1');
INSERT INTO `blog_ibatis`.`post_tag` (`id_Post_Tag`, `idPost`, `idTag`) VALUES ('2', '2', '1');
INSERT INTO `blog_ibatis`.`post_tag` (`id_Post_Tag`, `idPost`, `idTag`) VALUES ('3', '3', '1');
INSERT INTO `blog_ibatis`.`post_tag` (`id_Post_Tag`, `idPost`, `idTag`) VALUES ('4', '3', '2');