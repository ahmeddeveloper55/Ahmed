import java.util.*;

class A extends Thread
{ 
  public void run()
  {
   int c=0,i=0;
   boolean flag=true;
   while(c<3)
   {
     if(i%2 != 0)
     {
      System.out.println(i);
      c++;
     }
     i++;
     if(c==3)
     {
       flag = true;
       break;
     }
   }
   if(flag)
   { try{
     wait();
     }
     catch(Exception e)
     {}
   }
 } 
}

class B extends Thread
{ int n;
 B(int n)
 {
   this.n = n;
 }
 public void run()
 {
  int rev =0;
  while(n!=0)
  {
    int digit = n%10;
    rev = rev*10+digit;
    n/=10;
  }
  System.out.println("Reverse:"+rev);
 }
}

class TestThread
{
 public static void main(String args[])
 {
  A a = new A();
  a.start();
  B b = new B(1234);
  b.start();
 }
}


