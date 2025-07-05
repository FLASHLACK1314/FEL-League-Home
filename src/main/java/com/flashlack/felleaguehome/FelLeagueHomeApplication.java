package com.flashlack.felleaguehome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * SpringBoot应用程序FelLeagueHome的入口点。
 * @author FLASHLACK
 */
@SpringBootApplication
@EnableAsync
public class FelLeagueHomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FelLeagueHomeApplication.class, args);
    }

}
