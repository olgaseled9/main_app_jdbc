package com.seledtsova.dao.impl;


import com.seledtsova.dao.EmployeeDao;
import com.seledtsova.entity.Employee;
import com.seledtsova.exception.DaoException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeDaoImpl implements EmployeeDao {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

    private static final String SELECT_FROM_EMPLOYEE_TABLE =
            "SELECT employee_id , first_name, last_name, department_id, job_title, gender, date_of_birth FROM employee";
    private static final String DELETE_EMPLOYEE = "DELETE FROM employee WHERE employee_id = ?";
    private static final String SELECT_EMPLOYEE_BY_ID =
            "SELECT employee_id , first_name, last_name, department_id, job_title, gender, date_of_birth FROM employee WHERE employee_id=?";
    private static final String UPDATE_EMPLOYEE =

            "UPDATE employee SET (first_name=?, last_name=?, department_id=?, job_title=?, gender=?, date_of_birth=?) WHERE employee_id=?";
    private static final String ADD_NEW_EMPLOYEE =
            "INSERT INTO employee (first_name, last_name, department_id, job_title, date_of_birth, gender) VALUES (?,?,?,?,?,?)";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Employee employee) {
        try {
            jdbcTemplate.update(ADD_NEW_EMPLOYEE, employee.getFirstname(), employee.getLastname(),
                    employee.getDepartmentId(), employee.getJobTitle(), employee.getDateOfBirth(), employee.getGender());
        } catch (DaoException e) {
            logger.error("Add employee is not available" + e.getMessage(), e);
        }
    }

    @Override
    public List<Employee> findAll() {
        try {
            return jdbcTemplate.query(SELECT_FROM_EMPLOYEE_TABLE, new EmployeeMapper());
        } catch (DaoException e) {
            logger.error("Get all employees is not available" + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        try {
            jdbcTemplate.update(DELETE_EMPLOYEE, id);
        } catch (DaoException e) {
            logger.error("Delete employee is not available" + e.getMessage(), e);
        }
    }

    @Override
    public void update(Long id, Employee employee) {
        try {
            jdbcTemplate.update(UPDATE_EMPLOYEE,
                    new Object[]{employee.getFirstname(), employee.getLastname(), employee.getDepartmentId(), employee.getJobTitle(), employee.getGender(), employee.getDateOfBirth()}, id);
        } catch (DaoException e) {
            logger.error("Update employee is not available" + e.getMessage(), e);
        }
    }

    @Override
    public Employee findById(long id) {
        try {
            return jdbcTemplate.query(SELECT_EMPLOYEE_BY_ID, new Object[]{id},
                            new EmployeeMapper())
                    .stream().findAny().orElse(null);
        } catch (DaoException e) {
            logger.error("Find employee is not available" + e.getMessage(), e);
        }
        return null;
    }
}
