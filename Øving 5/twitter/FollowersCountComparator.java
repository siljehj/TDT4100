package oving5.twitter;

import java.util.Comparator;

public class FollowersCountComparator implements Comparator<TwitterAccount> {

    public FollowersCountComparator() {

    }

    public int compare(TwitterAccount t1, TwitterAccount t2) {
        return -Integer.valueOf(t1.getFollowerCount()).compareTo(Integer.valueOf(t2.getFollowerCount()));
    }
    
}
