/*
Navicat MySQL Data Transfer

Source Server         : 车巧飞--头条
Source Server Version : 50173
Source Host           : 120.27.214.29:3306
Source Database       : yc

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2017-05-17 19:36:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `phone` varchar(255) NOT NULL,
  `created` int(11) DEFAULT '0',
  `updated` int(11) DEFAULT '0',
  `deleted` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '8d423d5d06259f85af89054728f216c9', 'admin', '', '1439177754', '1439177754', '0');
INSERT INTO `admin` VALUES ('2', 'cky', 'e10adc3949ba59abbe56e057f20f883e', null, '13422323324', '1490842306', '0', '0');
INSERT INTO `admin` VALUES ('3', 'OPPO', '10fb6faf0bff4e694eaabb2d692b8d97', null, '', '1491389362', '0', '1');

-- ----------------------------
-- Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `site_id` bigint(20) NOT NULL,
  `wid` bigint(20) NOT NULL,
  `gid` bigint(20) NOT NULL,
  `title` varchar(255) NOT NULL COMMENT '文章标题',
  `author` varchar(255) NOT NULL COMMENT '作者',
  `abstracts` text NOT NULL COMMENT '摘要',
  `reply` int(11) NOT NULL DEFAULT '0' COMMENT '回复数',
  `pre_reply` int(11) NOT NULL DEFAULT '0' COMMENT '上一次回复数',
  `seply_status` int(11) NOT NULL DEFAULT '0' COMMENT '回复数状态 0为否 1为是',
  `brand_id` int(11) NOT NULL DEFAULT '0' COMMENT '品牌ID,与brand表ID对应,0表示未定义',
  `positive` int(11) NOT NULL DEFAULT '2' COMMENT '正负面 0为负 1为正 2未标识',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '文章状态 0 未处理 1处理中 2 处理完成',
  `url` varchar(500) NOT NULL COMMENT '原文URL',
  `share_url` varchar(500) NOT NULL COMMENT '分享URL',
  `release_time` int(11) NOT NULL COMMENT '发布时间',
  `created` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `deleted` int(11) NOT NULL DEFAULT '0',
  `keyword` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `site_id` (`site_id`),
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`site_id`) REFERENCES `site_desc` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章列表';

-- ----------------------------
-- Records of article
-- ----------------------------

-- ----------------------------
-- Table structure for `article_comment`
-- ----------------------------
DROP TABLE IF EXISTS `article_comment`;
CREATE TABLE `article_comment` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` bigint(20) NOT NULL,
  `comment_content` varchar(255) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1',
  `deleted` int(11) NOT NULL DEFAULT '0',
  `created` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `brand`
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '品牌名称',
  `created` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `deleted` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='品牌表';

-- ----------------------------
-- Records of brand
-- ----------------------------
INSERT INTO `brand` VALUES ('1', '小米', '1489398175', '0', '0');
INSERT INTO `brand` VALUES ('3', '魅族', '1489563441', '1489563451', '0');
INSERT INTO `brand` VALUES ('4', '华为', '1489758141', '0', '0');
INSERT INTO `brand` VALUES ('5', 'Apple', '1489772260', '0', '0');
INSERT INTO `brand` VALUES ('6', 'vivo', '1489772364', '1489916670', '0');
INSERT INTO `brand` VALUES ('7', 'OPPO', '1489926404', '0', '0');
INSERT INTO `brand` VALUES ('8', '三星', '1490162255', '0', '0');

-- ----------------------------
-- Table structure for `collect`
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task` varchar(255) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `url` varchar(255) NOT NULL COMMENT '链接',
  `release_time` int(11) NOT NULL DEFAULT '0' COMMENT '发布时间',
  `type` int(11) NOT NULL DEFAULT '1' COMMENT '来源 1=网页 2=新闻',
  `search_time` int(11) NOT NULL DEFAULT '0' COMMENT '搜索时间',
  `platform` varchar(255) NOT NULL,
  `brand` varchar(255) NOT NULL,
  `record_num` int(11) NOT NULL DEFAULT '0' COMMENT '返回记录数',
  `status` int(1) NOT NULL DEFAULT '0',
  `created` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `deleted` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16928 DEFAULT CHARSET=utf8 COMMENT='搜索记录表';

-- ----------------------------
-- Records of collect
-- ----------------------------

-- ----------------------------
-- Table structure for `event_log`
-- ----------------------------
DROP TABLE IF EXISTS `event_log`;
CREATE TABLE `event_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `event` varchar(255) NOT NULL,
  `ip` varchar(255) NOT NULL,
  `created` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `deleted` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7689 DEFAULT CHARSET=utf8 COMMENT='日志表';

-- ----------------------------
-- Records of event_log
-- ----------------------------

-- ----------------------------
-- Table structure for `excel`
-- ----------------------------
DROP TABLE IF EXISTS `excel`;
CREATE TABLE `excel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task` varchar(255) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `url` varchar(255) NOT NULL COMMENT '链接',
  `release_time` int(11) NOT NULL DEFAULT '0' COMMENT '发布时间',
  `search_time` int(11) NOT NULL DEFAULT '0' COMMENT '最新搜索时间',
  `platform` varchar(255) NOT NULL,
  `brand` varchar(255) NOT NULL,
  `created` int(11) NOT NULL DEFAULT '0',
  `updated` int(11) NOT NULL DEFAULT '0',
  `deleted` int(11) NOT NULL DEFAULT '0',
  `valid` int(11) DEFAULT '1',
  `baidu_count` int(11) DEFAULT NULL,
  `news_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7870 DEFAULT CHARSET=utf8 COMMENT='导入链接表';

-- ----------------------------
-- Records of excel
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_brand`
-- ----------------------------
DROP TABLE IF EXISTS `hai_brand`;
CREATE TABLE `hai_brand` (
  `brand_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `brand_name` varchar(60) NOT NULL DEFAULT '' COMMENT '品牌名称',
  `brand_logo` varchar(500) NOT NULL DEFAULT '' COMMENT '品牌logo',
  `brand_desc` text NOT NULL COMMENT '品牌描述',
  `site_url` varchar(255) NOT NULL DEFAULT '' COMMENT '连接地址',
  `sort_order` smallint(3) unsigned NOT NULL DEFAULT '50' COMMENT '排序',
  `is_show` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否显示',
  PRIMARY KEY (`brand_id`),
  KEY `is_show` (`is_show`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_brand
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_category`
-- ----------------------------
DROP TABLE IF EXISTS `hai_category`;
CREATE TABLE `hai_category` (
  `cat_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '分类编号',
  `cat_name` varchar(90) NOT NULL DEFAULT '' COMMENT '分类名称',
  `keywords` varchar(255) NOT NULL DEFAULT '' COMMENT '关键字',
  `cat_desc` varchar(255) NOT NULL DEFAULT '' COMMENT '分类简介',
  `parent_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '所属上级分类',
  `sort_order` smallint(1) unsigned NOT NULL DEFAULT '0' COMMENT '排序',
  `is_show` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否显示',
  `brand_id` text COMMENT '品牌编号',
  `category_url` varchar(200) DEFAULT NULL COMMENT '分类链接地址',
  PRIMARY KEY (`cat_id`),
  KEY `parent_id` (`parent_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_category
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_goods`
-- ----------------------------
DROP TABLE IF EXISTS `hai_goods`;
CREATE TABLE `hai_goods` (
  `goods_id` bigint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品编号',
  `cat_id` int(5) unsigned NOT NULL DEFAULT '0' COMMENT '分类编号',
  `goods_sn` varchar(60) NOT NULL DEFAULT '' COMMENT '商品编码',
  `goods_name` varchar(120) NOT NULL DEFAULT '' COMMENT '商品名称',
  `brand_id` int(5) unsigned NOT NULL DEFAULT '0' COMMENT '品牌编号',
  `shop_price` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '商品价格',
  `keywords` varchar(255) NOT NULL DEFAULT '' COMMENT '关键字',
  `goods_brief` text NOT NULL COMMENT '商品简介',
  `goods_desc` text NOT NULL COMMENT '商品详情',
  `act_desc` varchar(100) DEFAULT NULL COMMENT '标题旁边的标注',
  `goods_thumb` varchar(255) NOT NULL DEFAULT '' COMMENT '缩略图',
  `goods_img` varchar(255) NOT NULL DEFAULT '' COMMENT '商品图片',
  `original_img` varchar(255) NOT NULL DEFAULT '' COMMENT '商品原图',
  `is_on_sale` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否出售中',
  `add_time` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '添加时间',
  `sort_order` smallint(4) unsigned NOT NULL DEFAULT '100' COMMENT '排序',
  `last_update` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '最后更新时间',
  `exchangeRate` decimal(10,4) DEFAULT '0.0000' COMMENT '兑换率',
  `profit` decimal(10,4) DEFAULT '0.0000' COMMENT '利益',
  `shipping` decimal(10,4) DEFAULT '0.0000' COMMENT '运费',
  `profitType` int(2) DEFAULT '0' COMMENT '0:乘以折扣，1：加上费用',
  `currency` varchar(20) DEFAULT NULL COMMENT '货币类型',
  `goods_url` varchar(500) DEFAULT NULL COMMENT '网上抓取的网址',
  PRIMARY KEY (`goods_id`),
  KEY `goods_sn` (`goods_sn`),
  KEY `cat_id` (`cat_id`),
  KEY `last_update` (`last_update`),
  KEY `brand_id` (`brand_id`),
  KEY `sort_order` (`sort_order`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_goods
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_goods_attr`
-- ----------------------------
DROP TABLE IF EXISTS `hai_goods_attr`;
CREATE TABLE `hai_goods_attr` (
  `goods_attr_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '属性编号',
  `goods_id` mediumint(8) unsigned NOT NULL DEFAULT '0' COMMENT '商品编号',
  `attr_value` text NOT NULL COMMENT '属性名称',
  `attr_price` varchar(255) NOT NULL DEFAULT '' COMMENT '属性价格',
  `attr_type` varchar(255) NOT NULL DEFAULT '' COMMENT '属性类型',
  PRIMARY KEY (`goods_attr_id`),
  KEY `goods_id` (`goods_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_goods_attr
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_goods_gallery`
-- ----------------------------
DROP TABLE IF EXISTS `hai_goods_gallery`;
CREATE TABLE `hai_goods_gallery` (
  `img_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '商品编号',
  `img_url` varchar(255) NOT NULL DEFAULT '' COMMENT '在图地址',
  `img_desc` varchar(255) NOT NULL DEFAULT '' COMMENT '图片描述',
  `thumb_url` varchar(255) NOT NULL DEFAULT '' COMMENT '缩略图地址',
  `img_original` varchar(255) NOT NULL DEFAULT '' COMMENT '原图地址',
  PRIMARY KEY (`img_id`),
  KEY `goods_id` (`goods_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_goods_gallery
-- ----------------------------
