public class mainServer 
{
	public static boolean sFlag;
	public static void main(String arg[])
	{
//		System.out.print("其实很简单");
		try
		{
			new XMLServer().start();
		}
		catch(Exception e)
		{
			System.out.println("socket异常:"+e);
		}
	}
}
