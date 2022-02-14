package ru.itsjava.services;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class IOServiceImpl implements IOService {
    private final BufferedReader reader;

    public IOServiceImpl(@Value("#{T(java.lang.System).in}") InputStream inputStream) {
        this.reader = new BufferedReader(new InputStreamReader(inputStream));
    }


    @SneakyThrows
    @Override
    public String input() {
        return reader.readLine();
    }

    @SneakyThrows
    @Override
    public int inputInt() {
        return  Integer.parseInt(reader.readLine().strip());

    }
}
