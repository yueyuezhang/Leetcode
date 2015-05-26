package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public static List<List<Integer>> generate(int numRows){
		List <List<Integer>> result=new ArrayList<List<Integer>>();
		if(numRows<=0) return result;
		List<Integer> one=new ArrayList<Integer>();
		List<Integer> second=new ArrayList<Integer>();
		second.add(1);
		second.add(1);
		one.add(1);
		List<Integer> parentList=new ArrayList<Integer>();
		parentList=second;
		if(numRows==1){
			result.add(one);
		}
		else if(numRows==2){
			result.add(one);
			result.add(second);
		}
		else{
			result.add(one);
			result.add(second);
			for(int i=3;i<numRows+1;i++){
				List<Integer> subList=new ArrayList<Integer>();
				subList.add(1);
				for(int j=1;j<i-1;j++){
					subList.add(parentList.get(j-1)+parentList.get(j));
				}
				subList.add(1);
				result.add(subList);
				parentList=subList;
			}
		}
		return result;
	}
	public static void printList(List<List<Integer>> list){
		for(List<Integer> l:list){
			System.out.print("[");
			for(Integer i:l){
				System.out.print(i+", ");
			}
			System.out.print("]");
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		List <List<Integer>> result=generate(5);
		printList(result);
	}
}
