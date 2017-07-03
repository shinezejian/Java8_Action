package geym.conc.ch4.atomic;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * Created by zejian on 2017/7/2.
 * Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
 */
public class AtomicReferenceDemo2 {

    public static AtomicReference<User> atomicUserRef = new AtomicReference<User>();

    //注意更新的字段必须有volatile修饰,但不能使用private修饰,否则将抛出异常
    public static AtomicReferenceFieldUpdater atRefFieldUpdate =
            AtomicReferenceFieldUpdater.newUpdater(User.class,String.class,"name");


    public static void main(String[] args) {
        User user = new User("zejian", 18);
        atomicUserRef.set(user);
        User updateUser = new User("Shine", 25);
        atomicUserRef.compareAndSet(user, updateUser);
        //执行结果:User{name='Shine', age=25}
        System.out.println(atomicUserRef.get().toString());


        atRefFieldUpdate.compareAndSet(user,user.getName(),"JAVA-AND");
        //User{name='JAVA-AND', age=18}
        System.out.println(user.toString());

    }

    static class User {
        public volatile String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
