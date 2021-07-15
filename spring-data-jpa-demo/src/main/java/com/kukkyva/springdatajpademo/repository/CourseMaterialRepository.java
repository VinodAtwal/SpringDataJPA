package com.kukkyva.springdatajpademo.repository;

import com.kukkyva.springdatajpademo.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial ,Long> {
}
