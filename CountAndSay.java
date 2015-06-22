package leetcode;

public class CountAndSay {
	
	public static String countAndSay(int n){
		if (n<=0) return "";
		String result="1";
		for(int i=1;i<n;i++){
			StringBuilder res=new StringBuilder();
			int count=1;
			//reading
			for(int j=1;j<result.length();j++){
				if(result.charAt(j-1)==result.charAt(j)){
					count++;
				}
				else{
					res.append(count);
					res.append(result.charAt(j-1));
					count=1;
				}
			}
			res.append(count);
			res.append(result.charAt(result.length()-1));
			result=res.toString();
		}
		return result;
	}
	
	public static void main(String[] args){
		System.out.println(countAndSay(3));
		System.out.println(countAndSay(4));
		System.out.println(countAndSay(5));
	}
}
