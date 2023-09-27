package oving5.twitter;

import java.util.Comparator;

public class TweetsCountComparator implements Comparator<TwitterAccount> {
    
    public TweetsCountComparator() {

    }
   
    public int compare(TwitterAccount t1, TwitterAccount t2) {
        return -Integer.valueOf(t1.getTweetCount()).compareTo(Integer.valueOf(t2.getTweetCount()));
    }

}
