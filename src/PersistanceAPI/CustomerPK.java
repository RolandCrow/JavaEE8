package PersistanceAPI;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

public class CustomerPK implements Serializable {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int hashCode() {return 0;}

    @Override
    public boolean equals(Object obj) {return false;}
}
