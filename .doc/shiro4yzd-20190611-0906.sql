/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.238
Source Server Version : 50725
Source Host           : 192.168.1.238:3306
Source Database       : shiro4yzd

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-06-11 09:06:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_permission`;
CREATE TABLE `tb_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(128) NOT NULL COMMENT '资源名称',
  `permission_code` varchar(128) NOT NULL COMMENT '权限标识代码',
  `sort_no` int(4) NOT NULL DEFAULT '0' COMMENT '排序',
  `visible_status` int(4) NOT NULL DEFAULT '0' COMMENT '是否可见:1=可见、2=隐藏',
  `enable_status` int(4) NOT NULL DEFAULT '0' COMMENT '是否启用：1=启用、2=停止启用',
  `permission_type` int(4) NOT NULL DEFAULT '0' COMMENT '资源类型：1=目录、2=菜单、3=功能、4=按钮',
  `url` varchar(500) DEFAULT '#' COMMENT '请求地址',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父类ID',
  `remark` varchar(1000) DEFAULT '' COMMENT '备注说明',
  `gmt_is_del` int(4) DEFAULT '0' COMMENT '是否删除：0=正常、1=已删',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='资源表';

-- ----------------------------
-- Records of tb_permission
-- ----------------------------
INSERT INTO `tb_permission` VALUES ('7', '系统管理', '', '6', '1', '1', '1', '#', '0', '', '0');
INSERT INTO `tb_permission` VALUES ('8', '解决方案', '', '1', '1', '1', '1', '#', '0', '1', '0');
INSERT INTO `tb_permission` VALUES ('9', '所有商品', '', '2', '1', '1', '1', '#', '0', '2', '0');
INSERT INTO `tb_permission` VALUES ('10', '3', '', '3', '1', '1', '1', '#', '0', '', '0');
INSERT INTO `tb_permission` VALUES ('11', '角色管理', '', '4', '1', '1', '2', '', '7', '3', '0');
INSERT INTO `tb_permission` VALUES ('12', '3', '', '3', '1', '1', '1', '#', '0', '3', '0');
INSERT INTO `tb_permission` VALUES ('13', '1', '1', '1', '1', '1', '1', '1', '8', '1', '0');
INSERT INTO `tb_permission` VALUES ('14', '5', '5', '5', '1', '1', '1', '#', '0', '5', '0');
INSERT INTO `tb_permission` VALUES ('15', '1', '1', '1', '1', '1', '2', '1', '0', '1', '0');
INSERT INTO `tb_permission` VALUES ('16', '测试', '', '1', '1', '1', '2', '1', '10', '1', '0');
INSERT INTO `tb_permission` VALUES ('17', '目录1', '1', '1', '1', '1', '1', '#', '0', '', '0');
INSERT INTO `tb_permission` VALUES ('18', '444', '3', '3', '1', '1', '1', '3', '8', '', '1');
INSERT INTO `tb_permission` VALUES ('19', '333', '3', '3', '1', '1', '2', '33', '18', '', '0');
INSERT INTO `tb_permission` VALUES ('20', '222', '22', '2', '1', '1', '2', '222', '19', '', '1');
INSERT INTO `tb_permission` VALUES ('21', '用户管理', '', '3', '1', '1', '2', '', '7', '3', '0');
INSERT INTO `tb_permission` VALUES ('22', '查看', '', '1', '1', '1', '3', '', '16', '1', '0');
INSERT INTO `tb_permission` VALUES ('23', '编辑', '2', '1', '1', '1', '3', '', '16', '', '0');
INSERT INTO `tb_permission` VALUES ('24', '删除', '', '1', '1', '1', '3', '', '16', '', '0');

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `role_name` varchar(30) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(1000) DEFAULT '' COMMENT '角色描述',
  `role_code` varchar(128) DEFAULT NULL COMMENT '角色编号:角色名称的汉语拼音',
  `gmt_create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `gmt_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `gmt_is_del` int(4) DEFAULT '0' COMMENT '是否删除：0=正常、1=已删',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('6', '6', 'string', '6', '2019-05-19 22:07:32', '2019-05-19 22:07:32', '1');
INSERT INTO `tb_role` VALUES ('7', '7', 'string', '7', '2019-05-19 22:05:46', '2019-05-19 22:05:46', '1');
INSERT INTO `tb_role` VALUES ('8', '8', '', '8', '2019-05-19 22:08:21', '2019-05-19 22:08:21', '1');
INSERT INTO `tb_role` VALUES ('9', '1', '', null, '2019-05-16 20:16:43', '2019-05-16 20:16:43', '1');
INSERT INTO `tb_role` VALUES ('10', '5', '', null, '2019-05-16 20:17:49', '2019-05-16 20:17:49', '1');
INSERT INTO `tb_role` VALUES ('11', 'string-new', 'string', 'string', '2019-05-20 01:35:42', '2019-05-20 01:35:42', '0');
INSERT INTO `tb_role` VALUES ('12', '1', '1', '1', '2019-05-16 22:34:35', '2019-05-16 22:34:35', '0');
INSERT INTO `tb_role` VALUES ('13', '11', '111', 'ddsdds', '2019-05-20 01:22:21', '2019-05-20 01:22:21', '0');
INSERT INTO `tb_role` VALUES ('14', '11', '111', '11', '2019-05-17 00:18:19', '2019-05-17 00:18:19', '0');
INSERT INTO `tb_role` VALUES ('15', '11', '111', '11', '2019-05-17 00:19:47', '2019-05-17 00:19:47', '0');
INSERT INTO `tb_role` VALUES ('16', '11', '111', '11', '2019-05-17 00:29:03', '2019-05-17 00:29:03', '0');
INSERT INTO `tb_role` VALUES ('17', '11', '111', '11', '2019-05-17 00:32:31', '2019-05-17 00:32:31', '0');
INSERT INTO `tb_role` VALUES ('18', '11', '111', '11', '2019-05-17 00:34:43', '2019-05-17 00:34:43', '0');
INSERT INTO `tb_role` VALUES ('19', 'saass', '111', '11', '2019-05-20 01:23:38', '2019-05-20 01:23:38', '1');
INSERT INTO `tb_role` VALUES ('20', '11', '111', '11', '2019-05-17 00:57:13', '2019-05-17 00:57:13', '1');
INSERT INTO `tb_role` VALUES ('21', '11', '11', '11', '2019-05-19 22:03:25', '2019-05-19 22:03:25', '1');
INSERT INTO `tb_role` VALUES ('22', '11', '11', '11', '2019-05-17 01:01:26', '2019-05-17 01:01:26', '0');
INSERT INTO `tb_role` VALUES ('23', '223', '', '223', '2019-05-19 20:17:38', '2019-05-19 20:17:38', '1');
INSERT INTO `tb_role` VALUES ('24', '555', '555', '55', '2019-05-19 21:14:00', '2019-05-19 21:14:00', '1');
INSERT INTO `tb_role` VALUES ('25', '', '', '', '2019-05-20 00:41:29', '2019-05-20 00:41:29', '1');
INSERT INTO `tb_role` VALUES ('26', '', '', '', '2019-05-20 00:41:39', '2019-05-20 00:41:39', '1');

-- ----------------------------
-- Table structure for tb_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_permission`;
CREATE TABLE `tb_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `permission_id` bigint(20) NOT NULL COMMENT '资源ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `version` varchar(50) NOT NULL COMMENT '数据版本：目前使用当前创建时间',
  `gmt_create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `gmt_is_del` int(4) DEFAULT '0' COMMENT '是否删除：0=正常、1=已删',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8 COMMENT='角色与资源关联表';

-- ----------------------------
-- Records of tb_role_permission
-- ----------------------------
INSERT INTO `tb_role_permission` VALUES ('20', '7', '18', '20190517133444', '2019-05-17 00:34:44', '0');
INSERT INTO `tb_role_permission` VALUES ('21', '11', '18', '20190517133444', '2019-05-17 00:34:44', '0');
INSERT INTO `tb_role_permission` VALUES ('22', '21', '18', '20190517133444', '2019-05-17 00:34:44', '0');
INSERT INTO `tb_role_permission` VALUES ('23', '8', '18', '20190517133444', '2019-05-17 00:34:44', '0');
INSERT INTO `tb_role_permission` VALUES ('24', '13', '18', '20190517133444', '2019-05-17 00:34:44', '0');
INSERT INTO `tb_role_permission` VALUES ('25', '7', '19', '20190517135627', '2019-05-17 00:56:27', '1');
INSERT INTO `tb_role_permission` VALUES ('26', '11', '19', '20190517135627', '2019-05-17 00:56:27', '1');
INSERT INTO `tb_role_permission` VALUES ('27', '21', '19', '20190517135627', '2019-05-17 00:56:27', '1');
INSERT INTO `tb_role_permission` VALUES ('28', '8', '19', '20190517135627', '2019-05-17 00:56:27', '1');
INSERT INTO `tb_role_permission` VALUES ('29', '13', '19', '20190517135627', '2019-05-17 00:56:27', '1');
INSERT INTO `tb_role_permission` VALUES ('30', '7', '20', '20190517135713', '2019-05-17 00:57:13', '1');
INSERT INTO `tb_role_permission` VALUES ('31', '11', '20', '20190517135713', '2019-05-17 00:57:13', '1');
INSERT INTO `tb_role_permission` VALUES ('32', '21', '20', '20190517135713', '2019-05-17 00:57:13', '1');
INSERT INTO `tb_role_permission` VALUES ('33', '8', '20', '20190517135713', '2019-05-17 00:57:13', '1');
INSERT INTO `tb_role_permission` VALUES ('34', '13', '20', '20190517135713', '2019-05-17 00:57:13', '1');
INSERT INTO `tb_role_permission` VALUES ('35', '7', '21', '20190517140114', '2019-05-17 01:01:14', '1');
INSERT INTO `tb_role_permission` VALUES ('36', '11', '21', '20190517140114', '2019-05-17 01:01:14', '1');
INSERT INTO `tb_role_permission` VALUES ('37', '21', '21', '20190517140114', '2019-05-17 01:01:14', '1');
INSERT INTO `tb_role_permission` VALUES ('38', '8', '21', '20190517140114', '2019-05-17 01:01:14', '1');
INSERT INTO `tb_role_permission` VALUES ('39', '13', '21', '20190517140114', '2019-05-17 01:01:14', '1');
INSERT INTO `tb_role_permission` VALUES ('40', '7', '22', '20190517140126', '2019-05-17 01:01:26', '0');
INSERT INTO `tb_role_permission` VALUES ('41', '11', '22', '20190517140126', '2019-05-17 01:01:26', '0');
INSERT INTO `tb_role_permission` VALUES ('42', '21', '22', '20190517140126', '2019-05-17 01:01:26', '0');
INSERT INTO `tb_role_permission` VALUES ('43', '8', '22', '20190517140126', '2019-05-17 01:01:26', '0');
INSERT INTO `tb_role_permission` VALUES ('44', '13', '22', '20190517140126', '2019-05-17 01:01:26', '0');
INSERT INTO `tb_role_permission` VALUES ('45', '7', '23', '20190520091738', '2019-05-19 20:17:38', '1');
INSERT INTO `tb_role_permission` VALUES ('46', '11', '23', '20190520091738', '2019-05-19 20:17:38', '1');
INSERT INTO `tb_role_permission` VALUES ('47', '21', '23', '20190520091738', '2019-05-19 20:17:38', '1');
INSERT INTO `tb_role_permission` VALUES ('48', '7', '24', '20190520101359', '2019-05-19 21:14:00', '1');
INSERT INTO `tb_role_permission` VALUES ('49', '21', '24', '20190520101359', '2019-05-19 21:14:00', '1');
INSERT INTO `tb_role_permission` VALUES ('50', '7', '21', '20190520110311', '2019-05-19 22:03:12', '1');
INSERT INTO `tb_role_permission` VALUES ('51', '11', '21', '20190520110311', '2019-05-19 22:03:12', '1');
INSERT INTO `tb_role_permission` VALUES ('52', '21', '21', '20190520110311', '2019-05-19 22:03:12', '1');
INSERT INTO `tb_role_permission` VALUES ('53', '12', '8', '20190520110820', '2019-05-19 22:08:21', '1');
INSERT INTO `tb_role_permission` VALUES ('54', '14', '8', '20190520110820', '2019-05-19 22:08:21', '1');
INSERT INTO `tb_role_permission` VALUES ('55', '15', '8', '20190520110820', '2019-05-19 22:08:21', '1');
INSERT INTO `tb_role_permission` VALUES ('56', '17', '8', '20190520110820', '2019-05-19 22:08:21', '1');
INSERT INTO `tb_role_permission` VALUES ('57', '19', '8', '20190520110820', '2019-05-19 22:08:21', '1');
INSERT INTO `tb_role_permission` VALUES ('58', '15', '11', '20190520114157', '2019-05-19 22:41:57', '1');
INSERT INTO `tb_role_permission` VALUES ('59', '15', '11', '20190520140316', '2019-05-20 01:03:16', '1');
INSERT INTO `tb_role_permission` VALUES ('60', '7', '19', '20190520142312', '2019-05-20 01:23:12', '1');
INSERT INTO `tb_role_permission` VALUES ('61', '11', '19', '20190520142312', '2019-05-20 01:23:12', '1');
INSERT INTO `tb_role_permission` VALUES ('62', '21', '19', '20190520142312', '2019-05-20 01:23:12', '1');
INSERT INTO `tb_role_permission` VALUES ('63', '8', '19', '20190520142312', '2019-05-20 01:23:12', '1');
INSERT INTO `tb_role_permission` VALUES ('64', '13', '19', '20190520142312', '2019-05-20 01:23:12', '1');
INSERT INTO `tb_role_permission` VALUES ('65', '7', '19', '20190520142326', '2019-05-20 01:23:26', '1');
INSERT INTO `tb_role_permission` VALUES ('66', '11', '19', '20190520142326', '2019-05-20 01:23:26', '1');
INSERT INTO `tb_role_permission` VALUES ('67', '21', '19', '20190520142326', '2019-05-20 01:23:26', '1');
INSERT INTO `tb_role_permission` VALUES ('68', '8', '19', '20190520142326', '2019-05-20 01:23:26', '1');
INSERT INTO `tb_role_permission` VALUES ('69', '13', '19', '20190520142326', '2019-05-20 01:23:26', '1');
INSERT INTO `tb_role_permission` VALUES ('70', '10', '19', '20190520142326', '2019-05-20 01:23:26', '1');
INSERT INTO `tb_role_permission` VALUES ('71', '16', '19', '20190520142326', '2019-05-20 01:23:26', '1');
INSERT INTO `tb_role_permission` VALUES ('72', '22', '19', '20190520142326', '2019-05-20 01:23:26', '1');
INSERT INTO `tb_role_permission` VALUES ('73', '23', '19', '20190520142326', '2019-05-20 01:23:26', '1');
INSERT INTO `tb_role_permission` VALUES ('74', '24', '19', '20190520142326', '2019-05-20 01:23:26', '1');
INSERT INTO `tb_role_permission` VALUES ('75', '7', '19', '20190520142337', '2019-05-20 01:23:38', '1');
INSERT INTO `tb_role_permission` VALUES ('76', '11', '19', '20190520142337', '2019-05-20 01:23:38', '1');
INSERT INTO `tb_role_permission` VALUES ('77', '21', '19', '20190520142337', '2019-05-20 01:23:38', '1');
INSERT INTO `tb_role_permission` VALUES ('78', '8', '19', '20190520142337', '2019-05-20 01:23:38', '1');
INSERT INTO `tb_role_permission` VALUES ('79', '13', '19', '20190520142337', '2019-05-20 01:23:38', '1');
INSERT INTO `tb_role_permission` VALUES ('80', '10', '19', '20190520142337', '2019-05-20 01:23:38', '1');
INSERT INTO `tb_role_permission` VALUES ('81', '16', '19', '20190520142337', '2019-05-20 01:23:38', '1');
INSERT INTO `tb_role_permission` VALUES ('82', '22', '19', '20190520142337', '2019-05-20 01:23:38', '1');
INSERT INTO `tb_role_permission` VALUES ('83', '23', '19', '20190520142337', '2019-05-20 01:23:38', '1');
INSERT INTO `tb_role_permission` VALUES ('84', '24', '19', '20190520142337', '2019-05-20 01:23:38', '1');
INSERT INTO `tb_role_permission` VALUES ('85', '12', '19', '20190520142337', '2019-05-20 01:23:38', '1');
INSERT INTO `tb_role_permission` VALUES ('86', '12', '11', '20190520143541', '2019-05-20 01:35:42', '0');
INSERT INTO `tb_role_permission` VALUES ('87', '15', '11', '20190520143541', '2019-05-20 01:35:42', '0');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(50) DEFAULT '' COMMENT '用户名',
  `mobile` varchar(15) DEFAULT '' COMMENT '手机号',
  `email` varchar(50) DEFAULT '' COMMENT '邮箱',
  `password` varchar(50) DEFAULT '' COMMENT '密码',
  `insert_uid` int(11) DEFAULT NULL COMMENT '添加该用户的用户id',
  `job_status` int(4) DEFAULT '0' COMMENT '是否在职（0：正常；1，离职）',
  `version` int(10) DEFAULT '0' COMMENT '更新版本',
  `gmt_create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `gmt_update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `gmt_is_del` int(4) DEFAULT '0' COMMENT '是否删除：0=正常、1=已删',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('33', 'yzd', '15012345678', '', '123456', '0', '0', '1', '2019-06-06 03:05:35', '2019-06-06 03:05:35', '0');
INSERT INTO `tb_user` VALUES ('34', '1', '122', '', '654321', null, '0', '1', '2019-05-22 04:15:09', '2019-05-22 04:15:09', '0');
INSERT INTO `tb_user` VALUES ('35', '1', '35', '', '654321', null, '0', '1', '2019-05-22 04:15:18', '2019-05-22 04:15:18', '0');
INSERT INTO `tb_user` VALUES ('36', '1', '1', '1', '1', null, '0', '1', '2019-05-21 04:22:26', '2019-05-21 04:22:26', '1');

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `version` varchar(50) NOT NULL COMMENT '数据版本：目前使用当前创建时间',
  `gmt_create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `gmt_is_del` int(4) DEFAULT '0' COMMENT '是否删除：0=正常、1=已删',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8 COMMENT='用户与角色关联表';

-- ----------------------------
-- Records of tb_user_role
-- ----------------------------
INSERT INTO `tb_user_role` VALUES ('88', '36', '11', '20190521172239', '2019-05-21 04:22:39', '1');
INSERT INTO `tb_user_role` VALUES ('89', '33', '11', '20190522163558', '2019-05-22 03:35:58', '1');
INSERT INTO `tb_user_role` VALUES ('90', '34', '15', '20190522163634', '2019-05-22 03:36:35', '1');
INSERT INTO `tb_user_role` VALUES ('91', '35', '18', '20190522165209', '2019-05-22 03:52:10', '1');
INSERT INTO `tb_user_role` VALUES ('92', '33', '15', '20190522165314', '2019-05-22 03:53:14', '1');
INSERT INTO `tb_user_role` VALUES ('93', '33', '11', '20190522165421', '2019-05-22 03:54:21', '1');
INSERT INTO `tb_user_role` VALUES ('94', '34', '12', '20190522170218', '2019-05-22 04:02:19', '1');
INSERT INTO `tb_user_role` VALUES ('95', '34', '17', '20190522171509', '2019-05-22 04:15:09', '0');
INSERT INTO `tb_user_role` VALUES ('96', '35', '11', '20190522171517', '2019-05-22 04:15:18', '0');
INSERT INTO `tb_user_role` VALUES ('97', '33', '12', '20190606160522', '2019-06-06 03:05:22', '1');
INSERT INTO `tb_user_role` VALUES ('98', '33', '11', '20190606160534', '2019-06-06 03:05:35', '0');
