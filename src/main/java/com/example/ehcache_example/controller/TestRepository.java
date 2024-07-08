package com.example.ehcache_example.controller;


import jakarta.persistence.QueryHint;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> , JpaSpecificationExecutor<Test> {

    @QueryHints(@QueryHint(name = "org.hibernate.cacheable", value = "true"))
    List<Test> findAll();

}
