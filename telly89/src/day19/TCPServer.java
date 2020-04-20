package day19;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TCPServer {
	public static void main(String[] args) {
		try {
			ServerSocket server = null;
			try {
//				创建ServerSocket对象，指定端口是4700
				server = new ServerSocket(4700);
				System.out.println("服务器启动成功");
			} catch (Exception e) {
				System.out.println("服务器启动出错:" + e.getMessage());
			}
			Socket socket = null;
			try {
//				调用ServerSocket的accept方法，可以接受客户端的请求，并返回当前的Socket对象,accept方法是阻塞的
				socket = server.accept();
			} catch (Exception e) {
				e.printStackTrace();
			}
			String line;
//			获得基于Socket的输入流
			DataInputStream is = new DataInputStream(socket.getInputStream());

//			获得基于Socket的输出流
			DataOutputStream os = new DataOutputStream(socket.getOutputStream());

//			获得控制台输入
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));

			// 判断账号密码是否正确
			while (true) {
				line = is.readUTF();
				if (login(line)) {
					os.writeUTF("success");
					os.flush();
					break;
				} else {
					os.writeUTF("fail");
					os.flush();
				}
			}

//			输出客户端输入
			System.out.println("Client:" + is.readUTF());

			line = sin.readLine();

//			向客户端写数据
			while (!line.equals("exit")) {
				os.writeUTF(line);
				os.flush();
				System.out.println("Client:" + is.readUTF());
				line = sin.readLine();
			}

//			资源关闭操作
			os.close();
			is.close();
			socket.close();
			server.close();
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}

	}

	public static boolean login(String value) {
		String line = "";
		Reader r = null;
		BufferedReader br = null;
		List<String> list = new ArrayList<String>();
		try {
			r = new FileReader("D:\\telly\\user.txt");
			br = new BufferedReader(r);
			while ((line = br.readLine()) != null) {
				char[] c = line.toCharArray();
				int first = (int) c[0];
				if (first == 65279) {
					line = new String(c, 1, c.length - 1);
				}
				list.add(line);
			}
			if (list.contains(value)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
