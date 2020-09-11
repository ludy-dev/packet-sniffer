package jsniff;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;

public class NetworkDevice {
	public List<PcapIf> DeviceList;
	public StringBuilder ErrorBuffer;
	public String localIP =null;
	
	//Find Network Device Automatically
	@SuppressWarnings("deprecation")
	public void FindNetworkDevice(){
		DeviceList = new ArrayList<PcapIf>();
		this.ErrorBuffer = new StringBuilder();
		
		int r = Pcap.findAllDevs(DeviceList, ErrorBuffer);
		if(r == Pcap.NOT_OK || DeviceList.isEmpty())
			System.err.printf("Can not read Device list %s",ErrorBuffer.toString());
		
	}
	
	//Show Network Device List 
	public void ShowNetworkDevice(){
		int i = 0;
		for(PcapIf device : DeviceList){
			String Description = (device.getDescription() != null) ? device.getDescription() : "No Description available";
			System.out.printf("#%d : %s [%s] \n", i++, device.getName(), Description);
		}
	}

	//Show Local IP Address
	public void ShowLocalIP(){
		try {
			localIP = InetAddress.getLocalHost().getHostAddress();
			System.out.println("Host IP :" +localIP);
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.out.println("Host IP :" +localIP);
		}
	}
	//Get Local IP Address
	public byte[] GetLocalIP() throws UnknownHostException{
		return InetAddress.getLocalHost().getAddress();
	}
	
}
