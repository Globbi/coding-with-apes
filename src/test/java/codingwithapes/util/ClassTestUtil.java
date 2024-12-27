package codingwithapes.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.fail;

public final class ClassTestUtil {
    private ClassTestUtil() {}

    public static Class<?> tryLoading(Class<?> reference, String className) {
        String fullClassName = reference.getPackageName() + "." + className;
        try {
            return reference.getClassLoader().loadClass(fullClassName);
        } catch (ClassNotFoundException e) {
            fail("Klasse konnte nicht gefunden werden. Sicher dass die Klasse am richtigen Ort stellt wurde?");
        }
        throw new RuntimeException("Assertion failed!");
    }

    public static Constructor<?> getDefaultConstructor(Class<?> from) {
        return getConstructor(from, "Klasse hat keinen Default Konstruktor!");
    }

    public static Field getField(Class<?> from, String name) {
        try {
            return from.getDeclaredField(name);
        } catch (NoSuchFieldException e) {
            fail("Die Klasse '" + from.getSimpleName() + "' besitzt kein Feld/Attribut mit dem Namen '" + name + "'!");
        }
        throw new RuntimeException("Assertion failed!");
    }

    public static Constructor<?> getConstructor(Class<?> from, String errMsg, Class<?>... paramTypes) {
        try {
            return from.getConstructor(paramTypes);
        } catch (NoSuchMethodException e) {
            fail(errMsg);
        }
        throw new RuntimeException("Assertion failed!");
    }
}
