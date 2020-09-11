package jsniff;

import java.io.File;

public class systemControl {
	
	//JNI 관련 참조
	private static String OS = null;
	
	public static void LoadOSProperty(){
		systemControl.OS = System.getProperty("os.name").toLowerCase();
	}
	
	public static String GetOSProperty(){
		if(OS == null){
			LoadOSProperty();
			return OS;
		}else
			return OS;
	}
	
	public static int LoadLibFile(String filename){
		
			try{
				System.load(new File(filename).getAbsolutePath());
				System.out.println(new File("jnetpcap.dll").getAbsolutePath());
				return 0;
			}catch(UnsatisfiedLinkError e){
				return 1;
			}
		
		
	}
	
}
