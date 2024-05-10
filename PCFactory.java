package a2_2101140058;

import java.util.HashSet;

public class PCFactory  {
    // Singleton instance
    private static PCFactory instance = null;
    
    private PCFactory() {
    	
    }
    
    public static synchronized PCFactory getInstance() {
        if (instance == null) {
            instance = new PCFactory();
        }
        return instance;
    }
    
    public PC createPC(String model, int year, String manufacturer, Set<String> comps) {
        return new PC(model, year, manufacturer, comps);
    }
    
}
