/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.arabic;

import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author Jesjobom
 */
public class ArabicNumberTest extends TestCase {
    
    @Test
    public void testConstructorInt_SUCCESS() {
        int value = 123;
        ArabicNumber number = new ArabicNumber(value);
        assertNotNull(number);
        assertEquals(value, number.intValue());
    }
    
    @Test
    public void testConstructorString_SUCCESS() {
        String value = "12309";
        try {
            ArabicNumber number = new ArabicNumber(value);
            assertNotNull(number);
            assertEquals(12309, number.intValue());
        } catch (ArabicNumberException ex) {
            fail();
        }
    }
    
    @Test
    public void testConstructorString_FAILURE() {
        String value = "12E";
        try {
            new ArabicNumber(value);
            fail();
        } catch (ArabicNumberException ex) {
            
        }
    }
    
    @Test
    public void testConstructorString_FAILURE2() {
        String value = "0124";
        try {
            new ArabicNumber(value);
            fail();
        } catch (ArabicNumberException ex) {
            
        }
    }
    
    @Test
    public void testToStringFromInt_SUCCESS() {
        ArabicNumber arabic = new ArabicNumber(1234);
        assertEquals("1234", arabic.toString());
    }
    
    @Test
    public void testToStringFromInt_SUCCESS2() {
        ArabicNumber arabic = new ArabicNumber(0);
        assertEquals("0", arabic.toString());
    }
    
    @Test
    public void testToStringFromString_SUCCESS() throws ArabicNumberException {
        ArabicNumber arabic = new ArabicNumber("1234");
        assertEquals("1234", arabic.toString());
    }
}
