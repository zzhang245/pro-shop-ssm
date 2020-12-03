/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : shop

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 09/11/2020 20:33:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for a_admins
-- ----------------------------
DROP TABLE IF EXISTS `a_admins`;
CREATE TABLE `a_admins`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键;自动递增',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码,md5加密',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名称',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话',
  `sex` smallint(0) NULL DEFAULT NULL COMMENT '性别:0:无,1:男;2:女',
  `status` tinyint(0) NOT NULL COMMENT '状态:0:禁用,1:启用',
  `createTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updateTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `lastLoginTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '上次登陆时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '管理员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of a_admins
-- ----------------------------

-- ----------------------------
-- Table structure for a_cart
-- ----------------------------
DROP TABLE IF EXISTS `a_cart`;
CREATE TABLE `a_cart`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键;自动递增',
  `usersId` int(0) NULL DEFAULT NULL COMMENT '用户Id',
  `goodsId` int(0) NULL DEFAULT NULL COMMENT '商品Id',
  `num` int(0) NULL DEFAULT NULL COMMENT '数量',
  `status` tinyint(0) NOT NULL COMMENT '状态:0:禁用;1:启用',
  `createTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updateTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `pubTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '发布时间:用来排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '购物车表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of a_cart
-- ----------------------------

-- ----------------------------
-- Table structure for a_cate
-- ----------------------------
DROP TABLE IF EXISTS `a_cate`;
CREATE TABLE `a_cate`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键;自动递增',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名称(后端查看)',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '内容',
  `status` tinyint(0) NOT NULL COMMENT '状态:0:禁用,1:启用',
  `createTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updateTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `pubTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '发布时间:用来排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of a_cate
-- ----------------------------

-- ----------------------------
-- Table structure for a_common
-- ----------------------------
DROP TABLE IF EXISTS `a_common`;
CREATE TABLE `a_common`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键;自动递增',
  `usersId` int(0) NULL DEFAULT NULL COMMENT '用户Id',
  `adminsId` int(0) NULL DEFAULT NULL COMMENT '管理员Id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标题',
  `respCon` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '回复内容',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '备注',
  `status` tinyint(0) NOT NULL COMMENT '状态:0:草稿,1:发布;2:已处理;3:作废',
  `createTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updateTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `pubTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '发布时间:用来排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '留言表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of a_common
-- ----------------------------

-- ----------------------------
-- Table structure for a_goods
-- ----------------------------
DROP TABLE IF EXISTS `a_goods`;
CREATE TABLE `a_goods`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键;自动递增',
  `cateId` int(0) NULL DEFAULT NULL COMMENT '分类',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名称(前端查看)',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名称(后端查看)',
  `brief` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '简介',
  `price` decimal(20, 2) NULL DEFAULT NULL COMMENT '价格',
  `stockNum` int(0) NULL DEFAULT NULL COMMENT '库存',
  `saleNum` int(0) NULL DEFAULT NULL COMMENT '销售量',
  `listImg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图片路径',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '内容',
  `status` tinyint(0) NOT NULL COMMENT '状态:0:下架;1:上架',
  `createTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updateTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `pubTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '发布时间:用来排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of a_goods
-- ----------------------------

-- ----------------------------
-- Table structure for a_orders
-- ----------------------------
DROP TABLE IF EXISTS `a_orders`;
CREATE TABLE `a_orders`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键;自动递增',
  `usersId` int(0) NULL DEFAULT NULL COMMENT '用户Id',
  `receName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '收货人姓名',
  `recePhone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '收货人手机号',
  `receAddress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '收货地址',
  `totalPrice` decimal(10, 2) NULL DEFAULT NULL COMMENT '总价格',
  `dealAmount` decimal(10, 2) NULL DEFAULT NULL COMMENT '应付金额',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '备注',
  `status` tinyint(0) NOT NULL COMMENT '状态:0:下单;1:已确认;2:已付款;3:已收款;4:已发货;5:已收货',
  `createTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updateTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `pubTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '发布时间:用来排序',
  `payTime` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of a_orders
-- ----------------------------

-- ----------------------------
-- Table structure for a_orders_goods
-- ----------------------------
DROP TABLE IF EXISTS `a_orders_goods`;
CREATE TABLE `a_orders_goods`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键;自动递增',
  `ordersId` int(0) NULL DEFAULT NULL COMMENT '订单Id',
  `goodsId` int(0) NULL DEFAULT NULL COMMENT '商品Id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名称',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标题',
  `num` int(0) NULL DEFAULT NULL COMMENT '数量',
  `price` decimal(20, 2) NULL DEFAULT NULL COMMENT '价格',
  `totalPrice` decimal(20, 2) NULL DEFAULT NULL COMMENT '总价格',
  `status` tinyint(0) NOT NULL COMMENT '状态:0:下单;1:已确认;2:已付款;3:已收款;4:已发货;5:已收货',
  `createTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updateTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `pubTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '发布时间:用来排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单_商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of a_orders_goods
-- ----------------------------

-- ----------------------------
-- Table structure for a_orders_history
-- ----------------------------
DROP TABLE IF EXISTS `a_orders_history`;
CREATE TABLE `a_orders_history`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键;自动递增',
  `ordersId` int(0) NULL DEFAULT NULL COMMENT '订单Id',
  `adminsId` int(0) NULL DEFAULT NULL COMMENT '管理员Id',
  `usersId` int(0) NULL DEFAULT NULL COMMENT '用户Id',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '内容',
  `status` tinyint(0) NOT NULL COMMENT '状态:0:下单;1:已确认;2:已付款;3:已收款;4:已发货;5:已收货',
  `createTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updateTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `pubTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '发布时间:用来排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单_历史表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of a_orders_history
-- ----------------------------

-- ----------------------------
-- Table structure for a_users
-- ----------------------------
DROP TABLE IF EXISTS `a_users`;
CREATE TABLE `a_users`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键;自动递增',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '账号',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `trueName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `balance` decimal(20, 2) NULL DEFAULT NULL COMMENT '余额',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话',
  `sex` tinyint(0) NULL DEFAULT NULL COMMENT '性别:0:无,1:男;2:女',
  `status` tinyint(0) NOT NULL COMMENT '状态:0:禁用,1:启用',
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '审核备注',
  `createTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updateTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `lastLoginTime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '上次登陆时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of a_users
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
