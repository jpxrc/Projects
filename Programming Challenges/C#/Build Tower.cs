/*
Kata Name: Build Tower
Problem Task: Build Tower by the following given argument:
number of floors (integer and always greater than 0).

Sample Tests:
namespace Solution 
{
  using NUnit.Framework;
  using System;

  [TestFixture]
  public class KataTests
  {
    [Test]
    public void BasicTests()
    {
      Assert.AreEqual(string.Join(",", new [] { "*" }), string.Join(",", Kata.TowerBuilder(1)));
      Assert.AreEqual(string.Join(",", new [] { " * ", "***" }), string.Join(",", Kata.TowerBuilder(2)));
      Assert.AreEqual(string.Join(",", new [] { "  *  ", " *** ", "*****" }), string.Join(",", Kata.TowerBuilder(3)));
    }
  }
}
*/

using System;

public static class StringExtensions{

    public static string CenterString(this string stringToCenter, int totalLength)
    {
        return stringToCenter.PadLeft(((totalLength - stringToCenter.Length) / 2) 
                            + stringToCenter.Length)
                   .PadRight(totalLength);
    }
}

public class Kata
{

  public static string[] TowerBuilder(int nFloors)
  {
    
    var floorArray = new string[nFloors];
    int width = nFloors + nFloors - 1;
    
    for(int x=1;x<=nFloors;x++){    
       var s = new String('*', x + (x-1) ).CenterString(width);    
       floorArray[x-1] = s;
    }
  
    return floorArray;
  }
}