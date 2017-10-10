import java.util.Scanner;

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
		
		System.out.println("yo this is the best pet shop in downtown bk \nhow can we help you");
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		
		/*
		 * These if and if else statements decides which chatbot the user wants to talk to.
		 * Uses the checkChatBot function to understand if the 
		 */
		if (chatbot1.checkChatBot(statement))
		{

			System.out.println("oh ok so you like reptiles");
			statement = in.nextLine();
			while (!statement.equals("Bye") && !(chatbot2.checkChatBot(statement))
					&& !(chatbot3.checkChatBot(statement)) && !(chatbot4.checkChatBot(statement)))
			{
				System.out.println(chatbot1.getResponse(statement));
				statement = in.nextLine();
			}
		}
		else if (chatbot2.checkChatBot(statement))
		{
			System.out.println("ask me about the smallest of animals");
			statement = in.nextLine();
			while (!statement.equals("Bye") && !chatbot1.checkChatBot(statement) 
					&& !chatbot3.checkChatBot(statement) && !chatbot4.checkChatBot(statement))
			{
				System.out.println(chatbot2.getResponse(statement));
				statement = in.nextLine();
			}
		}
		else if (chatbot3.checkChatBot(statement))
		{
			System.out.println("fish person");
			statement = in.nextLine();
			while (!statement.equals("Bye") && !chatbot2.checkChatBot(statement) 
					&& !chatbot1.checkChatBot(statement) && !chatbot4.checkChatBot(statement))
			{
				System.out.println(chatbot3.getResponse(statement));
				statement = in.nextLine();
			}
		}
		else if (chatbot4.checkChatBot(statement))
		{
			System.out.println("dog person");
			statement = in.nextLine();
			while (!statement.equals("Bye") && !chatbot2.checkChatBot(statement)
					&& !chatbot3.checkChatBot(statement) && !chatbot1.checkChatBot(statement))
			{
				System.out.println(chatbot4.getResponse(statement));
				statement = in.nextLine();
			}

		}
		else
		{
			
		}
	}
}
