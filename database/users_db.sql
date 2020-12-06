-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 22, 2019 at 03:22 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `users_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `address` varchar(150) NOT NULL,
  `age` int(3) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `password` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `email`, `phone`, `address`, `age`, `gender`, `name`, `password`) VALUES
(1, 'nur', '', '', 0, '', '', 'password');

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `mname` varchar(50) NOT NULL,
  `power` varchar(10) NOT NULL,
  `price` int(5) NOT NULL,
  `uid` int(10) NOT NULL,
  `quantity` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `delivered`
--

CREATE TABLE `delivered` (
  `uid` int(11) NOT NULL,
  `mname` varchar(100) NOT NULL,
  `power` varchar(10) NOT NULL,
  `Total price` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `delivered`
--

INSERT INTO `delivered` (`uid`, `mname`, `power`, `Total price`, `quantity`) VALUES
(1, 'Seclo', '20', 100, 20),
(1, 'Seclo', '5', 60, 10),
(1, 'Xeldrin', '20', 0, 10),
(1, 'alu', '50mg', 3250, 10),
(1, 'Seclo', '5', 60, 10),
(1, 'Xeldrin', '20', 0, 20),
(1, 'Napa', 'extra', 250, 50),
(16, 'alu', '50mg', 1625, 5),
(16, 'Seclo', '5', 30, 5);

-- --------------------------------------------------------

--
-- Table structure for table `medicine`
--

CREATE TABLE `medicine` (
  `mid` int(11) NOT NULL,
  `mname` varchar(50) NOT NULL,
  `power` varchar(20) NOT NULL,
  `company` varchar(20) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price(per tab)` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `medicine`
--

INSERT INTO `medicine` (`mid`, `mname`, `power`, `company`, `quantity`, `price(per tab)`) VALUES
(11, 'Xeldrin', '20', 'Square', 0, 0),
(12, 'alu', '50mg', 'orion', 375, 325),
(13, 'Seclo', '20', 'Orion', 50, 5),
(14, 'Seclo', '5', 'Orion', 85, 6),
(15, 'Napa', 'extra', 'square', 100, 5);

-- --------------------------------------------------------

--
-- Table structure for table `requested`
--

CREATE TABLE `requested` (
  `uid` int(11) NOT NULL,
  `mname` varchar(50) NOT NULL,
  `power` varchar(10) NOT NULL,
  `total price` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `requ_medi`
--

CREATE TABLE `requ_medi` (
  `mname` varchar(50) NOT NULL,
  `power` varchar(10) NOT NULL,
  `company` varchar(50) DEFAULT NULL,
  `quantity` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `address` varchar(150) NOT NULL,
  `age` int(3) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `sq` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `phone`, `address`, `age`, `gender`, `name`, `password`, `sq`) VALUES
(1, 'nursm86@gmail.com', '01622114901', 'Dhalpur, Jatrabari, Dhaka -1204', 21, 'Male', 'Md.Nur Islam', 'password', 'Myself'),
(5, 'lucifersm786@gmail.com', '01776703468', 'Dhalpur, Jatrabari', 21, 'Male', 'Lucifer SM', 'password', 'Md.Nur Islam'),
(6, 'marzajaJenia@gmail.com', '01749433808', 'Airport, Uttara', 20, 'Female', 'Marzana Jenia', 'password', 'My sister'),
(7, 'farzanaakter@gmail.com', '01746371273', 'Mirpur -10', 20, 'Female', 'Farzana Akter', 'password', 'Marzana'),
(8, 'sajonybolod@gmail.com', '01782211908', 'Bashundhara,Dhaka', 21, 'Male', 'Shaheen alam Jony', 'amibolod', 'myself'),
(15, 'habiburrahman@gmail.com', '01564654635', 'sdf', 21, 'Male', 'Habibur Rahman', '12345678', 'hagu'),
(16, 'ahsan@gmail.com', '01684717711', 'Shamibagh, Motijheel', 23, 'Male', 'Ahsan', '12345678', 'Emon');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `medicine`
--
ALTER TABLE `medicine`
  ADD PRIMARY KEY (`mid`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `medicine`
--
ALTER TABLE `medicine`
  MODIFY `mid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
