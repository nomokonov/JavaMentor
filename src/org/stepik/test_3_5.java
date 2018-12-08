package org.stepik;

import java.util.function.DoubleUnaryOperator;

public class test_3_5 {
    public static void main(String[] args) {
        System.out.println(integrate(x -> 1, 0, 10));//10.0
        System.out.println(integrate(x -> x + 2, 0, 10));//70.0
        System.out.println(integrate( x -> Math.sin(x) / x , 1, 5));//0.603848
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
}
