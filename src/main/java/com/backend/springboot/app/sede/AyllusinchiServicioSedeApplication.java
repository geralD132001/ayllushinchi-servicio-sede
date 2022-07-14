package com.backend.springboot.app.sede;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@EntityScan({"com.backend.springboot.app.commons.sedes.models.entity"})
@SpringBootApplication
public class AyllusinchiServicioSedeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AyllusinchiServicioSedeApplication.class, args);
    }

}
