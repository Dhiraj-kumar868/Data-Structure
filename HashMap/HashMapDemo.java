import java.util.*;
public class HashMapDemo {
    public static void main(String[] args){
        HashMap<String,Integer> map=new HashMap<>();
        map.put("USA",300);
        map.put("India",350);
        map.put("Nepal",390);
        map.put("Canada",200);
        map.put("Germany ",340);
        System.out.println(map);
        map.put("India",500);
        System.out.println(map);
        System.out.println(map.get("Canada"));
        System.out.println(map.get("Japan"));
        System.out.println(map.remove("Canada"));
        System.out.println(map);
        System.out.println(map.containsKey("India"));
        System.out.println(map.containsValue(350));
        System.out.println("*****Keys*****");
        Set<String> keys=map.keySet();
        for(String key:keys){
            System.out.println(key);
        }
        System.out.println("*****Values*****");
        Collection<Integer> values=map.values();
        for(int value:values){
            System.out.println(value);
        }
        System.out.println("*****EntrySet*****");
        Set<Map.Entry<String,Integer>> entries=map.entrySet();
        for(Map.Entry<String, Integer> entry:entries){
            System.out.println(entry.getKey()+ "=>" +entry.getValue());
        }
        System.out.println("*****Max Occuring Character*****");
        String str="aabbaaabcdda";
        System.out.println(getMaxFreq(str));
        System.out.println("*****Intersection of Two Arrays*****");
        int[] array1={1,2,3,4,5,6};
        int[] array2={2,4,6,8,10};
        ArrayList<Integer> list=getIntersection(array1,array2);
        System.out.println(list);
    }

    //It will return the character having maximum frequency in the given string.
    public static char getMaxFreq(String str){
           HashMap<Character,Integer> map=new HashMap<>();
           for(int i=0;i<str.length();i++){
               char cc=str.charAt(i);
               if(map.containsKey(cc)){
                  int oldValue=map.get(cc);
                  int newValue=oldValue+1;
                  map.put(cc,newValue);
               }else{
                   map.put(cc,1);
               }
           }
           char maxChar='\0';
           int max=0;
           Set<Map.Entry<Character,Integer>> entries=map.entrySet();
           for(Map.Entry<Character,Integer> entry:entries){
             if(entry.getValue()>max){
               max=entry.getValue();
               maxChar=entry.getKey();
           }
        }
        return maxChar;
    }


    //It will return the ArrayList of Intersection Between given Two arrays.
    public static ArrayList<Integer> getIntersection(int[] array1,int[] array2){
       HashMap<Integer,Boolean> map=new HashMap<>();
       ArrayList<Integer> list=new ArrayList<>();
       for(int i=0;i<array1.length;i++){
           map.put(array1[i],false);
       }
       for(int j=0;j<array2.length;j++){
           if(map.containsKey(array2[j])){
              map.put(array2[j],true); 
           }
    }
    Set<Map.Entry<Integer,Boolean>> entries=map.entrySet();
           for(Map.Entry<Integer,Boolean> entry:entries){
             if(entry.getValue()){
              list.add(entry.getKey());
           }
        }

       return list;
    }
}
