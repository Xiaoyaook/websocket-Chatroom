-- 群组信息表
CREATE TABLE `group_info` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `group_name` varchar(50) NOT NULL DEFAULT '' COMMENT '群组名称',
  `discreption` varchar(300) NOT NULL DEFAULT '' COMMENT '群组简介，默认100个汉字以内',
  `avatar_url` varchar(200) NOT NULL DEFAULT '' COMMENT '头像url',
  `create_by` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_by` datetime NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;