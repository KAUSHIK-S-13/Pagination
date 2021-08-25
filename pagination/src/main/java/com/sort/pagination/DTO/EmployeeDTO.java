package com.sort.pagination.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EmployeeDTO {
    private int empId;
    private String empName;
    private int empSalary;
    private String email;
}
