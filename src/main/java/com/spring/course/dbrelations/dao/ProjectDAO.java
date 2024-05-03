package com.spring.course.dbrelations.dao;

import com.spring.course.dbrelations.entity.Project;

import java.util.List;

public interface ProjectDAO {
    List<Project> getAllProjects();

    List<Project> getProjectsByEmployeeId(Integer id);
}
