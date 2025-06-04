import java.util.*;

public class Player {
    String name;
    int winnings;
    Map<String, Boolean> lifelines;
    
    public Player(String name) {
        this.name = name;
        this.winnings = 0;
        this.lifelines = new HashMap<>();
        lifelines.put("50-50", true);
        lifelines.put("Skip", true);
    }
    
    public boolean useLifeline(String lifeline) {
        if (lifelines.getOrDefault(lifeline, false)) {
            lifelines.put(lifeline, false);
            return true;
        }
        return false;
    }
}
