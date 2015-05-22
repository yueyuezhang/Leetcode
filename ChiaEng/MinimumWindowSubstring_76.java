import java.awt.print.Printable;
import java.util.HashMap;

import javax.jws.soap.SOAPBinding.Use;

public class MinimumWindowSubstring_74 {

	public static void main(String args[]) {

		System.out.print(minWindow_evolve("a", "b"));

	}
	
	public static String minWindow_evolve(String S, String T) {
		if(S==null || S.length()==0)
        return "";
	
	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    for(int i=0; i<T.length();i++)
    {
        if(map.containsKey(T.charAt(i)))
        {
            map.put(T.charAt(i),map.get(T.charAt(i))+1);
        }
        else
        {
            map.put(T.charAt(i),1);
        }
    }
    
    int left = 0;
    int right = 0;
    int miniWindow=Integer.MAX_VALUE;
    int matchCount=0;
    int windowLeft=0;
    
    while(right<S.length()){
    	
    	if(map.containsKey(S.charAt(right))){
    		map.put(S.charAt(right), map.get(S.charAt(right))-1);
    		if(map.get(S.charAt(right))>=0){
    			matchCount++;
    		}
    		
    		while(T.length()==matchCount){
    			if(right-left+1<miniWindow){
    				miniWindow=right-left+1;
    				windowLeft=left;
    			}
    			if(map.containsKey(S.charAt(left))){

		    		map.put(S.charAt(left), map.get(S.charAt(left))+1);
		    		if(map.get(S.charAt(left))>0){
		    			matchCount--;
		    		}
    				
    			}
    			left++;		
    		}
    	}
    	right++;
    	
    }
    
    if(miniWindow>S.length())  
    {  
        return "";  
    }
    
	
	
	return S.substring(windowLeft,windowLeft+miniWindow);


	}
	
/*:Algo:
1. Right bound goes first. until all words in map are collected. Big window is finished.
All the words in map was deducted. so for multiple occurred words. its hash = -x

Then left start running. once some c in map over 0.
The remain window cover no this c anymore. (small window here.)

while condition is match count not equall (in the small window, lacks of c)
 
 	
*/	
	
// over time solution ------------------------------------------
	public static String minWindow(String S, String T) {
	    if(S==null || S.length()==0)
	        return "";
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	    for(int i=0; i<T.length();i++)
	    {
	        if(map.containsKey(T.charAt(i)))
	        {
	            map.put(T.charAt(i),map.get(T.charAt(i))+1);
	        }
	        else
	        {
	            map.put(T.charAt(i),1);
	        }
	    }
	    int left = 0;
	    int count = 0;
	    int minLen = S.length()+1;
	    int minStart = 0;
	    for(int right=0; right<S.length();right++)
	    {
	        if(map.containsKey(S.charAt(right)))
	        {
	            map.put(S.charAt(right),map.get(S.charAt(right))-1);
	            if(map.get(S.charAt(right))>=0)
	            {
	                count++;
	            }
	            while(count == T.length())
	            {
	                if(right-left+1<minLen)
	                {
	                    minLen = right-left+1;
	                    minStart = left;                    
	                }
	                if(map.containsKey(S.charAt(left)))
	                {
	                    map.put(S.charAt(left), map.get(S.charAt(left))+1);
	                    if(map.get(S.charAt(left))>0)
	                    {
	                        count--;
	                    }
	                }
	                left++;
	            }
	        }
	    }
	    if(minLen>S.length())
	    {
	        return "";
	    }
	    return S.substring(minStart,minStart+minLen);
	}

}

/*:Algo:
1. Use two pointers l and r to fix the window. l starts from head to tail, once match in hashmap, 
It could be a start point of matched t.
Use r to find every matched character in s. The first found one will be shortest if starting with l.

2. move l one step more and repeat the process. but once r-l over the window size. no need to try. 
(when the shortest is the right most, this algo will take long time)
*/



/*:Mistakes:
1. when seeing the short didn't replace the long. Think of not clear hashmap (need to do it when build the map)

******************************************************
hMap=new HashMap<Character, Integer>(bkMap);
******************************************************
hmap=bkMap;  This is wrong, not duplicated a new one


*/


/*:Questions:
1. Bad coding style :(hMap.containsKey(key) && hMap.get(key) > 0) ;  //map not contain but still get


*/