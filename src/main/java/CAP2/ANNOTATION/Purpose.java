package CAP2.ANNOTATION;


public @interface Purpose {
    int value() default 1;
    int[] h() default {1};
    String behaviorClass () default "";
}
