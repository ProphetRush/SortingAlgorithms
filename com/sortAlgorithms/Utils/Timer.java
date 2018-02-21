package com.sortAlgorithms.Utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Timer {
    public static <E extends Comparable<E>> void execute(Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        long start = System.currentTimeMillis();
        method.invoke(null, args);
        long end = System.currentTimeMillis();
        System.out.println(method.getName() + "() time consumed: " + String.valueOf(end - start) + "ms\n");
    }

    public static void execute(Method method, int[] array) throws InvocationTargetException, IllegalAccessException {
        long start = System.currentTimeMillis();
        method.invoke(null, new Object[]{array});
        long end = System.currentTimeMillis();
        System.out.println(method.getName() + "() time consumed: " + String.valueOf(end - start) + "ms\n");
    }

    public static void execute(Object obj, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        long start = System.currentTimeMillis();
        method.invoke(obj, args);
        long end = System.currentTimeMillis();
        System.out.println(method.getName() + "() time consumed: " + String.valueOf(end - start) + "ms\n");
    }
}
