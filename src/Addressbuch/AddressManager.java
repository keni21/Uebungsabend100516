package Addressbuch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AddressManager {
	
	private ArrayList<Address> list=new ArrayList<>();

	public ArrayList<Address> getList() {
		return list;
	}
	
	public void loadFromCSV(String path, String sepaerator) throws AddressLoadExecption, FileNotFoundException, IOException, AddressLoadWrongFormatException
	{
	File file=new File(path);
	try	
	(FileReader fr=new FileReader(file);BufferedReader br =new BufferedReader(fr) )
	{
		String line;
		while((line=br.readLine())!=null)
		{
			String[]spilten=line.split(sepaerator);
			if(spilten.length!=4)
			{
				throw new AddressLoadWrongFormatException("Fehler in Zeile: "+line);
				
			}
			Address NewAdress=new Address(spilten[0], spilten[1], spilten[2],  spilten[3]);
			list.add(NewAdress);
		}
			
	}
	
	
	}
	
	public void add(Address a)
	{
		list.add(a);
	
	}
	
	public void exportToCSV(String path, String seperator) throws AddressExportException, IOException
	{
		File file =new File(path);
		if(file.exists())
		{
			throw new AddressExportFileAlreadyExistsException();
		}
		
		try
		(FileWriter fw=new FileWriter(file); PrintWriter pw=new PrintWriter(fw))
		{
			String line;
			for (Address address : list) {
			line=address.getFirstname()+seperator+address.getLastname()+seperator+address.getMobilNumber()+seperator+address.getEmail();
			pw.println(line);
			}
			
			
		}
	}
	
	public void saveToSCV(String path,String seperator) throws AddressExportException
	{
		
		
		try (FileWriter fw=new FileWriter(path);PrintWriter pw =new PrintWriter(fw))
		{
			for (Address address : list) 
			{
				pw.println
						(address.getFirstname()+seperator+
						address.getLastname()+seperator+
						address.getMobilNumber()+seperator+
						address.getEmail());
			}
			pw.flush();
		} 
	
		
		catch (IOException e) {
			throw new AddressExportException();
		}
		
	}

}
