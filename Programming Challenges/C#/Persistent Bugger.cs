/*
Kata Name: Persistent Bugger
Problem Task: Write a function, persistence, that takes in a positive parameter num and returns its multiplicative persistence, which is the number of times you must multiply the digits in num until you reach a single digit.

Sample Tests:
using System;
using NUnit.Framework;

[TestFixture]
public class PersistTests {

[Test]
  public void Test1() {
    Console.WriteLine("****** Basic Tests");    
    Assert.AreEqual(3, Persist.Persistence(39));
    Assert.AreEqual(0, Persist.Persistence(4));
    Assert.AreEqual(2, Persist.Persistence(25));
    Assert.AreEqual(4, Persist.Persistence(999));
  }
}
*/

using System;
using System.Linq;

public class Persist 
{
    public static int Persistence(long n)
        {
            if (n <= 9) return 0;

            var opCount = 0;
            var result = n.ToString().Select(t => int.Parse(t.ToString())).ToArray();

            while (result.Length != 1)
            {
                int prod = result.Aggregate(1, (a, b) => a * b);
                result = prod.ToString().Select(t => int.Parse(t.ToString())).ToArray();
                opCount++;
            }
            return opCount;
        }

}