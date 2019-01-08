/*
Kata Name: Banker's Plan
Problem Task: John has some amount of money of which he wants to deposit a part f0 to the bank at the beginning of year 1. He wants to withdraw each year for his living an amount c0.

Sample Tests:
using System;
using NUnit.Framework;

[TestFixture]
public static class BankerPlanTests {

    private static void testing(Boolean actual, Boolean expected) {
        Assert.AreEqual(expected, actual);
    }

[Test]
    public static void test1() {
        Console.WriteLine("Testing Fortune");
        testing(BankerPlan.Fortune(100000, 1, 2000, 15, 1), true);
        testing(BankerPlan.Fortune(100000, 1, 9185, 12, 1), false);
        testing(BankerPlan.Fortune(100000000, 1, 100000, 50, 1), true);
        testing(BankerPlan.Fortune(100000000, 1.5, 10000000, 50, 1), false);
        testing(BankerPlan.Fortune(100000000, 5, 1000000, 50, 1), true);
    }
} 
*/

#define true  1
#define false 0
int fortune(int f0, double p, int c0, int n, double i)
{
  int cur_year = 1;
  int money_left = f0;

  for (;cur_year < n; cur_year++) {
    money_left *= 1.0 + (p / 100);
    money_left -= c0;
    money_left *= 1.0 - (i / 100);
  }
  return (cur_year == n && money_left > 0 ? true : false);
}