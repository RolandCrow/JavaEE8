package Bean.Singleton;

import javax.ejb.DependsOn;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timer;
import java.util.logging.Logger;

@Singleton
@Startup
@DependsOn("ShopperCount")
public class LogShopperCount {
    private final Logger log = Logger.getLogger("LogShopperCount.class");

    @Schedule(hour = "*/2")
    public void logShopperCount(Timer timer) {
        String timerInfo  = (String) timer.getInfo();
        System.out.println(timerInfo);
    }



}
