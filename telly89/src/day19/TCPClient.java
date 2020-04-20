package day19;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {
	public static void main(String[] args) {
		try {
//			����Socket��ָ��ip��port
			Socket socket = new Socket("127.0.0.1", 4700);

//			��ü�������
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));

//			��û���Socket���������������
			DataOutputStream os = new DataOutputStream(socket.getOutputStream());
			DataInputStream is = new DataInputStream(socket.getInputStream());

			String readline;

			// ��������Ӻͷ�������¼У��Ĵ���
			while (true) {
				readline = "";
				System.out.println("�������˺�:");
				readline = sin.readLine() + ";";
				System.out.println("����������:");
				readline += sin.readLine();
				// ���͸������������ݸ�ʽ�� �˺�;����
				os.writeUTF(readline);
				os.flush();
				readline = is.readUTF();// �涨��success ��¼�ɹ� ���� ��¼ʧ��
				if (readline.equals("success"))
					break;
			}
			System.out.println("���Ժͷ����������ˣ�");
			readline = sin.readLine();
//			�������д����
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
