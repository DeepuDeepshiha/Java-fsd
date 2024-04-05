package lms.liveclass.practice;

public class Camera 
{
	String brand;
	int model;
	double rentprice;
	String status;
	int camid;
	public String getBrand() 
	{
		return brand;
	}
	public void setBrand(String brand) 
	{
		this.brand = brand;
	}
	public int getModel() 
	{
		return model;
	}
	public void setModel(int model) 
	{
		this.model = model;
	}
	public double getRentprice() 
	{
		return rentprice;
	}
	public void setRentprice(double rentprice) 
	{
		this.rentprice = rentprice;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}
	public int getCamid()
	{
		return camid;
	}
	public void setCamid(int camid) 
	{
		this.camid = camid;
	}
	public Camera()
	{
		
	}
	public Camera(String brand, int model, double rentprice, String status, int camid) {
		super();
		this.brand = brand;
		this.model = model;
		this.rentprice = rentprice;
		this.status = status;
		this.camid = camid;
	}
	@Override
	public String toString() {
		return camid + " \t  " + brand + "  \t " + model + "  \t " + rentprice+ " \t  " + status+"\n" ;
	}
	
	public  void rentshow()
	{
		if(status.equals("Available"))
		{
			
			System.out.println(camid+"\t"+brand+"\t"+model+"\t"+rentprice+"\t"+status);
		}
	}

}
