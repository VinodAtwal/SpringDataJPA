package com.kukkyva.springdatajpademo.repository;

import com.kukkyva.springdatajpademo.entity.Guardian;
import com.kukkyva.springdatajpademo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("email1.com")
                .firstName("testFistName1")
                .lastName("testLastName")
                .guardian(Guardian.builder()
                        .guardianName("gt1")
                        .guardianEmail("gte1")
                        .guardianMobile("hmb1")
                        .build())
                .build();
        studentRepository.save(student);

    }

}