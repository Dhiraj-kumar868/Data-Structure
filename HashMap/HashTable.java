public class HashTable<K,V> {
    private class HTPair{
      K key;
      V value;
      HTPair(K key,V value){
          this.key=key;
          this.value=value;
      }
      public boolean equals(Object other){
          HTPair otherPair=(HTPair) other;
           return this.key.equals(otherPair.key);
      }
      public String toString(){
          return "{"+this.key+"-"+this.value+"}"+" => ";
      }
    }
    public static final int DEFAULT_CAPACITY=10;
    private LinkedList<HTPair>[] bucketArray;
    private int size;
    public HashTable(){
        this(DEFAULT_CAPACITY);
    }
    public HashTable(int capacity){
        this.bucketArray=(LinkedList<HTPair>[]) new LinkedList[capacity];
        this.size=0;
    }

    public void put(K key,V value) throws Exception{
         int baseIndex=hashFunction(key);
         LinkedList<HTPair> bucket=this.bucketArray[baseIndex];
         HTPair newPair=new HTPair(key,value);
         if(bucket==null){
            bucket=new LinkedList<>();
            bucket.addLast(newPair);
            this.bucketArray[baseIndex]=bucket;
            this.size++;
         }else{
             int findAt=bucket.find(newPair);
             if(findAt==-1){
                bucket.addLast(newPair);
                this.size++;
             }else{
                 HTPair pair=bucket.getAt(findAt);
                 pair.value=value;
             }

         }
         double lamda=(this.size*1.0)/this.bucketArray.length;
         if(lamda>0.75){
             this.rehash();
         }
    }
    private void rehash() throws Exception{
        LinkedList<HTPair>[] oba=this.bucketArray;
        this.bucketArray=(LinkedList<HTPair>[]) new LinkedList[2*oba.length];
        this.size=0;
        for(LinkedList<HTPair> ob:oba){
            while(ob!=null && !ob.isEmpty()){
                HTPair pair=ob.removeFirst();
                this.put(pair.key,pair.value);
            }
        }
    }


    public V get(K key) throws Exception{
        int baseIndex=hashFunction(key); 
        LinkedList<HTPair> bucket=this.bucketArray[baseIndex];
        HTPair ptf=new HTPair(key, null);
        if(bucket==null){
           return null;
        }else{
            int findAt=bucket.find(ptf);
             if(findAt==-1){
                return null;
             }else{
                 HTPair pair=bucket.getAt(findAt);
                  return pair.value;
             }
           
        }
    }

    public V remove(K key) throws Exception{
        int baseIndex=hashFunction(key); 
        LinkedList<HTPair> bucket=this.bucketArray[baseIndex];
        HTPair ptf=new HTPair(key, null);
        if(bucket==null){
           return null;
        }else{
            int findAt=bucket.find(ptf);
             if(findAt==-1){
                return null;
             }else{
                 HTPair pair=bucket.getAt(findAt);
                 bucket.removeAt(findAt);
                 this.size--;
                  return pair.value;
             }
           
        }
    }

    private int hashFunction(K key){
        int hashCode=key.hashCode();
        hashCode=Math.abs(hashCode);
        int baseIndex=hashCode%this.bucketArray.length;
        return baseIndex;
    }

    public void display(){
        for(LinkedList<HTPair> bucket:this.bucketArray){
            if(bucket!=null && !bucket.isEmpty()){
                bucket.display();
            }else{
                System.out.println("------------------------");
                System.out.println("NULL");
                System.out.println("------------------------");
            }
        }
       
    }
    public static void main(String[] args) throws Exception{
        HashTable<String,Integer> map=new HashTable<>(3);
        map.put("USA",300);
        map.put("India",350);
        map.put("Nepal",390);
        map.put("Canada",200);
        map.put("Germany ",340);
        map.display();
        System.out.println("******Get*******");
        System.out.println(map.get("India"));
        System.out.println("******Remove*******");
        System.out.println(map.remove("India"));
        map.display();
    }

}
