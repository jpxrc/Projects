/*
Kata Name: Directions Reduction
Problem Task: Write a function dirReduc which will take an array of strings and returns an array of strings with the needless directions removed (W<->E or S<->N side by side).

Sample Tests:
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runners.JUnit4;

public class DirReductionTest {
  @Test
  public void testSimpleDirReduc() {        
    assertArrayEquals("\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"",
          new String[]{"WEST"},
          DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));
    assertArrayEquals("\"NORTH\",\"SOUTH\",\"SOUTH\",\"EAST\",\"WEST\",\"NORTH\"",
          new String[]{},
          DirReduction.dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"}));
  }
}
*/

function DirReduction(arr) {
    var result = new Array();
    var match = {"NORTH" : "SOUTH", "SOUTH" : "NORTH", "EAST" : "WEST", "WEST" : "EAST"};
    
    for (var i = 0; i < arr.length; ++i) {
        var curr = arr[i];
        if (result.length == 0 || result[result.length - 1] != match[curr])
            result[result.length] = curr;
        else
            result.pop();
    }
    return result;
}