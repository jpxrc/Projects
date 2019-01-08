/*
Kata Name: Tortoise Racing
Problem Task: Two tortoises named A and B must run a race. A starts with an average speed of 720 feet per hour. Young B knows she runs faster than A, and furthermore has not finished her cabbage.
When she starts, at last, she can see that A has a 70 feet lead but B's speed is 850 feet per hour. How long will it take B to catch A?
More generally: given two speeds v1 (A's speed, integer > 0) and v2 (B's speed, integer > 0) and a lead g (integer > 0) how long will it take B to catch A?
The result will be an array [hour, min, sec] which is the time needed in hours, minutes and seconds (round down to the nearest second) or a string in some languages.
If v1 >= v2 then return nil, nothing, null, None or {-1, -1, -1} for C++, C, Go, Nim, [] for Kotlin or "-1 -1 -1".

Sample Tests:
using System;
using NUnit.Framework;

[TestFixture]
public class TortoiseTests {

    [Test]
    public void Test1() {
        Console.WriteLine("****** Basic Tests");    
        Assert.AreEqual(new int[]{0, 32, 18}, Tortoise.Race(720, 850, 70));
        Assert.AreEqual(new int[]{3, 21, 49}, Tortoise.Race(80, 91, 37));
        Assert.AreEqual(new int[]{2, 0, 0}, Tortoise.Race(80, 100, 40));
    }
}
*/

using System;
public class Tortoise
{
	public static int[] Race(int v1, int v2, int g) 
	{
		int[] result = new int[3];
    if (v1 >= v2)
    {
        return null;
    }
    
    double time = Convert.ToDouble(g)/(v2-v1);
    result[0] = Convert.ToInt16(Math.Floor(time));
    result[1] = Convert.ToInt16(Math.Floor((time*60)%60));
    result[2] = Convert.ToInt16(Math.Floor((time*3600)%60));
    return result;
	}
}