
public class Point {
	public int mx;
	public int my;
	public Point(int inX, int inY)
	{
		mx = inX;
		my = inY;
	}
	
	public String toString()
	{
		return new String(mx+","+my);
	}
}
