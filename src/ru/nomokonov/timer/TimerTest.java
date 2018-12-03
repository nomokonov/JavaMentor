package ru.nomokonov.timer;


import java.awt.Graphics;
import javax.swing.*;

public class TimerTest{
    public static final int i=1;
    public static void main(String[] args) {


        System.out.println(i);;
        // Создаем графическое окно
        OvalFrame of = new OvalFrame();
        // Задаем правидо, по которому приложение завершиться при
        // закрытии этой формы
        of.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Делаем окно видимым
        of.setVisible(true);
        System.out.println();
    }

    // Наследуемся от стандартного класса, который
// используется для создания компонентов на форме
    public static class OvalComponent  extends JComponent
    {

        // Переопределяем метод рисованиая, в который передается
        // объект класса Graphics

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int ot=1;
            // Используем Graphics для рисования овала
            // с отступами
            g.drawOval(5+ot, 5+ot, getWidth() - (20 + ot) , getHeight() - (20 + ot));
        }


    }
    public static class OvalFrame extends JFrame
    {
        public OvalFrame() {
            // Создаем объект типа OvalComponent
            OvalComponent oc = new OvalComponent();
            // Испольщзуем метод класса JFrame для добавления
            // компонента на главную панель.
            add(oc);

            // Устанавливаем координаты и размеры окна
            setBounds(200, 200, 300, 250);
        }



    }




}