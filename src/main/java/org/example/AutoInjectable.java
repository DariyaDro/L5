package org.example;
import java.lang.annotation.*;
@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoInjectable{}
