package org.stepik.module_6;

import java.util.Objects;
import java.util.Optional;

public class theory {
    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!


    }

    public class Example<X> {
        public void someMethod(Object obj) {

            Optional<X> optx = Optional.empty();
            X o = (X) obj;
        }
    }

    //******************* 6.1.1
    static class Pair<T, S> {
        private  T first;
        private  S second;

        private   Pair(T f, S s) {
            this.first = f;
            this.second = s;
        }
      public static <T,S> Pair<T,S> of (T f,S s){
        return   new Pair<>(f,s);
       }

        T getFirst() {
            return first;
        }

        S getSecond() {
            return second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) &&
                    Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {

            return Objects.hash(first, second);
        }
    }
}
