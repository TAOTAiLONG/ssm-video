/*
Navicat MySQL Data Transfer

Source Server         : ZGL_a
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : videos

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-10-21 16:36:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `roles` varchar(20) DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', 'administrator');
INSERT INTO `admin` VALUES ('2', 'jack', '123', 'administrator');

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `checked` char(1) DEFAULT NULL,
  `time` timestamp NULL DEFAULT NULL,
  `action` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO `client` VALUES ('1', '凉凉', '18639776239', '1758259743', '0', '2020-10-21 16:24:40', 'post');
INSERT INTO `client` VALUES ('2', '哈哈', '18639776239', '1758259743', '0', '2020-10-21 16:24:45', 'post');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `course_title` varchar(50) DEFAULT NULL,
  `course_desc` text,
  `subject_id` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('6', 'Web前端入门小项目', '适合无编程基础但想学H5前端开发的同学入门学习，也适合UI、Java、PHP等其他学科学员预习或练习。本课程通过新闻页面、个人主页、个人简历、场景秀等多个项目案例由浅入深以项目实战的方式让同学们体验到前端开发乐趣。本课程突出实战，如果希望深入学习课程中涉及到的知识可报名学习前端开发课程。', '1');
INSERT INTO `course` VALUES ('7', '前端开发与Git入门', 'Git是一款免费、开源的分布式版本控制系统，用于敏捷高效地处理任何或小或大的项目。经过本章课程学习你将轻松入门，学会使用Git管理自己的源代码，让自己的开发之路井井有条，想进一步学习Git进阶部分的同学可报名前端开发课程。', '1');
INSERT INTO `course` VALUES ('8', '每天20分钟轻松入门React 666', '适合有一定HTML+JS基础、想学习React的同学。本课程循序渐进、浅显易懂，非常适合React入门学习。想进一步学习和使用React进行开发的同学可以报名前端开发课程。', '1');
INSERT INTO `course` VALUES ('9', 'UI基础入门', '适合无设计基础但想学UI设计的同学学习。本课程零基础入门，扎实的软件基础、高端的图形创意、资深产品经理的面对面授课尽在智游UI设计课程，希望成为全能设计师的你可报名UI设计课程。', '6');
INSERT INTO `course` VALUES ('11', 'Python编程零基础入门', '适合无编程基础但想学Python的同学学习。本课程完全零基础入门，如果希望深入学习Python开发可报名学习智游Python企业开发课程。', '10');
INSERT INTO `course` VALUES ('13', '轻松进击PHP基础', '适合无编程基础但想学PHP开发的同学学习。本课程零基础入门，学习完本节课程相信同学们都轻松入门PHP开发，如果希望深入学习PHP开发可报名学习智游PHP课程，资深”老司机”带你完成PHP大牛的进阶之路！', '11');
INSERT INTO `course` VALUES ('14', 'java入门小项目', '适合无编程基础但想学H5前端开发的同学入门学习，也适合UI、Java、PHP等其他学科学员预习或练习。本课程通过新闻页面、个人主页、个人简历、场景秀等多个项目案例由浅入深以项目实战的方式让同学们体验到前端开发乐趣。本课程突出实战，如果希望深入学习课程中涉及到的知识可报名学习前端开发课程。', '2');
INSERT INTO `course` VALUES ('15', 'Android开发与入门', 'Android前端开发课程。', '3');
INSERT INTO `course` VALUES ('16', 'IOS基础入门', '适合无设计基础但想学UI设计的同学学习。本课程零基础入门，扎实的软件基础、高端的图形创意、资深产品经理的面对面授课尽在智游UI设计课程，希望成为全能设计师的你可报名IOS设计课程。', '4');
INSERT INTO `course` VALUES ('17', '大数据基础入门', '适合无设计基础但想学UI设计的同学学习。本课程零基础入门，扎实的软件基础、高端的图形创意、资深产品经理的面对面授课尽在智游UI设计课程，希望成为全能设计师的你可报名大数据设计课程。', '5');
INSERT INTO `course` VALUES ('18', 'VR基础入门', '适合无设计基础但想学UI设计的同学学习。本课程零基础入门，扎实的软件基础、高端的图形创意、资深产品经理的面对面授课尽在智游UI设计课程，希望成为全能设计师的你可报名VR设计课程。', '7');
INSERT INTO `course` VALUES ('19', 'U3D基础入门', '适合无设计基础但想学UI设计的同学学习。本课程零基础入门，扎实的软件基础、高端的图形创意、资深产品经理的面对面授课尽在智游UI设计课程，希望成为全能设计师的你可报名U3D设计课程。', '8');
INSERT INTO `course` VALUES ('20', '人工智能基础入门', '适合无设计基础但想学UI设计的同学学习。本课程零基础入门，扎实的软件基础、高端的图形创意、资深产品经理的面对面授课尽在智游UI设计课程，希望成为全能设计师的你可报名人工智能设计课程。', '9');

-- ----------------------------
-- Table structure for speaker
-- ----------------------------
DROP TABLE IF EXISTS `speaker`;
CREATE TABLE `speaker` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `speaker_name` varchar(20) DEFAULT NULL COMMENT '主讲人姓名',
  `speaker_desc` text COMMENT '主讲人简介',
  `speaker_job` varchar(30) DEFAULT NULL COMMENT '职位',
  `head_img_url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of speaker
-- ----------------------------
INSERT INTO `speaker` VALUES ('7', '张三', 'H5第1期学员，毕业后留校任助教职务。精通H5课程内容，先后参与过T教育网站、移动网站、微网站、课时管理系统等多个项目的开发工作。', '高级讲师', 'https://hbimg.huabanimg.com/3d7de2c102148ec19d649f4184f1d5ab17ccdb42d412-pdvrzg_fw658');
INSERT INTO `speaker` VALUES ('8', '李四', '高级工程师，曾供职于多家公司，参与过多个企业级项目研发。对H5、iOS客户端开发及混合开发有深入的研究，熟悉PHP等服务端技术，有着多年的开发经验和教学经验。', '高级讲师', 'https://hbimg.huabanimg.com/2f25846b5bb9f6b26a00771069e77e034bf088f83086-QwjJTh_fw658');
INSERT INTO `speaker` VALUES ('9', '小明', 'Aotodesk国际认证动画师，精通架构设计、效果图表达、APP特效等。多年产品经理经验。  代表作品：《手机博物馆》，《诺客商城》、《途铂旅行》。', '高级讲师', 'http://img5.duitang.com/uploads/item/201507/22/20150722191150_TYL2a.thumb.224_0.jpeg');
INSERT INTO `speaker` VALUES ('10', '王五', '5年应用及平台开发经验，主导并参与多款商业、非商业性质软件的研发工作，精通Web前端、Python服务端、iOS手机App研发、VR开发、Unity3D开发等技术。', '高级讲师', 'http://img4q.duitang.com/uploads/item/201412/29/20141229235630_4MFxe.thumb.700_0.jpeg');
INSERT INTO `speaker` VALUES ('11', '赵六', '多年PHP开发经验，参与过多个WEB项目开发，带领团队开发过CRM系统、OA系统、项目管理系统、SEM平台。精通PHP及多款开发框架、MySQL集群、Linux服务器运维、H5前端开发。', '高级讲师', 'http://img.mp.itc.cn/upload/20160901/3be90c0c51f341a594b9739197e06140_th.png');
INSERT INTO `speaker` VALUES ('13', '李雷', '对数据库的访问和操作是必须的。Spring Data作为SpringSource的其中一个子项目，旨在统一和简化对各类型持久化存储和访问，而不拘泥于是关系型数据库还是NoSQL数据存储，使得对数据库的访问变得方便快捷，并支持MapReduce框架及云计算服务；', '教授', 'http://awb.img.xmtbang.com/img/uploadnew/201609/13/488962a4651d456c832b11a2d3f3b2c2.jpg');
INSERT INTO `speaker` VALUES ('14', '韩梅梅', '讲师实战课程已经上线，从0开始部署项目，掌握SSM和SpringBoot两大主流框架。详解SSM无缝迁移到SPRINGBOOT + MYBATIS的框架转换，远程调试项目并与微信结合，利用阿里SUI，实现前后端的全栈开发。', '讲师', 'http://img.mb.moko.cc/2018-08-16/43857a26-df2c-4230-803f-70e7372ba96b.jpg?imageView2/2/w/915/h/915');
INSERT INTO `speaker` VALUES ('15', '小十七', '高级工程师，曾供职于阿里巴巴，参与过多个企业级项目研发。对H5、iOS客户端开发及混合开发有深入的研究，熟悉PHP等服务端技术，有着多年的开发经验和教学经验。', '金牌讲师', null);

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='学科表，存储各个学科的名字';

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES ('1', 'WEB前端');
INSERT INTO `subject` VALUES ('2', 'Java');
INSERT INTO `subject` VALUES ('3', 'Android');
INSERT INTO `subject` VALUES ('4', 'IOS');
INSERT INTO `subject` VALUES ('5', '大数据');
INSERT INTO `subject` VALUES ('6', 'UI');
INSERT INTO `subject` VALUES ('7', 'VR');
INSERT INTO `subject` VALUES ('8', 'U3D');
INSERT INTO `subject` VALUES ('9', '人工智能');
INSERT INTO `subject` VALUES ('10', 'Python');
INSERT INTO `subject` VALUES ('11', 'PHP');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(40) DEFAULT NULL,
  `phoneNum` varchar(20) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `code` varchar(10) DEFAULT NULL,
  `nickName` varchar(10) DEFAULT NULL COMMENT '昵称',
  `sex` varchar(6) DEFAULT NULL,
  `birthday` varchar(20) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `imgUrl` varchar(100) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '123@qq.com', null, '123', '904643', '邢女士', 'woman', '1998-01-01', '新疆-乌鲁木齐', '', '2020-10-20 17:25:19');
INSERT INTO `user` VALUES ('2', '111@qq.com', null, 'c11086871e4220e8c351341d51e08e75', '904645', 'Y先生', 'man', '1997-01-01', '黑龙江-双鸭山', 'http://localhost:8081/img/970b4612-963a-4422-9576-aa6206620990.jpg', '2019-06-27 16:14:24');
INSERT INTO `user` VALUES ('3', '12345@qq.com', null, '12', null, '小禅院', 'man', '2019-06-25', '河南-开封', '2019-06-27/8bd3cceff89d42f0a6ef74a4718b45cd.png', '2020-10-21 16:29:20');
INSERT INTO `user` VALUES ('4', '123456@qq.com', null, '123', null, '小幸毛', 'man', '2000-1-1', '河南-开封', null, '2020-10-21 09:30:45');

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) DEFAULT NULL COMMENT '标题',
  `detail` text COMMENT '简介',
  `time` int(8) DEFAULT NULL COMMENT '时长',
  `speaker_id` int(5) DEFAULT NULL COMMENT '关联主讲人',
  `course_id` int(5) DEFAULT NULL COMMENT '关联课程表',
  `video_url` varchar(100) DEFAULT NULL COMMENT '视频播放地址',
  `image_url` varchar(100) DEFAULT NULL COMMENT '封面地址',
  `play_num` int(5) unsigned zerofill DEFAULT NULL COMMENT '播放次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=267 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES ('218', 'HTML页面基本结构', '新闻页面的开发，包括前端开发中最常用的HTML标签33331', '600', '9', '9', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img4.mukewang.com/5774d89a0001fafc06000338-240-135.jpg', '00666');
INSERT INTO `video` VALUES ('220', '新闻页面开发', '新闻页面的开发，包括前端开发中最常用的HTML标签：H1、P、DIV、SPAN、IMG、A等，还包括控制文字、图片、超链接等最常用的CSS样式。', '1374', '14', '6', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img3.mukewang.com/5a5824c100019a8506000338-240-135.jpg', '00335');
INSERT INTO `video` VALUES ('223', '了解PHP', '讲解了PHP的基本概述，帮助大家对PHP语言有一个大体的认知，包括：什么是PHP、PHP的优势、教育的PHP课程、Lamp与wamp的介绍、开发环境和开发工具的的配置、PHP基本语法。', '1268', '13', '13', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img4.mukewang.com/57466a7b0001a49806000338-240-135.jpg', '00345');
INSERT INTO `video` VALUES ('224', 'React快速体验-组件', '介绍了React的前生今世，让同学们了解库文件下载和整体的React项目结构及React库最简单的使用。', '907', '8', '8', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img2.mukewang.com/szimg/5c7e6835087ef3d806000338.jpg', '00191');
INSERT INTO `video` VALUES ('225', '个人主页项目开发-1', '个人主页项目的演示、页面结构分析、包括网页常见的构成：页头、LOGO、横幅、导航、主体、页脚等。在页头开发过程中使用了固定位置、定宽居中等常见的布局模式。', '1692', '7', '6', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img2.mukewang.com/szimg/5c6bdb3e08e4674a06000338.jpg', '00288');
INSERT INTO `video` VALUES ('226', 'React创建组件的方法', '详细介绍了最简单的React组件的创建、使用及组件之间的简单嵌套使用。', '749', '11', '8', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img4.mukewang.com/szimg/5ccec7ba08430b1d06000338.jpg', '00165');
INSERT INTO `video` VALUES ('227', 'ES6重写组件和生命周期', '使用ES6语法重写React组件，更简洁的语法，更清晰的思路，同时介绍了React组件的生命周期。', '1195', '8', '8', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img.mukewang.com/5c18cf540001ac8206000338-240-135.jpg', '00189');
INSERT INTO `video` VALUES ('228', '个人主页项目开发-2', '个人主页项目页面主体部分的开发，大量使用了定宽居中的技术，在我的同学部分还使用了相对定位、绝对定位等非常重要定位技术，还使用了圆形边框等CSS3新技术。', '1699', '7', '6', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img4.mukewang.com/szimg/5a9614850001bc3405400300.jpg', '00272');
INSERT INTO `video` VALUES ('229', '使用JSX创建组件', '使用JSX重写React单一组件、组合组件，了解React的组件化思想及JSX的使用。', '1414', '8', '8', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img4.mukewang.com/57466a7b0001a49806000338-240-135.jpg', '00263');
INSERT INTO `video` VALUES ('230', '个人主页项目开发-3', '个人主页的语义化重构。介绍了H5语义化的意义、将非语义化的DIV+CSS改造成语义化标签的具体实践过程。以及VS Code分割视图在开发中的应用。', '409', '7', '6', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img4.mukewang.com/5afe7ffa00018fff06000338-240-135.jpg', '00237');
INSERT INTO `video` VALUES ('231', 'React虚拟DOM', 'React的快速响应魅力所在——虚拟DOM，本节课详细比较了普通DOM和虚拟DOM的区别。', '1468', '8', '8', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img1.mukewang.com/5b4705c90001fc9506000338-240-135.jpg', '00250');
INSERT INTO `video` VALUES ('238', '个人简历项目开发-1', '个人简历项目的开发。RGB颜色简介，字体简介及安装。本案例重度使用定位技术，使用了CSS3中新增的旋转图形变换技术。以及一些高级CSS选择器。', '2112', '7', '6', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img4.mukewang.com/5a56fdb400017d0306000338-240-135.jpg', '00236');
INSERT INTO `video` VALUES ('240', '个人简历项目开发-2', '个人简历项目开发的第二部分，包括字体的使用（注意：实际开发中会使用更高级的技术来使用字体）、背景图片的控制、内容溢出控制、绝对定位元素的层次控制、半透明的使用等。', '1997', '10', '6', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img4.mukewang.com/5b14c8690001f5b406000338-240-135.jpg', '00209');
INSERT INTO `video` VALUES ('242', '场景秀项目开发-1', '场景秀项目是一个手机页面、本部分介绍了响应式开发环境、viewport在响应式开发中的应用、vw/vh等响应式CSS单位的使用、CSS函数calc()在单位混合计算时的使用。', '1569', '7', '6', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img3.sycdn.imooc.com/szimg/5cb68a1408ed350506000338.jpg', '00223');
INSERT INTO `video` VALUES ('244', '场景秀项目开发-2', '场景秀动画部分的开发、本部分是场景秀开发的最出彩最重要的部分。包括关键帧动画的定义、平移动画、绽放动画等动画效果的实现方法。H5音频及JS控制音乐播放暂停。', '2179', '13', '6', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img4.mukewang.com/szimg/5a7127370001a8fa05400300.jpg', '00224');
INSERT INTO `video` VALUES ('245', 'Git的安装及配置', '介绍了Git的强大之处：保存开发过程、实验新特性而不破坏现有数据、多人合作开发、分布式思想、没网也可以使用，详细的讲解了Git的下载方法和安装注意事项。', '320', '14', '7', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img1.mukewang.com/szimg/5c87891f08dd162706000338.jpg', '00209');
INSERT INTO `video` VALUES ('246', '使用Git记录开发过程', '详细操作了使用Git管理源代码，包括：初始化、从工作区添加到暂存区、从暂存区添加到持久区等Git命令，同时介绍了Git的文件结构、撤回功能。', '1024', '11', '7', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img.mukewang.com/5cbe757b090f061210800600-240-135.jpg', '00158');
INSERT INTO `video` VALUES ('247', '响应式登录页面项目开发', '响应式页面开发与移动端适配，重点内容包括vw/vh单位、媒体查询的介绍及在移动端适配中的应用方法。表单及INPUT标签的基本使用和使用CSS控制表单样式的方法等。', '2134', '11', '6', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img2.mukewang.com/5b69143200016a1f05400300-240-135.jpg', '00246');
INSERT INTO `video` VALUES ('248', '使用码云作为远程代码库', '内容将从基础带你了解渲染的基础灯光操作及应用，包含了maya默认灯光（聚光灯，平行光，面光源，点光源，环境光），在之后还讲解了当下流行的ar渲染器的应用及设置。', '385', '10', '7', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img2.mukewang.com/5b69143200016a1f05400300-240-135.jpg', '00171');
INSERT INTO `video` VALUES ('249', '与远程代码库同步', '详细讲解在码云上面创建自己的项目并克隆到本地，使用Git命令将本地代码提交到远程仓库等内容。', '355', '14', '7', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img2.mukewang.com/5b39ca9100014d8605400300-240-135.jpg', '00222');
INSERT INTO `video` VALUES ('250', 'Python运行环境下载', 'Python开发环境的搭建，Python的下载及安装，帮助大家准备好Python开发环境。', '350', '9', '11', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img.mukewang.com/5b1dd1fa0001b70d06000338-240-135.jpg', '00247');
INSERT INTO `video` VALUES ('251', 'Python运行环境安装', 'Windows操作系统下面Python环境的安装及注意事项。', '239', '11', '11', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img2.mukewang.com/5aaf1f110001a0e105400300-240-135.jpg', '00180');
INSERT INTO `video` VALUES ('252', 'IDLE的基本使用', 'Python自带编辑器IDLE的使用，初识Python的语法，简单语法的编写和运行。', '1149', '14', '11', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img4.mukewang.com/5b03c68a000159b506000338-240-135.jpg', '00194');
INSERT INTO `video` VALUES ('253', 'Sublime的基本使用', 'Sublime的安装及基本使用，主要介绍了Sublime的智能提示功能，常用操作，例如新建文件、保存文件、字体设置、窗口背景颜色等。', '565', '10', '11', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img2.mukewang.com/5639a1b700013b9409600540-240-135.jpg', '00166');
INSERT INTO `video` VALUES ('254', 'Print语句', '讲解Python中的语句概述，主要介绍了常用的Print语句，语法错误的解决，以及注释的写法。', '805', '8', '11', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img4.mukewang.com/5bc0879f0001852905400300-240-135.jpg', '00192');
INSERT INTO `video` VALUES ('255', '变量', '介绍了Python语法中的变量写法、使用以及变量命名中的注意事项。', '332', '10', '11', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img2.mukewang.com/5b9f24bb0001fb3706000338-240-135.jpg', '00272');
INSERT INTO `video` VALUES ('256', '运算符', '讲解Python中运算符的基本使用，主要有算数运算符、比较运算符，介绍了三个双引号注释多行代码，', '667', '10', '11', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img2.mukewang.com/5b69142c0001d10705400300-240-135.jpg', '00209');
INSERT INTO `video` VALUES ('257', 'If条件语句', '讲解Python中的if条件语句，利用if语句进行简单的出租车价格计算。', '1099', '7', '11', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img.mukewang.com/5bf4c6940001df6c05400300-240-135.jpg', '00194');
INSERT INTO `video` VALUES ('258', 'While循环', '介绍Python编程中的while循环语句的基本形式，语句格式等。', '1024', '11', '11', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img1.mukewang.com/5b9b4f6b0001130205400300-240-135.jpg', '00185');
INSERT INTO `video` VALUES ('259', 'java入门', '介绍了Java基础知识，便于新手了解学习', '1022', '2', '14', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img.mukewang.com/5bf4c6940001df6c05400300-240-135.jpg', '00133');
INSERT INTO `video` VALUES ('260', 'java基础', '介绍了Java基础知识，便于有部分基础的选手了解学习', '666', '2', '14', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img.mukewang.com/5bf4c6940001df6c05400300-240-135.jpg', '00111');
INSERT INTO `video` VALUES ('261', '使用Android记录开发过程', '详细操作了使用Git管理源代码，包括：初始化、从工作区添加到暂存区、从暂存区添加到持久区等Git命令，同时介绍了Git的文件结构、撤回功能。', '888', '3', '15', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img.mukewang.com/5cbe757b090f061210800600-240-135.jpg', '00154');
INSERT INTO `video` VALUES ('262', 'IOS的安装及配置', '介绍了Git的强大之处：保存开发过程、实验新特性而不破坏现有数据、多人合作开发、分布式思想、没网也可以使用，详细的讲解了Git的下载方法和安装注意事项。', '320', '4', '16', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img1.mukewang.com/szimg/5c87891f08dd162706000338.jpg', '00209');
INSERT INTO `video` VALUES ('263', '大数据参与远程代码库同步', '详细讲解在码云上面创建自己的项目并克隆到本地，使用Git命令将本地代码提交到远程仓库等内容。', '355', '5', '17', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img2.mukewang.com/5b39ca9100014d8605400300-240-135.jpg', '00666');
INSERT INTO `video` VALUES ('264', 'UR响应式登录页面项目开发', '响应式页面开发与移动端适配，重点内容包括vw/vh单位、媒体查询的介绍及在移动端适配中的应用方法。表单及INPUT标签的基本使用和使用CSS控制表单样式的方法等。', '213', '7', '18', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img2.mukewang.com/5b69143200016a1f05400300-240-135.jpg', '00246');
INSERT INTO `video` VALUES ('265', 'U3D开发', '讲解Python中的语句概述，主要介绍了常用的Print语句，语法错误的解决，以及注释的写法。', '805', '8', '19', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img4.mukewang.com/5bc0879f0001852905400300-240-135.jpg', '00192');
INSERT INTO `video` VALUES ('266', '了解人工智能', '讲解了PHP的基本概述，帮助大家对PHP语言有一个大体的认知，包括：什么是PHP、PHP的优势、教育的PHP课程、Lamp与wamp的介绍、开发环境和开发工具的的配置、人工智能基本语法。', '1268', '9', '20', 'http://hgte298gtrciknerdgm.exp.bcevod.com/mda-jeryxrg7gfggfk3f/mda-jeryxrg7gfggfk3f.mp4', 'https://img4.mukewang.com/57466a7b0001a49806000338-240-135.jpg', '00345');
