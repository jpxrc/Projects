/*
Kata Name: Can you get the loop?
Problem Task: You are given a node that is the beginning of a linked list. This list always contains a tail and a loop.
Your objective is to determine the length of the loop.

Sample Tests:
using NUnit.Framework;

[TestFixture]
public class Tests {
  [Test]
  public  void FourNodesWithLoopSize3(){
    var n1 = new LoopDetector.Node();
    var n2 = new LoopDetector.Node();
    var n3 = new LoopDetector.Node();
    var n4 = new LoopDetector.Node();
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n2;
    Assert.AreEqual(3,Kata.getLoopSize(n1));
  }
  
    [Test]
  public  void RandomChainNodesWithLoopSize30(){
    var n1 = LoopDetector.createChain(3,30);
    Assert.AreEqual(30,Kata.getLoopSize(n1));
  }
  
  [Test]
  public  void RandomLongChainNodesWithLoopSize1087(){
    var n1 = LoopDetector.createChain(3904,1087);
    Assert.AreEqual(1087,Kata.getLoopSize(n1));
  }
}
*/

using System;
using System.Linq;
using System.Collections.Generic;

public class Kata{
  public static int getLoopSize(LoopDetector.Node node)
	{
		var positions = new Dictionary<LoopDetector.Node, int>();

		// assign the node positions and find the first node of the loop
		int i = 1;
		while (positions.ContainsKey(node) == false)
		{
			positions.Add(node, i++);
			node = node.next;
		}

		// get the last node's position
		var total_nodes = positions.Values.Last();

		// obtain the number of nodes in the loop
		var nodes_in_loop = total_nodes - positions[node] + 1;

		return nodes_in_loop;
	}
}