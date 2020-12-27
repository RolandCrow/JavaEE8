package Bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import java.util.ArrayList;

@Local({ShoppingCartLocal.class})
@Remote({ShoppingCart.class})
@Stateful(name = "ShoppingCart")
public class ShoppingCartBean implements ShoppingCart, ShoppingCartLocal  {
    public ShoppingCartBean() {

    }

    public ArrayList cartItems;
    public void addWineItem(String wine) {
        cartItems.add(wine);
    }

    public void removeWineItem(String wine) {
        cartItems.remove(wine);
    }

    public void setCartItems(ArrayList cartItems) {
        this.cartItems = cartItems;
    }

    public ArrayList getCartItems() {
        return cartItems;

    }

    @PostConstruct
    public void initialize() {
        cartItems = new ArrayList();
    }

    @PreDestroy
    public void exit() {
        System.out.println("Saved items into the database");
    }

    @Remove
    public void stopSession() {
        System.out.println("From stopSession with @Remove annotation");
    }


}
