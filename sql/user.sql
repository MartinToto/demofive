/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50624
 Source Host           : localhost:3306
 Source Schema         : blink

 Target Server Type    : MySQL
 Target Server Version : 50624
 File Encoding         : 65001

 Date: 04/04/2019 20:36:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户邮箱',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户昵称',
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户身份',
  `status` int(1) NOT NULL COMMENT '用户状态',
  `regTime` datetime(0) DEFAULT NULL COMMENT '注册时间',
  `regIp` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '注册IP',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'xxx', 'xxxxx', 'xxxxx', 'root', 0, '2017-03-28 09:40:31', '127.0.0.1');
INSERT INTO `user` VALUES (2, '123123@163.com', '123321', '张三', 'root', 1, '2019-03-21 23:03:05', '127.0.0.1');
INSERT INTO `user` VALUES (3, '123432@163.com', '2134322', '王五', 'root', 1, NULL, '192.168.2.123');
INSERT INTO `user` VALUES (10, '12342232@163.com', '2134322', '赵六', 'root', 1, NULL, '192.168.2.123');
INSERT INTO `user` VALUES (11, '1234dd2232@163.com', '2134322', '钱大', 'root', 1, NULL, '192.168.2.123');
INSERT INTO `user` VALUES (12, '1234wdd2232@163.com', '2134322', '钱大1', 'root', 1, NULL, '192.168.2.123');
INSERT INTO `user` VALUES (13, '1234ewdd2232@163.com', '2134322', '钱大2', 'root', 1, NULL, '192.168.2.123');
INSERT INTO `user` VALUES (14, '12384ewdd2232@163.com', '2134322', '钱大3', 'root', 1, NULL, '192.168.2.123');
INSERT INTO `user` VALUES (15, '123ewdd2232@163.com', '2134322', '钱大4', 'root', 1, NULL, '192.168.2.123');

SET FOREIGN_KEY_CHECKS = 1;
