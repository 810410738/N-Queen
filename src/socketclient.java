
import java.net.*;
import java.io.*;
public class socketclient {
	public static void main(String[] args) {
		Socket s = null;
		InputStream is = null;
		DataInputStream d = null;
		OutputStream os = null;
		DataOutputStream ds = null;
		try {
			s = new Socket("172.29.45.36", 1555);
			is = s.getInputStream();
			d = new DataInputStream(is);
			os = s.getOutputStream();
			ds = new DataOutputStream(os);
			System.out.println(d.readUTF() + " from " + s.getPort());
			String content = null;
			while (true) {
				content = new BufferedReader(new InputStreamReader(System.in))
						.readLine();
				ds.writeUTF("port# " + s.getLocalPort() + " says " + content
						+ " to " + s.getPort());
				ds.flush();
				if (content.equalsIgnoreCase("Bye"))
					break;
			}
		} catch (ConnectException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ds.close();
				os.close();
				d.close();
				is.close();
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}