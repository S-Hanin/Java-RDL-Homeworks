import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (var connection = getConnection()) {
            System.out.println("1. Список сотрудников указанного подразделения с сортировкой по зарплате:");
            printDepartmentEmployersOrderBySalary(connection, 1L);
            System.out.println("--------------------------------------------");

            System.out.println("2. Список сотрудников указанного подразделения с сортировкой по ФИО:");
            printDepartmentEmployersOrderByFullname(connection, 2L);
            System.out.println("--------------------------------------------");

            System.out.println("3. Список сотрудников у который оклад больше, чем у заданного:");
            printEmployersGainedMoreThan(connection, BigDecimal.valueOf(20000L));
            System.out.println("--------------------------------------------");

            System.out.println("4. Если ввели ФИО рядового сотрудника - то вывести только его зарплату. \n" +
                    "   Если ввели начальника подразделения - вывести список всех его подчинённых с указанием зарплаты и сортировкой по ФИО");
            printEmployerSalaryOrDependants(connection, "Андрей Пупкин");
            printEmployerSalaryOrDependants(connection, "Елена Премудрая");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void printDepartmentEmployersOrderBySalary(Connection connection, Long departmentId) throws SQLException {
        var sql = "select ID, FULLNAME, SALARY, DEPARTMENTID from EMPLOYER where DEPARTMENTID=? order by SALARY";
        var query = connection.prepareStatement(sql);
        query.setLong(1, departmentId);
        executeQuery(query).forEach(System.out::println);
        query.close();
    }

    private static void printDepartmentEmployersOrderByFullname(Connection connection, Long departmentId) throws SQLException {
        var sql = "select ID, FULLNAME, SALARY, DEPARTMENTID from EMPLOYER where DEPARTMENTID=? order by FULLNAME";
        var query = connection.prepareStatement(sql);
        query.setLong(1, departmentId);
        executeQuery(query).forEach(System.out::println);
        query.close();
    }

    private static void printEmployersGainedMoreThan(Connection connection, BigDecimal salary) throws SQLException {
        var sql = "select ID, FULLNAME, SALARY, DEPARTMENTID from EMPLOYER where SALARY>?";
        var query = connection.prepareStatement(sql);
        query.setBigDecimal(1, salary);
        executeQuery(query).forEach(System.out::println);
        query.close();
    }

    private static void printEmployerSalaryOrDependants(Connection connection, String fullname) throws SQLException {
        var departmentId = getChiefDepartmentId(connection, fullname);
        if (departmentId != null) {
            printDepartmentEmployersOrderByFullname(connection, departmentId);
        } else {
            System.out.println(getEmployerSalary(connection, fullname));
        }
    }

    private static BigDecimal getEmployerSalary(Connection connection, String fullname) throws SQLException {
        var sql = "select SALARY from EMPLOYER where FULLNAME=?";
        var query = connection.prepareStatement(sql);
        query.setString(1, fullname);
        var rs = query.executeQuery();
//        Takes only first employer from result set
        if (rs.next()) {
            var result = rs.getBigDecimal("SALARY");
            rs.close();
            return result;
        }
        return null;
    }

    private static Long getChiefDepartmentId(Connection connection, String fullname) throws SQLException {
//        var sql = "select ID from DEPARTMENT where CHIEFID in " +
//                "(select ID from EMPLOYER where FULLNAME=?)";
        var sql = "select d.ID from DEPARTMENT d " +
                "inner join EMPLOYER e on d.CHIEFID = e.ID " +
                "WHERE e.FULLNAME = ?";
        var query = connection.prepareStatement(sql);
        query.setString(1, fullname);
        var rs = query.executeQuery();
        if (rs.next()) {
            var result = rs.getLong("ID");
            rs.close();
            return result;
        }
        return null;
    }

    private static List<String> executeQuery(PreparedStatement query) throws SQLException {
        var result = new ArrayList<String>();
        var rs = query.executeQuery();
        while (rs.next()) {
            var id = rs.getLong("ID");
            var fullname = rs.getString("FULLNAME");
            var salary = rs.getBigDecimal("SALARY");
            var departmentId = rs.getLong("DEPARTMENTID");
            result.add(String.format("id: %s, fullname: %s, salary: %s, department id: %s",
                    id, fullname, salary, departmentId));
        }
        rs.close();
        return result;
    }

    private static Connection getConnection() throws SQLException {
        final String URL = "jdbc:h2:./JDBC/data/hw;" +
                "INIT=RUNSCRIPT FROM './JDBC/data/create.sql'\\;" +
                "RUNSCRIPT FROM './JDBC/data/populate.sql'";
        final String USER = "sa";
        final String PASSWORD = "";
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
