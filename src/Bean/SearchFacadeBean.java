package Bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

@Stateless(name = "SearchFacade")
public class SearchFacadeBean implements SearchFacade, SearchFacadeLocal{
    public SearchFacadeBean() {}


    public List wineSearch(String wineType) {
        List wineList = new List();
        if(wineList.equals("Red")) {
            wineList.add("Bordeaux");
            wineList.add("Merlot");
            wineList.add("Pinot Noir");
        } else if(wineType.equals("White")) {
            wineList.add("Chardonnay");
        }
        return wineList;
    }

    @PostConstruct
    public void initializeCountryWineList() {
        HashMap<String, String> countryMap = new HashMap<>();
        countryMap.put("Australia", "Sauvignon Blanc");
        countryMap.put("Australia", "Grenache");
        countryMap.put("France", "Gewurztraminer");
        countryMap.put("France", "Bordeaux");
    }


    @PreDestroy
    public void destroyWineList() {

    }
}
// 54