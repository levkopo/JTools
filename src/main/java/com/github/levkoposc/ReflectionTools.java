package com.github.levkoposc;

import com.github.levkoposc.annotations.DataAnnotation;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public final class ReflectionTools {

    @SuppressWarnings("unchecked")
    public <T> Map<String, T> getStaticFieldsByType(Class<T> clazzOf, Class<?> clazz){
        Map<String, T> values = new HashMap<>();

        for(Field field: clazz.getDeclaredFields())
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers())&&field.getType()==clazzOf) {
                try {
                    values.put(field.getName(), (T) field.get(clazz));
                } catch (IllegalAccessException ignored) {}
            }

        return values;
    }

    public Object[] getDataFromMethod(Class<?> clazz, String name){
        try {
            return clazz.getDeclaredMethod(name).getAnnotation(DataAnnotation.class).value();
        } catch (Exception ignored) {}

        return new Object[0];
    }

    public Object[] getDataFromField(Class<?> clazz, String name){
        try {
            return clazz.getDeclaredField(name).getAnnotation(DataAnnotation.class).value();
        } catch (Exception ignored) {}

        return new Object[0];
    }

    public Object[] getDataFromClass(Class<?> clazz){
        try {
            return clazz.getDeclaredAnnotation(DataAnnotation.class).value();
        } catch (Exception ignored) {}

        return new Object[0];
    }
}
