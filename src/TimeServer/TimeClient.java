package TimeServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

public class TimeClient {

	public static void main(String[] args) throws UnknownHostException, IOException {


		
		try(Socket client =new Socket("127.0.0.1", 1234);
			InputStreamReader osw=new InputStreamReader(client.getInputStream());
			BufferedReader bw=new BufferedReader(osw);)
		{
			System.out.println(bw.readLine());
			bw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}

}
