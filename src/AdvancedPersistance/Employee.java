package AdvancedPersistance;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name = "Employee.findAll",
                    query = "select o from Employee o")
})
@Table(name = "CH04_ST_EMPLOYEE")
public abstract class Employee implements Serializable {

    @SuppressWarnings("compatibility:276774077273820023")
    private static final long serialVersionUID = -8529011412038476148L;

    @Column(length = 400)
    private String department;

    @Column(length = 400)
    public String email;

    @ManyToOne
    @JoinColumn(name = "MANAGER")
    private FullTimeEmployee manager;

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public FullTimeEmployee getManager() {
        return manager;
    }

    public void setManager(FullTimeEmployee manager) {
        this.manager = manager;
    }
}
