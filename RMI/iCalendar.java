package br.com.alissonrs.calendario;

import java.rmi.* ;
public interface iCalendar
       extends Remote
{
	java.util.Date getDate() throws RemoteException;

}
