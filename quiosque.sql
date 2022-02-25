-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 25-Fev-2022 às 02:17
-- Versão do servidor: 10.4.14-MariaDB
-- versão do PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `quiosque`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_cliente`
--

CREATE TABLE `tb_cliente` (
  `id` int(11) NOT NULL,
  `nome` varchar(60) NOT NULL,
  `endereco` varchar(60) NOT NULL,
  `nascimento` date NOT NULL,
  `numero` varchar(15) NOT NULL,
  `genero` varchar(30) NOT NULL,
  `email` varchar(60) NOT NULL,
  `produto` varchar(60) NOT NULL,
  `data_do_cadastro` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tb_cliente`
--

INSERT INTO `tb_cliente` (`id`, `nome`, `endereco`, `nascimento`, `numero`, `genero`, `email`, `produto`, `data_do_cadastro`) VALUES
(1, 'Ester', 'Rua Zamorra 353', '1997-04-02', '1199999999', 'feminino', 'ester.alice@senaisp.edu.br', 'Jogos', '2022-02-24 00:00:00'),
(2, 'Sara', 'Rua Jose Balo 99', '2003-06-05', '11888855522', 'feminino', 'sara.lv@live.com', 'Console', '2022-02-24 00:00:00'),
(3, 'Maick', 'Vargem Grande', '1998-11-26', '11111111111', 'masculino', 'maickwazowski@hotmail.com', 'Jogos', '2022-02-24 00:00:00'),
(4, 'Larissa', 'Viva Vida', '1950-08-06', '12222222222', 'outros', 'larissaveia@hotmail.com', 'Jogos Tabuleiro', '2022-02-24 00:00:00'),
(5, 'Arthur', 'Senai', '2008-05-28', '9789789877', 'masculino', 'arthursenai@hotmail.com', 'Celular', '2022-02-24 00:00:00'),
(6, 'teste', 'Rua Zamorra 353', '2022-02-25', '11888855522', 'feminino', 'ester.alice@senaisp.edu.br', 'teste', '2022-02-24 22:05:30');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tb_cliente`
--
ALTER TABLE `tb_cliente`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tb_cliente`
--
ALTER TABLE `tb_cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
