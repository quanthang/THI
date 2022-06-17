package com.example.thilaiwcd.controller;

import com.example.thilaiwcd.entity.Employee;
import com.example.thilaiwcd.model.EmployeeModel;
import com.example.thilaiwcd.model.MySqlEmployeeModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListEmployeeServlet extends HttpServlet {
    private EmployeeModel employeeModel;
    @Override
    public void init() throws ServletException {
        employeeModel = new MySqlEmployeeModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employeeList = employeeModel.findAll();
        if(employeeList == null) {
            employeeList = new ArrayList<>();
        }
        req.setAttribute("employeelist", employeeList);
        req.getRequestDispatcher("/user/list.jsp").forward(req, resp);
    }
}
