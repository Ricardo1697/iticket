/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iticket.repository;

import com.iticket.entity.Conciertos;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rivil
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Repository
public interface ConciertosRepository extends CrudRepository<Conciertos,Long> {
    
}
