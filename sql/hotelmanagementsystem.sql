




--
-- Database: `hotelmanagementsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` varchar(25) DEFAULT NULL,
  `idno` varchar(25) DEFAULT NULL,
  `name` varchar(25) DEFAULT NULL,
  `gender` varchar(25) DEFAULT NULL,
  `country` varchar(25) DEFAULT NULL,
  `roomno` varchar(25) DEFAULT NULL,
  `checkintime` varchar(50) DEFAULT NULL,
  `deposit` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `idno`, `name`, `gender`, `country`, `roomno`, `checkintime`, `deposit`) VALUES
('Aadhar Card', '72024', 'bhuf', 'Female', 'Us', '102', 'Tue May 07 16:29:36 IST 2024', '780'),
('Driving Licence', '57859', 'vgud', 'Female', 'Inida', '103', 'Tue May 07 16:30:20 IST 2024', '345'),
('Passport', '729462', 'visya', 'Male', 'japan', '104', 'Tue May 07 16:31:37 IST 2024', '300'),
('Driving Licence', 'Drtyq3834', 'fblaehr', 'Female', 'eei[ei', '105', 'Tue May 07 16:32:31 IST 2024', '899');

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `department` varchar(30) DEFAULT NULL,
  `budget` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`department`, `budget`) VALUES
('Front Office', '500000'),
('HouseKeeping', '40000'),
('Food and Beverages', '30000'),
('Security', '35000');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `name` varchar(20) DEFAULT NULL,
  `age` varchar(20) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `job` varchar(25) DEFAULT NULL,
  `salary` varchar(15) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `aadhar` varchar(13) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`name`, `age`, `gender`, `job`, `salary`, `phone`, `email`, `aadhar`) VALUES
('Vasudha', '20', 'Female', 'Front Desk Clerk', '50000', '987654321', 'vasurp@gmail.com', '764804735753'),
('Ashwini', '23', 'Female', 'Chefs', '30000', '876789654', 'ash@gmail.com', '4678392937462'),
('Vishwajeet', '21', 'Male', 'Manager', '90000', '9739169235', 'vishwajeettpo@gmail.com', '987654321098');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(25) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('admin', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE `rooms` (
  `roomno` varchar(10) DEFAULT NULL,
  `available` varchar(20) DEFAULT NULL,
  `clean` varchar(20) DEFAULT NULL,
  `price` varchar(20) DEFAULT NULL,
  `bedtype` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`roomno`, `available`, `clean`, `price`, `bedtype`) VALUES
('101', 'Available', 'Dirty', '2500', 'Single Bed'),
('102', 'Booked', 'Cleaned', '2500', 'Single Bed'),
('103', 'Booked', 'Cleaned', '3500', 'Double Bed'),
('104', 'Booked', 'Cleaned', '3000', 'Double Bed'),
('105', 'available', 'Cleaned', '3200', 'Single Bed'),
('109', 'Available', 'Cleaned', '2500', 'Single Bed');
COMMIT;


