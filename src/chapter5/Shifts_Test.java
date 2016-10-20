package chapter5;

public class Shifts_Test {

	public static void main(String[] args) {
		Shifts_Test obj = new Shifts_Test() ;
		int a= 1024 , b= -1024 ;
		int shifts = 4 ;
		
		System.out.println("a= " + a + " After arithmetic right shift by " + shifts + ", value becomes " + obj.repetedArithmeticShifts(a, shifts)) ;
		System.out.println("a= " + a + " After logical right shift by " + shifts + ", value becomes " + obj.repetedLogicalShifts(a, shifts)) ;
		
		System.out.println("b= " + b + " After arithmetic right shift by " + shifts + ", value becomes " + obj.repetedArithmeticShifts(b, shifts)) ;
		System.out.println("b= " + b + " After logical right shift by " + shifts + ", value becomes " + obj.repetedLogicalShifts(b, shifts)) ;

	}
	
	private int repetedArithmeticShifts(int num, int count) {
		for(int i=1 ; i<=count ; i++) {
			num = num >> 1 ;
		}
		return num ;
	}
	
	private int repetedLogicalShifts(int num, int count) {
		for(int i=1 ; i<=count ; i++) {
			num = num >>> 1 ;
		}
		return num ;
	}
}
