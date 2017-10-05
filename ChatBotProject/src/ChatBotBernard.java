
public class ChatBotBernard {
	public boolean checkChatBot(String animalkey)
	{
	/*String[] animalArray = {"tortoise","snake","frog","turtle",""};
		for (String animal:animalArray)
		{
			if (animal.equals(animalkey))
			{
				return true;
			}
			
		}
		return false;
	*/
		String[] animalArray = {"tortoise","snake","frog","turtle",""};
		for (String animal:animalArray)
		{
			if (findKeyword(animalkey, animal, 0) != -1)
			{
				return true;
			}
		}
		return false;
	}
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
	public String getResponse(String statement)
	{
		
	}
}
