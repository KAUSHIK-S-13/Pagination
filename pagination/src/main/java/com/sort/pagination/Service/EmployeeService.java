package com.sort.pagination.Service;

import com.sort.pagination.BaseResponse.BaseResponse;
import com.sort.pagination.DTO.EmployeeDTO;
import com.sort.pagination.Model.Employee;
import com.sort.pagination.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public BaseResponse addetail(EmployeeDTO employeeDTO)
    {
        Employee emp=new Employee();
        BaseResponse baseResponse=new BaseResponse();
        emp.setEmpName(employeeDTO.getEmpName());
        emp.setEmail(employeeDTO.getEmail());
        emp.setEmpSalary(employeeDTO.getEmpSalary());
        employeeRepository.save(emp);
        baseResponse.setData(emp);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("sucess");
        return  baseResponse;
    }

    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    public List<Employee> findEmployeeWithSorting(String field){
        return  employeeRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    public Page<Employee> findEmployeesWithPagination(int offset, int pageSize){
        Page<Employee> employees = employeeRepository.findAll(PageRequest.of(offset, pageSize));
        return  employees;
    }

}
