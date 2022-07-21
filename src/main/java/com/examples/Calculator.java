package com.examples;

import com.exceptions.NotDivisible;

public class Calculator {

    public int add(int firstNumber, int secondNumber){

        int addedNumber = firstNumber + secondNumber;

        return addedNumber;
    }
    public int subtraction(int firstNumber,int secondNumber){

        int result= firstNumber-secondNumber;
        return result;
    }
    public int multiplication(int firstNumber,int secondNumber){

        int result= firstNumber*secondNumber;
        return result;
    }
    public int division(int firstNumber, int secondNumber)throws NotDivisible {
        int dividedNumber = 0;
//        if(secondNumber == 0)
//        {
//            System.out.println("division with zero is not possible");
//        }
//        else
//        {
//            dividedNumber = firstNumber / secondNumber;
//        }

        try {
             if( secondNumber==0)
               dividedNumber=firstNumber/secondNumber;

        }catch(ArithmeticException exp){
                throw new NotDivisible();
        }

        dividedNumber=firstNumber/secondNumber;
        return dividedNumber;
    }

}

