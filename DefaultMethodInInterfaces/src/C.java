/**
 * @author ABC Inc.
 */
public interface C extends A {
   void foobar();
   default void go() {
      System.out.println("C: go");
   }
   private static void staticMethod(){
      System.out.println("C: Static Method");
   }
}
