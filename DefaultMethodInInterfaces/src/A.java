public interface A {
   int VAL = 5;
   void foo();
   void bar();
   default void ddd() {

      System.out.println("A: DD");
      staticMethod();
   }
   private static void staticMethod(){
      System.out.println("DDD: Static Method");
   }
}
