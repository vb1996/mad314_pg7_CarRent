package com.example.vehicle;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDataSource {

    private static EmployeeDataSource instance = null;
    List<EmployeeData> employees;

    private EmployeeDataSource() {
        employees = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            EmployeeData employee = new EmployeeData();
            // Put random values, but id must be unique
            employee.id = i;
            employee.firstName = "employee ";
            employee.lastName = "#" + i;
            employee.userName = "employee " + i;
            employee.password = "a" + i;
            employee.contact=51460245;

            employees.add(employee);
        }
    }

    static EmployeeDataSource getInstance() {
        if (instance == null) {
            instance = new EmployeeDataSource();
        }
        return instance;
    }
}
