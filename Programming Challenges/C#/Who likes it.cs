/*
Kata Name: Who likes it?
Problem Task: You probably know the "like" system from Facebook and other pages. People can "like" blog posts, pictures or other items. We want to create the text that should be displayed next to such an item.

Sample Tests:
namespace Solution 
{
  using NUnit.Framework;
  using System;

  [TestFixture]
  public class SolutionTest
  {
    [Test, Description("It should return correct text")]
    public void SampleTest()
    {
      Assert.AreEqual("no one likes this", Kata.Likes(new string[0]));
      Assert.AreEqual("Peter likes this", Kata.Likes(new string[] {"Peter"}));
      Assert.AreEqual("Jacob and Alex like this", Kata.Likes(new string[] {"Jacob", "Alex"}));
      Assert.AreEqual("Max, John and Mark like this", Kata.Likes(new string[] {"Max", "John", "Mark"}));
      Assert.AreEqual("Alex, Jacob and 2 others like this", Kata.Likes(new string[] {"Alex", "Jacob", "Mark", "Max"}));
    }
  }
}
*/

using System;

public static class Kata
{
  public static string Likes(string[] name)
        {
            int numNames = name.Length;
            string result = "";

            switch (numNames)
            {
                case 0:
                    result = "no one likes this";
                    break;
                case 1:
                    result = $"{name[0]} likes this";
                    break;
                case 2:
                    result = $"{name[0]} and {name[1]} like this";
                    break;
                case 3:
                    result = $"{name[0]}, {name[1]} and {name[2]} like this";
                    break;
                case 4:
                    result = $"{name[0]}, {name[1]} and 2 others like this";
                    break;
                default:
                    result = $"{name[0]}, {name[1]} and {numNames-2} others like this";
                    break;
            }

            return result;
        }
}