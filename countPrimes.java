package leetcode;

public class CountPrimes {
	public static int countPrimes(int n){
		if(n<=1) return 0;
		boolean[] boolArr=new boolean[n];
		for(int i=2;i<n;i++){
			boolArr[i]=true;
		}
		for(int i=2;i<n;i++){
			for(int j=i+i;j<n;j+=i){
				boolArr[j]=false;
			}
		}
		int count=0;
		for(int i=2;i<n;i++){
			if(boolArr[i]){
				 count++;
			}
		}
		return count;
	}
	public static void main(String[] args){
		System.out.println(countPrimes(15));
	}
}
