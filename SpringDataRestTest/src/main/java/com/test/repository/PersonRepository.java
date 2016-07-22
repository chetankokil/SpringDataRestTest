package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
