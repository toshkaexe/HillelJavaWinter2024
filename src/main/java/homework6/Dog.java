package homework6;

 class Dog extends Animal {
     private static int dogCount = 0;

     public Dog() {
         super(500, 10);
         dogCount ++;
     }
 }
