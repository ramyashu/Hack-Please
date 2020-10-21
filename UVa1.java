import java.util.*;
public class UVa1 {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		//String inn="tamak";
		//System.out.print(inn.substring(2,5));
		for(int i=0;i<n;i++) {
			String in=sc.next();
			if(in.length()==1) {
				if(in.compareTo("0")==1 || in.compareTo("1")==1 ) {
					System.out.println("+");
				}
			}
			else if(in.length()==2) {
				if(in.compareTo("78")==0) { 
					System.out.println("+");
				}
				else if((in.compareTo("35")==0)) {
					System.out.println("-");
				}
			}
			else {
				//System.out.print(in.substring(0, 4));
				if(in.substring(in.length()-2, in.length()).compareTo("35")==0) {
					System.out.println("-");
				}
				else if(in.substring(0, 1).compareTo("9")==0 && in.substring(in.length()-1, in.length()).compareTo("4")==0) {
					System.out.println("*");
				}
				
				else if(in.substring(0, 3).compareTo("190")==0) {
					System.out.println("?");
				}
			}
		}
	}
}
