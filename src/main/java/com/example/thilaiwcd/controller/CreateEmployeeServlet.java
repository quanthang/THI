package com.example.thilaiwcd.controller;

import com.example.thilaiwcd.entity.Employee;
import com.example.thilaiwcd.model.EmployeeModel;
import com.example.thilaiwcd.model.MySqlEmployeeModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateEmployeeServlet extends HttpServlet {
    private EmployeeModel employeeModel;
    @Override
    public void init() throws ServletException {
        employeeModel = new MySqlEmployeeModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/user/worker.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");
            String fullName = req.getParameter("fullName");
            String birthday = req.getParameter("birthday");
            String address = req.getParameter("address");
            String position = req.getParameter("position");
            String department = req.getParameter("department");
            Employee employee = new Employee();
            employee.setFullName(fullName);
            employee.setBirthday(birthday);
            employee.setAddress(address);
            employee.setPosition(position);
            employee.setDepartment(department);
            if (employee.isValid()) {
                boolean result = employeeModel.save(employee);
                if (result) {
                    resp.sendRedirect("/list");
                } else {
                    try {
                        throw new Exception("Cant save employee");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            } else {
                req.setAttribute("employee", employee);
                req.setAttribute("errors", employee.getErrors());
                req.getRequestDispatcher("/user/worker.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}