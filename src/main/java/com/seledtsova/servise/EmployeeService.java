package com.seledtsova.servise;

import com.seledtsova.converter.EmployeeServiceConverter;
import com.seledtsova.dao.EmployeeDao;
import com.seledtsova.dto.EmployeeDTO;
import com.seledtsova.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeDao employeeDao;
    private final EmployeeServiceConverter converter;

    public EmployeeService(EmployeeDao employeeDao, EmployeeServiceConverter converter) {
        this.employeeDao = employeeDao;
        this.converter = converter;
    }

    @Transactional
    public void addEmployee(EmployeeDTO employeeDTO) {
        employeeDao.save(converter.convertDTOtoEmployee(employeeDTO));
    }

    @Transactional(readOnly = true)
    public EmployeeDTO findEmployeeById(Long id) {
        Optional<Employee> employee = employeeDao.findById(id);
        return converter.convertEmployeeToDTO(employee.get());
    }

    @Transactional(readOnly = true)
    public List<EmployeeDTO> getEmployees() {
        List<Employee> employees = employeeDao.findAll();
        List<EmployeeDTO> employeesDTOS = new ArrayList<>();
        for (Employee employee : employees) {
            employeesDTOS.add(converter.convertEmployeeToDTO(employee));
        }
        return employeesDTOS;
    }

    @Transactional
    public void removeEmployeeById(Long id) {
        Optional<Employee> employee = employeeDao.findById(id);
        employeeDao.delete(employee.get());
    }

    @Transactional
    public void updateEmployee(EmployeeDTO employeeDTO) {
        Optional<Employee> employee = employeeDao.findById(employeeDTO.getId());
        employee.get().setId(employeeDTO.getId());
        employee.get().setFirstname(employeeDTO.getFirstname());
        employee.get().setLastname(employeeDTO.getLastname());
        employee.get().setDepartmentId(employeeDTO.getDepartmentId());
        employee.get().setJobTitle(employeeDTO.getJobTitle());
        employee.get().setDateOfBirth(employeeDTO.getDateOfBirth());
        employee.get().setGender(employeeDTO.getGender());
        employeeDao.save(employee.get());

    }
}