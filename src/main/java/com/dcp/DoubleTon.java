package com.dcp;

public class DoubleTon {

    private static boolean flag = true;

    private DoubleTon(){

    }

    private static class DoubleTonHelperEven{
        private static final DoubleTon INSTANCE = new DoubleTon();
    }

    private static class DoubleTonHelperOdd{
        private static  final  DoubleTon INSTANCE = new DoubleTon();
    }

    public static DoubleTon getInstance(){
        if(flag){
            flag = false;
            return DoubleTonHelperEven.INSTANCE;
        }
        else{
            flag = true;
            return DoubleTonHelperOdd.INSTANCE;
        }
    }

}
