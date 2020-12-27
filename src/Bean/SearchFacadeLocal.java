package Bean;

import javax.ejb.Local;
import java.awt.*;

@Local
public interface SearchFacadeLocal {
    List wineSearch(String wineType);

}
