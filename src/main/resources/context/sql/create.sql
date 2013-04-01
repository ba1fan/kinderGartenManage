CREATE DATABASE gartenManage;

use gartenManage;
CREATE  TABLE  `User`
(
  `userId` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `status` int(2),
  `departId` int(10),
  PRIMARY KEY (`userId`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE  TABLE  `Auth`
(
  `authId` int(10) NOT NULL AUTO_INCREMENT,
  `type` int(2) NOT NULL,
  `url` varchar(50) NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`authId`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE  TABLE  `AuthMap`
(
  `authMapId` int(10) NOT NULL AUTO_INCREMENT,
  `authId` int(10) NOT NULL,
  `departId` int(10) NOT NULL,
  PRIMARY KEY (`authMapId`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE  TABLE  `Depart`
(
  `departId` int(10) NOT NULL AUTO_INCREMENT,
  `departName` varchar(20) NOT NULL,
  `status` int(2) NOT NULL,
  PRIMARY KEY (`departId`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE  TABLE  `Educate`
(
  `educateId` int(10) NOT NULL AUTO_INCREMENT,
  `educateName` varchar(20) NOT NULL,
  PRIMARY KEY (`educateId`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE  TABLE  `TechTitle`
(
  `titleId` int(10) NOT NULL AUTO_INCREMENT,
  `titleName` varchar(20) NOT NULL,
  PRIMARY KEY (`titleId`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE  TABLE  `TeacherInfo`
(
  `teacherId` int(10) NOT NULL AUTO_INCREMENT,
  `teacherName` varchar(20) NOT NULL,
  `sex` int(1) NULL,
  `age` int(3) NULL,
  `educateId` int(10) NOT NULL,
  `titleId` int(10) NOT NULL,
  `departId` int(10) NOT NULL,
  `userId` int(10) NOT NULL,
  `subject` varchar(20) NULL,
  `tel` varchar(20) NULL,
  `educateSchool` varchar(20) NULL,
  `addTime` datetime NULL,
  `salary` varchar(20) NULL,
  PRIMARY KEY (`teacherId`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE  TABLE  `TeacherLog`
(
  `logId` int(10) NOT NULL AUTO_INCREMENT,
  `logType` int(1) NOT NULL,
  `resFromId` int(10) NOT NULL,
  `resToId` int(10) NOT NULL,
  `teacherId` int(10) NOT NULL,
  `addTime` datetime NULL,
  PRIMARY KEY (`logId`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


