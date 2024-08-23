/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package firstjavaprogram;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Athlon 3000g
 */
public class RomanNumerals {

    private static final Map<Character, Integer> romanToIntMap = new HashMap<>();

    static {
        romanToIntMap.put('I', 1);
        romanToIntMap.put('V', 5);
        romanToIntMap.put('X', 10);
        romanToIntMap.put('L', 50);
        romanToIntMap.put('C', 100);
        romanToIntMap.put('D', 500);
        romanToIntMap.put('M', 1000);
    }

    public static int romanToNumber(String romanStr) {
        int total = 0;
        int prevValue = 0;

        for (int index = romanStr.length() - 1; index >= 0; index--) {
            char currentChar = romanStr.charAt(index);
            int currentNumValue = romanToIntMap.get(currentChar);

            if (currentNumValue < prevValue) {
                total -= currentNumValue;
            } else {
                total += currentNumValue;
            }
            prevValue = currentNumValue;
        }
        return total;
    }

    public static String numberToRoman(int number) {
        StringBuilder convertedRoman = new StringBuilder();

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int index = 0; index < values.length; index++) { // 20
            while (number >= values[index]) {
                convertedRoman.append(symbols[index]);
                number -= values[index];
            }
        }

        return convertedRoman.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int option;

        System.out.println("\t\tWelcome to Convertsion");
        System.out.println("\t\t1. Roman to Number Conversion ");
        System.out.println("\t\t2. Number to Roman Conversion ");

        System.out.print("\t\tEnter your option: ");
        option = input.nextInt();

        input.nextLine();
        switch (option) {
            case 1:
                String romanStr = null;
                System.out.println("\n\t\tRoman to Integer Conversion");
                System.out.print("\t\tEnter roman: ");
                romanStr = input.nextLine();

                System.out.println("\n\t\tThe value of roman in integer is: " + romanToNumber(romanStr));
                break;
            case 2:
                int numberInt = 0;
                System.out.println("\n\t\tNumber to Roman Conversion");
                System.out.print("\t\tEnter Number: ");
                numberInt = input.nextInt();

                System.out.println("\n\t\tThe value of number in roman is: " + numberToRoman(numberInt));
                break;
            default:
                System.out.println("\n\t\tPlease Enter only range in 1-2");
        }

    }
}
