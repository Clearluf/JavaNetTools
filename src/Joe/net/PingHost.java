package Joe.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class PingHost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String host="47.94.171.180";
		int port=22;
		Socket s=new Socket();
		InetSocketAddress sa=new InetSocketAddress(host, port);
		boolean r=Ping(host,2000);
		
		if(r==true) {
			try {
				s.connect(sa);
				System.out.println(host+":"+port+" is connectable.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("the port "+port+" is not open.");
			}
		}
		else {
			System.out.println("the ip is not reachable.");
		}

			
	}
	static boolean Ping(String ip,int timeout) {
		try {
			boolean status=InetAddress.getByName(ip).isReachable(timeout);
			return status;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return false;
		}
	}

}
