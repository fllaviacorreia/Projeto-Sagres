-- MySQL Script generated by MySQL Workbench
-- Fri Apr 26 13:00:12 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema sagres
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sagres
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sagres` DEFAULT CHARACTER SET utf8 ;
USE `sagres` ;

-- -----------------------------------------------------
-- Table `sagres`.`Endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagres`.`Endereco` (
  `idEndereco` INT NOT NULL AUTO_INCREMENT,
  `cep` VARCHAR(10) NOT NULL,
  `rua` VARCHAR(30) NOT NULL,
  `numero` VARCHAR(7) NOT NULL,
  `complemento` VARCHAR(30) NULL,
  `bairro` VARCHAR(30) NOT NULL,
  `cidade` VARCHAR(30) NOT NULL,
  `uf` CHAR(2) NOT NULL,
  `tipo` VARCHAR(9) NOT NULL,
  PRIMARY KEY (`idEndereco`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sagres`.`Curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagres`.`Curso` (
  `idCurso` INT NOT NULL AUTO_INCREMENT,
  `nomeCurso` VARCHAR(50) NOT NULL,
  `cargaHorariaTotal` VARCHAR(7) NOT NULL,
  `tipoCurso` VARCHAR(14) NOT NULL,
  `quantidadeSemestres` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`idCurso`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sagres`.`Aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagres`.`Aluno` (
  `idAluno` INT NOT NULL AUTO_INCREMENT,
  `nomeAluno` VARCHAR(50) NOT NULL,
  `numMatricula` VARCHAR(12) NOT NULL,
  `dataNascimento` VARCHAR(10) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(14) NULL,
  `celular` VARCHAR(15) NULL,
  `cpf` CHAR(11) NOT NULL,
  `rg` VARCHAR(14) NOT NULL,
  `ufRg` CHAR(2) NOT NULL,
  `orgaoExpeditorRg` VARCHAR(30) NOT NULL,
  `dataExpedicaoRg` VARCHAR(10) NOT NULL,
  `Endereco_idEndereco` INT NOT NULL,
  `Curso_idCurso` INT NOT NULL,
  PRIMARY KEY (`idAluno`),
  INDEX `fk_Aluno_Endereco_idx` (`Endereco_idEndereco` ASC) VISIBLE,
  INDEX `fk_Aluno_Curso1_idx` (`Curso_idCurso` ASC) VISIBLE,
  CONSTRAINT `fk_Aluno_Endereco`
    FOREIGN KEY (`Endereco_idEndereco`)
    REFERENCES `sagres`.`Endereco` (`idEndereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aluno_Curso1`
    FOREIGN KEY (`Curso_idCurso`)
    REFERENCES `sagres`.`Curso` (`idCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sagres`.`Professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagres`.`Professor` (
  `idProfessor` INT NOT NULL AUTO_INCREMENT,
  `nomeProfessor` VARCHAR(50) NOT NULL,
  `dataNascimento` VARCHAR(10) NOT NULL,
  `numMatricula` VARCHAR(12) NOT NULL,
  `areaAtuacao` VARCHAR(30) NOT NULL,
  `cargaHoraria` VARCHAR(10) NOT NULL,
  `telefone` VARCHAR(14) NULL,
  `celular` VARCHAR(15) NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `rg` VARCHAR(14) NOT NULL,
  `ufRg` CHAR(2) NOT NULL,
  `orgaoExpeditor` VARCHAR(30) NOT NULL,
  `dataExpedicao` VARCHAR(10) NOT NULL,
  `Endereco_idEndereco` INT NOT NULL,
  PRIMARY KEY (`idProfessor`),
  INDEX `fk_Professor_Endereco1_idx` (`Endereco_idEndereco` ASC) VISIBLE,
  CONSTRAINT `fk_Professor_Endereco1`
    FOREIGN KEY (`Endereco_idEndereco`)
    REFERENCES `sagres`.`Endereco` (`idEndereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sagres`.`Disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagres`.`Disciplina` (
  `idDisciplina` INT NOT NULL AUTO_INCREMENT,
  `nomeDisciplina` VARCHAR(50) NOT NULL,
  `areaDisciplina` VARCHAR(45) NOT NULL,
  `semestre` VARCHAR(2) NOT NULL,
  `cargaHoraria` VARCHAR(5) NOT NULL,
  `tipoDisciplina` VARCHAR(10) NOT NULL,
  `optativaObrigatoria` VARCHAR(12) NOT NULL,
  `teorica` TINYINT NOT NULL,
  `estagio` TINYINT NOT NULL,
  `pratica` TINYINT NOT NULL,
  `preRequisito` TINYINT NOT NULL,
  `Curso_idCurso` INT NOT NULL,
  PRIMARY KEY (`idDisciplina`),
  INDEX `fk_Disciplina_Curso1_idx` (`Curso_idCurso` ASC) VISIBLE,
  CONSTRAINT `fk_Disciplina_Curso1`
    FOREIGN KEY (`Curso_idCurso`)
    REFERENCES `sagres`.`Curso` (`idCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sagres`.`Classe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagres`.`Classe` (
  `idClasse` INT NOT NULL AUTO_INCREMENT,
  `periodoLetivo` VARCHAR(7) NOT NULL,
  `dia` VARCHAR(50) NOT NULL,
  `hora` VARCHAR(50) NULL,
  PRIMARY KEY (`idClasse`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sagres`.`Professor_da_aulas_Classe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagres`.`Professor_da_aulas_Classe` (
  `Professor_idProfessor` INT NOT NULL,
  `Classe_idClasse` INT NOT NULL,
  PRIMARY KEY (`Professor_idProfessor`, `Classe_idClasse`),
  INDEX `fk_Professor_has_Classe_Classe1_idx` (`Classe_idClasse` ASC) VISIBLE,
  INDEX `fk_Professor_has_Classe_Professor1_idx` (`Professor_idProfessor` ASC) VISIBLE,
  CONSTRAINT `fk_Professor_has_Classe_Professor1`
    FOREIGN KEY (`Professor_idProfessor`)
    REFERENCES `sagres`.`Professor` (`idProfessor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Professor_has_Classe_Classe1`
    FOREIGN KEY (`Classe_idClasse`)
    REFERENCES `sagres`.`Classe` (`idClasse`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sagres`.`Aluno_tem_aulas_Classe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagres`.`Aluno_tem_aulas_Classe` (
  `Aluno_idAluno` INT NOT NULL,
  `Classe_idClasse` INT NOT NULL,
  `media` VARCHAR(5) NOT NULL,
  `situaçao` VARCHAR(18) NOT NULL,
  PRIMARY KEY (`Aluno_idAluno`, `Classe_idClasse`),
  INDEX `fk_Aluno_has_Classe_Classe1_idx` (`Classe_idClasse` ASC) VISIBLE,
  INDEX `fk_Aluno_has_Classe_Aluno1_idx` (`Aluno_idAluno` ASC) VISIBLE,
  CONSTRAINT `fk_Aluno_has_Classe_Aluno1`
    FOREIGN KEY (`Aluno_idAluno`)
    REFERENCES `sagres`.`Aluno` (`idAluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aluno_has_Classe_Classe1`
    FOREIGN KEY (`Classe_idClasse`)
    REFERENCES `sagres`.`Classe` (`idClasse`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sagres`.`Disciplina_tem_Classe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagres`.`Disciplina_tem_Classe` (
  `Disciplina_idDisciplina` INT NOT NULL,
  `Classe_idClasse` INT NOT NULL,
  PRIMARY KEY (`Disciplina_idDisciplina`, `Classe_idClasse`),
  INDEX `fk_Disciplina_has_Classe_Classe1_idx` (`Classe_idClasse` ASC) VISIBLE,
  INDEX `fk_Disciplina_has_Classe_Disciplina1_idx` (`Disciplina_idDisciplina` ASC) VISIBLE,
  CONSTRAINT `fk_Disciplina_has_Classe_Disciplina1`
    FOREIGN KEY (`Disciplina_idDisciplina`)
    REFERENCES `sagres`.`Disciplina` (`idDisciplina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Disciplina_has_Classe_Classe1`
    FOREIGN KEY (`Classe_idClasse`)
    REFERENCES `sagres`.`Classe` (`idClasse`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sagres`.`Aluno_cursou_Disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagres`.`Aluno_cursou_Disciplina` (
  `Aluno_idAluno` INT NOT NULL,
  `Disciplina_idDisciplina` INT NOT NULL,
  PRIMARY KEY (`Aluno_idAluno`, `Disciplina_idDisciplina`),
  INDEX `fk_Aluno_has_Disciplina_Disciplina1_idx` (`Disciplina_idDisciplina` ASC) VISIBLE,
  INDEX `fk_Aluno_has_Disciplina_Aluno1_idx` (`Aluno_idAluno` ASC) VISIBLE,
  CONSTRAINT `fk_Aluno_has_Disciplina_Aluno1`
    FOREIGN KEY (`Aluno_idAluno`)
    REFERENCES `sagres`.`Aluno` (`idAluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aluno_has_Disciplina_Disciplina1`
    FOREIGN KEY (`Disciplina_idDisciplina`)
    REFERENCES `sagres`.`Disciplina` (`idDisciplina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
