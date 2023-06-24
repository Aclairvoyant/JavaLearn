package com.learn.Reflection_;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Reflection01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/re.properties"));
        String className = properties.get("classFullName").toString();
        String methodName = properties.get("method").toString();

        Class<?> aClass = Class.forName(className);
        Object o = aClass.getDeclaredConstructor().newInstance();
        Method method = aClass.getMethod(methodName);
        method.invoke(o);

        //得到name属性,不能为私有
        Field age = aClass.getField("age");
        System.out.println(age.get(o));
        //构造器
        Constructor<?> constructor = aClass.getConstructor();
        System.out.println(constructor);
    }
}
