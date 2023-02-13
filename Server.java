package robottino;


import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Server {
	
    private ServerSocket server;
    private Socket clientSocket = null;
    private ObjectOutputStream output;
    private ObjectInputStream input;
   
    
    private int port = 10000; //porta del server
    
    public void listen() throws IOException
    {
    	System.out.println("in attesa del client...");
    	
    	clientSocket = server.accept();
    	
    	System.out.println("client connesso"); 	
    }
    
    public void createServer() throws IOException 
    {	
        server = new ServerSocket(port);   
        System.out.println("creatoooo");
    }
    
    public char receive() throws IOException, ClassNotFoundException 
    {  	
    	input = new ObjectInputStream(clientSocket.getInputStream());   	
    	char code = (char)input.readObject();   	
    	System.out.println(code);
    	
    	return code;	
    }
    
	public void send(int speed) throws IOException 
	{
		output = new ObjectOutputStream(clientSocket.getOutputStream());
		
		output.writeObject(speed);
	}
        
    public void close() throws IOException 
    {
        input.close();
        clientSocket.close();
        System.out.println("chiusura socket del server...");
        
        server.close();
    }
    
    public boolean isOpen()
    {
    	
    	if(clientSocket.isClosed()) 
    	{
    		System.out.println("il socket è chiuso");
    		return false;
    	}
    	else
    	{
    		System.out.println("il socket è aperto");
    		return true;
    	}
    		
    	
    }
}