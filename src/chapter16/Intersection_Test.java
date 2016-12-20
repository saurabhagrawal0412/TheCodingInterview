package chapter16;

public class Intersection_Test {

	public static void main(String[] args) {
		
	}
}

class IntersectionFinder {
	static Point findIntersection(Line line1, Line line2) {
		return null ;
	}
}

class Line {
	Point a ;
	Point b ;
}

class Point {
	int x ;
	int y ;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}