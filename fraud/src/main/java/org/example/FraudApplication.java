package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class FraudApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(FraudApplication.class,args);
        System.out.println( "Fraud service is running..." );
    }
}
