
public class ChatBotBernard {
	public boolean checkChatBot(String animalkey)
	{
		String[] animalArray = {"tortoise","snake","frog"};
		for (String animal:animalArray)
		{
			if (animal.equals(animalkey))
			{
				return true;
			}
			
		}
		return false;
		
	}
}
