-- 用户信息表
CREATE TABLE `user_info` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` VARCHAR(32) NOT NULL UNIQUE COMMENT '用户名',
  `password` VARCHAR(32) DEFAULT NULL COMMENT 'MD5(MD5(pass明文+固定salt) + salt)',
  `salt` VARCHAR(10) DEFAULT NULL,
  `nickname` varchar(50) NOT NULL DEFAULT '' COMMENT '昵称',
  `discreption` varchar(300) NOT NULL DEFAULT '' COMMENT '个人简介，默认100个汉字以内',
  `avatar_url` varchar(200) NOT NULL DEFAULT '' COMMENT '头像url',
  `create_by` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_by` datetime NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;