package com.kukkyva.springdatajpademo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "Student_Tbl"
        ,
        uniqueConstraints = @UniqueConstraint(
                name = "emailId Unique",
                columnNames = "email_addresses"
        )
)
public class Student {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String firstName;
    private String lastName;
    @Column(name = "email_addresses",nullable = false)
    private String emailId;
    @Embedded
    private Guardian guardian;

}
