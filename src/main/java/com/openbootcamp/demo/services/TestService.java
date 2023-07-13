package com.openbootcamp.demo.services;

import com.openbootcamp.demo.models.Test;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {
    private final List<Test> tests = new ArrayList<>();

    public List<Test> getAll() {
        return tests;
    }

    public void add(Test test) {
        tests.add(test);
    }

    public Test get(String name) {
        for (Test test : tests) {
            if (test.getName().equalsIgnoreCase(name))
                return test;
        }
        return null;
    }


}
