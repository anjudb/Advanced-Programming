import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RandomWalk {
   int[][] adj;
     double[][] probab;
   int T; // number of steps Tony takes in the random walk 
   int n; // number of nodes
   int[] degree;
   int s; //Start node
   ArrayList<Integer> hitRate;
    
   public static void main(String[] args) {
      Solution sol1 = new Solution();
      sol1.read_matrix();
      sol1.surf();
        sol1.print();
   }

   public void read_matrix() {
      Scanner sc = new Scanner(System.in);
      n = sc.nextInt();
        s = sc.nextInt();
        int m = sc.nextInt();
      T = sc.nextInt();
      adj = new int[n][n];
         probab = new double[n][n];
      degree = new int[n];
        int sizeGraph=m;
      while(sizeGraph>0) {
         int a = sc.nextInt();
         int b = sc.nextInt();
         adj[a][b]++;
         degree[a]++;
         sizeGraph--;
       //  System.out.println("jhg");
      }
      
         for (int i = 0; i < n ; i++) {
         for (int j = 0; j < n ; j++) {
            double p =  (double)adj[i][j]/degree[i];
            //System.out.println("jhgug");
            probab[i][j] = p;
         }
      }
   }
     
    public void surf() {
    	int min = 0;
		int max = n;
		double randomNumber;
		double hint=0.0,prob=0.0;
		int anchor=0;
		hitRate=new ArrayList<Integer>();
		Random r = new Random();
		int nextRandomStop;
		for(int k=0;k<n;k++){
			hitRate.add(0);
		}
		
		hitRate.set(s,1);
		
		double cumulativeProbability=0;
		
		for(int i=0;i<T;i++){
			randomNumber=  Math.random();
			cumulativeProbability=0;
			if(degree[s]==0){
				while(degree[s]==0 ){
					s=(int)randomNumber*n;
				}
			}
			for(int j=0;j<n;j++){
				cumulativeProbability=cumulativeProbability+probab[s][j];
				if(randomNumber<=cumulativeProbability){
					s=j;
					break;
				}
			}
			int value=hitRate.get(s);
			hitRate.set(s,++value);
			
		}
    //	for(int i=0;i<n;i++)
	//		System.out.println(hitRate.get(i));
    }
  
     public void print() {
    	
    	ArrayList<Integer> hitRatedup=new ArrayList<Integer>();
         ArrayList<Integer> topBuildings=new ArrayList<Integer>();
    	 //for(int h=0;h<n;h++)
    		 //hitRatedup.add(h,hitRate[h]);
    	 int max=0;
    	 int pos=0;
    	 for(int k=0;k<3;k++){
             max=0;
             pos=0;
    	 for(int h=0;h<hitRate.size();h++){
    		 if(max<hitRate.get(h)){
    			 max=hitRate.get(h);
    			 pos=h;
    		 }
    	 }
    	 topBuildings.add(pos);
    	 hitRate.set(pos,0);
    		 
    	 }
    	 Collections.sort(topBuildings);
    	 for(int y=0;y<3;y++)
    		 System.out.print(topBuildings.get(y)+" ");
    }
}
