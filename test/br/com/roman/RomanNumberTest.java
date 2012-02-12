/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.roman;

import java.util.HashMap;
import java.util.Map;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author Jesjobom
 */
public class RomanNumberTest extends TestCase {
    
    @Test
    public void testConstructorString_SUCCESS() throws RomanNumberException {
        String testValues[] = {"III", "XVI", "IX", "LXVIII", "CDXLIV", "MMMCDXLIV", "MMMDCCCLXXXVIII"};
        
        for(int i=0; i<testValues.length; i++) {
            assertNotNull(new RomanNumber(testValues[i]));
        }
    }
    
    @Test
    public void testConstructorString_FAILURE() {
        String testValues[] = {"1", "A", "IIII", "IVI", "LL", "XCL", "XD"};
        
        for(int i=0; i<testValues.length; i++) {
            try {
                new RomanNumber(testValues[i]);
                fail();
            } catch (RomanNumberException ex) {
            }
        }
    }
    
    @Test
    public void testValueConvert_SUCCESS() throws RomanNumberException {
        Map<String, Integer> testPairs = new HashMap<String, Integer>();
        testPairs.put("I", 1);
        testPairs.put("III", 3);
        testPairs.put("XVI", 16);
        testPairs.put("XC", 90);
        testPairs.put("CMXCIX", 999);
        testPairs.put("CDXLIV", 444);
        testPairs.put("MMMDCCCLXXXVIII", 3888);
        
        for(String key : testPairs.keySet()) {
            int value = RomanNumber.valueOf(key);
            assertEquals(testPairs.get(key).intValue(), value);
        }
    }
    
    @Test
    public void testRomanConvert_SUCCESS() {
        Map<String, Integer> testPairs = new HashMap<String, Integer>();
        testPairs.put("I", 1);
        testPairs.put("III", 3);
        testPairs.put("XVI", 16);
        testPairs.put("XC", 90);
        testPairs.put("CMXCIX", 999);
        testPairs.put("CDXLIV", 444);
        testPairs.put("MMMDCCCLXXXVIII", 3888);
        
        for(String key : testPairs.keySet()) {
            String roman = RomanNumber.valueOf(testPairs.get(key).intValue());
            assertEquals(key, roman);
        }
    }
}
