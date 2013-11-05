package mybest;

public class Styles {

	/**
	 * @param args
	 */
	static String mystr="",my="";
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String my="ketan a chawda";
		System.out.println(scase(my));				
	}
	public static String scase(String str)//for sentence case
	{
		mystr="";
		for(int k=0;k<str.length();k++)
		{
			my=str.charAt(k)+"";
			if(k==0 || str.charAt(k-1)==10)
			mystr=mystr+my.toUpperCase();
			else
			mystr=mystr+my.toLowerCase();
		}
		return mystr;
	}
	
	public static String ccase(String str)//for capitalized each word(title)
	{
		mystr="";
		boolean status=true;
		for(int k=0;k<str.length();k++)
		{
		my=str.charAt(k)+"";
		if(status==true)
		mystr=mystr+my.toUpperCase();
		else
		mystr=mystr+my.toLowerCase();
		if(str.charAt(k)==32 || str.charAt(k)==9 || str.charAt(k)==10)
			status=true;
		else
			status=false;
		}
		return mystr;
	
	}
	public static String tcase(String str)//for toggle case
	{
		mystr="";
		boolean status=true;
		for(int k=0;k<str.length();k++)
		{
		my=str.charAt(k)+"";
		if(status==true)
		mystr=mystr+my.toLowerCase();
		else
		mystr=mystr+my.toUpperCase();
		if(str.charAt(k)==32 || str.charAt(k)==9 || str.charAt(k)==10)
			status=true;
		else
			status=false;
		}
		return mystr;
	
	}

}
