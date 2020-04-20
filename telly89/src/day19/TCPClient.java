package day19;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {
	public static void main(String[] args) {
		try {
//			创建Socket，指定ip，port
			Socket socket = new Socket("127.0.0.1", 4700);

//			获得键盘输入
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));

//			获得基于Socket的输入流和输出流
			DataOutputStream os = new DataOutputStream(socket.getOutputStream());
			DataInputStream is = new DataInputStream(socket.getInputStream());

			String readline;

			// 在这里添加和服务器登录校验的代码
			while (true) {
				readline = "";
				System.out.println("请输入账号:");
				readline = sin.readLine() + ";";
				System.out.println("请输入密码:");
				readline += sin.readLine();
				// 发送给服务器的数据格式： 账号;密码
				os.writeUTF(readline);
				os.flush();
				readline = is.readUTF();// 规定：success 登录成功 否则 登录失败
				if (readline.equals("success"))
					break;
			}
			System.out.println("可以和服务器聊天了！");
			readline = sin.readLine();
//			向服务器写数据
			while (!readline.equals("exit")) {
				os.writeUTF(readline);
				os.flush();
				System.out.println("Server:" + is.readUTF());
				readline = sin.readLine();
			}
			os.close();
			is.close();
			socket.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
