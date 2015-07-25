package com.jorgecastilloprz.mirage.di.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;

/**
 * @author jorge
 * @since 25/07/15
 */
@Qualifier @Documented @Retention(RetentionPolicy.RUNTIME) public @interface Mock {
}
