package chapter8;

import java.util.ArrayList;
import java.util.Arrays;

public class OmSolution {

	public static void main(String[] args) {
		OmSolution obj = new OmSolution() ;
		String sol = obj.solution(1,8,3,2) ;
		System.out.println(sol);
	}

/*	public String solution(int a, int b, int c, int d) {
		String solution = "" ;
		int[] timeArr = {a,b,c,d} ;
		
		Arrays.sort(timeArr) ;
		
		int[] arr2 = new int[4] ;
		
		for(int i=0 ; i<4 ; i++) {
			arr2[3-i] = timeArr[i] ;
		}
		
		for(int i: arr2)
			System.out.println(i) ;
		
		int[] arr3 = new int[100] ;
		ArrayList<Integer> tList = new ArrayList<Integer>() ;
		int m = 0 ;
		for(int i=0 ; i<4 ; i++) {
			for(int j=0 ; j<4 ; j++) {
				if(i==j)
					continue ;
				
				for(int k=0 ; k<4 ; k++) {
					if(k==i || k==j)
						continue ;
					
					for(int l = 0 ; l<4 ; l++) {
						if(l==i || l==j || l==k)
							continue ;
						
						else {
							int temp = arr2[l] + 10*arr2[k] + 100*arr2[j] + 1000*arr2[i] ;
							tList.add(temp) ;
							arr3[m] = temp ;
							m++ ;
						}
					}
				}
			}
		}
		
		for(int n : arr3)
			System.out.println(n) ;
		
		int fin = 0 ;
		for(int i=0 ; i<100 ; i++) {
			int hours = arr3[i]/100 ;
			int minutes = arr3[i]%100 ;
			
			if(hours <= 23 && minutes <= 59) {
				fin = arr3[i] ;
				break ;
			}
			
		}
		
		
		if(fin == 0) 
			solution = "NOT POSSIBLE" ;
		else {
			int hours = fin/100 ;
			int minutes = fin%100 ;
			
			String hStr = (hours<10) ? "0" + hours : "" + hours ;
			String mStr = (minutes<10) ? "0" + minutes : "" + minutes ;
			
			solution = hStr + " : " + mStr ;
		}
		//System.out.println("fin = " + fin) ;
		
		return solution ;
	}*/
	
		public String solution(int A, int B, int C, int D) {
			String solution = "" ;
			int[] tempArray = {A, B, C, D} ;
			Arrays.sort(tempArray) ;
			
			Arrays.sort(tempArray) ;
			
			int[] timeArr = new int[4] ;
			
			for(int i=0 ; i<4 ; i++) {
				timeArr[3-i] = tempArray[i] ;
			}
			
			/*for(int i: tempArray)
				System.out.println(i) ;*/
			
			ArrayList<Integer> tList = new ArrayList<Integer>() ;
			for(int i=0 ; i<4 ; i++) {
				for(int j=0 ; j<4 ; j++) {
					if(i==j)
						continue ;
					
					for(int k=0 ; k<4 ; k++) {
						if(k==i || k==j)
							continue ;
						
						for(int l = 0 ; l<4 ; l++) {
							if(l==i || l==j || l==k)
								continue ;
							
							else {
								int temp = tempArray[l] + 10*tempArray[k] + 100*tempArray[j] + 1000*tempArray[i] ;
								tList.add(temp) ;
							}
						}
					}
				}
			}
			
			for(int n : tList)
				System.out.println(n) ;
			
			int value = 0 ;
			for(int i=0 ; i<tList.size() ; i++) {
				int t = tList.get(i) ;
				int hours = t/100 ;
				int minutes = t%100 ;
				
				if(hours <= 23 && minutes <= 59) {
					value = t ;
					break ;
				}
				
			}
			
			
			if(value == 0) 
				solution = "NOT POSSIBLE" ;
			else {
				int hours = value/100 ;
				int minutes = value%100 ;
				
				String hStr = (hours<10) ? "0" + hours : "" + hours ;
				String mStr = (minutes<10) ? "0" + minutes : "" + minutes ;
				
				solution = hStr + " : " + mStr ;
			}
			//System.out.println("fin = " + fin) ;
			
			return solution ;
		}
}