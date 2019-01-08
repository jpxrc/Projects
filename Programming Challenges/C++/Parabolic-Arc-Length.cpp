/*
Kata Name: Parabolic Arc Length
Problem Task: We want to approximate the length of a curve representing a function y = f(x) with a<= x <= b. First, we split the interval [a, b] into n sub-intervals with widths h1, h2, ... , hn by defining points x1, x2 , ... , xn-1 between a and b. This defines points P0, P1, P2, ... , Pn on the curve whose x-coordinates are a, x1, x2 , ... , xn-1, b and y-coordinates f(a), f(x1), ..., f(xn-1), f(b) . By connecting these points, we obtain a polygonal path approximating the curve.
Our task is to approximate the length of a parabolic arc representing the curve y = x * x with x in the interval [0, 1]. We will take a common step h between the points xi: h1, h2, ... , hn = h = 1/n and we will consider the points P0, P1, P2, ... , Pn on the curve. The coordinates of each Pi are (xi, yi = xi * xi).
The function len_curve (or similar in other languages) takes n as parameter (number of sub-intervals) and returns the length of the curve truncated to 9 decimal places.

Sample Tests:
import static org.junit.Assert.*;
import java.text.DecimalFormat;
import org.junit.Test;


public class ArcParabLenTest {
    @Test
    public void test1() {
        System.out.println("Fixed Tests: lenCurve");    
        assertEquals(1.414213562, ArcParabLen.lenCurve(1), 1e-9);
        assertEquals(1.478197397, ArcParabLen.lenCurve(10), 1e-9);
    }
}
*/

#include <iostream>
#include <iomanip>
#include <cmath>

class ArcParabLen
{
public:
    static double lenCurve(int n);
};

double ArcParabLen::lenCurve (int n){
	
	double l(0), x0(0), x1(0), y0(0), y1(0), h;
	
	h = 1 / (double) n;
	
	for(int i = 0; i < n; i++) {
		
		x0 = i * h;
		y0 = pow(x0, 2);

		x1 = x0 + h;
		y1 = pow(x1, 2);
		
		l += sqrt ( pow((y1 - y0), 2) + pow(h, 2));
	}
	 
	return l;
}