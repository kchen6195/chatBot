import java.util.Scanner;
import java.util.Arrays;

/**
 * A simple  class to run our chatbot teams.
 * @author Mr. Levin
 * @version September 2017
 */
public class ChatBotRunner
{

	/**
	 * Create instances of each chatbot, give it user input, and print its replies. Switch chatbot responses based on which chatbot the user is speaking too.
	 */
	public static void main(String[] args)
	{
		ChatBotBernard chatbot1 = new ChatBotBernard();
		ChatBotChen chatbot2 = new ChatBotChen();
		ChatBotUsman chatbot3 = new ChatBotUsman();
		ChatBotYaroslavsky chatbot4 = new ChatBotYaroslavsky();
		
		System.out.println("yo this is the best pet shop in downtown bk \n Which animal would you like to learn about?");
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		
		/*
		 * array animalArray is all of the animals that our pet shop chatbot can provide information on.
		 * int animalPosArray is the position of the animal the user wants to discuss within animalArray.
		 */
		
		String[] animalArray = {"hamster","guinea pig","tortoise","frog","tarantula","snake","dog","cat","fish"};
		int animalPosArray = -1;
		{
			for (String animal:animalArray)
			{
				if (chatbot1.findKeyword(statement, animal, 0)>=0)
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
		else if (animalPosArray< 6 && animalPosArray>1)
		{
			while (statement!="Bye")
			{
				System.out.println(chatbot1.getResponse(statement));
				statement = in.nextLine();
			}
		}
		else if (animalPosArray< 8 && animalPosArray>5)
		{
			System.out.println(chatbot4.getGreeting());
			while (statement!="Bye")
			{
				System.out.println(chatbot4.getResponse(statement));
				statement = in.nextLine();
			}
		}
		else if (animalPosArray< 10 && animalPosArray>7)
		{

			System.out.println(chatbot3.getGreeting());
			while (statement!="Bye")
			{
				System.out.println(chatbot3.getResponse(statement));
				statement = in.nextLine();
			}
		}
		else
		{//
			System.out.println("Please say a real animal this time.");
			statement = in.nextLine();
		}
	}
}
