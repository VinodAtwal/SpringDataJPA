package com.kukkyva.springdatajpademo;

import com.kukkyva.springdatajpademo.entity.*;
import com.kukkyva.springdatajpademo.repository.CourseMaterialRepository;
import com.kukkyva.springdatajpademo.repository.CourseRepository;
import com.kukkyva.springdatajpademo.repository.StudentRepository;
import com.kukkyva.springdatajpademo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Running implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("======>  commandLineRunner  <=====");
//        Student student = Student.builder()
//                .emailId("email1.com")
//                .firstName("testFistName1")
//                .lastName("testLastName")
//                .guardian(Guardian.builder()
//                        .guardianName("gt1")
//                        .guardianEmail("gte1")
//                        .guardianMobile("hmb1")
//                        .build())
//                .build();
//        studentRepository.save(student);
//
//        System.out.println(studentRepository.findByFirstName("testFistName1"));
//
//        System.out.println(studentRepository.getStudentByEmailIdNative("email1.com"));
//
//        studentRepository.updateStudentNameByEmailId("testFistName2","email1.com");
//        saveCourseMaterial();
//        printAllCoursesMaterial();
        saveTeacher();


    }

    public void saveTeacher(){
        Teacher teacher = Teacher.builder().firstName("f1").lastName("l1").build();
        Course course =Course.builder().title("DBA").credit(6).teacher(teacher).build();
//        Teacher teacher = Teacher.builder().firstName("f1").lastName("l1").courses(List.of(course)).build();
        courseRepository.save(course);



    }

    public void saveCourseMaterial(){
        Course course = Course.builder()
                .title("DSA").credit(6).build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google.com")
                .course(course).build();
        courseMaterialRepository.save(courseMaterial);
    }
    public void printAllCoursesMaterial(){
        List<CourseMaterial> courseMaterialList = courseMaterialRepository.findAll();
        System.out.println(courseMaterialList);
        System.out.println(courseMaterialList.get(0).getCourse());

    }
}
