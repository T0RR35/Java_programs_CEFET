package br.com.alissonrs.calendario;
//arquivo CalendarUser.java

import java.rmi.Naming;
import java.util.Date;

import javax.swing.JOptionPane;

public class CalendarUser
{
// constructor
public CalendarUser() {}

public static void main(String args[])
{
  long       t1=0,t2=0;
  iCalendar  remoteCal;
  
  try {
    remoteCal = (iCalendar) Naming.lookup("rmi:///CalendarImpl");

    t1 = remoteCal.getDate().getTime();
    JOptionPane.showMessageDialog(null, "Essa mensagem eh so para gastar tempo");
    Date dt = remoteCal.getDate();
    t2 = dt.getTime();
  }
  
  catch (Exception e) {
      e.printStackTrace();
    }
  
    System.out.println("This RMI call took "     + (t2-t1) + " milliseconds");
    
  }
} 

