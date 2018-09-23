package com.test.zopa;

import com.test.zopa.service.ZopaComparisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ZopaApplication
        implements CommandLineRunner {

    @Autowired
    private ZopaComparisonService zopaComparisonService;

    public static void main(String[] args) {
        SpringApplication.run(ZopaApplication.class, args);
    }

    @Override
    public void run(String... args) throws IOException {
        zopaComparisonService.calculateComparison(args[0], args[1]);
    }
}
