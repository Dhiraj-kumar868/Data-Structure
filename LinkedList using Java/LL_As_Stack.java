public class LL_As_Stack {

    private LinkedList stack;
    public LL_As_Stack(){
        this.stack=new LinkedList();
    }  
    public int size(){
       return this.stack.size();
    }
    public boolean isEmpty(){
        return this.stack.isEmpty();
  
    }
    public void push(int data){
         this.stack.addFirst(data);
    }
    public int pop() throws Exception{
         return this.stack.removeFirst();
    }
    public int top() throws Exception{
           return this.stack.getFirst();
  }
  public void display(){
        this.stack.display();
  }
  
  public static void main(String[] args) throws Exception{
        LL_As_Stack stack=new LL_As_Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.display();
        System.out.println("top element is : "+stack.top());
        System.out.println("Size is : "+stack.size());
        System.out.println("LL is empty : "+stack.isEmpty());
        System.out.println("Removed element is : "+stack.pop());
        stack.display();
  }
  
    
}
