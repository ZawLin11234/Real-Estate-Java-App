package application.Controller;

import application.Entity.ReviewEntity;

public class RateAgentController {

	public static boolean rateAgent (int star, String review, String username1, String profile1, String username2, String profile2) {
		ReviewEntity a = new ReviewEntity();
		boolean result =a.createReview(star, review, username1, profile1, username2, profile2);
		return result;
	}
	
	
}
