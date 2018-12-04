/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package XtinXion;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jwuan
 */
public class CardTest {
//    
//    public CardTest() {
//    }
//
//    /**
//     * Test of getCardNum method, of class Card.
//     */
//    @Test
//    public void testGetCardNum() {
//    }
//
//    /**
//     * Test of getTitle method, of class Card.
//     */
//    @Test
//    public void testGetTitle() {
//    }
//
//    /**
//     * Test of getDeck method, of class Card.
//     */
//    @Test
//    public void testGetDeck() {
//    }
//
//    /**
//     * Test of getDescription method, of class Card.
//     */
//    @Test
//    public void testGetDescription() {
//    }
//
//    /**
//     * Test of getUpCond method, of class Card.
//     */
//    @Test
//    public void testGetUpCond() {
//    }
//
//    /**
//     * Test of getLowCond method, of class Card.
//     */
//    @Test
//    public void testGetLowCond() {
//    }

    /**
     * Test of toString method, of class Card.
     */
    @Test
    public void testToString() {
        Card card = new Card("1", "TITLE", "DECK", "DESCRIPTION", "3", "5");
        String string = "1" + "\n"; 
        string = "TITLE" + "\n";
        string += "DECK" + "\n";
        string += "DESCRIPTION" + "\n";
        string += "3" + "\n";
        string += "5" + "\n";
        assertEquals(string, card.toString());
    }
    
}
