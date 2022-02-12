package com.seledtsova.servise;


import com.seledtsova.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> getEmployees();

    EmployeeDTO findEmployeeById(Long id);

    void addEmployee(EmployeeDTO employeeDTO);

    void removeEmployeeById(Long id);

    void updateEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getById(Long id);
}

