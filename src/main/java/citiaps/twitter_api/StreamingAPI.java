package citiaps.twitter_api;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

public class StreamingAPI 
{
	public final static String OAUTH_CONSUMER_KEY = "";
    public final static String OAUTH_CONSUMER_SECRET = "";
    public final static String OAUTH_ACCESS_TOKEN = "";
    public final static String OAUTH_ACCESS_TOKEN_SECRET = "";
	
    public static void main(String[] args) {
    	new StreamingAPI().doMain(args);      
    }
    
    public void doMain(String[] args){
    	ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true);
    	cb.setOAuthConsumerKey(OAUTH_CONSUMER_KEY);
    	cb.setOAuthConsumerSecret(OAUTH_CONSUMER_SECRET);
    	cb.setOAuthAccessToken(OAUTH_ACCESS_TOKEN);
    	cb.setOAuthAccessTokenSecret(OAUTH_ACCESS_TOKEN_SECRET);
    	

    	TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
    	StatusListener listener = new StatusListener() {  		

	        public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
	            System.out.println("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
	        }

	        public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
	            System.out.println("Got track limitation notice:" + numberOfLimitedStatuses);
	        }

	        public void onScrubGeo(long userId, long upToStatusId) {
	            System.out.println("Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId);
	        }

	        public void onException(Exception ex) {
	            ex.printStackTrace();
	        }

			public void onStatus(Status status) {
				System.out.println(status.getText());
				
			}

			public void onStallWarning(StallWarning arg0) {
				// TODO Auto-generated method stub
				
			}
	    };

	    FilterQuery fq = new FilterQuery();
	    String keywords[] = {"Chile", "Santiago", "Región Metropolitana", "Intendencia"};

	    fq.track(keywords);

	    twitterStream.addListener(listener);
	    twitterStream.filter(fq);      
    	
    }



}
