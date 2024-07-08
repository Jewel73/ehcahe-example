package com.example.ehcache_example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tests")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping
    public List<Test> getAllTests() {
        return testService.getAllTests();
    }

    @GetMapping("/page")
    public Page<Test> getAllTests(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size) {
        return testService.getAllTests(page, size);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Test> getTestById(@PathVariable Long id) {
        Optional<Test> test = testService.getTestById(id);
        if (test.isPresent()) {
            return ResponseEntity.ok(test.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Test createTest(@RequestBody Test test) {
        return testService.createTest(test);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Test> updateTest(@PathVariable Long id, @RequestBody Test testDetails) {
        try {
            Test updatedTest = testService.updateTest(id, testDetails);
            return ResponseEntity.ok(updatedTest);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTest(@PathVariable Long id) {
        testService.deleteTest(id);
        return ResponseEntity.noContent().build();
    }
}
