package com.example.kodillahibernate.manytomany.dao;

import com.example.kodillahibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer>{
    @Query
    List<Employee> retrieveEmployeeWhereName(@Param("LASTNAME") String lastName);
    @Query
    List<Employee> retrieveEmployeeWhereNameContains(@Param("LASTNAME") String lastName);
}