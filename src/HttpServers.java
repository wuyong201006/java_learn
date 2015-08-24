import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServers extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
		String clientName = request.getParameter("clientName");
		if(clientName != null)
			clientName = new String(clientName.getBytes("ISO-8859-1"), "GB2312");
		else
			clientName = "我的朋友";
		
		PrintWriter out;
		String title = "HttpServer";
		String heading1 = "HelloServlet的doGet方法的输出:";
		
		response.setContentType("text/html;charset=GB2312");
		
		out = response.getWriter();
		out.print("<HTML><HEAD><TITLE>"+title+"</TITLE>");
		out.print("</HEAD><BODY>");
		out.print(heading1);
		out.println("<h1><p>"+clientName+":您好</h1>");
		out.print("</BODY></HTML>");
		out.close();
	}
}
