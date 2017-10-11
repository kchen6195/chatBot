import java.util.Arrays;
import java.util.Scanner;

public class ChatBotBernard {
	int patience = 0;
	
	
	ChatBotChen chatbot2 = new ChatBotChen();
	ChatBotUsman chatbot3 = new ChatBotUsman();
	ChatBotYaroslavsky chatbot4 = new ChatBotYaroslavsky();
	Scanner in = new Scanner (System.in);
	public int findKeyword(String statement, String goal,
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
	/*
	 * Generates a random response when called.
	 */
	private String randomResponse()
	{
			patience--;
			if (patience==0)
			{
				String[] randomArray = {"Huh?","Can you rephrase that in reptilian for me?","Sorry I don't understand."
						,"Hmmm","Hmph"};
				int i = (int)Math.random()*(randomArray.length);
				return randomArray[i];
			}	
			else if (patience <= 0)
			{
				String[] randomImpatientArray = {"Hiss","Can you please use your words correctly to speak",">:(((","Your pushing my limit","You were here... Now your here!!","ok....."};
				int i = (int)Math.random()*(randomImpatientArray.length);
				return randomImpatientArray[i];
			}
			else 
			{
				String[] randomPatientArray = {"Hey can you please say that again.","Excuse me but I don't understand","Oh okay!Interesting","Yeah yeah totally"};
				int i = (int)Math.random()*(randomPatientArray.length);
				return randomPatientArray[i];
			}
	}
	/*
	 * This method returns a response to the statement of the previous line from the user.
	 * @param String statement
	 * @return a string for the chat bot to respond with.
	 */
	public String getResponse(String statement)
	{
		statement.toLowerCase();
		
		String[] animalArray = {"hamster","guinea pig","tortoise","frog","dog","cat","fish","seaweed"};
		int animalPosArray = -1;
		{
			for (String animal:animalArray)
			{
				if (findKeyword(statement, animal, 0)>=0)
				{					
					animalPosArray = Arrays.asList(animalArray).indexOf(animal);
				}	
			}
		}
		if (animalPosArray< 2 && animalPosArray>-1)
		{
			while (statement!="Bye")
			{
				System.out.println(chatbot2.getResponse(statement));
				statement = in.nextLine();
			}
		}
		
		else if (animalPosArray< 6 && animalPosArray>3)
		{
			while (statement!="Bye")
			{
				System.out.println(chatbot4.getResponse(statement));
				statement = in.nextLine();
			}
		}
		else if (animalPosArray< 8 && animalPosArray>5)
		{
			while (statement!="Bye")
			{
				System.out.println(chatbot3.getResponse(statement));
				statement = in.nextLine();
			}
		}
		else
		{
			
		}
		
		
		boolean animalInStatement = false;
		String animalName = "";
		int posOfAnimal = -1;
		for (String animal:animalArray)
		{
			if (findKeyword(statement, animal, 0) >= -1)
			{
				animalInStatement = false;
				posOfAnimal = findKeyword(statement, animal, 0);
				animalName = animal;
			}
		}
		if (statement.length()==0)
		{
			String[] emptyResponses = {"You're replying slower than a tortoise!!","I know snakes that type faster than you./nThey don't even have fingers...",
					"Please say something.","Hurry up and reply... I have other customers!"};
			int i = (int)Math.random()*(emptyResponses.length);
			String answerEmpty = emptyResponses[i];
			return answerEmpty;
		}
		else if (animalInStatement)
		{
			if (animalName.equals("tortoise"))
			{
				if (findKeyword(statement,"food",0)>=0)
				{
					return "Tortoises really like fruit.";
				}
				return "Oh I like tortoises too";
			}
			else if (animalName.equals("frog"))
			{
				return "I used to have frogs but they died";
			}
			return randomResponse();
		}
		else 
		{
			return randomResponse();
		}
		
	}
}
