package PersistanceAPI;

import javax.persistence.EntityManager;
import java.awt.*;
import java.util.List;


public class CustomerOrderManager {
    private EntityManager em;

    public CustomerOrderManager() {

    }

    public <T> T persistEntity(T entity) {
        em.persist(entity);
        return entity;
    }

    public <T> T mergeEntity(T entity) {
        return em.merge(entity);
    }

    public void removeCustomer(Customer  customer) {
        customer = em.find(Customer.class, customer.getId());
        em.remove(customer);
    }

    public List<Address> getAddressFindAll() {
        return em.createNamedQuery("Address.findAll", Address.class).getResultList();
    }

    public void removeCustomerOrder(CustomerOrder customerOrder) {
        customerOrder = em.find(CustomerOrder.class, customerOrder.getId());
        em.remove(customerOrder);
    }

    public List<CustomerOrder> getCustomOrderFindAll() {
        return em
                .createNamedQuery("CustomerOrder.findByEmail", CustomerOrder.class)
                .setParameter("email", em)
                .getResultList();
    }





}
