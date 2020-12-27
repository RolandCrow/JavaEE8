package AdvancedPersistance;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@NamedQueries({
        @NamedQuery(name = "PartTimeEmployee.findAll",
                query = "select o from PartTimeEmployee o")
})
@Table(name = "CH04_ST_PT_EMPLOYEE")
public class PartTimeEmployee extends Employee implements Serializable {
    @SuppressWarnings("compatibility:4882346458268010846")
    private static final long serialVersionUID = 417999239159878209L;
    @Column(name = "HOURLY_WAGE")
    private double hourlyWage;

    public PartTimeEmployee() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }
}
// 169