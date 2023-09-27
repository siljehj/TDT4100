package oving5.twitter;

import java.util.Comparator;

public class TwitterAccountComparator implements Comparator<TwitterAccount> {

    public TwitterAccountComparator() {
    }

    public int compare(TwitterAccount t1, TwitterAccount t2) {
        Comparator<TwitterAccount> c1 = new FollowersCountComparator();
        Comparator<TwitterAccount> c2 = new TweetsCountComparator();
        Comparator<TwitterAccount> c3 = new UserNameComparator();
        if (c1.compare(t1, t2) == 0) {
            if (c2.compare(t1, t2) == 0) {
                return c3.compare(t1, t2);
            }
            return c2.compare(t1, t2);
        }
        return c1.compare(t1, t2);

    }
    

}
