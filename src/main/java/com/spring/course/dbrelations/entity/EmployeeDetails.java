package com.spring.course.dbrelations.entity;

import jakarta.persistence.*;
import lombok.*;

@ToString(exclude = {"employee"})
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_details")
public class EmployeeDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(name = "location")
    private String location;

    @NonNull
    @Column(name="role")
    private String role;

    @OneToOne(mappedBy = "employeeDetails",cascade = CascadeType.ALL)
    private Employee employee;

}
