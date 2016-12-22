package citiaps.twitter_api;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

public class RestAPI {

	public final static String OAUTH_CONSUMER_KEY = "";
	public final static String OAUTH_CONSUMER_SECRET = "";
	public final static String OAUTH_ACCESS_TOKEN = "";
	public final static String OAUTH_ACCESS_TOKEN_SECRET = "";

	public static void main(String[] args) {
		new RestAPI().doMain(args);
	}

	public void searchByWords(String terms) {

		Twitter twitter = TwitterFactory.getSingleton();
		Query query = new Query(terms);
		QueryResult result = null;
		try {
			result = twitter.search(query);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		for (Status status : result.getTweets()) {
			System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
		}

	}

	public void searchUserByScreenName(String username) {

		Twitter twitter = TwitterFactory.getSingleton();

		ResponseList<User> users;

		try {
			users = twitter.searchUsers(username, 0);
			for (User user : users) {
				if (user.getStatus() != null) {
					System.out.println("@" + user.getScreenName() + " - " + user.getStatus().getText());
				} else {
					// the user is protected
					System.out.println("@" + user.getScreenName());
				}
			}

		} catch (TwitterException e) {
			e.printStackTrace();
		}

	}

	public void searchFF(String username) {

		Twitter twitter = TwitterFactory.getSingleton();

		ResponseList<User> users;

		try {
			users = twitter.searchUsers(username, 0);
			for (User user : users) {
				if (user.getStatus() != null) {
					System.out.println("@" + user.getScreenName() + " - " + user.getStatus().getText());
				} else {
					// the user is protected
					System.out.println("@" + user.getScreenName());
				}
			}
		} catch (TwitterException e) {
			e.printStackTrace();
		}

	}

	public void doMain(String[] args) {

		searchUserByScreenName("Juan");

	}

}
