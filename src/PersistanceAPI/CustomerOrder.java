package PersistanceAPI;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "CustomerOrder.findAll",
        query = "select o from CustomerOrder o")})
@Table(name = "CH03_CUSTOMER_ORDER")
@TableGenerator( name = "Custom_Order_ID_generator",
                table = "CUSTOM_ORDER_ID_GENERATOR",
                pkColumnName = "PRIMARY_KEY_NAME", pkColumnValue = "CustomerOrder.id",
                valueColumnName = "NEXT_ID_VALUE")
public class CustomerOrder implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE,
                    generator = "CustomerOrder_ID_Generator")
    private BigDecimal id;

    @Version
    private int version;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATION_DATE")
    private Date creationDate;
    private String status;
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getVersion() {
        return version;
    }

    public String getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
