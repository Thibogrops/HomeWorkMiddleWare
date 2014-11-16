package pack5;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;



public class Server  extends UnicastRemoteObject implements Currency{

	private static final long serialVersionUID = 1L;

	protected Server() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public double Convert(String from, String to, double amount){
		if (from.equals("EUR") && to.equals("USD")){
			return amount*1.25;
		}
		if (from.equals("USD") && to.equals("EUR")){
			return amount*0.78;
		}
		if (from.equals("USD") && to.equals("GBP")){
			return amount*0.63;
		}
		if (from.equals("GBP") && to.equals("USD")){
			return amount*1.56;
		}
		if (from.equals("GBP") && to.equals("EUR")){
			return amount*1.25;
		}
		if (from.equals("EUR") && to.equals("GBP")){
			return amount*0.79;
		}
		else{
			System.out.println("Devise incorrect");
			return 0;
		}
	}

	public static void main(String[] args) {
		try {
			/*
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }
			 */
			LocateRegistry.createRegistry(1099);

			Server server = new Server();
			Naming.rebind("//0.0.0.0/ServerCurrency", server);

			System.out.println("Server started...");

		} catch (Exception e) {
			System.out.println("Error: " + e.getLocalizedMessage());
		}

	}

}
