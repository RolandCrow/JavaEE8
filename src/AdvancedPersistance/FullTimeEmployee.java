package AdvancedPersistance;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "FullTimeEmployee.findAll",
                    query = "select o from FullTimeEmployee o")
})
@Table(name = "CH04_ST_FT_EMPLOYEE")
public class FullTimeEmployee extends Employee implements Serializable {
    @SuppressWarnings("compatibility:9058152191575937294")
    private static final long serialVersionUID = -301681120809804802L;
    @Column(name = "ANNUAL_SALARY")
    private double annualSalary;
    @OneToMany(mappedBy = "manager", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Employee> managedEmployees;
    public FullTimeEmployee() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public List<Employee> getManagedEmployees() {
        return managedEmployees;
    }

    public void setManagedEmployees(List<Employee> managedEmployees) {
        this.managedEmployees = managedEmployees;
    }
}
