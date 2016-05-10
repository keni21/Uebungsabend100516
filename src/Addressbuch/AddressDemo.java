package Addressbuch;

import java.io.IOException;

public class AddressDemo {

	public static void main(String[] args) throws AddressExportException, IOException, AddressLoadExecption, AddressLoadWrongFormatException {
		
		AddressManager manager=new AddressManager();
		Address a =new Address("firstname", "lastname", "mobilNumber", "email");
		Address b =new Address("firstname1", "lastname1", "mobilNumber1", "email1");
		
		manager.add(a);
		manager.add(b);
		
		
		manager.loadFromCSV("C:\\temp\\Uebungsabed.txt", ",");
		manager.exportToCSV("C:\\temp\\Uebungsabed1.txt", "|");
		

	}

}
