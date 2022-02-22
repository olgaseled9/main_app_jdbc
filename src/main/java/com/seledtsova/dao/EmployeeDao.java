package com.seledtsova.dao;

import com.seledtsova.entity.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao {

    private static final String SELECT_FROM_EMPLOYEE_TABLE =
            "SELECT employee_id , first_name, last_name, department_id, job_title, gender, date_of_birth FROM employee";
    private static final String DELETE_EMPLOYEE = "DELETE FROM employee WHERE employee_id = ?";
    private static final String SELECT_EMPLOYEE_BY_ID =
            "SELECT employee_id , first_name, last_name, department_id, job_title, gender, date_of_birth FROM employee WHERE employee_id=?";
    private static final String UPDATE_EMPLOYEE =
            "UPDATE employee SET first_name= ?, last_name= ?, department_id= ?, job_title= ?, gender= ?, date_of_birth= ? WHERE employee_id=?";
    private static final String ADD_NEW_EMPLOYEE =
            "INSERT INTO employee (first_name, last_name, department_id, job_title, date_of_birth, gender) VALUES (?,?,?,?,?,?)";

    private final JdbcTemplate jdbcTemplate;

    public EmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(Employee employee) {
        jdbcTemplate.update(ADD_NEW_EMPLOYEE, employee.getFirstname(), employee.getLastname(),
                employee.getDepartmentId(), employee.getJobTitle(), employee.getDateOfBirth(), employee.getGender());
    }

    public List<Employee> findAll() {
        return jdbcTemplate.query(SELECT_FROM_EMPLOYEE_TABLE, new EmployeeMapper());
    }

    public void delete(Long id) {
        jdbcTemplate.update(DELETE_EMPLOYEE, id);
    }

    public void update(Employee employee, Long id) {
        jdbcTemplate.update(UPDATE_EMPLOYEE, employee.getFirstname(), employee.getLastname(),
                employee.getDepartmentId(), employee.getJobTitle(), employee.getGender(), employee.getDateOfBirth(), id);
    }

    public Employee findById(long id) {
        return jdbcTemplate.queryForObject(SELECT_EMPLOYEE_BY_ID, new EmployeeMapper(), id);
    }
}
