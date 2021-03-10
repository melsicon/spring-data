/** */
@CheckReturnValue
@DefaultQualifier(
    value = NonNull.class,
    locations = {TypeUseLocation.PARAMETER, TypeUseLocation.RETURN})
package de.melsicon.example.spring_data.classcheck;

import com.google.errorprone.annotations.CheckReturnValue;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.checkerframework.framework.qual.TypeUseLocation;
