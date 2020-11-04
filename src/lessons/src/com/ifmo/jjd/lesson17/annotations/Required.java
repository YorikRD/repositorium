package com.ifmo.jjd.lesson17.annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Annotation called for annotation to make it valid for lementType (FIELD)
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME) // Control time
public @interface Required {
    // then @ is before word interface it will be annotation.

}
