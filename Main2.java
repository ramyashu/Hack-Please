/*import java.util.*;
public class Main2 {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		
		
		
		
		
		
		
		while(true) {
			int n=sc.nextInt();
			if(n==0) {
				break;
			}
			else {
				stack1 k=new stack1();
				stack1 k1=new stack1();
				stack1 k2=new stack1();
				for(int i=0;i<n;i++) {
					int lov=sc.nextInt();
					k.addrear(lov);
				}
				while(!k.isempty()) {
					
					node1 temp=k.pop();
					//System.out.println(temp.data);
					if(temp.data==1) {
						//System.out.println("11");
						k1.push(temp.data);
					}
					else if(temp.data!=1) {
						if(k1.isempty()) {
							if(k2.isempty()) {
								k2.push(temp.data);
							}
							else if(k2.top.data>temp.data){
								k2.push(temp.data);
							}
							else {
								
								System.out.println("no");
								break;
							}
						}
						else if(!k1.isempty()) {
							//System.out.println(temp.data+" "+k1.top.data);
							if(temp.data==(k1.top.data+1)) {
								//System.out.print("hi");
								k1.push(temp.data);
							}
							else if(k2.isempty()) {
								k2.push(temp.data);
							}
							else if(k2.top.data>temp.data) {
								k2.push(temp.data);
							}
							else if(k2.top.data==k1.top.data+1) {
								k1.push(k2.pop().data);
								k.push(temp.data);
							}
							else {
								System.out.println("no");
								break;
							}
						}
					}
				}
				if(k.isempty()) {
					System.out.println("yes");
				}
			}
		}
	}
}
class stack1{
	node1 top;
	node1 end;
	int number;
	stack1(){
		top=end=null;
		number=0;
	}
	void push(int data) {
		node1 n=new node1(data);
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
	node1 pop() {
		if(number>1) {
			node1 temp=top;
			top.next.prev=null;
			top=top.next;
			number--;
			return temp;
		}
		else if(number==1) {
			node1 temp=top;
			top=end=null;
			number--;
			return temp;
		}
		else {
			return null;
		}
	}
	void addrear(int data) {
		node1 n=new node1(data);
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
	void addrear(node1 n) {
		//node1 n=new node1(data);
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
	void add(stack1 t) {
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
class node1{
	int data;
	node1 next;
	node1 prev;
	node1(int d){
		data=d;
		next=prev=null;
	}
}*/