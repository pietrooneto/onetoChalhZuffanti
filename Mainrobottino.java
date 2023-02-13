package robottino;



import java.io.IOException;

public class Mainrobottino {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
		Server server = new Server();
		Comandi move = new Comandi();
		char character = 0;
		int flag = 0;
		System.out.println("SCUDERIA: charlatans");
		server.createServer();
		
		server.listen();
		
		while(flag == 0) {
			character = server.receive();
			System.out.println(character);
			switch(character) 
			{
			
				case 'w':
					move.forward();
					//move.acceleration();
					break;
					
				case 'a':
					move.left();
					break;
				case 'y':
					move.alza();
					break;
				case 'b':
					move.abbassa();
					break;
					
				case 's':
					move.backward();
					move.acceleration();
					break;
					
				case 'd':
					move.right();
					break;
				case 'v':
					move.festeggia();
					break;
				case 'e':
					move.freno();
					break;
				
				case 'x':
					System.out.println("Exit");
					move.stop();
					flag = 1;
					break;
				case ' ':
					move.deceleration();
					break;
			
				default:
					
					break;
					
			}
			
		}
		
		
		
		server.close();
	}

}