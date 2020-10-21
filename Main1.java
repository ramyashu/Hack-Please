//beggar my neighbour problem
import java.util.*;
public class Main1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			String card=sc.next();
			int turn=0;
			int penalty=1;
			if(card.compareTo("#")==0) {
				break;
			}
			else {
				stack [] s1=new stack[2];
				s1[0]=new stack();
				s1[1]=new stack();
				s1[0].push(card.substring(1,2));
				
				for(int i=0;i<51;i++) {
					card=sc.next();
					//System.out.print(card.substring(1,2));
					int k3=(i%2==0?1:0);
					s1[k3].push(card.substring(1,2));
				}
				
				stack heap=new stack();
				int faceactive=0;
				while (true) {
					if(s1[turn].number==0) {
						break;
					}
					//System.out.print("hi2");
					while(penalty>0) {
						if(s1[turn].number==0) {
							break;
						}
						node temp=s1[turn].pop();
						
						//System.out.println(temp.data+" "+turn);
						heap.addrear(temp);
						if(temp.isface()) {
							//System.out.print("hi1");
							penalty=temp.penalty;
							turn=(turn==0?1:0);
							faceactive=1;
							break;
						}
						//System.out.print("hi2");
						penalty--;
						if(penalty==0 && faceactive==1) {
							//System.out.println("hi"+" "+heap.number+" "+turn);
							
							//System.out.print("hi3");
							int k=(turn==0?1:0);
							turn=(turn==0?1:0);
							penalty=1;
							s1[k].add(heap);
							faceactive=0;
							heap=new stack();
						}
						else if(penalty==0 && faceactive==0) {
							turn=(turn==0?1:0);
							penalty=1;
						}
					}
				}
				//System.out.print("hi");
				if(turn==0) {
					if(s1[1].number<10) {
						System.out.println("1"+"  "+s1[1].number);
					}
					else {
						System.out.println("1"+" "+s1[1].number);
					}
				}
				else {
					if(s1[0].number<10) {
					System.out.println("2"+"  "+s1[0].number);
					}
					else {
						System.out.println("2"+" "+s1[0].number);
					}
				}
			}
		}
	}
}
class node{
	String data;
	node next;
	node prev;
	int penalty;
	node(String d){
		data=d;
		next=null;
		prev=null;
		if(data.compareTo("K")==0) {
			penalty=3;
		}
		else if(data.compareTo("Q")==0) {
			penalty=2;
		}
		else if(data.compareTo("J")==0) {
			penalty=1;
		}
		else if(data.compareTo("A")==0) {
			penalty=4;
		}
		else {
			penalty=1;
		}
	}
	boolean isface() {
		if(data.compareTo("A")==0 || data.compareTo("K")==0 ||data.compareTo("Q")==0 ||data.compareTo("J")==0) {
			return true;
		}
		return false;
	}
	boolean isking() {
		if(data.compareTo("k")==0) {
			
			return true;
			}
		else return false;
	}
	boolean isQueen() {
		if(data.compareTo("Q")==0) {
			
			return true;
		}
		else return false;
	}
	boolean isJack() {
		if(data.compareTo("J")==0) {
			
			return true;
		}
		else return false;
	}
	boolean isAce() {
		if(data.compareTo("A")==0) {
			
			return true;
		}
		else return false;
	}
}
class stack{
	node top;
	node end;
	int number;
	stack(){
		top=end=null;
		number=0;
	}
	void push(String data) {
		node n=new node(data);
		if(top==null) {
			top=end=n;
		}
		else {
			n.next=top;
			top.prev=n;
			top=n;
		}
		number++;
	}
	node pop() {
		if(number>1) {
			node temp=top;
			top.next.prev=null;
			top=top.next;
			number--;
			return temp;
		}
		else if(number==1) {
			node temp=top;
			top=end=null;
			number--;
			return temp;
		}
		else {
			return null;
		}
	}
	void addrear(String data) {
		node n=new node(data);
		if(top==null) {
			top=end=n;
		}
		else {
			n.prev=end;
			end.next=n;
			end=n;
		}
		number++;
	}
	void addrear(node n) {
		//node n=new node(data);
		if(top==null) {
			top=end=n;
		}
		else {
			n.prev=end;
			end.next=n;
			end=n;
		}
		number++;
	}
	void add(stack t) {
		if(end!=null) {
		end.next=t.top;
		t.top.prev=end;
		end=t.end;
		number=number+t.number;
		}
		else {
			top=t.top;
			end=t.end;
			number=number+t.number;
		}
	}
	boolean isempty() {
		return number==0;
	}
	
	
}

class codezin {
	static long []fac=new long[20];
	public static void main(String[] args) throws IOException{
		String[] arg=new String[] {"a"};
        int[] marr=new int[] {1,8,9,4,5,17,8,55,12,0};
        int[] marr2=new int[] {1,8,9,4,5};
		first f=new first();
		stack_arr obj=new stack_arr(10);
		//f.mergesortrec(marr, 0, marr.length-1);
		//f.mergesortitr(marr);
		stack_arr.main(arg);
	}
	
}
class first{
	public void mergesortrec(int[] arr,int l,int r) {
		if(l<r) {
			//System.out.println("hi");
			int mid=(l+r)/2;
			mergesortrec(arr,l,mid);
			mergesortrec(arr,mid+1,r);
			merge(arr,l,mid,r);
		}
	}
	public void mergesortitr(int[]arr) {
		for(int len=1;len<arr.length;len*=2) {
			for(int lo=0;lo<arr.length-len;lo+=2*len) {
				merge(arr,lo,lo+len-1,Math.min(lo+len+len-1, arr.length-1));
			}
		}
	}
	public void merge(int[] arr,int lo,int mid,int hi) {
		int l=lo;int h=mid+1;
		int[] left=new int[mid-lo+1];
		int[] right=new int[hi-mid];
		for(int i=0;i<mid-lo+1;i++) {
			left[i]=arr[l+i];
			
		}
		for(int i=0;i<hi-mid;i++) {
			right[i]=arr[h+i];
		}
		int k=l;
		l=0;h=0;
		while(l<mid-lo+1 && h<hi-mid) {
			
			if(left[l]<=right[h]) {
				arr[k]=left[l];
				l++;
			}
			else {
				arr[k]=right[h];
				h++;
			}
			k++;
		}
		while(l<mid-lo+1) {
			arr[k]=left[l];
			l++;k++;
		}
		while(h<hi-mid) {
			arr[k]=right[h];
			k++;h++;
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		int t=Integer.parseInt(reader.readLine().trim());
		while(t-->0) {
			String[] inp=reader.readLine().trim().split("\\s+");
			int n=Integer.parseInt(inp[0]);int k=Integer.parseInt(inp[1]);
			String[] arr=reader.readLine().trim().split("\\s+");
			int[] peak=new int[n];
			peak[0]=0;peak[n-1]=0;
			for(int i=1;i<n-1;i++) {
				int arri=Integer.parseInt(arr[i]);int arrim=Integer.parseInt(arr[i-1]);
				int arrip=Integer.parseInt(arr[i+1]);
				if(arri>arrim && arri>arrip) {
					peak[i]=1;
				}
				else peak[i]=0;
			}
			int[] prefix=new int[n];
			prefix[0]=0;
			for(int i=1;i<n;i++) {
				prefix[i]=prefix[i-1]+peak[i];
			}
			int lo=0;
			int maxno=0;
			for(int i=0;i<n-k+1;i++) {
				int atlo=prefix[i];int athi=prefix[i+k-1];
				if(peak[i]==1) {
					atlo--;
					athi--;
				}
				if(peak[i+k-1]==1) {
					athi--;
				}
				int ans=athi-atlo;
				if(ans>maxno) {
					maxno=ans;
					lo=i;
				}
			}
			writer.write((maxno+1)+" "+(lo+1)+"\n");
		}
		writer.close();
		
	}
}
class stack_arr{
	public static void main(String[] args) {
		stack_arr st=new stack_arr(2);
		st.push(8);st.push(9);st.pop();st.push(5);st.peek();st.push(10);st.pop();st.peek();
	}
	int[] arr;
	int top;
	int len;
	stack_arr(int max){
		arr=new int[max];
		top=-1;
		len=max;
	}
	boolean isempty() {
		if(top==-1) return true;
		return false;
	}
	int pop() {
		if(top==-1) return -1;
		int temp=top;
		top--;
		return arr[temp];
	}
	void push(int k) {
		if(top+1<len) {
			arr[++top]=k;
		}
	}
	int peek() {
		System.out.println(arr[top]);
		return arr[top];
	}
}
