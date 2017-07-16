import java.net.*;
import java.io.*;

public class socketserver {
	public static void main(String[] args) {
		Socket socket = null;
		OutputStream output = null;
		DataOutputStream doutput = null;
		InputStream input = null;
		DataInputStream dinput = null;
		try {
			ServerSocket ss = new ServerSocket(1555);
			socket = ss.accept();
			output = socket.getOutputStream();
			doutput = new DataOutputStream(output);
			input = socket.getInputStream();
			dinput = new DataInputStream(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			String content = null;
			doutput.writeUTF("Hello " + socket.getInetAddress() + " port#"
					+ socket.getPort());//��utf����ķ�ʽд���ַ���
			doutput.flush();
			while (true) {
				content = dinput.readUTF();
				System.out.println(content);
				if (content.equalsIgnoreCase("Bye"))
					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				doutput.close();
				output.close();
				dinput.close();
				input.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}