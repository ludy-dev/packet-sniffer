package jsniff;

import java.net.UnknownHostException;

public class main {

	public static void main(String[] args) throws InterruptedException, UnknownHostException {
		
		System.out.println("[ Network Device List ]");
		NetworkDevice ndv = new NetworkDevice();
		ndv.FindNetworkDevice();
		ndv.ShowNetworkDevice();
		System.out.println("\n[ System Property ]");
		ndv.ShowLocalIP();
		System.out.printf("OS Name : %s \n",systemControl.GetOSProperty());
		
		
		System.out.printf("\nStart capturing packet 'promiscuous mode' with NIC Name %s \n\n", ndv.DeviceList.get(2).getDescription());
		
		Packetcapture captureUnit = new Packetcapture("promisc",10,64,ndv.DeviceList.get(2));
		captureUnit.startPacketCapture();
		
		
	}

}
