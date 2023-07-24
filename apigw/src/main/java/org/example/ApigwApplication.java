package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class ApigwApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(ApigwApplication.class,args);
        System.out.println( "Api gateway is running... " );
    }
}
