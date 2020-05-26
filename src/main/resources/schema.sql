DROP TABLE IF EXISTS CITY; 
 
CREATE TABLE CITY (  
City_code INT AUTO_INCREMENT  PRIMARY KEY,  
city_name VARCHAR(50) NOT NULL,  
city_pincode INT(8) NOT NULL  
);

INSERT INTO CITY (city_name,city_pincode) VALUES ('Delhi', 110001);  
INSERT INTO CITY (city_name,city_pincode) VALUES ('Kanpur', 208001);  
INSERT INTO CITY (city_name,city_pincode) VALUES ('Lucknow', 226001);  
