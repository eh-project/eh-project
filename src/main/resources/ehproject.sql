/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50631
Source Host           : 127.0.0.1:3306
Source Database       : ehproject

Target Server Type    : MYSQL
Target Server Version : 50631
File Encoding         : 65001

Date: 2016-11-11 17:49:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `hai_account_log`
-- ----------------------------
DROP TABLE IF EXISTS `hai_account_log`;
CREATE TABLE `hai_account_log` (
  `log_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` mediumint(8) unsigned NOT NULL,
  `user_money` decimal(10,2) NOT NULL,
  `frozen_money` decimal(10,2) NOT NULL,
  `rank_points` mediumint(9) NOT NULL,
  `pay_points` mediumint(9) NOT NULL,
  `change_time` int(10) unsigned NOT NULL,
  `change_desc` varchar(255) NOT NULL,
  `change_type` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`log_id`),
  KEY `user_id` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_account_log
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_ad`
-- ----------------------------
DROP TABLE IF EXISTS `hai_ad`;
CREATE TABLE `hai_ad` (
  `ad_id` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `position_id` smallint(5) unsigned NOT NULL DEFAULT '0',
  `media_type` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `ad_name` varchar(60) NOT NULL DEFAULT '',
  `ad_link` varchar(255) NOT NULL DEFAULT '',
  `ad_code` text NOT NULL,
  `link_man` varchar(60) NOT NULL DEFAULT '',
  `link_email` varchar(60) NOT NULL DEFAULT '',
  `link_phone` varchar(60) NOT NULL DEFAULT '',
  `click_count` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `enabled` tinyint(3) unsigned NOT NULL DEFAULT '1',
  `store_id` int(11) NOT NULL DEFAULT '0',
  `start_time` date DEFAULT NULL,
  `end_time` date DEFAULT NULL,
  `nav_id` int(11) DEFAULT NULL COMMENT '用于关联到导航栏下面的广告位',
  `sort` int(2) DEFAULT '0',
  `is_mobile` smallint(1) DEFAULT '0' COMMENT '是否手机使用',
  PRIMARY KEY (`ad_id`),
  KEY `position_id` (`position_id`),
  KEY `enabled` (`enabled`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_ad
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_admin_action`
-- ----------------------------
DROP TABLE IF EXISTS `hai_admin_action`;
CREATE TABLE `hai_admin_action` (
  `action_id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `parent_id` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `action_code` varchar(20) NOT NULL DEFAULT '',
  `relevance` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`action_id`),
  KEY `parent_id` (`parent_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_admin_action
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_admin_log`
-- ----------------------------
DROP TABLE IF EXISTS `hai_admin_log`;
CREATE TABLE `hai_admin_log` (
  `log_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `log_time` int(10) unsigned NOT NULL DEFAULT '0',
  `user_id` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `log_info` varchar(255) NOT NULL DEFAULT '',
  `ip_address` varchar(15) NOT NULL DEFAULT '',
  PRIMARY KEY (`log_id`),
  KEY `log_time` (`log_time`),
  KEY `user_id` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_admin_log
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_admin_message`
-- ----------------------------
DROP TABLE IF EXISTS `hai_admin_message`;
CREATE TABLE `hai_admin_message` (
  `message_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `sender_id` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `receiver_id` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `sent_time` int(11) unsigned NOT NULL DEFAULT '0',
  `read_time` int(11) unsigned NOT NULL DEFAULT '0',
  `readed` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `title` varchar(150) NOT NULL DEFAULT '',
  `message` text NOT NULL,
  PRIMARY KEY (`message_id`),
  KEY `sender_id` (`sender_id`,`receiver_id`),
  KEY `receiver_id` (`receiver_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_admin_message
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_admin_user`
-- ----------------------------
DROP TABLE IF EXISTS `hai_admin_user`;
CREATE TABLE `hai_admin_user` (
  `admin_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(60) NOT NULL DEFAULT '',
  `email` varchar(60) NOT NULL DEFAULT '',
  `password` varchar(32) NOT NULL DEFAULT '',
  `ec_salt` varchar(10) DEFAULT NULL,
  `add_time` int(11) DEFAULT '0',
  `last_login` int(11) DEFAULT '0',
  `last_ip` varchar(15) DEFAULT '',
  `action_list` text,
  `nav_list` text,
  `lang_type` varchar(50) DEFAULT '',
  `agency_id` smallint(5) unsigned DEFAULT NULL,
  `business_id` smallint(5) unsigned DEFAULT '0',
  `todolist` longtext,
  `store_id` int(10) DEFAULT '0',
  `project_folder` varchar(20) DEFAULT NULL COMMENT '使用文件夹',
  PRIMARY KEY (`admin_id`),
  KEY `user_name` (`user_name`),
  KEY `agency_id` (`agency_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_admin_user
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_adsense`
-- ----------------------------
DROP TABLE IF EXISTS `hai_adsense`;
CREATE TABLE `hai_adsense` (
  `from_ad` smallint(5) NOT NULL DEFAULT '0',
  `referer` varchar(255) NOT NULL DEFAULT '',
  `clicks` int(10) unsigned NOT NULL DEFAULT '0',
  KEY `from_ad` (`from_ad`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_adsense
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_ad_custom`
-- ----------------------------
DROP TABLE IF EXISTS `hai_ad_custom`;
CREATE TABLE `hai_ad_custom` (
  `ad_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `ad_type` tinyint(1) unsigned NOT NULL DEFAULT '1',
  `ad_name` varchar(60) DEFAULT NULL,
  `add_time` int(10) unsigned NOT NULL DEFAULT '0',
  `content` mediumtext,
  `url` varchar(255) DEFAULT NULL,
  `ad_status` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `store_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ad_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_ad_custom
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_ad_position`
-- ----------------------------
DROP TABLE IF EXISTS `hai_ad_position`;
CREATE TABLE `hai_ad_position` (
  `position_id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `position_code` varchar(20) DEFAULT NULL COMMENT '识别码',
  `position_name` varchar(60) NOT NULL DEFAULT '',
  `ad_width` smallint(5) unsigned NOT NULL DEFAULT '0',
  `ad_height` smallint(5) unsigned NOT NULL DEFAULT '0',
  `position_desc` varchar(255) NOT NULL DEFAULT '',
  `position_style` text,
  `store_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`position_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_ad_position
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_affiliate_log`
-- ----------------------------
DROP TABLE IF EXISTS `hai_affiliate_log`;
CREATE TABLE `hai_affiliate_log` (
  `log_id` mediumint(8) NOT NULL AUTO_INCREMENT,
  `order_id` mediumint(8) NOT NULL,
  `time` int(10) NOT NULL,
  `user_id` mediumint(8) NOT NULL,
  `user_name` varchar(60) DEFAULT NULL,
  `money` decimal(10,2) NOT NULL DEFAULT '0.00',
  `point` int(10) NOT NULL DEFAULT '0',
  `separate_type` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`log_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_affiliate_log
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_agency`
-- ----------------------------
DROP TABLE IF EXISTS `hai_agency`;
CREATE TABLE `hai_agency` (
  `agency_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `agency_name` varchar(255) NOT NULL,
  `agency_desc` text NOT NULL,
  `legal_person` varchar(20) DEFAULT NULL COMMENT '法人',
  `linkman` varchar(20) DEFAULT NULL COMMENT '联系人',
  `tel` varchar(15) DEFAULT NULL COMMENT '电话',
  `fax` varchar(15) DEFAULT NULL COMMENT '传真',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `address` varchar(200) DEFAULT NULL COMMENT '联系地址',
  `longitude` decimal(15,6) DEFAULT NULL COMMENT '经度',
  `latitude` decimal(15,6) DEFAULT NULL COMMENT '纬度',
  `void` enum('1','0') DEFAULT '1',
  `logo` varchar(200) DEFAULT NULL COMMENT 'logo',
  `website` varchar(100) DEFAULT NULL COMMENT '网址',
  `store_id` int(11) DEFAULT NULL,
  `pinyin` varchar(200) DEFAULT NULL COMMENT '拼音',
  `country` smallint(2) DEFAULT NULL,
  `province` smallint(2) DEFAULT NULL,
  `city` smallint(2) DEFAULT NULL,
  `county` smallint(2) DEFAULT NULL,
  `district` smallint(2) DEFAULT NULL,
  `street` smallint(2) DEFAULT NULL,
  PRIMARY KEY (`agency_id`),
  KEY `agency_name` (`agency_name`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of hai_agency
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_alipay_result`
-- ----------------------------
DROP TABLE IF EXISTS `hai_alipay_result`;
CREATE TABLE `hai_alipay_result` (
  `alipay_id` int(11) NOT NULL AUTO_INCREMENT,
  `alipay_type` varchar(20) DEFAULT NULL COMMENT 'notify,return',
  `out_trade_no` varchar(50) DEFAULT NULL COMMENT '商户订单号',
  `trade_no` varchar(50) DEFAULT NULL COMMENT '支付宝交易号',
  `trade_status` varchar(50) DEFAULT NULL COMMENT '交易状态',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `body` text,
  `buyer_email` varchar(50) DEFAULT NULL,
  `buyer_id` varchar(30) DEFAULT NULL,
  `discount` decimal(20,4) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_logistics_modify` datetime DEFAULT NULL,
  `gmt_payment` datetime DEFAULT NULL,
  `is_success` varchar(10) DEFAULT NULL,
  `is_total_fee_adjust` varchar(10) DEFAULT NULL,
  `logistics_fee` decimal(20,4) DEFAULT NULL,
  `logistics_payment` varchar(20) DEFAULT NULL,
  `logistics_type` varchar(20) DEFAULT NULL,
  `notify_id` varchar(150) DEFAULT NULL,
  `notify_time` datetime DEFAULT NULL,
  `notify_type` varchar(20) DEFAULT NULL,
  `payment_type` varchar(20) DEFAULT NULL,
  `price` decimal(20,4) DEFAULT NULL,
  `quantity` int(10) DEFAULT NULL,
  `receive_address` varchar(200) DEFAULT NULL,
  `receive_mobile` varchar(20) DEFAULT NULL,
  `receive_name` varchar(50) DEFAULT NULL,
  `seller_actions` varchar(20) DEFAULT NULL,
  `seller_email` varchar(50) DEFAULT NULL,
  `seller_id` varchar(30) DEFAULT NULL,
  `subject` varchar(200) DEFAULT NULL,
  `total_fee` decimal(20,4) DEFAULT NULL,
  `use_coupon` varchar(10) DEFAULT NULL,
  `sign` varchar(50) DEFAULT NULL,
  `sign_type` varchar(10) DEFAULT NULL,
  `_URL_` varchar(100) DEFAULT NULL,
  `remark` text,
  PRIMARY KEY (`alipay_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_alipay_result
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_area_region`
-- ----------------------------
DROP TABLE IF EXISTS `hai_area_region`;
CREATE TABLE `hai_area_region` (
  `shipping_area_id` smallint(5) unsigned NOT NULL DEFAULT '0',
  `region_id` smallint(5) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`shipping_area_id`,`region_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_area_region
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_article`
-- ----------------------------
DROP TABLE IF EXISTS `hai_article`;
CREATE TABLE `hai_article` (
  `article_id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `cat_id` int(5) NOT NULL DEFAULT '0',
  `code` varchar(20) NOT NULL,
  `title` varchar(150) NOT NULL DEFAULT '',
  `content` longtext NOT NULL,
  `author` varchar(30) NOT NULL DEFAULT '',
  `author_email` varchar(60) NOT NULL DEFAULT '',
  `article_date` datetime DEFAULT NULL,
  `keywords` varchar(255) NOT NULL DEFAULT '',
  `is_open` smallint(3) unsigned NOT NULL DEFAULT '1',
  `create_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `file_url` varchar(255) NOT NULL DEFAULT '',
  `open_type` smallint(1) unsigned NOT NULL DEFAULT '0',
  `link` varchar(255) NOT NULL DEFAULT '',
  `description` varchar(255) DEFAULT NULL,
  `store_id` int(10) DEFAULT NULL,
  `sort` smallint(5) DEFAULT NULL,
  `article_images` varchar(200) DEFAULT NULL,
  `video_url` varchar(200) DEFAULT NULL,
  `article_type_code` varchar(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `article_enum` enum('company','article') DEFAULT 'article' COMMENT '列表文章还是公司资讯文章',
  PRIMARY KEY (`article_id`),
  KEY `cat_id` (`cat_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_article
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_article_cat`
-- ----------------------------
DROP TABLE IF EXISTS `hai_article_cat`;
CREATE TABLE `hai_article_cat` (
  `cat_id` smallint(5) NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(255) NOT NULL DEFAULT '',
  `cat_type` tinyint(1) unsigned NOT NULL DEFAULT '1',
  `keywords` varchar(255) NOT NULL DEFAULT '',
  `cat_desc` varchar(255) NOT NULL DEFAULT '',
  `sort_order` tinyint(3) unsigned NOT NULL DEFAULT '1',
  `show_in_nav` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `parent_id` smallint(5) unsigned NOT NULL DEFAULT '0',
  `store_id` int(10) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `images` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`cat_id`),
  KEY `cat_type` (`cat_type`),
  KEY `sort_order` (`sort_order`),
  KEY `parent_id` (`parent_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_article_cat
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_attribute`
-- ----------------------------
DROP TABLE IF EXISTS `hai_attribute`;
CREATE TABLE `hai_attribute` (
  `attr_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `cat_id` smallint(5) unsigned NOT NULL DEFAULT '0',
  `attr_code` varchar(20) DEFAULT NULL,
  `attr_name` varchar(60) NOT NULL DEFAULT '',
  `attr_input_type` tinyint(1) unsigned NOT NULL DEFAULT '1',
  `attr_type` tinyint(1) unsigned NOT NULL DEFAULT '1',
  `attr_values` text NOT NULL,
  `attr_index` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `sort_order` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `is_linked` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `attr_group` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `store_id` int(11) DEFAULT '0' COMMENT '商家编号',
  PRIMARY KEY (`attr_id`),
  KEY `cat_id` (`cat_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_attribute
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_attribute_value`
-- ----------------------------
DROP TABLE IF EXISTS `hai_attribute_value`;
CREATE TABLE `hai_attribute_value` (
  `attr_id` int(11) NOT NULL,
  `attr_value` varchar(200) DEFAULT NULL,
  `filter_id` int(11) DEFAULT NULL,
  `store_id` int(11) DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_attribute_value
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_auction_log`
-- ----------------------------
DROP TABLE IF EXISTS `hai_auction_log`;
CREATE TABLE `hai_auction_log` (
  `log_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `act_id` mediumint(8) unsigned NOT NULL,
  `bid_user` mediumint(8) unsigned NOT NULL,
  `bid_price` decimal(10,2) unsigned NOT NULL,
  `bid_time` int(10) unsigned NOT NULL,
  PRIMARY KEY (`log_id`),
  KEY `act_id` (`act_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_auction_log
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_auto_manage`
-- ----------------------------
DROP TABLE IF EXISTS `hai_auto_manage`;
CREATE TABLE `hai_auto_manage` (
  `item_id` mediumint(8) NOT NULL,
  `type` varchar(10) NOT NULL,
  `starttime` int(10) NOT NULL,
  `endtime` int(10) NOT NULL,
  PRIMARY KEY (`item_id`,`type`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_auto_manage
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_back_goods`
-- ----------------------------
DROP TABLE IF EXISTS `hai_back_goods`;
CREATE TABLE `hai_back_goods` (
  `rec_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `back_id` mediumint(8) unsigned DEFAULT '0',
  `goods_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `product_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `product_sn` varchar(60) DEFAULT NULL,
  `goods_name` varchar(120) DEFAULT NULL,
  `brand_name` varchar(60) DEFAULT NULL,
  `goods_sn` varchar(60) DEFAULT NULL,
  `is_real` tinyint(1) unsigned DEFAULT '0',
  `send_number` smallint(5) unsigned DEFAULT '0',
  `goods_attr` text,
  PRIMARY KEY (`rec_id`),
  KEY `back_id` (`back_id`),
  KEY `goods_id` (`goods_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_back_goods
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_back_order`
-- ----------------------------
DROP TABLE IF EXISTS `hai_back_order`;
CREATE TABLE `hai_back_order` (
  `back_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `delivery_sn` varchar(20) NOT NULL,
  `order_sn` varchar(20) NOT NULL,
  `order_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `invoice_no` varchar(50) DEFAULT NULL,
  `add_time` int(10) unsigned DEFAULT '0',
  `shipping_id` tinyint(3) unsigned DEFAULT '0',
  `shipping_name` varchar(120) DEFAULT NULL,
  `user_id` mediumint(8) unsigned DEFAULT '0',
  `action_user` varchar(30) DEFAULT NULL,
  `consignee` varchar(60) DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  `country` smallint(5) unsigned DEFAULT '0',
  `province` smallint(5) unsigned DEFAULT '0',
  `city` smallint(5) unsigned DEFAULT '0',
  `district` smallint(5) unsigned DEFAULT '0',
  `sign_building` varchar(120) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `zipcode` varchar(60) DEFAULT NULL,
  `tel` varchar(60) DEFAULT NULL,
  `mobile` varchar(60) DEFAULT NULL,
  `best_time` varchar(120) DEFAULT NULL,
  `postscript` varchar(255) DEFAULT NULL,
  `how_oos` varchar(120) DEFAULT NULL,
  `insure_fee` decimal(10,2) unsigned DEFAULT '0.00',
  `shipping_fee` decimal(10,2) unsigned DEFAULT '0.00',
  `update_time` int(10) unsigned DEFAULT '0',
  `suppliers_id` smallint(5) DEFAULT '0',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `return_time` int(10) unsigned DEFAULT '0',
  `agency_id` smallint(5) unsigned DEFAULT '0',
  PRIMARY KEY (`back_id`),
  KEY `user_id` (`user_id`),
  KEY `order_id` (`order_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_back_order
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_bonus_type`
-- ----------------------------
DROP TABLE IF EXISTS `hai_bonus_type`;
CREATE TABLE `hai_bonus_type` (
  `type_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `type_name` varchar(60) NOT NULL DEFAULT '',
  `type_money` decimal(10,2) NOT NULL DEFAULT '0.00',
  `send_type` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `min_amount` decimal(10,2) unsigned NOT NULL DEFAULT '0.00',
  `max_amount` decimal(10,2) unsigned NOT NULL DEFAULT '0.00',
  `send_start_date` int(11) NOT NULL DEFAULT '0',
  `send_end_date` int(11) NOT NULL DEFAULT '0',
  `use_start_date` int(11) NOT NULL DEFAULT '0',
  `use_end_date` int(11) NOT NULL DEFAULT '0',
  `min_goods_amount` decimal(10,2) unsigned NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`type_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_bonus_type
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_booking_goods`
-- ----------------------------
DROP TABLE IF EXISTS `hai_booking_goods`;
CREATE TABLE `hai_booking_goods` (
  `rec_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `email` varchar(60) NOT NULL DEFAULT '',
  `link_man` varchar(60) NOT NULL DEFAULT '',
  `tel` varchar(60) NOT NULL DEFAULT '',
  `goods_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `goods_desc` varchar(255) NOT NULL DEFAULT '',
  `goods_number` smallint(5) unsigned NOT NULL DEFAULT '0',
  `booking_time` int(10) unsigned NOT NULL DEFAULT '0',
  `is_dispose` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `dispose_user` varchar(30) NOT NULL DEFAULT '',
  `dispose_time` int(10) unsigned NOT NULL DEFAULT '0',
  `dispose_note` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`rec_id`),
  KEY `user_id` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_booking_goods
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_brand`
-- ----------------------------
DROP TABLE IF EXISTS `hai_brand`;
CREATE TABLE `hai_brand` (
  `brand_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(60) NOT NULL DEFAULT '',
  `brand_logo` varchar(500) NOT NULL DEFAULT '',
  `brand_desc` text NOT NULL,
  `site_url` varchar(255) NOT NULL DEFAULT '',
  `sort_order` smallint(3) unsigned NOT NULL DEFAULT '50',
  `is_show` tinyint(1) unsigned NOT NULL DEFAULT '1',
  `store_id` int(11) DEFAULT NULL,
  `cat_id` int(11) DEFAULT NULL,
  `recommend` varchar(200) DEFAULT NULL COMMENT '推荐类型，也作扩展信息',
  PRIMARY KEY (`brand_id`),
  KEY `is_show` (`is_show`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_brand
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_business`
-- ----------------------------
DROP TABLE IF EXISTS `hai_business`;
CREATE TABLE `hai_business` (
  `business_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '企业编号',
  `user_id` int(11) DEFAULT NULL,
  `business_name` varchar(200) DEFAULT NULL COMMENT '企业名称',
  `sectors_id` int(11) DEFAULT NULL COMMENT '行业编号',
  `legal_person` varchar(20) DEFAULT NULL COMMENT '法人',
  `linkman` varchar(20) DEFAULT NULL COMMENT '联系人',
  `tel` varchar(15) DEFAULT NULL COMMENT '电话',
  `fax` varchar(15) DEFAULT NULL COMMENT '传真',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `address` varchar(200) DEFAULT NULL COMMENT '联系地址',
  `longitude` decimal(8,8) DEFAULT NULL COMMENT '经度',
  `latitude` decimal(8,8) DEFAULT NULL COMMENT '纬度',
  `is_void` enum('1','0') DEFAULT '1',
  `intro` text COMMENT '简介',
  `logo` varchar(200) DEFAULT NULL COMMENT 'logo',
  `website` varchar(100) DEFAULT NULL COMMENT '网址',
  `store_id` int(11) DEFAULT NULL,
  `pinyin` varchar(200) DEFAULT NULL COMMENT '拼音',
  `country` smallint(2) DEFAULT NULL,
  `province` smallint(2) DEFAULT NULL,
  `city` smallint(2) DEFAULT NULL,
  `county` smallint(2) DEFAULT NULL,
  `district` smallint(2) DEFAULT NULL,
  `street` smallint(2) DEFAULT NULL,
  PRIMARY KEY (`business_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_business
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_business_data`
-- ----------------------------
DROP TABLE IF EXISTS `hai_business_data`;
CREATE TABLE `hai_business_data` (
  `business_id` int(11) unsigned NOT NULL,
  `click_count` int(11) DEFAULT '0' COMMENT ' 点击数',
  `comment_count` int(11) DEFAULT '0' COMMENT '评论数',
  `reply_count` int(11) DEFAULT '0' COMMENT '回复数',
  `score_total` int(11) DEFAULT '0' COMMENT '评分总数',
  `score_count` int(11) DEFAULT '0' COMMENT '评分数量',
  PRIMARY KEY (`business_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_business_data
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_card`
-- ----------------------------
DROP TABLE IF EXISTS `hai_card`;
CREATE TABLE `hai_card` (
  `card_id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `card_name` varchar(120) NOT NULL DEFAULT '',
  `card_img` varchar(255) NOT NULL DEFAULT '',
  `card_fee` decimal(6,2) unsigned NOT NULL DEFAULT '0.00',
  `free_money` decimal(6,2) unsigned NOT NULL DEFAULT '0.00',
  `card_desc` varchar(255) NOT NULL DEFAULT '',
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`card_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_card
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_cart`
-- ----------------------------
DROP TABLE IF EXISTS `hai_cart`;
CREATE TABLE `hai_cart` (
  `rec_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `session_id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '',
  `goods_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `goods_sn` varchar(60) NOT NULL DEFAULT '',
  `product_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `goods_name` varchar(120) NOT NULL DEFAULT '',
  `market_price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00',
  `goods_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `goods_number` smallint(5) unsigned NOT NULL DEFAULT '0',
  `goods_attr` text NOT NULL,
  `goods_thumb` varchar(255) DEFAULT NULL,
  `is_real` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `extension_code` varchar(30) NOT NULL DEFAULT '',
  `parent_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `rec_type` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `is_gift` smallint(5) unsigned NOT NULL DEFAULT '0',
  `is_shipping` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `can_handsel` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `goods_attr_id` varchar(255) DEFAULT '',
  `goods_attr_json` text,
  `goods_store_id` int(11) DEFAULT NULL COMMENT '商品所属商家编号',
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`rec_id`),
  KEY `session_id` (`session_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_cart
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_category`
-- ----------------------------
DROP TABLE IF EXISTS `hai_category`;
CREATE TABLE `hai_category` (
  `cat_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(90) NOT NULL DEFAULT '',
  `keywords` varchar(255) NOT NULL DEFAULT '',
  `sub_cat_name` varchar(50) DEFAULT NULL,
  `cat_desc` varchar(255) NOT NULL DEFAULT '',
  `parent_id` int(11) unsigned NOT NULL DEFAULT '0',
  `sort_order` smallint(1) unsigned NOT NULL DEFAULT '0',
  `template_file` varchar(50) NOT NULL DEFAULT '',
  `measure_unit` varchar(15) NOT NULL DEFAULT '',
  `show_in_nav` tinyint(1) NOT NULL DEFAULT '0',
  `style` varchar(150) NOT NULL,
  `is_show` tinyint(1) unsigned NOT NULL DEFAULT '1',
  `grade` smallint(4) NOT NULL DEFAULT '0',
  `filter_attr` text NOT NULL COMMENT '筛选属性编号',
  `sub_parent_id` text COMMENT '子分类的编号',
  `brand_id` text COMMENT '品牌编号',
  `store_id` int(10) DEFAULT NULL COMMENT '商家编号',
  `thumb` varchar(200) DEFAULT NULL COMMENT '缩略图',
  `image` varchar(200) DEFAULT NULL COMMENT '图片',
  `cat_code` varchar(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `recommend` varchar(20) DEFAULT NULL COMMENT '推荐类型',
  PRIMARY KEY (`cat_id`),
  KEY `parent_id` (`parent_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_category
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_cat_recommend`
-- ----------------------------
DROP TABLE IF EXISTS `hai_cat_recommend`;
CREATE TABLE `hai_cat_recommend` (
  `cat_id` smallint(5) NOT NULL,
  `recommend_type` tinyint(1) NOT NULL,
  PRIMARY KEY (`cat_id`,`recommend_type`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_cat_recommend
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_chapter`
-- ----------------------------
DROP TABLE IF EXISTS `hai_chapter`;
CREATE TABLE `hai_chapter` (
  `cha_id` int(11) NOT NULL AUTO_INCREMENT,
  `cha_name` varchar(100) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL COMMENT '所属商品编号',
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`cha_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_chapter
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_collect_goods`
-- ----------------------------
DROP TABLE IF EXISTS `hai_collect_goods`;
CREATE TABLE `hai_collect_goods` (
  `rec_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `goods_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `add_time` int(11) unsigned NOT NULL DEFAULT '0',
  `is_attention` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`rec_id`),
  KEY `user_id` (`user_id`),
  KEY `goods_id` (`goods_id`),
  KEY `is_attention` (`is_attention`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_collect_goods
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_comment`
-- ----------------------------
DROP TABLE IF EXISTS `hai_comment`;
CREATE TABLE `hai_comment` (
  `comment_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `comment_type` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `id_value` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `email` varchar(60) NOT NULL DEFAULT '',
  `user_name` varchar(60) NOT NULL DEFAULT '',
  `content` text NOT NULL,
  `comment_rank` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `add_time` int(10) unsigned NOT NULL DEFAULT '0',
  `ip_address` varchar(15) NOT NULL DEFAULT '',
  `status` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `parent_id` int(10) unsigned NOT NULL DEFAULT '0',
  `user_id` int(10) unsigned NOT NULL DEFAULT '0',
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `parent_id` (`parent_id`),
  KEY `id_value` (`id_value`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_company`
-- ----------------------------
DROP TABLE IF EXISTS `hai_company`;
CREATE TABLE `hai_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL,
  `content` text,
  `store_id` int(11) DEFAULT NULL,
  `parent_id` int(11) DEFAULT '0',
  `summary` text COMMENT '摘要',
  `keywords` varchar(200) DEFAULT NULL,
  `sort` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_company
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_crons`
-- ----------------------------
DROP TABLE IF EXISTS `hai_crons`;
CREATE TABLE `hai_crons` (
  `cron_id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `cron_code` varchar(20) NOT NULL,
  `cron_name` varchar(120) NOT NULL,
  `cron_desc` text,
  `cron_order` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `cron_config` text NOT NULL,
  `thistime` int(10) NOT NULL DEFAULT '0',
  `nextime` int(10) NOT NULL,
  `day` tinyint(2) NOT NULL,
  `week` varchar(1) NOT NULL,
  `hour` varchar(2) NOT NULL,
  `minute` varchar(255) NOT NULL,
  `enable` tinyint(1) NOT NULL DEFAULT '1',
  `run_once` tinyint(1) NOT NULL DEFAULT '0',
  `allow_ip` varchar(100) NOT NULL DEFAULT '',
  `alow_files` varchar(255) NOT NULL,
  PRIMARY KEY (`cron_id`),
  KEY `nextime` (`nextime`),
  KEY `enable` (`enable`),
  KEY `cron_code` (`cron_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_crons
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_delivery_goods`
-- ----------------------------
DROP TABLE IF EXISTS `hai_delivery_goods`;
CREATE TABLE `hai_delivery_goods` (
  `rec_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `delivery_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `goods_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `product_id` mediumint(8) unsigned DEFAULT '0',
  `product_sn` varchar(60) DEFAULT NULL,
  `goods_name` varchar(120) DEFAULT NULL,
  `brand_name` varchar(60) DEFAULT NULL,
  `goods_sn` varchar(60) DEFAULT NULL,
  `is_real` tinyint(1) unsigned DEFAULT '0',
  `extension_code` varchar(30) DEFAULT NULL,
  `parent_id` mediumint(8) unsigned DEFAULT '0',
  `send_number` smallint(5) unsigned DEFAULT '0',
  `goods_attr` text,
  PRIMARY KEY (`rec_id`),
  KEY `delivery_id` (`delivery_id`,`goods_id`),
  KEY `goods_id` (`goods_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_delivery_goods
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_delivery_order`
-- ----------------------------
DROP TABLE IF EXISTS `hai_delivery_order`;
CREATE TABLE `hai_delivery_order` (
  `delivery_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `delivery_sn` varchar(20) NOT NULL,
  `order_sn` varchar(20) NOT NULL,
  `order_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `invoice_no` varchar(50) DEFAULT NULL,
  `add_time` int(10) unsigned DEFAULT '0',
  `shipping_id` tinyint(3) unsigned DEFAULT '0',
  `shipping_name` varchar(120) DEFAULT NULL,
  `user_id` mediumint(8) unsigned DEFAULT '0',
  `action_user` varchar(30) DEFAULT NULL,
  `consignee` varchar(60) DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  `country` smallint(5) unsigned DEFAULT '0',
  `province` smallint(5) unsigned DEFAULT '0',
  `city` smallint(5) unsigned DEFAULT '0',
  `district` smallint(5) unsigned DEFAULT '0',
  `sign_building` varchar(120) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `zipcode` varchar(60) DEFAULT NULL,
  `tel` varchar(60) DEFAULT NULL,
  `mobile` varchar(60) DEFAULT NULL,
  `best_time` varchar(120) DEFAULT NULL,
  `postscript` varchar(255) DEFAULT NULL,
  `how_oos` varchar(120) DEFAULT NULL,
  `insure_fee` decimal(10,2) unsigned DEFAULT '0.00',
  `shipping_fee` decimal(10,2) unsigned DEFAULT '0.00',
  `update_time` int(10) unsigned DEFAULT '0',
  `suppliers_id` smallint(5) DEFAULT '0',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `agency_id` smallint(5) unsigned DEFAULT '0',
  PRIMARY KEY (`delivery_id`),
  KEY `user_id` (`user_id`),
  KEY `order_id` (`order_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_delivery_order
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_donation`
-- ----------------------------
DROP TABLE IF EXISTS `hai_donation`;
CREATE TABLE `hai_donation` (
  `donation_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动编辑',
  `donation_name` varchar(50) DEFAULT NULL COMMENT '捐款项目名称',
  `donation_type_id` int(11) DEFAULT NULL COMMENT '捐款类型编号',
  `picture` varchar(200) DEFAULT NULL COMMENT '图片',
  `intro` varchar(100) DEFAULT NULL COMMENT '摘要',
  `content` text COMMENT '内容',
  `sort` int(5) DEFAULT NULL COMMENT '排序',
  `store_id` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `total_amount` int(11) DEFAULT NULL COMMENT '捐款总金额',
  `total_quantity` int(11) DEFAULT NULL COMMENT '捐款总人数',
  PRIMARY KEY (`donation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_donation
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_email_list`
-- ----------------------------
DROP TABLE IF EXISTS `hai_email_list`;
CREATE TABLE `hai_email_list` (
  `id` mediumint(8) NOT NULL AUTO_INCREMENT,
  `email` varchar(60) NOT NULL,
  `stat` tinyint(1) NOT NULL DEFAULT '0',
  `hash` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_email_list
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_email_sendlist`
-- ----------------------------
DROP TABLE IF EXISTS `hai_email_sendlist`;
CREATE TABLE `hai_email_sendlist` (
  `id` mediumint(8) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `template_id` mediumint(8) NOT NULL,
  `email_content` text NOT NULL,
  `error` tinyint(1) NOT NULL DEFAULT '0',
  `pri` tinyint(10) NOT NULL,
  `last_send` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_email_sendlist
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_error_log`
-- ----------------------------
DROP TABLE IF EXISTS `hai_error_log`;
CREATE TABLE `hai_error_log` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `info` varchar(255) NOT NULL,
  `file` varchar(100) NOT NULL,
  `time` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `time` (`time`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_error_log
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_exchange_goods`
-- ----------------------------
DROP TABLE IF EXISTS `hai_exchange_goods`;
CREATE TABLE `hai_exchange_goods` (
  `goods_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `exchange_integral` int(10) unsigned NOT NULL DEFAULT '0',
  `is_exchange` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `is_hot` tinyint(1) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`goods_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_exchange_goods
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_extend_fields`
-- ----------------------------
DROP TABLE IF EXISTS `hai_extend_fields`;
CREATE TABLE `hai_extend_fields` (
  `field_id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `field_name` varchar(60) NOT NULL DEFAULT '',
  `field_label` varchar(60) DEFAULT NULL,
  `extend_table` varchar(60) NOT NULL,
  `dis_order` tinyint(3) unsigned NOT NULL DEFAULT '2',
  `display` tinyint(1) unsigned NOT NULL DEFAULT '1',
  `type` varchar(20) NOT NULL DEFAULT '0',
  `is_need` tinyint(1) unsigned NOT NULL DEFAULT '1',
  `control` varchar(20) DEFAULT '0',
  `prompt` varchar(200) DEFAULT NULL COMMENT '提示信息',
  `length` int(11) DEFAULT '20',
  `extend_value_list` text COMMENT '扩展字段列表，以逗号分开',
  `store_id` int(11) DEFAULT '0',
  PRIMARY KEY (`field_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_extend_fields
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_extend_value`
-- ----------------------------
DROP TABLE IF EXISTS `hai_extend_value`;
CREATE TABLE `hai_extend_value` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `field_id` int(10) unsigned NOT NULL,
  `content` text NOT NULL,
  `table_id` int(11) DEFAULT NULL COMMENT '对应表的编号',
  `store_id` int(11) DEFAULT '0',
  `field_name` varchar(50) DEFAULT NULL,
  `table_name` varchar(50) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_extend_value
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_favorites`
-- ----------------------------
DROP TABLE IF EXISTS `hai_favorites`;
CREATE TABLE `hai_favorites` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `sesskey` varchar(64) DEFAULT NULL COMMENT '未登陆时的sesskey',
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `goods_id` (`goods_id`),
  KEY `user_id` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_favorites
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_favourable_activity`
-- ----------------------------
DROP TABLE IF EXISTS `hai_favourable_activity`;
CREATE TABLE `hai_favourable_activity` (
  `act_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `act_name` varchar(255) NOT NULL,
  `start_time` int(10) unsigned NOT NULL,
  `end_time` int(10) unsigned NOT NULL,
  `user_rank` varchar(255) NOT NULL,
  `act_range` tinyint(3) unsigned NOT NULL,
  `act_range_ext` varchar(255) NOT NULL,
  `min_amount` decimal(10,2) unsigned NOT NULL,
  `max_amount` decimal(10,2) unsigned NOT NULL,
  `act_type` tinyint(3) unsigned NOT NULL,
  `act_type_ext` decimal(10,2) unsigned NOT NULL,
  `gift` text NOT NULL,
  `sort_order` tinyint(3) unsigned NOT NULL DEFAULT '50',
  PRIMARY KEY (`act_id`),
  KEY `act_name` (`act_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_favourable_activity
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_feedback`
-- ----------------------------
DROP TABLE IF EXISTS `hai_feedback`;
CREATE TABLE `hai_feedback` (
  `msg_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `parent_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `user_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `user_name` varchar(60) NOT NULL DEFAULT '',
  `user_email` varchar(60) NOT NULL DEFAULT '',
  `msg_title` varchar(200) NOT NULL DEFAULT '',
  `msg_type` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `msg_status` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `msg_content` text NOT NULL,
  `msg_time` int(10) unsigned NOT NULL DEFAULT '0',
  `message_img` varchar(255) NOT NULL DEFAULT '0',
  `order_id` int(11) unsigned NOT NULL DEFAULT '0',
  `msg_area` tinyint(1) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`msg_id`),
  KEY `user_id` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_feedback
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_forum`
-- ----------------------------
DROP TABLE IF EXISTS `hai_forum`;
CREATE TABLE `hai_forum` (
  `forum_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  `content` text,
  `create_date` datetime DEFAULT NULL,
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`forum_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_forum
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_friend_link`
-- ----------------------------
DROP TABLE IF EXISTS `hai_friend_link`;
CREATE TABLE `hai_friend_link` (
  `link_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `link_name` varchar(255) NOT NULL DEFAULT '',
  `link_url` varchar(255) NOT NULL DEFAULT '',
  `link_logo` varchar(255) NOT NULL DEFAULT '',
  `show_order` tinyint(3) unsigned NOT NULL DEFAULT '50',
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`link_id`),
  KEY `show_order` (`show_order`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_friend_link
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_goods`
-- ----------------------------
DROP TABLE IF EXISTS `hai_goods`;
CREATE TABLE `hai_goods` (
  `goods_id` bigint(8) unsigned NOT NULL AUTO_INCREMENT,
  `cat_id` int(5) unsigned NOT NULL DEFAULT '0',
  `goods_sn` varchar(60) NOT NULL DEFAULT '',
  `goods_name` varchar(120) NOT NULL DEFAULT '',
  `goods_name_style` varchar(60) NOT NULL DEFAULT '+',
  `click_count` int(10) unsigned NOT NULL DEFAULT '0',
  `brand_id` int(5) unsigned NOT NULL DEFAULT '0',
  `provider_name` varchar(100) NOT NULL DEFAULT '',
  `goods_number` smallint(5) unsigned NOT NULL DEFAULT '0',
  `goods_weight` int(10) unsigned NOT NULL DEFAULT '0',
  `market_price` int(10) unsigned NOT NULL DEFAULT '0',
  `shop_price` int(10) unsigned NOT NULL DEFAULT '0',
  `cost_price` int(10) DEFAULT '0',
  `promote_price` int(10) unsigned NOT NULL DEFAULT '0',
  `promote_start_date` date NOT NULL DEFAULT '0000-00-00',
  `promote_end_date` date NOT NULL DEFAULT '0000-00-00',
  `warn_number` tinyint(3) unsigned NOT NULL DEFAULT '1',
  `keywords` varchar(255) NOT NULL DEFAULT '',
  `goods_brief` text NOT NULL,
  `goods_desc` text NOT NULL,
  `act_desc` varchar(100) DEFAULT NULL COMMENT '标题旁边的标注',
  `app_desc` text COMMENT '手机端描述',
  `goods_thumb` varchar(255) NOT NULL DEFAULT '',
  `goods_img` varchar(255) NOT NULL DEFAULT '',
  `original_img` varchar(255) NOT NULL DEFAULT '',
  `is_real` tinyint(3) unsigned NOT NULL DEFAULT '1',
  `extension_code` varchar(30) NOT NULL DEFAULT '',
  `is_on_sale` tinyint(1) unsigned NOT NULL DEFAULT '1',
  `is_alone_sale` tinyint(1) unsigned NOT NULL DEFAULT '1',
  `is_shipping` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `integral` int(10) unsigned NOT NULL DEFAULT '0',
  `add_time` int(10) unsigned NOT NULL DEFAULT '0',
  `sort_order` smallint(4) unsigned NOT NULL DEFAULT '100' COMMENT '排序',
  `is_delete` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `is_best` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `is_new` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `is_hot` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `is_promote` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `is_special` tinyint(1) NOT NULL DEFAULT '0',
  `bonus_type_id` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `last_update` int(10) unsigned NOT NULL DEFAULT '0',
  `goods_type` smallint(5) unsigned NOT NULL DEFAULT '0',
  `seller_note` varchar(255) NOT NULL DEFAULT '',
  `give_integral` int(11) NOT NULL DEFAULT '-1',
  `rank_integral` int(11) NOT NULL DEFAULT '-1',
  `business_id` smallint(5) unsigned DEFAULT NULL,
  `is_check` tinyint(1) unsigned DEFAULT NULL,
  `tb_iid` varchar(40) DEFAULT NULL,
  `tb_data` text,
  `is_export` smallint(6) DEFAULT '0' COMMENT '0不导出，1导出',
  `user_id` int(11) DEFAULT '0' COMMENT '用户编号，store_id必须为0，针对用户自己的商品',
  `store_id` int(10) DEFAULT '0' COMMENT '商家的编号',
  `exchangeRate` decimal(10,4) DEFAULT '0.0000' COMMENT '兑换率',
  `profit` decimal(10,4) DEFAULT '0.0000' COMMENT '利益',
  `shipping` decimal(10,4) DEFAULT '0.0000' COMMENT '运费',
  `profitType` int(2) DEFAULT '0' COMMENT '0:乘以折扣，1：加上费用',
  `currency` varchar(20) DEFAULT NULL COMMENT '货币类型',
  `goods_url` varchar(500) DEFAULT NULL COMMENT '网上抓取的网址',
  `tabbox` int(11) DEFAULT NULL COMMENT 'tabbox推荐商品类别',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`goods_id`),
  KEY `goods_sn` (`goods_sn`),
  KEY `cat_id` (`cat_id`),
  KEY `last_update` (`last_update`),
  KEY `brand_id` (`brand_id`),
  KEY `goods_weight` (`goods_weight`),
  KEY `promote_end_date` (`promote_end_date`),
  KEY `promote_start_date` (`promote_start_date`),
  KEY `goods_number` (`goods_number`),
  KEY `sort_order` (`sort_order`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_goods
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_goods_activity`
-- ----------------------------
DROP TABLE IF EXISTS `hai_goods_activity`;
CREATE TABLE `hai_goods_activity` (
  `act_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `act_name` varchar(255) NOT NULL,
  `act_desc` text NOT NULL,
  `act_type` tinyint(3) unsigned NOT NULL,
  `goods_id` mediumint(8) unsigned NOT NULL,
  `product_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `goods_name` varchar(255) NOT NULL,
  `start_time` int(10) unsigned NOT NULL,
  `end_time` int(10) unsigned NOT NULL,
  `is_finished` tinyint(3) unsigned NOT NULL,
  `ext_info` text NOT NULL,
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`act_id`),
  KEY `act_name` (`act_name`,`act_type`,`goods_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_goods_activity
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_goods_article`
-- ----------------------------
DROP TABLE IF EXISTS `hai_goods_article`;
CREATE TABLE `hai_goods_article` (
  `goods_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `article_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `admin_id` tinyint(3) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`goods_id`,`article_id`,`admin_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_goods_article
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_goods_attr`
-- ----------------------------
DROP TABLE IF EXISTS `hai_goods_attr`;
CREATE TABLE `hai_goods_attr` (
  `goods_attr_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `goods_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `attr_id` smallint(5) unsigned NOT NULL DEFAULT '0',
  `attr_value` text NOT NULL,
  `attr_price` varchar(255) NOT NULL DEFAULT '',
  `taobao_vid` bigint(20) DEFAULT '0',
  PRIMARY KEY (`goods_attr_id`),
  KEY `goods_id` (`goods_id`),
  KEY `attr_id` (`attr_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_goods_attr
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_goods_cat`
-- ----------------------------
DROP TABLE IF EXISTS `hai_goods_cat`;
CREATE TABLE `hai_goods_cat` (
  `goods_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `cat_id` smallint(5) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`goods_id`,`cat_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_goods_cat
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_goods_gallery`
-- ----------------------------
DROP TABLE IF EXISTS `hai_goods_gallery`;
CREATE TABLE `hai_goods_gallery` (
  `img_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT '0',
  `goods_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `table_name` varchar(50) DEFAULT NULL,
  `img_url` varchar(255) NOT NULL DEFAULT '',
  `img_desc` varchar(255) NOT NULL DEFAULT '',
  `thumb_url` varchar(255) NOT NULL DEFAULT '',
  `img_original` varchar(255) NOT NULL DEFAULT '',
  `gallery_type` smallint(1) DEFAULT '0' COMMENT '相册类型',
  `store_id` int(11) DEFAULT '0' COMMENT '商家编号',
  PRIMARY KEY (`img_id`),
  KEY `goods_id` (`goods_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_goods_gallery
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_goods_type`
-- ----------------------------
DROP TABLE IF EXISTS `hai_goods_type`;
CREATE TABLE `hai_goods_type` (
  `cat_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(60) NOT NULL DEFAULT '',
  `enabled` tinyint(1) unsigned NOT NULL DEFAULT '1',
  `attr_group` varchar(255) NOT NULL,
  `store_id` int(11) DEFAULT '0' COMMENT '商家编号',
  PRIMARY KEY (`cat_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_goods_type
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_group_goods`
-- ----------------------------
DROP TABLE IF EXISTS `hai_group_goods`;
CREATE TABLE `hai_group_goods` (
  `parent_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `goods_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `goods_price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00',
  `admin_id` tinyint(3) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`parent_id`,`goods_id`,`admin_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_group_goods
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_guestbook`
-- ----------------------------
DROP TABLE IF EXISTS `hai_guestbook`;
CREATE TABLE `hai_guestbook` (
  `guestbook_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `content` text,
  `guest` varchar(50) DEFAULT NULL,
  `sex` smallint(1) DEFAULT NULL,
  `company` varchar(200) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `postcode` varchar(50) DEFAULT NULL,
  `telphone` varchar(50) DEFAULT NULL,
  `fax` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `store_id` int(11) DEFAULT NULL,
  `status` smallint(1) DEFAULT NULL,
  `result_message` text COMMENT '处理结果信息',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`guestbook_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_guestbook
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_job_apply`
-- ----------------------------
DROP TABLE IF EXISTS `hai_job_apply`;
CREATE TABLE `hai_job_apply` (
  `mja_id` int(11) NOT NULL AUTO_INCREMENT,
  `job_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `job_type` smallint(2) DEFAULT '0' COMMENT '1：模特，2：翻译',
  `pass` smallint(2) DEFAULT NULL,
  `remark` text COMMENT '备注信息',
  `store_id` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`mja_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_job_apply
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_keywords`
-- ----------------------------
DROP TABLE IF EXISTS `hai_keywords`;
CREATE TABLE `hai_keywords` (
  `date` date NOT NULL DEFAULT '0000-00-00',
  `searchengine` varchar(20) NOT NULL DEFAULT '',
  `keyword` varchar(90) NOT NULL DEFAULT '',
  `count` mediumint(8) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`date`,`searchengine`,`keyword`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_keywords
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_link_goods`
-- ----------------------------
DROP TABLE IF EXISTS `hai_link_goods`;
CREATE TABLE `hai_link_goods` (
  `goods_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `link_goods_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `is_double` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `admin_id` tinyint(3) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`goods_id`,`link_goods_id`,`admin_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_link_goods
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_mail_templates`
-- ----------------------------
DROP TABLE IF EXISTS `hai_mail_templates`;
CREATE TABLE `hai_mail_templates` (
  `template_id` tinyint(1) unsigned NOT NULL AUTO_INCREMENT,
  `template_code` varchar(30) NOT NULL DEFAULT '',
  `is_html` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `template_subject` varchar(200) NOT NULL DEFAULT '',
  `template_content` text NOT NULL,
  `last_modify` int(10) unsigned NOT NULL DEFAULT '0',
  `last_send` int(10) unsigned NOT NULL DEFAULT '0',
  `type` varchar(10) NOT NULL,
  PRIMARY KEY (`template_id`),
  UNIQUE KEY `template_code` (`template_code`),
  KEY `type` (`type`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_mail_templates
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_member_price`
-- ----------------------------
DROP TABLE IF EXISTS `hai_member_price`;
CREATE TABLE `hai_member_price` (
  `price_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `goods_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `user_rank` tinyint(3) NOT NULL DEFAULT '0',
  `user_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`price_id`),
  KEY `goods_id` (`goods_id`,`user_rank`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_member_price
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_model_info`
-- ----------------------------
DROP TABLE IF EXISTS `hai_model_info`;
CREATE TABLE `hai_model_info` (
  `model_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `model_name` varchar(50) DEFAULT NULL COMMENT '模特名称',
  `sex` smallint(1) DEFAULT NULL,
  `age` int(4) DEFAULT NULL,
  `face_path` varchar(200) DEFAULT NULL COMMENT '头像图片',
  `xingzuo` varchar(100) DEFAULT NULL COMMENT '星座',
  `xuexing` varchar(100) DEFAULT NULL COMMENT '血型',
  `faxing` varchar(100) DEFAULT NULL COMMENT '发型',
  `xueli` varchar(100) DEFAULT NULL COMMENT '学历',
  `school` varchar(200) DEFAULT NULL COMMENT '毕业学校',
  `model_type` varchar(100) DEFAULT NULL COMMENT '模特类型',
  `city` varchar(100) DEFAULT NULL,
  `xinshui` varchar(100) DEFAULT NULL COMMENT '薪水',
  `self_introduction` text,
  `experience` text COMMENT '经验',
  `awards` text COMMENT '所获奖项',
  `telephone` varchar(100) DEFAULT NULL,
  `mobilephone` varchar(100) DEFAULT NULL,
  `qq` varchar(100) DEFAULT NULL,
  `weixin` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `company` varchar(200) DEFAULT NULL,
  `company_phone` varchar(100) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `pass` smallint(1) DEFAULT '0' COMMENT '是否通过审核',
  `store_id` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`model_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_model_info
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_model_job`
-- ----------------------------
DROP TABLE IF EXISTS `hai_model_job`;
CREATE TABLE `hai_model_job` (
  `model_job_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL COMMENT '标题',
  `issue_date` date DEFAULT NULL COMMENT '发布日期',
  `end_date` date DEFAULT NULL COMMENT '截止日期',
  `city` varchar(50) DEFAULT NULL COMMENT '所在城市',
  `job_type` varchar(100) DEFAULT NULL COMMENT '工作类型',
  `xinshui` varchar(50) DEFAULT NULL COMMENT '薪水',
  `quantity` varchar(50) DEFAULT NULL COMMENT '数量',
  `sex` int(1) DEFAULT NULL COMMENT '性别',
  `height` varchar(50) DEFAULT NULL COMMENT '身高',
  `linkman` varchar(50) DEFAULT NULL COMMENT '联系人',
  `mobilephone` varchar(50) DEFAULT NULL COMMENT '手机',
  `QQ` varchar(50) DEFAULT NULL COMMENT 'QQ',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `job_yao_qiu` text COMMENT '招聘要求',
  `pass` smallint(1) DEFAULT '0' COMMENT '是否通过审核',
  `store_id` int(10) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`model_job_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of hai_model_job
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_nav`
-- ----------------------------
DROP TABLE IF EXISTS `hai_nav`;
CREATE TABLE `hai_nav` (
  `id` mediumint(8) NOT NULL AUTO_INCREMENT,
  `ctype` varchar(10) DEFAULT NULL,
  `cid` smallint(5) unsigned DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `ifshow` smallint(5) DEFAULT NULL,
  `vieworder` smallint(5) DEFAULT NULL,
  `opennew` smallint(5) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `sub_nav` text COMMENT '子栏',
  `store_id` int(11) DEFAULT NULL,
  `className` varchar(20) DEFAULT NULL COMMENT '样式名称',
  `parent_nav_id` int(10) DEFAULT '0' COMMENT '父栏目',
  `thumb` varchar(200) DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `type` (`type`),
  KEY `ifshow` (`ifshow`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_nav
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_nav_promotion`
-- ----------------------------
DROP TABLE IF EXISTS `hai_nav_promotion`;
CREATE TABLE `hai_nav_promotion` (
  `id` mediumint(8) NOT NULL AUTO_INCREMENT,
  `nav_id` int(10) DEFAULT NULL COMMENT 'hai_nav的外键联接字段',
  `name` varchar(255) NOT NULL,
  `ifshow` tinyint(1) NOT NULL,
  `vieworder` tinyint(1) NOT NULL,
  `opennew` tinyint(1) NOT NULL,
  `url` varchar(255) NOT NULL,
  `img_url` varchar(200) DEFAULT NULL COMMENT '图片地址',
  `nav_left_type` int(11) DEFAULT NULL COMMENT '图片类型',
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ifshow` (`ifshow`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_nav_promotion
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_note`
-- ----------------------------
DROP TABLE IF EXISTS `hai_note`;
CREATE TABLE `hai_note` (
  `note_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  `note` text,
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`note_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_note
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_notice`
-- ----------------------------
DROP TABLE IF EXISTS `hai_notice`;
CREATE TABLE `hai_notice` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `notice` text,
  `is_show` int(11) DEFAULT '1',
  `start_date` date DEFAULT NULL COMMENT '生效日期',
  `end_date` date DEFAULT NULL COMMENT '截止日期',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `store_id` int(11) DEFAULT '0' COMMENT '商家编号',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_notice
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_order_action`
-- ----------------------------
DROP TABLE IF EXISTS `hai_order_action`;
CREATE TABLE `hai_order_action` (
  `action_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `action_user` varchar(30) NOT NULL DEFAULT '',
  `order_status` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `shipping_status` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `pay_status` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `action_place` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `action_note` varchar(255) NOT NULL DEFAULT '',
  `log_time` int(11) unsigned NOT NULL DEFAULT '0',
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`action_id`),
  KEY `order_id` (`order_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_order_action
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_order_goods`
-- ----------------------------
DROP TABLE IF EXISTS `hai_order_goods`;
CREATE TABLE `hai_order_goods` (
  `rec_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `sub_order_sn` varchar(50) DEFAULT NULL COMMENT '商家子订单号',
  `goods_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `goods_name` varchar(120) NOT NULL DEFAULT '',
  `goods_sn` varchar(60) NOT NULL DEFAULT '',
  `product_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `goods_number` smallint(5) unsigned NOT NULL DEFAULT '1',
  `market_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `goods_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `goods_attr` text NOT NULL,
  `goods_thumb` varchar(255) DEFAULT NULL,
  `send_number` smallint(5) unsigned NOT NULL DEFAULT '0',
  `is_real` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `extension_code` varchar(30) NOT NULL DEFAULT '',
  `parent_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `is_gift` smallint(5) unsigned NOT NULL DEFAULT '0',
  `goods_attr_id` varchar(255) NOT NULL DEFAULT '',
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`rec_id`),
  KEY `order_id` (`order_id`),
  KEY `goods_id` (`goods_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_order_goods
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_order_info`
-- ----------------------------
DROP TABLE IF EXISTS `hai_order_info`;
CREATE TABLE `hai_order_info` (
  `order_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `order_sn` varchar(30) NOT NULL DEFAULT '',
  `user_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `order_status` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `shipping_status` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `pay_status` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `consignee` varchar(60) NOT NULL DEFAULT '',
  `country` smallint(5) unsigned NOT NULL DEFAULT '0',
  `province` smallint(5) unsigned NOT NULL DEFAULT '0',
  `city` smallint(5) unsigned NOT NULL DEFAULT '0',
  `county` smallint(5) NOT NULL DEFAULT '0',
  `district` smallint(5) unsigned DEFAULT '0',
  `street` smallint(5) DEFAULT '0',
  `address` varchar(255) NOT NULL DEFAULT '',
  `zipcode` varchar(60) NOT NULL DEFAULT '',
  `tel` varchar(60) NOT NULL DEFAULT '',
  `mobile` varchar(60) NOT NULL DEFAULT '',
  `email` varchar(60) NOT NULL DEFAULT '',
  `best_time` varchar(120) NOT NULL DEFAULT '',
  `sign_building` varchar(120) NOT NULL DEFAULT '',
  `postscript` varchar(255) NOT NULL DEFAULT '',
  `shipping_id` tinyint(3) NOT NULL DEFAULT '0',
  `shipping_name` varchar(120) NOT NULL DEFAULT '',
  `pay_id` tinyint(3) NOT NULL DEFAULT '0',
  `pay_name` varchar(120) NOT NULL DEFAULT '',
  `how_oos` varchar(120) NOT NULL DEFAULT '',
  `how_surplus` varchar(120) NOT NULL DEFAULT '',
  `pack_name` varchar(120) NOT NULL DEFAULT '',
  `card_name` varchar(120) NOT NULL DEFAULT '',
  `card_message` varchar(255) NOT NULL DEFAULT '',
  `inv_payee` varchar(120) NOT NULL DEFAULT '',
  `inv_content` varchar(120) NOT NULL DEFAULT '',
  `goods_amount` decimal(10,2) NOT NULL DEFAULT '0.00',
  `shipping_fee` decimal(10,2) NOT NULL DEFAULT '0.00',
  `insure_fee` decimal(10,2) NOT NULL DEFAULT '0.00',
  `pay_fee` decimal(10,2) NOT NULL DEFAULT '0.00',
  `pack_fee` decimal(10,2) NOT NULL DEFAULT '0.00',
  `card_fee` decimal(10,2) NOT NULL DEFAULT '0.00',
  `money_paid` decimal(10,2) NOT NULL DEFAULT '0.00',
  `surplus` decimal(10,2) NOT NULL DEFAULT '0.00',
  `integral` int(10) unsigned NOT NULL DEFAULT '0',
  `integral_money` decimal(10,2) NOT NULL DEFAULT '0.00',
  `bonus` decimal(10,2) NOT NULL DEFAULT '0.00',
  `order_amount` decimal(10,2) NOT NULL DEFAULT '0.00',
  `from_ad` smallint(5) NOT NULL DEFAULT '0',
  `referer` varchar(255) NOT NULL DEFAULT '',
  `add_time` int(10) unsigned NOT NULL DEFAULT '0',
  `confirm_time` int(10) unsigned NOT NULL DEFAULT '0',
  `pay_time` int(10) unsigned NOT NULL DEFAULT '0',
  `shipping_time` int(10) unsigned NOT NULL DEFAULT '0',
  `pack_id` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `card_id` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `bonus_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `invoice_no` varchar(255) NOT NULL DEFAULT '',
  `extension_code` varchar(30) NOT NULL DEFAULT '',
  `extension_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `to_buyer` varchar(255) NOT NULL DEFAULT '',
  `pay_note` varchar(255) NOT NULL DEFAULT '',
  `agency_id` smallint(5) unsigned NOT NULL,
  `inv_type` varchar(60) NOT NULL,
  `tax` decimal(10,2) NOT NULL,
  `is_separate` tinyint(1) NOT NULL DEFAULT '0',
  `parent_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `discount` decimal(10,2) NOT NULL,
  `store_id` int(11) DEFAULT NULL,
  `remark` text COMMENT '备注',
  `is_void` enum('1','0') DEFAULT '1',
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `order_sn` (`order_sn`),
  KEY `user_id` (`user_id`),
  KEY `order_status` (`order_status`),
  KEY `shipping_status` (`shipping_status`),
  KEY `pay_status` (`pay_status`),
  KEY `shipping_id` (`shipping_id`),
  KEY `pay_id` (`pay_id`),
  KEY `extension_code` (`extension_code`,`extension_id`),
  KEY `agency_id` (`agency_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_order_info
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_order_pay_extends`
-- ----------------------------
DROP TABLE IF EXISTS `hai_order_pay_extends`;
CREATE TABLE `hai_order_pay_extends` (
  `order_pay_extends_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_pay_id` bigint(20) DEFAULT NULL,
  `realname` varchar(50) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `openid` varchar(100) DEFAULT NULL,
  `face` varchar(200) DEFAULT NULL COMMENT '头像',
  `order_body` text,
  `prepay_id` varchar(100) DEFAULT NULL,
  `guestbook` varchar(200) DEFAULT NULL COMMENT '留言',
  `createdate` datetime DEFAULT NULL,
  `remark` text,
  `anonymous` int(5) DEFAULT '0' COMMENT '0:非匿名，1：匿名，不显示名称',
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_pay_extends_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_order_pay_extends
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_order_pay_record`
-- ----------------------------
DROP TABLE IF EXISTS `hai_order_pay_record`;
CREATE TABLE `hai_order_pay_record` (
  `order_pay_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `wxid` int(11) DEFAULT NULL,
  `order_sn` varchar(100) DEFAULT NULL COMMENT '支付订单编号',
  `order_pay_source` enum('unionpay','alipay','paybill','weixin') DEFAULT NULL,
  `order_status` int(5) DEFAULT NULL COMMENT '0:刚插入，1：支付成功，2：取消支付，3：支付失败',
  `amount` int(11) DEFAULT NULL,
  `table_name` varchar(50) DEFAULT NULL COMMENT '对应记录表',
  `table_id` bigint(20) DEFAULT NULL COMMENT '对应表格的编号',
  `store_id` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `remark` text COMMENT '备注',
  `order_body` text,
  `prepay_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`order_pay_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单支付记录，包括微信，支付宝，银联等多种支付\r\n';

-- ----------------------------
-- Records of hai_order_pay_record
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_pack`
-- ----------------------------
DROP TABLE IF EXISTS `hai_pack`;
CREATE TABLE `hai_pack` (
  `pack_id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `pack_name` varchar(120) NOT NULL DEFAULT '',
  `pack_img` varchar(255) NOT NULL DEFAULT '',
  `pack_fee` decimal(6,2) unsigned NOT NULL DEFAULT '0.00',
  `free_money` smallint(5) unsigned NOT NULL DEFAULT '0',
  `pack_desc` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`pack_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_pack
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_package_goods`
-- ----------------------------
DROP TABLE IF EXISTS `hai_package_goods`;
CREATE TABLE `hai_package_goods` (
  `package_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `goods_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `product_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `goods_number` smallint(5) unsigned NOT NULL DEFAULT '1',
  `admin_id` tinyint(3) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`package_id`,`goods_id`,`admin_id`,`product_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_package_goods
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_payment`
-- ----------------------------
DROP TABLE IF EXISTS `hai_payment`;
CREATE TABLE `hai_payment` (
  `pay_id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `pay_code` varchar(20) NOT NULL DEFAULT '',
  `pay_name` varchar(120) NOT NULL DEFAULT '',
  `pay_fee` varchar(10) NOT NULL DEFAULT '0',
  `pay_desc` text NOT NULL,
  `pay_order` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `pay_config` text NOT NULL,
  `enabled` tinyint(1) unsigned NOT NULL DEFAULT '1',
  `is_default` tinyint(1) NOT NULL DEFAULT '0',
  `is_cod` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `is_online` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `className` varchar(20) DEFAULT NULL COMMENT '样式名称',
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pay_id`),
  UNIQUE KEY `pay_code` (`pay_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_payment
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_pay_log`
-- ----------------------------
DROP TABLE IF EXISTS `hai_pay_log`;
CREATE TABLE `hai_pay_log` (
  `log_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `order_amount` decimal(10,2) unsigned NOT NULL,
  `order_type` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `is_paid` tinyint(1) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`log_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_pay_log
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_plugins`
-- ----------------------------
DROP TABLE IF EXISTS `hai_plugins`;
CREATE TABLE `hai_plugins` (
  `code` varchar(30) NOT NULL DEFAULT '',
  `version` varchar(10) NOT NULL DEFAULT '',
  `library` varchar(255) NOT NULL DEFAULT '',
  `assign` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `install_date` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_plugins
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_products`
-- ----------------------------
DROP TABLE IF EXISTS `hai_products`;
CREATE TABLE `hai_products` (
  `product_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `goods_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `goods_attr` varchar(50) DEFAULT NULL,
  `product_sn` varchar(60) DEFAULT NULL,
  `product_number` smallint(5) unsigned DEFAULT '0',
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_products
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_region`
-- ----------------------------
DROP TABLE IF EXISTS `hai_region`;
CREATE TABLE `hai_region` (
  `region_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `parent_id` smallint(5) unsigned NOT NULL DEFAULT '0',
  `region_name` varchar(120) NOT NULL DEFAULT '',
  `region_type` tinyint(1) NOT NULL DEFAULT '2',
  `agency_id` smallint(5) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`region_id`),
  KEY `parent_id` (`parent_id`),
  KEY `region_type` (`region_type`),
  KEY `agency_id` (`agency_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_region
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_reg_extend_info`
-- ----------------------------
DROP TABLE IF EXISTS `hai_reg_extend_info`;
CREATE TABLE `hai_reg_extend_info` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` mediumint(8) unsigned NOT NULL,
  `reg_field_id` int(10) unsigned NOT NULL,
  `reg_field_name` varchar(60) DEFAULT NULL,
  `content` text NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_reg_extend_info
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_reg_fields`
-- ----------------------------
DROP TABLE IF EXISTS `hai_reg_fields`;
CREATE TABLE `hai_reg_fields` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `reg_field_name` varchar(60) NOT NULL,
  `reg_field_cn_name` varchar(200) DEFAULT NULL,
  `dis_order` tinyint(3) unsigned NOT NULL DEFAULT '100',
  `display` tinyint(1) unsigned NOT NULL DEFAULT '1',
  `type` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `is_need` tinyint(1) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_reg_fields
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_role`
-- ----------------------------
DROP TABLE IF EXISTS `hai_role`;
CREATE TABLE `hai_role` (
  `role_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `role_name` varchar(60) NOT NULL DEFAULT '',
  `action_list` text NOT NULL,
  `role_describe` text,
  PRIMARY KEY (`role_id`),
  KEY `user_name` (`role_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_role
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_searchengine`
-- ----------------------------
DROP TABLE IF EXISTS `hai_searchengine`;
CREATE TABLE `hai_searchengine` (
  `date` date NOT NULL DEFAULT '0000-00-00',
  `searchengine` varchar(20) NOT NULL DEFAULT '',
  `count` mediumint(8) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`date`,`searchengine`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_searchengine
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_sectors`
-- ----------------------------
DROP TABLE IF EXISTS `hai_sectors`;
CREATE TABLE `hai_sectors` (
  `sectors_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `sectors_name` varchar(50) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `store_id` int(11) DEFAULT NULL,
  `is_top` smallint(1) DEFAULT NULL COMMENT '是否热门榜单',
  `order` int(11) DEFAULT '1' COMMENT '排序',
  `is_header` smallint(1) DEFAULT NULL COMMENT 'parent_id为0时，此值为1就是显示在header上面',
  PRIMARY KEY (`sectors_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_sectors
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_sessions`
-- ----------------------------
DROP TABLE IF EXISTS `hai_sessions`;
CREATE TABLE `hai_sessions` (
  `sesskey` char(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '',
  `expiry` int(10) unsigned NOT NULL DEFAULT '0',
  `userid` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `adminid` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `ip` char(15) NOT NULL DEFAULT '',
  `user_name` varchar(60) NOT NULL,
  `user_rank` tinyint(3) NOT NULL,
  `discount` decimal(3,2) NOT NULL,
  `email` varchar(60) NOT NULL,
  `data` char(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`sesskey`),
  KEY `expiry` (`expiry`)
) ENGINE=MEMORY DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_sessions
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_sessions_data`
-- ----------------------------
DROP TABLE IF EXISTS `hai_sessions_data`;
CREATE TABLE `hai_sessions_data` (
  `sesskey` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '',
  `expiry` int(10) unsigned NOT NULL DEFAULT '0',
  `data` longtext NOT NULL,
  PRIMARY KEY (`sesskey`),
  KEY `expiry` (`expiry`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_sessions_data
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_shipping`
-- ----------------------------
DROP TABLE IF EXISTS `hai_shipping`;
CREATE TABLE `hai_shipping` (
  `shipping_id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `shipping_code` varchar(20) NOT NULL DEFAULT '',
  `shipping_name` varchar(120) NOT NULL DEFAULT '',
  `shipping_desc` varchar(255) NOT NULL DEFAULT '',
  `insure` varchar(10) NOT NULL DEFAULT '0',
  `support_cod` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `enabled` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `is_default` tinyint(1) DEFAULT '0',
  `shipping_print` text NOT NULL,
  `print_bg` varchar(255) DEFAULT NULL,
  `config_lable` text,
  `print_model` tinyint(1) DEFAULT '0',
  `shipping_order` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `store_id` int(11) DEFAULT NULL,
  `className` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`shipping_id`),
  KEY `shipping_code` (`shipping_code`,`enabled`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of hai_shipping
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_shipping_area`
-- ----------------------------
DROP TABLE IF EXISTS `hai_shipping_area`;
CREATE TABLE `hai_shipping_area` (
  `shipping_area_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `shipping_area_name` varchar(150) NOT NULL DEFAULT '',
  `shipping_id` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `configure` text NOT NULL,
  PRIMARY KEY (`shipping_area_id`),
  KEY `shipping_id` (`shipping_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_shipping_area
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_shop_config`
-- ----------------------------
DROP TABLE IF EXISTS `hai_shop_config`;
CREATE TABLE `hai_shop_config` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `parent_id` smallint(5) unsigned NOT NULL DEFAULT '0',
  `code` varchar(30) NOT NULL DEFAULT '',
  `code_text` varchar(20) DEFAULT NULL,
  `type` varchar(10) NOT NULL DEFAULT '',
  `store_range` varchar(255) NOT NULL DEFAULT '',
  `store_dir` varchar(255) NOT NULL DEFAULT '',
  `value` text NOT NULL,
  `sort_order` tinyint(3) unsigned NOT NULL DEFAULT '1',
  `store_id` int(11) DEFAULT NULL,
  `isvoid` enum('0','1') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_shop_config
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_snatch_log`
-- ----------------------------
DROP TABLE IF EXISTS `hai_snatch_log`;
CREATE TABLE `hai_snatch_log` (
  `log_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `snatch_id` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `user_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `bid_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `bid_time` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`log_id`),
  KEY `snatch_id` (`snatch_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_snatch_log
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_stats`
-- ----------------------------
DROP TABLE IF EXISTS `hai_stats`;
CREATE TABLE `hai_stats` (
  `access_time` int(10) unsigned NOT NULL DEFAULT '0',
  `ip_address` varchar(15) NOT NULL DEFAULT '',
  `visit_times` smallint(5) unsigned NOT NULL DEFAULT '1',
  `browser` varchar(60) NOT NULL DEFAULT '',
  `system` varchar(20) NOT NULL DEFAULT '',
  `language` varchar(20) NOT NULL DEFAULT '',
  `area` varchar(30) NOT NULL DEFAULT '',
  `referer_domain` varchar(100) NOT NULL DEFAULT '',
  `referer_path` varchar(200) NOT NULL DEFAULT '',
  `access_url` varchar(255) NOT NULL DEFAULT '',
  `store_id` int(11) DEFAULT NULL,
  KEY `access_time` (`access_time`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_stats
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_store`
-- ----------------------------
DROP TABLE IF EXISTS `hai_store`;
CREATE TABLE `hai_store` (
  `store_id` int(10) unsigned NOT NULL DEFAULT '0',
  `store_name` varchar(100) NOT NULL DEFAULT '',
  `owner_name` varchar(60) NOT NULL DEFAULT '',
  `owner_card` varchar(60) NOT NULL DEFAULT '',
  `region_id` int(10) unsigned DEFAULT NULL,
  `region_name` varchar(100) DEFAULT NULL,
  `address` varchar(255) NOT NULL DEFAULT '',
  `zipcode` varchar(20) NOT NULL DEFAULT '',
  `tel` varchar(60) NOT NULL DEFAULT '',
  `sgrade` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `apply_remark` varchar(255) NOT NULL DEFAULT '',
  `credit_value` int(10) NOT NULL DEFAULT '0',
  `praise_rate` decimal(5,2) unsigned NOT NULL DEFAULT '0.00',
  `domain` varchar(60) DEFAULT NULL,
  `state` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `close_reason` varchar(255) NOT NULL DEFAULT '',
  `add_time` int(10) unsigned DEFAULT NULL,
  `end_time` int(10) unsigned NOT NULL DEFAULT '0',
  `certification` varchar(255) DEFAULT NULL,
  `sort_order` smallint(5) unsigned NOT NULL DEFAULT '0',
  `recommended` tinyint(4) NOT NULL DEFAULT '0',
  `theme` varchar(60) NOT NULL DEFAULT '',
  `store_banner` varchar(255) DEFAULT NULL,
  `store_logo` varchar(255) DEFAULT NULL,
  `description` text,
  `image_1` varchar(255) NOT NULL DEFAULT '',
  `image_2` varchar(255) NOT NULL DEFAULT '',
  `image_3` varchar(255) NOT NULL DEFAULT '',
  `im_qq` varchar(60) NOT NULL DEFAULT '',
  `im_ww` varchar(60) NOT NULL DEFAULT '',
  `im_msn` varchar(60) NOT NULL DEFAULT '',
  `enable_groupbuy` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `enable_radar` tinyint(1) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`store_id`),
  KEY `store_name` (`store_name`),
  KEY `owner_name` (`owner_name`),
  KEY `region_id` (`region_id`),
  KEY `domain` (`domain`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_store
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_store_appkey_secret`
-- ----------------------------
DROP TABLE IF EXISTS `hai_store_appkey_secret`;
CREATE TABLE `hai_store_appkey_secret` (
  `app_id` int(5) NOT NULL AUTO_INCREMENT,
  `appkey` varchar(64) NOT NULL,
  `secret` varchar(128) NOT NULL,
  `store_id` int(11) NOT NULL,
  `logo` varchar(200) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `desc` longtext,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `isvalid` enum('0','1') NOT NULL DEFAULT '1',
  PRIMARY KEY (`app_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of hai_store_appkey_secret
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_suppliers`
-- ----------------------------
DROP TABLE IF EXISTS `hai_suppliers`;
CREATE TABLE `hai_suppliers` (
  `suppliers_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `suppliers_name` varchar(255) DEFAULT NULL,
  `suppliers_desc` mediumtext,
  `is_check` tinyint(1) unsigned NOT NULL DEFAULT '1',
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`suppliers_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_suppliers
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_tag`
-- ----------------------------
DROP TABLE IF EXISTS `hai_tag`;
CREATE TABLE `hai_tag` (
  `tag_id` mediumint(8) NOT NULL AUTO_INCREMENT,
  `user_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `goods_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `tag_words` varchar(255) NOT NULL DEFAULT '',
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`tag_id`),
  KEY `user_id` (`user_id`),
  KEY `goods_id` (`goods_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_tag
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_taobao`
-- ----------------------------
DROP TABLE IF EXISTS `hai_taobao`;
CREATE TABLE `hai_taobao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `session` varchar(255) DEFAULT NULL,
  `nick` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_taobao
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_taobao_order`
-- ----------------------------
DROP TABLE IF EXISTS `hai_taobao_order`;
CREATE TABLE `hai_taobao_order` (
  `order_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `order_sn` varchar(255) NOT NULL DEFAULT '',
  `order_title` varchar(255) NOT NULL DEFAULT '0',
  `order_status` varchar(255) NOT NULL DEFAULT '0',
  `shipping_status` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `pay_status` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `consignee` varchar(60) NOT NULL DEFAULT '',
  `country` smallint(5) unsigned NOT NULL DEFAULT '0',
  `province` smallint(5) unsigned NOT NULL DEFAULT '0',
  `city` smallint(5) unsigned NOT NULL DEFAULT '0',
  `district` smallint(5) unsigned NOT NULL DEFAULT '0',
  `address` varchar(255) NOT NULL DEFAULT '',
  `zipcode` varchar(60) NOT NULL DEFAULT '',
  `tel` varchar(60) NOT NULL DEFAULT '',
  `mobile` varchar(60) NOT NULL DEFAULT '',
  `email` varchar(60) NOT NULL DEFAULT '',
  `best_time` varchar(120) NOT NULL DEFAULT '',
  `sign_building` varchar(120) NOT NULL DEFAULT '',
  `postscript` varchar(255) NOT NULL DEFAULT '',
  `shipping_id` tinyint(3) NOT NULL DEFAULT '0',
  `shipping_name` varchar(120) NOT NULL DEFAULT '',
  `pay_id` tinyint(3) NOT NULL DEFAULT '0',
  `pay_name` varchar(120) NOT NULL DEFAULT '',
  `how_oos` varchar(120) NOT NULL DEFAULT '',
  `how_surplus` varchar(120) NOT NULL DEFAULT '',
  `pack_name` varchar(120) NOT NULL DEFAULT '',
  `card_name` varchar(120) NOT NULL DEFAULT '',
  `card_message` varchar(255) NOT NULL DEFAULT '',
  `inv_payee` varchar(120) NOT NULL DEFAULT '',
  `inv_content` varchar(120) NOT NULL DEFAULT '',
  `goods_amount` decimal(10,2) NOT NULL DEFAULT '0.00',
  `shipping_fee` decimal(10,2) NOT NULL DEFAULT '0.00',
  `insure_fee` decimal(10,2) NOT NULL DEFAULT '0.00',
  `pay_fee` decimal(10,2) NOT NULL DEFAULT '0.00',
  `pack_fee` decimal(10,2) NOT NULL DEFAULT '0.00',
  `card_fee` decimal(10,2) NOT NULL DEFAULT '0.00',
  `money_paid` decimal(10,2) NOT NULL DEFAULT '0.00',
  `surplus` decimal(10,2) NOT NULL DEFAULT '0.00',
  `integral` int(10) unsigned NOT NULL DEFAULT '0',
  `integral_money` decimal(10,2) NOT NULL DEFAULT '0.00',
  `bonus` decimal(10,2) NOT NULL DEFAULT '0.00',
  `order_amount` decimal(10,2) NOT NULL DEFAULT '0.00',
  `from_ad` smallint(5) NOT NULL DEFAULT '0',
  `referer` varchar(255) NOT NULL DEFAULT '',
  `add_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `confirm_time` int(10) unsigned NOT NULL DEFAULT '0',
  `pay_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `shipping_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `pack_id` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `card_id` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `bonus_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `invoice_no` varchar(255) NOT NULL DEFAULT '',
  `extension_code` varchar(30) NOT NULL DEFAULT '',
  `extension_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `to_buyer` varchar(255) NOT NULL DEFAULT '',
  `pay_note` varchar(255) NOT NULL DEFAULT '',
  `agency_id` smallint(5) unsigned NOT NULL,
  `inv_type` varchar(60) NOT NULL,
  `tax` decimal(10,2) NOT NULL,
  `is_separate` tinyint(1) NOT NULL DEFAULT '0',
  `parent_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `discount` decimal(10,2) NOT NULL,
  `adjust_fee` decimal(10,2) DEFAULT NULL,
  `buyer_rate` varchar(6) DEFAULT NULL,
  `discount_fee` decimal(10,2) DEFAULT NULL,
  `order_iid` varchar(40) DEFAULT NULL,
  `goods_price` decimal(10,2) DEFAULT NULL,
  `refund_status` varchar(10) DEFAULT NULL,
  `seller_rate` varchar(6) DEFAULT NULL,
  `seller_type` varchar(5) DEFAULT NULL,
  `buyer_nick` varchar(255) DEFAULT NULL,
  `goods_num` int(4) DEFAULT NULL,
  `user_name` varchar(10) DEFAULT NULL,
  `chick_status` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `order_sn` (`order_sn`),
  KEY `user_id` (`order_title`),
  KEY `order_status` (`order_status`),
  KEY `shipping_status` (`shipping_status`),
  KEY `pay_status` (`pay_status`),
  KEY `shipping_id` (`shipping_id`),
  KEY `pay_id` (`pay_id`),
  KEY `extension_code` (`extension_code`,`extension_id`),
  KEY `agency_id` (`agency_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_taobao_order
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_template`
-- ----------------------------
DROP TABLE IF EXISTS `hai_template`;
CREATE TABLE `hai_template` (
  `filename` varchar(30) NOT NULL DEFAULT '',
  `region` varchar(40) NOT NULL DEFAULT '',
  `library` varchar(40) NOT NULL DEFAULT '',
  `sort_order` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `id` smallint(5) unsigned NOT NULL DEFAULT '0',
  `number` tinyint(1) unsigned NOT NULL DEFAULT '5',
  `type` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `theme` varchar(60) NOT NULL DEFAULT '',
  `remarks` varchar(30) NOT NULL DEFAULT '',
  KEY `filename` (`filename`,`region`),
  KEY `theme` (`theme`),
  KEY `remarks` (`remarks`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_template
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_time_axisn`
-- ----------------------------
DROP TABLE IF EXISTS `hai_time_axisn`;
CREATE TABLE `hai_time_axisn` (
  `time_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `summary` varchar(200) DEFAULT NULL,
  `content` text,
  `his_date` date DEFAULT NULL,
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`time_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_time_axisn
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_topic`
-- ----------------------------
DROP TABLE IF EXISTS `hai_topic`;
CREATE TABLE `hai_topic` (
  `topic_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL DEFAULT '''''',
  `intro` text NOT NULL,
  `start_time` int(11) NOT NULL DEFAULT '0',
  `end_time` int(10) NOT NULL DEFAULT '0',
  `data` text NOT NULL,
  `template` varchar(255) NOT NULL DEFAULT '''''',
  `css` text NOT NULL,
  `topic_img` varchar(255) DEFAULT NULL,
  `title_pic` varchar(255) DEFAULT NULL,
  `base_style` char(6) DEFAULT NULL,
  `htmls` mediumtext,
  `keywords` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  KEY `topic_id` (`topic_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_topic
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_translation_info`
-- ----------------------------
DROP TABLE IF EXISTS `hai_translation_info`;
CREATE TABLE `hai_translation_info` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL,
  `Translation_name` varchar(100) DEFAULT NULL,
  `age` int(4) DEFAULT NULL,
  `sex` int(2) DEFAULT NULL,
  `face_path` varchar(200) DEFAULT NULL COMMENT '头像图片',
  `xueli` varchar(50) DEFAULT NULL COMMENT '学历',
  `school` varchar(100) DEFAULT NULL,
  `translation_type` varchar(200) DEFAULT NULL COMMENT '翻译类型',
  `city` varchar(50) DEFAULT NULL,
  `xinshui` varchar(50) DEFAULT NULL,
  `self_introduction` text,
  `experience` text,
  `telephone` varchar(50) DEFAULT NULL,
  `mobilephone` varchar(50) DEFAULT NULL,
  `qq` varchar(50) DEFAULT NULL,
  `weixin` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `pass` smallint(1) DEFAULT '0' COMMENT '是否通过审核',
  `store_id` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_translation_info
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_translation_job`
-- ----------------------------
DROP TABLE IF EXISTS `hai_translation_job`;
CREATE TABLE `hai_translation_job` (
  `t_job_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL COMMENT '标题',
  `issue_date` date DEFAULT NULL COMMENT '发布日期',
  `end_date` date DEFAULT NULL COMMENT '截止日期',
  `city` varchar(50) DEFAULT NULL COMMENT '所在城市',
  `job_type` varchar(100) DEFAULT NULL COMMENT '工作类型',
  `xinshui` varchar(50) DEFAULT NULL COMMENT '薪水',
  `quantity` varchar(50) DEFAULT NULL COMMENT '数量',
  `sex` int(1) DEFAULT NULL COMMENT '性别',
  `height` varchar(50) DEFAULT NULL COMMENT '身高',
  `linkman` varchar(50) DEFAULT NULL COMMENT '联系人',
  `mobilephone` varchar(50) DEFAULT NULL COMMENT '手机',
  `QQ` varchar(50) DEFAULT NULL COMMENT 'QQ',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `job_yao_qiu` text COMMENT '招聘要求',
  `pass` smallint(1) DEFAULT '0' COMMENT '是否通过审核',
  `store_id` int(10) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`t_job_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of hai_translation_job
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_users`
-- ----------------------------
DROP TABLE IF EXISTS `hai_users`;
CREATE TABLE `hai_users` (
  `user_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(100) DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `nickname` varchar(100) DEFAULT NULL COMMENT '昵称',
  `realname` varchar(100) DEFAULT NULL COMMENT '真实姓名',
  `question` varchar(255) DEFAULT NULL,
  `answer` varchar(255) DEFAULT '',
  `sex` tinyint(1) unsigned DEFAULT '0',
  `birthday` date DEFAULT '0000-00-00',
  `user_money` decimal(10,2) DEFAULT '0.00',
  `frozen_money` decimal(10,2) DEFAULT '0.00',
  `pay_points` int(10) unsigned DEFAULT '0',
  `rank_points` int(10) unsigned DEFAULT '0',
  `address` varchar(200) DEFAULT NULL,
  `address_id` mediumint(8) unsigned DEFAULT '0',
  `reg_time` datetime DEFAULT NULL,
  `last_login` datetime DEFAULT NULL,
  `last_time` datetime DEFAULT '0000-00-00 00:00:00',
  `last_ip` varchar(15) DEFAULT '',
  `visit_count` smallint(5) unsigned DEFAULT '0',
  `user_rank` tinyint(3) unsigned DEFAULT '0',
  `is_special` tinyint(3) unsigned DEFAULT '0',
  `ec_salt` varchar(10) DEFAULT NULL,
  `salt` varchar(10) DEFAULT '0',
  `parent_id` mediumint(9) DEFAULT '0',
  `flag` tinyint(3) unsigned DEFAULT '0',
  `alias` varchar(60) DEFAULT NULL,
  `msn` varchar(60) DEFAULT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `office_phone` varchar(20) DEFAULT NULL,
  `home_phone` varchar(20) DEFAULT NULL,
  `mobile_phone` varchar(20) DEFAULT NULL,
  `is_validated` tinyint(3) unsigned DEFAULT '0',
  `credit_line` decimal(10,2) unsigned DEFAULT NULL,
  `passwd_question` varchar(50) DEFAULT NULL,
  `passwd_answer` varchar(255) DEFAULT NULL,
  `store_id` int(11) DEFAULT NULL,
  `country` smallint(6) DEFAULT NULL,
  `province` smallint(6) DEFAULT NULL,
  `city` smallint(6) DEFAULT NULL,
  `county` smallint(6) DEFAULT NULL,
  `district` smallint(6) DEFAULT NULL,
  `street` smallint(6) DEFAULT NULL,
  `self_description` text COMMENT '自我描述',
  `user_type` smallint(1) DEFAULT '0' COMMENT '0:普通用户，1:企业',
  `face_image` varchar(200) DEFAULT NULL COMMENT '头像',
  `openid` varchar(100) DEFAULT NULL,
  `subscribe` int(5) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`),
  KEY `email` (`email`),
  KEY `parent_id` (`parent_id`),
  KEY `flag` (`flag`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_users
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_user_account`
-- ----------------------------
DROP TABLE IF EXISTS `hai_user_account`;
CREATE TABLE `hai_user_account` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `admin_user` varchar(255) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `add_time` int(10) NOT NULL DEFAULT '0',
  `paid_time` int(10) NOT NULL DEFAULT '0',
  `admin_note` varchar(255) NOT NULL,
  `user_note` varchar(255) NOT NULL,
  `process_type` tinyint(1) NOT NULL DEFAULT '0',
  `payment` varchar(90) NOT NULL,
  `is_paid` tinyint(1) NOT NULL DEFAULT '0',
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `is_paid` (`is_paid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_user_account
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_user_address`
-- ----------------------------
DROP TABLE IF EXISTS `hai_user_address`;
CREATE TABLE `hai_user_address` (
  `address_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `address_name` varchar(50) NOT NULL DEFAULT '',
  `user_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `consignee` varchar(60) NOT NULL DEFAULT '',
  `email` varchar(60) NOT NULL DEFAULT '',
  `country` smallint(5) NOT NULL DEFAULT '0',
  `province` smallint(5) NOT NULL DEFAULT '0',
  `city` smallint(5) NOT NULL DEFAULT '0',
  `county` smallint(5) DEFAULT '0',
  `district` smallint(5) NOT NULL DEFAULT '0',
  `street` smallint(5) DEFAULT '0' COMMENT '街道办',
  `address` varchar(120) NOT NULL DEFAULT '',
  `zipcode` varchar(60) NOT NULL DEFAULT '',
  `tel` varchar(60) NOT NULL DEFAULT '',
  `mobile` varchar(60) NOT NULL DEFAULT '',
  `sign_building` varchar(120) NOT NULL DEFAULT '',
  `best_time` varchar(120) NOT NULL DEFAULT '',
  `is_default` enum('0','1') NOT NULL DEFAULT '0' COMMENT '是否默认地址',
  `store_id` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL COMMENT '更新日期',
  `add_time` datetime DEFAULT NULL,
  PRIMARY KEY (`address_id`),
  KEY `user_id` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_user_address
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_user_bonus`
-- ----------------------------
DROP TABLE IF EXISTS `hai_user_bonus`;
CREATE TABLE `hai_user_bonus` (
  `bonus_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `bonus_type_id` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `bonus_sn` bigint(20) unsigned NOT NULL DEFAULT '0',
  `user_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `used_time` int(10) unsigned NOT NULL DEFAULT '0',
  `order_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `emailed` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`bonus_id`),
  KEY `user_id` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_user_bonus
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_user_feed`
-- ----------------------------
DROP TABLE IF EXISTS `hai_user_feed`;
CREATE TABLE `hai_user_feed` (
  `feed_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `value_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `goods_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `feed_type` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `is_feed` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`feed_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_user_feed
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_user_login`
-- ----------------------------
DROP TABLE IF EXISTS `hai_user_login`;
CREATE TABLE `hai_user_login` (
  `login_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `session_id` varchar(64) DEFAULT NULL,
  `login_time` int(15) DEFAULT NULL,
  `longitude` float(10,6) DEFAULT NULL,
  `latitude` float(10,6) DEFAULT NULL,
  `login_ip` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`login_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_user_login
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_user_rank`
-- ----------------------------
DROP TABLE IF EXISTS `hai_user_rank`;
CREATE TABLE `hai_user_rank` (
  `rank_id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `rank_name` varchar(30) NOT NULL DEFAULT '',
  `min_points` int(10) unsigned NOT NULL DEFAULT '0',
  `max_points` int(10) unsigned NOT NULL DEFAULT '0',
  `discount` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `show_price` tinyint(1) unsigned NOT NULL DEFAULT '1',
  `special_rank` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `store_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`rank_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_user_rank
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_virtual_card`
-- ----------------------------
DROP TABLE IF EXISTS `hai_virtual_card`;
CREATE TABLE `hai_virtual_card` (
  `card_id` mediumint(8) NOT NULL AUTO_INCREMENT,
  `goods_id` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `card_sn` varchar(60) NOT NULL DEFAULT '',
  `card_password` varchar(60) NOT NULL DEFAULT '',
  `add_date` int(11) NOT NULL DEFAULT '0',
  `end_date` int(11) NOT NULL DEFAULT '0',
  `is_saled` tinyint(1) NOT NULL DEFAULT '0',
  `order_sn` varchar(20) NOT NULL DEFAULT '',
  `crc32` varchar(12) NOT NULL DEFAULT '0',
  PRIMARY KEY (`card_id`),
  KEY `goods_id` (`goods_id`),
  KEY `car_sn` (`card_sn`),
  KEY `is_saled` (`is_saled`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_virtual_card
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_volume_price`
-- ----------------------------
DROP TABLE IF EXISTS `hai_volume_price`;
CREATE TABLE `hai_volume_price` (
  `price_type` tinyint(1) unsigned NOT NULL,
  `goods_id` mediumint(8) unsigned NOT NULL,
  `volume_number` smallint(5) unsigned NOT NULL DEFAULT '0',
  `volume_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`price_type`,`goods_id`,`volume_number`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_volume_price
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_vote`
-- ----------------------------
DROP TABLE IF EXISTS `hai_vote`;
CREATE TABLE `hai_vote` (
  `vote_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `vote_name` varchar(250) NOT NULL DEFAULT '',
  `start_time` int(11) unsigned NOT NULL DEFAULT '0',
  `end_time` int(11) unsigned NOT NULL DEFAULT '0',
  `can_multi` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `vote_count` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`vote_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_vote
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_vote_log`
-- ----------------------------
DROP TABLE IF EXISTS `hai_vote_log`;
CREATE TABLE `hai_vote_log` (
  `log_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `vote_id` smallint(5) unsigned NOT NULL DEFAULT '0',
  `ip_address` varchar(15) NOT NULL DEFAULT '',
  `vote_time` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`log_id`),
  KEY `vote_id` (`vote_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_vote_log
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_vote_option`
-- ----------------------------
DROP TABLE IF EXISTS `hai_vote_option`;
CREATE TABLE `hai_vote_option` (
  `option_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `vote_id` smallint(5) unsigned NOT NULL DEFAULT '0',
  `option_name` varchar(250) NOT NULL DEFAULT '',
  `option_count` int(8) unsigned NOT NULL DEFAULT '0',
  `option_order` tinyint(3) unsigned NOT NULL DEFAULT '100',
  PRIMARY KEY (`option_id`),
  KEY `vote_id` (`vote_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_vote_option
-- ----------------------------

-- ----------------------------
-- Table structure for `hai_wholesale`
-- ----------------------------
DROP TABLE IF EXISTS `hai_wholesale`;
CREATE TABLE `hai_wholesale` (
  `act_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `goods_id` mediumint(8) unsigned NOT NULL,
  `goods_name` varchar(255) NOT NULL,
  `rank_ids` varchar(255) NOT NULL,
  `prices` text NOT NULL,
  `enabled` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`act_id`),
  KEY `goods_id` (`goods_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hai_wholesale
-- ----------------------------

-- ----------------------------
-- Table structure for `mw_lbs`
-- ----------------------------
DROP TABLE IF EXISTS `mw_lbs`;
CREATE TABLE `mw_lbs` (
  `mw_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone` varchar(20) DEFAULT NULL,
  `other_phone` varchar(20) DEFAULT NULL,
  `latitude` int(11) DEFAULT NULL,
  `longitude` int(11) DEFAULT NULL,
  `addtime` bigint(20) DEFAULT NULL COMMENT 'FROM_UNIXTIME( addtime, ''%Y-%m-%d %H:%i:%s'' )',
  PRIMARY KEY (`mw_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mw_lbs
-- ----------------------------

-- ----------------------------
-- Table structure for `pro_examine`
-- ----------------------------
DROP TABLE IF EXISTS `pro_examine`;
CREATE TABLE `pro_examine` (
  `examine_id` int(11) NOT NULL AUTO_INCREMENT,
  `examine_title` varchar(200) DEFAULT NULL,
  `examine_m_content` text,
  `examine_content` text,
  `examine_m_result` text,
  `examine_result` text,
  `pro_id` int(11) DEFAULT NULL,
  `plan_start_date` date DEFAULT NULL,
  `plan_end_date` date DEFAULT NULL,
  `truth_start_date` date DEFAULT NULL,
  `truth_end_date` date DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `dispatch_user_id` int(11) DEFAULT NULL COMMENT '指派处理的用户编号',
  `progress` int(6) DEFAULT NULL,
  `m_remark` text,
  `remark` text,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`examine_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pro_examine
-- ----------------------------

-- ----------------------------
-- Table structure for `pro_idea`
-- ----------------------------
DROP TABLE IF EXISTS `pro_idea`;
CREATE TABLE `pro_idea` (
  `idea_id` int(11) NOT NULL AUTO_INCREMENT,
  `idea_title` varchar(200) DEFAULT NULL,
  `idea_m_content` text,
  `idea_content` text,
  `idea_m_remark` text,
  `idea_remark` text,
  `idea_m_plan` text,
  `idea_plan` text,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `state` int(5) DEFAULT NULL,
  `progress` int(3) DEFAULT NULL,
  `plan_date` date DEFAULT NULL,
  PRIMARY KEY (`idea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pro_idea
-- ----------------------------

-- ----------------------------
-- Table structure for `pro_plan`
-- ----------------------------
DROP TABLE IF EXISTS `pro_plan`;
CREATE TABLE `pro_plan` (
  `plan_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_id` int(11) DEFAULT NULL,
  `plan_title` varchar(200) DEFAULT NULL,
  `plan_m_content` text,
  `plan_content` text,
  `plan_m_result` text,
  `plan_result` text,
  `pro_id` int(11) DEFAULT NULL,
  `plan_start_date` date DEFAULT NULL,
  `plan_end_date` date DEFAULT NULL,
  `truth_start_date` date DEFAULT NULL,
  `truth_end_date` date DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `dispatch_user_id` int(11) DEFAULT NULL COMMENT '指派处理的用户编号',
  `progress` int(6) DEFAULT NULL,
  `m_remark` text,
  `remark` text,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`plan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of pro_plan
-- ----------------------------

-- ----------------------------
-- Table structure for `pro_project`
-- ----------------------------
DROP TABLE IF EXISTS `pro_project`;
CREATE TABLE `pro_project` (
  `pro_id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_name` varchar(50) DEFAULT NULL,
  `pro_data_type` int(4) DEFAULT '1' COMMENT '1:管理后台级，2:前台用户级',
  `pro_admin_user_id` int(4) DEFAULT '0' COMMENT '管理员级或用户级的编号',
  PRIMARY KEY (`pro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pro_project
-- ----------------------------

-- ----------------------------
-- Table structure for `pro_task`
-- ----------------------------
DROP TABLE IF EXISTS `pro_task`;
CREATE TABLE `pro_task` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_title` varchar(200) DEFAULT NULL,
  `task_m_content` text,
  `task_content` text,
  `task_m_result` text,
  `task_result` text,
  `pro_id` int(11) DEFAULT NULL,
  `plan_start_date` date DEFAULT NULL,
  `plan_end_date` date DEFAULT NULL,
  `truth_start_date` date DEFAULT NULL,
  `truth_end_date` date DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `dispatch_user_id` int(11) DEFAULT NULL COMMENT '指派处理的用户编号',
  `progress` int(6) DEFAULT NULL,
  `m_remark` text,
  `remark` text,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of pro_task
-- ----------------------------

-- ----------------------------
-- Table structure for `pro_user_project`
-- ----------------------------
DROP TABLE IF EXISTS `pro_user_project`;
CREATE TABLE `pro_user_project` (
  `pro_user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `pro_id` int(11) DEFAULT NULL,
  `state` int(5) DEFAULT '0',
  PRIMARY KEY (`pro_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pro_user_project
-- ----------------------------

-- ----------------------------
-- Table structure for `pro_wbs_work`
-- ----------------------------
DROP TABLE IF EXISTS `pro_wbs_work`;
CREATE TABLE `pro_wbs_work` (
  `wbs_id` int(11) NOT NULL AUTO_INCREMENT,
  `wbs_name` varchar(100) DEFAULT NULL,
  `pro_id` int(11) DEFAULT '0',
  `wbs_parent_id` int(11) DEFAULT '0',
  `plan_start_date` date DEFAULT NULL,
  `plan_end_date` date DEFAULT NULL,
  `truth_start_date` date DEFAULT NULL,
  `truth_end_date` date DEFAULT NULL,
  `user_id` int(11) DEFAULT '0' COMMENT '会员编号',
  `progress` int(11) DEFAULT '0' COMMENT '进度',
  `sort` int(5) DEFAULT '0' COMMENT '排序',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`wbs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pro_wbs_work
-- ----------------------------

-- ----------------------------
-- Table structure for `pro_work_log`
-- ----------------------------
DROP TABLE IF EXISTS `pro_work_log`;
CREATE TABLE `pro_work_log` (
  `work_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `simple_content` text,
  `content` text,
  `m_plan` text,
  `plan` text,
  `m_remark` text,
  `remark` text,
  `status` smallint(4) DEFAULT NULL,
  `work_date` date DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `pro_id` int(11) DEFAULT '0',
  PRIMARY KEY (`work_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pro_work_log
-- ----------------------------

-- ----------------------------
-- Table structure for `think_access`
-- ----------------------------
DROP TABLE IF EXISTS `think_access`;
CREATE TABLE `think_access` (
  `role_id` smallint(6) unsigned NOT NULL,
  `node_id` smallint(6) unsigned NOT NULL,
  `level` tinyint(1) NOT NULL,
  `pid` smallint(6) NOT NULL,
  `module` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`role_id`,`node_id`),
  KEY `groupId` (`role_id`),
  KEY `nodeId` (`node_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='角色对应节点的访问权限';

-- ----------------------------
-- Records of think_access
-- ----------------------------

-- ----------------------------
-- Table structure for `think_auth_group`
-- ----------------------------
DROP TABLE IF EXISTS `think_auth_group`;
CREATE TABLE `think_auth_group` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `title` char(100) NOT NULL DEFAULT '',
  `status` tinyint(1) NOT NULL DEFAULT '1',
  `rules` char(80) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of think_auth_group
-- ----------------------------

-- ----------------------------
-- Table structure for `think_auth_group_access`
-- ----------------------------
DROP TABLE IF EXISTS `think_auth_group_access`;
CREATE TABLE `think_auth_group_access` (
  `uid` mediumint(8) unsigned NOT NULL,
  `group_id` mediumint(8) unsigned NOT NULL,
  UNIQUE KEY `uid_group_id` (`uid`,`group_id`),
  KEY `uid` (`uid`),
  KEY `group_id` (`group_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of think_auth_group_access
-- ----------------------------

-- ----------------------------
-- Table structure for `think_auth_rule`
-- ----------------------------
DROP TABLE IF EXISTS `think_auth_rule`;
CREATE TABLE `think_auth_rule` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `name` char(80) NOT NULL DEFAULT '',
  `title` char(20) NOT NULL DEFAULT '',
  `status` tinyint(1) NOT NULL DEFAULT '1',
  `condition` char(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of think_auth_rule
-- ----------------------------

-- ----------------------------
-- Table structure for `think_group`
-- ----------------------------
DROP TABLE IF EXISTS `think_group`;
CREATE TABLE `think_group` (
  `id` smallint(3) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `title` varchar(50) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `status` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `sort` smallint(3) unsigned NOT NULL DEFAULT '0',
  `is_show` tinyint(1) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of think_group
-- ----------------------------

-- ----------------------------
-- Table structure for `think_menu`
-- ----------------------------
DROP TABLE IF EXISTS `think_menu`;
CREATE TABLE `think_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NOT NULL COMMENT '上级ID',
  `child_ids` varchar(128) NOT NULL COMMENT '下级ID用''，''分开',
  `title` varchar(12) NOT NULL COMMENT '菜单名',
  `position` varchar(8) NOT NULL COMMENT '菜单所在的位置top1,top2,menu,main',
  `target` varchar(10) NOT NULL COMMENT '连接打开的位置header-frame,menu-framemain-frame,_blank',
  `url` varchar(512) NOT NULL COMMENT '连接地址，有下级的用#或者JS来操作，连接从根开始，不带域名',
  `app` varchar(24) NOT NULL COMMENT '所属分组应用，主要会控制左边的菜单变化,空为所有APP都可以',
  `module` varchar(24) NOT NULL COMMENT '所属模块，空为做公共的',
  `action` varchar(24) NOT NULL COMMENT '所属操作，空为公共的',
  `node_id` int(11) NOT NULL COMMENT '标记对应的节点，创建应用、模块或操作时生成上下级的菜单',
  `access_node` varchar(128) NOT NULL COMMENT '此菜单需要访问的节点，角色有此菜单时必需要给这些节点赋权，每个节点用，分开',
  `group_id` tinyint(4) NOT NULL COMMENT '对菜单进行分组，这样不同的应用就可以按组来读取菜单了',
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '这个菜单导航的用户,当为0时是公共的',
  `role_id` varchar(64) NOT NULL DEFAULT '[1][2]' COMMENT '角色的菜单，当角色菜单生效时，user_id不生效',
  `listorder` smallint(6) NOT NULL DEFAULT '0' COMMENT '排序，从小到大',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1：显示，0:不显示，-1：禁用',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='系统导航菜单，app,module,action用于生成菜单的位置,node_id为找出上级节点菜单作准备';

-- ----------------------------
-- Records of think_menu
-- ----------------------------

-- ----------------------------
-- Table structure for `think_node`
-- ----------------------------
DROP TABLE IF EXISTS `think_node`;
CREATE TABLE `think_node` (
  `id` smallint(6) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `title` varchar(50) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '0',
  `remark` varchar(255) DEFAULT NULL,
  `sort` smallint(6) unsigned DEFAULT NULL,
  `pid` smallint(6) unsigned NOT NULL,
  `level` tinyint(1) unsigned NOT NULL,
  `group_id` tinyint(3) unsigned DEFAULT '0',
  `role_id` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `level` (`level`),
  KEY `pid` (`pid`),
  KEY `status` (`status`),
  KEY `name` (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of think_node
-- ----------------------------

-- ----------------------------
-- Table structure for `think_role`
-- ----------------------------
DROP TABLE IF EXISTS `think_role`;
CREATE TABLE `think_role` (
  `id` smallint(6) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `pid` smallint(6) NOT NULL DEFAULT '1',
  `status` tinyint(1) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parentId` (`pid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='1为EMT开发人员，2为系统管理员，其它的按groupID作为起数，100以内为系统预留的ID';

-- ----------------------------
-- Records of think_role
-- ----------------------------

-- ----------------------------
-- Table structure for `think_role_admin`
-- ----------------------------
DROP TABLE IF EXISTS `think_role_admin`;
CREATE TABLE `think_role_admin` (
  `admin_id` int(11) NOT NULL,
  `role_code` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

-- ----------------------------
-- Records of think_role_admin
-- ----------------------------

-- ----------------------------
-- Table structure for `think_role_user`
-- ----------------------------
DROP TABLE IF EXISTS `think_role_user`;
CREATE TABLE `think_role_user` (
  `role_id` mediumint(9) unsigned DEFAULT NULL,
  `user_id` char(32) DEFAULT NULL,
  KEY `group_id` (`role_id`),
  KEY `user_id` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of think_role_user
-- ----------------------------

-- ----------------------------
-- Table structure for `think_table`
-- ----------------------------
DROP TABLE IF EXISTS `think_table`;
CREATE TABLE `think_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL COMMENT '表名',
  `title` varchar(32) NOT NULL COMMENT '表中文名',
  `remark` varchar(128) NOT NULL COMMENT '备注',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态，-1表示在回收站，1表示正常，可以增加其它状态',
  `add_user_id` int(11) NOT NULL COMMENT '添加人ID',
  `add_time` int(11) NOT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='系统表管理';

-- ----------------------------
-- Records of think_table
-- ----------------------------

-- ----------------------------
-- Table structure for `wp_public`
-- ----------------------------
DROP TABLE IF EXISTS `wp_public`;
CREATE TABLE `wp_public` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` int(10) DEFAULT NULL COMMENT '用户ID',
  `public_name` varchar(50) DEFAULT NULL COMMENT '公众号名称',
  `public_id` varchar(100) DEFAULT NULL COMMENT '公众号原始id',
  `wechat` varchar(100) DEFAULT NULL COMMENT '微信号',
  `interface_url` varchar(255) DEFAULT NULL COMMENT '接口地址',
  `headface_url` varchar(255) DEFAULT NULL COMMENT '公众号头像',
  `area` varchar(50) DEFAULT NULL COMMENT '地区',
  `addon_config` text COMMENT '插件配置',
  `addon_status` text COMMENT '插件状态',
  `token` varchar(100) DEFAULT NULL COMMENT 'Token',
  `is_use` tinyint(2) DEFAULT '0' COMMENT '是否为当前公众号',
  `type` char(10) DEFAULT '0' COMMENT '公众号类型',
  `appid` varchar(255) DEFAULT NULL COMMENT 'AppID',
  `secret` varchar(255) DEFAULT NULL COMMENT 'AppSecret',
  `group_id` int(10) unsigned DEFAULT '0' COMMENT '等级',
  `encodingaeskey` varchar(255) DEFAULT NULL COMMENT 'EncodingAESKey',
  `tips_url` varchar(255) DEFAULT NULL COMMENT '提示关注公众号的文章地址',
  `domain` varchar(30) DEFAULT NULL COMMENT '自定义域名',
  `is_bind` tinyint(2) DEFAULT '0' COMMENT '是否为微信开放平台绑定账号',
  `pay_appid` varchar(100) DEFAULT NULL,
  `pay_secret` varchar(100) DEFAULT NULL,
  `mch_id` varchar(100) DEFAULT NULL,
  `sub_mch_id` varchar(100) DEFAULT NULL,
  `mch_secret` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `token` (`token`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wp_public
-- ----------------------------

-- ----------------------------
-- Table structure for `wx_notity_pay`
-- ----------------------------
DROP TABLE IF EXISTS `wx_notity_pay`;
CREATE TABLE `wx_notity_pay` (
  `notify_pay_id` int(11) NOT NULL AUTO_INCREMENT,
  `return_code` varchar(32) DEFAULT NULL,
  `return_msg` varchar(32) DEFAULT NULL,
  `appid` varchar(32) DEFAULT NULL,
  `mch_id` varchar(32) DEFAULT NULL,
  `device_info` varchar(32) DEFAULT NULL,
  `nonce_str` varchar(32) DEFAULT NULL,
  `sign` varchar(32) DEFAULT NULL,
  `result_code` varchar(32) DEFAULT NULL,
  `err_code` varchar(32) DEFAULT NULL,
  `err_code_des` varchar(255) DEFAULT NULL,
  `openid` varchar(128) DEFAULT NULL,
  `is_subscribe` varchar(2) DEFAULT NULL,
  `trade_type` varchar(32) DEFAULT NULL,
  `bank_type` varchar(32) DEFAULT NULL,
  `total_fee` int(11) DEFAULT NULL,
  `fee_type` varchar(32) DEFAULT NULL,
  `cash_fee` int(11) DEFAULT NULL,
  `cash_fee_type` varchar(32) DEFAULT NULL,
  `coupon_fee` int(11) DEFAULT NULL,
  `coupon_count` int(5) DEFAULT NULL,
  `coupon_id_1` varchar(32) DEFAULT NULL,
  `coupon_fee_1` int(11) DEFAULT NULL,
  `transaction_id` varchar(32) DEFAULT NULL,
  `out_trade_no` varchar(32) DEFAULT NULL,
  `attach` varchar(255) DEFAULT NULL,
  `time_end` float(32,0) DEFAULT NULL,
  PRIMARY KEY (`notify_pay_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wx_notity_pay
-- ----------------------------

-- ----------------------------
-- Table structure for `wx_unifiedorder`
-- ----------------------------
DROP TABLE IF EXISTS `wx_unifiedorder`;
CREATE TABLE `wx_unifiedorder` (
  `wx_order_id` int(11) NOT NULL AUTO_INCREMENT,
  `appid` varchar(64) DEFAULT NULL,
  `mch_id` varchar(64) DEFAULT NULL,
  `device_info` varchar(64) DEFAULT NULL,
  `nonce_str` varchar(64) DEFAULT NULL,
  `sign` varchar(64) DEFAULT NULL,
  `body` varchar(255) DEFAULT NULL,
  `detail` varchar(500) DEFAULT NULL,
  `attach` varchar(255) DEFAULT NULL,
  `out_trade_no` varchar(64) DEFAULT NULL,
  `fee_type` varchar(64) DEFAULT NULL,
  `total_fee` int(11) DEFAULT NULL,
  `spbill_create_ip` varchar(64) DEFAULT NULL,
  `time_start` float(32,0) DEFAULT NULL,
  `time_expire` float(32,0) DEFAULT NULL,
  `goods_tag` varchar(32) DEFAULT NULL,
  `notify_url` varchar(255) DEFAULT NULL,
  `trade_type` varchar(64) DEFAULT NULL,
  `product_id` varchar(64) DEFAULT NULL,
  `limit_pay` varchar(64) DEFAULT NULL,
  `openid` varchar(100) DEFAULT NULL,
  `e_pay_status` smallint(5) DEFAULT NULL,
  PRIMARY KEY (`wx_order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of wx_unifiedorder
-- ----------------------------

-- ----------------------------
-- Table structure for `wx_unifiedorder_result`
-- ----------------------------
DROP TABLE IF EXISTS `wx_unifiedorder_result`;
CREATE TABLE `wx_unifiedorder_result` (
  `wx_order_result_id` int(11) NOT NULL AUTO_INCREMENT,
  `return_code` varchar(64) DEFAULT NULL,
  `return_msg` varchar(255) DEFAULT NULL,
  `device_info` varchar(64) DEFAULT NULL,
  `appid` varchar(64) DEFAULT NULL,
  `mch_id` varchar(64) DEFAULT NULL,
  `nonce_str` varchar(64) DEFAULT NULL,
  `sign` varchar(64) DEFAULT NULL,
  `result_code` varchar(64) DEFAULT NULL,
  `prepay_id` varchar(64) DEFAULT NULL,
  `trade_type` varchar(64) DEFAULT NULL,
  `err_code` varchar(64) DEFAULT NULL,
  `err_code_des` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`wx_order_result_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of wx_unifiedorder_result
-- ----------------------------

-- ----------------------------
-- Table structure for `wy_building`
-- ----------------------------
DROP TABLE IF EXISTS `wy_building`;
CREATE TABLE `wy_building` (
  `building_id` int(11) NOT NULL AUTO_INCREMENT,
  `building_code` varchar(20) DEFAULT NULL,
  `building_name` varchar(50) DEFAULT NULL,
  `building_unit_quantity` int(11) DEFAULT NULL,
  `building_floor_quantity` int(11) DEFAULT NULL,
  `building_house_quantity` int(11) DEFAULT NULL,
  `building_community_id` int(11) DEFAULT NULL,
  `building_house_type_id` int(11) DEFAULT NULL,
  `building_remark` text,
  PRIMARY KEY (`building_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wy_building
-- ----------------------------

-- ----------------------------
-- Table structure for `wy_certificate`
-- ----------------------------
DROP TABLE IF EXISTS `wy_certificate`;
CREATE TABLE `wy_certificate` (
  `certificate_id` int(11) NOT NULL AUTO_INCREMENT,
  `homeowner_id` int(11) DEFAULT NULL,
  `homeowner_name` varchar(255) DEFAULT NULL,
  `deal_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `community_id` int(11) DEFAULT NULL,
  `building_id` int(11) DEFAULT NULL,
  `house_id` int(11) DEFAULT NULL,
  `remark` text,
  PRIMARY KEY (`certificate_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wy_certificate
-- ----------------------------

-- ----------------------------
-- Table structure for `wy_community`
-- ----------------------------
DROP TABLE IF EXISTS `wy_community`;
CREATE TABLE `wy_community` (
  `community_id` int(11) NOT NULL AUTO_INCREMENT,
  `community_code` varchar(20) DEFAULT NULL,
  `community_name` varchar(50) DEFAULT NULL,
  `community_building_quantity` int(4) DEFAULT NULL,
  `community_house_quantity` int(4) DEFAULT NULL,
  `community_address` varchar(200) DEFAULT NULL,
  `community_introduction` text,
  `community_remark` text,
  PRIMARY KEY (`community_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wy_community
-- ----------------------------

-- ----------------------------
-- Table structure for `wy_company`
-- ----------------------------
DROP TABLE IF EXISTS `wy_company`;
CREATE TABLE `wy_company` (
  `company_id` int(11) NOT NULL AUTO_INCREMENT,
  `company_code` varchar(20) DEFAULT NULL,
  `company_name` varchar(100) DEFAULT NULL,
  `nature_id` int(11) DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL,
  `linkman` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `office_tel` varchar(20) DEFAULT NULL,
  `home_tel` varchar(20) DEFAULT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `mail` varchar(20) DEFAULT NULL,
  `msn` varchar(20) DEFAULT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `weixin` varchar(20) DEFAULT NULL,
  `industry_id` int(11) DEFAULT NULL,
  `main_business` varchar(200) DEFAULT NULL COMMENT '主营业务',
  `homepage` varchar(200) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `remark` text,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`company_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wy_company
-- ----------------------------

-- ----------------------------
-- Table structure for `wy_customer`
-- ----------------------------
DROP TABLE IF EXISTS `wy_customer`;
CREATE TABLE `wy_customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_code` varchar(50) DEFAULT NULL,
  `customer_name` varchar(200) DEFAULT NULL,
  `member_level_id` int(11) DEFAULT NULL,
  `customer_level_id` int(11) DEFAULT NULL,
  `customer_type_id` int(11) DEFAULT NULL,
  `customer_source_id` int(11) DEFAULT NULL,
  `industry_id` int(11) DEFAULT NULL,
  `community_id` int(11) DEFAULT NULL,
  `building_id` int(11) DEFAULT NULL,
  `house_id` int(11) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `homepage` varchar(100) DEFAULT NULL,
  `postcode` varchar(10) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `detail` text,
  `remark` text,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wy_customer
-- ----------------------------

-- ----------------------------
-- Table structure for `wy_customer_level`
-- ----------------------------
DROP TABLE IF EXISTS `wy_customer_level`;
CREATE TABLE `wy_customer_level` (
  `customer_level_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_level_code` varchar(20) DEFAULT NULL,
  `customer_level_name` varchar(50) DEFAULT NULL,
  `remark` text,
  PRIMARY KEY (`customer_level_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wy_customer_level
-- ----------------------------

-- ----------------------------
-- Table structure for `wy_customer_source`
-- ----------------------------
DROP TABLE IF EXISTS `wy_customer_source`;
CREATE TABLE `wy_customer_source` (
  `customer_source_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_source_code` varchar(20) DEFAULT NULL,
  `customer_source_name` varchar(50) DEFAULT NULL,
  `remark` text,
  PRIMARY KEY (`customer_source_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wy_customer_source
-- ----------------------------

-- ----------------------------
-- Table structure for `wy_customer_type`
-- ----------------------------
DROP TABLE IF EXISTS `wy_customer_type`;
CREATE TABLE `wy_customer_type` (
  `customer_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_type_code` varchar(20) DEFAULT NULL,
  `customer_type_name` varchar(50) DEFAULT NULL,
  `remark` text,
  PRIMARY KEY (`customer_type_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wy_customer_type
-- ----------------------------

-- ----------------------------
-- Table structure for `wy_expense`
-- ----------------------------
DROP TABLE IF EXISTS `wy_expense`;
CREATE TABLE `wy_expense` (
  `expense_id` int(11) NOT NULL AUTO_INCREMENT,
  `charge_method_id` int(11) DEFAULT NULL,
  `homeowner_id` int(11) DEFAULT NULL,
  `homeowner_name` varchar(50) DEFAULT NULL,
  `community_id` int(11) DEFAULT NULL,
  `house_id` int(11) DEFAULT NULL,
  `building_id` int(11) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `previous_degree` double(10,4) DEFAULT NULL,
  `now_degree` double(10,4) DEFAULT NULL,
  `remark` text,
  PRIMARY KEY (`expense_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wy_expense
-- ----------------------------

-- ----------------------------
-- Table structure for `wy_group`
-- ----------------------------
DROP TABLE IF EXISTS `wy_group`;
CREATE TABLE `wy_group` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_code` varchar(20) DEFAULT NULL,
  `group_name` varchar(50) DEFAULT NULL,
  `remark` text,
  PRIMARY KEY (`group_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wy_group
-- ----------------------------

-- ----------------------------
-- Table structure for `wy_home_owner`
-- ----------------------------
DROP TABLE IF EXISTS `wy_home_owner`;
CREATE TABLE `wy_home_owner` (
  `homeowner_id` int(11) NOT NULL AUTO_INCREMENT,
  `homeowner_name` varchar(50) DEFAULT NULL,
  `homeowner_sex` smallint(1) DEFAULT NULL,
  `homeowner_card_type` smallint(1) DEFAULT NULL,
  `homeowner_home_date` date DEFAULT NULL,
  `house_status` smallint(1) DEFAULT NULL,
  `house_community_id` int(11) DEFAULT NULL,
  `house_building_id` int(11) DEFAULT NULL,
  `house_id` int(11) DEFAULT NULL,
  `homeowner_idcard_no` varchar(50) DEFAULT NULL,
  `homeowner_company` varchar(50) DEFAULT NULL,
  `homeowner_tel` varchar(50) DEFAULT NULL,
  `homeowner_mobile` varchar(50) DEFAULT NULL,
  `homeowner_email` varchar(50) DEFAULT NULL,
  `homeowner_qq` varchar(50) DEFAULT NULL,
  `homeowner_weixin` varchar(50) DEFAULT NULL,
  `homeowner_country` varchar(50) DEFAULT NULL,
  `homeowner_province` varchar(50) DEFAULT NULL,
  `homeowner_race` varchar(50) DEFAULT NULL,
  `homeowner_contract_no` varchar(50) DEFAULT NULL,
  `homeowner_address` varchar(50) DEFAULT NULL,
  `homeowner_zip_code` varchar(50) DEFAULT NULL,
  `homeowner_police_station` varchar(50) DEFAULT NULL,
  `homeowner_bank_no` varchar(50) DEFAULT NULL,
  `homeowner_pressing_link` varchar(50) DEFAULT NULL,
  `homeowner_pressing_tel` varchar(50) DEFAULT NULL,
  `homeowner_pressing_address` varchar(50) DEFAULT NULL,
  `homeowner_job_position` varchar(50) DEFAULT NULL,
  `homeowner_remark` text,
  PRIMARY KEY (`homeowner_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wy_home_owner
-- ----------------------------

-- ----------------------------
-- Table structure for `wy_home_owner_change`
-- ----------------------------
DROP TABLE IF EXISTS `wy_home_owner_change`;
CREATE TABLE `wy_home_owner_change` (
  `change_id` int(11) NOT NULL AUTO_INCREMENT,
  `previous_homeowner_id` int(11) DEFAULT NULL,
  `previous_homeowner_name` varchar(50) DEFAULT NULL,
  `now_homeowner_id` int(11) DEFAULT NULL,
  `now_homeowner_name` varchar(50) DEFAULT NULL,
  `community_id` int(11) DEFAULT NULL,
  `building_id` int(11) DEFAULT NULL,
  `house_id` int(11) DEFAULT NULL,
  `change_date` date DEFAULT NULL,
  `remark` text,
  PRIMARY KEY (`change_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wy_home_owner_change
-- ----------------------------

-- ----------------------------
-- Table structure for `wy_industry`
-- ----------------------------
DROP TABLE IF EXISTS `wy_industry`;
CREATE TABLE `wy_industry` (
  `industry_id` int(11) NOT NULL AUTO_INCREMENT,
  `industry_code` varchar(20) DEFAULT NULL,
  `industry_name` varchar(50) DEFAULT NULL,
  `remark` text,
  PRIMARY KEY (`industry_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wy_industry
-- ----------------------------

-- ----------------------------
-- Table structure for `wy_living`
-- ----------------------------
DROP TABLE IF EXISTS `wy_living`;
CREATE TABLE `wy_living` (
  `living_id` int(11) NOT NULL AUTO_INCREMENT,
  `living_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `community_id` int(11) DEFAULT NULL,
  `building_id` int(11) DEFAULT NULL,
  `house_id` int(11) DEFAULT NULL,
  `homeowner_id` int(11) DEFAULT NULL,
  `homeowner_name` varchar(50) DEFAULT NULL,
  `remark` text,
  PRIMARY KEY (`living_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wy_living
-- ----------------------------

-- ----------------------------
-- Table structure for `wy_member_level`
-- ----------------------------
DROP TABLE IF EXISTS `wy_member_level`;
CREATE TABLE `wy_member_level` (
  `member_level_id` int(11) NOT NULL AUTO_INCREMENT,
  `member_level_code` varchar(20) DEFAULT NULL,
  `member_level_name` varchar(50) DEFAULT NULL,
  `remark` text,
  PRIMARY KEY (`member_level_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wy_member_level
-- ----------------------------

-- ----------------------------
-- Table structure for `wy_nature`
-- ----------------------------
DROP TABLE IF EXISTS `wy_nature`;
CREATE TABLE `wy_nature` (
  `nature_id` int(11) NOT NULL AUTO_INCREMENT,
  `nature_code` varchar(20) DEFAULT NULL,
  `nature_name` varchar(50) DEFAULT NULL,
  `remark` text,
  PRIMARY KEY (`nature_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wy_nature
-- ----------------------------

-- ----------------------------
-- Table structure for `wy_project_accept`
-- ----------------------------
DROP TABLE IF EXISTS `wy_project_accept`;
CREATE TABLE `wy_project_accept` (
  `projectaccept_id` int(11) NOT NULL AUTO_INCREMENT,
  `projectaccept_name` varchar(20) DEFAULT NULL,
  `homeowner_id` int(11) DEFAULT NULL,
  `homeowner_name` varchar(50) DEFAULT NULL,
  `deal_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `community_id` int(11) DEFAULT NULL,
  `building_id` int(11) DEFAULT NULL,
  `house_id` int(11) DEFAULT NULL,
  `remark` text,
  PRIMARY KEY (`projectaccept_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of wy_project_accept
-- ----------------------------

-- ----------------------------
-- Table structure for `wy_repair`
-- ----------------------------
DROP TABLE IF EXISTS `wy_repair`;
CREATE TABLE `wy_repair` (
  `repair_id` int(11) NOT NULL AUTO_INCREMENT,
  `repair_name` varchar(255) DEFAULT NULL,
  `deal_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `homeowner_id` int(11) DEFAULT NULL,
  `homeowner_name` varchar(255) DEFAULT NULL,
  `community_id` int(11) DEFAULT NULL,
  `building_id` int(11) DEFAULT NULL,
  `house_id` int(11) DEFAULT NULL,
  `remark` text,
  `evaluator` varchar(50) DEFAULT NULL,
  `assess_remark` text,
  `assess_date` datetime DEFAULT NULL,
  `maintenance` varchar(50) DEFAULT NULL,
  `result_remark` text,
  `result_date` datetime DEFAULT NULL,
  `berichten` varchar(50) DEFAULT NULL,
  `berichten_remark` text,
  `berichten_date` datetime DEFAULT NULL,
  PRIMARY KEY (`repair_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wy_repair
-- ----------------------------

-- ----------------------------
-- Table structure for `wy_setting_charge_method`
-- ----------------------------
DROP TABLE IF EXISTS `wy_setting_charge_method`;
CREATE TABLE `wy_setting_charge_method` (
  `setting_charge_method_id` int(11) NOT NULL AUTO_INCREMENT,
  `setting_charge_method_code` varchar(20) DEFAULT NULL,
  `setting_charge_method_name` varchar(50) DEFAULT NULL,
  `setting_charge_method_remark` text,
  PRIMARY KEY (`setting_charge_method_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wy_setting_charge_method
-- ----------------------------

-- ----------------------------
-- Table structure for `wy_setting_house`
-- ----------------------------
DROP TABLE IF EXISTS `wy_setting_house`;
CREATE TABLE `wy_setting_house` (
  `house_id` int(11) NOT NULL AUTO_INCREMENT,
  `house_name` varchar(20) DEFAULT NULL,
  `house_unit_no` varchar(20) DEFAULT NULL,
  `house_floor` int(4) DEFAULT NULL,
  `house_status` int(4) DEFAULT NULL,
  `house_community_id` int(11) DEFAULT NULL,
  `house_building_id` int(11) DEFAULT NULL,
  `house_type_id` int(11) DEFAULT NULL,
  `house_direction_id` int(11) DEFAULT NULL,
  `house_remark` text,
  PRIMARY KEY (`house_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wy_setting_house
-- ----------------------------

-- ----------------------------
-- Table structure for `wy_setting_house_direction`
-- ----------------------------
DROP TABLE IF EXISTS `wy_setting_house_direction`;
CREATE TABLE `wy_setting_house_direction` (
  `setting_house_direction_id` int(11) NOT NULL AUTO_INCREMENT,
  `setting_house_direction_code` varchar(20) DEFAULT NULL,
  `setting_house_direction_name` varchar(50) DEFAULT NULL,
  `setting_house_direction_remark` text,
  PRIMARY KEY (`setting_house_direction_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wy_setting_house_direction
-- ----------------------------

-- ----------------------------
-- Table structure for `wy_setting_house_structure`
-- ----------------------------
DROP TABLE IF EXISTS `wy_setting_house_structure`;
CREATE TABLE `wy_setting_house_structure` (
  `setting_house_structure_id` int(11) NOT NULL AUTO_INCREMENT,
  `setting_house_structure_code` varchar(20) DEFAULT NULL,
  `setting_house_structure_name` varchar(50) DEFAULT NULL,
  `setting_house_structure_remark` text,
  PRIMARY KEY (`setting_house_structure_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wy_setting_house_structure
-- ----------------------------

-- ----------------------------
-- Table structure for `wy_setting_house_type`
-- ----------------------------
DROP TABLE IF EXISTS `wy_setting_house_type`;
CREATE TABLE `wy_setting_house_type` (
  `setting_house_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `setting_house_type_code` varchar(20) DEFAULT NULL,
  `setting_house_type_name` varchar(50) DEFAULT NULL,
  `setting_house_type_remark` text,
  PRIMARY KEY (`setting_house_type_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wy_setting_house_type
-- ----------------------------
