package br.com.main;

import br.com.arabic.ArabicNumber;
import br.com.arabic.ArabicNumberException;
import br.com.roman.RomanNumber;
import br.com.roman.RomanNumberException;

/**
 *
 * @author Jesjobom
 */
public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Necessario executar passando os parametros:");
            System.out.println(" - Valor na representacao romana para conversao para o formato arabico; ou");
            System.out.println(" - Valor no formato arabico para conversao na representacao romana.");
            
            System.out.println("\nExemplo:");
            System.out.println("java -jar ConvertRomans.jar XCVI");
            System.out.println("java -jar ConvertRomans.jar 96");
            System.exit(0);
        }
        
        try {
            RomanNumber roman = new RomanNumber(args[0]);
            ArabicNumber arabic = new ArabicNumber(roman.intValue());
            
            System.out.println("\n\n" + roman.toString() + " convertido para " + arabic.toString() + "\n");
        } catch (RomanNumberException re) {
            
            try {
                ArabicNumber arabic = new ArabicNumber(args[0]);
                RomanNumber roman = new RomanNumber(arabic.intValue());
                
                System.out.println("\n\n" + arabic.toString() + " convertido para " + roman.toString() + "\n");
            } catch (ArabicNumberException ae) {
                
                System.err.println("Nao foi possivel realizar a conversao: ");
                System.err.println("RomanToArabic: " + re.getMessage());
                System.err.println("ArabicToRoman: " + ae.getMessage());
            }
        }
    }
}
