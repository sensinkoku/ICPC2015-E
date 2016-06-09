import java.io.*;
import java.util.*;
public class E{
	int [] a = new int[10];
	long ans = 0;
	int keta;
	long [] kaijyo = new long[15];
	long souwa, souseki, kazu;

	public void kaijyo(){
		kaijyo[0] = 1;
		for (int i = 1; i < 15;i++)	kaijyo[i] = kaijyo[i-1] * i;
	}

	public long case3(int ke) {
		long res = 0;
		if (ke == 0){return 0;}
		long pow = 1;
		for (int i = 0; i < ke-1; i++) pow*=10;
		long kaz = (long)(kazu/pow);
		kaz %= 10;
		for (int i = 0; i < 10; i++) {
		
			if(a[i] != 0) {
				if(kaz > i) {
					a[i]--;
					res += calccomb(ke-1);
					a[i]++;
				}
				if(kaz < i) break;
				if(kaz == i) {
					a[i]--;
					res += case3(ke-1);
					a[i]++;
					return res;
				}
			}
		}
		return res;
	}

	public long calccomb(int ket){
		long r = kaijyo[ket];
		for (int i = 0; i <10; i++) r /= kaijyo[a[i]];
		return r;
	}

	public int check(){
		long wa = 0, seki  =1, kaz;
		for (int i = 0; i < 10; i++)  wa += a[i]*i;
		for (int i = 0; i < 10; i++) if(a[i] != 0) {
			for (int j = 0; j < a[i]; j++) seki *=(i+1);
		}
		if(souwa < wa)  return 0;
		if(souwa > wa) 	return 1;
		if(souwa == wa && souseki > seki) return 2;
		if(souwa == wa && souseki == seki) return 3;
		return 0;
	}

	public void func(int i, int k) {
		if(i == 9) {
			a[i] = k;
			if(check() == 1 || check() == 2) ans += calccomb(keta);
			if(check() == 3)ans += case3(keta);
			return;
		}else{
		for (int j = 0; j <= k; j++) {
			a[i] = j;
			func(i+1, k-j);
			}
			return;
		}
	}

public static void main(String[] args)throws IOException {
	E ic = new E();
	Scanner scan = new Scanner(System.in);
	String s = scan.next();
	//long start = System.nanoTime();
	long kaz = Long.parseLong(s);
	ic.kazu = kaz;
	long souw = 0;
	long sousek = 1;
	while(kaz >= 1){
		souw += kaz % 10;
		sousek *= (kaz % 10 +1);
		kaz /= 10;
	}
	ic.souseki = sousek;
	ic.souwa = souw;
	ic.keta = s.length();
	ic.kaijyo();
	ic.func(0,ic.keta);
	System.out.println(ic.ans);
	//long end = System.nanoTime();
	//System.out.println((end - start)/1000000f  + "ms");
	}
}