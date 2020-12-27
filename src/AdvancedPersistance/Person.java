package AdvancedPersistance;

import PersistanceAPI.Address;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@NamedQueries({
        @NamedQuery(name = "Person.findAll",
                    query = "select o from Person o ")
})
@Table
@TableGenerator(name = "Person_ID_Generator", table = "CH04_ST_PERSON_ID_GEN"
                    , pkColumnName = "PRIMARY_KEY_NAME",
                        valueColumnName = "NEXT_ID_VALUE" )
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Person implements Serializable {
    @SuppressWarnings("compatibility:-7074714881275658754")
    private static final long serialVersionUID  = 5291172566067954515L;

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Person_ID_Generator")
    private Integer id;

    @Column(name = "FIRST_NAME", length = 400)
    private String firstName;

    @Column(name = "LAST_NAME", length = 400)
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "HOME_ADDRESS")
    private Address homeAddress;
    @Version
    private Integer version;
    public Person() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    // 166
}
