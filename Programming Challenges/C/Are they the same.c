/*
Kata Name: Are they the "same"?
Problem Task: Given two arrays a and b write a function comp(a, b) (compSame(a, b) in Clojure) that checks whether the two arrays have the "same" elements, with the same multiplicities. "Same" means, here, that the elements in b are the elements in a squared, regardless of the order.

Sample Tests:
import static org.junit.Assert.*;
import org.junit.Test;


public class AreSameTest {

  @Test
  public void test1() {
    int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
    int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
    assertEquals(true, AreSame.comp(a, b)); 
  }
}
*/

#include <stdbool.h>
#include <stddef.h>

#define true  1
#define false 0

bool comp(int* a, int* b, size_t sizeArray) {
  bool match_found = true;
  int x;
  int b_array_matches = 0;
  if (a == NULL || b == NULL)
    return (false);
  for (x = 0; x < sizeArray && match_found == true; x++) {
  match_found = false;
    for (int y = 0; y < sizeArray && match_found == false; y++) { 
      if ((a[x] * a[x]) == b[y]) {
        match_found = true;
        b[y] = -1;
      }
    }
  }
  if (x == sizeArray && match_found == true)
    return (true);
  else
    return (false);
}