package selfPreparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IPAddressSort {

	public static void main(String[] args) {
		List<String> ips = new ArrayList<String>();
		ips.add("103.2.117.6");
		ips.add("103.2.117.70");
		ips.add("103.10.125.18");
		ips.add("103.10.125.15");
		ips.add("103.10.125.19");
		ips.add("18.255.255.255");
		ips.add("18.5.255.255");
		ips = ipSort(ips);
		for(String str: ips)
			System.out.println(str);
	}
	
	public static List<String> ipSort(List<String> ips){
		Collections.sort(ips, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				String ip1[] = o1.split("\\.");
				String ip2[] = o2.split("\\.");
				for(int i=0;i<ip1.length;i++){
					if(Integer.parseInt(ip1[i]) > Integer.parseInt(ip2[i]))
						return 1;
					else if(Integer.parseInt(ip1[i]) < Integer.parseInt(ip2[i]))
						return -1;
				}
				return 0;
			}
			
		});
		
		return ips;
	}

}
