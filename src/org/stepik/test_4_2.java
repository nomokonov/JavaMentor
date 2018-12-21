package org.stepik;

public class test_4_2 {

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
        long finish = System.nanoTime();
        long timeConsumedMillis = finish - start;
        System.out.println(timeConsumedMillis);
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        // ...
//        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
//        try {
//            return stackTraceElements[3].getClassName() + "#" + stackTraceElements[3].getMethodName();
//        } catch (Exception e) {
//            return null;
//        }

        //******************* Best practice
        StackTraceElement[] stackTraceElements = new Throwable().getStackTrace();
        if (stackTraceElements.length >= 3)
            return stackTraceElements[2].getClassName() + "#" + stackTraceElements[2].getMethodName()
                    + "#" + stackTraceElements[2].getFileName() +"#" + stackTraceElements[2].getLineNumber()  ;
        else
            return null;
    }


//    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
//        // your implementation here
//        boolean noStop = true;
//        int count = 0;
//        while (noStop) {
//            try (RobotConnection robotConection = robotConnectionManager.getConnection()) {
//                robotConection.moveRobotTo(toX, toY);
//                noStop = false;
//            } catch (RobotConnectionException e) {
//
//                count++;
//                if (count >= 3) {
//                    noStop = false;
//                    throw new RobotConnectionException("Can not connect robot");
//
//                }
//            }
//        }
//    }


}
