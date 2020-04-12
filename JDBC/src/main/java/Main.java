import dao.EmployerDao;
import entities.Employer;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static dbutils.Connection.H2;

public class Main {
    final static String DB_URL = "jdbc:h2:~/temp/hw";
    final static String USER = "sa";
    final static String PASSWORD = "";
    final static String CREATE_DEPARTMENT_SQL = "CREATE TABLE DEPARTMENT(" +
            "id INT AUTO_INCREMENT," +
            "name VARCHAR(250)," +
            "chiefId INT)";
    final static String CREATE_EMPLOYER_SQL = "CREATE TABLE EMPLOYER(" +
            "id INT AUTO_INCREMENT," +
            "fullname VARCHAR(250)," +
            "salary DECIMAL(20, 2)," +
            "departmentId INT)";

    public static void main(String[] args){
        createTables();
        var employerDao = new EmployerDao();
        var e1 = new Employer("Василий Пупкин", BigDecimal.valueOf(20000), 1L);
        var e2 = new Employer("Андрей Пупкин", BigDecimal.valueOf(25000), 1L);
        employerDao.create(e1);
        employerDao.create(e2);
        System.out.println(employerDao.getById(1L));
        System.out.println(employerDao.getById(2L));
    }

    private static void createTables() {
        try (var connection = H2.getDataSource().getConnection()) {
            dropSchema(connection);
            executeUpdate(connection, CREATE_EMPLOYER_SQL);
            executeUpdate(connection, CREATE_DEPARTMENT_SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void executeUpdate(Connection connection, String sql) throws SQLException {
        var query = connection.createStatement();
        query.executeUpdate(sql);
        System.out.println("statement execute OK");
        query.close();
    }

    private static void dropSchema(Connection connection){
        var dropEmployer = "drop table EMPLOYER";
        var dropDepartment = "drop table DEPARTMENT";
        try {
            executeUpdate(connection, dropEmployer);
            executeUpdate(connection, dropDepartment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
