package com.spring.course.dbrelations.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "projects")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@ToString(exclude = {"employee"})
public class Project {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(name = "project_name")
    private String projectName;

    @NonNull
    @Column(name = "project_duration")
    private Integer projectDuration;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private Employee employee;
}
