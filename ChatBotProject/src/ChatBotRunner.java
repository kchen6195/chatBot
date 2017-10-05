import java.util.Scanner;

/**
 * A simple class to run our chatbot teams.
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
		
		System.out.println(getGreeting());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		if (chatbot1.checkChatBot(statement))
		{
			System.out.println("oh ok so you like reptiles");
			
		}
		

		while (!statement.equals("Bye"))
		{
			//System.out.println (chatbot1.getResponse(statement));
			statement = in.nextLine();
		}
	}
	/*
	 * gets the intitial greeting for the user.
	 * @return a string that greets the user.
	 * 10/5/17
	 */
	private static String getGreeting()
	{
		return "yo this is the best pet shop in downtown bk \nhow can we help you";
	}
	

}
