package com.zejian;

import org.omg.CORBA.Object;

/**
 * Created by zejian on 2017/4/30.
 * Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
 */
public class ClassCast {

 public void cast(){

     Animal animal= new Dog();
     //强制转换
     Dog dog = (Dog) animal;
//
     Class<Dog> dogType = Dog.class;
     Dog dog1 = dogType.cast(animal);

     dogType.isInstance(dog);

 }

    public void cast2(Object obj){
        //instanceof关键字
        if(obj instanceof Animal){
            Animal animal= (Animal) obj;
        }

        //isInstance方法
        if(Animal.class.isInstance(obj)){
            Animal animal= (Animal) obj;
        }
    }

}

interface BigHouse{

}

interface Animal{

}

class Dog implements  Animal{

}
