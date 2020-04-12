package dao;

import dbutils.Connection;
import entities.Employer;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class EmployerDao {
    DataSource dataSource = Connection.H2.getDataSource();

    public boolean create(Employer employer) {
        try {
            var connection = dataSource.getConnection();
            var sql = "insert into EMPLOYER (FULLNAME, SALARY, DEPARTMENTID) values (?, ?, ?)";
            var query = connection.prepareStatement(sql);
            query.setString(1, employer.getFullname());
            query.setBigDecimal(2, employer.getSalary());
            query.setLong(3, employer.getDepartmentId());
            query.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Employer getById(Long id) {
        try {
            var connection = dataSource.getConnection();
            var sql = "select ID, FULLNAME, SALARY, DEPARTMENTID from EMPLOYER where ID=?";
            var query = connection.prepareStatement(sql);
            query.setLong(1, id);
            var rs = query.executeQuery();
            if (rs.next()) {
                var employer = new Employer();
                employer.setId(rs.getLong("ID"));
                employer.setFullname(rs.getString("FULLNAME"));
                employer.setSalary(rs.getBigDecimal("SALARY"));
                employer.setDepartmentId(rs.getLong("DEPARTMENTID"));
                return employer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Employer> getAll() {
        return null;
    }

    public List<Employer> getAllSortedByFullname() {
        return null;
    }

    public List<Employer> getAllSortedBySalary() {
        return null;
    }

    public List<Employer> getByFullname(String fullname) {
        return null;
    }

    public List<Employer> getByDepartmentId(Long id) {
        return null;
    }

    public boolean update(Employer employer) {
        return false;
    }

    public boolean remove(Employer employer) {
        return false;
    }
}
