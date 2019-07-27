package Joe.net;

import java.net.InetAddress;

public class ScanThread extends Thread {
	String theStartIp;
	int theEnd;
	public void run() {
		String hostaddress = null;
		try {
			String initIp=theStartIp;			
			Integer lastNum=Integer.valueOf(initIp.split("\\.")[3]);
			
		for(int i=0;i<theEnd+1-lastNum;i++) {   
			String ip=initIp;
			ip=ipAdd(ip,i);
				if(ping(ip)) {
					if(!ip.equals(hostaddress)) {
						System.out.println("the reachableIp is------------------------------ "+ip);
						Thread.sleep(5000);
					}					
				}
				System.out.println("ping "+ip+" false");
				
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static boolean ping(String ipAddress) throws Exception {
        int  timeOut =  3000 ;  //��ʱӦ����3������        
        boolean status = InetAddress.getByName(ipAddress).isReachable(timeOut);     // ������ֵ��trueʱ��˵��host�ǿ��õģ�false�򲻿ɡ�
        return status;
    }
	
    private static String ipAdd(String initIp,int i) {
		// TODO Auto-generated method stub
    	Integer lastNum=Integer.valueOf(initIp.split("\\.")[3])+i;
    	return initIp=initIp.split("\\.")[0]+"."+initIp.split("\\.")[1]+"."+initIp.split("\\.")[2]+"."+String.valueOf(lastNum);
	
	}
}
