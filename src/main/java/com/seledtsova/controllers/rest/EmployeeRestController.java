package com.seledtsova.controllers.rest;

import com.seledtsova.dto.EmployeeDTO;
import com.seledtsova.servise.EmployeeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Log4j2
@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<EmployeeDTO> getAllItems() {
        return employeeService.getEmployees();
    }

    @PostMapping("/employees")
    public ResponseEntity<Void> addNewEmployee(@RequestBody @Valid EmployeeDTO employeeDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            employeeService.addEmployee(employeeDTO);
            log.debug("Added employees with name {}", employeeDTO.getId());
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id) {
        employeeService.removeEmployeeById(id);
        log.info("Removed employee with id {}", id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id) {
        return employeeService.findEmployeeById(id);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Void> updateEmployeeById(@PathVariable Long id, @RequestBody EmployeeDTO employee) {
        Optional<EmployeeDTO> employeeDTOOptional = employeeService.getEmployees().stream()
                .filter(employeeDTO -> employeeDTO.getId().equals(id))
                .findFirst();
        if (employeeDTOOptional.isPresent()) {
            EmployeeDTO employeeDTO = employeeDTOOptional.get();
            employeeDTO.setFirstname(employee.getFirstname());
            employeeDTO.setLastname(employee.getLastname());
            employeeDTO.setDepartmentId(employee.getDepartmentId());
            employeeDTO.setJobTitle(employee.getJobTitle());
            employeeDTO.setGender(employee.getGender());
            employeeDTO.setDateOfBirth(employee.getDateOfBirth());
            employeeService.updateEmployee(employeeDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
