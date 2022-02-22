package com.seledtsova.servise;

import com.seledtsova.converter.EmployeeServiceConverter;
import com.seledtsova.dao.EmployeeDao;
import com.seledtsova.dto.EmployeeDTO;
import com.seledtsova.entity.Employee;
import com.seledtsova.exception.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
        employeeDao.add(converter.convertDTOtoEmployee(employeeDTO));
    }

    @Transactional (readOnly = true)
    public EmployeeDTO findEmployeeById(Long id) {
        Employee employee = employeeDao.findById(id);
        if (employee != null) {
            return converter.convertEmployeeToDTO(employee);
        } else {
            throw new ServiceException("Employee is not found");
        }
    }

    @Transactional (readOnly = true)
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
        Employee employee = employeeDao.findById(id);
        if (employee != null) {
            employeeDao.delete(id);
        } else {
            throw new ServiceException("Employee is not found");
        }
    }

    @Transactional
    public void updateEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeDao.findById(employeeDTO.getId());
        if (employee != null) {
            employee.setId(employee.getId());
            employee.setFirstname(employeeDTO.getFirstname());
            employee.setLastname(employeeDTO.getLastname());
            employee.setDepartmentId(employeeDTO.getDepartmentId());
            employee.setJobTitle(employeeDTO.getJobTitle());
            employee.setDateOfBirth(employeeDTO.getDateOfBirth());
            employee.setGender(employeeDTO.getGender());
            employeeDao.update(employee, employee.getId());
        } else {
            throw new ServiceException("Employee was not update");
        }
    }
}