package oving4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StopWatchManager {

    private Map<String, StopWatch> myMap = new HashMap<>();

    public StopWatchManager() {

    }

    public StopWatch newStopWatch(String name) {
        if (myMap.containsKey(name)) {
            throw new IllegalArgumentException(name + " already has a clock.");
        }
        StopWatch myWatch = new StopWatch();
        myMap.put(name, myWatch);
        return myWatch;
    }

    public void removeStopWatch(String name) {
        if (myMap.containsKey(name)) {
            myMap.remove(name);
        } else {
            throw new IllegalArgumentException("No clocks on this name.");
        }
    }

    public void tick(int ticks) {
        for (Map.Entry<String, StopWatch> entry : myMap.entrySet()) {
            entry.getValue().tick(ticks);
        }
    }

    public StopWatch getStopWatch(String name) {
        if (!myMap.containsKey(name)) {
            return null;
        }
        // skulle visst ikke ha exception
        /*if (!myMap.containsKey(name)) {
            throw new IllegalArgumentException("No clocks on this name.");
        }*/
        return myMap.get(name);
    }

    public Collection<StopWatch> getAllWatches() {
        Collection<StopWatch> myC = new ArrayList<>();
        for (StopWatch c : myMap.values()) {
            myC.add(c);
        }
        return myC;
    }

    public Collection<StopWatch> getStartedWatches() {
        Collection<StopWatch> myC = new ArrayList<>();
        for (StopWatch c : myMap.values()) {
            if (c.isStarted()) {
            myC.add(c);}
        }
        return myC;
    }

    public Collection<StopWatch> getStoppedWatches() {
        Collection<StopWatch> myC = new ArrayList<>();
        for (StopWatch c : myMap.values()) {
            if (c.isStopped()) {
            myC.add(c);}
        }
        return myC;
    }

    @Override
    public String toString() {
        /*
         * for (StopWatch c : myMap.values()) {
         * System.out.println(c);
         * }
         */

        for (Map.Entry<String, StopWatch> entry : myMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        return "";
        // return "" + myMap;
    }

    public static void main(String[] args) {
        StopWatchManager n = new StopWatchManager();
        n.newStopWatch("klokke");
        n.newStopWatch("hihi");
        System.out.println(n);
    }

}
