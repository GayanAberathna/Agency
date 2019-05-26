public interface B {
   int VAL = TestClient.getVal();
   void foo();
   default void go() {
      System.out.println("B: go");
   }
   static void staticMethod(){
      System.out.println("B: Static Method");
   }
}
