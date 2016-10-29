package selfPreparation;

public class Test2 {
    
    Test1 t1 = new Test1(10);   
    int x;
    Test2(int i) { t1 = new Test1(i); 
    t1.method();} 
  
    public static void main(String[] args) {    
        Test2 t2 = new Test2(5);
        System.out.println(t2.x);
   }
}
