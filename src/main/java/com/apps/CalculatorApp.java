package com.apps;

import com.examples.Calculator;
import com.exceptions.NotDivisible;

public class CalculatorApp {

        public static void main(String[] args) {

            Calculator cal = new Calculator();
            // addition tests
            String result = testApp(cal, "ADD",5,3);
            if(result.equals("8"))
                System.out.println("add of two positive number: PASSED");
            else
                System.out.println("add of two positive number: FAILED");

            result = testApp(cal, "ADD",-3,10);
            if(result.equals("7"))
                System.out.println("add of two positive number: PASSED");
            else
                System.out.println("add of one positive number: FAILED");

            // division tests
            result = testApp(cal, "DIVIDE",10,3);
            if(result.equals("3"))
                System.out.println("division of two positive number: PASSED");
            else
                System.out.println("division of two positive number: FAILED");

            result = testApp(cal, "DIVIDE",-46,-6);
            if(result.equals("7"))
                System.out.println("division of two positive number: PASSED");
            else
                System.out.println("division of two positive number: FAILED");

            result = testApp(cal, "DIVIDE",-89,0);
            if(result.equals("EXCEPTION"))
                System.out.println("division of two positive number: PASSED");
            else
                System.out.println("division of two positive number: FAILED");

            //substraction test
            result = testApp(cal, "SUBSTRACT",10,-3);
            if(result.equals("13"))
                System.out.println("substraction of two positive number: PASSED");
            else
                System.out.println("substractionof two positive number: FAILED");

            result = testApp(cal, "SUBSTRACT",-56,-29);
            if(result.equals("-27"))
                System.out.println("substraction of two positive number: PASSED");
            else
                System.out.println("substractionof two positive number: FAILED");
            //multiplication test
            result = testApp(cal, "MULTIPLY",-45,8);
            if(result.equals("-360"))
                System.out.println("multiplication of two positive number: PASSED");
            else
                System.out.println("multiplication of two positive number: FAILED");


        }

        private static String testApp(Calculator cal,String operation, int firstNumber,int secondNumber){
            String result=null;
            switch (operation){
                case "ADD":
                    result = new Integer(cal.add(firstNumber, secondNumber)).toString();
                    break;
                case "DIVIDE":
                    try {
                        result = new Integer(cal.division(firstNumber, secondNumber)).toString();

                    } catch (NotDivisible divisible) {
                        result = "EXCEPTION";
                    }
                    break;
                case "SUBSTRACT":
                    result=new Integer(cal.subtraction(firstNumber, secondNumber)).toString();
                    break;
                case "MULTIPLY":
                    result=new Integer(cal.multiplication(firstNumber, secondNumber)).toString();
            }
            return result;
        }
}

