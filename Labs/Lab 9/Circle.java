//*******************************************************
// Circle.java
//
// 
//*******************************************************
public class Circle {
	

	private double x;       // declare the private double instance  radius
	private double y;       // declare the private double instance  x
	private double r;       // declare the private double instance  y
	
	
	//----------------------------------------------
	// getX - returns the value of x
	//----------------------------------------------
	public double getX() {
        return x;
	}
	

	//----------------------------------------------
	// getY - returns the value of y
	//----------------------------------------------
	public double getY() {
        return y;
	}
	
	//----------------------------------------------
	// getRadius - returns the value of radius
	//----------------------------------------------
	public double getRadius() {
        return r;
	}

	//----------------------------------------------
	// setX - assigns a new value to x
	//----------------------------------------------
	public void setX(double X) {
	    x = X;	
	}
	

	//----------------------------------------------
	// setY - assigns a new value to y
	//----------------------------------------------
	public void setY(double Y) {
	    y = Y;	
	}	
	
	
	//----------------------------------------------
	// setRadius - assigns a new value to radius
	//----------------------------------------------
	public void setRadius(double R) {
	    if (R >= 0) {
            r = R;
        }
	}
	
	//--------------------------------------------------------
	// diameter - calculates the diameter of the circle
	//--------------------------------------------------------
	public double diameter() {
	    return 2*r;	
	}
	

	//--------------------------------------------------------
	// area - returns the area of the circle
	//--------------------------------------------------------
	public double area() {
	    return Math.PI*r*r;	
	}

	//--------------------------------------------------------
	// perimeter - returns the perimeter of the circle
	//--------------------------------------------------------
	public double perimeter() {
	    return 2*Math.PI*r;	
	}
	
	//--------------------------------------------------------
	// isUnitCircle - return true if the radius of this circle
	//                is 1 and its center is (0,0) and false
	//      	      otherwise.
	//--------------------------------------------------------
	public boolean isUnitCircle() {
	    if (x == 0 && y == 0 && r == 1) {
            return true;
        }
        else {
            return false;
        }	
	}
	
	
	//--------------------------------------------------------
	// toString - return a String representation of
	//            this circle in the following format:
	//            center:(x,y)
	//            radius: r
	//--------------------------------------------------------
	public String toString() {
        return "\ncenter: (" + x + "," + y +")\nradius: " + r;
	}

	//--------------------------------------------------------
	// equals - returns a true when the radius & center of  
	//          the input circle equals that of the circle 
	//          executing the method
	//--------------------------------------------------------

    public boolean equals(Circle anotherCircle) {
        if (x == anotherCircle.getX() && y == anotherCircle.getY() && r == anotherCircle.getRadius()) {
            return true;
        }
        else {
            return false;
        }
    }

	//--------------------------------------------------------
	// is Concentric - returns a true when the center of the 
	//                 input circle equals that of the circle 
	//                 executing the method but their radii
    //                 are not equal
	//--------------------------------------------------------

    public boolean isConcentric(Circle anotherCircle) {
        if (x == anotherCircle.getX() && y == anotherCircle.getY() && r != anotherCircle.getRadius()) {
            return true;
        }
        else {
            return false;
        }
    } 

    public double distance (Circle anotherCircle) {
        return Math.sqrt(Math.pow(x - anotherCircle.getX(),2) + Math.pow(y - anotherCircle.getY(),2));
    }

    public boolean intersects(Circle anotherCircle) {
        if (this.distance(anotherCircle) < (r + anotherCircle.getRadius())) {
            return true;
        }
        else {
            return false;
        }
    }
    

}
