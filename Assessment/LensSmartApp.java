package lms.liveclass.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LensSmartApp 
{
	private static final String username="admin";
	private static final String password="pass@123";
	public static void main(String[] args)
	{
		try
		{
			Scanner sc=new Scanner(System.in);
			List<Camera> lst=new ArrayList<Camera>();
			Camera c=new Camera();
			lst.add(new Camera("Canon",5001,2500,"Available",1));
			lst.add(new Camera("Sony",5002,2750,"Available",2));
			lst.add(new Camera("Fujifilm",5003,2300,"Rent",3));
			lst.add(new Camera("Nikon",5004,2000,"Available",4));
			lst.add(new Camera("Panasonic",5005,1750,"Available",5));
			lst.add(new Camera("Olympus",5006,1250,"Rent",6));
			lst.add(new Camera("Pentax",5007,1500,"Available",7));
			System.out.println("******************************************************************************");
			System.out.println("\t\t Lens Smart App Welcomes you! \t\t");
			System.out.println("\t\t Developed by Deepshiha \t\t");
			System.out.println("******************************************************************************");
			System.out.print("Enter username: ");
			String uname=sc.next();
			System.out.print("Enter password: ");
			String pwd=sc.next();
			System.out.println("******************************************************************************");
			if(uname.equals(username) && pwd.equals(password))
			{
				System.out.println();
				System.out.println("\tLogin successful\t");
				System.out.println();
				options(lst,c);
				
			}
			else
			{
				System.out.println("Ooops,Please check your credentials");
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		
	}
	
	public static void viewcam(List<Camera> l)
	{
		System.out.println("****************************************************************************");
		System.out.println("CamId\tBrand\t\tModel\t\tRental Price\t\tStatus");
		System.out.println("****************************************************************************");
		for(Camera cam:l)
		{
			System.out.println(cam.getCamid()+"\t"+cam.getBrand()+"\t\t"+cam.getModel()+"\t\t"+cam.getRentprice()+"\t\t"+cam.getStatus());
		}
		if(l.isEmpty())
		{
			System.out.println("No data to display");
		}
	}
	
	public static void options(List<Camera> lst,Camera c)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("******************************************************************************");
		System.out.println("\t\t\tMenu\t\t\t");
		System.out.println("******************************************************************************");
		System.out.println(" 1. My cameras\n 2. Rent a Camera\n 3. Check Wallet\n 4. Exit");
		double walletbalance=20500;
		System.out.print("Enter your choice: ");
		int opt=sc.nextInt();
		System.out.println("******************************************************************************");
		switch(opt)
		{
		
		case 1:
		{
			System.out.println("---------My Cameras-----------");
			System.out.println();
			System.out.println("1.Add camera\t 2. Remove camera\t 3. View camera\t 4. Back to main menu");
			System.out.println();
			System.out.print("Enter your choice:");
			int i=sc.nextInt();
			System.out.println();
			if(i==1)
			{	
				System.out.print("Enter brand: ");
				c.brand=sc.next();
				System.out.print("Enter model: ");
				c.model=sc.nextInt();
				System.out.print("Enter rent price: ");
				c.rentprice=sc.nextDouble();
				System.out.print("Enter status(Available/Rent): ");
				c.status=sc.next();
				int ci=7+i;
				c.camid=ci;
				lst.add(c);
				System.out.println();
				System.out.println("Hurray!, Camera Added!");
				viewcam(lst);
				System.out.println("******************************************************************************");
				break;
			}
			else if(i==2)
			{
				List<Camera> lstremove=new ArrayList<Camera>();
				viewcam(lst);
				System.out.println();
				System.out.print("Enter the camera id to remove: ");
				int id=sc.nextInt();
				for(Camera cam:lst)
				{
					if(cam.camid==id)
					{
						lstremove.add(cam);
					}
				}
				lst.removeAll(lstremove);
				viewcam(lst);
				System.out.println();
				System.out.println("\nCamera Removed!");
				break;
				
			}
			else if(i==3)
			{
				System.out.println();
				viewcam(lst);
				System.out.println();
				break;
			}
			else if(i==4)
			{
				System.out.println();
				options(lst,c);
				break;
			}
		}
		case 2:
		{
			System.out.println("---------Rent a camera-----------");
			System.out.println("******************************************************************");
			System.out.println("CamId\tBrand\tModel\tRental Price\tStatus");
			System.out.println("******************************************************************");
			for(Camera cam:lst)
			{
				cam.rentshow();
			}
			System.out.println();
			System.out.print("Enter the Camera Id you want to rent: ");
			int cid=sc.nextInt();
			System.out.println("******************************************************************");
			for(Camera cam:lst)
			{
				if(cam.camid==cid)
				{
					if(cam.rentprice<walletbalance)
					{
						walletbalance=walletbalance-cam.rentprice;
						System.out.println("Transaction completed for "+cam.brand+" of Rupees "+cam.rentprice+" and your current balance is "+walletbalance);
					}
					else
					{
						System.out.println("Insufficient amount in your balance");
					}
				}
			}
			System.out.println();
			break;
		}
		case 3:
		{
			System.out.println("---------Check Wallet-----------");
			System.out.println();
			System.out.println("1. Add money to balance\t 2. View wallet balance\t 3. Back to main menu");
			System.out.print("Enter your choice: ");
			int s=sc.nextInt();
			if(s==1)
			{
				System.out.println("Enter the amount:");
				double amt=sc.nextDouble();
				walletbalance=walletbalance+amt;
				System.out.println("My wallet balance is "+walletbalance);
				break;
			}
			else if(s==2)
			{
				System.out.println("My current balance is "+walletbalance);
				break;
			}
			else if(s==3)
			{
				options(lst,c);
				break;
			}
		}
		
		case 4:
		{
			System.out.println("---------Exit-----------");
			System.out.println("Bye, See you soon!!");
			break;
		}
		default:
		{
			System.out.println("Wrong option");
			break;
		}
		
		}
	}

}
