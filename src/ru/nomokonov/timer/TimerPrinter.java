package ru.nomokonov.timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TimerPrinter implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        System.out.println("At the tone, the time is ");

        Toolkit.getDefaultToolkit().beep();
    }
}
