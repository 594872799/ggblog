/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : ggbolg

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 28/11/2019 18:03:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for gg_article
-- ----------------------------
DROP TABLE IF EXISTS `gg_article`;
CREATE TABLE `gg_article`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '正文',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gg_article_info
-- ----------------------------
DROP TABLE IF EXISTS `gg_article_info`;
CREATE TABLE `gg_article_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `article_id` int(11) NULL DEFAULT NULL COMMENT '文章id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章标题',
  `tag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '文章状态',
  `favor_num` int(11) NULL DEFAULT NULL COMMENT '喜欢的数量',
  `comment_num` int(11) NULL DEFAULT NULL COMMENT '评论的数量',
  `weigh` int(11) NULL DEFAULT NULL COMMENT '权重',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
