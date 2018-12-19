package org.stepik;

public class test_4_2 {

    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        // ...
//        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
//        String message = "";
//        if(stackTraceElements.length >= 3) {
//            StackTraceElement element = stackTraceElements[2];
//            String className = element.getClassName();
//            String methodName = element.getMethodName();
//            message = className + "#" + methodName;
//        }
//        for (StackTraceElement st: stackTraceElements ) {
//            System.out.println( st.);
//        }
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        try {
            StackTraceElement element = stackTraceElements[3];
            return  element.getClassName() + "#" + element.getMethodName();
        }
        catch (ArrayIndexOutOfBoundsException e
        ){
            return null;
        }

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
