package TimeServer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class TimeServer {

	public static void main(String[] args) throws IOException 
	{

		try
		{
			ServerSocket server =new ServerSocket(1234);
			
			Socket client= server.accept();
		
			try(OutputStreamWriter osw=new OutputStreamWriter(client.getOutputStream());BufferedWriter bw=new BufferedWriter(osw);)
			{
				bw.write(LocalDateTime.now().toString());
				bw.flush();
			}
		
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}

	}

}
