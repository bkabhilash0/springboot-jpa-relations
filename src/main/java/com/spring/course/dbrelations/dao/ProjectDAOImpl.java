package com.spring.course.dbrelations.dao;

import com.spring.course.dbrelations.entity.Project;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDAOImpl implements ProjectDAO{

    private EntityManager entityManager;

    @Autowired
    public ProjectDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Project> getAllProjects() {
        return entityManager.createQuery("from Project", Project.class).getResultList();
    }

    @Override
    public List<Project> getProjectsByEmployeeId(Integer id) {
        TypedQuery<Project> query = entityManager.createQuery("from Project where employee.id=:data",Project.class);
        query.setParameter("data", id);
        return query.getResultList();
    }
}
