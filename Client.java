package testlab;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;

public class Client {
	
	private  Socket socket = null;
    private  ObjectOutputStream output = null;
    private  ObjectInputStream input = null;
    
	public void connect() throws UnknownHostException, IOException 
	{	
        String ip = ipRequest();
        int port = portRequest();        
        
        socket = new Socket(ip, port);	
	}
	
	
	private String ipRequest() 
	{
		
		String ip;
		
		ip = JOptionPane.showInputDialog("indirizzo IP:");
        if(ip.isEmpty()) 
        {
        	System.out.println("errore inserimento IP");
        	System.exit(1);
        	
        }
        
        return ip;
	}
	
	
	private int portRequest() 
	{
		
        String porta = JOptionPane.showInputDialog("porta:");
        int port = 0;
        
        if(porta.isEmpty()) 
        {
        	System.out.println("errore inserimento porta");
        	System.exit(1);
        	
        }
        else
        	port = Integer.parseInt(porta);
		
        return port;
	}
	

	
	public void send(char code) throws IOException 
	{	
        //write to socket using ObjectOutputStream
		output = new ObjectOutputStream(socket.getOutputStream());
		
		output.writeObject(code);
		
	}
	
    public int receive() throws IOException, ReflectiveOperationException
    {
    	
    	input = new ObjectInputStream(socket.getInputStream());
    	int speed = (int)input.readObject();
    	
    	return speed;
    	
    }
	
	public void close() throws IOException 
	{
		
        output.close();
        socket.close();
		
	}
	
    public boolean isOpen() 
    {
    	
    	if(socket.isClosed()) 
    	{
    		return false;
    	}
    	else
    		return true;
    	
    }

}
