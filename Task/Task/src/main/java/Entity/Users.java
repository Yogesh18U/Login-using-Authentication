package Entity;

public class Users {

	private String UserName;
	private int Age;
	private String Phone;
	private String MailId;
	private String Location;
	private String Password;
	
	public String getUserName() 
	{
		return UserName;
	}
	
	public void setUserName(String userName)
	{
		UserName = userName;
	}
	
	public int getAge()
	{
		return Age;
	}
	
	public void setAge(int age)
	{
		Age = age;
	}
	
	public String getPhone()
	{
		return Phone;
	}
	
	public void setPhone(String phone) 
	{
		Phone = phone;
	}
	
	public String getMailId()
	{
		return MailId;
	}
	
	public void setMailId(String mailId) 
	{
		MailId = mailId;
	}
	
	public String getLocation()
	{
		return Location;
	}
	
	public void setLocation(String location)
	{
		Location = location;
	}
	
	public String getPassword() 
	{
		return Password;
	}
	
	public void setPassword(String password) 
	{
		Password = password;
	}
	
}
