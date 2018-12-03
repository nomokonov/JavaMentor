package ru.nomokonov.task5;
import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.nio.charset.Charset;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class task5 extends JFrame
{
    public enum Weekday
    {
        MONDAY("Понедельник"), TUESDAY("Вторник"), WEDNESDAY("Среда"),
        THURSDAY("Четверг"), FRIDAY("Пятница"), SATURDAY("Суббота"), SUNDAY("Воскресенье");

        String value;
        Weekday(String value)
        {
            this.value = value;
        }
        @Override
        public String toString()
        {
            return value;
        }
    }



    public task5() {
        super("Определение кода нажатой клавиши");
        JLabel label = new JLabel();
        label.setFont(new Font("Calibri", Font.PLAIN, 40));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setLayout(new BorderLayout());
        label.setFocusable(true);
        label.setText("Hello!");
        label.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                label.setText("Код клавиши: " + (char)e.getKeyCode());
            }
        });
        add(label);
        setBounds(100,100,400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args)
    {
        task5 hf = new task5();
    }
}