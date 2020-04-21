package concurrency.annotation;

import java.lang.annotation.*;

/**
 *
 * аннотация указывает что класс потокобезопасен
 *
 */

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ThreadSafe {
}
