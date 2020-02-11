-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 28-Jun-2019 às 12:11
-- Versão do servidor: 10.1.38-MariaDB
-- versão do PHP: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sge`
--

--
-- Estrutura da tabela `aluno`
--

CREATE TABLE `aluno` (
  `idAluno` int(11) NOT NULL,
  `nomeAluno` varchar(50) NOT NULL,
  `numMatricula` varchar(12) NOT NULL,
  `dataNascimento` varchar(10) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telefone` varchar(14) DEFAULT NULL,
  `celular` varchar(15) DEFAULT NULL,
  `cpf` char(11) NOT NULL,
  `rg` varchar(14) NOT NULL,
  `ufRg` char(2) NOT NULL,
  `orgaoExpeditorRg` varchar(30) NOT NULL,
  `dataExpedicaoRg` varchar(10) NOT NULL,
  `Endereco_idEndereco` int(11) NOT NULL,
  `Curso_idCurso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`idAluno`, `nomeAluno`, `numMatricula`, `dataNascimento`, `email`, `telefone`, `celular`, `cpf`, `rg`, `ufRg`, `orgaoExpeditorRg`, `dataExpedicaoRg`, `Endereco_idEndereco`, `Curso_idCurso`) VALUES
(2, 'FLÁVIA CORREIA', '20190000', '22/05/1978', 'fjc@email.com', NULL, '(73) 98899-5505', '08167944565', '2125050412', 'BA', 'SSP', '21/05/1999', 3, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno_cursou_disciplina`
--

CREATE TABLE `aluno_cursou_disciplina` (
  `Aluno_idAluno` int(11) NOT NULL,
  `Disciplina_idDisciplina` int(11) NOT NULL,
  `media` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno_tem_aulas_classe`
--

CREATE TABLE `aluno_tem_aulas_classe` (
  `Aluno_idAluno` int(11) NOT NULL,
  `Classe_idClasse` int(11) NOT NULL,
  `media` varchar(5) NOT NULL,
  `situaçao` varchar(18) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `classe`
--

CREATE TABLE `classe` (
  `idClasse` int(11) NOT NULL,
  `periodoLetivo` varchar(7) NOT NULL,
  `dia` varchar(50) NOT NULL,
  `hora` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `curso`
--

CREATE TABLE `curso` (
  `idCurso` int(11) NOT NULL,
  `nomeCurso` varchar(50) NOT NULL,
  `cargaHorariaTotal` varchar(7) NOT NULL,
  `tipo` varchar(14) NOT NULL,
  `quantidadeSemestres` varchar(3) NOT NULL,
  `tipoCurso` varchar(20) NOT NULL,
  `tipoGraduacao` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `curso`
--

INSERT INTO `curso` (`idCurso`, `nomeCurso`, `cargaHorariaTotal`, `tipo`, `quantidadeSemestres`, `tipoCurso`, `tipoGraduacao`) VALUES
(2, 'SISTEMAS DE INFORMAÇÃO', '2000', 'INTEGRAL', '8', 'GRADUAÇÃO', 'BACHARELADO'),
(3, 'PEDAGOGIA', '2000', 'NOTURNO', '8', 'GRADUAÇÃO', 'LICENCIATURA');

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplina`
--

CREATE TABLE `disciplina` (
  `idDisciplina` int(11) NOT NULL,
  `nomeDisciplina` varchar(50) NOT NULL,
  `areaDisciplina` varchar(45) NOT NULL,
  `semestre` varchar(2) NOT NULL,
  `cargaHoraria` varchar(5) NOT NULL,
  `optativa` tinyint(4) NOT NULL,
  `obrigatoria` tinyint(4) NOT NULL,
  `teorica` tinyint(4) NOT NULL,
  `estagio` tinyint(4) NOT NULL,
  `pratica` tinyint(4) NOT NULL,
  `preRequisito` tinyint(4) NOT NULL,
  `Curso_idCurso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `disciplina`
--

INSERT INTO `disciplina` (`idDisciplina`, `nomeDisciplina`, `areaDisciplina`, `semestre`, `cargaHoraria`, `optativa`, `obrigatoria`, `teorica`, `estagio`, `pratica`, `preRequisito`, `Curso_idCurso`) VALUES
(1, 'INTRODUÇÃO A ALGORITMOS E ESTRUTURA DE DADOS', 'LÓGICA E PROGRAMAÇÃO', '1', '75', 0, 1, 1, 0, 1, 1, 2),
(2, 'TEORIA GERAL DOS SISTEMAS', 'ADMINISTRAÇÃO', '4', '60', 0, 1, 1, 0, 0, 0, 2),
(3, 'EMPREENDEDORISMO', 'ADMINISTRAÇÃO', '8', '75', 0, 1, 1, 0, 0, 0, 2),
(4, 'BANCO DE DADOS I', 'LÓGICA', '4', '75', 0, 1, 1, 0, 1, 1, 2),
(5, 'PSICOLOGIA APLCADA A SISTEMAS DE INFORMAÇÃO', 'PSICOLOGIA', '2', '75', 0, 1, 1, 0, 0, 0, 2),
(6, 'ENGENHARIA DE SOFTWARE I', 'GERÊNCIAMENTO DE SOFTWARE', '4', '75', 0, 1, 1, 0, 1, 1, 2),
(8, 'ENGENHARIA DE SOFTWARE II', 'GERÊNCIAMENTO DE SOFTWARE', '5', '75', 0, 1, 1, 0, 1, 1, 2),
(9, 'INTRODUÇÃO À SOCIOLOGIA', 'CIÊNCIAS HUMANAS', '1', '60', 0, 1, 1, 0, 0, 1, 3),
(10, 'ENGENHARIA DESOFTWARE II', 'GERÊNCIAMENTO DE SOFTWARE', '5', '75', 0, 1, 1, 0, 1, 1, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplina_tem_classe`
--

CREATE TABLE `disciplina_tem_classe` (
  `Disciplina_idDisciplina` int(11) NOT NULL,
  `Classe_idClasse` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplina_tem_prerequisito`
--

CREATE TABLE `disciplina_tem_prerequisito` (
  `idDisciplina` int(11) NOT NULL,
  `idPreRequisito` int(11) NOT NULL,
  `nomePreRequisito` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `disciplina_tem_prerequisito`
--

INSERT INTO `disciplina_tem_prerequisito` (`idDisciplina`, `idPreRequisito`, `nomePreRequisito`) VALUES
(8, 6, 'ENGENHARIA DE SOFTWARE I'),
(10, 6, 'ENGENHARIA DE SOFTWARE I');

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE `endereco` (
  `idEndereco` int(11) NOT NULL,
  `cep` varchar(10) NOT NULL,
  `rua` varchar(30) NOT NULL,
  `numero` varchar(7) NOT NULL,
  `complemento` varchar(30) DEFAULT NULL,
  `bairro` varchar(30) NOT NULL,
  `cidade` varchar(30) NOT NULL,
  `uf` char(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`idEndereco`, `cep`, `rua`, `numero`, `complemento`, `bairro`, `cidade`, `uf`) VALUES
(1, '45.203-728', 'RUA MARCOS VIEIRA', '36', NULL, 'CAIXA DÁGUA', 'JEQUIÉ', 'BA'),
(3, '45.203-728', 'MARCOS VIEIRA', '36', NULL, 'CAIXA DÁGUA', 'JEQUIÉ', 'BA');

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor`
--

CREATE TABLE `professor` (
  `idProfessor` int(11) NOT NULL,
  `nomeProfessor` varchar(50) NOT NULL,
  `dataNascimento` varchar(10) NOT NULL,
  `numMatricula` varchar(12) NOT NULL,
  `areaAtuacao` varchar(30) NOT NULL,
  `cargaHoraria` varchar(10) NOT NULL,
  `telefone` varchar(14) DEFAULT NULL,
  `celular` varchar(15) DEFAULT NULL,
  `cpf` varchar(11) NOT NULL,
  `rg` varchar(14) NOT NULL,
  `ufRg` char(2) NOT NULL,
  `orgaoExpeditor` varchar(30) NOT NULL,
  `dataExpedicao` varchar(10) NOT NULL,
  `Endereco_idEndereco` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor_da_aulas_classe`
--

CREATE TABLE `professor_da_aulas_classe` (
  `Professor_idProfessor` int(11) NOT NULL,
  `Classe_idClasse` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`idAluno`),
  ADD KEY `fk_Aluno_Endereco_idx` (`Endereco_idEndereco`),
  ADD KEY `fk_Aluno_Curso1_idx` (`Curso_idCurso`);

--
-- Indexes for table `aluno_cursou_disciplina`
--
ALTER TABLE `aluno_cursou_disciplina`
  ADD PRIMARY KEY (`Aluno_idAluno`,`Disciplina_idDisciplina`),
  ADD KEY `fk_Aluno_has_Disciplina_Disciplina1_idx` (`Disciplina_idDisciplina`),
  ADD KEY `fk_Aluno_has_Disciplina_Aluno1_idx` (`Aluno_idAluno`);

--
-- Indexes for table `aluno_tem_aulas_classe`
--
ALTER TABLE `aluno_tem_aulas_classe`
  ADD PRIMARY KEY (`Aluno_idAluno`,`Classe_idClasse`),
  ADD KEY `fk_Aluno_has_Classe_Classe1_idx` (`Classe_idClasse`),
  ADD KEY `fk_Aluno_has_Classe_Aluno1_idx` (`Aluno_idAluno`);

--
-- Indexes for table `classe`
--
ALTER TABLE `classe`
  ADD PRIMARY KEY (`idClasse`);

--
-- Indexes for table `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`idCurso`);

--
-- Indexes for table `disciplina`
--
ALTER TABLE `disciplina`
  ADD PRIMARY KEY (`idDisciplina`),
  ADD KEY `fk_Disciplina_Curso1_idx` (`Curso_idCurso`);

--
-- Indexes for table `disciplina_tem_classe`
--
ALTER TABLE `disciplina_tem_classe`
  ADD PRIMARY KEY (`Disciplina_idDisciplina`,`Classe_idClasse`),
  ADD KEY `fk_Disciplina_has_Classe_Classe1_idx` (`Classe_idClasse`),
  ADD KEY `fk_Disciplina_has_Classe_Disciplina1_idx` (`Disciplina_idDisciplina`);

--
-- Indexes for table `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`idEndereco`);

--
-- Indexes for table `professor`
--
ALTER TABLE `professor`
  ADD PRIMARY KEY (`idProfessor`),
  ADD KEY `fk_Professor_Endereco1_idx` (`Endereco_idEndereco`);

--
-- Indexes for table `professor_da_aulas_classe`
--
ALTER TABLE `professor_da_aulas_classe`
  ADD PRIMARY KEY (`Professor_idProfessor`,`Classe_idClasse`),
  ADD KEY `fk_Professor_has_Classe_Classe1_idx` (`Classe_idClasse`),
  ADD KEY `fk_Professor_has_Classe_Professor1_idx` (`Professor_idProfessor`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `aluno`
--
ALTER TABLE `aluno`
  MODIFY `idAluno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `classe`
--
ALTER TABLE `classe`
  MODIFY `idClasse` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `curso`
--
ALTER TABLE `curso`
  MODIFY `idCurso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `disciplina`
--
ALTER TABLE `disciplina`
  MODIFY `idDisciplina` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `endereco`
--
ALTER TABLE `endereco`
  MODIFY `idEndereco` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `professor`
--
ALTER TABLE `professor`
  MODIFY `idProfessor` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `aluno`
--
ALTER TABLE `aluno`
  ADD CONSTRAINT `fk_Aluno_Curso1` FOREIGN KEY (`Curso_idCurso`) REFERENCES `curso` (`idCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Aluno_Endereco` FOREIGN KEY (`Endereco_idEndereco`) REFERENCES `endereco` (`idEndereco`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `aluno_cursou_disciplina`
--
ALTER TABLE `aluno_cursou_disciplina`
  ADD CONSTRAINT `fk_Aluno_has_Disciplina_Aluno1` FOREIGN KEY (`Aluno_idAluno`) REFERENCES `aluno` (`idAluno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Aluno_has_Disciplina_Disciplina1` FOREIGN KEY (`Disciplina_idDisciplina`) REFERENCES `disciplina` (`idDisciplina`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `aluno_tem_aulas_classe`
--
ALTER TABLE `aluno_tem_aulas_classe`
  ADD CONSTRAINT `fk_Aluno_has_Classe_Aluno1` FOREIGN KEY (`Aluno_idAluno`) REFERENCES `aluno` (`idAluno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Aluno_has_Classe_Classe1` FOREIGN KEY (`Classe_idClasse`) REFERENCES `classe` (`idClasse`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `disciplina`
--
ALTER TABLE `disciplina`
  ADD CONSTRAINT `fk_Disciplina_Curso1` FOREIGN KEY (`Curso_idCurso`) REFERENCES `curso` (`idCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `disciplina_tem_classe`
--
ALTER TABLE `disciplina_tem_classe`
  ADD CONSTRAINT `fk_Disciplina_has_Classe_Classe1` FOREIGN KEY (`Classe_idClasse`) REFERENCES `classe` (`idClasse`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Disciplina_has_Classe_Disciplina1` FOREIGN KEY (`Disciplina_idDisciplina`) REFERENCES `disciplina` (`idDisciplina`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `professor`
--
ALTER TABLE `professor`
  ADD CONSTRAINT `fk_Professor_Endereco1` FOREIGN KEY (`Endereco_idEndereco`) REFERENCES `endereco` (`idEndereco`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `professor_da_aulas_classe`
--
ALTER TABLE `professor_da_aulas_classe`
  ADD CONSTRAINT `fk_Professor_has_Classe_Classe1` FOREIGN KEY (`Classe_idClasse`) REFERENCES `classe` (`idClasse`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Professor_has_Classe_Professor1` FOREIGN KEY (`Professor_idProfessor`) REFERENCES `professor` (`idProfessor`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
