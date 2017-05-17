package reflect;

import java.lang.reflect.Field;

/**
 * Created by zejian on 2017/5/1.
 * Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
 */
public class ReflectField {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
//        Class<?> clazz = Class.forName("reflect.Student");
//        //获取指定字段名称的Field类,注意字段修饰符必须为public而且存在该字段,
//        // 否则抛NoSuchFieldException
//        Field field = clazz.getField("age");
//        System.out.println("field:"+field);
//
//        //获取所有修饰符为public的字段,包含父类字段,注意修饰符为public才会获取
//        Field fields[] = clazz.getFields();
//        for (Field f:fields) {
//            System.out.println("f:"+f);
//        }
//
//        System.out.println("================getDeclaredFields====================");
//        //获取当前类所字段(包含private字段),注意不包含父类的字段
//        Field fields2[] = clazz.getDeclaredFields();
//        for (Field f2:fields2) {
//            System.out.println("f2:"+f2);
//        }
//        //获取指定字段名称的Field类,可以是任意修饰符的自动,注意不包含父类的字段
//        Field field2 = clazz.getDeclaredField("desc");
//        System.out.println("field2:"+field2);

        //获取Class对象引用
        Class<?> clazz = Class.forName("reflect.Student");

        Student st= (Student) clazz.newInstance();
        //获取父类public字段并赋值
        Field ageField = clazz.getField("age");
        ageField.set(st,18);
        Field nameField = clazz.getField("name");
        nameField.set(st,"Lily");

        //只获取当前类的字段,不获取父类的字段
        Field descField = clazz.getDeclaredField("desc");
        descField.set(st,"I am student");
        Field scoreField = clazz.getDeclaredField("score");
        //设置可访问
        scoreField.setAccessible(true);
        scoreField.set(st,88);
        System.out.println(st.toString());

        //获取字段值
        System.out.println(scoreField.get(st));
        //>	getType()
        System.out.println("getType():"+scoreField.getType());



    }

}


class Person{
    public int age;
    public String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return
                "age=" + age +
                ", name='" + name ;
    }
}

class Student extends Person{
    public String desc;
    private int score;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +super.toString()+
                " ,desc='" + desc + '\'' +
                ", score=" + score +
                "} ";
    }
}