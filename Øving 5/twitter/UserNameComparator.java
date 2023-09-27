package oving5.twitter;

import java.util.Comparator;

public class UserNameComparator implements Comparator<TwitterAccount> {

    public UserNameComparator() {

    }

    public int compare(TwitterAccount t1, TwitterAccount t2) {
        return t1.getUserName().compareTo(t2.getUserName());
    }
    
}
