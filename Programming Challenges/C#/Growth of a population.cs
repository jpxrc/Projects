/*
Kata Name: Growth of a population
Problem Task: In a small town the population is p0 = 1000 at the beginning of a year. The population regularly increases by 2 percent per year and moreover 50 new inhabitants per year come to live in the town. How many years does the town need to see its population greater or equal to p = 1200 inhabitants?
More generally given parameters:
p0, percent, aug (inhabitants coming or leaving each year), p (population to surpass)
the function nb_year should return n number of entire years needed to get a population greater or equal to p.
aug is an integer, percent a positive or null number, p0 and p are positive integers (> 0)

Sample Tests:
using System;
using NUnit.Framework;

[TestFixture]
public static class ArgeTests {

    private static void testing(int actual, int expected) {
        Assert.AreEqual(expected, actual);
    }

[Test]
    public static void test1() {
        Console.WriteLine("Testing NbYear");
        testing(Arge.NbYear(1500, 5, 100, 5000),15);
        testing(Arge.NbYear(1500000, 2.5, 10000, 2000000), 10);
        testing(Arge.NbYear(1500000, 0.25, 1000, 2000000), 94);
    }
}
*/


using System;

class Arge {
    
    public static int NbYear(int p0, double percent, int aug, int p) {
        int years = 0;
        int current_p = p0;
        
        while(current_p < p)
        {
          years += 1;
          current_p += (int)(current_p*(percent/100)) + aug;
        }
        return years;
    }
}