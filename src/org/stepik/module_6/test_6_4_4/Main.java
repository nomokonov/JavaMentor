package org.stepik.module_6.test_6_4_4;

import java.util.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {


        // Random variables
        String randomFrom = "Myself"; // Некоторая случайная строка. Можете выбрать ее самостоятельно.
        String randomTo = "MySelf";  // Некоторая случайная строка. Можете выбрать ее самостоятельно.
        int randomSalary = 100;  // Некоторое случайное целое положительное число. Можете выбрать его самостоятельно.

// Создание списка из трех почтовых сообщений.
        MailMessage firstMessage = new MailMessage(
                "Robert Howard",
                "H.P. Lovecraft",
                "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
        );

        assert firstMessage.getFrom().equals("Robert Howard") : "Wrong firstMessage from address";
        assert firstMessage.getTo().equals("H.P. Lovecraft") : "Wrong firstMessage to address";
        assert firstMessage.getContent().endsWith("Howard!") : "Wrong firstMessage content ending";

        MailMessage secondMessage = new MailMessage(
                "Jonathan Nolan",
                "Christopher Nolan",
                "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!"
        );

        MailMessage thirdMessage = new MailMessage(
                "Stephen Hawking",
                "Christopher Nolan",
                "Я так и не понял Интерстеллар."
        );

        List<MailMessage> messages = Arrays.asList(
                firstMessage, secondMessage, thirdMessage
        );

// Создание почтового сервиса.
        MailService<String> mailService = new MailService<>();

// Обработка списка писем почтовым сервисом
        messages.stream().forEachOrdered(mailService);

// Получение и проверка словаря "почтового ящика",
//   где по получателю можно получить список сообщений, которые были ему отправлены
        Map<String, List<String>> mailBox = mailService.getMailBox();

        assert mailBox.get("H.P. Lovecraft").equals(
                Arrays.asList(
                        "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
                )
        ) : "wrong mailService mailbox content (1)";

        assert mailBox.get("Christopher Nolan").equals(
                Arrays.asList(
                        "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!",
                        "Я так и не понял Интерстеллар."
                )
        ) : "wrong mailService mailbox content (2)";

        assert mailBox.get(randomTo).equals(Collections.<String>emptyList()) : "wrong mailService mailbox content (3)";


// Создание списка из трех зарплат.
        Salary salary1 = new Salary("Facebook", "Mark Zuckerberg", 1);
        Salary salary2 = new Salary("FC Barcelona", "Lionel Messi", Integer.MAX_VALUE);
        Salary salary3 = new Salary(randomFrom, randomTo, randomSalary);

// Создание почтового сервиса, обрабатывающего зарплаты.
        MailService<Integer> salaryService = new MailService<>();

// Обработка списка зарплат почтовым сервисом
        Arrays.asList(salary1, salary2, salary3).forEach(salaryService);

// Получение и проверка словаря "почтового ящика",
//   где по получателю можно получить список зарплат, которые были ему отправлены.
        Map<String, List<Integer>> salaries = salaryService.getMailBox();
        assert salaries.get(salary1.getTo()).equals(Arrays.asList(1)) : "wrong salaries mailbox content (1)";
        assert salaries.get(salary2.getTo()).equals(Arrays.asList(Integer.MAX_VALUE)) : "wrong salaries mailbox content (2)";
        assert salaries.get(randomTo).equals(Arrays.asList(randomSalary)) : "wrong salaries mailbox content (3)";
    }

    interface Sendable<T> {
        String getTo();

        T getContext();
    }

    public static class MailMessage implements Sendable<String> {
        private String from;
        private String to;
        private String text;

        public MailMessage(String from, String to, String text) {
            this.from = from;
            this.to = to;
            this.text = text;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public String getContext() {
            return text;
        }
        public String getFrom(){
            return from;
        }

        public String getContent() {
            return text;
        }
    }

    public static class Salary implements Sendable<Integer> {
        private String company;
        private String name;
        private int salary;

        public Salary(String company, String name, int salary) {
            this.company = company;
            this.name = name;
            this.salary = salary;
        }

        @Override
        public String getTo() {
            return name;
        }

        @Override
        public Integer getContext() {
            return salary;
        }
    }

    public static class MailService<T> implements Consumer<Sendable<T>> {
        Map<String, List<T>> map;

        public MailService() {
            Map<String, List<T>> map = new MyMap<>();
            this.map = map;
        }

        public Map<String, List<T>> getMailBox() {
            return map;
        }

        @Override
        public void accept(Sendable<T> sendable) {
            if (map.containsKey(sendable.getTo())) {
                map.get(sendable.getTo()).add(sendable.getContext());
            } else {
                List<T> list = new ArrayList(Arrays.asList(sendable.getContext()));
                 map.put(sendable.getTo(),list);
            }
        }

    }

    static class MyMap<K,V> extends HashMap<K,V>{

        @Override
        public V get(Object key) {
            List<String> list = new ArrayList<>();
            return super.getOrDefault(key , (V) list);
        }
    }

}


