package testlab;

import java.io.IOException;
import java.net.UnknownHostException;

public class Mainpc {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException, ReflectiveOperationException {
		// TODO Auto-generated method stub
		
		Client client = new Client();
		Controller pad = new Controller();
		
		client.connect();
		pad.createWindow();
		
		while(pad.getCode() != 'x')
		{
			Thread.sleep(125);
			if(client.isOpen()) 
			{
				client.send(pad.getCode());
			}
		}
		
		
		client.close();
        System.out.println("chiusura client...");
        System.exit(0);
		
	}

}