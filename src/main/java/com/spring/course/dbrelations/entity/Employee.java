package com.spring.course.dbrelations.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@ToString(exclude = {"projects"})
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(name = "first_name")
    private String firstName;

    @NonNull
    @Column(name = "last_name")
    private String lastName;

    @NonNull
    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_details_id")
    private EmployeeDetails employeeDetails;

//    By Default Lazy Loaded
    @OneToMany(mappedBy = "employee",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Project> projects;

    public void add(Project newProject) {
        if (this.projects == null) {
            this.projects = new ArrayList<>();
        }

        this.projects.add(newProject);
        newProject.setEmployee(this);
    }
}
