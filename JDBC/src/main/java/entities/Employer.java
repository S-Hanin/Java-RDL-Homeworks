package entities;

import java.math.BigDecimal;
import java.util.Objects;

public class Employer {
    private Long id;
    private String fullname;
    private BigDecimal salary;
    private Long departmentId;

    public Employer() {
    }

    public Employer(String fullname, BigDecimal salary, Long departmentId) {
        this.fullname = fullname;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employer employer = (Employer) o;
        return id.equals(employer.id) &&
                fullname.equals(employer.fullname) &&
                salary.equals(employer.salary) &&
                departmentId.equals(employer.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullname, salary, departmentId);
    }

    @Override
    public String toString() {
        return "Employer{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", salary=" + salary +
                ", departmentId=" + departmentId +
                '}';
    }
}
