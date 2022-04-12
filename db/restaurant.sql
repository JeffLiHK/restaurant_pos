/*
 Navicat Premium Data Transfer

 Source Server         : 1
 Source Server Type    : MySQL
 Source Server Version : 50537
 Source Host           : localhost:3306
 Source Schema         : restaurant

 Target Server Type    : MySQL
 Target Server Version : 50537
 File Encoding         : 65001

 Date: 21/10/2019 23:17:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
-- ----------------------------
-- Table structure for r_category
-- ----------------------------
DROP TABLE IF EXISTS `r_category`;
CREATE TABLE `r_category`  (
  `category_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'category_id',
  `category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'category_name',
  `del` int(2) NOT NULL DEFAULT 0 COMMENT 'delete',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of r_category
-- ----------------------------
INSERT INTO `r_category` VALUES (1, 'Food', 0);
INSERT INTO `r_category` VALUES (2, 'Drink', 0);
INSERT INTO `r_category` VALUES (3, 'Salad', 0);
INSERT INTO `r_category` VALUES (4, 'Dessert', 0);
INSERT INTO `r_category` VALUES (5, 'Set', 0);

-- ----------------------------
-- Table structure for r_desk
-- ----------------------------
DROP TABLE IF EXISTS `r_desk`;
CREATE TABLE `r_desk`  (
  `desk_id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'desk_id',
  `desk_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'desk_code',
  `people_count` int(6) NULL DEFAULT NULL COMMENT 'cus_number',
  `idle_status` int(2) NULL DEFAULT 0 COMMENT 'desk_status(0 No Customer，1 In Use，2 Wait For Clean)',
  `create_time` datetime NULL DEFAULT NULL COMMENT 'create_time',
  `modify_time` datetime NULL DEFAULT NULL COMMENT 'modify_time',
  `del` int(2) NULL DEFAULT 0 COMMENT 'delete',
  PRIMARY KEY (`desk_id`) USING BTREE,
  UNIQUE INDEX `desk_code`(`desk_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of r_desk
-- ----------------------------
INSERT INTO `r_desk` VALUES (1, '1', 8, 0, '2018-10-22 21:14:22', '2018-11-27 15:53:59', 0);
INSERT INTO `r_desk` VALUES (2, '2', 10, 1, '2018-10-22 22:11:56', '2018-10-22 22:23:02', 0);
INSERT INTO `r_desk` VALUES (3, '3', 10, 0, '2018-10-22 22:17:14', '2018-10-22 22:21:18', 0);
INSERT INTO `r_desk` VALUES (4, '4', 4, 0, '2018-10-22 22:21:11', '2018-11-27 17:19:22', 0);
INSERT INTO `r_desk` VALUES (5, '5', 10, 0, '2018-10-22 22:21:34', '2018-10-22 22:21:40', 0);
INSERT INTO `r_desk` VALUES (6, '6', 6, 0, '2018-10-22 22:21:50', '2018-11-27 17:19:31', 0);
INSERT INTO `r_desk` VALUES (7, '7', 12, 0, '2018-10-22 22:21:56', '2018-11-27 17:19:25', 0);
INSERT INTO `r_desk` VALUES (8, '8', 4, 1, '2018-10-22 22:22:04', '2018-11-27 15:54:06', 0);
INSERT INTO `r_desk` VALUES (9, '9', 8, 0, '2018-10-22 22:22:21', '2018-10-22 22:22:24', 0);
INSERT INTO `r_desk` VALUES (10, '10', 4, 0, '2018-10-22 22:22:36', '2018-11-27 17:19:28', 0);
INSERT INTO `r_desk` VALUES (11, '11', 6, 2, '2018-10-22 22:22:50', NULL, 0);
INSERT INTO `r_desk` VALUES (12, '12', 10, 0, '2018-10-24 18:53:41', '2018-11-27 17:19:35', 0);
INSERT INTO `r_desk` VALUES (13, '13', 4, 0, '2018-10-24 18:53:48', NULL, 0);
INSERT INTO `r_desk` VALUES (14, '14', 6, 2, '2018-10-24 18:53:55', NULL, 0);
INSERT INTO `r_desk` VALUES (15, '15', 4, 0, '2018-10-24 18:54:04', NULL, 0);
INSERT INTO `r_desk` VALUES (16, '16', 8, 0, '2018-10-24 18:54:30', NULL, 0);
INSERT INTO `r_desk` VALUES (17, '17', 12, 0, '2018-10-24 18:55:55', '2018-11-27 17:16:38', 0);
INSERT INTO `r_desk` VALUES (18, '18', 4, 0, '2018-10-24 18:56:01', NULL, 0);
INSERT INTO `r_desk` VALUES (19, '19', 10, 0, '2018-10-24 18:56:08', NULL, 0);
INSERT INTO `r_desk` VALUES (20, '20', 4, 0, '2018-10-24 18:56:17', NULL, 0);
INSERT INTO `r_desk` VALUES (21, '21', 4, 0, '2018-10-24 18:56:28', '2018-11-27 15:54:23', 0);
INSERT INTO `r_desk` VALUES (22, '22', 10, 2, '2018-10-24 20:12:52', NULL, 0);
INSERT INTO `r_desk` VALUES (23, '23', 4, 0, '2018-10-24 20:13:18', NULL, 0);
INSERT INTO `r_desk` VALUES (24, '24', 6, 0, '2018-10-24 20:13:29', NULL, 0);
INSERT INTO `r_desk` VALUES (25, '25', 8, 0, '2018-10-24 20:13:34', NULL, 0);
INSERT INTO `r_desk` VALUES (26, '26', 4, 0, '2018-10-24 20:13:40', '2018-10-24 20:14:14', 0);
INSERT INTO `r_desk` VALUES (27, '27', 10, 0, '2018-10-24 20:13:47', NULL, 0);
INSERT INTO `r_desk` VALUES (28, '28', 8, 0, '2018-10-24 20:14:00', '2018-11-27 15:54:27', 0);
INSERT INTO `r_desk` VALUES (29, '29', 4, 0, '2018-10-24 20:14:10', NULL, 0);
INSERT INTO `r_desk` VALUES (30, '30', 6, 0, '2018-10-24 20:14:26', NULL, 0);
INSERT INTO `r_desk` VALUES (31, '31', 6, 0, '2018-10-24 20:14:37', NULL, 0);
INSERT INTO `r_desk` VALUES (32, '32', 8, 0, '2018-11-01 16:26:13', NULL, 0);

-- ----------------------------
-- Table structure for r_goods
-- ----------------------------
DROP TABLE IF EXISTS `r_goods`;
CREATE TABLE `r_goods`  (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'goods_id',
  `goods_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'goods_name',
  `category_id` int(11) NOT NULL COMMENT 'category_id',
  `img_small_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'img_small_url',
  `img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'img_url',
  `img_circle_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'img_circle_url',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'description',
  `cost` decimal(20, 2) NULL DEFAULT NULL COMMENT 'cost',
  `price` decimal(20, 2) NULL DEFAULT NULL COMMENT 'price',
  `discount` decimal(20, 2) NULL DEFAULT 1.00 COMMENT 'discount',
  `store_count` bigint(20) NULL DEFAULT 0 COMMENT 'store_count',
  `sold_count` bigint(20) NULL DEFAULT 0 COMMENT 'sold_count',
  `type_state` int(2) NULL DEFAULT 1 COMMENT 'type_state(1normal，2new，3hot)',
  `sold_state` int(2) NULL DEFAULT 0 COMMENT 'sold_state(0OnSell,1SellOut)',
  `putaway_status` int(2) NULL DEFAULT 0 COMMENT 'good_status(0OffSale，1OnSale)',
  `create_time` datetime NULL DEFAULT NULL COMMENT 'create_time',
  `modify_time` datetime NULL DEFAULT NULL COMMENT 'modify_time',
  `del` int(2) NULL DEFAULT 0 COMMENT 'delete',
  PRIMARY KEY (`goods_id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE,
  CONSTRAINT `r_goods_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `r_category` (`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 65 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of r_goods
-- ----------------------------

INSERT INTO `r_goods` (`goods_id`, `goods_name`, `category_id`, `img_small_url`, `img_url`, `img_circle_url`, `description`, `cost`, `price`, `discount`, `store_count`, `sold_count`, `type_state`, `sold_state`, `putaway_status`, `create_time`, `modify_time`, `del`) VALUES (3, 'French Fries', 1, NULL, '/image/frenchfries.jpeg', '', 'French Fries', 23.00, 88.00, 1.00, 3, 16, 1, 0, 1, '2022-02-19 16:55:13', '2022-02-21 21:19:47', 0);
INSERT INTO `r_goods` (`goods_id`, `goods_name`, `category_id`, `img_small_url`, `img_url`, `img_circle_url`, `description`, `cost`, `price`, `discount`, `store_count`, `sold_count`, `type_state`, `sold_state`, `putaway_status`, `create_time`, `modify_time`, `del`) VALUES (4, 'Fried Squid Rings', 1, NULL, '/image/FriedSquidRings.jpg', '', 'Fried Squid Rings', 20.00, 68.00, 1.00, 0, 20, 2, 1, 0, '2021-09-29 14:26:19', '2021-11-30 16:41:12', 0);
INSERT INTO `r_goods` (`goods_id`, `goods_name`, `category_id`, `img_small_url`, `img_url`, `img_circle_url`, `description`, `cost`, `price`, `discount`, `store_count`, `sold_count`, `type_state`, `sold_state`, `putaway_status`, `create_time`, `modify_time`, `del`) VALUES (5, 'Roast Pork Knuckle', 1, NULL, '/image/RoastPorkKnuckle.jpeg', '', 'Roast Pork Knuckle', 55.00, 148.00, 1.00, 13, 18, 1, 0, 1, '2021-10-19 13:53:07', '2021-10-30 21:11:15', 0);
INSERT INTO `r_goods` (`goods_id`, `goods_name`, `category_id`, `img_small_url`, `img_url`, `img_circle_url`, `description`, `cost`, `price`, `discount`, `store_count`, `sold_count`, `type_state`, `sold_state`, `putaway_status`, `create_time`, `modify_time`, `del`) VALUES (6, 'Chicken Wings with Buffalo', 1, NULL, '/image/ChickenWingswithBuffalo.jpeg', NULL, 'Chicken Wings with Buffalo', 40.00, 68.00, 1.00, 23, 5, 1, 0, 1, '2021-10-19 14:11:54', '2021-10-30 21:11:03', 0);
INSERT INTO `r_goods` (`goods_id`, `goods_name`, `category_id`, `img_small_url`, `img_url`, `img_circle_url`, `description`, `cost`, `price`, `discount`, `store_count`, `sold_count`, `type_state`, `sold_state`, `putaway_status`, `create_time`, `modify_time`, `del`) VALUES (7, 'Risotto', 1, NULL, '/image/a1945009-194b-4e21-9f84-042f0e82fc51.jpeg', '', 'Risotto', 17.00, 58.00, 1.00, 59, 41, 3, 0, 1, '2021-10-19 14:15:09', '2022-04-06 12:37:33', 0);
INSERT INTO `r_goods` (`goods_id`, `goods_name`, `category_id`, `img_small_url`, `img_url`, `img_circle_url`, `description`, `cost`, `price`, `discount`, `store_count`, `sold_count`, `type_state`, `sold_state`, `putaway_status`, `create_time`, `modify_time`, `del`) VALUES (8, 'Steak Burgers', 1, NULL, '/image/SteakBurgers.jpeg', '', 'Steak Burgers', 45.00, 88.80, 1.00, 20, 14, 1, 0, 1, '2021-10-19 14:16:16', '2021-11-01 10:47:01', 0);
INSERT INTO `r_goods` (`goods_id`, `goods_name`, `category_id`, `img_small_url`, `img_url`, `img_circle_url`, `description`, `cost`, `price`, `discount`, `store_count`, `sold_count`, `type_state`, `sold_state`, `putaway_status`, `create_time`, `modify_time`, `del`) VALUES (9, 'Barbeque Chicken Grilled Pizza', 1, NULL, '/image/BarbequeChickenGrilledPizza.jpeg', '', 'Barbeque Chicken Grilled Pizza', 78.00, 148.80, 1.00, 17, 11, 1, 0, 1, '2021-10-19 14:32:57', '2021-11-20 09:54:36', 0);
INSERT INTO `r_goods` (`goods_id`, `goods_name`, `category_id`, `img_small_url`, `img_url`, `img_circle_url`, `description`, `cost`, `price`, `discount`, `store_count`, `sold_count`, `type_state`, `sold_state`, `putaway_status`, `create_time`, `modify_time`, `del`) VALUES (10, 'Roasted Chicken', 1, NULL, '/image/RoastedChicken.jpeg', '', 'Roasted Chicken', 123.00, 208.00, 1.00, 8, 25, 1, 0, 1, '2021-10-21 23:35:03', '2022-04-12 21:49:33', 0);
INSERT INTO `r_goods` (`goods_id`, `goods_name`, `category_id`, `img_small_url`, `img_url`, `img_circle_url`, `description`, `cost`, `price`, `discount`, `store_count`, `sold_count`, `type_state`, `sold_state`, `putaway_status`, `create_time`, `modify_time`, `del`) VALUES (11, 'Creamy Garlic Tomato Shrimp Pasta', 1, NULL, '/image/CreamyGarlicTomatoShrimpPasta.jpeg', '', 'Creamy Garlic Tomato Shrimp Pasta', 17.90, 108.00, 1.00, 12, 9, 1, 0, 1, '2021-10-21 23:40:10', '2021-10-30 10:32:21', 0);
INSERT INTO `r_goods` (`goods_id`, `goods_name`, `category_id`, `img_small_url`, `img_url`, `img_circle_url`, `description`, `cost`, `price`, `discount`, `store_count`, `sold_count`, `type_state`, `sold_state`, `putaway_status`, `create_time`, `modify_time`, `del`) VALUES (12, 'Honey Garlic Meatballs', 1, NULL, '/image/HoneyGarlicMeatballs.jpeg', NULL, 'Honey Garlic Meatballs', 28.00, 68.00, 1.00, 70, 18, 2, 0, 1, '2021-10-30 10:29:51', '2021-11-11 17:00:07', 0);
INSERT INTO `r_goods` (`goods_id`, `goods_name`, `category_id`, `img_small_url`, `img_url`, `img_circle_url`, `description`, `cost`, `price`, `discount`, `store_count`, `sold_count`, `type_state`, `sold_state`, `putaway_status`, `create_time`, `modify_time`, `del`) VALUES (13, 'Americano', 2, NULL, '/image/Americano.jpeg', NULL, 'Americano', 6.00, 18.00, 1.00, 10, 10, 1, 0, 1, '2021-10-30 10:34:47', NULL, 0);
INSERT INTO `r_goods` (`goods_id`, `goods_name`, `category_id`, `img_small_url`, `img_url`, `img_circle_url`, `description`, `cost`, `price`, `discount`, `store_count`, `sold_count`, `type_state`, `sold_state`, `putaway_status`, `create_time`, `modify_time`, `del`) VALUES (14, 'Flat White', 2, NULL, '/image/FlatWhite.jpeg', NULL, 'Flat White', 7.00, 18.00, 1.00, 10, 20, 1, 0, 1, '2021-10-30 10:35:36', NULL, 0);
INSERT INTO `r_goods` (`goods_id`, `goods_name`, `category_id`, `img_small_url`, `img_url`, `img_circle_url`, `description`, `cost`, `price`, `discount`, `store_count`, `sold_count`, `type_state`, `sold_state`, `putaway_status`, `create_time`, `modify_time`, `del`) VALUES (15, 'Cappuccino', 2, NULL, '/image/Cappuccino.jpeg', NULL, 'Cappuccino', 6.50, 18.00, 1.00, 28, 12, 1, 0, 1, '2021-10-30 10:36:25', NULL, 0);
INSERT INTO `r_goods` (`goods_id`, `goods_name`, `category_id`, `img_small_url`, `img_url`, `img_circle_url`, `description`, `cost`, `price`, `discount`, `store_count`, `sold_count`, `type_state`, `sold_state`, `putaway_status`, `create_time`, `modify_time`, `del`) VALUES (16, 'Chocolate Latte', 2, NULL, '/image/ChocolateLatte.jpeg', NULL, 'Chocolate Latte', 8.00, 25.00, 1.00, 10, 10, 1, 0, 1, '2021-10-30 10:38:02', '2021-10-30 23:42:50', 0);
INSERT INTO `r_goods` (`goods_id`, `goods_name`, `category_id`, `img_small_url`, `img_url`, `img_circle_url`, `description`, `cost`, `price`, `discount`, `store_count`, `sold_count`, `type_state`, `sold_state`, `putaway_status`, `create_time`, `modify_time`, `del`) VALUES (17, 'Coke Cola', 2, NULL, '/image/8b63772e-51e4-45e3-a4c2-99ce1f4bd2f1.jpeg', NULL, 'Coke Cola', 6.00, 15.00, 1.00, 8, 6, 1, 0, 1, '2021-10-30 10:38:54', '2022-04-12 22:01:24', 0);
INSERT INTO `r_goods` (`goods_id`, `goods_name`, `category_id`, `img_small_url`, `img_url`, `img_circle_url`, `description`, `cost`, `price`, `discount`, `store_count`, `sold_count`, `type_state`, `sold_state`, `putaway_status`, `create_time`, `modify_time`, `del`) VALUES (18, 'Chocolate', 2, NULL, '/image/Chocolate.jpeg', NULL, 'Chocolate', 7.50, 18.00, 1.00, 1, 18, 1, 0, 1, '2021-10-30 10:39:48', NULL, 0);
INSERT INTO `r_goods` (`goods_id`, `goods_name`, `category_id`, `img_small_url`, `img_url`, `img_circle_url`, `description`, `cost`, `price`, `discount`, `store_count`, `sold_count`, `type_state`, `sold_state`, `putaway_status`, `create_time`, `modify_time`, `del`) VALUES (19, 'Orange Juice', 2, NULL, '/image/OrangeJuice.jpeg', NULL, 'Orange Juice', 6.00, 15.00, 1.00, 14, 18, 3, 0, 1, '2021-10-30 16:37:32', NULL, 0);
INSERT INTO `r_goods` (`goods_id`, `goods_name`, `category_id`, `img_small_url`, `img_url`, `img_circle_url`, `description`, `cost`, `price`, `discount`, `store_count`, `sold_count`, `type_state`, `sold_state`, `putaway_status`, `create_time`, `modify_time`, `del`) VALUES (20, 'Mocha', 2, NULL, '/image/Mocha.jpeg', NULL, 'Mocha', 6.50, 18.00, 1.00, 56, 9, 3, 0, 1, '2021-10-30 23:38:03', '2021-10-30 23:38:22', 0);
INSERT INTO `r_goods` (`goods_id`, `goods_name`, `category_id`, `img_small_url`, `img_url`, `img_circle_url`, `description`, `cost`, `price`, `discount`, `store_count`, `sold_count`, `type_state`, `sold_state`, `putaway_status`, `create_time`, `modify_time`, `del`) VALUES (21, 'House Beer', 2, NULL, '/image/HouseBeer.jpeg', NULL, 'House Beer', 21.00, 48.00, 1.00, 33, 10, 2, 0, 1, '2021-10-30 23:39:27', NULL, 0);
INSERT INTO `r_goods` (`goods_id`, `goods_name`, `category_id`, `img_small_url`, `img_url`, `img_circle_url`, `description`, `cost`, `price`, `discount`, `store_count`, `sold_count`, `type_state`, `sold_state`, `putaway_status`, `create_time`, `modify_time`, `del`) VALUES (22, 'Espresso', 2, NULL, '/image/Espresso.png', NULL, 'Espresso', 12.00, 30.00, 1.00, 6, 11, 1, 0, 1, '2021-10-30 23:40:36', NULL, 0);
INSERT INTO `r_goods` (`goods_id`, `goods_name`, `category_id`, `img_small_url`, `img_url`, `img_circle_url`, `description`, `cost`, `price`, `discount`, `store_count`, `sold_count`, `type_state`, `sold_state`, `putaway_status`, `create_time`, `modify_time`, `del`) VALUES (23, 'Salmon Caesar Salad', 3, NULL, '/image/p4.png', NULL, 'Salmon Caesar Salad', 41.00, 108.00, 1.00, 36, 4, 1, 0, 1, '2021-10-30 23:41:34', NULL, 0);
INSERT INTO `r_goods` (`goods_id`, `goods_name`, `category_id`, `img_small_url`, `img_url`, `img_circle_url`, `description`, `cost`, `price`, `discount`, `store_count`, `sold_count`, `type_state`, `sold_state`, `putaway_status`, `create_time`, `modify_time`, `del`) VALUES (24, 'Chicken Salad', 3, NULL, '/image/ChickenSalad.jpeg', NULL, 'Chicken Salad', 24.00, 98.00, 1.00, 63, 15, 1, 0, 1, '2021-10-30 23:43:36', NULL, 0);
INSERT INTO `r_goods` (`goods_id`, `goods_name`, `category_id`, `img_small_url`, `img_url`, `img_circle_url`, `description`, `cost`, `price`, `discount`, `store_count`, `sold_count`, `type_state`, `sold_state`, `putaway_status`, `create_time`, `modify_time`, `del`) VALUES (25, 'Nicoise Salad', 3, NULL, '/image/6eda53f6-1362-44c2-8748-504b12a94960.jpeg', NULL, 'Nicoise Salad', 34.00, 103.00, 1.00, 9, 4, 1, 0, 1, '2021-10-30 23:44:21', '2022-04-12 22:01:37', 0);
INSERT INTO `r_goods` (`goods_id`, `goods_name`, `category_id`, `img_small_url`, `img_url`, `img_circle_url`, `description`, `cost`, `price`, `discount`, `store_count`, `sold_count`, `type_state`, `sold_state`, `putaway_status`, `create_time`, `modify_time`, `del`) VALUES (26, 'Love in Paris', 4, NULL, '/image/glassheart.jpeg', NULL, 'Love in Paris', 34.00, 108.00, 1.00, 15, 10, 1, 0, 1, '2021-10-30 23:44:58', NULL, 0);
INSERT INTO `r_goods` (`goods_id`, `goods_name`, `category_id`, `img_small_url`, `img_url`, `img_circle_url`, `description`, `cost`, `price`, `discount`, `store_count`, `sold_count`, `type_state`, `sold_state`, `putaway_status`, `create_time`, `modify_time`, `del`) VALUES (27, 'Tiramisu', 4, NULL, '/image/85c75c90-bf93-4aa6-9569-085f4c08b16c.jpeg', NULL, 'Tiramisu', 18.00, 78.00, 1.00, 30, 4, 1, 0, 1, '2021-10-30 23:46:09', '2022-04-12 22:02:09', 0);
INSERT INTO `r_goods` (`goods_id`, `goods_name`, `category_id`, `img_small_url`, `img_url`, `img_circle_url`, `description`, `cost`, `price`, `discount`, `store_count`, `sold_count`, `type_state`, `sold_state`, `putaway_status`, `create_time`, `modify_time`, `del`) VALUES (28, 'Mango Cheesecake', 4, NULL, '/image/MangoCheesecake.jpeg', NULL, 'Mango Cheesecake', 9.00, 38.00, 1.00, 11, 1, 2, 0, 1, '2021-10-30 23:48:07', '2021-11-01 14:54:03', 0);
INSERT INTO `r_goods` (`goods_id`, `goods_name`, `category_id`, `img_small_url`, `img_url`, `img_circle_url`, `description`, `cost`, `price`, `discount`, `store_count`, `sold_count`, `type_state`, `sold_state`, `putaway_status`, `create_time`, `modify_time`, `del`) VALUES (29, 'Snowflake', 4, NULL, '/image/p3.jpeg', NULL, 'Snowflake', 6.50, 42.00, 1.00, 33, 1, 1, 0, 1, '2021-10-30 23:48:44', NULL, 0);
INSERT INTO `r_goods` (`goods_id`, `goods_name`, `category_id`, `img_small_url`, `img_url`, `img_circle_url`, `description`, `cost`, `price`, `discount`, `store_count`, `sold_count`, `type_state`, `sold_state`, `putaway_status`, `create_time`, `modify_time`, `del`) VALUES (30, 'Apple Pie', 4, NULL, '/image/ApplePie.jpeg', NULL, 'Apple Pie', 11.00, 78.00, 1.00, 8, 4, 1, 0, 1, '2021-10-30 23:49:17', '2021-10-30 23:49:33', 0);

-- ----------------------------
-- Table structure for r_member
-- ----------------------------
DROP TABLE IF EXISTS `r_member`;
CREATE TABLE `r_member`  (
  `member_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'member id',
  `member_code` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'member code（use phone number for member code）',
  `m_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'member name',
  `m_gender` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'gender',
  `m_birthday` date NULL DEFAULT NULL COMMENT 'birthday',
  `m_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'phone',
  `mc_id` int(11) NOT NULL DEFAULT 1 COMMENT 'member type id',
  `total_money` double(11, 3) NULL DEFAULT 0.000 COMMENT 'total money',
  `create_time` datetime NULL DEFAULT NULL COMMENT 'create time',
  `modify_time` datetime NULL DEFAULT NULL COMMENT 'modify time',
  `del` int(2) NULL DEFAULT 0 COMMENT 'delete',
  PRIMARY KEY (`member_id`) USING BTREE,
  UNIQUE INDEX `member_code`(`member_code`) USING BTREE,
  INDEX `mc_id`(`mc_id`) USING BTREE,
  CONSTRAINT `r_member_ibfk_1` FOREIGN KEY (`mc_id`) REFERENCES `r_merber_category` (`mc_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of r_member
-- ----------------------------
INSERT INTO `r_member` VALUES (1, '57359824', 'Customer A', 'M', '1991-06-05', '57359824', 3, 9735.980, '2018-11-21 21:11:18', '2018-11-30 18:21:19', 0);
INSERT INTO `r_member` VALUES (2, '92948443', 'Ku Ming', 'F', '2000-10-15', '92948443', 1, 627.200, '2018-11-21 21:12:07', NULL, 0);
INSERT INTO `r_member` VALUES (3, '63982967', 'Chung Fung', 'F', '2000-01-16', '63982967', 1, 418.460, '2018-11-21 21:12:07', '2018-11-30 18:14:47', 0);
INSERT INTO `r_member` VALUES (4, '97258262', 'Yoyo Wong', 'F', '1989-04-01', '97258262', 2, 1607.840, '2018-11-21 21:12:07', '2018-10-16 15:43:31', 0);
INSERT INTO `r_member` VALUES (5, '52731082', 'Lau Ki', 'M', '2018-10-15', '52731082', 2, 1465.100, '2018-11-21 22:27:30', '2018-10-16 15:38:25', 0);
INSERT INTO `r_member` VALUES (6, '92026469', 'Lee Ho', 'M', '1977-10-16', '92026469', 2, 1026.940, '2018-11-22 14:50:39', '2018-10-16 15:56:25', 0);
INSERT INTO `r_member` VALUES (10, '50728373', 'Cheung Chun Ho', 'M', '1987-07-29', '50728373', 2, 1331.820, '2018-11-22 11:02:50', '2018-11-30 18:14:52', 0);
INSERT INTO `r_member` VALUES (11, '97287401', 'Lilly Chan', 'F', '1990-05-25', '97287401', 1, 937.860, '2018-11-17 11:05:04', NULL, 0);
INSERT INTO `r_member` VALUES (12, '52023784', 'Christal Kwun', 'F', '1952-12-25', '52023784', 1, 534.550, '2018-11-23 11:10:37', NULL, 0);
INSERT INTO `r_member` VALUES (13, '90842741', 'Law Po', 'F', '1990-07-07', '90842741', 1, 871.610, '2018-11-24 11:12:20', NULL, 1);
INSERT INTO `r_member` VALUES (14, '96710438', 'Chan Siu Ming', 'M', '1966-08-07', '96710438', 4, 12456.800, '2019-10-12 11:13:21', '2019-10-15 14:46:55', 0);
INSERT INTO `r_member` VALUES (15, '69963802', 'Tai Kei', 'F', '1966-11-07', '69963802', 3, 8233.250, '2019-10-14 11:15:03', NULL, 0);
INSERT INTO `r_member` VALUES (16, '60362847', 'Leung Ka Wing', 'F', '1980-11-20', '60362847', 1, 784.390, '2019-10-14 17:22:33', NULL, 0);
INSERT INTO `r_member` VALUES (17, '93927490', 'Ku Chu Kei', 'F', '1977-11-15', '93927490', 1, 784.390, '2019-10-15 20:12:42', NULL, 0);
INSERT INTO `r_member` VALUES (18, '93769245', 'Chan Tai Ming', 'M', '1966-11-08', '93769245', 2, 1331.230, '2019-10-15 20:15:29', NULL, 0);
INSERT INTO `r_member` VALUES (19, '93769248', 'Leung Fei', 'M', '1966-07-12', '93769248', 1, 748.720, '2019-10-15 20:19:45', NULL, 0);
INSERT INTO `r_member` VALUES (20, '69263937', 'Emma Li', 'F', '1963-02-13', '69263937', 2, 1918.300, '2019-10-15 20:23:18', NULL, 0);
INSERT INTO `r_member` VALUES (21, '90672938', 'Sophia Do', 'F', '1956-07-26', '90672938', 2, 1266.750, '2019-10-17 08:36:01', NULL, 0);
INSERT INTO `r_member` VALUES (22, '94380163', 'Mia Dao', 'F', '1980-11-21', '94380163', 1, 281.260, '2019-10-17 08:36:29', NULL, 0);
INSERT INTO `r_member` VALUES (23, '61027324', 'Max Leung', 'M', '1951-05-22', '61027324', 1, 754.010, '2019-10-17 09:12:48', NULL, 1);
INSERT INTO `r_member` VALUES (24, '93629387', 'Member Li ', 'M', '1981-11-19', '93629387', 2, 1060.560, '2019-10-17 14:13:48', NULL, 1);
INSERT INTO `r_member` VALUES (25, '90284962', 'Wu Tin', 'F', '1987-11-30', '90284962', 1, 0.000, '2019-10-17 18:17:48', NULL, 0);

-- ----------------------------
-- Table structure for r_merber_category
-- ----------------------------
DROP TABLE IF EXISTS `r_merber_category`;
CREATE TABLE `r_merber_category`  (
  `mc_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'member type id',
  `mc_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'typename',
  `discount` decimal(10, 2) NULL DEFAULT NULL COMMENT 'discount',
  `amount` decimal(20, 2) NULL DEFAULT NULL COMMENT 'expenditure need',
  `create_time` datetime NULL DEFAULT NULL COMMENT 'create time',
  `modify_time` datetime NULL DEFAULT NULL COMMENT 'create time',
  `del` int(2) NULL DEFAULT 0 COMMENT 'delete',
  PRIMARY KEY (`mc_id`) USING BTREE,
  UNIQUE INDEX `mc_name`(`mc_name`) USING BTREE COMMENT 'unique key'
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of r_merber_category
-- ----------------------------
INSERT INTO `r_merber_category` VALUES (1, 'VIP', 0.98, 0.00, '2018-09-28 16:02:25', '2018-11-20 09:22:43', 0);
INSERT INTO `r_merber_category` VALUES (2, 'VIP_BRONZE', 0.90, 1000.00, '2018-09-28 16:02:48', '2018-11-30 18:14:29', 0);
INSERT INTO `r_merber_category` VALUES (3, 'VIP_SILVER', 0.85, 8000.00, '2018-09-28 16:03:18', '2018-11-20 09:23:07', 0);
INSERT INTO `r_merber_category` VALUES (4, 'VIP_GOLD ', 0.80, 10000.00, '2018-09-28 16:04:08', '2018-11-20 09:23:12', 0);
INSERT INTO `r_merber_category` VALUES (12, 'VIP_PLATINUM', 0.40, 6000000.00, '2018-10-16 17:41:30', NULL, 0);
INSERT INTO `r_merber_category` VALUES (13, 'VIP_DIAMOND', 0.10, 100000000.00, '2018-10-16 17:44:47', '2018-10-16 17:45:12', 0);
INSERT INTO `r_merber_category` VALUES (14, 'VIP_BLACK', 1.10, 100000.00, '2018-10-16 17:47:03', NULL, 0);

-- ----------------------------
-- Table structure for r_order
-- ----------------------------
DROP TABLE IF EXISTS `r_order`;
CREATE TABLE `r_order`  (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'order id',
  `order_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'order code',
  `desk_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'desk code',
  `member_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'member_code',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT ' user id',
  `total_cost` decimal(10, 2) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT 'total cost',
  `total_price` decimal(10, 2) NULL DEFAULT NULL COMMENT 'total price',
  `total_profit` decimal(10, 2) NULL DEFAULT NULL COMMENT 'total profit',
  `actual_pay` decimal(10, 2) NULL DEFAULT NULL COMMENT 'actual pay',
  `must_pay` decimal(10, 2) NULL DEFAULT NULL COMMENT 'payment',
  `change_money` decimal(10, 2) NULL DEFAULT NULL COMMENT 'change money',
  `discount_money` decimal(10, 2) NULL DEFAULT NULL COMMENT 'discount value',
  `people_num` int(10) NULL DEFAULT 0 COMMENT 'Customer number',
  `pay_status` int(2) NULL DEFAULT 0 COMMENT 'payment status(0not pay，1 payment finished))',
  `finish_status` int(2) NULL DEFAULT 0 COMMENT 'status of goods（0not finish，1finished）',
  `over_status` int(2) NULL DEFAULT 0 COMMENT 'over all status(0Not finish，1finished）',
  `create_time` datetime NULL DEFAULT NULL COMMENT 'create time',
  `modify_time` datetime NULL DEFAULT NULL COMMENT 'modify time',
  `del` int(2) NULL DEFAULT 0 COMMENT 'delete',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 72 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of r_order
-- ----------------------------
INSERT INTO `r_order` VALUES (1, '2018-1108-1114-01-637', '28', '97258262', 2, 00000191.90, 648.00, 443.14, 640.00, 635.04, 4.96, 12.96, 8, 1, 1, 1, '2018-11-01 11:14:01', NULL, 0);
INSERT INTO `r_order` VALUES (2, '2018-1108-1117-39-402', '1', '90842741', 2, 00000283.60, 947.40, 644.85, 930.00, 928.45, 1.55, 18.95, 6, 1, 1, 1, '2018-11-02 11:17:39', NULL, 0);
INSERT INTO `r_order` VALUES (3, '2018-1108-1119-29-470', '2', '52731082', 2, 00000039.00, 110.00, 68.80, 110.00, 107.80, 2.20, 2.20, 3, 1, 1, 1, '2018-11-03 11:19:29', NULL, 0);
INSERT INTO `r_order` VALUES (4, '2018-1108-1121-30-237', '3', '52731082', 2, 00000103.00, 279.00, 170.42, 300.00, 273.42, 26.58, 5.58, 7, 1, 1, 1, '2018-11-04 11:21:30', NULL, 0);
INSERT INTO `r_order` VALUES (5, '2018-1108-1130-25-576', '9', NULL, 2, 00000168.00, 567.00, 399.00, 570.00, 567.00, 3.00, 0.00, 5, 1, 1, 1, '2018-11-05 11:30:25', NULL, 0);
INSERT INTO `r_order` VALUES (6, '2018-1108-1305-16-100', '12', '52731082', 2, 00000317.00, 1106.00, 766.88, 1100.00, 1083.88, 16.12, 22.12, 10, 1, 1, 1, '2018-11-06 13:05:16', NULL, 0);
INSERT INTO `r_order` VALUES (7, '2018-1109-1628-56-962', '7', '52023784', 2, 00000087.00, 316.00, 222.68, 310.00, 309.68, 0.32, 6.32, 5, 1, 1, 1, '2018-11-06 16:28:56', NULL, 0);
INSERT INTO `r_order` VALUES (8, '2018-1109-1712-54-580', '28', '97287401', 2, 00000269.40, 957.00, 668.46, 940.00, 937.86, 2.14, 19.14, 7, 1, 1, 1, '2018-11-06 17:12:54', NULL, 0);
INSERT INTO `r_order` VALUES (9, '2018-1109-1822-59-014', '14', '92026469', 2, 00000466.00, 1133.00, 440.40, 910.00, 906.40, 3.60, 226.60, 10, 1, 1, 1, '2018-11-07 18:22:59', NULL, 0);
INSERT INTO `r_order` VALUES (10, '2018-1110-0933-06-050', '19', '90842741', 2, 00000312.80, 889.40, 558.81, 880.00, 871.61, 8.39, 17.79, 10, 1, 1, 1, '2018-11-08 09:33:06', NULL, 0);
INSERT INTO `r_order` VALUES (11, '2018-1110-0942-26-668', '22', '50728373', 2, 00000482.00, 1359.00, 849.82, 1400.00, 1331.82, 68.18, 27.18, 10, 1, 1, 1, '2018-11-09 09:42:26', NULL, 0);
INSERT INTO `r_order` VALUES (12, '2018-1110-1441-11-228', '32', '63982967', 2, 00000069.00, 192.00, 119.16, 190.00, 188.16, 1.84, 3.84, 5, 1, 1, 1, '2018-11-09 14:41:11', NULL, 0);
INSERT INTO `r_order` VALUES (13, '2018-1110-1441-46-056', '27', '92948443', 2, 00000175.90, 640.00, 451.30, 630.00, 627.20, 2.80, 12.80, 7, 1, 1, 1, '2018-11-10 14:41:46', NULL, 0);
INSERT INTO `r_order` VALUES (14, '2018-1110-1442-14-811', '7', '57359824', 2, 00000295.80, 970.80, 655.58, 960.00, 951.38, 8.62, 19.42, 8, 1, 1, 1, '2018-11-10 14:42:14', NULL, 0);
INSERT INTO `r_order` VALUES (15, '2018-1110-1446-10-928', '24', NULL, 2, 00000272.00, 663.00, 391.00, 665.00, 663.00, 2.00, 0.00, 6, 1, 1, 1, '2018-11-10 14:46:10', NULL, 0);
INSERT INTO `r_order` VALUES (16, '2018-1110-1458-24-234', '12', NULL, 2, 00000354.00, 906.00, 552.00, 910.00, 906.00, 4.00, 0.00, 6, 1, 1, 1, '2018-11-11 09:12:24', NULL, 0);
INSERT INTO `r_order` VALUES (17, '2018-1110-1649-42-996', '9', NULL, 2, 00000180.00, 388.00, 208.00, 390.00, 388.00, 2.00, 0.00, 6, 1, 1, 1, '2018-11-12 11:49:42', NULL, 0);
INSERT INTO `r_order` VALUES (18, '2018-1110-1650-22-646', '14', NULL, 2, 00000325.80, 1052.80, 727.00, 390.00, 1052.80, 0.00, 0.00, 7, 1, 1, 1, '2018-11-12 12:30:22', NULL, 0);
INSERT INTO `r_order` VALUES (19, '2018-1111-1652-04-078', '22', '60362847', 27, 00000104.90, 800.40, 679.49, 790.00, 784.39, 5.61, 16.01, 10, 1, 1, 1, '2018-11-13 12:35:04', NULL, 0);
INSERT INTO `r_order` VALUES (20, '2018-1111-1652-47-224', '25', '69963802', 2, 00000112.60, 311.00, 120.65, 234.00, 233.25, 0.75, 77.75, 6, 1, 1, 1, '2018-11-13 12:40:47', NULL, 0);
INSERT INTO `r_order` VALUES (21, '2018-1111-1653-53-785', '1', '93927490', 2, 00000084.00, 288.40, 198.63, 285.00, 282.63, 2.37, 5.77, 3, 1, 1, 1, '2018-11-14 18:53:53', NULL, 0);
INSERT INTO `r_order` VALUES (22, '2018-1111-1654-37-175', '2', '93769245', 2, 00000213.00, 615.60, 390.29, 610.00, 603.29, 6.71, 12.31, 10, 1, 1, 1, '2018-11-14 18:54:37', NULL, 0);
INSERT INTO `r_order` VALUES (23, '2018-1111-1655-00-052', '4', '93769248', 2, 00000076.00, 266.00, 184.68, 270.00, 260.68, 9.32, 5.32, 2, 1, 1, 1, '2018-11-15 18:55:00', NULL, 0);
INSERT INTO `r_order` VALUES (24, '2018-1111-1656-17-949', '31', '69263937', 2, 00000207.80, 958.00, 731.04, 940.00, 938.84, 1.16, 19.16, 10, 1, 1, 1, '2018-11-15 18:56:17', NULL, 0);
INSERT INTO `r_order` VALUES (25, '2018-1111-1659-05-809', '27', '69263937', 2, 00000267.80, 757.00, 474.06, 750.00, 741.86, 8.14, 15.14, 5, 1, 1, 1, '2018-11-16 19:01:05', NULL, 0);
INSERT INTO `r_order` VALUES (26, '2018-1111-1659-27-980', '31', '69263937', 2, 00000104.60, 297.00, 133.00, 240.00, 237.60, 2.40, 59.40, 6, 1, 1, 1, '2018-11-17 19:23:27', NULL, 0);
INSERT INTO `r_order` VALUES (27, '2018-1111-1700-49-571', '14', '93927490', 2, 00000156.00, 512.00, 345.76, 505.00, 501.76, 3.24, 10.24, 6, 1, 1, 1, '2018-11-18 19:43:49', NULL, 0);
INSERT INTO `r_order` VALUES (28, '2018-1111-1701-22-686', '9', '93769245', 2, 00000225.80, 742.80, 502.14, 730.00, 727.94, 2.06, 14.86, 7, 1, 1, 1, '2018-11-18 20:01:22', NULL, 0);
INSERT INTO `r_order` VALUES (29, '2018-1111-1702-09-686', '22', '93769248', 2, 00000173.60, 498.00, 314.44, 500.00, 488.04, 11.96, 9.96, 7, 1, 1, 1, '2018-11-18 20:02:09', NULL, 0);
INSERT INTO `r_order` VALUES (30, '2018-1111-2237-59-129', '8', NULL, 2, 00000038.80, 88.00, 49.20, 90.00, 88.00, 2.00, 0.00, 2, 1, 1, 1, '2018-11-18 22:37:59', NULL, 0);
INSERT INTO `r_order` VALUES (31, '2018-1111-2302-50-321', '13', NULL, 2, 00000161.00, 504.00, 343.00, 510.00, 504.00, 6.00, 0.00, 3, 1, 1, 1, '2018-11-18 23:02:50', NULL, 0);
INSERT INTO `r_order` VALUES (32, '2018-1111-2306-40-065', '8', '90672938', 2, 00000026.00, 76.60, 49.07, 80.00, 75.07, 3.40, 1.53, 4, 1, 1, 1, '2018-11-19 19:11:40', NULL, 0);
INSERT INTO `r_order` VALUES (33, '2018-1111-2315-39-110', '9', NULL, 2, 00000055.00, 138.00, 83.00, 140.00, 138.00, 2.00, 0.00, 2, 1, 1, 1, '2018-11-19 19:14:39', NULL, 0);
INSERT INTO `r_order` VALUES (34, '2018-1111-2321-15-914', '23', '52023784', 2, 00000042.00, 120.40, 78.40, 130.00, 120.40, 9.60, 0.00, 4, 1, 1, 1, '2018-11-19 19:14:15', NULL, 0);
INSERT INTO `r_order` VALUES (35, '2018-1111-2325-10-423', '13', '63982967', 2, 00000084.80, 235.00, 145.50, 240.00, 230.30, 5.00, 4.70, 2, 1, 1, 1, '2018-11-19 12:25:10', NULL, 0);
INSERT INTO `r_order` VALUES (36, '2018-1111-2326-30-816', '10', NULL, 2, 00000006.00, 12.00, 6.00, 12.00, 12.00, 0.00, 0.00, 1, 1, 1, 1, '2018-11-19 12:26:30', NULL, 0);
INSERT INTO `r_order` VALUES (37, '2018-1111-2340-28-569', '2', '94380163', 2, 00000064.00, 287.00, 217.26, 300.00, 281.26, 18.74, 5.74, 4, 1, 1, 1, '2018-11-19 12:40:00', NULL, 0);
INSERT INTO `r_order` VALUES (38, '2018-1111-2359-20-674', '9', NULL, 2, 00000104.80, 282.00, 177.20, 300.00, 282.00, 18.00, 0.00, 6, 1, 1, 1, '2018-11-20 12:59:20', NULL, 0);
INSERT INTO `r_order` VALUES (39, '2018-1112-0004-47-499', '15', '61027324', 2, 00000056.80, 135.00, 75.50, 140.00, 132.30, 7.70, 2.70, 1, 1, 1, 1, '2018-11-20 13:14:47', NULL, 0);
INSERT INTO `r_order` VALUES (40, '2018-1112-0753-27-965', '7', '61027324', 2, 00000162.80, 514.00, 340.92, 510.00, 503.72, 6.28, 10.28, 3, 1, 1, 1, '2018-11-21 07:53:27', NULL, 0);
INSERT INTO `r_order` VALUES (41, '2018-1112-0804-14-377', '8', NULL, 2, 00000084.80, 235.00, 150.20, 235.00, 235.00, 0.00, 0.00, 2, 1, 1, 1, '2018-11-21 08:04:14', NULL, 0);
INSERT INTO `r_order` VALUES (42, '2018-1112-0810-20-484', '3', NULL, 2, 00000109.80, 303.80, 194.00, 303.80, 303.80, 0.00, 0.00, 4, 1, 1, 1, '2018-11-22 08:10:20', NULL, 0);
INSERT INTO `r_order` VALUES (43, '2018-1112-0816-11-824', '4', NULL, 2, 00000018.00, 54.60, 36.60, 55.00, 54.60, 0.40, 0.00, 2, 1, 1, 1, '2018-11-22 08:16:11', NULL, 0);
INSERT INTO `r_order` VALUES (44, '2018-1112-0819-29-373', '2', '61027324', 2, 00000042.00, 120.40, 75.99, 120.00, 117.99, 2.01, 2.41, 2, 1, 1, 1, '2018-11-22 08:19:29', NULL, 0);
INSERT INTO `r_order` VALUES (45, '2018-1112-0822-08-622', '1', NULL, 2, 00000038.00, 120.40, 82.40, 130.00, 120.40, 9.60, 0.00, 3, 1, 1, 1, '2018-11-28 08:22:08', NULL, 0);
INSERT INTO `r_order` VALUES (46, '2018-1112-0830-25-350', '8', NULL, 2, 00000046.00, 106.00, 60.00, 106.00, 106.00, 0.00, 0.00, 2, 1, 1, 1, '2018-11-28 08:30:25', NULL, 0);
INSERT INTO `r_order` VALUES (47, '2018-1112-0833-51-927', '22', '90672938', 2, 00000134.60, 431.00, 287.78, 430.00, 422.38, 7.62, 8.62, 7, 1, 1, 1, '2018-11-29 08:33:51', NULL, 0);
INSERT INTO `r_order` VALUES (48, '2018-1112-0837-57-423', '7', '90672938', 2, 00000257.00, 785.00, 512.30, 770.00, 769.30, 0.70, 15.70, 7, 1, 1, 1, '2018-11-30 08:37:57', NULL, 0);
INSERT INTO `r_order` VALUES (49, '2018-1112-0958-48-911', '23', '52023784', 2, 00000044.00, 106.60, 60.47, 110.00, 104.47, 5.53, 2.13, 5, 1, 1, 1, '2018-11-30 09:58:48', NULL, 0);
INSERT INTO `r_order` VALUES (50, '2018-1112-1459-29-229', '3', '92026469', 2, 00000056.00, 123.00, 64.54, 121.00, 120.54, 0.46, 2.46, 2, 1, 1, 1, '2018-12-01 14:59:29', NULL, 0);
INSERT INTO `r_order` VALUES (51, '2018-1112-1504-15-185', '13', NULL, 2, 00000043.00, 74.00, 31.00, 75.00, 74.00, 1.00, 0.00, 3, 1, 1, 1, '2018-12-01 15:04:15', NULL, 0);
INSERT INTO `r_order` VALUES (52, '2018-1112-1509-27-708', '9', NULL, 2, 00000023.00, 54.00, 31.00, 54.00, 54.00, 0.00, 0.00, 4, 1, 1, 1, '2018-12-02 15:09:27', NULL, 0);
INSERT INTO `r_order` VALUES (53, '2018-1119-1145-16-679', '31', '93629387', 2, 00000220.60, 488.00, 257.64, 500.00, 478.24, 21.76, 9.76, 7, 1, 1, 1, '2018-12-02 11:45:16', NULL, 0);
INSERT INTO `r_order` VALUES (55, '2018-1119-1152-55-639', '9', NULL, 2, 00000239.00, 544.00, 305.00, 544.00, 544.00, 0.00, 0.00, 8, 1, 1, 1, '2018-12-02 12:52:55', NULL, 0);
INSERT INTO `r_order` VALUES (56, '2018-1119-1154-05-629', '7', NULL, 2, 00000161.00, 386.60, 225.60, 387.00, 386.60, 0.40, 0.00, 10, 1, 1, 1, '2018-12-02 13:54:05', NULL, 0);
INSERT INTO `r_order` VALUES (57, '2018-1119-1154-36-746', '28', NULL, 2, 00000387.00, 1124.00, 737.00, 1124.00, 1124.00, 0.00, 0.00, 7, 1, 1, 1, '2018-12-02 18:54:36', NULL, 0);
INSERT INTO `r_order` VALUES (58, '2018-1120-1503-10-944', '12', NULL, 2, 00000134.90, 390.00, 255.10, 400.00, 390.00, 10.00, 0.00, 5, 1, 1, 1, '2018-12-03 19:03:10', NULL, 0);
INSERT INTO `r_order` VALUES (59, '2018-1120-1504-40-111', '14', '93629387', 2, 00000073.00, 183.60, 106.93, 180.00, 179.93, 0.07, 3.67, 5, 1, 1, 1, '2018-12-04 19:04:40', NULL, 0);
INSERT INTO `r_order` VALUES (60, '2018-1120-1506-34-403', '31', '93629387', 2, 00000067.00, 184.60, 113.91, 185.00, 180.91, 4.09, 3.69, 7, 1, 1, 1, '2018-12-04 19:06:34', NULL, 0);
INSERT INTO `r_order` VALUES (61, '2018-1121-2056-53-649', '8', NULL, 2, 00000091.00, 246.40, 155.40, 250.00, 246.40, 3.60, 0.00, 4, 1, 1, 1, '2018-12-04 20:56:53', NULL, 0);
INSERT INTO `r_order` VALUES (62, '2018-1122-1007-04-366', '8', '97258262', 2, 00000173.00, 460.00, 277.80, 500.00, 450.80, 49.20, 9.20, 10, 1, 1, 1, '2018-12-04 12:07:04', NULL, 0);
INSERT INTO `r_order` VALUES (63, '2018-1122-1722-29-411', '4', NULL, 2, 00000139.00, 470.00, 331.00, 490.00, 470.00, 20.00, 0.00, 6, 1, 1, 1, '2018-12-04 12:22:29', NULL, 0);
INSERT INTO `r_order` VALUES (64, '2018-1126-1522-45-299', '6', NULL, 2, 00000096.90, 324.00, 227.10, 324.00, 324.00, 0.00, 0.00, 4, 1, 1, 1, '2018-12-05 15:22:45', NULL, 0);
INSERT INTO `r_order` VALUES (65, '2018-1126-1525-06-796', '10', '97258262', 2, 00000038.80, 102.00, 53.00, 100.00, 91.80, 8.20, 10.20, 4, 1, 1, 1, '2018-12-05 15:25:06', NULL, 0);
INSERT INTO `r_order` VALUES (66, '2018-1127-1539-32-467', '12', '97258262', 2, 00000068.80, 124.00, 42.80, 125.00, 111.60, 1.00, 12.40, 5, 1, 1, 1, '2018-12-05 15:39:32', NULL, 0);
INSERT INTO `r_order` VALUES (67, '2018-1127-1720-11-936', '2', '93629387', 2, 00000099.00, 226.00, 122.48, 230.00, 221.48, 8.52, 4.52, 5, 1, 1, 1, '2018-12-06 17:20:11', NULL, 0);
INSERT INTO `r_order` VALUES (68, '2018-1127-1735-11-470', '14', '96710438', 27, 00000175.80, 571.00, 281.00, 500.00, 456.80, 43.20, 114.20, 6, 1, 1, 1, '2018-12-06 17:35:11', NULL, 0);
INSERT INTO `r_order` VALUES (69, '2018-1127-1746-38-179', '11', '97258262', 2, 00000118.90, 354.00, 199.70, 320.00, 318.60, 1.40, 35.40, 4, 1, 1, 1, '2018-12-07 08:46:38', NULL, 0);
INSERT INTO `r_order` VALUES (70, '2018-1130-2112-07-397', '14', NULL, 2, 00000061.80, 136.00, 74.20, 138.00, 136.00, 2.00, 0.00, 3, 1, 1, 1, '2018-12-14 09:12:07', NULL, 0);
INSERT INTO `r_order` VALUES (71, '2019-1017-1238-23-146', '22', NULL, 2, 00000048.00, 86.00, 38.00, 86.00, 86.00, 0.00, 0.00, 6, 1, 1, 1, '2019-10-17 12:38:23', '2019-10-17 12:39:08', 0);

-- ----------------------------
-- Table structure for r_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `r_order_detail`;
CREATE TABLE `r_order_detail`  (
  `od_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'small_order_id',
  `order_id` bigint(20) NOT NULL COMMENT 'order_id',
  `goods_id` int(11) NOT NULL COMMENT 'goods_id',
  `count` int(6) NOT NULL DEFAULT 1 COMMENT 'goods_count',
  `status` int(2) NULL DEFAULT 0 COMMENT 'goods_status(0not make，1making，2finish，3served)',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'description',
  `del` int(2) NULL DEFAULT 0 COMMENT 'delete',
  PRIMARY KEY (`od_id`) USING BTREE,
  INDEX `order_id`(`order_id`) USING BTREE,
  INDEX `goods_id`(`goods_id`) USING BTREE,
  CONSTRAINT `r_order_detail_ibfk_2` FOREIGN KEY (`goods_id`) REFERENCES `r_goods` (`goods_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 293 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of r_order_detail
-- ----------------------------
INSERT INTO `r_order_detail` VALUES (1, 1, 11, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (2, 1, 35, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (3, 1, 34, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (4, 1, 39, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (5, 1, 5, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (6, 1, 18, 2, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (7, 2, 4, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (8, 2, 12, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (9, 2, 21, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (10, 2, 7, 2, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (11, 2, 37, 2, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (12, 2, 20, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (13, 3, 13, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (14, 3, 14, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (15, 3, 15, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (16, 4, 19, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (17, 4, 25, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (18, 4, 22, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (19, 4, 27, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (20, 4, 10, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (21, 5, 34, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (22, 5, 39, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (23, 5, 35, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (24, 5, 5, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (25, 5, 18, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (26, 6, 34, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (27, 6, 37, 2, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (28, 6, 36, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (29, 6, 20, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (30, 6, 21, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (31, 7, 16, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (32, 7, 24, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (33, 7, 20, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (34, 7, 19, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (35, 8, 7, 2, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (36, 8, 19, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (37, 8, 5, 2, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (38, 8, 18, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (39, 8, 7, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (40, 8, 17, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (41, 8, 20, 2, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (42, 8, 24, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (43, 8, 22, 2, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (44, 9, 18, 9, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (45, 9, 39, 7, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (46, 9, 22, 5, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (47, 9, 24, 7, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (48, 9, 16, 7, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (49, 10, 4, 2, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (50, 10, 12, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (51, 10, 16, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (52, 10, 21, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (53, 10, 30, 2, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (54, 10, 36, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (55, 10, 38, 3, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (56, 10, 7, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (57, 11, 9, 5, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (58, 11, 8, 7, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (59, 11, 14, 7, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (60, 11, 12, 4, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (61, 11, 13, 7, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (62, 11, 15, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (63, 11, 3, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (64, 12, 8, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (65, 12, 15, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (66, 12, 14, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (67, 12, 12, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (68, 12, 3, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (69, 13, 10, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (70, 13, 6, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (71, 13, 11, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (72, 13, 26, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (73, 13, 29, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (74, 14, 7, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (75, 14, 19, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (76, 14, 20, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (77, 14, 32, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (78, 14, 37, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (79, 14, 4, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (80, 14, 12, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (81, 14, 12, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (82, 14, 21, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (83, 14, 33, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (84, 15, 15, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (85, 15, 14, 3, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (86, 15, 36, 4, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (87, 15, 35, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (88, 16, 36, 4, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (89, 16, 33, 3, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (90, 16, 38, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (91, 16, 32, 2, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (92, 17, 19, 2, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (93, 17, 17, 2, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (94, 17, 28, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (95, 17, 26, 3, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (96, 18, 3, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (97, 18, 7, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (98, 18, 37, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (99, 18, 6, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (100, 18, 34, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (101, 18, 35, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (102, 18, 27, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (103, 18, 25, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (104, 18, 26, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (105, 19, 3, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (106, 19, 15, 2, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (107, 19, 14, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (108, 19, 8, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (109, 19, 9, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (110, 19, 39, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (111, 19, 11, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (112, 20, 5, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (113, 20, 10, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (114, 20, 7, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (115, 20, 17, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (116, 20, 23, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (117, 21, 4, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (118, 21, 12, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (119, 21, 21, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (120, 22, 3, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (121, 22, 8, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (122, 22, 14, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (123, 22, 10, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (124, 22, 31, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (125, 22, 22, 2, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (126, 22, 26, 2, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (127, 23, 4, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (128, 23, 21, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (129, 24, 37, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (130, 24, 32, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (131, 24, 19, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (132, 24, 7, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (133, 24, 34, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (134, 25, 7, 6, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (135, 25, 10, 7, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (136, 26, 7, 2, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (137, 26, 10, 3, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (138, 27, 5, 5, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (139, 27, 18, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (140, 28, 21, 3, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (141, 28, 12, 2, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (142, 28, 4, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (143, 28, 23, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (144, 28, 17, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (145, 29, 7, 2, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (146, 29, 10, 6, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (147, 30, 7, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (148, 30, 19, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (149, 31, 6, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (150, 31, 35, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (151, 31, 37, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (152, 32, 9, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (153, 32, 15, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (154, 32, 3, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (155, 33, 19, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (156, 33, 32, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (157, 34, 12, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (158, 34, 33, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (159, 35, 7, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (160, 35, 37, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (161, 36, 18, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (162, 37, 32, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (163, 37, 20, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (164, 37, 19, 1, 0, NULL, 1);
INSERT INTO `r_order_detail` VALUES (165, 38, 18, 1, 0, NULL, 1);
INSERT INTO `r_order_detail` VALUES (166, 38, 7, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (167, 38, 10, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (168, 38, 35, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (169, 38, 39, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (170, 39, 7, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (171, 39, 36, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (172, 40, 4, 3, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (173, 40, 11, 1, 0, NULL, 1);
INSERT INTO `r_order_detail` VALUES (174, 40, 25, 2, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (175, 40, 23, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (176, 41, 7, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (177, 41, 37, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (178, 42, 7, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (179, 42, 37, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (180, 42, 8, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (181, 43, 9, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (182, 43, 3, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (183, 44, 12, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (184, 44, 33, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (185, 45, 4, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (186, 45, 12, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (187, 46, 26, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (188, 46, 27, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (189, 47, 7, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (190, 47, 7, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (191, 47, 10, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (192, 47, 5, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (193, 47, 21, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (194, 48, 4, 2, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (195, 48, 6, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (196, 48, 37, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (197, 48, 38, 2, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (198, 48, 32, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (199, 49, 3, 2, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (200, 49, 14, 2, 0, NULL, 1);
INSERT INTO `r_order_detail` VALUES (201, 49, 52, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (202, 50, 52, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (203, 50, 53, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (204, 51, 56, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (205, 51, 55, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (206, 52, 46, 1, 0, NULL, 1);
INSERT INTO `r_order_detail` VALUES (207, 52, 47, 1, 0, NULL, 1);
INSERT INTO `r_order_detail` VALUES (208, 52, 45, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (209, 53, 24, 3, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (210, 53, 19, 3, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (211, 53, 16, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (212, 53, 10, 2, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (213, 53, 57, 2, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (214, 53, 52, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (215, 54, 7, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (216, 54, 40, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (217, 55, 5, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (218, 55, 43, 2, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (219, 55, 45, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (220, 55, 46, 2, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (221, 55, 41, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (222, 55, 42, 2, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (223, 55, 39, 4, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (224, 55, 38, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (225, 56, 44, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (226, 56, 49, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (227, 56, 54, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (228, 56, 8, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (229, 56, 9, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (230, 56, 15, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (231, 57, 34, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (232, 57, 35, 3, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (233, 57, 36, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (234, 57, 38, 3, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (235, 57, 33, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (236, 58, 39, 2, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (237, 58, 4, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (238, 58, 11, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (239, 58, 37, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (240, 59, 51, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (241, 59, 15, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (242, 59, 8, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (243, 59, 9, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (244, 60, 8, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (245, 60, 9, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (246, 60, 14, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (247, 60, 15, 2, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (248, 61, 12, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (249, 61, 53, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (250, 61, 61, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (251, 61, 4, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (252, 62, 24, 2, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (253, 62, 22, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (254, 62, 33, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (255, 62, 44, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (256, 62, 40, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (257, 62, 5, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (258, 62, 18, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (259, 62, 46, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (260, 63, 7, 2, 0, NULL, 1);
INSERT INTO `r_order_detail` VALUES (261, 63, 19, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (262, 63, 37, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (263, 63, 40, 2, 0, NULL, 1);
INSERT INTO `r_order_detail` VALUES (264, 63, 44, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (265, 63, 20, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (266, 64, 6, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (267, 64, 11, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (268, 64, 36, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (269, 65, 7, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (270, 65, 44, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (271, 65, 20, 1, 0, NULL, 1);
INSERT INTO `r_order_detail` VALUES (272, 66, 55, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (273, 66, 56, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (274, 66, 57, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (275, 66, 58, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (276, 67, 47, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (277, 67, 45, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (278, 67, 44, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (279, 67, 43, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (280, 68, 7, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (281, 68, 37, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (282, 68, 40, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (283, 68, 34, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (284, 69, 11, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (285, 69, 33, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (286, 69, 37, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (287, 70, 40, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (288, 70, 7, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (289, 70, 19, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (290, 71, 56, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (291, 71, 63, 1, 3, NULL, 0);
INSERT INTO `r_order_detail` VALUES (292, 71, 53, 1, 0, NULL, 1);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'menu_id',
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'menu_name',
  `parent_id` bigint(20) NULL DEFAULT 0 COMMENT 'parent_id',
  `parent_ids` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'all_parent_id',
  `is_show` int(2) NULL DEFAULT NULL COMMENT 'showing（0no，1yes）',
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'permission',
  `menu_href` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'menu_href',
  `menu_icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'menu_icon',
  `weight` int(10) NULL DEFAULT NULL COMMENT 'menu_weigh',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'menu_description',
  `del` int(2) NULL DEFAULT 0 COMMENT 'delete(0no，1yes)',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 'Order Management', 0, '', 1, '', NULL, 'layui-icon-form', 50000, '', 0);
INSERT INTO `sys_menu` VALUES (2, 'Order List', 1, '1,', 1, 'orderManage:view', '/order/list.html', NULL, 8000, NULL, 0);
INSERT INTO `sys_menu` VALUES (3, 'Modify', 2, '1,2', 0, 'orderManage:edit', NULL, NULL, 7900, NULL, 0);
INSERT INTO `sys_menu` VALUES (4, 'Searching', 2, '1,2', 0, 'orderManage:view', NULL, NULL, 7800, NULL, 0);
INSERT INTO `sys_menu` VALUES (5, 'Menu Management', 0, NULL, 1, '', '', 'layui-icon-read', 60000, NULL, 0);
INSERT INTO `sys_menu` VALUES (6, 'Menu List', 5, '5,', 1, 'goodsManage:view', '/goods/list.html', NULL, 7700, NULL, 0);
INSERT INTO `sys_menu` VALUES (7, 'Add goods', 5, '5,', 1, 'goodsManage:view', '', NULL, 7600, NULL, 1);
INSERT INTO `sys_menu` VALUES (8, 'modify', 6, '5,6', 0, 'goodsManage:edit', NULL, NULL, 7500, NULL, 0);
INSERT INTO `sys_menu` VALUES (9, 'Searching', 6, '5,6', 0, 'goodsManage:view', NULL, NULL, 7400, NULL, 0);
INSERT INTO `sys_menu` VALUES (10, 'Type List', 5, '5,', 1, 'goodsTypes:view', '/goodscategory/list.html', NULL, 7300, NULL, 0);
INSERT INTO `sys_menu` VALUES (11, 'Add Type', 5, '5,', 1, 'goodsTypes:edit', '', NULL, 7200, NULL, 1);
INSERT INTO `sys_menu` VALUES (12, 'Modify', 10, '5,10', 0, 'goodsTypes:edit', NULL, NULL, 7100, NULL, 0);
INSERT INTO `sys_menu` VALUES (13, 'Searching', 10, '5,10', 0, 'goodsTypes:view', NULL, NULL, 7000, NULL, 0);
INSERT INTO `sys_menu` VALUES (14, 'Member Management', 0, NULL, 1, '', NULL, 'layui-icon-username', 70000, NULL, 0);
INSERT INTO `sys_menu` VALUES (15, 'Member List', 14, '14,', 1, 'memberManage:view', '/member/list.html', NULL, 6900, NULL, 0);
INSERT INTO `sys_menu` VALUES (16, 'Modify', 15, '14,15', 0, 'memberManage:edit', NULL, NULL, 6800, NULL, 0);
INSERT INTO `sys_menu` VALUES (17, 'Searching', 15, '14,15', 0, 'memberManage:view', NULL, NULL, 6700, NULL, 0);
INSERT INTO `sys_menu` VALUES (18, 'Member Type List', 14, '14,', 1, 'memberTypes:view', '/membercategory/list.html', NULL, 6600, NULL, 0);
INSERT INTO `sys_menu` VALUES (19, 'Add Member Type', 14, '14,', 1, 'memberTypes:edit', '', NULL, 6500, NULL, 1);
INSERT INTO `sys_menu` VALUES (20, 'Modify', 18, '14,18', 0, 'memberTypes:edit', NULL, NULL, 6400, NULL, 0);
INSERT INTO `sys_menu` VALUES (21, 'Searching', 18, '14,18', 0, 'memberTypes:view', NULL, NULL, 6300, NULL, 0);
INSERT INTO `sys_menu` VALUES (22, 'Employee Management', 0, NULL, 1, '', NULL, 'layui-icon-user', 80000, NULL, 0);
INSERT INTO `sys_menu` VALUES (23, 'Employee List', 22, '22,', 1, 'userManage:view', '/user/userlist.html', NULL, 6200, NULL, 0);
INSERT INTO `sys_menu` VALUES (24, 'Add Employee', 22, '22,', 1, 'userManage:edit', '/user/adduser.html', NULL, 6100, NULL, 1);
INSERT INTO `sys_menu` VALUES (25, 'Modify', 23, '22,23', 0, 'userManage:edit', NULL, NULL, 6000, NULL, 0);
INSERT INTO `sys_menu` VALUES (26, 'Searching', 23, '22,23', 0, 'userManage:view ', NULL, NULL, 5900, NULL, 0);
INSERT INTO `sys_menu` VALUES (27, 'Sales Management', 0, NULL, 1, '', NULL, 'layui-icon-cart-simple', 40000, NULL, 0);
INSERT INTO `sys_menu` VALUES (28, 'Sales Statistics', 27, '27,', 1, 'salesVolume:view', '/analysis/salesVolume.html', NULL, 5800, NULL, 0);
INSERT INTO `sys_menu` VALUES (29, 'Searching', 28, '27,28', 0, 'salesVolume:view', NULL, NULL, 5700, NULL, 0);
INSERT INTO `sys_menu` VALUES (30, 'Transaction Record', 27, '27,', 1, 'tranRecords:view', '/sold/tranRecordsList.html', NULL, 5600, NULL, 0);
INSERT INTO `sys_menu` VALUES (31, 'Searching', 30, '27,30', 0, 'tranRecords:view', NULL, NULL, 5500, NULL, 0);
INSERT INTO `sys_menu` VALUES (32, 'Food Status Management', 0, NULL, 1, '', NULL, 'layui-icon-release', 30000, NULL, 0);
INSERT INTO `sys_menu` VALUES (33, 'Cooking List', 32, '32,', 1, 'cooking:view', '/service/cookTask.html', NULL, 5400, NULL, 0);
INSERT INTO `sys_menu` VALUES (34, 'Modify', 33, '32,33', 0, 'cooking:edit', NULL, NULL, 5300, NULL, 0);
INSERT INTO `sys_menu` VALUES (35, 'Serving List', 32, '32,', 1, 'serving:view', '/service/servingTask.html', NULL, 5200, NULL, 0);
INSERT INTO `sys_menu` VALUES (36, 'Modify', 35, '32,35', 0, 'serving:edit', NULL, NULL, 5100, NULL, 0);
INSERT INTO `sys_menu` VALUES (37, 'Table Serving Status List', 32, '32,', 1, 'deskServing:view', '/service/dssList.html', NULL, 5000, NULL, 0);
INSERT INTO `sys_menu` VALUES (38, 'Searching', 37, '32,37', 0, 'deskServing:view', NULL, NULL, 4900, NULL, 0);
INSERT INTO `sys_menu` VALUES (39, 'Table Management', 0, NULL, 1, '', '', 'layui-icon-circle', 20000, NULL, 0);
INSERT INTO `sys_menu` VALUES (40, 'Table List', 39, '39,', 1, 'deskManage:view', '/desk/list.html', NULL, 4800, NULL, 0);
INSERT INTO `sys_menu` VALUES (41, 'Add Table', 39, '39,', 1, 'deskManage:edit', '', NULL, 4700, NULL, 1);
INSERT INTO `sys_menu` VALUES (42, 'Modify', 40, '39,40', 0, 'deskManage:edit', NULL, NULL, 4600, NULL, 0);
INSERT INTO `sys_menu` VALUES (43, 'Searching', 40, '39,40', 0, 'deskManage:view', NULL, NULL, 4500, NULL, 0);
INSERT INTO `sys_menu` VALUES (44, 'Cashier', 0, NULL, 1, '', '', 'layui-icon-rmb', 10000, NULL, 0);
INSERT INTO `sys_menu` VALUES (45, 'Payment', 44, '44,', 1, 'counter:view', '/counter/counterPage.html', NULL, 4400, NULL, 0);
INSERT INTO `sys_menu` VALUES (47, 'delete', 15, '14,15', 1, 'manage:del', NULL, NULL, 6310, NULL, 0);
INSERT INTO `sys_menu` VALUES (48, 'Total Sales', 27, '27，', 1, 'salesStatistics:view', '/analysis/salesStatistics.html', NULL, 5850, NULL, 0);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'role_id',
  `role_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'role_name',
  `create_time` datetime NULL DEFAULT NULL COMMENT 'create_time',
  `modify_time` datetime NULL DEFAULT NULL COMMENT 'modify_time',
  `del` int(2) NULL DEFAULT 0 COMMENT 'delete',
  PRIMARY KEY (`role_id`) USING BTREE,
  UNIQUE INDEX `role_name`(`role_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'Manager', '2018-09-28 15:58:21', NULL, 0);
INSERT INTO `sys_role` VALUES (2, 'Chef', '2018-09-28 16:00:32', NULL, 0);
INSERT INTO `sys_role` VALUES (3, 'Waiter', '2018-09-28 16:00:41', NULL, 0);
INSERT INTO `sys_role` VALUES (4, 'Cashier', '2018-09-28 16:01:09', NULL, 0);
INSERT INTO `sys_role` VALUES (5, 'Customer', '2018-09-28 16:01:16', NULL, 1);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_id` int(10) NOT NULL COMMENT 'role_id',
  `menu_id` bigint(20) NOT NULL COMMENT 'menu_id',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE,
  INDEX `menu_id`(`menu_id`) USING BTREE,
  CONSTRAINT `sys_role_menu_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `sys_role_menu_ibfk_2` FOREIGN KEY (`menu_id`) REFERENCES `sys_menu` (`menu_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 1);
INSERT INTO `sys_role_menu` VALUES (4, 1);
INSERT INTO `sys_role_menu` VALUES (1, 2);
INSERT INTO `sys_role_menu` VALUES (4, 2);
INSERT INTO `sys_role_menu` VALUES (4, 3);
INSERT INTO `sys_role_menu` VALUES (1, 4);
INSERT INTO `sys_role_menu` VALUES (4, 4);
INSERT INTO `sys_role_menu` VALUES (1, 5);
INSERT INTO `sys_role_menu` VALUES (2, 5);
INSERT INTO `sys_role_menu` VALUES (1, 6);
INSERT INTO `sys_role_menu` VALUES (2, 6);
INSERT INTO `sys_role_menu` VALUES (1, 7);
INSERT INTO `sys_role_menu` VALUES (2, 7);
INSERT INTO `sys_role_menu` VALUES (1, 8);
INSERT INTO `sys_role_menu` VALUES (2, 8);
INSERT INTO `sys_role_menu` VALUES (1, 9);
INSERT INTO `sys_role_menu` VALUES (2, 9);
INSERT INTO `sys_role_menu` VALUES (1, 10);
INSERT INTO `sys_role_menu` VALUES (1, 11);
INSERT INTO `sys_role_menu` VALUES (1, 12);
INSERT INTO `sys_role_menu` VALUES (1, 13);
INSERT INTO `sys_role_menu` VALUES (1, 14);
INSERT INTO `sys_role_menu` VALUES (4, 14);
INSERT INTO `sys_role_menu` VALUES (1, 15);
INSERT INTO `sys_role_menu` VALUES (4, 15);
INSERT INTO `sys_role_menu` VALUES (1, 16);
INSERT INTO `sys_role_menu` VALUES (4, 16);
INSERT INTO `sys_role_menu` VALUES (1, 17);
INSERT INTO `sys_role_menu` VALUES (4, 17);
INSERT INTO `sys_role_menu` VALUES (1, 18);
INSERT INTO `sys_role_menu` VALUES (1, 19);
INSERT INTO `sys_role_menu` VALUES (1, 20);
INSERT INTO `sys_role_menu` VALUES (1, 21);
INSERT INTO `sys_role_menu` VALUES (1, 22);
INSERT INTO `sys_role_menu` VALUES (1, 23);
INSERT INTO `sys_role_menu` VALUES (1, 24);
INSERT INTO `sys_role_menu` VALUES (1, 25);
INSERT INTO `sys_role_menu` VALUES (1, 26);
INSERT INTO `sys_role_menu` VALUES (1, 27);
INSERT INTO `sys_role_menu` VALUES (4, 27);
INSERT INTO `sys_role_menu` VALUES (1, 28);
INSERT INTO `sys_role_menu` VALUES (1, 29);
INSERT INTO `sys_role_menu` VALUES (1, 30);
INSERT INTO `sys_role_menu` VALUES (4, 30);
INSERT INTO `sys_role_menu` VALUES (1, 31);
INSERT INTO `sys_role_menu` VALUES (4, 31);
INSERT INTO `sys_role_menu` VALUES (1, 32);
INSERT INTO `sys_role_menu` VALUES (2, 32);
INSERT INTO `sys_role_menu` VALUES (3, 32);
INSERT INTO `sys_role_menu` VALUES (1, 33);
INSERT INTO `sys_role_menu` VALUES (2, 33);
INSERT INTO `sys_role_menu` VALUES (2, 34);
INSERT INTO `sys_role_menu` VALUES (1, 35);
INSERT INTO `sys_role_menu` VALUES (3, 35);
INSERT INTO `sys_role_menu` VALUES (3, 36);
INSERT INTO `sys_role_menu` VALUES (1, 37);
INSERT INTO `sys_role_menu` VALUES (3, 37);
INSERT INTO `sys_role_menu` VALUES (1, 38);
INSERT INTO `sys_role_menu` VALUES (3, 38);
INSERT INTO `sys_role_menu` VALUES (1, 39);
INSERT INTO `sys_role_menu` VALUES (3, 39);
INSERT INTO `sys_role_menu` VALUES (1, 40);
INSERT INTO `sys_role_menu` VALUES (3, 40);
INSERT INTO `sys_role_menu` VALUES (1, 41);
INSERT INTO `sys_role_menu` VALUES (1, 42);
INSERT INTO `sys_role_menu` VALUES (1, 43);
INSERT INTO `sys_role_menu` VALUES (3, 43);
INSERT INTO `sys_role_menu` VALUES (4, 44);
INSERT INTO `sys_role_menu` VALUES (4, 45);
INSERT INTO `sys_role_menu` VALUES (1, 47);
INSERT INTO `sys_role_menu` VALUES (1, 48);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
 `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'user_id',
 `login_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'login_account',
 `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'password',
 `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'user_name',
 `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'user_phone',
 `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'user_email_address',
 `gender` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'user_gender',
 `birthday` date NULL DEFAULT NULL COMMENT 'user_birthday',
 `id_number` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'HKID',
 `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Address',
 `create_time` datetime NULL DEFAULT NULL COMMENT 'create_time',
 `modify_time` datetime NULL DEFAULT NULL COMMENT 'modify_time',
 `del` int(2) NULL DEFAULT 0 COMMENT 'delete',
 PRIMARY KEY (`user_id`) USING BTREE,
 UNIQUE INDEX `login_code`(`login_code`) USING BTREE,
 UNIQUE INDEX `id_number`(`id_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '69972123', '123456', 'Manager Li', '69972123', '18384623911@gmail.com', 'M', '1998-05-26', 'Y9273471', 'Tung Chung', '2018-09-28 16:16:14', '2019-10-17 13:07:36', 0);
INSERT INTO `sys_user` VALUES (2, '92876762', '123456', 'Cashier A', '92876762', '18384623912@gmail.com', 'M', '1995-06-24', 'Y9273472', 'Kowloon Bay', '2018-09-28 16:20:32', '2019-10-17 13:07:41', 0);
INSERT INTO `sys_user` VALUES (3, '93268745', '123456', 'Chef Nick', '93268745', '18384623913@gmail.com', 'M', '1990-08-16', 'Y9278473', 'Yung Shue Wan', '2018-09-28 16:23:03', '2019-10-17 13:07:47', 0);
INSERT INTO `sys_user` VALUES (4, '64789021', '123456', 'Waiter D', '64789021', '18384623914@gmail.com', 'M', '1992-01-16', 'Y9073474', 'Ngong Ping', '2018-09-28 16:24:56', '2019-10-17 13:07:56', 0);
INSERT INTO `sys_user` VALUES (13, '92137980', '123456', 'Emily Yu', '92137980', '18384623915@gmail.com', 'F', '1996-10-16', 'Y9203475', 'Tuen Mun', '2018-10-13 23:41:19', NULL, 0);
INSERT INTO `sys_user` VALUES (14, '57938802', '123456', 'Ashley Ku', '57938802', '18384623915@gmail.com', 'F', '1996-10-09', 'Y9271476', 'Tsuen Wan', '2018-10-13 23:43:02', NULL, 0);
INSERT INTO `sys_user` VALUES (15, '52938047', '123456', 'Lilly Cheung', '52938047', '18384623917@gmail.com', 'F', '1980-10-13', 'Y9263477', 'Shatin', '2018-10-13 23:45:44', NULL, 0);
INSERT INTO `sys_user` VALUES (20, '95823043', '123456', 'May Chan', '95823043', '18384623919@gmail.com', 'F', '1988-07-13', 'Y9373478', 'Kwun Tong', '2018-10-14 20:25:15', NULL, 0);
INSERT INTO `sys_user` VALUES (23, '57239870', '123456', 'Lee Big Big', '57239870', '18384623919@gmail.com', 'M', '1981-03-01', 'Y9278479', 'Lok Fu', '2018-10-14 22:38:46', NULL, 0);
INSERT INTO `sys_user` VALUES (24, '67129038', '123456', 'Waiter B', '67129038', '18384623918@gmail.com', 'F', '1981-10-15', 'Y2610582', 'Lai KIng', '2018-10-15 16:03:46', '2018-11-26 17:42:42', 0);
INSERT INTO `sys_user` VALUES (25, '54807728', '123456', 'Waiter C', '54807728', '18384623912@gmail.com', 'M', '1970-10-15', 'Y2946210', 'Sai Ying Pun', '2018-10-15 17:39:08', '2018-11-26 17:43:03', 1);
INSERT INTO `sys_user` VALUES (26, '61028371', '123456', 'Waiter D', '61028371', '18384623912@gmail.com', 'F', '1997-12-02', 'Y3926392', 'Mong Kok', '2018-10-15 17:47:06', '2018-11-26 17:28:54', 0);
INSERT INTO `sys_user` VALUES (27, '92197407', '123456', 'Cashier B', '92197407', '18384623910@gmail.com', 'F', '1978-03-16', 'Y1234567', 'Chai Wan', '2018-11-11 17:13:22', '2018-11-26 17:40:12', 0);
INSERT INTO `sys_user` VALUES (28, '99732686', '123456', 'Waiter F', '99732686', '18384623810@gmail.com', 'F', '1978-04-12', 'Y0172649', 'Po Lam', '2018-11-26 17:37:23', '2018-11-26 17:40:24', 0);
INSERT INTO `sys_user` VALUES (29, '63027381', '123456', 'Chief B', '63027381', '18384623811@gmail.com', 'F', '2018-11-26', 'Y0126371', 'Tsing Yi', '2018-11-26 17:38:33', '2018-11-26 17:40:29', 1);
INSERT INTO `sys_user` VALUES (30, '91323028', '123456', 'Chief C', '91323028', '18384623812@gmail.com', 'F', '1983-11-11', 'Y2329736', 'Whampoa', '2018-11-26 17:39:47', '2018-11-26 17:42:22', 1);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
 `user_id` bigint(20) NOT NULL COMMENT 'user_id',
 `role_id` int(11) NOT NULL COMMENT 'role_id',
 PRIMARY KEY (`user_id`, `role_id`) USING BTREE,
 INDEX `role_id`(`role_id`) USING BTREE,
 CONSTRAINT `sys_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
 CONSTRAINT `sys_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (3, 2);
INSERT INTO `sys_user_role` VALUES (20, 2);
INSERT INTO `sys_user_role` VALUES (29, 2);
INSERT INTO `sys_user_role` VALUES (30, 2);
INSERT INTO `sys_user_role` VALUES (4, 3);
INSERT INTO `sys_user_role` VALUES (13, 3);
INSERT INTO `sys_user_role` VALUES (23, 3);
INSERT INTO `sys_user_role` VALUES (24, 3);
INSERT INTO `sys_user_role` VALUES (25, 3);
INSERT INTO `sys_user_role` VALUES (26, 3);
INSERT INTO `sys_user_role` VALUES (28, 3);
INSERT INTO `sys_user_role` VALUES (2, 4);
INSERT INTO `sys_user_role` VALUES (14, 4);
INSERT INTO `sys_user_role` VALUES (27, 4);

SET FOREIGN_KEY_CHECKS = 1;