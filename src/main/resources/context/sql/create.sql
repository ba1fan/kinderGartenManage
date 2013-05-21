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

CREATE  TABLE  `UserLog`
(
  `userLogId` int(10) NOT NULL AUTO_INCREMENT,
  `userId` int(10) NULL,
  `addTime` datetime NULL,
  `status` int(2) NULL,
  PRIMARY KEY (`userLogId`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE  TABLE  `Auth`
(
  `authId` int(10) NOT NULL AUTO_INCREMENT,
  `type` int(2) NOT NULL,
  `url` varchar(50)  NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`authId`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE  TABLE  `AuthMap`
(
  `authMapId` int(10) NOT NULL AUTO_INCREMENT,
  `authStr` varchar(500)  NULL,
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

CREATE  TABLE  `phyParameter`
(
  `year` int(2) NOT NULL,
  `month` int(2) NOT NULL,
  `glevel` float(10) NOT NULL,
  `flevel` float(10) NOT NULL,
  `elevel` float(10) NOT NULL,
  `dlevel` float(10) NOT NULL,
  `clevel` float(10) NOT NULL,
  `blevel` float(10) NOT NULL,
  `alevel` float(10) NOT NULL,
  `sex` int(1) NOT NULL,
  `phyType` int(1) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE  TABLE  `Clazz`
(
  `clazzId` int(10) NOT NULL AUTO_INCREMENT,
  `clazzName` varchar(20) NOT NULL,
  PRIMARY KEY (`clazzId`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE  TABLE  `Child`
(
  `childId` int(10) NOT NULL AUTO_INCREMENT,
  `childName` varchar(20) NOT NULL,
  `birthday` datetime  NULL,
  `entranday` datetime NULL,
  `clazzId` int(10) NULL,
  `isTeahcher` int(1) NULL,
  `isGrandTeahcher` int(1) NULL,
  `address` varchar(50)  NULL,
  `fatherName`  varchar(20)  NULL,
  `fatherAge`  varchar(2)  NULL,
  `fatherOcu`  varchar(20)  NULL,
  `motherName`  varchar(20)  NULL,
  `motherAge` varchar(2)  NULL,
  `motherOcu`  varchar(20)  NULL,
  `tel` varchar(20)  NULL,
  `sex` int(1)  NULL,
  PRIMARY KEY (`childId`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE  TABLE  `Attendance`
(
  `attendId` int(10) NOT NULL AUTO_INCREMENT,
  `childId` int(10) NULL,
  `year` int(10)  NULL,
  `month` int(10)  NULL,
  `count` int(10)  NULL,
  PRIMARY KEY (`attendId`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE  TABLE  `physicalLog`
(
  `logId` int(10) NOT NULL AUTO_INCREMENT,
  `childId` int(10) NULL,
  `year` int(10)  NULL,
  `term` int(10)  NULL,
  `height` float(10)  NULL,
  `weight` float(10)  NULL,
  `heightPoint` varchar(20)  NULL,
  `weightPoint` varchar(20)  NULL,
  `addTime` datetime NULL,
  PRIMARY KEY (`logId`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE  TABLE  `MonthWage`
(
  `monthWageId` int(10) NOT NULL AUTO_INCREMENT,
  `year` int(10)  NULL,
  `month` int(10)  NULL,
  `childId` int(10)  NULL,
  `boardWages` float(10)  NULL,
  `skillWages` float(10)  NULL,
  `arrears` float(10)  NULL,
  `careWages` float(10)  NULL,
  `manageWages` float(10)  NULL,
  `overdue` float(10)  NULL,
  `other` float(10)  NULL,
  `totalWages` float(10)  NULL,
  `payWages` float(10)  NULL,
  `addTime` datetime NULL,
  PRIMARY KEY (`monthWageId`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE  TABLE  `yearWage`
(
  `yearWageId` int(10) NOT NULL AUTO_INCREMENT,
  `year` int(10)  NULL,
  `term` int(10)  NULL,
  `childId` int(10)  NULL,
  `applyWages` float(10)  NULL,
  `airWages` float(10)  NULL,
  `airCollWages` float(10)  NULL,
  `borrowWages` float(10)  NULL,
  `quiltWages` float(10)  NULL,
  `manageWages` float(10)  NULL,
  `careWages` float(10)  NULL,
  `otherWages` float(10)  NULL,
  `authorize` float(10)  NULL,
  `overstaffs` float(10)  NULL,
  `cookWages` float(10)  NULL,
  `totalWages` float(10)  NULL,
  `payWages` float(10)  NULL,
  `addTime` datetime NULL,
  PRIMARY KEY (`yearWageId`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;