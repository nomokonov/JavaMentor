package org.stepik;

public abstract class abstractClassExample {
    protected static int maxValue;

    public abstractClassExample(int maxValue) {
        this.maxValue = maxValue;
    }
    public int  getSumm(){
        return  maxValue;
    }
}

class ClassExample extends abstractClassExample {
    public ClassExample(int maxValue) {
        super(maxValue);
         }
}