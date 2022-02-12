package com.seledtsova.dao.impl;

import com.seledtsova.dao.EmployeeDao;
import com.seledtsova.entity.Employee;
import com.seledtsova.exception.DaoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.List;

public class test {

//    public class EmployeeDaoImpl implements EmployeeDao {
//
//        private static final Logger logger = LoggerFactory.getLogger(com.seledtsova.dao.impl.EmployeeDaoImpl.class);
//        private static final String SELECT_FROM_EMPLOYEE_TABLE =
//                "SELECT employee_id , first_name, last_name, department_id, job_title, gender, date_of_birth FROM employee";
//
//        private static final String DELETE_EMPLOYEE = "DELETE FROM employee WHERE employee_id =:employee_id";
//
//        private static final String SELECT_EMPLOYEE_BY_ID =
//                "SELECT employee_id , first_name, last_name, department_id, job_title, gender, date_of_birth FROM employee WHERE employee_id=?";
//        private static final String UPDATE_EMPLOYEE =
//                "UPDATE employee SET first_name=:first_name, last_name=:last_name, department_id=:department_id, job_title=:job_title, gender=:gender, date_of_birth=:date_of_birth WHERE employee_id=?";
//
//        private static final String ADD_NEW_EMPLOYEE =
//                "INSERT INTO employee (first_name, last_name, department_id, job_title, date_of_birth, gender) VALUES (?,?,?,?,?,?)";
//
//
//        private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//        private MapSqlParameterSource mapSqlParameterSource;
//
//        @Autowired
//        public EmployeeDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
//            this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
//        }
//
//        @Override
//        public void add(Employee employee) {
//
//        }
//
//        @Override
//        public List<Employee> findAll() {
//            try {
//                return namedParameterJdbcTemplate.query(SELECT_FROM_EMPLOYEE_TABLE, new BeanPropertyRowMapper<>(Employee.class));
//            } catch (DaoException e) {
//                logger.error("Get all employees is not available" + e.getMessage(), e);
//            }
//            return null;
//        }
//
//        @Override
//        public void delete(Long id) {
//            SqlParameterSource namedParameters = new MapSqlParameterSource("employee_id", id);
//            try {
//                namedParameterJdbcTemplate.update(DELETE_EMPLOYEE, namedParameters);
//                logger.info("A employee was removed successful" + id);
//            } catch (Exception e) {
//                logger.error("No employee found with ID " + id + e.getMessage(), e);
//            }
//        }
//
//        @Override
//        public void update(Long id, Employee employee) {
//            mapSqlParameterSource.addValue("employee_id", id);
//            mapSqlParameterSource.addValue("first_name", employee.getFirstname());
//            mapSqlParameterSource.addValue("last_name", employee.getLastname());
//            mapSqlParameterSource.addValue("department_id", employee.getDepartmentId());
//            mapSqlParameterSource.addValue("gender", employee.getGender());
//            mapSqlParameterSource.addValue("job_title", employee.getJobTitle());
//            mapSqlParameterSource.addValue("date_of_birth", employee.getDateOfBirth());
//
//            try {
//                namedParameterJdbcTemplate.update(UPDATE_EMPLOYEE, mapSqlParameterSource);
//            } catch (Exception e) {
//                logger.error("Update employee is not available" + e.getMessage(), e);
//                ;
//            }
//        }
//
//        @Override
//        public Employee findById(long id) {
//            return null;
//        }
//
//    }
}
