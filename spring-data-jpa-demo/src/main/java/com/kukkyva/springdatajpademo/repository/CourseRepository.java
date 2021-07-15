package com.kukkyva.springdatajpademo.repository;

import com.kukkyva.springdatajpademo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
}
