package com.seledtsova.dao.impl;


import com.seledtsova.entity.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getLong("employee_id"));
        employee.setFirstname(resultSet.getString("first_name"));
        employee.setLastname(resultSet.getString("last_name"));
        employee.setJobTitle(resultSet.getString("job_title"));
        employee.setDepartmentId(resultSet.getLong("department_id"));
        employee.setDateOfBirth(resultSet.getString("date_of_birth"));
        employee.setGender(resultSet.getString("gender"));
        return employee;
    }
}
