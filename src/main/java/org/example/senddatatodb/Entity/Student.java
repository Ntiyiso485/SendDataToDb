package org.example.senddatatodb.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "firstName",nullable=false)
    private String firstName;

    @Column (name = "lastName",nullable=false)
    private String lastName;

    @Column (name = "email",unique = true, nullable = false)
    private String email;

}
