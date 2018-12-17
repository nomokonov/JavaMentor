package org.stepik;

import java.nio.charset.StandardCharsets;
import java.util.function.DoubleUnaryOperator;

public class test_3_5 {



    public static void main(String[] args) {

        //test3.5.3
        // инициализация анализаторов для проверки в порядке данного набора анализаторов
        String[] spamKeywords = {"spam", "bad"};
        int commentMaxLength = 40;
        TextAnalyzer[] textAnalyzers1 = {
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers2 = {
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers3 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers4 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords)
        };
        TextAnalyzer[] textAnalyzers5 = {
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers6 = {
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords)
        };
        // тестовые комментарии
        String[] tests = new String[8];
        tests[0] = "This comment is so good.";                            // OK
        tests[1] = "This comment is so Loooooooooooooooooooooooooooong."; // TOO_LONG
        tests[2] = "Very negative comment !!!!=(!!!!;";                   // NEGATIVE_TEXT
        tests[3] = "Very BAAAAAAAAAAAAAAAAAAAAAAAAD comment with :|;";    // NEGATIVE_TEXT or TOO_LONG
        tests[4] = "This comment is so bad....";                          // SPAM
        tests[5] = "The comment is a spam, maybeeeeeeeeeeeeeeeeeeeeee!";  // SPAM or TOO_LONG
        tests[6] = "Negative bad :( spam.";                               // SPAM or NEGATIVE_TEXT
        tests[7] = "Very bad, very neg =(, very ..................";      // SPAM or NEGATIVE_TEXT or TOO_LONG
        TextAnalyzer[][] textAnalyzers = {textAnalyzers1, textAnalyzers2, textAnalyzers3,
                textAnalyzers4, textAnalyzers5, textAnalyzers6};
        TestObj testObj = new TestObj();
        int numberOfAnalyzer; // номер анализатора, указанный в идентификаторе textAnalyzers{№}
        int numberOfTest = 0; // номер теста, который соответствует индексу тестовых комментариев
        for (String test : tests) {
            numberOfAnalyzer = 1;
            System.out.print("test #" + numberOfTest + ": ");
            System.out.println(test);
            for (TextAnalyzer[] analyzers : textAnalyzers) {
                System.out.print(numberOfAnalyzer + ": ");
                System.out.println(testObj.checkLabels(analyzers, test));
                numberOfAnalyzer++;
            }
            numberOfTest++;
        }


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

        //tect 3.5.1

        System.out.println(integrate(x -> 1, 0, 10));//10.0
        System.out.println(integrate(x -> x + 2, 0, 10));//70.0
        System.out.println(integrate(x -> Math.sin(x) / x , 1, 5));//0.603848
    }
    //   result += f.applyAsDouble(a + h * (i + 0.5)); // - Метод средних прямоугольников
    //   result += f.applyAsDouble(a + h * (i -1)); // - Метод левых прямоугольников
    //   result += f.applyAsDouble(a + h * (i ));//Метод правых
    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double h = 1e-6;
        int n = (int) ((b - a)/ h);         //h = (b - a) / n; //Шаг сетки
        double result = 0;
        for (int i = 1; i <= n; i++) {
            result += f.applyAsDouble(a + h * (i -1));
        }
        return result *= h;
    }


    //test 3.5.3


}
class TestObj {

    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        Label lab;
        for (int i = 0; i < analyzers.length; i++) {
            lab = analyzers[i].processText(text);
            if ( lab != Label.OK) return lab;
        }
        return Label.OK;
    }
}
interface TextAnalyzer {
    Label processText(String text);
}
enum Label {
    SPAM, NEGATIVE_TEXT, TOO_LONG, OK
}
abstract  class KeywordAnalyzer implements TextAnalyzer{
    protected   abstract String[] getKeywords ();
    protected   abstract Label getLabel();
    @Override
    public Label processText(String text) {
        for (String key: getKeywords()) {
            if (text.contains(key) ) {
                return getLabel();
            }
        }
        return Label.OK;
    }
}

class SpamAnalyzer extends KeywordAnalyzer {
    private String[] keywords;
    public SpamAnalyzer(String[] keywords) {
        this.keywords = new String[keywords.length];
        this.keywords = keywords.clone();
    }
    @Override
    protected   String[] getKeywords() {
        return this.keywords;
    }
    @Override
    protected   Label getLabel() {
        return Label.SPAM;
    }
}

class NegativeTextAnalyzer extends KeywordAnalyzer {
    private static final String[] KEYS = new String[] {":(","=(",":|"};
    @Override
    protected  String[] getKeywords() {
        return  KEYS;
    }
    @Override
    protected  Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}

class TooLongTextAnalyzer implements TextAnalyzer {
    private final int maxLength;
    public TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }
    @Override
    public Label processText(String text) {
        return text.length() > maxLength ? Label.TOO_LONG : Label.OK;
    }
}

