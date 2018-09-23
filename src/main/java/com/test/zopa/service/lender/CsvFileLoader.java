package com.test.zopa.service.lender;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Component
public class CsvFileLoader {

    public Stream<String> parseCsvFile(String filename) throws IOException {
        Path path = Paths.get(System.getProperty("user.dir") + "/" + filename);
        return Files.lines(path);
    }
}
