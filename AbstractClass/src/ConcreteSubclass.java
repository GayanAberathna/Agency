public class ConcreteSubclass extends AbstractSubclass {

    static void method (){
        System.out.println("ConcreteSubclass");
    }

    @Override
    void test2() {
        System.out.println("test2");
    }
    @Override
    void test3() {
        System.out.println("test3");
    }

   public static void main(String[] args) {
       AbstractSuperclass concrete = new ConcreteSubclass();
	   concrete.test1();
	   concrete.test2();
       System.out.println(id);
	   //concrete.test3();
	   //AbstractSuperclass test = new AbstractSuperclass();
   }
}
