
public class Solution {
public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> subset= new ArrayList<Integer>();                     
    res.add(subset);
    if(nums==null || nums.length==0){
        return res;
    }
        
    Arrays.sort(nums);
    int start = 0;
    for(int i=0;i<nums.length;i++)
    {
        int size = res.size();
        for(int j=start;j<size;j++)
        {
            ArrayList<Integer> newItem = new ArrayList<Integer>(res.get(j));
            newItem.add(nums[i]);
            res.add(newItem);
        }
        if(i<nums.length-1 && nums[i]==nums[i+1])
        {
            start = size;
        }
        else
        {
            start = 0;
        }
    }
    return res;
    }
}

/*


public class Solution {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
		
    	Arrays.sort(nums);
    	List<List<Integer>> wholeSets= new ArrayList<List<Integer>>();
    	List<Integer> subset= new ArrayList<Integer>();
    	wholeSets.add(subset);
    	dfs(0,wholeSets,nums);
    	return wholeSets;
	        
    }

    
    public static 	List<List<Integer>> dfs(Integer index, List<List<Integer>> aWholeSets,int[] nums){
    	int lastRoundNum=-1;
    	int newSetStartIndex=0;
    	
    	for(;index<nums.length;index++){
    		
    		if(nums[index]==lastRoundNum){
    			int length=aWholeSets.size();
    			int StartIndex=newSetStartIndex;
    			newSetStartIndex=length;
    			for(int j=StartIndex;j<length;j++){
        			List<Integer> subset=new ArrayList<>(aWholeSets.get(j));
        			subset.add(nums[index]);
        			aWholeSets.add(subset);
        		}
    		}else{
    			int length=aWholeSets.size();
        		newSetStartIndex=length;
        		for(int i=0;i<length;i++){
        			List<Integer> subset=new ArrayList<>(aWholeSets.get(i));
        			subset.add(nums[index]);
        			aWholeSets.add(subset);
        		}
        	}
    	
    		lastRoundNum=nums[index];
    		
    		
    	}
    	
    	return aWholeSets;
    }
}
*/