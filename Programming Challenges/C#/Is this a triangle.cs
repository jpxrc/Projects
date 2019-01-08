/*
Kata Name: Is this a triangle?
Problem Task: Implement a method that accepts 3 integer values a, b, c. The method should return true if a triangle can be built with the sides of given length and false in any other case.

Sample Tests:
using NUnit.Framework;
using System;

[TestFixture]
public class TriangleTests
{
    [Test]
    public void IsTriangle_ValidPostiveNumbers_ReturnsTrue()
    {
        Assert.IsTrue(Triangle.IsTriangle(5, 7, 10));
    }
}
*/

public class Triangle
{
    public static bool IsTriangle(int a, int b, int c)
    {
        if (a == 0 | b == 0 | c == 0){
        return false;}
        if (a < 2 | b < 2 | c < 2){
        return false;}
        else{
        
        return true;}
    }
}