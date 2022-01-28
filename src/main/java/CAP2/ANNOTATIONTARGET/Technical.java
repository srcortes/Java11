package CAP2.ANNOTATIONTARGET;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
@Documented
@Target({ElementType.TYPE_USE, ElementType.METHOD})
public @interface Technical {
    String author() default "";
    String value() default "";
}
