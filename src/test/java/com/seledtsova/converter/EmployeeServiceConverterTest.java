package com.seledtsova.converter;

import com.seledtsova.dto.EmployeeDTO;
import com.seledtsova.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceConverterTest {

    @InjectMocks
    private EmployeeServiceConverter employeeServiceConverter;

    @Test
    void shouldConvertEmployeeToDTOAndReturnEmployeeFirstname() {
        Employee employee = new Employee();
        String firstname = "user";
        employee.setFirstname(firstname);
        EmployeeDTO employeeDTO = employeeServiceConverter.convertEmployeeToDTO(employee);
        Assertions.assertEquals(firstname, employeeDTO.getFirstname());
    }

    @Test
    void shouldConvertEmployeeToDTOAndReturnEmployeeLastname() {
        Employee employee = new Employee();
        String lastname = "lastname";
        employee.setLastname(lastname);
        EmployeeDTO employeeDTO = employeeServiceConverter.convertEmployeeToDTO(employee);
        Assertions.assertEquals(lastname, employeeDTO.getLastname());
    }

    @Test
    void shouldConvertEmployeeToDTOAndReturnEmployeeDepartmentId() {
        Employee employee = new Employee();
        long id = 2L;
        employee.setDepartmentId(id);
        EmployeeDTO employeeDTO = employeeServiceConverter.convertEmployeeToDTO(employee);
        Assertions.assertEquals(id, employeeDTO.getDepartmentId());
    }

}