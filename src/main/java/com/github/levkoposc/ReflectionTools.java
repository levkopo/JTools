package com.github.levkoposc;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public final class ReflectionTools {

    public <T> List<T> getStaticFieldsByType(Class<T> clazzOf, Class<?> clazz){
        List<T> values = new ArrayList<T>();

        for(Field field: clazz.getDeclaredFields())
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers())&&field.getType()==clazzOf) {
                try {
                    values.add((T) field.get(clazz));
                } catch (IllegalAccessException ignored) {}
            }

        return values;
    }
}
