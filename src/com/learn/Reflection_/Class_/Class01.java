package com.learn.Reflection_.Class_;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        String classFullPath = "com.learn.Car";
        //获取到Car类对应的Class对象
        Class<?> cls = Class.forName(classFullPath);
        //输出cls
        System.out.println(cls); //显示cls对象是哪个类的Class对象
        System.out.println(cls.getClass()); //运行类型
        //得到包名
        System.out.println(cls.getPackageName());
        //得到类名
        System.out.println(cls.getName());
        //通过cls创建对象实例
        Object o = cls.getDeclaredConstructor().newInstance();
        System.out.println(o); //调用toString
        //通过反射获取属性
        Field brand = cls.getField("brand");
        System.out.println(brand.get(o)); //不能为私有属性
        //通过反射给属性赋值
        brand.set(o, "奥迪");
        System.out.println(brand.get(o));
        //得到所有的属性
        System.out.println("=================");
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            System.out.println(field.getName()); //属性名称
            System.out.println(field.get(o)); //值
        }
    }
}
