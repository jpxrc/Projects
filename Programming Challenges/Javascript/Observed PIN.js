/*
Kata Name: The Observed PIN
Problem Task: Alright, detective, one of our colleagues successfully observed our target person, Robby the robber. We followed him to a secret warehouse, where we assume to find all the stolen stuff. The door to this warehouse is secured by an electronic combination lock. Unfortunately our spy isn't sure about the PIN he saw, when Robby entered it.

Sample Tests:
using NUnit.Framework;
using System.Collections.Generic;

public class ExampleTests
{
    [Test]
    public void TestBasic()
    {
        var expectations = new Dictionary<string, string[]>{
        { "8", new[] { "5", "7", "8", "9", "0" } },
        {"11",  new[]{"11", "22", "44", "12", "21", "14", "41", "24", "42" } },
        {"369", new[] { "339","366","399","658","636","258","268","669","668","266","369","398","256","296","259","368","638","396","238","356","659","639","666","359","336","299","338","696","269","358","656","698","699","298","236","239" } }
  };
*/

function generateKthDigit(result, neighbor, observed, temp) {
    if (temp.length == observed.length) {
        result[result.length] = temp;
        return;
    }
    var c = observed.charAt(temp.length);
    for (var i = 0; i < neighbor[c].length; ++i)
        generateKthDigit(result, neighbor, observed, temp + neighbor[c][i]);
}

function getPINs(observed) {
    var neighbor = new Array();
    neighbor["0"] = new Array(0, 8);
    neighbor["1"] = new Array(1, 2, 4);
    neighbor["2"] = new Array(1, 2, 3, 5);
    neighbor["3"] = new Array(2, 3, 6);
    neighbor["4"] = new Array(1, 4, 5, 7);
    neighbor["5"] = new Array(2, 4, 5, 6, 8);
    neighbor["6"] = new Array(3, 5, 6, 9);
    neighbor["7"] = new Array(4, 7, 8);
    neighbor["8"] = new Array(0, 5, 7, 8, 9);
    neighbor["9"] = new Array(6, 8, 9);
    
    var result = new Array();
    generateKthDigit(result, neighbor, observed, "");
    return result;
}