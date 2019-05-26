/**
 * @author XYZ Inc.
 */
public class X extends AbstractA implements A, B, C, Cloneable {
   final int val =33;
   public void foo() {
       System.out.println(super.val);
	   System.out.println("X: foo");
	   System.out.println("VAL: " + B.VAL);
   }
    public void go() {
       C.super.go();
        System.out.println("X: go");
    }

   public void foobar() {
	   System.out.println("X: foobar");
   }
   
   public C clone() {
      try {
		 return (C) super.clone();
      } catch(CloneNotSupportedException e) {
	     e.printStackTrace();
	  }
      
	  return null;
   }
 
}
