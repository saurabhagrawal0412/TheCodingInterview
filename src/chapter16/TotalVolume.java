package chapter16;

public class TotalVolume {

	public static void main(String[] args) {
		TotalVolume obj = new TotalVolume() ;
		//int heights[] = null ;
		//int heights[] = {1} ;
		//int heights[] = {1, 0, 2, 0, 6, 0, 5, 0, 4} ;
		int heights[] = {5, 0, 4, 0, 1, 0, 2, 0, 6} ;
		
		try {
			int totalVolume = obj.getTotalVolume(heights) ;
			System.out.println("totalVolume = " + totalVolume) ;
		}
		catch(NullInputException e) {
			System.out.println(e.getMessage()) ;
		}
		
	}
	
	int getTotalVolume(int[] heights) throws NullInputException {
		if(heights == null || heights.length == 0) {
			throw new NullInputException() ;
		}
		else if(heights.length == 1) {
			return 0 ;
		}

		int submerged = removeSubmerged(heights) ;
		int totalVolume = calculateTotalVolume(heights) ;
		totalVolume -= submerged ;
		return totalVolume ;
	}

	private int removeSubmerged(int[] heights) {
		int fPtr = 1, bPtr = heights.length-2 ;
		int fMax = heights[0], bMax = heights[heights.length-1] ; 
		int submerged = 0 ;
		while(fPtr != bPtr) {
			if(heights[fPtr] < heights[bPtr]) {
				if(heights[fPtr] <= fMax) {
					System.out.println("Removing fPtr = " + fPtr + " where value = " + heights[fPtr]) ;
					submerged += heights[fPtr] ;
					heights[fPtr] = 0 ;
				}
				else {
					fMax = heights[fPtr] ;
				}
				fPtr++ ;
			}
			else {
				if(heights[bPtr] <= bMax) {
					System.out.println("Removing bPtr = " + bPtr + " where value = " + heights[bPtr]) ;
					submerged += heights[bPtr] ;
					heights[bPtr] = 0 ;
				}
				else {
					bMax = heights[bPtr] ;
				}
				bPtr-- ;
			}
		}
		if(heights[fPtr] < fMax && heights[fPtr] < bMax) {
			submerged += heights[fPtr] ;
			heights[fPtr] = 0 ;
		}
		System.out.println("submerged = " + submerged) ;
		return submerged ;
	}

	private int calculateTotalVolume(int[] heights) {
		int totalVol = 0 ;
		int prev = 0 ;
		int currVol ;

		for(int curr=1 ; curr<heights.length ; curr++) {
			if(heights[curr] != 0) {
				currVol = (curr-prev-1) * minBetween(heights[curr], heights[prev]) ;
				totalVol += currVol ;
				prev = curr ;
			}
		}
		System.out.println("totalVol = " + totalVol) ;
		return totalVol ;
	}

	private int minBetween(int height1, int height2) {
		return (height1 < height2) ? height1 : height2 ;
	}
}
