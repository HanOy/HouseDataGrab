/*
Navicat MySQL Data Transfer

Source Server         : diomond
Source Server Version : 80011
Source Host           : 192.168.52.47:3306
Source Database       : house

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2018-08-06 11:27:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room` tinyint(4) DEFAULT NULL COMMENT '室',
  `hall` tinyint(4) DEFAULT NULL COMMENT '厅',
  `toilet` tinyint(4) DEFAULT NULL COMMENT '卫',
  `community` varchar(32) DEFAULT NULL COMMENT '小区',
  `area` decimal(9,2) DEFAULT NULL COMMENT '面积',
  `price` decimal(9,2) DEFAULT NULL COMMENT '单位：万元',
  `average` decimal(9,2) DEFAULT NULL COMMENT '每平米价格',
  `year` varchar(32) DEFAULT NULL COMMENT '建筑年代',
  `floor` varchar(32) DEFAULT NULL COMMENT '层',
  `district` varchar(32) DEFAULT NULL COMMENT '区',
  `address` varchar(128) DEFAULT NULL COMMENT '地址',
  `subway` tinyint(4) DEFAULT NULL COMMENT '是否近地铁',
  `elevator` tinyint(4) DEFAULT NULL COMMENT '是否电梯',
  `visit` tinyint(4) DEFAULT NULL COMMENT '是否随时看房',
  `href` varchar(128) DEFAULT NULL COMMENT '详情地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
