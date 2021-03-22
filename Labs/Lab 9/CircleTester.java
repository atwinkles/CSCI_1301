//*******************************************************
// CircleTester.java
//
//
//  A client to test the functionality of objects
//  of the class Circle
// 
//*******************************************************
public class CircleTester{
	
	public static void main(String[] args) {
		
        // creates instances of the Circle class to test
		Circle circle1 = new Circle();
		Circle circle2 = new Circle();
    
        // sets the X and Y values of the circles as well as the radius
		circle1.setX(0.0);
		circle1.setY(0.0);
		circle1.setRadius(2);
		circle2.setX(2.0);
		circle2.setY(1.0);
		circle2.setRadius(1);
		System.out.println("circle1="+circle1);
		System.out.println("circle2="+circle2);
		
		// If the method setRadius is implemented correctly,
		// a call to setRadius with a negative number
		// will not change the value of the circle's radius.
		//
		circle1.setRadius(-2.0); 
		
		//
		// Reset the center of circle1 (-3.0,4.0)
		//
		circle1.setX(-3.0);
		circle1.setY(4.0);
		
		
		// print circle1 characteristics (center and radius), use a statement similar 
		// to the previous println statements. Note that is not necessary to call
		//the method toString, why?
        System.out.println("circle1=" + circle1.toString());
		
		// set the circle2 radius to 5.3
        circle2.setRadius(5.3);
		
		// print circle2 characteristics (center and radius), use a statement similar to the first and
		// second println statements
        System.out.println("circle2=" + circle2.toString());
		
		// print circle1 diameter, area and perimeter
        System.out.println("circle1 diameter=" + circle1.diameter());
        System.out.println("circle1 area=" + circle1.area());
        System.out.println("circle1 perimeter=" + circle1.perimeter());
		
		// print circle2 diameter, area and perimeter
        System.out.println("circle2 diameter=" + circle2.diameter());
        System.out.println("circle2 area=" + circle2.area());
        System.out.println("circle2 perimeter=" + circle2.perimeter());
		
		// display whether circle1 is a unit circle
		System.out.println("circle1 is a unit circle=" + circle1.isUnitCircle());
		// display whether circle2 is a unit circle
		System.out.println("circle2 is a unit circle=" + circle2.isUnitCircle());
		
		// your additional tests should be placed below here


        // test equals method
        // test one
		System.out.println("circle1="+circle1);
		System.out.println("circle2="+circle2);
        System.out.println("Does circle1 equal circle2? " + circle1.equals(circle2));
        // test two
        circle1.setRadius(5.3);
		System.out.println("circle1="+circle1);
		System.out.println("circle2="+circle2);
        System.out.println("Does circle1 equal circle2? " + circle1.equals(circle2));
        // test three
        circle1.setX(2.0);
        circle1.setY(1.0);
		System.out.println("circle1="+circle1);
		System.out.println("circle2="+circle2);
        System.out.println("Does circle1 equal circle2? " + circle1.equals(circle2));

        // test isConcentric method
        // test one
        System.out.println("Is circle1 concentric with circle2? " + circle1.isConcentric(circle2));
        // test two
        circle1.setRadius(2.1);
		System.out.println("circle1="+circle1);
		System.out.println("circle2="+circle2);
        System.out.println("Is circle1 concentric with circle2? " + circle1.isConcentric(circle2));
        // test three
        circle1.setX(2.4);
		System.out.println("circle1="+circle1);
		System.out.println("circle2="+circle2);
        System.out.println("Is circle1 concentric with circle2? " + circle1.isConcentric(circle2));

        // test distance method
        // test one
		System.out.println("circle1="+circle1);
		System.out.println("circle2="+circle2);
        System.out.println("The distance between circle1 and circle2 is " + circle1.distance(circle2));
        // test two
        circle1.setX(2.0);
		System.out.println("circle1="+circle1);
		System.out.println("circle2="+circle2);
        System.out.println("The distance between circle1 and circle2 is " + circle1.distance(circle2));
        // test three
        circle1.setX(3.4);
        circle1.setY(3.4);
		System.out.println("circle1="+circle1);
		System.out.println("circle2="+circle2);
        System.out.println("The distance between circle1 and circle2 is " + circle1.distance(circle2));
				
        // test intersects method
        // test one
		System.out.println("circle1="+circle1);
		System.out.println("circle2="+circle2);
        System.out.println("Do circle1 and circle2 intersect? " + circle1.intersects(circle2));
        // test two
        circle1.setX(8.9);
        circle1.setY(8.9);
		System.out.println("circle1="+circle1);
		System.out.println("circle2="+circle2);
        System.out.println("Do circle1 and circle2 intersect? " + circle1.intersects(circle2));
        // test three
        circle1.setX(circle2.getX());
        circle1.setY(circle2.getY());
		System.out.println("circle1="+circle1);
		System.out.println("circle2="+circle2);
        System.out.println("Do circle1 and circle2 intersect? " + circle1.intersects(circle2));
        
        

	}
	
}
