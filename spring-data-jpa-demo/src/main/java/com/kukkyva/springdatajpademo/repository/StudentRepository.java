package com.kukkyva.springdatajpademo.repository;

import com.kukkyva.springdatajpademo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);

    public List<Student> findByLastNameNotNull();

    //JPQL
    @Query("select s from Student s where s.emailId= ?1" )
    public Student getStudentByEmailId(String emailId);

    //Native
    @Query(
            value = "select  * from Student_Tbl s where s.email_addresses=?1",
            nativeQuery = true
    )
    public Student getStudentByEmailIdNative(String emailId);

    //NativeNamedParam
    @Query(
            value = "select  * from Student_Tbl s where s.email_addresses=:emailId",
            nativeQuery = true
    )
    public Student getStudentByEmailIdNativeNamePram(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(
            value = "update Student_Tbl set first_name =?1 where email_addresses= ?2 ",
            nativeQuery = true
    )
    public int updateStudentNameByEmailId(String firstName, String emailId);
}
