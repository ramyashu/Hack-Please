package end2;
//package code1;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
 

public class myrama {
	public static void main (String args[]) throws IOException {
		
		 
		
				Scanner sc=new Scanner(System.in);
				int t=sc.nextInt();
				for(int i=0;i<t;i++) {
					int m=sc.nextInt();
					long k1=1000000007;
					int n=sc.nextInt();
					long  sum1=0;
					long sum2=0;
					long[] arr=new long[Math.max(2, n)];
					for(int j=0;j<m;j++) {
						long y=sc.nextLong();
						sum1=(sum1+y)%k1;
					}
					for(int j1=0;j1<m;j1++) {
						long y1=sc.nextLong();
						sum2=(sum2+y1)%k1;
						
					}
					arr[0]=(sum1*m);
					arr[1]=sum2*m;
					for(int i1=2;i1<n;i1++) {
						//System.out.println("hi");
						arr[i1]=(arr[i1-1]+arr[i1-2])%k1;
					}
					
						
						//long k1=1000000007;
						//long lo=(new Double(k)).longValue()*3*3;
						//long po=lo%k1;
						long result=((arr[n-1]));
						System.out.println(result);
					
					
				}
				//sc.close();
			}
		
	}

class graph{
	int N;
	long [][] g;
	long[] dist;
	heap h;
	long sum;
	boolean visited[];
	int[] parent;
	Long inf=Long.MAX_VALUE;
	graph(int n){
		g=new long[n+1][n+1];
		dist=new long[n+1];
		parent=new int[n+1];
		visited=new boolean[n+1];
		for(int i=1;i<=n;i++) {
			dist[i]=inf;
			parent[i]=0;
			visited[i]=false;
		}
		h=new heap(N);
		N=n;
		sum=0;
	}
	void clac() {
		dist[1]=0;
		
		for(int i=0;i<N;i++) {
			int k=min(dist);
			//System.out.print(min(dist));
			visited[k]=true;
			for(int y=1;y<=N;y++) {
				
				if(g[k][y]<=dist[y] && visited[y]!=true && g[k][y]!=0) {
					//System.out.println("ju");
					dist[y]=g[k][y];
					parent[y]=k;
				}
			}
		}
		
		for(int i1=1;i1<=N;i1++) {
			sum+=g[parent[i1]][i1];
		}
		//System.out.println(sum);
	}
	int min(long[] arr) {
		long min=Long.MAX_VALUE;
		int k=-1;
		for(int y=0;y<arr.length;y++) {
			if(arr[y]<min && visited[y]==false) {
				min=arr[y];
				k=y;
			}
		}
		return k;
	}
}
class heap{
	int[] h;
	int size;
	heap(int n) {
		h=new int[n+1];
		size=0;
	}
	int parent(int child) {
		return (child-1)/2;
	}
	int child(int parent,int k) {
		int w1=parent*2+k;
		if(w1<size) {
			return w1;
		}
		else {
			return -1;
		}
	}
	int min(int parent) {
		int w1=child(parent,1);
		int w2=child(parent,2);
		if(w1<size && w2<size && h[w1]<=h[w2]) {
			return w1;
		}
		else if(w1<size && w2<size && h[w1]>h[w2]) {
			return w2;
		}
		else if(w1<size) {
			return w1;
		}
		else if(w2<size){
			return w2;
		}
		else 
			return -1;
	}
	void insert(int data) {
		h[size++]=data;
		heapup(size-1);
	}
	void heapup(int index) {
		int w=h[index];
		while(index>0 && h[index]<h[parent(index)]) {
			h[index]=h[parent(index)];
			index=parent(index);
		}
		h[index]=w;
	}
	void heapdown(int root) {
		int w=h[root];
		while(root<size) {
			if(child(root,1)!=-1 && min(root)!=-1) {
				if((h[root]>h[child(root,1)] && child(root,1)!=-1))  {
					h[root]=h[min(root)];
		
					root=min(root);
				}
				else break;
			}
				else if( child(root,2)!=-1 && min(root)!=-1) {
					if((h[root]>h[child(root,2)])){
						h[root]=h[min(root)];
						root=min(root);
					}
					else 
						break;
				}
			
			
			else
				break;
		}
		h[root]=w;
	}
	int delete() {
		int temp=h[0];
		h[0]=h[size-1];
		size--;
		heapdown(0);
		return temp;
	}
	void print() {
		for(int i=0;i<size;i++) {
			System.out.print(h[i]+" ");
		}
	}
}
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
    static long nextLong() throws IOException{
    	return Long.parseLong( next());
    }
}
