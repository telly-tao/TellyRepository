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
//				����ServerSocket����ָ���˿���4700
				server = new ServerSocket(4700);
				System.out.println("�����������ɹ�");
			} catch (Exception e) {
				System.out.println("��������������:" + e.getMessage());
			}
			Socket socket = null;
			try {
//				����ServerSocket��accept���������Խ��ܿͻ��˵����󣬲����ص�ǰ��Socket����,accept������������
				socket = server.accept();
			} catch (Exception e) {
				e.printStackTrace();
			}
			String line;
//			��û���Socket��������
			DataInputStream is = new DataInputStream(socket.getInputStream());

//			��û���Socket�������
			DataOutputStream os = new DataOutputStream(socket.getOutputStream());

//			��ÿ���̨����
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));

			// �ж��˺������Ƿ���ȷ
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

//			����ͻ�������
			System.out.println("Client:" + is.readUTF());

			line = sin.readLine();

//			��ͻ���д����
			while (!line.equals("exit")) {
				os.writeUTF(line);
				os.flush();
				System.out.println("Client:" + is.readUTF());
				line = sin.readLine();
			}

//			��Դ�رղ���
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
