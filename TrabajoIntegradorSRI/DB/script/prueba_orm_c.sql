-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-12-2023 a las 05:21:22
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `prueba_orm_c`
--
CREATE DATABASE IF NOT EXISTS `prueba_orm_c` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `prueba_orm_c`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `dni` int(11) NOT NULL,
  `estado` bit(1) NOT NULL,
  `id` int(11) NOT NULL,
  `cuit` varchar(11) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `razonSocial` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`dni`, `estado`, `id`, `cuit`, `apellido`, `nombre`, `razonSocial`) VALUES
(40555666, b'1', 1, '11405556661', 'Godoy', 'Lautaro', 'RS.srl'),
(50666777, b'1', 2, '22506667772', 'Brito', 'Tomas', 'Razon.srl'),
(60777888, b'1', 3, '33607778883', 'Cristaldo', 'Ruben', 'Social.srl');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_seq`
--

CREATE TABLE `cliente_seq` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) UNSIGNED NOT NULL,
  `cycle_option` tinyint(1) UNSIGNED NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB;

--
-- Volcado de datos para la tabla `cliente_seq`
--

INSERT INTO `cliente_seq` (`next_not_cached_value`, `minimum_value`, `maximum_value`, `start_value`, `increment`, `cache_size`, `cycle_option`, `cycle_count`) VALUES
(101, 1, 9223372036854775806, 1, 50, 0, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_servicio_incidente`
--

CREATE TABLE `cliente_servicio_incidente` (
  `cliente_id` int(11) DEFAULT NULL,
  `incidente_id` int(11) NOT NULL,
  `servicio_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente_servicio_incidente`
--

INSERT INTO `cliente_servicio_incidente` (`cliente_id`, `incidente_id`, `servicio_id`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidad`
--

CREATE TABLE `especialidad` (
  `id` int(11) NOT NULL,
  `nombre` enum('SAP','TANGO','SIP') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `especialidad`
--

INSERT INTO `especialidad` (`id`, `nombre`) VALUES
(1, 'SAP'),
(2, 'TANGO'),
(3, 'SIP');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidad_problema`
--

CREATE TABLE `especialidad_problema` (
  `especialidad_id` int(11) NOT NULL,
  `problema_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `especialidad_problema`
--

INSERT INTO `especialidad_problema` (`especialidad_id`, `problema_id`) VALUES
(1, 1),
(1, 2),
(2, 2),
(2, 3),
(3, 3),
(3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidad_seq`
--

CREATE TABLE `especialidad_seq` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) UNSIGNED NOT NULL,
  `cycle_option` tinyint(1) UNSIGNED NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB;

--
-- Volcado de datos para la tabla `especialidad_seq`
--

INSERT INTO `especialidad_seq` (`next_not_cached_value`, `minimum_value`, `maximum_value`, `start_value`, `increment`, `cache_size`, `cycle_option`, `cycle_count`) VALUES
(101, 1, 9223372036854775806, 1, 50, 0, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `incidente`
--

CREATE TABLE `incidente` (
  `id` int(11) NOT NULL,
  `ingreso` date NOT NULL,
  `problema_id` int(11) NOT NULL,
  `resolucion` date DEFAULT NULL,
  `tecnico_id` int(11) DEFAULT NULL,
  `tiempoEstimado` date DEFAULT NULL,
  `tiempoMaximo` date DEFAULT NULL,
  `descripcionProblema` varchar(100) NOT NULL,
  `indicacionesTecnicas` varchar(100) DEFAULT NULL,
  `dificultadTecnica` enum('SIMPLE','INTERMEDIO','COMPLEJO') DEFAULT NULL,
  `estado` enum('ABIERTO','ASIGNADO','EN_PROGRESO','RESUELTO','CERRADO') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `incidente`
--

INSERT INTO `incidente` (`id`, `ingreso`, `problema_id`, `resolucion`, `tecnico_id`, `tiempoEstimado`, `tiempoMaximo`, `descripcionProblema`, `indicacionesTecnicas`, `dificultadTecnica`, `estado`) VALUES
(1, '2023-10-15', 1, '2023-10-25', 1, '2023-10-25', NULL, 'Hace una semana que bla bla bla bla bla', 'Tenes que...', 'INTERMEDIO', 'RESUELTO'),
(2, '2023-10-20', 2, '2023-10-30', 2, '2023-10-30', NULL, 'Hola mi problema es que bla bla bla bla bla', 'Primero ...', 'INTERMEDIO', 'RESUELTO'),
(3, '2023-10-25', 3, '2023-11-05', 3, '2023-11-05', NULL, 'Me gustaria saber por que bla bla bla bla bla', 'Lo que tenes que hacer es...', 'INTERMEDIO', 'RESUELTO'),
(52, '2023-11-01', 3, '2023-11-12', 1, '2023-11-10', '2023-11-13', 'Me gustaria saber por que bla bla bla bla bla', 'Tenes que...', 'COMPLEJO', 'RESUELTO'),
(53, '2023-11-07', 2, '2023-11-10', 2, '2023-11-10', NULL, 'Me gustaria saber por que bla bla bla bla bla', 'Primero ...', 'INTERMEDIO', 'RESUELTO'),
(54, '2023-11-13', 1, '2023-11-14', 1, '2023-11-14', NULL, 'Me gustaria saber por que bla bla bla bla bla', 'Lo que tenes que hacer es...', 'INTERMEDIO', 'RESUELTO'),
(102, '2023-11-01', 3, NULL, 2, '2023-11-11', '2023-11-14', 'Me gustaria saber por que bla bla bla bla bla', 'Lo que tenes que hacer es...', 'COMPLEJO', 'ASIGNADO'),
(103, '2023-11-15', 3, '2023-11-18', 2, '2023-11-17', '2023-11-20', 'Me gustaria saber por que bla bla bla bla bla', 'Lo que tenes que hacer es...', 'COMPLEJO', 'RESUELTO'),
(104, '2023-11-19', 2, '2023-11-21', 2, '2023-11-21', NULL, 'Hola mi problema es que bla bla bla bla bla', 'Primero ...', 'INTERMEDIO', 'RESUELTO'),
(105, '2023-11-23', 2, NULL, 2, '2023-11-25', NULL, 'Hola mi problema es que bla bla bla bla bla', 'Primero ...', 'INTERMEDIO', 'EN_PROGRESO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `incidente_seq`
--

CREATE TABLE `incidente_seq` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) UNSIGNED NOT NULL,
  `cycle_option` tinyint(1) UNSIGNED NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB;

--
-- Volcado de datos para la tabla `incidente_seq`
--

INSERT INTO `incidente_seq` (`next_not_cached_value`, `minimum_value`, `maximum_value`, `start_value`, `increment`, `cache_size`, `cycle_option`, `cycle_count`) VALUES
(201, 1, 9223372036854775806, 1, 50, 0, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `problema`
--

CREATE TABLE `problema` (
  `id` int(11) NOT NULL,
  `tipo` enum('ACTUALIZACION','CONEXION','FUNCIONAMIENTO') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `problema`
--

INSERT INTO `problema` (`id`, `tipo`) VALUES
(2, 'ACTUALIZACION'),
(1, 'CONEXION'),
(3, 'FUNCIONAMIENTO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `problema_seq`
--

CREATE TABLE `problema_seq` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) UNSIGNED NOT NULL,
  `cycle_option` tinyint(1) UNSIGNED NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB;

--
-- Volcado de datos para la tabla `problema_seq`
--

INSERT INTO `problema_seq` (`next_not_cached_value`, `minimum_value`, `maximum_value`, `start_value`, `increment`, `cache_size`, `cycle_option`, `cycle_count`) VALUES
(101, 1, 9223372036854775806, 1, 50, 0, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE `servicio` (
  `estado` bit(1) NOT NULL,
  `id` int(11) NOT NULL,
  `app` enum('SAP','TANGO','SIP') NOT NULL,
  `so` enum('WINDOWS','MACOS','LINUX_UBUNTU') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `servicio`
--

INSERT INTO `servicio` (`estado`, `id`, `app`, `so`) VALUES
(b'1', 1, 'SAP', 'MACOS'),
(b'1', 2, 'TANGO', 'WINDOWS'),
(b'1', 3, 'SIP', 'LINUX_UBUNTU');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio_problema`
--

CREATE TABLE `servicio_problema` (
  `problema_id` int(11) NOT NULL,
  `servicio_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `servicio_problema`
--

INSERT INTO `servicio_problema` (`problema_id`, `servicio_id`) VALUES
(1, 1),
(2, 2),
(3, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio_seq`
--

CREATE TABLE `servicio_seq` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) UNSIGNED NOT NULL,
  `cycle_option` tinyint(1) UNSIGNED NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB;

--
-- Volcado de datos para la tabla `servicio_seq`
--

INSERT INTO `servicio_seq` (`next_not_cached_value`, `minimum_value`, `maximum_value`, `start_value`, `increment`, `cache_size`, `cycle_option`, `cycle_count`) VALUES
(101, 1, 9223372036854775806, 1, 50, 0, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tecnico`
--

CREATE TABLE `tecnico` (
  `dni` int(11) NOT NULL,
  `estado` bit(1) NOT NULL,
  `id` int(11) NOT NULL,
  `matricula` int(11) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tecnico`
--

INSERT INTO `tecnico` (`dni`, `estado`, `id`, `matricula`, `apellido`, `nombre`) VALUES
(10222333, b'1', 1, 12345, 'Medina', 'Florencia'),
(20333444, b'1', 2, 23456, 'Sosa', 'Guillermo'),
(30444555, b'1', 3, 34567, 'Fernandez', 'Bruno');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tecnico_especialidad`
--

CREATE TABLE `tecnico_especialidad` (
  `especialidad_id` int(11) NOT NULL,
  `tecnico_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tecnico_especialidad`
--

INSERT INTO `tecnico_especialidad` (`especialidad_id`, `tecnico_id`) VALUES
(1, 1),
(2, 2),
(3, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tecnico_seq`
--

CREATE TABLE `tecnico_seq` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) UNSIGNED NOT NULL,
  `cycle_option` tinyint(1) UNSIGNED NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB;

--
-- Volcado de datos para la tabla `tecnico_seq`
--

INSERT INTO `tecnico_seq` (`next_not_cached_value`, `minimum_value`, `maximum_value`, `start_value`, `increment`, `cache_size`, `cycle_option`, `cycle_count`) VALUES
(101, 1, 9223372036854775806, 1, 50, 0, 0, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_jlcg5nhnauli1hu4ojldsedaw` (`dni`),
  ADD UNIQUE KEY `UK_as537scmvws7al2fgsv91u4aj` (`cuit`);

--
-- Indices de la tabla `cliente_servicio_incidente`
--
ALTER TABLE `cliente_servicio_incidente`
  ADD PRIMARY KEY (`incidente_id`),
  ADD KEY `FK7u6kjw31u1tfiqm8wnnkdtdg1` (`cliente_id`),
  ADD KEY `FK77u4mnroqm4i6bob0gprpqyn3` (`servicio_id`);

--
-- Indices de la tabla `especialidad`
--
ALTER TABLE `especialidad`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `especialidad_problema`
--
ALTER TABLE `especialidad_problema`
  ADD KEY `FK6h0pkr4geaqbxcmnwm534yu0i` (`problema_id`),
  ADD KEY `FKdjh3mwi2e80ak4er7pr0tqv5v` (`especialidad_id`);

--
-- Indices de la tabla `incidente`
--
ALTER TABLE `incidente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK208tv0pfg8ku7cyutuk294b5l` (`problema_id`),
  ADD KEY `FK7aqbn77r6kjypgxw0d2nc20ts` (`tecnico_id`);

--
-- Indices de la tabla `problema`
--
ALTER TABLE `problema`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_d0wj71wf9pmqcylpnf3l81n8f` (`tipo`);

--
-- Indices de la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_rq9tr58450a09j4mpqmvkybyf` (`app`),
  ADD UNIQUE KEY `UK_qwqvl3vnjpk1kbbcpa7r649iv` (`so`);

--
-- Indices de la tabla `servicio_problema`
--
ALTER TABLE `servicio_problema`
  ADD KEY `FKtnumcnqyegkw3a20uq5p1t2yf` (`problema_id`),
  ADD KEY `FKhaphdir0dwje64willsnlr7mv` (`servicio_id`);

--
-- Indices de la tabla `tecnico`
--
ALTER TABLE `tecnico`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_b5jwp6rtd21n1394lhj69tqfi` (`dni`),
  ADD UNIQUE KEY `UK_3wiukdc67xubhm2e2j1tm88i2` (`matricula`);

--
-- Indices de la tabla `tecnico_especialidad`
--
ALTER TABLE `tecnico_especialidad`
  ADD KEY `FK2ycbvwetrpqhbb7li5rhps2p7` (`especialidad_id`),
  ADD KEY `FKqgxjpa4l0clohyx7vmlxc1ngu` (`tecnico_id`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente_servicio_incidente`
--
ALTER TABLE `cliente_servicio_incidente`
  ADD CONSTRAINT `FK77u4mnroqm4i6bob0gprpqyn3` FOREIGN KEY (`servicio_id`) REFERENCES `servicio` (`id`),
  ADD CONSTRAINT `FK7u6kjw31u1tfiqm8wnnkdtdg1` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `FKawqf3iw2sn1p9g3qfmyoyr5c0` FOREIGN KEY (`incidente_id`) REFERENCES `incidente` (`id`);

--
-- Filtros para la tabla `especialidad_problema`
--
ALTER TABLE `especialidad_problema`
  ADD CONSTRAINT `FK6h0pkr4geaqbxcmnwm534yu0i` FOREIGN KEY (`problema_id`) REFERENCES `problema` (`id`),
  ADD CONSTRAINT `FKdjh3mwi2e80ak4er7pr0tqv5v` FOREIGN KEY (`especialidad_id`) REFERENCES `especialidad` (`id`);

--
-- Filtros para la tabla `incidente`
--
ALTER TABLE `incidente`
  ADD CONSTRAINT `FK208tv0pfg8ku7cyutuk294b5l` FOREIGN KEY (`problema_id`) REFERENCES `problema` (`id`),
  ADD CONSTRAINT `FK7aqbn77r6kjypgxw0d2nc20ts` FOREIGN KEY (`tecnico_id`) REFERENCES `tecnico` (`id`);

--
-- Filtros para la tabla `servicio_problema`
--
ALTER TABLE `servicio_problema`
  ADD CONSTRAINT `FKhaphdir0dwje64willsnlr7mv` FOREIGN KEY (`servicio_id`) REFERENCES `servicio` (`id`),
  ADD CONSTRAINT `FKtnumcnqyegkw3a20uq5p1t2yf` FOREIGN KEY (`problema_id`) REFERENCES `problema` (`id`);

--
-- Filtros para la tabla `tecnico_especialidad`
--
ALTER TABLE `tecnico_especialidad`
  ADD CONSTRAINT `FK2ycbvwetrpqhbb7li5rhps2p7` FOREIGN KEY (`especialidad_id`) REFERENCES `especialidad` (`id`),
  ADD CONSTRAINT `FKqgxjpa4l0clohyx7vmlxc1ngu` FOREIGN KEY (`tecnico_id`) REFERENCES `tecnico` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
