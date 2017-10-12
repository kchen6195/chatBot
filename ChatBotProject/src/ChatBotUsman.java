import java.util.Random;



/**

* A program to carry on conversations with a human user.

* This version:

* @author Mr. Levin

* @version  September 2017

*/

	public class ChatBotUsman{


		public boolean checkChatBot(String animalkey)

		{

			String[] animalArray = {"Fish"};

			for (String animal: animalArray) {

				/*	if (animal.equals(animalKey)) {

				return true;

				} */

				if (findKeyword(animalkey,animal) != -1) 
				{

				return true;

				}

		}

			return false;

		}

			int emotion = 0;

			String[] fishArray = {"Clown Fish", "Neon Tetra", "Danios", "Platies", "Kuhli Loach","Cherry Barb",

			"Fire Mouth Cichilid","Pearl Gourami","Tiger Pleco","Mollies","Sword Tails","Betta"};

			boolean listedFish = false;

			//emotion can alter the way our bot responds. Emotion can become more negative or positive over time.


			public String getGreeting()

			{

				return "Hi, how are you? I am a bot that will help you with finding the perfect pet, which is a FISH!";

			}


			/**

			 * Gives a response to a user statement

			 * @param statement

			 * the user statement

			 * @return a response based on the rules given
			*/

			public String getResponse(String statement)

			{

				String response = "";


				if (statement.length() == 0)

				{

					response = "Are you there?";

				}



				else if (findKeyword(statement, "no") >= 0)

				{

					response = "Ok I guess not?";

					emotion--;

				}

				else if (findKeyword(statement, "dog") >= 0)

				{

					response = "DOGS?! Please reconsider your decision, they are too much!";

					emotion--;

				}

				else if (findKeyword(statement, "cat") >= 0)

				{

					response = "CATS?! Please reconsider your decision, they are too much!";

					emotion--;

				}

				else if (findKeyword(statement, "fish") >= 0)

				{

					response = "YES! They are the best! QUET, COOL, AND EASY TO TAKE CARE OF! If you want to find out more information on them enter'type of fish'";

					emotion++;

				}
				else if (findKeyword(statement, "type of fish") >= 0)

				{

					response = "Fish is a popular pet, which means it comes in all shapes and size but our store only has the most popular one such as 'Clown Fish', 'Neon Tetra', 'Danios', 'Platies', 'Kuhli Loach','Cherry Barb','Fire Mouth Cichilid','Pearl Gourami','Tiger Pleco','Mollies','Sword Tails','Betta',"
							+ "If you want to find out more information on one of them, just enter the name";

				}
				else if (findKeyword(statement, "Clown Fish") >= 0)

				{

					response = "YES! They are the best! QUET, COOL, AND EASY TO TAKE CARE OF! If you want to find out more information on them enter'type of fish'";

					emotion++;

				}

				else if (findKeyword(statement, "yes")>=0)

				{
						
					response = "Alright, I see. ";

					emotion++;

				}


				else if (findKeyword(statement, "cool") >= 0)

				{

					response = "That's great, is there anything I can help you with?";

					emotion++;

				}

				else if (findKeyword(statement, "pet") >= 0)

				{

					response = "Wait you're lookin for pet?! The best choice is obviously a fish. They come in all different sizes and colors, and they make no mess at all, and theya re quiet! ";

					emotion++;

				}


				// Response transforming I want to statement

				else if (findKeyword(statement, "I want to", 0) >= 0)

				{

					response = transformIWantToStatement(statement);

				}

				else if (findKeyword(statement, "I want",0) >= 0)

				{

					response = transformIWantStatement(statement);

				}

				else

				{

					response = getRandomResponse();

				}


				return response;

				}


			/**

			 * Take a statement with "I want to <something>." and transform it into 

			 * "Why do you want to <something>?"

			 * @param statement the user statement, assumed to contain "I want to"

			 * @return the transformed statement

			 */

			private String transformIWantToStatement(String statement)

			{

				//  Remove the final period, if there is one

				statement = statement.trim();

				String lastChar = statement.substring(statement.length() - 1);

				if (lastChar.equals("."))

				{

					statement = statement.substring(0, statement.length() - 1);

				}

				int psn = findKeyword (statement, "I want to", 0);

				String restOfStatement = statement.substring(psn + 9).trim();

				return "Why do you want to " + restOfStatement + "?";

			}

			/**
	
			 * Take a statement with "I want <something>." and transform it into 

			 * "Would you really be happy if you had <something>?"
	
			 * @param statement the user statement, assumed to contain "I want"

			 * @return the transformed statement

			 */

			private String transformIWantStatement(String statement)

			{

				//  Remove the final period, if there is one

				statement = statement.trim();

				String lastChar = statement.substring(statement.length() - 1);

				if (lastChar.equals("."))

				{

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

			private String transformIYouStatement(String statement)

			{

				//  Remove the final period, if there is one

				statement = statement.trim();

				String lastChar = statement.substring(statement.length() - 1);

				if (lastChar.equals("."))
					
				{

					statement = statement.substring(0, statement.length() - 1);

				}


				int psnOfI = findKeyword (statement, "I", 0);

				int psnOfYou = findKeyword (statement, "you", psnOfI);


				String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();

				return "Why do you " + restOfStatement + " me?";

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

						after = phrase.substring(psn + goal.length(),psn + goal.length() + 1);

					}



					// If before and after aren't letters, we've

					// found the word

					if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0)) // before is not a// letter
						&& ((after.compareTo("a") < 0) || (after.compareTo("z") > 0)))

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


			private String transformBuy(String statement) {

				statement = statement.trim();

				String lastChar = statement.substring(statement.length() - 1);

				if (lastChar.equals("."))

				{

					statement = statement.substring(0, statement.length() - 1);

				}


				int psn = findKeyword(statement, "buy");

				String restOfStatement = statement.substring(psn + 3).trim();


				if (findKeyword(statement.substring(0, psn), "don't") >= 0 && findKeyword(statement, "cat") >= 0) 
				{

					emotion++;

					return "Very good choice! You shouldn't even consider buying " + restOfStatement;

				}

				else if (findKeyword(statement.substring(0, psn), "don't") >= 0) 
				{

					return "Why don't you want to buy " + restOfStatement;

				}

				else if (findKeyword(statement, "cat") >= 0) {

					emotion--;

					return "Terrible Choice! You should not buy " + restOfStatement;

				}

				else if (findKeyword(statement, "fish") >= 0) {

					emotion++;

					return "I agree! Buying " + restOfStatement + " is a great idea!";

				}

				else if (findKeyword(statement.substring(0, psn), "don't") >= 0 && findKeyword(statement, "fish") >= 0) {

					emotion--;

					return "Let me try and persuade you into buying " + restOfStatement;

				}

				else {

					return "Buying " + restOfStatement + " is boring.";

				}

			}

			private String transformTypes(String statement) {

				statement = statement.trim();

				String lastChar = statement.substring(statement.length() - 1);

				if (lastChar.equals("."))

				{

					statement = statement.substring(0, statement.length() - 1);

				}


				String fishes = "";


				for (String type: fishArray)
				{

					if (findKeyword(statement, type) >= 0)
					{

						fishes += type + ", ";

					}

				}


				emotion++;

				return "I love " + fishes + " they truly are fascinating!";

			}

			private String flipCoinGameIntro(String statement) {

				statement = statement.trim();

				String lastChar = statement.substring(statement.length() - 1);

				if (lastChar.equals("."))

				{

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

			private String getRandomResponse ()

			{

				Random r = new Random ();

				if (emotion == 0)

				{

					return randomNeutralResponses [r.nextInt(randomNeutralResponses.length)];

				}

				if (emotion < 0)

				{

					return randomAngryResponses [r.nextInt(randomAngryResponses.length)];

				}

				return randomHappyResponses [r.nextInt(randomHappyResponses.length)];

			}


			private String [] randomNeutralResponses = {"Interesting, tell me more",

					"Hmmm.",

					"Do you really think so?",

					"You don't say.",

					"It's all boolean to me.",

					"So, would you like to go for a walk?",

					"Could you say that again?"

			};

			private String [] randomAngryResponses = {"Okay....", "I don't like that tone", "Lets take this outside!", ">:(", "Bye!"};

			private String [] randomHappyResponses = {"YASSS", "Today is a good day", "Glad to talk to you!"};


	}



