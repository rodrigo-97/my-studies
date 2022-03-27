package com.app.mystudies.msstudent.repositories;

import com.app.mystudies.msstudent.models.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
