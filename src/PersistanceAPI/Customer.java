package PersistanceAPI;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Customer")
@NamedQueries({
        @NamedQuery(name = "Customer.findAll",
                    query = "select o from Customer o"),
        @NamedQuery(name = "Customer.finsByEmail",
                    query = "select o from Customer o where o.email = :email"   )

})

@IdClass(CustomerPK.class)
@Table(name = "CUSTOMER")
@TableGenerator(name = "Customer_ID_Generator",
                    table = "CUSTOMER_ID_GENERATOR",
                    pkColumnName = "PRIMARY_KEY_NAME",
                    pkColumnValue = "Customer.id",
                    valueColumnName = "NEXT_ID_VALUE"

)
public class Customer implements Serializable { // good practice
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE,
                        generator = "Customer_ID_Generator")
    private BigDecimal id;
    @Version
    private int version;

    @Column(length = 4000)
    private String email;
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.ALL})
    private List<CustomerOrder> customerOrders;
    @OneToOne( cascade = {CascadeType.ALL})
    @JoinColumn(name = "BILLING_ADDRESS")
    private Address billingAddress;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "SHIPPING_ADDRESS")
    private Address shippingAddress;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private long customerId; // primary key or identifier

    public List<CustomerOrder> getCustomerOrders() {
        return customerOrders;
    }

    public void setCustomerOrders(List<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }

    public CustomerOrder addCustomerOrder(CustomerOrder customOrder) {
        if(customerOrders == null) {
            customerOrders = new ArrayList<CustomerOrder>();
        }
        customerOrders.add((CustomerOrder) customerOrders);
        customOrder.setCustomer(this);
        return customOrder;

    }

    public CustomerOrder removeCustomerOrder(CustomerOrder customerOrder) {
        getCustomerOrders().remove(customerOrder);
        customerOrder.setCustomer(null);
        return customerOrder;

    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Basic(fetch = FetchType.EAGER)
    @Column(name = "NAME", table = "CUSTOMER")
    private String name;

    public long getCustomerId() {return customerId;}
    public void setCustomerId(long customerId) {this.customerId = customerId;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}


// 138

}
