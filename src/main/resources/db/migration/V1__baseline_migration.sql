CREATE TABLE IF NOT EXISTS `flight_data` (
  `flight_number`                    VARCHAR(255) NOT NULL,
  `start`                            VARCHAR(255),
  `end`                              VARCHAR(255),
  `date`                             VARCHAR(255),
  `aircraft`                         VARCHAR(255),
  PRIMARY KEY (`flight_number`)
) ENGINE=InnoDB CHARSET=utf8;

--INSERT INTO `flight_data` VALUES ('SF2490','STR','FRA','2018-10-10T10:00:00Z','DHC-8-400');