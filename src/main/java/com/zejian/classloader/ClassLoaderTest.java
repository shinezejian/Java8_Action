package com.zejian.classloader;

import java.io.*;
import java.security.ProtectionDomain;

/**
 * Created by zejian on 2017/6/18.
 * Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
 */
//自定义ClassLoader
class MyClassLoader extends  ClassLoader{
    private String rootDir;

    public MyClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    // 获取类的字节码
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getClassData(name);  // 获取类的字节数组
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] getClassData(String className) {
        // 读取类文件的字节
        String path = classNameToPath(className);
        try {
            InputStream ins = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead = 0;
            // 读取类文件的字节码
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 得到类文件的完全路径
     * @param className
     * @return
     */
    private String classNameToPath(String className) {
        return rootDir + File.separatorChar
                + className.replace('.', File.separatorChar) + ".class";
    }
}

public class ClassLoaderTest {
    private native Class<?> defineClass2(String name, java.nio.ByteBuffer b,
                                         int off, int len, ProtectionDomain pd,
                                         String source);
    public static void main(String[] args) throws ClassNotFoundException {


//        System.out.println("自定义类加载器的父加载器: "+loader1.getParent());
//        System.out.println("系统默认的AppClassLoader: "+ClassLoader.getSystemClassLoader());
//        System.out.println("AppClassLoader的父类加载器: "+ClassLoader.getSystemClassLoader().getParent());
//        System.out.println("ExtClassLoader的父类加载器: "+ClassLoader.getSystemClassLoader().getParent().getParent());

        /**
         输出结果:
             自定义类加载器的父加载器: sun.misc.Launcher$AppClassLoader@29453f44
             系统默认的AppClassLoader: sun.misc.Launcher$AppClassLoader@29453f44
             AppClassLoader的父类加载器: sun.misc.Launcher$ExtClassLoader@6f94fa3e
             ExtClassLoader的父类加载器: null
         */

        String rootDir="/Users/zejian/Downloads/Java8_Action/src/main/java/";
        MyClassLoader loader1 = new MyClassLoader(rootDir);
        MyClassLoader loader2 = new MyClassLoader(rootDir);

        try {
            Class<?> object1=loader1.findClass("com.zejian.classloader.DemoObj");
            Class<?> object2=loader2.findClass("com.zejian.classloader.DemoObj");
            System.out.println("findClass->obj1:"+object1.hashCode());
            System.out.println("findClass->obj2:"+object2.hashCode());

            /**
             * 直接调用findClass方法输出结果:
             * findClass->obj1:723074861
               findClass->obj2:895328852
               生成不同的实例
             */

            //直接调用父类的loadClass()方法
            Class<?> obj1 =loader1.loadClass("com.zejian.classloader.DemoObj");
            Class<?> obj2 =loader2.loadClass("com.zejian.classloader.DemoObj");

            //不同实例对象的自定义类加载器
            System.out.println("loadClass->obj1:"+obj1.hashCode());
            System.out.println("loadClass->obj2:"+obj2.hashCode());
            //系统类加载器
            System.out.println("Class->obj3:"+DemoObj.class.hashCode());

            /**
             * 直接调用loadClass方法的输出结果,注意并没有重写loadClass方法
             * loadClass->obj1:1872034366
               loadClass->obj2:1872034366
               Class->    obj3:1872034366
               都是同一个实例
             */

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
