package containers;//: containers/FillingLists.java
// The Collections.fill() & Collections.nCopies() methods.
import java.util.*;

class StringAddress {
  private String s;
  public StringAddress(String s) { this.s = s; }
  public String toString() {
    return super.toString() + " " + s;
  }
}

public class FillingLists {
  public static void main(String[] args) {
    List<StringAddress> list= new ArrayList<>(
            //返回由指定对象的 n 个副本组成的不可变列表。
            Collections.nCopies(4, new StringAddress("Hello")));
    System.out.println(list);
    //使用指定元素替换指定列表中的所有元素。
    Collections.fill(list, new StringAddress("World!"));
    System.out.println(list);
  }
} /* Output: (Sample)
[StringAddress@82ba41 Hello, StringAddress@82ba41 Hello, StringAddress@82ba41 Hello, StringAddress@82ba41 Hello]
[StringAddress@923e30 World!, StringAddress@923e30 World!, StringAddress@923e30 World!, StringAddress@923e30 World!]
*///:~
