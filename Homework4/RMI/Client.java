package pack5;

import java.rmi.Naming;

public class Client {
	
	public static void main(String[] args) throws Exception{
		Currency client = (Currency)Naming.lookup("//localhost/ServerCurrency");
        System.out.println("Conversion of 1000 USD to EUR : " + client.Convert("USD","EUR",1000));
        System.out.println("Conversion of 340 USD to GBP : " + client.Convert("USD","GBP",340));
        System.out.println("Conversion of 10000 GBP to EUR : " + client.Convert("GBP","EUR",10000));
        System.out.println("Conversion of 150.25 GBP to USD : " + client.Convert("GBP","USD",150.25));
    }

}
