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

	public boolean checkChatBot(String animalkey)
	{
		String[] animalArray = {"hamster","guinea pig","rabbit"};
		for (String animal:animalArray)
		{
			if (findKeyword(animalkey,animal) != -1)
			{
				return true;
			}
			
		}
		return false;
		
	}
	int emotion = 0;
	public static String animal = "";
	/*
	 * Get a greeting
	 * @return: a greeting
	 */
	public String getGreeting()
	{
		return "Hello, I'm the bot responsible for small animals. Which include hamsters, guinea pigs and rabbits."; 
	}

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
		}
		if(findKeyword(statement, "rabbit") != -1)
		{
			animal = "rabbit";
		}
		if(animal == "hamster")
		{
			 if (findKeyword(statement, "how") != -1)
			{
				if(findKeyword(statement, "care")!= -1)
				{
					response = "you give the hamster attention and affection";
				}
				else if(findKeyword(statement, "feed")!= -1)
				{
					response = "give it a food bowl and poor a tablespoon of food into it";
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
					response = "when it stares at you ";
				}
				else if(findKeyword(statement, "sleeps")!= -1)
				{
					response = "during the day and awake at night";
				}
			}
			else
			{
				response = "go away";
			}
		
	}
		return response;
	
}
}