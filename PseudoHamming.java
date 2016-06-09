import java.util.*;
public class PseudoHamming{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.next());
		for (int i = 0; i < n;i++) {
			String a = scan.next();
			String b = scan.next();
			int hum = 0;
			int len = a.length();
			int c00 = 0, c01 = 0, c10 = 0, cx0 = 0,cx1 = 0, coo = 0;
			for (int j = 0; j < len;j++){
				if(a.charAt(j) == b.charAt(j)) coo++;
				else if(a.charAt(j) == '0' && b.charAt(j) == '1') c01++;
				else if(a.charAt(j) == '1' && b.charAt(j) == '0') c10++;
				else if(a.charAt(j) == '?' && b.charAt(j) == '1') cx1++;
				else if(a.charAt(j) == '?' && b.charAt(j) == '0') cx0++;
			}
			if(c10<= c01 +cx1 && c01 + cx1 <=c10 + cx0){
				hum  += (c10 > c01) ? c10 : c10;
				hum += (cx1 + cx0);
			}else{
				hum = -1;
			}
		int res = i+1;
		System.out.println("Case " + res+": "+hum);	
		}
	}
}