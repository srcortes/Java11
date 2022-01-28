package CAP2.ANNOTATIONVALUE;

import CAP2.ANNOTATIONTARGET.Technical;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface Furry {
    public String[] value();
    boolean cute() default true;
}
