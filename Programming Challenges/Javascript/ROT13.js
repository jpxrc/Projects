/*
Kata Name: ROT13
Problem Task: How can you tell an extrovert from an introvert at NSA? Va gur ryringbef, gur rkgebireg ybbxf ng gur BGURE thl'f fubrf.
I found this joke on USENET, but the punchline is scrambled. Maybe you can decipher it? According to Wikipedia, ROT13 (http://en.wikipedia.org/wiki/ROT13) is frequently used to obfuscate jokes on USENET.

Sample Tests:
namespace Solution
{
  using NUnit.Framework;
  using System;
  using System.Linq;

  [TestFixture]
  public class SystemTests
  { 
    [Test]
    public void Test1()
    {
      Assert.AreEqual("ROT13 example.", Kata.Rot13("EBG13 rknzcyr."));
    }
  }
}
*/

function rot13(message) {
    var secret = "";
    for (var i = 0; i < message.length; ++i) {
        var d = message.charAt(i);
        var c = d.charCodeAt(0);
        if (c >= "a".charCodeAt(0) && c <= "z".charCodeAt(0)) {
            var diff = parseInt((c - "a".charCodeAt() + 13) % 26);
            secret += String.fromCharCode("a".charCodeAt() + diff);
        } else if (c >= "A".charCodeAt(0) && c <= "Z".charCodeAt(0)) {
            var diff = parseInt((c - "A".charCodeAt() + 13) % 26);
            secret += String.fromCharCode("A".charCodeAt() + diff);
        } else
            secret += d;
    }
    return secret;
}