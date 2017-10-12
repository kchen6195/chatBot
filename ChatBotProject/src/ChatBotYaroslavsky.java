import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * A program to carry on conversations with a human user about dogs and cats.
 * This version:
 * @author  Edward Yaroslavsky
 * @version October 2017
 */
public class ChatBotYaroslavsky { 
	public boolean checkChatBot(String animalKey) {
		String[] animalArray = {"dog","cat"};
		for (String animal: animalArray) {
			if (findKeyword(animalKey,animal) != -1) {
				return true;
			}
		}
		return false;
	}
	
	int emotion = 0;
	
	String[] dogBreedArray = {"shepherd","husky","beagle","retriever","bulldog","chihuahua","poodle","boxer","rottweiler","dachshund",
			"terrier","shih tzu","pug","corgi","dane","collie","spaniel","pomeranian","pointer","schnauzer","sheepdog","hound"};
	
	boolean mentionDog = false;
	boolean mentionCat = false;
	boolean playActive = false;
	boolean listedDogBreeds = false;
	
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */	
	public String getGreeting() {
		return "Hi, what is up? Do you want to talk about man's best friend (dogs) or their worst enemy (cats)?"
				+ "\nType in 'dog' or 'cat' to continue to learn more about them!";
	}
		
	/**
	 * Gives a response to a user statement
	 * @param statement the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement) {
		String response = "";
		
		ChatBotBernard chatbot1 = new ChatBotBernard();
		ChatBotChen chatbot2 = new ChatBotChen();
		ChatBotUsman chatbot3 = new ChatBotUsman();
		Scanner in = new Scanner (System.in); 
		
		String[] animalArray = {"hamster","guinea pig","tortoise","frog","dog","cat","fish","seaweed"};
		int animalPosArray = -1;
		
		for (String animal:animalArray) {
			if (findKeyword(statement, animal) >= 0) {				
				animalPosArray = Arrays.asList(animalArray).indexOf(animal);
			}	
		}
		
		if (animalPosArray < 2 && animalPosArray > -1) {
			while (statement!="Bye") {
				System.out.println(chatbot2.getResponse(statement));
				statement = in.nextLine();
			}
		}
		else if (animalPosArray < 4 && animalPosArray > 1) {
			while (statement!="Bye") {
				System.out.println(chatbot1.getResponse(statement));
				statement = in.nextLine();
			}
		}
		else if (animalPosArray < 8 && animalPosArray > 5) {
			while (statement!="Bye") {
				System.out.println(chatbot3.getResponse(statement));
				statement = in.nextLine();
			}
		} 
		
		
		if (statement.length() == 0) {
			response = "Please talk to me.";
		}
		else if (findKeyword(statement, "dog") >= 0 && statement.length() == 3) {
			response = "Great! Type in 'size', 'speed', or 'cuteness' to learn more about dogs";
			mentionDog = true;
			emotion++;
		}
		else if (mentionDog) {
			if (findKeyword(statement, "size") >= 0) {
				response = "Small-sized dog breeds can stand as small as 2.5 inches at the shoulder and can weigh under 10 pounds."
						+ "\nMedium-sized dog breeds can stand about 18-22 inches at the shoulder and can weigh about 40-60 pounds."
						+ "\nLarge-Sized dog breeds can get bigger than 2.5 feet at the shoulder and can weigh over 200 pounds.";
			}
			else if (findKeyword(statement, "speed") >= 0) {
				response = "When you think of fast dogs, the tall and lean Greyhound is a great example. \nThis racing breed has been"
						+ " clocked at speeds up to 45 miles per hour, sparking its nickname: the 45-mph couch potato."
						+ "\nHowever, an average dog can run about 19 miles per hour";
			}
			else if (findKeyword(statement, "cuteness") >= 0) {
				response = "Lovingly referred to as the 'Yorkie', the Yorkshire terrier is the ultimate cutie in small breeds."
						+ "\nI personally believe that German Shepherd and Husky breeds are the best";
			}
			else {
				response = "Why didn't you listen to me?";
				emotion--;
			}
			mentionDog = false;
		}
		else if (findKeyword(statement, "cat") >= 0 && statement.length() == 3) {
			response = "That's an odd choice. Type in 'evil', 'soul', or 'cuteness' to learn more about cats";
			mentionCat = true;
			emotion--;
		}
		else if (mentionCat) {
			if (findKeyword(statement, "evil") >= 0) {
				response = "All cats are evil.";
			}
			else if (findKeyword(statement, "soul") >= 0) {
				response = "All cats have no soul.";
			}
			else if (findKeyword(statement, "cuteness") >= 0) {
				response = "Do not be tricked by the cats' cuteness; It is only a ruse."
						+ "\nThey hide their true maleficent intent behind their cuteness like a shield";
			}
			else {
				response = "Why didn't you listen to me?";
				emotion--;
			}
			mentionCat = false;
		}
		else if (findKeyword(statement, "I want to") >= 0) {
			response = transformIWantToStatement(statement);
		}
		else if (findKeyword(statement, "I want") >= 0) {
			response = transformIWantStatement(statement);
		}
		else if (findKeyword(statement, "I") >= 0 && findKeyword(statement, "you", findKeyword(statement, "I")) >= 0) {
			response = transformIYouStatement(statement);
		}
		else if (findKeyword(statement, "decide") >= 0 && findKeyword(statement, "dog") >= 0) {
			response = flipCoinGameIntro(statement);
		}
		else if (statement.equals("play")) {
			response = "Type in 'tails' if you think you should buy a dog \nand 'heads' if you think you should buy anything else "
					+ "\nI will decide for you";
			playActive = true;
		}
		else if (statement.equals("heads") && playActive) {
			response = "Oops! Looks like it landed on tails. Time to get a dog!"
					+ "\nIf you believe there is something wrong with this game please type 'help'";
			emotion--;
		}
		else if (statement.equals("tails") && playActive) {
			response = "Congrats! The coin landed on tails. Time to get a dog!"
					+ "\nIf you believe there is something wrong with this game please type 'help'";
			emotion++;
		}
		else if (findKeyword(statement, "help") >= 0 && playActive) {
			response = "That's right! I tricked you because everyone should buy dogs, for they are the best species"
					+ "\n(I may be a bit biased towards dogs)";
			playActive = false;
		}
		else if (findKeyword(statement, "buy") >= 0) {
			response = transformBuy(statement); 
		}
		else if (findKeyword(statement, "dogs") >= 0) {
			response = "I love dogs!";
			emotion++;
		}
		else if (findKeyword(statement, "cats") >= 0) {
			response = "Ew! Cats are disgusting creatures!";
			emotion--;
		}
		else if (findKeyword(statement, "no") >= 0) {
			response = "Why so negative?";
            emotion--;
		}	
		else if (findKeyword(statement, "fun facts") >= 0) {
			Random r = new Random();
			response = funFacts[r.nextInt(funFacts.length)];
		}
		else {
			for (String breed: dogBreedArray) {
				if (findKeyword(statement,breed) != -1) {
					listedDogBreeds = true;
				}
			}
			if (listedDogBreeds) {
				response = transformBreeds(statement);
				listedDogBreeds = false;
			}
			else {
				response = getRandomResponse();
			}
		}
			
		return response;
	}
	
	/**
	 * Search for one word in phrase. The search is not case sensitive. This method will check that the given goal 
	 * is not a substring of a longer string (so, for example, "I know" does not contain "no").
	 * @param statement the string to search
	 * @param goal the string to search for
	 * @param startPos the character of the string to begin the search at
	 * @return the index of the first occurrence of goal in statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal, int startPos) {
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		int psn = phrase.indexOf(goal, startPos);

		while (psn >= 0) {
			String before = " ", after = " ";
			if (psn > 0) {
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length()) {
				after = phrase.substring(psn + goal.length(), psn + goal.length() + 1);
			}

			if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0)) 
					&& ((after.compareTo("a") < 0) || (after.compareTo("z") > 0))) {
				return psn;
			}

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
	private int findKeyword(String statement, String goal) {
		return findKeyword (statement, goal, 0);
	}
	
	/**
	 * Take a statement with "I want to <something>." and transform it into 
	 * "Why do you want to <something>?"
	 * @param statement the user statement, assumed to contain "I want to"
	 * @return the transformed statement
	 */
	private String transformIWantToStatement(String statement) {
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")) {
			statement = statement.substring(0, statement.length() - 1);
		}
		int psn = findKeyword (statement, "I want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "Why do you want to " + restOfStatement + "?";
	}
	
	/**
	 * Take a statement with "I want <something>." and transform it into "Would you really be happy if you had <something>?"
	 * @param statement the user statement, assumed to contain "I want"
	 * @return the transformed statement
	 */
	private String transformIWantStatement(String statement) {
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")) {
			statement = statement.substring(0, statement.length() - 1);
		}
		int psn = findKeyword (statement, "I want", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "Would you really be happy if you had " + restOfStatement + "?";
	}
	
	/**
	 * Take a statement with "I <something> you" and transform it into 
	 * "Why do you <something> me?"
	 * @param statement the user statement, assumed to contain "I" followed by "you"
	 * @return the transformed statement
	 */
	private String transformIYouStatement(String statement) {
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")) {
			statement = statement.substring(0, statement.length() - 1);
		}
		
		int psnOfI = findKeyword (statement, "I", 0);
		int psnOfYou = findKeyword (statement, "you", psnOfI);
		
		String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
		return "Why do you " + restOfStatement + " me?";
	}
	
	/**
	 * Take a statement with "buy" and figure out if the user wants dogs or cats and transforms into an agreement or disagreement
	 * @param statement the user states, assumed to contain "buy", and possibly "dog" or "cat"
	 * @return the transformed statement
	 */
	private String transformBuy(String statement) {
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")) {
			statement = statement.substring(0, statement.length() - 1);
		}
		
		int psn = findKeyword(statement, "buy");
		String restOfStatement = statement.substring(psn + 3).trim();
		
		if (findKeyword(statement.substring(0, psn), "don't") >= 0 && findKeyword(statement, "cat") >= 0) {
			emotion++;
			return "Very good choice! You shouldn't even consider buying " + restOfStatement;
		}
		else if (findKeyword(statement.substring(0, psn), "don't") >= 0 && findKeyword(statement, "dog") >= 0) {
			emotion--;
			return "Let me try and persuade you into buying " + restOfStatement;
		}
		else if (findKeyword(statement.substring(0, psn), "don't") >= 0) {
			return "Why don't you want to buy " + restOfStatement + "?";
		}
		else if (findKeyword(statement, "cat") >= 0) {
			emotion--;
			return "Terrible Choice! You should not buy " + restOfStatement;
		}
		else if (findKeyword(statement, "dog") >= 0) {
			emotion++;
			return "I agree! Buying " + restOfStatement + " is a great idea!";
		}
		else {
			return "Buying " + restOfStatement + " is boring.";
		}
	} 
	
	
	/**
	 * Take a statement with a dog breed and respond back with a compliment to that breed
	 * @param statement the user states, assumed to contain a dog breed
	 * @return the transformed statement
	 */
	private String transformBreeds(String statement) {
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")) {
			statement = statement.substring(0, statement.length() - 1);
		}
		
		String dogBreeds = "";
		
		for (String breed: dogBreedArray) {
			if (findKeyword(statement, breed) >= 0) {
				dogBreeds += breed + "s, ";
			}
		}
		
		emotion++;
		return "I love " + dogBreeds + "they truly are fascinating!";
	}
	
	/**
	 * Takes a statement with the key words "decide" and "dog" following it, 
	 * and asks the user if they would like to play a coin flip game
	 * @param statement the user states, assumed to contain the key words
	 * @return the statement asking if the user wants to play a game
	 */
	private String flipCoinGameIntro(String statement) {
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")) {
			statement = statement.substring(0, statement.length() - 1);
		}
		
		int psn = findKeyword(statement, "decide");
		String restOfStatement = statement.substring(psn + 6).trim();
		
		return "Let me help you decide " + restOfStatement + " by playing a game. \nType 'play' to begin";
	}
	
	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
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
	
	private String[] randomHappyResponses = {"Ruf Ruf!", "Today is a good day", "Dogs rule, cats drool!", "You make me happy", ":D"};
	
	private String[] funFacts = {"Dogs don't have the same muscles in the cheeks and lips as we do, therefore a blow is something they do not understand",
			"To a dog, a stare from another dog, animal or human is rude and can mean a challenge", 
			"A dog can locate the source of a sound in 1/600 of a second and can hear sounds four times farther away than a human can", 
			"Cats  have a 'cry' which they use to manipulate humans", 
			"Cats hunt and bring you dead animals because they think you are too stupid to catch a bird or a mouse on your own", 
			"When a cat is rubbing up against you or lying in your lap, it doesn't want affection, it is marking you as its property"};
	
	
}
