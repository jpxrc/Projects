/*
Kata Name: Two fighters, one winner
Problem Task: Create a function that returns the name of the winner in a fight between two fighters.
Each fighter takes turns attacking the other and whoever kills the other first is victorious. Death is defined as having health <= 0.
Each fighter will be a Fighter object/instance. See the Fighter class below in your chosen language.
Both health and damagePerAttack (damage_per_attack for python) will be integers larger than 0. You can mutate the Fighter objects.

Sample Tests:
namespace Solution {
  using NUnit.Framework;
  using System;

  [TestFixture]
  public class SolutionTest
  {
    [Test]
    public void BasicTests() {
      Assert.AreEqual("Lew", Kata.declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Lew"));
      Assert.AreEqual("Harry", Kata.declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Harry"));
      Assert.AreEqual("Harald", Kata.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harry"));        
      Assert.AreEqual("Harald", Kata.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harald"));        
      Assert.AreEqual("Harald", Kata.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Jerry"));            
      Assert.AreEqual("Harald", Kata.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Harald"));
        
    }
  }
}
*/

using System;

public class Kata
{
	public static string declareWinner(Fighter fighter1, Fighter fighter2, string firstAttacker)
	{
		var attacker = firstAttacker == fighter1.Name ? fighter1 : fighter2;
		var defender = firstAttacker == fighter1.Name ? fighter2 : fighter1;

		for (;;)
		{
			if (Attack(attacker, defender)) return attacker.Name;
			Swap(ref attacker, ref defender);
		}
	}

	static bool Attack(Fighter attacker, Fighter defender)
	{
		defender.Health -= attacker.DamagePerAttack;
		if (defender.Health <= 0) return true;
		return false;
	}

	static void Swap(ref Fighter f1, ref Fighter f2)
	{
		var t = f1; f1 = f2; f2 = t;
	}
}