/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lamdaandreferencemethodstest;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

/**
 *
 * @author dell
 */
public class LamdaAndReferenceMethodsTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s1 = "Hello World sdfdgdfdfgfd";
        String s2 = "new Hello World";
        String s3="P@ssw0rd";
 
// Using a method reference
        String betterS = betterS(s1, s2, LamdaAndReferenceMethodsTest::isBetter);
        System.out.println(betterS);
        boolean containAlphabet = containAlphabet(s3, LamdaAndReferenceMethodsTest::isL);
        System.out.println(containAlphabet);
    }

    public static boolean isBetter(String s1, String s2) {
        return (s1.length() > s2.length());
    }

    public static String betterS(String s1, String s2, BiPredicate<String, String> p) {
        if (isBetter(s1, s2)) {
            return s1;
        } else {
            return s2;
        }

    }

    public static boolean isL(String s1) {
        char[] s1_char_arr = s1.toCharArray();
        for (char c : s1_char_arr) {
            if (Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static Boolean containAlphabet(String s1, Consumer<String>c) {
        return isL(s1);
    }
}
