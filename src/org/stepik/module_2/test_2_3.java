package org.stepik.module_2;

public class test_2_3 {
    public static void main(String[] args) {
        //test 2.3.1
        System.out.println(isPalindrome("Madam, I'm Adam!"));
        System.exit(0);
    }

    public static boolean isPalindrome(String text) {
        String str = text.replaceAll("[^a-zA-Z0-9]","");
        String str2 = new StringBuilder(str).reverse().toString();
        return str2.equalsIgnoreCase(str);

    }
}

