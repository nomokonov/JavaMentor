package ru.nomokonov.queues;

public class TestObjectQueue {
    public static void main(String[] args) {
        ObjectQueue queue = new ObjectQueue();
        // Выбираем размер стороны квадрата и рассчитываем общее количество элементов массива
        int Size = 10;
        int Max = Size * Size;
        /*
         координаты и рамки заполнения массива
         x[0],y[0] – нижние динамические границы
         x[1],y[1] – верхние динамические границы
         x[2],y[2] – текущие координаты
         x[3],y[3] – вектор смещения
         */
        int RC = 4;
        int[] x = new int[RC];
        int[] y = new int[RC];
        // Объявляем массив для заполнения
        int[][] Sp = new int[Size][Size];
        // Задаём начальные значения координат и рамок
        for (int i = 0; i < RC; i++) {
            x[i] = y[i] = 0;
        }
        x[1] = y[1] = Size - 1;
        x[3] = 1;
        // Заполняем массив
        for (int i = 0; i < Max; i++) {
            //Используем массив как координатное поле
            Sp[x[2]][y[2]] = i + 1;
            // Рассчитываем текущие координаты
            x[2] = x[2] + x[3];
            y[2] = y[2] + y[3];
            // Рассчёт вектора смещения
            if (y[3] == 0) {
                if ((x[2] > x[0]) && (x[3] > 0)) {
                    x[3] = 1;
                }
                if ((x[2] < x[1]) && (x[3] < 0)) {
                    x[3] = -1;
                }
                if ((x[2] == x[1]) && (x[3] > 0)) {
                    x[3] = 0;
                    x[1]--;
                    y[3] = 1;
                }
                if ((x[2] == x[0]) && (x[3] < 0)) {
                    x[3] = 0;
                    x[0]++;
                    y[3] = -1;
                }
            }
            if (x[3] == 0) {
                if ((y[2] > y[0]) && (y[3] > 0)) {
                    y[3] = 1;
                }
                if ((y[2] < y[1]) && (y[3] < 0)) {
                    y[3] = -1;
                }
                if ((y[2] == y[1]) && (y[3] > 0)) {
                    y[3] = 0;
                    y[1]--;
                    x[3] = -1;
                }
                if ((y[2] == x[0]) && (y[3] < 0)) {
                    y[3] = 0;
                    y[0]++;
                    x[3] = 1;
                }
            }
        }
        // Печать массива заполненного данными по спирали
        System.out.println();
        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
                System.out.format("%4d", Sp[j][i]);
            }
            System.out.println();
        }

        //+++++++++++++++++
        for(int i=0; i<10; i++) {
            // В данном случае мы складываем в очередь строки
            queue.push("Строка:" + i);

        }
        String str =(String)queue.getIndex(5);

        System.out.println(str + ": Index=" +5);
        System.out.println();
        int[][] arr = new int [5][5] ;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = (i+1)* (j+1);
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.format("%3d",arr[i][j]);
            }
            System.out.println();
        }



        while(queue.getSize() > 0) {
            // Мы делаем жесткое приведение типа, т.к. знаем, что там лежат строки
            String s = (String)queue.pull();
            System.out.println(s);
            System.out.println("Размер очереди:" + queue.getSize());
        }
    }
}

