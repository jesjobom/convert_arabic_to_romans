/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.roman;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Classe para representar os números romanos.
 * Deve ser responsável pela conversão de seu valor quantitativo para <code>int</code>
 * ou para a representação romana e vice-versa.
 *
 * @author Jesjobom
 */
public class RomanNumber extends Number {
    
    //Valor quantitativo
    private int value;
    
    //Representação romana
    private final String rawValue;
    
    //Regex de validação do formato romano
    private static final String format = "^M{0,3}(CM|C?D|D?C{0,3})?(XC|X?L|L?X{0,3})?(IX|I?V|V?I{0,3})?$";
    
    //Mapeamento dos valores para conversão de romano para int
    private static final Map<String, Integer> convertToIntValues;
    
    //Listagem dos valores para conversão de int para romano
    private static final LinkedList<Object[]> convertToRomanValues;
    
    static {
        //Inicialização do mapeamento de valores para conversão
        convertToIntValues = new HashMap<String, Integer>();
        convertToIntValues.put("M", 1000);
        convertToIntValues.put("D", 500);
        convertToIntValues.put("C", 100);
        convertToIntValues.put("L", 50);
        convertToIntValues.put("X", 10);
        convertToIntValues.put("V", 5);
        convertToIntValues.put("I", 1);
        
        //Inicialização da listagem de valores para conversão
        convertToRomanValues = new LinkedList<Object[]>();
        convertToRomanValues.add(new Object[]{1000,"M"});
        convertToRomanValues.add(new Object[]{900,"CM"});
        convertToRomanValues.add(new Object[]{500,"D"});
        convertToRomanValues.add(new Object[]{400,"CD"});
        convertToRomanValues.add(new Object[]{100,"C"});
        convertToRomanValues.add(new Object[]{90,"XC"});
        convertToRomanValues.add(new Object[]{50,"L"});
        convertToRomanValues.add(new Object[]{40,"XL"});
        convertToRomanValues.add(new Object[]{10,"X"});
        convertToRomanValues.add(new Object[]{9,"IX"});
        convertToRomanValues.add(new Object[]{5,"V"});
        convertToRomanValues.add(new Object[]{4,"IV"});
        convertToRomanValues.add(new Object[]{1,"I"});
    }

    /**
     * Construtor que recebe a representação romana do valor.
     * 
     * @param rawValue
     * @throws RomanNumberException 
     */
    public RomanNumber(String rawValue) throws RomanNumberException {
        this.value = valueOf(rawValue);
        this.rawValue = rawValue;
    }

    public RomanNumber(int value) {
        this.value = value;
        this.rawValue = valueOf(value);
    }
    
    /**
     * Retorna o valor quantitativo da reprensentação romana passada.
     * 
     * @param rawValue
     * @return valor representado
     * @throws RomanNumberException 
     */
    public static int valueOf(String rawValue) throws RomanNumberException {
        if(!rawValue.matches(format)) {
            throw new RomanNumberException("Invalid number format");
        }
        
        int value = 0;
        int index = 0;
        while(index < rawValue.length()) {
            
            if( (index+1) < rawValue.length() && 
                    convertToIntValues.get(rawValue.substring(index, index+1)) < convertToIntValues.get(rawValue.substring(index+1, index+2)) ) {
                value += ( convertToIntValues.get(rawValue.substring(index+1, index+2)) - convertToIntValues.get(rawValue.substring(index, index+1)) );
                index += 2;
            } else {
                value += convertToIntValues.get(rawValue.substring(index, index+1));
                index++;
            }
        }
        
        return value;
    }
    
    /**
     * Retorna a representação romana do valor passado
     * 
     * @param value
     * @return String
     */
    public static String valueOf(int value) {
        
        String romanValue = "";
        int remainValue = value;
        int index = 0;
        
        while(remainValue > 0) {
            int currentConvertValue = (Integer)convertToRomanValues.get(index)[0];
            
            if(currentConvertValue > remainValue) {
                index ++;
                continue;
            }
            
            romanValue += (String)convertToRomanValues.get(index)[1];
            remainValue -= currentConvertValue;
        }
        
        return romanValue;
    }

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return (long)value;
    }

    @Override
    public float floatValue() {
        return (float)value;
    }

    @Override
    public double doubleValue() {
        return (double)value;
    }

    @Override
    public String toString() {
        return rawValue;
    }
}
