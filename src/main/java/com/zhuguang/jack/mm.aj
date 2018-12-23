package com.zhuguang.jack;

public aspect mm {
    pointcut say():
            execution(* App.say(..));
    before(): say() {
        System.out.println("AjAspect before say");
    }
    after(): say() {
        System.out.println("AjAspect after say");
    }
}
