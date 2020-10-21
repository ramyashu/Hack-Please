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