package com.seledtsova.dao;

import com.seledtsova.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    void add(Employee employee);

    List<Employee> findAll();

    void delete(Long id);

    void update(Long id, Employee employee);

    Employee findById(long id);
}
