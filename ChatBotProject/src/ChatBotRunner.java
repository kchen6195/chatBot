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
		
		
		
	}
}
