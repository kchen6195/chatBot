import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ChatBotBernard {
	int patience = 0;
	
	
	ChatBotChen chatbot2 = new ChatBotChen();
	ChatBotUsman chatbot3 = new ChatBotUsman();
	ChatBotYaroslavsky chatbot4 = new ChatBotYaroslavsky();
	Scanner in = new Scanner (System.in);
	
	boolean convoTortoise = false;
	boolean convoFrog = false;
	boolean convoTarantula = false;
	boolean convoSnake = false;
	public String getGreeting()
	{
		return "Hi I am the expert on reptiles such as the tortoise, the tarantulas, frogs and snakes.";
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
	private String randomResponse()
	{
			patience--;
			if (patience==0)
			{
				String[] randomArray = {"Huh?","Can you rephrase that in reptilian for me?","Sorry I don't understand."
						,"Hmmm","Hmph"};
				Random rand = new Random();
				int i = rand.nextInt(4)+0;
				return randomArray[i];
			}	
			else if (patience <= 0)
			{
				String[] randomImpatientArray = {"Hiss","Can you please use your words correctly to speak",">:(((","Your pushing my limit","You were here... Now your here!!","ok....."};
				Random rand = new Random();
				int i = rand.nextInt(5)+0;
				return randomImpatientArray[i];
			}
			else 
			{
				String[] randomPatientArray = {"Hey can you please say that again.","Excuse me but I don't understand","Oh okay!Interesting","Yeah yeah totally"};
				Random rand = new Random();
				int i = rand.nextInt(3)+0;
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
		
		else if (animalPosArray< 8 && animalPosArray>5)
		{
			while (statement!="Bye")
			{
				System.out.println(chatbot4.getResponse(statement));
				statement = in.nextLine();
			}
		}
		else if (animalPosArray< 10 && animalPosArray>7)
		{
			while (statement!="Bye")
			{
				System.out.println(chatbot3.getResponse(statement));
				statement = in.nextLine();
			}
		}
		
		
		if (findKeyword(statement, "tortoise", 0)>=0)
		{
			patience = patience +3;
			convoTortoise = true;
			convoFrog = false;
			convoTarantula = false;
			convoSnake = false;
		}
		else if (findKeyword(statement, "frog", 0)>=0)
		{
			patience--;
			convoTortoise = false;
			convoFrog = true;
			convoTarantula = false;
			convoSnake = false;
		}
		else if (findKeyword(statement, "tarantula", 0)>=0)
		{
			patience++;
			convoTortoise = false;
			convoFrog = false;
			convoTarantula = true;
			convoSnake = false;
		}
		else if (findKeyword(statement, "snake", 0)>=0)
		{
			convoTortoise = false;
			convoFrog = false;
			convoTarantula = false;
			convoSnake = true;
		}
		if (statement.length()==0)
		{
			String[] emptyResponses = {"You're replying slower than a tortoise!!","I know snakes that type faster than you./nThey don't even have fingers...",
					"Please say something.","Hurry up and reply... I have other customers!"};
			int i = (int)Math.random()*(emptyResponses.length);
			String answerEmpty = emptyResponses[i];
			return answerEmpty;
		}
		else if (convoTortoise)
		{
			if (findKeyword(statement, "what", 0)>=0)
			{
				if ((findKeyword(statement, "food", 0)>=0)||(findKeyword(statement, "eat", 0)>=0))
				{
					return "Tortoise usually eat a lot of greens but they can feed on some insects and like fruits as a special treat.";
				}
				else if (findKeyword(statement, "habitat", 0)>=0)
				{
					return "Tortoise like habitats with a lot of hideaways and in certain places you should look into if you need special lights to regulate heat.\nVisit this website to look into building the best habitat for your tortoise http://tortoisegroup.org/desert-tortoise-habitat-checklist/";
							
				}
				else
				{
					return "What, what? You can ask about what food they eat or what habitat though.\nYou can use this article to help answer your question! http://www.vetstreet.com/our-pet-experts/tempted-to-get-a-pet-turtle-or-tortoise-read-this-first";
				}
			}
			else if (findKeyword(statement, "how", 0)>=0)
			{
				if ((findKeyword(statement, "live", 0)>=0)||(findKeyword(statement, "years", 0)>=0))
				{
					return "Depending on living conditions and health issues, tortoises usually live about 70-100 years.\nThere is a lot of debate on an average life length though.";
				}
				else if ((findKeyword(statement, "buy", 0)>=0)||(findKeyword(statement, "get", 0)>=0))
				{
					return "We actually have a few Russian Tortoises that you can look at in our store!";
				}
				else 
				{
					return "How, what? You can ask how long they live or how to get one.\nYou can use this article to help answer your question! http://www.vetstreet.com/our-pet-experts/tempted-to-get-a-pet-turtle-or-tortoise-read-this-first";
				}
			}
			else if (findKeyword(statement, "tortoise", 0)>=0)
			{
				return "I've always wanted to buy a tortoise!!\nI encourage that you buy one of our Russian Tortoises.\nIf you want you can ask about how long they live or the food or anything else concerning you and I'll see if I can answer it.";
			}
				
		}
		else if (convoFrog)
		{
			if (findKeyword(statement, "what", 0)>=0)
			{
				if (findKeyword(statement, "food", 0)>=0)
				{
					return "Tortoise usually eat a lot of greens but they can feed on some insects and like fruits as a special treat.";
				}
				else if (findKeyword(statement, "habitat", 0)>=0)
				{
					return "Tortoise like habitats with a lot of hideaways and in certain places you should look into if you need special lights to regulate heat.\nVisit this website to look into building the best habitat for your tortoise http://tortoisegroup.org/desert-tortoise-habitat-checklist/";
							
				}
				else
				{
					return "What, what? You can ask about what food they eat or what habitat though.\nYou can use this article to help answer your question! https://www.wikihow.com/Take-Care-of-Frogs";
				}
			}
			else if (findKeyword(statement, "how", 0)>=0)
			{
				if (findKeyword(statement, "live", 0)>=0)
				{
					return "There isn't a good answer for this but the average is in a range from about 4 to 15.\nThere is a lot of debate on an average life length though.";
				}
				else if ((findKeyword(statement, "buy", 0)>=0)||(findKeyword(statement, "get", 0)>=0))
				{
					return "If you do want a frog (I recommend a tortoise), we have some of them available.";
				}
				else 
				{
					return "How, what? You can ask how long they live or how to get one.";
				}
			}
			
			
			else if (findKeyword(statement, "frog", 0)>=0)
			{
				return "I've never really understood why people want pets as frogs.\nI think you should buy one of our Russian Tortoises or Tarantulas but we have some frogs available.\nIf you want you can ask about how long they live or the food or anything else concerning you and I'll see if I can answer it.";
			}
				
		}
		else if (convoTarantula)
		{
			if (findKeyword(statement, "what", 0)>=0)
			{
				if (findKeyword(statement, "food", 0)>=0)
				{
					return "Tarantulas are insectivorous so crickets are their favorite meal.";
				}
				else if (findKeyword(statement, "habitat", 0)>=0)
				{
					return "People usually use aquarium-like tanks for habitats of tarantulas.\nUse this website for help: http://www.tarantulaguide.com/pet-tarantula-cage-and-habitat/";
							
				}
				else
				{
					return "What, what? You can ask about what food they eat or what habitat though.\nYou can use this article to help answer your question! http://www.tarantulaguide.com/";
				}
			}
			else if (findKeyword(statement, "how", 0)>=0)
			{
				if (findKeyword(statement, "live", 0)>=0)
				{
					return "Female Tarantulas can live up to 30 years while Male ones can only live up to 7 years.";
				}
				else if ((findKeyword(statement, "buy", 0)>=0)||(findKeyword(statement, "get", 0)>=0))
				{
					return "If you do want a tarantula, we only have one available.";
				}
				else 
				{
					return "How, what? You can ask how long they live or how to get one.\nYou can also check out this website to help you: http://www.tarantulaguide.com/";
				}
			}
			
			else if (findKeyword(statement, "tarantula", 0)>=0)
			{
				return "Tarantulas intimidate so many people but I think they are so cool.\nIf you want you can ask about how long they live or the food or anything else concerning you and I'll see if I can answer it.";
			}
				
		}
		else if (convoSnake)
		{
			if (findKeyword(statement, "what", 0)>=0)
			{
				if (findKeyword(statement, "food", 0)>=0)
				{
					return "Some species of snakes eat insects and reptiles like frogs, but others eat warm-blooded animals like mice.";
				}
				else if (findKeyword(statement, "habitat", 0)>=0)
				{
					return "People usually use aquarium-like tanks for habitats of snakes.\nThe size of it can depend on your snake.";
							
				}
				else
				{
					return "What, what? You can ask about what food they eat or what habitat though.\nYou can use this article to help answer your question! http://www.petmd.com/reptile/care/evr_rp_snake_facts";
				}
			}
			else if (findKeyword(statement, "how", 0)>=0)
			{
				if (findKeyword(statement, "live", 0)>=0)
				{
					return "There isn't a good answer for this but the average is in a range from about 4 to 15.\nThere is a lot of debate on an average life length though.";
				}
				else if ((findKeyword(statement, "buy", 0)>=0)||(findKeyword(statement, "get", 0)>=0))
				{
					return "If you want to check out some snakes we have two ball pythons and a corn snake available.";
				}
				else 
				{
					return "How, what? You can ask how long they live or how to get one.\nYou can also check out this website to help you: http://www.petmd.com/reptile/care/evr_rp_snake_facts";
				}
			}
			
			else if (findKeyword(statement, "snake", 0)>=0)
			{
				return "There have been rumors of pet snakes choking their owners but they are pretty chill pets if you know how to take care of them.\nIf you want you can ask about how long they live or the food or anything else concerning you and I'll see if I can answer it.";
			}
				
		}
		
		return randomResponse();
		
		
	}
	
}
