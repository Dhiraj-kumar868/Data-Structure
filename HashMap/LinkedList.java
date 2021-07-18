public class LinkedList<T> {
  private class Node{
      T data;
      Node next;
  }  
  private Node head;
  private Node tail;
  private int size;

 //O(n)
  public void display(){
    System.out.println("------------------------");
      Node temp=this.head;
      while(temp!=null){
          System.out.print(temp.data+"  ");
          temp=temp.next;
      }
      System.out.print("End");
      System.out.println();
      System.out.println("------------------------");
  }

  //O(1)
  public void addLast(T item){
      Node nn=new Node();
      nn.data=item;
      nn.next=null;
      if(this.size>=1){
          this.tail.next=nn;
      }
      if(this.size==0){
         this.head=nn;
         this.tail=nn;
         this.size++;
      }else{
         this.tail=nn;
         this.size++;
      }
  }

  //O(1)
  public void addFirst(T item){
      Node nn=new Node();
      nn.data=item;
      nn.next=null;
      if(this.size>=1){
          nn.next=head;
      }
      if(this.size==0){
        this.head=nn;
        this.tail=nn;
        this.size++;
      }else{
          this.head=nn;
          this.size++;
      }

  }

  //O(n)
  public Node getNodeAt(int index) throws Exception{
      if(this.size==0){
          throw new Exception("LL is Empty.");
      }
      if(index<0 || index>=this.size){
          throw new Exception("Invalid Index."); 
      }
      Node temp=this.head;
      for(int i=1;i<=index;i++){
          temp=temp.next;
      }
      return temp;
  } 

  //O(n)
  public T getAt(int index) throws Exception{
    if(this.size==0){
        throw new Exception("LL is Empty.");
    }
    if(index<0 || index>=this.size){
        throw new Exception("Invalid Index."); 
    }
    Node temp=this.head;
    for(int i=1;i<=index;i++){
        temp=temp.next;
    }
    return temp.data;
} 

  //O(1)
  public T getFirst() throws Exception{
    if(this.size==0){
        throw new Exception("LL is Empty");
    }
    return this.head.data;
  }

  //O(1)
  public T getLast() throws Exception{
    if(this.size==0){
        throw new Exception("LL is Empty");
    }
    return this.tail.data;
  }
 
  //O(1)
  public T removeFirst() throws Exception{
      if(this.size==0){
        throw new Exception("LL is Empty");
      }
      T rv=this.head.data;
      if(this.size==1){
          this.head=null;
          this.tail=null;
          this.size=0;
      }else{
          this.head=this.head.next;
          this.size--;
      }
      return rv;
  }
   
  //O(n)
  public T removeAt(int index) throws Exception{
    if(this.size==0){
        throw new Exception("LL is Empty.");
    }
    if(index<0 || index>=this.size){
        throw new Exception("Invalid Index."); 
    }
    if(index==0){
        return removeFirst();
    }else if(index==this.size-1){
        return removeLast();
    }else{
        Node nm1=getNodeAt(index-1);
        Node n=nm1.next;
        Node np1=n.next;
        nm1.next=np1;
        this.size--;
        return n.data;
    }  
}

//O(n)
public T removeLast() throws Exception{
    if(this.size==0){
        throw new Exception("LL is Empty.");
    }
   T rv=this.tail.data;
   if(this.size==1){
       this.head=null;
       this.tail=null;
       this.size=0;
   }else{
   Node sizem2=getNodeAt(this.size-2);
   this.tail=sizem2;
   this.tail.next=null;
   this.size--;
   }
   return rv;
}

//O(n)
public void reverseData() throws Exception{
    int left=0;
    int right=this.size-1;
    while(left<right){
        Node ln=getNodeAt(left);
        Node rn=getNodeAt(right);
        T temp=ln.data;
        ln.data=rn.data;
        rn.data=temp;
        left++;
        right--;
    }
}

 //O(n)
public void reversePointers(){
    Node prev=this.head;
    Node curr=prev.next;
    while(curr!=null){
        Node ahead=curr.next;
        curr.next=prev;
        prev=curr;
        curr=ahead;
    }
    Node t=this.head;
    this.head=this.tail;
    this.tail=t;
    this.tail.next=null;
}

public T midNode(){
    Node temp1=this.head;
    Node temp2=this.head;
    while(temp2.next!=null && temp2.next.next!=null){
        temp1=temp1.next;
        temp2=temp2.next.next;
    }
    return temp1.data;
}
public int size(){
    return size;
}

public boolean isEmpty(){
    return size==0;
}

public int find(T data){
    int index=0;
    for(Node temp=this.head;temp!=null;temp=temp.next){
        if(temp.data.equals(data)){
            return index;
        }
        index++;
    }
    return -1;
}
  public static void main(String[] args) throws Exception{
      LinkedList<Integer> list=new LinkedList<>();
      list.addLast(10);
      list.addFirst(20);
      list.addLast(30);
      list.addLast(40);
      list.addLast(50);
      list.display();
      System.out.println("Mid element is : "+list.midNode());
      System.out.println("Element at index 3 is : "+list.getNodeAt(3).data);
      System.out.println("First element is : "+list.getFirst());
      System.out.println("Last element is : "+list.getLast());
      System.out.println("Removed first element is : "+list.removeFirst());
      System.out.println("Removed element of index 2 is : "+list.removeAt(2));
      System.out.println("Removed last element is : "+list.removeLast());
      list.display();
      list.reverseData();
      list.display();
      list.reversePointers ();
      list.display();
      System.out.println("Size is : "+list.size());
      System.out.println("LL is Empty : "+list.isEmpty());
      
  }
}
