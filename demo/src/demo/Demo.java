
package demo;

import java.util.Arrays;

class stack{
  private int top; // index
   private static int array[]=new int[1];// the array
 
    public stack() {
        top=-1;
     
    }

   public void push(int element){
        
          ensureCapacityOfArray(top+2);
           top+=1; 
       array[top]=element; 

   }
    int peek(){
        return array[top];
    }
    
   private void ensureCapacityOfArray(int s){   // double size
         int oldCapacity=array.length;
          if(s >oldCapacity){ 
              int newSize=oldCapacity*2;
            array=Arrays.copyOf(array, newSize);   // copy the array to new size 
        }     
    }
   
 
     public boolean empty(){
        
        return top==-1;
    }
   public int pop(){
     
      if(empty()) {
           System.out.println("the stack is empty");
      }
        int item= array[top];
  
     top--;
       
        return item;
    }
   public int search(int item){
         reverse();
        for (int i = 0; i <=top; i++) {
            if(array[i]==item)
                return i;
        }
        
     return (-1);
       
    } 
    
   public int size(){
       return array.length;
   }
     private void reverse(){
         // method to reverse the index of array
                  int start = 0;
      int end=top;
      while (start < end){
    int temp = array[start];
    array[start] = array[end];
    array[end] = temp;
    start++;
    end--;}
     
    }
    
      public void print(){
        
       reverse();
          System.out.print("[");
       for (int i = 0; i <=top; i++) { 
           System.out.print(array[i]);
           if(i<top)
               System.out.print(",");
           
       }
          System.out.print("]\n");
      }
    
   int performOperation(int op1, int op2, char op)
     {
	int ans = 0;
	switch (op) 
                  {
	case '+':
		ans = op2 + op1;
		break;
	case '-':
		ans = op2 - op1;
		break;
	case '*':
		ans = op2 * op1;
		break;
	case '/':
		ans = op2 / op1;
		break;
	            }  
	return ans;
    }
 }

public class Demo {

    public static void main(String[] args) {
       
        try {

 stack s=new stack();

      String post = "984*+";   //Postfix expression
                for(int i=0;i<post.length();i++)   //Expression is traversed
        {
            char ch=post.charAt(i);
            if(ch>=48 && ch<=57)   //Checking for digit
                      s.push(ch-48);
            else 
            {
                //Two operands are being popped
                int p1=s.pop(); 
                int p2=s.pop();
              int r=  s.performOperation(p1, p2, ch);
                s.push(r);  //Result is pushed to stack
            }
        }
            s.print();
    } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            System.out.println("check the data type or the postfix expression ");
    } 
        
        
    
    
}}
