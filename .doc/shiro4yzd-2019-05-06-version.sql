/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.238
Source Server Version : 50725
Source Host           : 192.168.1.238:3306
Source Database       : shiro4yzd

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-05-21 16:47:15
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
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COMMENT='用户表';

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
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8 COMMENT='用户与角色关联表';
