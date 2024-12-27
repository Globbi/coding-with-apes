package codingwithapes.lesson1.classes;

import codingwithapes.util.ClassTestUtil;
import org.junit.jupiter.api.Test;

import java.lang.reflect.AccessFlag;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Aufgabe1Test {

    private static final String className = "Armbrust";

    @Test
    public void testClassExists() {
        Class<?> aClass = ClassTestUtil.tryLoading(Aufgabe1Test.class, className);
        assertTrue(aClass.accessFlags().contains(AccessFlag.PUBLIC),
            "Die Klasse muss 'public' sein!");
        assertFalse(aClass.accessFlags().contains(AccessFlag.ABSTRACT),
            "Die Klasse darf nicht 'abstract' sein!");

        Constructor<?> defaultConstructor = ClassTestUtil.getDefaultConstructor(aClass);
        assertTrue(defaultConstructor.accessFlags().contains(AccessFlag.PUBLIC),
            "Der Konstruktor muss 'public' sein!");
    }

    @Test
    public void testHasFieldFarbe() {
        Class<?> aClass = ClassTestUtil.tryLoading(Aufgabe1Test.class, className);

        Field farbe = ClassTestUtil.getField(aClass, "farbe");

        assertEquals(String.class, farbe.getType(), "Das Feld/Attribut 'farbe' muss vom Typen 'String' sein");
    }

    @Test
    public void testHasFieldMaterial() {
        Class<?> aClass = ClassTestUtil.tryLoading(Aufgabe1Test.class, className);

        Field farbe = ClassTestUtil.getField(aClass, "material");

        assertEquals(String.class, farbe.getType(), "Das Feld/Attribut 'material' muss vom Typen 'String' sein");
    }

    @Test
    public void testHasFieldStaerke() {
        Class<?> aClass = ClassTestUtil.tryLoading(Aufgabe1Test.class, className);

        Field farbe = ClassTestUtil.getField(aClass, "staerke");

        assertEquals(double.class, farbe.getType(), "Das Feld/Attribut 'staerke' muss vom Typen 'double' sein");
    }

    @Test
    public void testHasDefaultConstructor() {
        Class<?> aClass = ClassTestUtil.tryLoading(Aufgabe1Test.class, className);

        Constructor<?> defaultConstructor = ClassTestUtil.getDefaultConstructor(aClass);
        assertTrue(defaultConstructor.accessFlags().contains(AccessFlag.PUBLIC),
            "Der Konstruktor muss 'public' sein!");
    }

}