public class LL_As_Queue {
  private LinkedList queue;
  public LL_As_Queue(){
      this.queue=new LinkedList();
  }  
  public int size(){
     return this.queue.size();
  }
  public boolean isEmpty(){
      return this.queue.isEmpty();

  }
  public void enqueue(int data){
       this.queue.addLast(data);
  }
  public int dequeue() throws Exception{
       return this.queue.removeFirst();
  }
  public int front() throws Exception{
         return this.queue.getFirst();
}
public void display(){
      this.queue.display();
}

public static void main(String[] args) throws Exception{
      LL_As_Queue queue=new LL_As_Queue();
      queue.enqueue(10);
      queue.enqueue(20);
      queue.enqueue(30);
      queue.enqueue(40);
      queue.enqueue(50);
      queue.display();
      System.out.println("Front element is : "+queue.front());
      System.out.println("Size is : "+queue.size());
      System.out.println("LL is empty : "+queue.isEmpty());
      System.out.println("Removed element is : "+queue.dequeue());
      queue.display();
}

}
