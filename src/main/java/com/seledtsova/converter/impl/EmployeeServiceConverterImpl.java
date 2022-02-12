package com.seledtsova.converter.impl;

import com.seledtsova.converter.EmployeeServiceConverter;
import com.seledtsova.dto.EmployeeDTO;
import com.seledtsova.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeServiceConverterImpl implements EmployeeServiceConverter {

    @Override
    public EmployeeDTO convertEmployeeToDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setFirstname(employee.getFirstname());
        employeeDTO.setLastname(employee.getLastname());
        employeeDTO.setDepartmentId(employee.getDepartmentId());
        employeeDTO.setJobTitle(employee.getJobTitle());
        employeeDTO.setDateOfBirth(employee.getDateOfBirth());
        employeeDTO.setGender(employee.getGender());
        return employeeDTO;
    }

    @Override
    public Employee convertDTOtoEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setFirstname(employeeDTO.getFirstname());
        employee.setLastname(employeeDTO.getLastname());
        employee.setJobTitle(employeeDTO.getJobTitle());
        employee.setDepartmentId(employeeDTO.getDepartmentId());
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
        employee.setGender(employeeDTO.getGender());
        return employee;
    }
}
