import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ChatBotUsman {
	int emotion = 0;
	
	
	
	Scanner in = new Scanner (System.in);
	
	boolean convoFish = false;
	
	public String getGreeting()
	{
		return "Hi I'm a Fish Bot, so if you have any questions concerning the fish we are selling in our store, ASK AWAY!!!";
	}
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
	private String getRandomResponse () {
		Random r = new Random();
		if (emotion == 0) {	
			return randomNeutralResponses[r.nextInt(randomNeutralResponses.length)];
		}
		if (emotion < 0) {	
			return randomAngryResponses[r.nextInt(randomAngryResponses.length)];
		}	
		return randomHappyResponses[r.nextInt(randomHappyResponses.length)];
	}
	
	private String[] randomNeutralResponses = {"Interesting, tell me more", "Hmmm.", "Do you really think so?", "You don't say.", 
			"Cool! By the way, type in 'fun facts' to hear some.", "So, would you like to go for a walk?", "Could you say that again?"};
	
	private String[] randomAngryResponses = {"Grrr!", "I'm drowning in my anger!", "I'm so mad!", "D:<"};
	
	private String[] randomHappyResponses = {"SPLASH!", "Today is a good day", "FISH ARE GREAT!", "You make me happy", ":D"};
	
	private String[] funFacts = {"Most fish reproduce by laying eggs, though some fish, such as great white sharks, give birth to live babies called pups",
			"TSome fish, such as the great white shark, can raise their body temperature. This helps them hunt for prey in cold water.", 
			"The oldest known age for a fish was an Australian lungfish. In 2003, it was still alive and well at 65 years old", 
			"Starfish are not fish. Neither are jellyfish.", 
			"Since a fish’s jaw is not attached to its skull, many fishes can shoot their mouths forward like a spring to catch startled prey", 
			"An estimated one third of male fish in British waters are changing sex due to pollution in human sewage",
			"Most fish have taste buds all over their body"};
	
	/*
	 * This method returns a response to the statement of the previous line from the user.
	 * @param String statement
	 * @return a string for the chat bot to respond with.
	 */
	public String getResponse(String statement)
	{
		String response ="";
		statement.toLowerCase();
		ChatBotChen chatbot2 = new ChatBotChen();
		ChatBotBernard chatbot1 = new ChatBotBernard();
		ChatBotYaroslavsky chatbot4 = new ChatBotYaroslavsky();
		
		String[] animalArray = {"hamster","guinea pig","tortoise","frog","tarantula","snake","dog","cat","fish","seaweed"};
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
		else if  (animalPosArray> 2 && animalPosArray<5)
		{
			while (statement!="Bye")
			{
				System.out.println(chatbot2.getResponse(statement));
				statement = in.nextLine();
			}
		}
		
		else if (animalPosArray< 8 && animalPosArray>5)
		{
			while (statement!="Bye")
			{
				System.out.println(chatbot4.getResponse(statement));
				statement = in.nextLine();
			}
		}
		
		
		
		
		
		if (statement.length()==0)
		{
			String[] emptyResponses = {"Waiting for a response","Are you there?",
					"Please say something.","If you are not going to say anything, get OUT!!!"};
			int i = (int)Math.random()*(emptyResponses.length);
			String answerEmpty = emptyResponses[i];
			return answerEmpty;
		}
		else if (findKeyword(statement, "fish", 0) >= 0 && statement.length() == 4)
		{
			response = "Great!";
			convoFish = true;
		}
		else if (convoFish)
		{
			if (findKeyword(statement, "what", 0)>=0)
			{
				if ((findKeyword(statement, "food", 0)>=0)||(findKeyword(statement, "eat", 0)>=0))
				{
					return "The pet fish are given food in the form of flakes, granules and pellets. Vegetable matter, raw potatoes, bits of beans, peas, zucchini, etc. are fed to the pet fish. Sponges and spirulina algae are some of the foods that are given to the fish in the frozen form.";
				}
				else if (findKeyword(statement, "habitat", 0)>=0 || findKeyword(statement, "live", 0)>=0)
				{
					return "Size and Species of your fish. Naturally, the larger the fish, the larger the tank they will need. "
							+ "Remember, though, you shouldn’t force your fish into a habitat that doesn’t suit him because you can’t afford the tank or don’t have the room."
							+ " Determine the maximum size of the tank you can have before researching what fish and how many will fit in it.";
							
				}
				else if (findKeyword(statement, "breeds", 0)>=0)
				{
					return "The different fish we have are Guppies, Neon Tetra, Swordtail, Angelfish, Cory Catfish, Black-Skirt Tetra, Harlequin Rasbora and more which can viewed on this http://www.leisurepro.com/blog/explore-the-blue/10-popular-tropical-fish-aquariums/"; 
							
							
				}
				else
				{
					return "What, what? You can ask about what food they eat or what habitat though.\nYou can use this article to help answer your question! https://www.hartz.com/choosing-the-right-aquarium-tank/";
				}
			}
			else if (findKeyword(statement, "how", 0)>=0||(findKeyword(statement, "I want", 0)>=0))
			{
				if ((findKeyword(statement, "live", 0)>=0)||(findKeyword(statement, "years", 0)>=0))
				{
					return "Depending on living conditions and health issues, fish can live a decently long time time. FUN FACT: The longest pet fish lived for 43 years.";
				}
				else if ((findKeyword(statement, "buy", 0)>=0)||(findKeyword(statement, "get", 0)>=0))
				{
					return "We actually have the most popular ones that you can look at in our store!";
				}
				else 
				{
					return "How, what? You can ask how long do they live or how to get one.\nYou can use this article to help answer your question! http://www.vetstreet.com/our-pet-experts/tempted-to-get-a-pet-turtle-or-tortoise-read-this-first";
				}
				
			}
			//else if (findKeyword(statement, "breeds", 0)>=0)
			//{
			//	return "The different fish we have are Guppies, Neon Tetra, Swordtail, Angelfish, Cory Catfish, Black-Skirt Tetra, Harlequin Rasbora and more which can viewed on this http://www.leisurepro.com/blog/explore-the-blue/10-popular-tropical-fish-aquariums/"; 
						
						
			//}
		}
		
		return response;
	}
}
		
		
	
	



