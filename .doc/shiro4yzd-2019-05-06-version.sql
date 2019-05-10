/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.238
Source Server Version : 50725
Source Host           : 192.168.1.238:3306
Source Database       : shiro4yzd

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-05-06 10:09:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT '' COMMENT '用户名',
  `mobile` varchar(15) DEFAULT '' COMMENT '手机号',
  `email` varchar(50) DEFAULT '' COMMENT '邮箱',
  `password` varchar(50) DEFAULT '' COMMENT '密码',
  `insert_uid` int(11) DEFAULT NULL COMMENT '添加该用户的用户id',
  `insert_time` datetime DEFAULT NULL COMMENT '注册时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '是否删除（0：正常；1：已删）',
  `is_job` tinyint(1) DEFAULT '0' COMMENT '是否在职（0：正常；1，离职）',
  `mcode` varchar(10) DEFAULT '' COMMENT '短信验证码',
  `send_time` datetime DEFAULT NULL COMMENT '短信发送时间',
  `version` int(10) DEFAULT '0' COMMENT '更新版本',
  PRIMARY KEY (`id`),
  KEY `name` (`username`) USING BTREE,
  KEY `id` (`id`) USING BTREE,
  KEY `mobile` (`mobile`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户表';

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('32', 'yzd', '15012345678', '', '123456', '0', '2019-05-05 03:49:51', '2019-05-05 03:49:51', '0', '1', '', '2019-05-05 03:49:51', '0');
-- ----------------------------
-- Table structure for tb_permission
-- ----------------------------
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='资源表';
