package dao;

import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO implements IDAO<Employee> {
    private final String jdbcURL="jdbc:mysql://localhost:3306/quanlynhanvien?useSSL=false";
    private final String jdbcUser="root";
    private final String jdbcPassword="admin";
    //jdbc sql command
    private static String SELECT_ALL_EMPLOYEE_SQL="select nhanvien.id,nhanvien.name,email,address,phonenum,salary,d.name as department from nhanvien join department d on d.id = nhanvien.department_id;";
    private static String SELECT_DEPARTMENT_SQL = "SELECT name FROM department where id=?";
    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO nhanvien (name,email,address,phonenum,salary,department_id) VALUES (?,?,?,?,?,?);";
    private static String SELECT_EMPLOYEE_SQL="SELECT * FROM users WHERE id = ?";
    private static String DELETE_USER_SQL="DELETE FROM users where id=?";
    private static String UPDATE_EMPLOYEE_SQL="UPDATE nhanvien SET name=?,email=?,address=?,phonenum=?,salary=?,department_id=? where id=?";
//            "UPDATE nhanvien SET name=?,email=?,country=? where id=?";
    Connection connection = null;

    public DAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUser,jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(Employee element) {
        if (connection != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
                preparedStatement.setString(1,element.getName());
                preparedStatement.setString(2,element.getEmail());
                preparedStatement.setString(3,element.getAddress());
                preparedStatement.setString(4,element.getPhoneNum());
                preparedStatement.setLong(5,element.getSalary());
                preparedStatement.setInt(6,1);

                System.out.println(preparedStatement);
                int row = preparedStatement.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Employee selectItem(int id) {
//        System.out.println(SELECT_EMPLOYEE_SQL);
        Employee user = null;
        if (connection != null) {
            System.out.println(connection);
            try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_SQL)) {
                preparedStatement.setInt(1,id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int uid = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("address");
                    String phoneNum = resultSet.getString("phonenum");
                    long salary = Long.parseLong(resultSet.getString("salary"));
                    String department = String.valueOf(resultSet.getInt("department_id"));
                    user = new Employee(uid,name,email,country,phoneNum,salary,department);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
//                printSQLException(e);
            }
        }
        return user;
    }

    @Override
    public List<Employee> selectAll() {
        List<Employee> employees = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE_SQL)) {
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery(SELECT_ALL_EMPLOYEE_SQL);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phoneNum = resultSet.getString("phonenum");
                long salary = resultSet.getLong("salary");
                String department = resultSet.getString("department");

                employees.add(new Employee(id,name,email,address,phoneNum,salary,department));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } ;
        return employees;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(Employee element) {
        if (connection != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL)) {
                preparedStatement.setString(1,element.getName());
                preparedStatement.setString(2,element.getEmail());
                preparedStatement.setString(3,element.getAddress());
                preparedStatement.setString(4,element.getPhoneNum());
                preparedStatement.setLong(5,element.getSalary());
                preparedStatement.setInt(6,1);

                preparedStatement.setInt(7,element.getId());
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } ;

        }
        return false;
    }
}
