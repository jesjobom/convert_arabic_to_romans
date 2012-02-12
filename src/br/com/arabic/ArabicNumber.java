/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.arabic;

/**
 *
 * @author Jesjobom
 */
public class ArabicNumber extends Number {

    private final int value;
    
    private static final String format = "[1-9]\\d*";

    public ArabicNumber(int value) {
        this.value = value;
    }
    
    public ArabicNumber(String value) throws ArabicNumberException {
        this.value = valueOf(value);
    }
    
    public static int valueOf(String value) throws ArabicNumberException {
        if(!value.matches(format)) {
            throw new ArabicNumberException("Invalid format.");
        }
        
        double newValue = 0;
        for(int index=0; index<value.length(); index++) {
            newValue += (Character.digit(value.charAt(value.length() - index - 1), 10) * Math.pow(10, index));
        }
        
        return (int)newValue;
    }
    
    @Override
    public int intValue() {
        return this.value;
    }

    @Override
    public long longValue() {
        return (long)this.value;
    }

    @Override
    public float floatValue() {
        return (float)this.value;
    }

    @Override
    public double doubleValue() {
        return (double)this.value;
    }

    @Override
    public String toString() {
        int remainValue = this.value;
        String finalValue = this.value == 0 ? "0" : "";
        
        while(remainValue > 0) {
            finalValue = Character.forDigit(remainValue % 10, 10) + finalValue;
            remainValue = remainValue / 10;
        }
        return finalValue;
    }
    
}
