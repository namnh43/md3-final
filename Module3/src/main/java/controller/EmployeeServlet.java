package controller;

import dao.DAO;
import model.Employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EmployeeServlet", value = "/home")
public class EmployeeServlet extends HttpServlet {
    private DAO dao = null;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dao = new DAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createEmployee(request,response);
                break;
            case "edit":
                editEmployee(request,response);
                break;
            case "delete":
//                deleteUser(request,response);
                break;
            default:
                showAll(request,response);
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("employee/create.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        
    }

    private void showAll(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("list",dao.selectAll());
        try {
            request.getRequestDispatcher("employee/employee.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertEmployee(request,response);
                break;
            case "edit":
                editEmployee(request,response);
                break;
            case "delete":
//                deleteUser(request,response);
                break;
            default:
                showAll(request,response);
        }
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("address");
        String phonenum = request.getParameter("phonenum");
        long salary = Long.parseLong(request.getParameter("salary"));
//        String department = request.getHeader("department");
        String department = "RnD";
        Employee employee = new Employee(name,email,country,phonenum,salary,department);
        dao.insert(employee);
        try {
//            request.getRequestDispatcher("/home").forward(request,response);
            response.sendRedirect("/home");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
