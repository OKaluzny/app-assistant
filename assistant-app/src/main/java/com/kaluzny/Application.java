package com.kaluzny;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Main application class.
 *
 * @author Oleg Kaluzny
 */
@ServletComponentScan
@EnableConfigurationProperties
@SpringBootApplication
public class Application {

    /**
     * Application start point.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
