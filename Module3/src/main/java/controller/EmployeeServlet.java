package controller;

import dao.DAO;
import model.Employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

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
                showEditEmployee(request,response);
                break;
            case "delete":
                deleteEmployee(request,response);
                break;
            case "search":
                searchEmployee(request,response);
            default:
                showAll(request,response);
        }
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("search");
        List<Employee> list = dao.search(name);
        System.out.println(list);
        request.setAttribute("list",list);
        try {
            request.getRequestDispatcher("employee/employee.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showEditEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        //Get user from database
        Employee employee = dao.selectItem(id);
        request.setAttribute("employee",employee);
        try {
            request.getRequestDispatcher("/employee/edit.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
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
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phoneNum = request.getParameter("phonenum");
        Long salary = Long.valueOf(request.getParameter("salary"));
        String department = "RnD";
        Employee employee = new Employee(id,name,email,address,phoneNum,salary,department);
        dao.update(employee);
        try {
            response.sendRedirect("/home");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

            default:
                showAll(request,response);
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        dao.delete(id);
        try {
            response.sendRedirect("/home");
        } catch (IOException e) {
            throw new RuntimeException(e);
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
