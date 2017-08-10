/*
Navicat MySQL Data Transfer

Source Server         : mysql.cheau.io_3306
Source Server Version : 50719
Source Host           : mysql.cheau.io:3306
Source Database       : intern

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-08-09 23:06:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attendence
-- ----------------------------
DROP TABLE IF EXISTS `attendence`;
CREATE TABLE `attendence` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `audit_state` bit(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) NOT NULL,
  `del_flag` bit(1) DEFAULT NULL,
  `modifier` bigint(20) NOT NULL,
  `modify_time` datetime NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sign_in` datetime DEFAULT NULL,
  `sign_out` datetime DEFAULT NULL,
  `fk_os_staff_state_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdgptdd6rtvm5re89hbrcg1bqa` (`fk_os_staff_state_id`),
  CONSTRAINT `FKdgptdd6rtvm5re89hbrcg1bqa` FOREIGN KEY (`fk_os_staff_state_id`) REFERENCES `os_staff_state` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attendence
-- ----------------------------
INSERT INTO `attendence` VALUES ('1', null, 'code1', '2017-08-09 09:43:01', '0', '\0', '0', '2017-08-09 09:43:01', 'absent', '2017-08-09 09:43:01', '2017-08-09 09:43:01', null);
INSERT INTO `attendence` VALUES ('2', null, 'code2', '2017-08-09 09:43:01', '0', '\0', '0', '2017-08-09 09:43:01', 'absent', '2017-08-09 09:43:01', '2017-08-09 09:43:01', null);
INSERT INTO `attendence` VALUES ('3', null, 'code3', '2017-08-09 09:43:01', '0', '\0', '0', '2017-08-09 09:43:01', 'absent', '2017-08-09 09:43:01', '2017-08-09 09:43:01', null);
INSERT INTO `attendence` VALUES ('101', null, null, null, '0', null, '0', '2017-08-09 09:43:03', null, '2017-08-09 09:43:03', '2017-08-09 09:43:03', '91');
INSERT INTO `attendence` VALUES ('102', null, null, null, '0', null, '0', '2017-08-09 09:43:03', null, '2017-08-09 09:43:03', '2017-08-09 09:43:03', '92');
INSERT INTO `attendence` VALUES ('103', null, null, null, '0', null, '0', '2017-08-09 09:43:03', null, '2017-08-09 09:43:03', '2017-08-09 09:43:03', '93');
INSERT INTO `attendence` VALUES ('104', null, null, '2017-08-09 22:48:49', '61', '\0', '61', '2017-08-09 22:48:49', null, '2017-08-09 22:48:49', null, null);

-- ----------------------------
-- Table structure for bid
-- ----------------------------
DROP TABLE IF EXISTS `bid`;
CREATE TABLE `bid` (
  `level` varchar(255) NOT NULL,
  `bid_price` double NOT NULL,
  `nrof_people` int(11) NOT NULL,
  `fk_supplier_id` bigint(20) NOT NULL,
  `fk_proj_id` bigint(20) NOT NULL,
  `fk_os_pos_id` bigint(20) NOT NULL,
  PRIMARY KEY (`fk_supplier_id`,`fk_proj_id`,`fk_os_pos_id`,`level`,`bid_price`),
  KEY `FKs754tplfqoq7qj9qdi8b1nqax` (`fk_proj_id`),
  KEY `FKe52t7xf5u4i9n16igj0o5a0s9` (`fk_os_pos_id`),
  CONSTRAINT `FK3ch093grv560pmuhr9bugbyst` FOREIGN KEY (`fk_supplier_id`) REFERENCES `supplier` (`id`),
  CONSTRAINT `FKe52t7xf5u4i9n16igj0o5a0s9` FOREIGN KEY (`fk_os_pos_id`) REFERENCES `os_pos` (`id`),
  CONSTRAINT `FKs754tplfqoq7qj9qdi8b1nqax` FOREIGN KEY (`fk_proj_id`) REFERENCES `proj` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bid
-- ----------------------------
INSERT INTO `bid` VALUES ('high', '300', '20', '11', '21', '41');
INSERT INTO `bid` VALUES ('normal', '200', '30', '12', '22', '42');
INSERT INTO `bid` VALUES ('low', '100', '10', '13', '23', '43');

-- ----------------------------
-- Table structure for criteria
-- ----------------------------
DROP TABLE IF EXISTS `criteria`;
CREATE TABLE `criteria` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `audit_state` bit(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) NOT NULL,
  `del_flag` bit(1) DEFAULT NULL,
  `modifier` bigint(20) NOT NULL,
  `modify_time` datetime NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of criteria
-- ----------------------------
INSERT INTO `criteria` VALUES ('51', null, 'code1', '2017-08-09 09:43:02', '0', '\0', '0', '2017-08-09 09:43:02', 'sfaffEval', 'workHour');
INSERT INTO `criteria` VALUES ('52', null, 'code2', '2017-08-09 09:43:02', '0', '\0', '0', '2017-08-09 09:43:02', 'supplierEval', 'workHour');
INSERT INTO `criteria` VALUES ('53', null, 'code3', '2017-08-09 09:43:02', '0', '\0', '0', '2017-08-09 09:43:02', 'canteenEval', 'workHour');

-- ----------------------------
-- Table structure for cs_participation
-- ----------------------------
DROP TABLE IF EXISTS `cs_participation`;
CREATE TABLE `cs_participation` (
  `cs_staff_id` bigint(20) NOT NULL,
  `proj_id` bigint(20) NOT NULL,
  PRIMARY KEY (`cs_staff_id`,`proj_id`),
  KEY `FKlqp823bpdbjcr3ya3imnesoup` (`proj_id`),
  CONSTRAINT `FKhv20680a7i9wfi0ovdchoflom` FOREIGN KEY (`cs_staff_id`) REFERENCES `cs_staff` (`id`),
  CONSTRAINT `FKlqp823bpdbjcr3ya3imnesoup` FOREIGN KEY (`proj_id`) REFERENCES `proj` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cs_participation
-- ----------------------------
INSERT INTO `cs_participation` VALUES ('81', '21');
INSERT INTO `cs_participation` VALUES ('81', '22');
INSERT INTO `cs_participation` VALUES ('81', '23');

-- ----------------------------
-- Table structure for cs_staff
-- ----------------------------
DROP TABLE IF EXISTS `cs_staff`;
CREATE TABLE `cs_staff` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `audit_state` bit(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) NOT NULL,
  `del_flag` bit(1) DEFAULT NULL,
  `modifier` bigint(20) NOT NULL,
  `modify_time` datetime NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `fk_staff_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKin7ojrnyy98kyj91da5i932a5` (`fk_staff_id`),
  CONSTRAINT `FKin7ojrnyy98kyj91da5i932a5` FOREIGN KEY (`fk_staff_id`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cs_staff
-- ----------------------------
INSERT INTO `cs_staff` VALUES ('81', '', 'code1', '2017-08-09 09:43:02', '0', '\0', '0', '2017-08-09 09:43:02', 'qin', '65');

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `audit_state` bit(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) NOT NULL,
  `del_flag` bit(1) DEFAULT NULL,
  `modifier` bigint(20) NOT NULL,
  `modify_time` datetime NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('31', null, 'code1', '2017-08-09 09:43:01', '0', '\0', '0', '2017-08-09 09:43:01', '運研');
INSERT INTO `dept` VALUES ('32', null, 'code2', '2017-08-09 09:43:01', '0', '\0', '0', '2017-08-09 09:43:01', '飯堂');
INSERT INTO `dept` VALUES ('33', null, 'code3', '2017-08-09 09:43:01', '0', '\0', '0', '2017-08-09 09:43:01', '空乘');

-- ----------------------------
-- Table structure for eval_state
-- ----------------------------
DROP TABLE IF EXISTS `eval_state`;
CREATE TABLE `eval_state` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `audit_state` bit(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) NOT NULL,
  `del_flag` bit(1) DEFAULT NULL,
  `modifier` bigint(20) NOT NULL,
  `modify_time` datetime NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rating` varchar(255) DEFAULT NULL,
  `fk_criteria_id` bigint(20) DEFAULT NULL,
  `fk_os_company_eval_id` bigint(20) DEFAULT NULL,
  `fk_os_staff_eval_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfgnubxqpwi2fdggqyg80gg0n6` (`fk_criteria_id`),
  KEY `FK6a0wnin7rnqd2c39e64gld0yr` (`fk_os_company_eval_id`),
  KEY `FK837wfbs35icepq0lm03cav90r` (`fk_os_staff_eval_id`),
  CONSTRAINT `FK6a0wnin7rnqd2c39e64gld0yr` FOREIGN KEY (`fk_os_company_eval_id`) REFERENCES `os_company_eval` (`id`),
  CONSTRAINT `FK837wfbs35icepq0lm03cav90r` FOREIGN KEY (`fk_os_staff_eval_id`) REFERENCES `os_staff_eval` (`id`),
  CONSTRAINT `FKfgnubxqpwi2fdggqyg80gg0n6` FOREIGN KEY (`fk_criteria_id`) REFERENCES `criteria` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eval_state
-- ----------------------------

-- ----------------------------
-- Table structure for leave_appl
-- ----------------------------
DROP TABLE IF EXISTS `leave_appl`;
CREATE TABLE `leave_appl` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `audit_state` bit(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) NOT NULL,
  `del_flag` bit(1) DEFAULT NULL,
  `modifier` bigint(20) NOT NULL,
  `modify_time` datetime NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `days` double NOT NULL,
  `end_time` datetime DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `fk_os_staff_state_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKaqhuf6ovmcyei4itjjq7lctyy` (`fk_os_staff_state_id`),
  CONSTRAINT `FKaqhuf6ovmcyei4itjjq7lctyy` FOREIGN KEY (`fk_os_staff_state_id`) REFERENCES `os_staff_state` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of leave_appl
-- ----------------------------

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `audit_state` bit(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) NOT NULL,
  `del_flag` bit(1) DEFAULT NULL,
  `modifier` bigint(20) NOT NULL,
  `modify_time` datetime NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `readed` bit(1) DEFAULT NULL,
  `fk_staff_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg3xkeysf8w57ut6j8n9sedny` (`fk_staff_id`),
  CONSTRAINT `FKg3xkeysf8w57ut6j8n9sedny` FOREIGN KEY (`fk_staff_id`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------

-- ----------------------------
-- Table structure for os_company_eval
-- ----------------------------
DROP TABLE IF EXISTS `os_company_eval`;
CREATE TABLE `os_company_eval` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `audit_state` bit(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) NOT NULL,
  `del_flag` bit(1) DEFAULT NULL,
  `modifier` bigint(20) NOT NULL,
  `modify_time` datetime NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `overall_rating` double NOT NULL,
  `signed` bit(1) DEFAULT NULL,
  `fk_supplier_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgsy8kdwxd4hrd8iw3viltqbgj` (`fk_supplier_id`),
  CONSTRAINT `FKgsy8kdwxd4hrd8iw3viltqbgj` FOREIGN KEY (`fk_supplier_id`) REFERENCES `supplier` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of os_company_eval
-- ----------------------------

-- ----------------------------
-- Table structure for os_empl_form
-- ----------------------------
DROP TABLE IF EXISTS `os_empl_form`;
CREATE TABLE `os_empl_form` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `audit_state` bit(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) NOT NULL,
  `del_flag` bit(1) DEFAULT NULL,
  `modifier` bigint(20) NOT NULL,
  `modify_time` datetime NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `appl_date` datetime DEFAULT NULL,
  `appl_state` varchar(255) DEFAULT NULL,
  `fk_proj_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6m0yfv2dlk0hvrvesqgdlxdui` (`fk_proj_id`),
  CONSTRAINT `FK6m0yfv2dlk0hvrvesqgdlxdui` FOREIGN KEY (`fk_proj_id`) REFERENCES `proj` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of os_empl_form
-- ----------------------------
INSERT INTO `os_empl_form` VALUES ('1', null, '123', '2017-08-09 21:55:42', '123', '\0', '123', '2017-08-09 21:55:49', 'helloworld', '2017-08-08 21:55:57', 'HEHEHEHEHE', '21');
INSERT INTO `os_empl_form` VALUES ('2', null, '124', '2017-08-09 22:18:47', '123', '\0', '123', '2017-08-08 22:19:02', 'heiheiworld', '2017-08-09 22:19:13', 'fuck you', '22');

-- ----------------------------
-- Table structure for os_empl_form_detail
-- ----------------------------
DROP TABLE IF EXISTS `os_empl_form_detail`;
CREATE TABLE `os_empl_form_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `expected_arrival` datetime DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `people_count` int(11) NOT NULL,
  `people_day` double NOT NULL,
  `seat_needed` int(11) NOT NULL,
  `workplace` varchar(255) DEFAULT NULL,
  `fk_details_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpo38wiy2p36iuoqq8mf1gd8en` (`fk_details_id`),
  CONSTRAINT `FKpo38wiy2p36iuoqq8mf1gd8en` FOREIGN KEY (`fk_details_id`) REFERENCES `os_empl_form` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of os_empl_form_detail
-- ----------------------------
INSERT INTO `os_empl_form_detail` VALUES ('1', '2017-08-09 22:19:51', 'h', '2', '12', '12', 'hoho', '1');
INSERT INTO `os_empl_form_detail` VALUES ('2', '2017-08-09 22:20:14', 'm', '3', '32', '23', 'a', '1');
INSERT INTO `os_empl_form_detail` VALUES ('3', '2017-08-09 22:20:33', 'l', '6', '9', '224', 'b', '2');

-- ----------------------------
-- Table structure for os_pos
-- ----------------------------
DROP TABLE IF EXISTS `os_pos`;
CREATE TABLE `os_pos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `audit_state` bit(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) NOT NULL,
  `del_flag` bit(1) DEFAULT NULL,
  `modifier` bigint(20) NOT NULL,
  `modify_time` datetime NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of os_pos
-- ----------------------------
INSERT INTO `os_pos` VALUES ('41', null, 'code1', '2017-08-09 09:43:02', '0', '\0', '0', '2017-08-09 09:43:02', 'java');
INSERT INTO `os_pos` VALUES ('42', null, 'code1', '2017-08-09 09:43:02', '0', '\0', '0', '2017-08-09 09:43:02', 'csharp');
INSERT INTO `os_pos` VALUES ('43', null, 'code1', '2017-08-09 09:43:02', '0', '\0', '0', '2017-08-09 09:43:02', 'python');

-- ----------------------------
-- Table structure for os_staff
-- ----------------------------
DROP TABLE IF EXISTS `os_staff`;
CREATE TABLE `os_staff` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `audit_state` bit(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) NOT NULL,
  `del_flag` bit(1) DEFAULT NULL,
  `modifier` bigint(20) NOT NULL,
  `modify_time` datetime NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `guarantee_letter` bit(1) DEFAULT NULL,
  `id_copy` bit(1) DEFAULT NULL,
  `national_id` varchar(18) DEFAULT NULL,
  `rules` bit(1) DEFAULT NULL,
  `ss_certificate` bit(1) DEFAULT NULL,
  `fk_supplier_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn9ew1islc2ajpqn04aes8mpua` (`fk_supplier_id`),
  CONSTRAINT `FKn9ew1islc2ajpqn04aes8mpua` FOREIGN KEY (`fk_supplier_id`) REFERENCES `supplier` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of os_staff
-- ----------------------------
INSERT INTO `os_staff` VALUES ('71', null, 'kkk', '2017-08-09 22:28:37', '123', '\0', '123', '2017-08-09 22:28:44', 'zhihng', 'high', '', '', '1', '', '', '11');

-- ----------------------------
-- Table structure for os_staff_eval
-- ----------------------------
DROP TABLE IF EXISTS `os_staff_eval`;
CREATE TABLE `os_staff_eval` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `audit_state` bit(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) NOT NULL,
  `del_flag` bit(1) DEFAULT NULL,
  `modifier` bigint(20) NOT NULL,
  `modify_time` datetime NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `dept_manager` bit(1) DEFAULT NULL,
  `os_field` bit(1) DEFAULT NULL,
  `overall_rating` double NOT NULL,
  `proj_leader` bit(1) DEFAULT NULL,
  `result` bit(1) DEFAULT NULL,
  `trial_flag` varchar(255) DEFAULT NULL,
  `fk_os_staff_id` bigint(20) DEFAULT NULL,
  `fk_proj_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd8cla8jlmiqmyup8c4e9ftt5u` (`fk_os_staff_id`),
  KEY `FKdq2yk11nxiamwc5350ydo8sgc` (`fk_proj_id`),
  CONSTRAINT `FKd8cla8jlmiqmyup8c4e9ftt5u` FOREIGN KEY (`fk_os_staff_id`) REFERENCES `os_staff` (`id`),
  CONSTRAINT `FKdq2yk11nxiamwc5350ydo8sgc` FOREIGN KEY (`fk_proj_id`) REFERENCES `proj` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of os_staff_eval
-- ----------------------------

-- ----------------------------
-- Table structure for os_staff_state
-- ----------------------------
DROP TABLE IF EXISTS `os_staff_state`;
CREATE TABLE `os_staff_state` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `audit_state` bit(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) NOT NULL,
  `del_flag` bit(1) DEFAULT NULL,
  `modifier` bigint(20) NOT NULL,
  `modify_time` datetime NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `duration` int(11) NOT NULL,
  `enter_date` datetime DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `quit_date` datetime DEFAULT NULL,
  `validation` bit(1) NOT NULL,
  `fk_os_pos_id` bigint(20) DEFAULT NULL,
  `fk_os_staff_id` bigint(20) DEFAULT NULL,
  `fk_proj_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlmo4goig3kq1t7tbwyjldtk4s` (`fk_os_pos_id`),
  KEY `FKsi7jmu4qvgew12m1bssmmvw56` (`fk_os_staff_id`),
  KEY `FKt0c6y19yb4rsuqpr9xgd8gywl` (`fk_proj_id`),
  CONSTRAINT `FKlmo4goig3kq1t7tbwyjldtk4s` FOREIGN KEY (`fk_os_pos_id`) REFERENCES `os_pos` (`id`),
  CONSTRAINT `FKsi7jmu4qvgew12m1bssmmvw56` FOREIGN KEY (`fk_os_staff_id`) REFERENCES `os_staff` (`id`),
  CONSTRAINT `FKt0c6y19yb4rsuqpr9xgd8gywl` FOREIGN KEY (`fk_proj_id`) REFERENCES `proj` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of os_staff_state
-- ----------------------------
INSERT INTO `os_staff_state` VALUES ('91', null, null, null, '0', null, '0', '2017-08-09 09:43:03', null, null, '10', null, null, null, '', null, null, null);
INSERT INTO `os_staff_state` VALUES ('92', null, null, null, '0', null, '0', '2017-08-09 09:43:03', null, null, '10', null, null, null, '', null, null, null);
INSERT INTO `os_staff_state` VALUES ('93', null, null, null, '0', null, '0', '2017-08-09 09:43:03', null, null, '10', null, null, null, '', null, null, null);

-- ----------------------------
-- Table structure for osm_role
-- ----------------------------
DROP TABLE IF EXISTS `osm_role`;
CREATE TABLE `osm_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `audit_state` bit(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) NOT NULL,
  `del_flag` bit(1) DEFAULT NULL,
  `modifier` bigint(20) NOT NULL,
  `modify_time` datetime NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of osm_role
-- ----------------------------
INSERT INTO `osm_role` VALUES ('111', null, null, null, '0', null, '0', '2017-08-09 09:43:03', 'ROLE_OS_STAFF');
INSERT INTO `osm_role` VALUES ('112', null, null, null, '0', null, '0', '2017-08-09 09:43:03', 'ROLE_PRJ_MGR');
INSERT INTO `osm_role` VALUES ('113', null, null, '2017-08-09 19:09:00', '123', '\0', '123', '2017-08-09 19:09:00', 'ROLE_ADMIN');
INSERT INTO `osm_role` VALUES ('114', null, null, '2017-08-09 19:11:19', '123', '\0', '123', '2017-08-09 19:11:19', 'ROLE_ADMIN');
INSERT INTO `osm_role` VALUES ('115', null, null, '2017-08-09 21:55:36', '123', '\0', '123', '2017-08-09 21:55:36', 'ROLE_ADMIN');
INSERT INTO `osm_role` VALUES ('116', null, null, '2017-08-09 21:57:22', '123', '\0', '123', '2017-08-09 21:57:22', 'ROLE_ADMIN');

-- ----------------------------
-- Table structure for ot_application
-- ----------------------------
DROP TABLE IF EXISTS `ot_application`;
CREATE TABLE `ot_application` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `audit_state` bit(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) NOT NULL,
  `del_flag` bit(1) DEFAULT NULL,
  `modifier` bigint(20) NOT NULL,
  `modify_time` datetime NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `fk_os_staff_state_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk8q092r285dr6ynvy5xwdobo8` (`fk_os_staff_state_id`),
  CONSTRAINT `FKk8q092r285dr6ynvy5xwdobo8` FOREIGN KEY (`fk_os_staff_state_id`) REFERENCES `os_staff_state` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ot_application
-- ----------------------------

-- ----------------------------
-- Table structure for possession
-- ----------------------------
DROP TABLE IF EXISTS `possession`;
CREATE TABLE `possession` (
  `osm_role_id` bigint(20) NOT NULL,
  `power_id` bigint(20) NOT NULL,
  PRIMARY KEY (`osm_role_id`,`power_id`),
  KEY `FKbdij3puoki4dsvlyk3cbtjr0w` (`power_id`),
  CONSTRAINT `FKbdij3puoki4dsvlyk3cbtjr0w` FOREIGN KEY (`power_id`) REFERENCES `power` (`id`),
  CONSTRAINT `FKpggk54ow4aygv83808hycavno` FOREIGN KEY (`osm_role_id`) REFERENCES `osm_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of possession
-- ----------------------------

-- ----------------------------
-- Table structure for power
-- ----------------------------
DROP TABLE IF EXISTS `power`;
CREATE TABLE `power` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `audit_state` bit(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) NOT NULL,
  `del_flag` bit(1) DEFAULT NULL,
  `modifier` bigint(20) NOT NULL,
  `modify_time` datetime NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `power_content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power
-- ----------------------------

-- ----------------------------
-- Table structure for proj
-- ----------------------------
DROP TABLE IF EXISTS `proj`;
CREATE TABLE `proj` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `audit_state` bit(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) NOT NULL,
  `del_flag` bit(1) DEFAULT NULL,
  `modifier` bigint(20) NOT NULL,
  `modify_time` datetime NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `termination` bit(1) DEFAULT NULL,
  `fk_dept_id` bigint(20) DEFAULT NULL,
  `fk_project_manager_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKghgmy93yyuh4jof1b09gjjwyb` (`fk_dept_id`),
  KEY `FKck2lalqu34pamvtkemq97kvdn` (`fk_project_manager_id`),
  CONSTRAINT `FKck2lalqu34pamvtkemq97kvdn` FOREIGN KEY (`fk_project_manager_id`) REFERENCES `cs_staff` (`id`),
  CONSTRAINT `FKghgmy93yyuh4jof1b09gjjwyb` FOREIGN KEY (`fk_dept_id`) REFERENCES `dept` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of proj
-- ----------------------------
INSERT INTO `proj` VALUES ('21', null, 'code1', '2017-08-09 09:43:02', '0', '\0', '0', '2017-08-09 09:43:02', 'SANHAO', '\0', null, '81');
INSERT INTO `proj` VALUES ('22', null, 'code2', '2017-08-09 09:43:02', '0', '\0', '0', '2017-08-09 09:43:02', 'SANHAO', '\0', null, '81');
INSERT INTO `proj` VALUES ('23', null, 'code3', '2017-08-09 09:43:02', '0', '\0', '0', '2017-08-09 09:43:02', 'SANHAO', '\0', null, '81');

-- ----------------------------
-- Table structure for responsibility
-- ----------------------------
DROP TABLE IF EXISTS `responsibility`;
CREATE TABLE `responsibility` (
  `staff_id` bigint(20) NOT NULL,
  `osm_role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`staff_id`,`osm_role_id`),
  KEY `FKkmnrrxm61v9jnyshnbn08eu9y` (`osm_role_id`),
  CONSTRAINT `FKkclnc331x4hl5b0eedy7npheh` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`),
  CONSTRAINT `FKkmnrrxm61v9jnyshnbn08eu9y` FOREIGN KEY (`osm_role_id`) REFERENCES `osm_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of responsibility
-- ----------------------------
INSERT INTO `responsibility` VALUES ('61', '111');
INSERT INTO `responsibility` VALUES ('62', '111');
INSERT INTO `responsibility` VALUES ('63', '111');
INSERT INTO `responsibility` VALUES ('64', '111');
INSERT INTO `responsibility` VALUES ('66', '111');
INSERT INTO `responsibility` VALUES ('65', '112');
INSERT INTO `responsibility` VALUES ('66', '112');
INSERT INTO `responsibility` VALUES ('66', '113');

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `audit_state` bit(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) NOT NULL,
  `del_flag` bit(1) DEFAULT NULL,
  `modifier` bigint(20) NOT NULL,
  `modify_time` datetime NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `fk_cs_staff_id` bigint(20) DEFAULT NULL,
  `fk_os_staff_id` bigint(20) DEFAULT NULL,
  `fk_supplier_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq0458ahj2u9uvcpc12alau8gj` (`fk_cs_staff_id`),
  KEY `FK7grug5o0hfxcpxqfc49nsgsph` (`fk_os_staff_id`),
  KEY `FK1n3rvfqyl0yt4279jegrjqdmf` (`fk_supplier_id`),
  CONSTRAINT `FK1n3rvfqyl0yt4279jegrjqdmf` FOREIGN KEY (`fk_supplier_id`) REFERENCES `supplier` (`id`),
  CONSTRAINT `FK7grug5o0hfxcpxqfc49nsgsph` FOREIGN KEY (`fk_os_staff_id`) REFERENCES `os_staff` (`id`),
  CONSTRAINT `FKq0458ahj2u9uvcpc12alau8gj` FOREIGN KEY (`fk_cs_staff_id`) REFERENCES `cs_staff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('61', null, 'code1', '2017-08-09 09:43:02', '0', '\0', '0', '2017-08-09 09:43:02', 'hong', 'password', null, '71', null);
INSERT INTO `staff` VALUES ('62', null, 'code2', '2017-08-09 09:43:02', '0', '\0', '0', '2017-08-09 09:43:02', 'huang', 'password', null, '72', null);
INSERT INTO `staff` VALUES ('63', null, 'code3', '2017-08-09 09:43:02', '0', '\0', '0', '2017-08-09 09:43:02', 'ling', 'password', null, '73', null);
INSERT INTO `staff` VALUES ('64', null, 'code4', '2017-08-09 09:43:02', '0', '\0', '0', '2017-08-09 09:43:02', 'lun', 'password', null, '74', null);
INSERT INTO `staff` VALUES ('65', null, 'code5', '2017-08-09 09:43:02', '0', '\0', '0', '2017-08-09 09:43:02', 'qin', 'password', '81', null, null);
INSERT INTO `staff` VALUES ('66', null, '123', '2017-08-09 19:09:01', '123', '\0', '123', '2017-08-09 19:11:19', 'helloworld', 'csairmind', null, null, null);

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `audit_state` bit(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) NOT NULL,
  `del_flag` bit(1) DEFAULT NULL,
  `modifier` bigint(20) NOT NULL,
  `modify_time` datetime NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('11', null, 'code1', '2017-08-09 09:43:01', '0', '\0', '0', '2017-08-09 09:43:01', 'YIHAO');
INSERT INTO `supplier` VALUES ('12', null, 'code2', '2017-08-09 09:43:01', '0', '\0', '0', '2017-08-09 09:43:01', 'ERHAO');
INSERT INTO `supplier` VALUES ('13', null, 'code3', '2017-08-09 09:43:01', '0', '\0', '0', '2017-08-09 09:43:01', 'SANHAO');

-- ----------------------------
-- Table structure for total_attend
-- ----------------------------
DROP TABLE IF EXISTS `total_attend`;
CREATE TABLE `total_attend` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `audit_state` bit(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) NOT NULL,
  `del_flag` bit(1) DEFAULT NULL,
  `modifier` bigint(20) NOT NULL,
  `modify_time` datetime NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `ot_time` double NOT NULL,
  `come_on_schedule` bit(1) DEFAULT NULL,
  `early_day` int(11) NOT NULL,
  `late_day` int(11) NOT NULL,
  `person_days` int(11) NOT NULL,
  `fk_os_staff_state_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjs0oicf7sf9e24ojwmiyvbv37` (`fk_os_staff_state_id`),
  CONSTRAINT `FKjs0oicf7sf9e24ojwmiyvbv37` FOREIGN KEY (`fk_os_staff_state_id`) REFERENCES `os_staff_state` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of total_attend
-- ----------------------------
