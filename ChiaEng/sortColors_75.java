import java.util.ArrayList;
import java.util.List;


public class sortColors_75 {

	public void sortColors(int[] nums){
		
		if(nums==null) return;
		
		int	zeroCount=0;
		int oneCount=0;
		int twoCount=0;
		
		for(int n : nums){
			if(n==0){
				zeroCount++;
			}else if(n==1){
				oneCount++;
			}else if(n==2){
				twoCount++;
			}
		}
		
		int arrayCount=0;
		for(int i=0;i<zeroCount;i++){
			nums[arrayCount]=0;
			arrayCount++;
		}
		
		for(int i=0;i<oneCount;i++){
			nums[arrayCount]=1;
			arrayCount++;
		}
		
		for(int i=0;i<twoCount;i++){
			nums[arrayCount]=2;
			arrayCount++;
		}
		
	}
	
}
