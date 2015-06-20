package leetcode;

public class AddBinary {
	public static String addBinary(String a,String b){
		String result="";
		int newLength=a.length();
		if (b.length()>newLength){
			newLength=b.length();
			int anotherLength=a.length();
			for(int i=0;i<newLength-anotherLength;i++){
				a='0'+a;
			}
		}
		else{
			int anotherLength=b.length();
			for(int i=0;i<newLength-anotherLength;i++){
				b='0'+b;
			}
		}
		int carry=0;
		for(int i=newLength-1;i>=0;i--){
			if(a.charAt(i)=='1'&&b.charAt(i)=='1'){
				if (carry==0) result="0"+result;
				else result="1"+result;
				carry=1;
			}
			else if(a.charAt(i)=='0'&&b.charAt(i)=='0'){
				if(carry==0) result="0"+result;
				else{
					result="1"+result;
					carry=0;
				}
			}
			else{
				if(carry==0) result="1"+result;
				else{
					result="0"+result;
					carry=1;
				}
			}
		}
		if (carry==1) result="1"+result;
		return result;
	}
	public static void main(String[] args){
		//expected:100
		System.out.println(addBinary("1010","1011"));
		
	}
}
