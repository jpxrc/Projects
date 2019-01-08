/*
Kata Name: Buying a Car
Problem Task: A man has a rather old car being worth $2000. He saw a secondhand car being worth $8000. He wants to keep his old car until he can buy the secondhand one.
He thinks he can save $1000 each month but the prices of his old car and of the new one decrease of 1.5 percent per month. Furthermore this percent of loss increases by 0.5 percent at the end of every two months. Our man finds it difficult to make all these calculations.
How many months will it take him to save up enough money to buy the car he wants, and how much money will he have left over?

Sample Tests:
using System;
using NUnit.Framework;

[TestFixture]
public class BuyCarTests {

[Test]
  public void Test1() {
    int[] r = new int[] { 6, 766 };
    Assert.AreEqual(r, BuyCar.nbMonths(2000, 8000, 1000, 1.5));
  }
[Test]
  public void Test2() {
    int[] r = new int[] { 0, 4000 };
    Assert.AreEqual(r, BuyCar.nbMonths(12000, 8000, 1000, 1.5));
  }
}

*/

int* nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth)
{
  int *return_this = malloc(8); return_this[0] = -1; return_this[1] = -1;
  double amount_saved = 0.0;
  int months = 0;
  double old_car_price = startPriceOld, new_car_price = startPriceNew;
  double percent_loss = percentLossByMonth;

  for (; return_this[0] == -1; months++) {
    if (new_car_price <= old_car_price + amount_saved) {
      return_this[0] = months;
      return_this[1] = round(old_car_price - new_car_price + amount_saved);
      return (return_this);
    }
    old_car_price *= 1.0 - (percent_loss / 100.0);
    new_car_price *= 1.0 - (percent_loss / 100.0);
    percent_loss += (months % 2 == 0) ? 0.5 : 0.0;
    amount_saved += savingperMonth;
  }
}