package retrofit2.http;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface k {
    boolean allowUnsafeNonAsciiValues() default false;

    String[] value();
}
