-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 27, 2024 at 07:33 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shipsharp`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

CREATE TABLE `admins` (
  `admin_id` int(11) NOT NULL,
  `admin_fullname` varchar(200) NOT NULL,
  `admin_username` varchar(200) NOT NULL,
  `admin_password` varchar(200) NOT NULL,
  `admin_email` varchar(200) NOT NULL,
  `admin_createdOn` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`admin_id`, `admin_fullname`, `admin_username`, `admin_password`, `admin_email`, `admin_createdOn`) VALUES
(1, 'Ganidu Sathishka', 'admin', 'b6c45863875e34487ca3c155ed145efe12a74581e27befec5aa661b8ee8ca6dd', 'ganidu49@gmail.com', '2024-06-26 14:01:26');

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `id` int(11) NOT NULL,
  `customerName` varchar(200) NOT NULL,
  `customerEmail` varchar(200) NOT NULL,
  `customerUsername` varchar(200) NOT NULL,
  `customerPassword` varchar(200) NOT NULL,
  `registered_on` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`id`, `customerName`, `customerEmail`, `customerUsername`, `customerPassword`, `registered_on`) VALUES
(3, 'Ganidu Sathishka', 'ganidu49@gmail.com', 'customer', 'b6c45863875e34487ca3c155ed145efe12a74581e27befec5aa661b8ee8ca6dd', '2024-05-26 09:40:46');

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `emp_id` int(11) NOT NULL,
  `emp_email` varchar(200) NOT NULL,
  `emp_username` varchar(200) NOT NULL,
  `emp_password` varchar(200) NOT NULL,
  `emp_fullname` varchar(200) NOT NULL,
  `emp_addedOn` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`emp_id`, `emp_email`, `emp_username`, `emp_password`, `emp_fullname`, `emp_addedOn`) VALUES
(1, 'ganidu49@gmail.com', 'employee', '9d586dc0a48a2ed04839e0a69750893438e8d379e2fa45e94e82c5b3abb00daa', 'Ganidu Employee', '2024-06-16 17:25:08'),
(4, 'dihanhewage123@gmail.com', 'dihan', 'd0a59dd21955a860a4bb9fb1f8dc811612b59b1a185c4bfb285f1658cfac9cb4', 'Dihan Hewage', '2024-06-27 11:57:34'),
(5, 'kavinduavishka85@gmail.com', 'kavindu', 'afbc40f04b117b89c1d38f45e32e270ec389eeee0b63bbe9ced8aca419adbde9', 'Kavindu Ulwishewa', '2024-06-27 11:59:57');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `customer_username` varchar(50) DEFAULT NULL,
  `product_ID` int(3) NOT NULL,
  `product_name` varchar(100) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `status` int(2) NOT NULL DEFAULT 0,
  `created_on` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `customer_username`, `product_ID`, `product_name`, `quantity`, `status`, `created_on`) VALUES
(10, 'customer', 6, 'Engine Wheel', 2, 0, '2024-06-27 17:20:52');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `productName` varchar(255) DEFAULT NULL,
  `productPrice` decimal(10,2) DEFAULT NULL,
  `productStock` int(11) DEFAULT NULL,
  `added_on` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `productName`, `productPrice`, `productStock`, `added_on`) VALUES
(6, 'Engine Wheel', 2300.00, 998, '2024-05-26 05:26:28'),
(7, 'Chain ', 3100.00, 1000, '2024-05-26 05:26:28'),
(8, 'Gas Cut1', 5000.00, 1000, '2024-05-26 05:26:28');

-- --------------------------------------------------------

--
-- Table structure for table `service_requests`
--

CREATE TABLE `service_requests` (
  `req_id` int(11) NOT NULL,
  `req_customer` varchar(200) NOT NULL,
  `req_service` varchar(200) NOT NULL,
  `req_description` mediumtext NOT NULL,
  `req_status` int(11) NOT NULL DEFAULT 0,
  `allocated_employee` varchar(200) DEFAULT NULL,
  `req_createdOn` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `service_requests`
--

INSERT INTO `service_requests` (`req_id`, `req_customer`, `req_service`, `req_description`, `req_status`, `allocated_employee`, `req_createdOn`) VALUES
(7, 'customer', 'Repairs', 'Test Repair Needed !', 1, 'employee', '2024-06-26 13:06:15'),
(8, 'customer', 'Repairs 2', 'Test Repair Needed ! 2', 0, '5', '2024-06-26 13:06:15');

-- --------------------------------------------------------

--
-- Table structure for table `suppliers`
--

CREATE TABLE `suppliers` (
  `sup_id` int(11) NOT NULL,
  `sup_name` varchar(200) NOT NULL,
  `sup_companyName` varchar(200) NOT NULL,
  `sup_email` varchar(200) NOT NULL,
  `sup_addedOn` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `suppliers`
--

INSERT INTO `suppliers` (`sup_id`, `sup_name`, `sup_companyName`, `sup_email`, `sup_addedOn`) VALUES
(2, 'Dilith Udawatta', 'Dilith Stores', 'ganidu49@gmail.com', '2024-06-27 15:06:28');

-- --------------------------------------------------------

--
-- Table structure for table `supplier_items`
--

CREATE TABLE `supplier_items` (
  `id` int(11) NOT NULL,
  `sup_id` int(5) NOT NULL,
  `item_id` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `supplier_items`
--

INSERT INTO `supplier_items` (`id`, `sup_id`, `item_id`) VALUES
(1, 2, 6),
(4, 2, 7);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `user_fname` varchar(200) NOT NULL,
  `user_lname` varchar(200) NOT NULL,
  `user_contact` varchar(200) NOT NULL,
  `user_address` varchar(200) NOT NULL,
  `user_city` varchar(200) NOT NULL,
  `user_email` varchar(200) NOT NULL,
  `user_password` varchar(200) NOT NULL,
  `user_province` varchar(200) NOT NULL,
  `user_zip` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `user_fname`, `user_lname`, `user_contact`, `user_address`, `user_city`, `user_email`, `user_password`, `user_province`, `user_zip`) VALUES
(1, 'dihan', 'hewage', '1111', 'aaaa', 'aaaa', 'dihanhewage123@gmail.com', '$2y$10$yF338L0aDh45y5ybwffZMOj5eqzRkx2l/7WXdCUDF9CaYFkhkbei.', 'aaaa', 'aaaa');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`emp_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `service_requests`
--
ALTER TABLE `service_requests`
  ADD PRIMARY KEY (`req_id`);

--
-- Indexes for table `suppliers`
--
ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`sup_id`);

--
-- Indexes for table `supplier_items`
--
ALTER TABLE `supplier_items`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admins`
--
ALTER TABLE `admins`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `emp_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `service_requests`
--
ALTER TABLE `service_requests`
  MODIFY `req_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `suppliers`
--
ALTER TABLE `suppliers`
  MODIFY `sup_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `supplier_items`
--
ALTER TABLE `supplier_items`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
