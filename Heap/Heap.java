import java.util.ArrayList;

public class Heap{
    ArrayList<Integer> data=new ArrayList<>();

    //O(logn)
    public void add(int item){
        data.add(item);
        upheapify(data.size()-1);
    }

    //O(logn)
    private void upheapify(int child_index) {
        int parent_index=(child_index-1)/2;
        if(data.get(child_index)<data.get(parent_index)){
            swap(parent_index,child_index);
            upheapify(parent_index);
        }
    }

    //O(1)
    private void swap(int i, int j){
        int ith=data.get(i);
        int jth=data.get(j);
        data.set(i,jth);
        data.set(j,ith);
    }
    public void display(){
        System.out.println(data);
    }
    public int size(){
        return this.data.size();
    }
    public boolean isEmpty(){
          return this.data.size()==0;
    }


    //O(logn)
    public int remove(){
        swap(0,this.data.size()-1);
        int rv=this.data.remove(this.data.size()-1);
        downheapify(0);
        return rv;
    }

    //O(logn)
    private void downheapify(int pi) {
        int lChildIndex=2*pi+1;
        int rChildIndex=2*pi+2;
        int minIndex=pi;
        if(lChildIndex<this.data.size() && data.get(lChildIndex)<data.get(minIndex)){
            minIndex=lChildIndex;
        }
        if(rChildIndex<this.data.size() && data.get(rChildIndex)<data.get(minIndex)){
            minIndex=rChildIndex;
        }
        if(minIndex!=pi){
          swap(pi,minIndex);
          downheapify(minIndex);
        }
    }

    //O(1)
    public int get(){
        return this.data.get(0);
    }
    public static void main(String[] args){
        Heap heap=new Heap();
        heap.add(10);
        heap.display();
        heap.add(5);
        heap.display();
        heap.add(34);
        heap.display();
        heap.add(24);
        heap.display();
        heap.add(90);
        heap.display();
        System.out.println("Removed Element is : "+heap.remove());
        System.out.println("Parent Element is : "+heap.get());
        System.out.println("Size is : "+heap.size());
        System.out.println("Is Empty : "+heap.isEmpty());
        heap.display();
    }

}