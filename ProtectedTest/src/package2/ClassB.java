package package2;

public class ClassB implements Cloneable {
    String check;
    ClassB(){}
    ClassB(String s){
        check = s;
    }
    public static void main(String[] args) {
        ClassB cb = new ClassB();
        ClassB newCb = cb.methodInA();
        System.out.println(newCb.check);
    }
   public ClassB methodInA(){
       try {
           return (ClassB) super.clone();
       } catch (CloneNotSupportedException e) {
           e.printStackTrace();
           return new ClassB("error one");
       }
   }
}
