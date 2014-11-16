package pack5;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Currency extends Remote {

	public double Convert(String from, String to, double amount) throws RemoteException;
}
