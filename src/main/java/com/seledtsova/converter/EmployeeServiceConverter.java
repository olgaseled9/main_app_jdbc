package com.seledtsova.converter;

import com.seledtsova.dto.EmployeeDTO;
import com.seledtsova.entity.Employee;

public interface EmployeeServiceConverter {

    EmployeeDTO convertEmployeeToDTO(Employee employee);

    Employee convertDTOtoEmployee(EmployeeDTO employeeDTO);
}
