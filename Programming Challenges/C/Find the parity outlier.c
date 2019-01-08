/*
Kata Name: Find the parity outlier
Problem Task: You are given an array (which will have a length of at least 3, but could be very large) containing integers. The array is either entirely comprised of odd integers or entirely comprised of even integers except for a single integer N. Write a method that takes the array as an argument and returns this "outlier" N.

Sample Tests:
using NUnit.Framework;
using System;

[TestFixture]
public class Tests
{
  [Test]
  public static void Test1()
  {
    int[] exampleTest1 = {2,6,8,-10,3}; 
    Assert.IsTrue(3 == Kata.Find(exampleTest1));
  }
  
  [Test]
  public static void Test2()
  {  
    int[] exampleTest2 = {206847684,1056521,7,17,1901,21104421,7,1,35521,1,7781};
    Assert.IsTrue(206847684 == Kata.Find(exampleTest2));
  }
  
  [Test]
  public static void Test3()
  {
    int[] exampleTest3 = { int.MaxValue, 0, 1 };
    Assert.IsTrue(0 == Kata.Find(exampleTest3));
  }
}
*/

#include <stdlib.h>

int find_pattern(const int *values, size_t count)
{
  int odd = 0, even = 0;
  for (int x = 0; x < count; x++)
    (values[x] % 2 == 0) ? (even)++ : (odd)++;
  return ((odd > even) ? 1 : 0);
}

int find_outlier(const int *values, size_t count)
{
  for (int x = 0; x < count; x++)
    if (find_pattern(values, count) != abs(values[x]) % 2)
      return (values[x]);
}