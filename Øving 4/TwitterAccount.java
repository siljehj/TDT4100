package oving4;

import java.util.ArrayList;

public class TwitterAccount {
    
    private String userName;
    private ArrayList<TwitterAccount> followers = new ArrayList<>();
    private ArrayList<TwitterAccount> following = new ArrayList<>();
    private ArrayList<Tweet> myTweets = new ArrayList<>();
    private ArrayList<Tweet> myRetweets = new ArrayList<>();
    private ArrayList<Tweet> allTweets = new ArrayList<>();

    public TwitterAccount(String s) {
        this.userName = s;
    }

    public String getUserName() {
        return userName;
    }

    public void follow(TwitterAccount account) {
        if (this.userName == account.userName) {
            throw new IllegalArgumentException("You cannot follow yourself.");
        }
        this.following.add(account);
        account.followers.add(this);
    }

    public void unfollow(TwitterAccount account) {
        if (!this.isFollowing(account)) {
            throw new IllegalArgumentException("Cannot unfollow an account you don't follow");
        }
        this.following.remove(account);
        account.followers.remove(this);
    }

    public boolean isFollowing(TwitterAccount account) {
        if (this.following.contains(account)) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isFollowedBy(TwitterAccount account) {
        if (this.followers.contains(account)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void tweet(String s) {
        Tweet myTweet = new Tweet(this, s);
        this.myTweets.add(0, myTweet);
        this.allTweets.add(0, myTweet);
    }

    public void retweet(Tweet tweet) {
        Tweet myTweet = new Tweet(this, tweet);
        this.myRetweets.add(0, myTweet);
        this.allTweets.add(0, myTweet);
    }

    public Tweet getTweet(int i) {
        if (i > 0 && i <= this.getTweetCount()) {
            return allTweets.get(i - 1);
        }
        else {
            throw new IllegalArgumentException("Not enough tweets.");
        }
    }

    public int getTweetCount() {
        return allTweets.size();
    }

    public int getRetweetCount() {
        int count = 0;
        for (Tweet t : myTweets) {
            int x = t.getRetweetCount();
            count += x;
        }
        return count;
    }

    @Override
    public String toString() {
        System.out.println("Username: " + this.getUserName());
        System.out.println("--------------------");
        System.out.print("Followers: ");
        for (TwitterAccount o : this.followers) {
            System.out.print(o.getUserName() + "  ");
        }
        System.out.print("\nFollowing: ");
        for (TwitterAccount x : this.following) {
            System.out.print(x.getUserName() + "  ");
        }
        System.out.print("\nTweets: ");
        for (Tweet y : this.myTweets) {
            System.out.print(y.getText() + "  ");
        }
        System.out.print("\nRetweets: ");
        for (Tweet z : this.myRetweets) {
            System.out.print(z.getText() + "  ");
        }
        System.out.print("\nRetweet count: " + this.getRetweetCount());
        System.out.print("\n\n");
        return "";
    }

    public static void main(String[] args) {
        TwitterAccount silje = new TwitterAccount("siljehj");
        TwitterAccount elise = new TwitterAccount("elisef");
        TwitterAccount nora = new TwitterAccount("norab");
        TwitterAccount helene = new TwitterAccount("helenel");
        silje.follow(elise);
        helene.follow(elise);
        nora.follow(elise);
        System.out.println(silje);
        System.out.println(elise);
        silje.tweet("Hello");
        elise.retweet(silje.myTweets.get(0));
        System.out.println(silje.getTweet(1).getText() + "\n");
        helene.unfollow(elise);
        System.out.println(elise);
        System.out.println(silje);



    }

}
