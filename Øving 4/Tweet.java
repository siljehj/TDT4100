package oving4;

public class Tweet {

    private TwitterAccount account;
    private TwitterAccount originalAccount;
    private String text;
    private int count = 0;
    private Tweet originalTweet;

    public Tweet(TwitterAccount account, String s) {
        this.account = account;
        this.text = s;
    }

    public Tweet(TwitterAccount account, Tweet retweetedTweet) {
        this.account = account;
        this.text = retweetedTweet.text;
        if (retweetedTweet.originalAccount == null) {
            if (retweetedTweet.account == this.account) {
                throw new IllegalArgumentException("Cannot retweet own tweet.");}
            this.originalTweet = retweetedTweet;
            this.originalAccount = retweetedTweet.account;
            
        } else {
            if (retweetedTweet.originalAccount == this.account) {
                throw new IllegalArgumentException("Cannot retweet own tweet.");}
            this.originalTweet = retweetedTweet.originalTweet;
            this.originalAccount = retweetedTweet.originalAccount;
        }
        originalTweet.count += 1;

    }

    

    public String getText() {
        return text;
    }

    public TwitterAccount getOwner() {
            return account;
    }

    public Tweet getOriginalTweet() {
        if (originalTweet != null) {
            return originalTweet;
        } else {
            return null;
        }

    }

    public int getRetweetCount() {
        return count;
    }

    @Override
    public String toString() {
        if (this.originalAccount != null) {
            return "Retweet from " + account.getUserName() + ". '" + text + "'. Original account: "
                    + originalAccount.getUserName() + ". Retweet count: " + originalTweet.count;
        } else {
            return "Original tweet from " + account.getUserName() + ". '" + text + "''.";
        }
    }

    public static void main(String[] args) {
        TwitterAccount silje = new TwitterAccount("siljehj");
        TwitterAccount elise = new TwitterAccount("eliseflovikholm");
        TwitterAccount nora = new TwitterAccount("noraborgenvik");
        TwitterAccount helene = new TwitterAccount("helenelyslo");
        Tweet t1 = new Tweet(silje, "Hello");
        Tweet t2 = new Tweet(elise, "Jeg hører på pils for helvete!!!");
        Tweet t3 = new Tweet(nora, t2);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        Tweet t4 = new Tweet(silje, t2);
        System.out.println(t4);
        Tweet t5 = new Tweet(helene, t3);
        System.out.println(t5);
        Tweet t6 = new Tweet(nora, t5);
        System.out.println(t6);
        //Tweet t7 = new Tweet(elise, t2);
        //System.out.println(t7);

    }

}
