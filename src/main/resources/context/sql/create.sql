CREATE DATABASE gartenManage;

use gartenManage;
CREATE  TABLE  `User`
(
  `userId` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `status` int(2),
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