package enumerated;//: enumerated/ConstantSpecificMethod.java
import java.util.*;
import java.text.*;

public enum ConstantSpecificMethod {
  DATE_TIME {
    String getInfo() {
      return
        DateFormat.getDateInstance().format(new Date());
    }
  },
  CLASSPATH {
    String getInfo() {
      return System.getenv("CLASSPATH");
    }
  },
  VERSION {
    String getInfo() {
      return System.getProperty("java.version");
    }
  };
  abstract String getInfo();
  public static void main(String[] args) {
    ConstantSpecificMethod.DATE_TIME.getInfo();
    for(ConstantSpecificMethod csm : values()) {
      System.out.println(csm.getInfo());
      System.out.println(csm);
    }
  }
} /* (Execute to see output) *///:~
