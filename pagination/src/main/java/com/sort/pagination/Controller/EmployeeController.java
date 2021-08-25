package com.sort.pagination.Controller;

import com.sort.pagination.BaseResponse.APIResponse;
import com.sort.pagination.BaseResponse.BaseResponse;
import com.sort.pagination.DTO.EmployeeDTO;
import com.sort.pagination.Model.Employee;
import com.sort.pagination.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addemployee")
    public BaseResponse addetail(@RequestBody EmployeeDTO employeeDTO)
    {
        return employeeService.addetail(employeeDTO);
    }

    @GetMapping("/getall")
    private APIResponse<List<Employee>> findAllEmployee() {
        List<Employee> allemployee = employeeService.findAllEmployee();
        return new APIResponse<>(allemployee.size(),allemployee);
    }

   @GetMapping("/sort/{field}")
    private APIResponse<List<Employee>> findEmployeeWithSorting(@PathVariable String field) {
        List<Employee> allemployee = employeeService.findEmployeeWithSorting(field);
        return new APIResponse<>(allemployee.size(), allemployee);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    private APIResponse<Page<Employee>> findEmployeesWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<Employee> Pagination = employeeService.findEmployeesWithPagination(offset, pageSize);
        return new APIResponse<>(Pagination.getSize(), Pagination);
    }


}
