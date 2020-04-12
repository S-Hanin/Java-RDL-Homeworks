package entities;

import java.util.Objects;

public class Department {
    private Long id;
    private String name;
    private Long chiefId;

    public Department(String name, Long chiefId) {
        this.name = name;
        this.chiefId = chiefId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getChiefId() {
        return chiefId;
    }

    public void setChiefId(Long chiefId) {
        this.chiefId = chiefId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                chiefId.equals(that.chiefId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, chiefId);
    }
}
