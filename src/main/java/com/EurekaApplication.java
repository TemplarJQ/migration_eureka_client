package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */

@EnableEurekaClient
@SpringBootApplication
public class EurekaApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(EurekaApplication.class, args);
        System.out.println( "Hello World!" );
    }
}
