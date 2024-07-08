package com.example.ehcache_example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {


    @Autowired
    private TestRepository testRepository;

    @Cacheable(value = "testCache")
    public List<Test> getAllTests() {
        return testRepository.findAll();
    }

    @Cacheable(value = "pageCache", key = "#page + '-' + #size")
    public Page<Test> getAllTests(int page, int size) {
        Pageable content = Pageable.ofSize(size).withPage(page);
        return testRepository.findAll(content);
    }

    public Optional<Test> getTestById(Long id) {
        return testRepository.findById(id);
    }

    public Test createTest(Test test) {
        return testRepository.save(test);
    }

    public Test updateTest(Long id, Test testDetails) {
        Optional<Test> optionalTest = testRepository.findById(id);
        if (optionalTest.isPresent()) {
            Test test = optionalTest.get();
            test.setName(testDetails.getName());
            test.setDescription(testDetails.getDescription());
            return testRepository.save(test);
        } else {
            throw new RuntimeException("Test not found with id " + id);
        }
    }

    public void deleteTest(Long id) {
        testRepository.deleteById(id);
    }
}
