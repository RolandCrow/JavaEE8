package AdvancedPersistance;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name = "Address.findAll", query = "select o from Address o")
})
@Table(name = "CH04_ST_ADDRESS")
@TableGenerator(name = "Address_ID_Generator", table ="CH04_ST_ADDRESS_ID_GEN"
                , pkColumnName = "PRIMARY_KEY_NAME", pkColumnValue = "Address.id", valueColumnName ="NEXT_ID_VALUE" )
public class Address implements Serializable {


    @SuppressWarnings("compatibility: -5340972441524875330 ")
    private static final long serialVersionUID = -5279408726470732092L;
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Address_ID_Generator")
    private Integer id;
    @Column(length = 400)
    private String city;
    @Column(length = 2)
    private String state;
    @Column(length = 400)
    private String street1;
    @Column(length = 400)
    private String street2;
    @Version
    private Integer version;
    @Column(name = "ZIP_CODE")
    private String zipCode;

    public Address() {}

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
// 177