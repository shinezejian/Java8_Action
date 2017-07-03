package com.zejian.classloader;

import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

/**
 * Created by zejian on 2017/6/17.
 * Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
 */
public class HotSwapClassLoader extends URLClassLoader {
    public HotSwapClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public HotSwapClassLoader(URL[] urls) {
        super(urls);
    }

    public HotSwapClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
    }


    // 下面的两个重载load方法实现类的加载，仿照ClassLoader中的两个loadClass()
    // 具体的加载过程代理给父类中的相应方法来完成
    public Class<?> load(String name) throws ClassNotFoundException {
        return load(name, false);
    }

    public Class<?> load(String name, boolean resolve) throws ClassNotFoundException {
        // 若类已经被加载，则重新再加载一次
        if (null != super.findLoadedClass(name)) {
            return reload(name, resolve);
        }
        // 否则用findClass()首次加载它
        Class<?> clazz = super.findClass(name);
        if (resolve) {
            super.resolveClass(clazz);
        }

//        Class.forName()
//        sun.misc.Launcher
        return clazz;
    }

    public Class<?> reload(String name, boolean resolve) throws ClassNotFoundException {
        return new HotSwapClassLoader(super.getURLs(), super.getParent()).load(
                name, resolve);
    }
}
