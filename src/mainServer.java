public class mainServer 
{
	public static boolean sFlag;
	public static void main(String arg[])
	{
//		System.out.print("��ʵ�ܼ�");
		try
		{
			new XMLServer().start();
		}
		catch(Exception e)
		{
			System.out.println("socket�쳣:"+e);
		}
	}
}
