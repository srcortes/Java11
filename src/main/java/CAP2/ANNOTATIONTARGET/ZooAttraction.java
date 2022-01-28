package CAP2.ANNOTATIONTARGET;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE})
public @interface ZooAttraction {
}
