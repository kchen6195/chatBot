import java.util.Random;
/*
 * Chat Bot that will attend to a customer that wants a small animal.
 * @Author:  Kelvin Chen
 * 
 * 
 * ideas: everytime the person says the animal include a piece of information ie: likes a big cage, lives 3-4 years.
 * add field : animal name ++ when person says name
 * ifs: how then more if (keywords) -> "feed" "care" "hold" 
 *      when -> "feed"
 *      
 */
public class ChatBotChen {


	int emotion = 0;
	public static String animal = "";

	
	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no").
	 *
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @param startPos
	 *            the character of the string to begin the
	 *            search at
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal,
			int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.indexOf(goal, startPos);

		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0)
		{
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1);
			}

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1);

		}

		return -1;
	}
	
	/**
	 * Search for one word in phrase.  The search is not case sensitive.
	 * This method will check that the given goal is not a substring of a longer string
	 * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal)
	{
		return findKeyword (statement, goal, 0);
	}
	public String getResponse(String statement)
	{
			String response = "";
		
		if (statement.length() == 0)
		{
			response = "Hey, you there?";
		}
		if(findKeyword(statement, "hamster") != -1)
		{
			 animal = "hamster";
			 
		}
		if(findKeyword(statement, "guinea pig") != -1)
		{
			animal = "guinea pig";
			response = "hey ask away about your budget hamster questions!";
		}
		if(animal.equalsIgnoreCase("hamster"))
		{
			 if (findKeyword(statement, "how") != -1)
			{
				if(findKeyword(statement, "care")!= -1)
				{
					response = "you give the hamster attention and affection";
				}
				else if(findKeyword(statement, "feed")!= -1)
				{
					response = "give it a food bowl and pour a tablespoon of food into it";
				}
				else if(findKeyword(statement, "hold")!= -1)
				{
					response = "let it walk on your hand. Dont force it!";
				}
				else if(findKeyword(statement, "long")!= -1)
				{ // life span
					response = "they live for 2-3 years";
				}
			}
			else if (findKeyword(statement, "when") != -1)
			{
				if(findKeyword(statement, "feed")!= -1)
				{
					response = "once a day and when it stares at you ";
				}
				else if(findKeyword(statement, "sleep")!= -1)
				{
					response = "sleeps during the day and awake at night";
				}
			}
			else if (findKeyword(statement, "what") != -1)
			{
				if(findKeyword(statement, "food")!= -1)
				{
					response = "Hey we have 3 types of food at this store! \n"
							+ " First one is the treat mix (unhealthy for hamsters, If you pick this I will be mad!) for $5.00 \n" 
							+ " Second one is the tasty mix(not a bad pick) for $8.00 \n"
							+ " Third one is the healthy mix(expensive, but your hamster will love you, so will I.) for $12.50 ";
					
				}
				if(findKeyword(statement, "cage")!= -1)
				{
					response = "We have 3 cages at this store! \n"
							+ " First is the wired cage(bad for their health) for $40.00 \n "
							+ " Second is the bin cage (cheap and effective) for $30.00 \n"
							+ "Third is the tank cage(pricy but will make for a happy hamster and happy chatBotChen) for $50.00 ";
				}
			}
			else
			{
				
					response = "hey ask away about your hamster questions!";
				
				
			}
		
	}
		return response;
	
}
}