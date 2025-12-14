package br.com.alissonrs.calendario;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class CalendarImpl extends UnicastRemoteObject implements iCalendar {

	public CalendarImpl() throws RemoteException {
	}

	public Date getDate() throws RemoteException {
		return new Date();
	}

	public static void main(String args[]) {
		CalendarImpl cal;
		try {
			cal = new CalendarImpl();
			LocateRegistry.createRegistry(1099);
			Naming.bind("rmi:///CalendarImpl", cal);			
			System.out.println("Server rodando!");
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
