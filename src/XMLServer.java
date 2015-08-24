import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class XMLServer{

	public void start() throws Exception{
		String xml="<cross-domain-policy>";
		xml += "<allow-access-from domain=\"*\" to-ports=\"*\" />";
		xml += "</cross-domain-policy>";
		
		ServerSocket serverSocket = new ServerSocket(5000);
		while(true)
		{
			try
			{
				Socket socket = serverSocket.accept();
				System.out.println("���ӳɹ� ......");
				BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));//correct get the input from the client
				PrintWriter pw=new PrintWriter(socket.getOutputStream());//correct make pw the output to client
				
				char[] by = new char[22];
				br.read(by, 0, 22);
				String head=new String(by);
//				JSONObject jsonObject = JSONObject.fromObject(head);
				System.out.println("��Ϣͷ:"+head);
				if(head.equals("<policy-file-request/>"))
				{
					System.out.println("�����ļ����سɹ�������");
					pw.print(xml+"\0");
					pw.flush();
				}
				else
				{
					controlThread testController=new controlThread(pw);
					testController.start();
				}
			}
			catch(Exception e)
			{
				serverSocket.close();
				System.out.println("�����������쳣��"+e);
			}
		}
	}
}
