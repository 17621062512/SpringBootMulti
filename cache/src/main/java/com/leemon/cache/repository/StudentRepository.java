package com.leemon.cache.repository;

import com.leemon.cache.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByName(String name);

}
