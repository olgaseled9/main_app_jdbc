package com.seledtsova.servise.impl;

import com.seledtsova.converter.EmployeeServiceConverter;
import com.seledtsova.dao.EmployeeDao;
import com.seledtsova.dto.EmployeeDTO;
import com.seledtsova.entity.Employee;
import com.seledtsova.exception.ServiceException;
import com.seledtsova.servise.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private final EmployeeDao employeeDao;
    @Autowired
    private final EmployeeServiceConverter converter;

    @Override
    @Transactional
    public void addEmployee(EmployeeDTO employeeDTO) {
        employeeDao.add(converter.convertDTOtoEmployee(employeeDTO));
    }


    @Override
    @Transactional
    public EmployeeDTO findEmployeeById(Long id) {
        Employee employee = employeeDao.findById(id);
        if (Objects.nonNull(employee)) {
            return converter.convertEmployeeToDTO(employee);
        } else {
            throw new ServiceException(String.format("Employee is not found with id=", id));
        }
    }

    @Override
    @Transactional
    public List<EmployeeDTO> getEmployees() {
        List<Employee> employees = employeeDao.findAll();
        List<EmployeeDTO> employeesDTOS = new ArrayList<>();
        for (Employee employee : employees) {
            employeesDTOS.add(converter.convertEmployeeToDTO(employee));
        }
        return employeesDTOS;
    }

    @Override
    @Transactional
    public void removeEmployeeById(Long id) {
        Employee employee = employeeDao.findById(id);
        if (Objects.nonNull(employee)) {
            employeeDao.delete(id);
        } else {
            throw new ServiceException(String.format("Employee is not found with id=", id));
        }
    }

    @Override
    @Transactional
    public void updateEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeDao.findById(employeeDTO.getId());
        if (Objects.nonNull(employee)) {
            employee.setFirstname(employeeDTO.getFirstname());
            employee.setLastname(employeeDTO.getLastname());
            employee.setDepartmentId(employeeDTO.getDepartmentId());
            employee.setJobTitle(employeeDTO.getJobTitle());
            employee.setDateOfBirth(employee.getDateOfBirth());
            employee.setGender(employeeDTO.getGender());
        } else {
            throw new ServiceException(String.format("Employee was not found ", employeeDTO.getId()));
        }
    }

    @Override
    @Transactional
    public EmployeeDTO getById(Long id) {
        Employee employee = employeeDao.findById(id);
        if (Objects.nonNull(employee)) {
            return converter.convertEmployeeToDTO(employee);
        } else {
            throw new ServiceException(String.format("Employee was not found with id=", id));
        }
    }
}

