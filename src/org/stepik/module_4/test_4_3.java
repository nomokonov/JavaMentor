package org.stepik.module_4;

import java.util.logging.*;

public class test_4_3 {
    private static final Logger loggerA = Logger.getLogger("org.stepic.java.logging.ClassA");
    private static final Logger loggerB = Logger.getLogger("org.stepic.java.logging.ClassB");
    private static final Logger loggerCommon = Logger.getLogger("org.stepic.java");

    public static void main(String[] args) {
        configureLogging();
        loggerCommon.log(Level.WARNING,"WARNING");
        loggerCommon.log(Level.FINE,"FINE");

        loggerA.log(Level.WARNING,"WARNING!!");
        loggerA.log(Level.INFO,"INFO");
        loggerA.log(Level.CONFIG,"CONFIG");
        loggerA.log(Level.FINE,"FINE");

        loggerB.log(Level.WARNING,"WARNING");
        loggerB.log(Level.INFO,"INFO");
        loggerB.log(Level.CONFIG,"CONFIG");
        loggerB.log(Level.FINE,"FINE");

    }

    private static void configureLogging() {


        loggerCommon.setUseParentHandlers(false);
        loggerCommon.setLevel(Level.ALL);
        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        handler.setFormatter(new XMLFormatter());
        loggerCommon.addHandler(handler);

        loggerA.setLevel(Level.ALL);
        Handler handlerA = new ConsoleHandler();
        handlerA.setLevel(Level.ALL);
        loggerA.addHandler(handlerA);

        loggerB.setLevel(Level.WARNING);
        Handler handlerB = new ConsoleHandler();
        handlerB.setLevel(Level.WARNING);
        loggerA.addHandler(handlerB);


    }

}
