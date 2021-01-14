/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  DELL
 * Created: 13/01/2021
 */

DROP TABLE IF EXISTS log;

CREATE TABLE log (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  documento VARCHAR(250) NOT NULL,
  fecha TIMESTAMP NOT NULL,
  entrada BLOB NULL,
  resultado BLOB NULL
);