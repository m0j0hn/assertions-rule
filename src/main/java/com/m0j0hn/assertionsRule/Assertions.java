package com.m0j0hn.assertionsRule;

import java.lang.annotation.*;

/**
 * <p>Mark test methods which exercise assertions.</p>
 *
 * @author m0j0hn@users.noreply.github.com
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Assertions {
    public boolean enabled() default true;
}
