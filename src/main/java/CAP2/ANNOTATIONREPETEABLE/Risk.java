package CAP2.ANNOTATIONREPETEABLE;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;

@Repeatable(Risks.class)
@Target({ElementType.TYPE_USE})
public @interface Risk {
    String danger();
    int level() default 1;
}
