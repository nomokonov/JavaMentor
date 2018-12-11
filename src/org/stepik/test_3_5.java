package org.stepik;

import java.nio.charset.StandardCharsets;
import java.util.function.DoubleUnaryOperator;

public class test_3_5 {
    public static void main(String[] args) {

        //test3.5.3


        System.out.println(integrate(x -> 1, 0, 10));//10.0
        System.out.println(integrate(x -> x + 2, 0, 10));//70.0
        System.out.println(integrate( x -> Math.sin(x) / x , 1, 5));//0.603848

        //3.5.2

        byte[] example = "Hello!".getBytes(StandardCharsets.US_ASCII);
        CharSequence answer = new AsciiCharSequence(example);
        System.out.println("Последовательность - " + answer.toString());//Hello!
        System.out.println("Размер её - " + answer.length());//6
        System.out.println("Символ под № 1 - " + answer.charAt(1));//e
        System.out.println("Подпоследовательность - " + answer.subSequence(1, 5));//ello
//проверка на нарушение инкапсуляции private поля
        System.out.println(answer.toString());//Hello!
        example[0] = 74;
        System.out.println(answer.toString());//Hello!

    }
    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        //ваш код
        int n;
        double result, h;
        result = 0;
        //h = (b - a) / n; //Шаг сетки
      h =1e-6;
        n = (int) ((b - a)/ h);
        for(int i = 1; i <= n; i++)
        {
         //   result += f.applyAsDouble(a + h * (i + 0.5)); // - Метод средних прямоугольников
            result += f.applyAsDouble(a + h * (i -1)); // - Метод левых прямоугольников
         //   result += f.applyAsDouble(a + h * (i ));//Метод правых

        }
        result *= h;
        return result;
    }


    //test 3.5.3
    abstract  class KeywordAnalyzer{
        protected String[] getKeywords (){
        }
        protected Label getLabel(){
        }
    }
    class SpamAnalyzer, NegativeTextAnalyzer и TooLongTextAnalyzer.


    interface TextAnalyzer {
        Label processText(String text);
    }
    enum Label {
        SPAM, NEGATIVE_TEXT, TOO_LONG, OK
    }
}
