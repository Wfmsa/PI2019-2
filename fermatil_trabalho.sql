-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 27-Out-2019 às 11:38
-- Versão do servidor: 10.1.17-MariaDB
-- versão do PHP: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `fermatil_trabalho`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `compra`
--

CREATE TABLE `compra` (
  `idcompra` int(10) NOT NULL,
  `data` date NOT NULL,
  `dia_da_semana` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `compra`
--

INSERT INTO `compra` (`idcompra`, `data`, `dia_da_semana`) VALUES
(12, '2012-12-12', 'seg'),
(13, '2012-12-13', 'ter'),
(14, '2012-12-14', 'qua'),
(15, '2012-12-15', 'qui'),
(16, '2012-12-16', 'sex'),
(17, '2012-12-17', 's?b'),
(18, '2012-12-18', 'dom'),
(19, '2012-12-19', 'seg'),
(20, '2012-12-20', 'ter'),
(21, '2012-12-21', 'qua'),
(22, '2012-12-22', 'qui'),
(23, '2012-12-23', 'sex'),
(24, '2012-12-24', 's?b'),
(25, '2012-12-25', 'dom'),
(26, '2012-12-26', 'seg'),
(27, '2012-12-27', 'ter'),
(28, '2012-12-28', 'qua'),
(29, '2012-12-29', 'qui'),
(30, '2012-12-30', 'sex'),
(31, '2012-12-31', 's?b');

-- --------------------------------------------------------

--
-- Estrutura da tabela `itens`
--

CREATE TABLE `itens` (
  `idcompra` int(10) NOT NULL,
  `idproduto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `itens`
--

INSERT INTO `itens` (`idcompra`, `idproduto`) VALUES
(12, 1),
(12, 2),
(12, 12),
(13, 1),
(13, 2),
(13, 13),
(14, 1),
(14, 2),
(14, 14),
(15, 1),
(15, 2),
(15, 15),
(16, 1),
(16, 2),
(16, 16),
(17, 1),
(17, 2),
(17, 17),
(18, 1),
(18, 2),
(18, 18),
(19, 1),
(19, 2),
(19, 19),
(20, 1),
(20, 2),
(20, 20),
(21, 1),
(21, 2),
(21, 21),
(22, 1),
(22, 2),
(22, 22),
(23, 1),
(23, 2),
(23, 23),
(24, 1),
(24, 2),
(24, 24),
(25, 1),
(25, 2),
(25, 25),
(26, 1),
(26, 2),
(26, 26),
(27, 1),
(27, 2),
(27, 27),
(28, 1),
(28, 2),
(28, 28),
(29, 1),
(29, 2),
(29, 29),
(30, 1),
(30, 2),
(30, 30),
(31, 1),
(31, 2),
(31, 31);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `idproduto` int(11) NOT NULL,
  `descproduto` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`idproduto`, `descproduto`) VALUES
(1, 'Arroz'),
(2, 'Feijão'),
(3, 'Batata'),
(4, 'Monster'),
(5, 'Cenoura'),
(6, 'Cerveja'),
(7, 'Chocolate'),
(8, 'Banana'),
(9, 'Laranja'),
(10, 'Alface'),
(11, 'Cebola'),
(12, 'Biscoito'),
(13, 'leite'),
(14, 'Doritos'),
(15, 'Ketchup'),
(16, 'Mostarda'),
(17, 'Sorvete'),
(18, 'Beterraba'),
(19, 'Queijo'),
(20, 'Picanha');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`idproduto`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
