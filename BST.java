public class BST {
    private class Node{
        int data;
        Node left;
        Node right;
    }
    private Node root;
    public BST(int[] arr){
      this.root=create(arr,0,arr.length-1);
    }
    private Node create(int[] arr,int lb,int ub){
        if(lb>ub){
            return null;
        } 
        int mid=(lb+ub)/2;
         Node node=new Node();
         node.data=arr[mid];
         node.left=create(arr,lb,mid-1);
         node.right=create(arr,mid+1,ub);
         return node;
    }

     public void display(){
         display(this.root);
     }
    private void display(Node node){
        if(node==null){
            return;
        }
        String str="";
        if(node.left==null){
            str=str+".";
        }else{
            str+=node.left.data;
        }
        str+=" -> "+node.data+" <- ";
        if(node.right==null){
            str=str+".";
        }else{
            str+=node.right.data;
        }
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
    public boolean search(int value){
        return search(this.root,value);
    }

    private boolean search(Node node,int value){
        if(node==null){
            return false; 
        }
        if(value>node.data){
            return search(node.right,value);
        }else if(value<node.data){
            return search(node.left,value);
        }else{
            return true;
        }
    }

   public int max(){
       return max(this.root);
   }
   private int max(Node node){
       if(node.right==null){
           return node.data;
       }
       return max(node.right);

   }

   public void add(int value){
       add(this.root,value);
   }
   private void add(Node node,int value){
       if(value>node.data){
           if(node.right==null){
                Node nn=new Node();
                nn.data=value;
                node.right=nn;
           }else{
               add(node.right,value);
           }

       }else{
        if(node.left==null){
            Node nn=new Node();
            nn.data=value;
            node.left=nn;
       }else{
           add(node.left,value);
       }
       }
   }

   public void remove(int value){
       remove(this.root,null,false,value);
   }
   private void remove(Node node,Node parent,boolean ilc,int value){
       if(node==null){
           return;
       }
       if(value>node.data){
           remove(node.right,node,false,value);
       }else if(value<node.data){
        remove(node.left,node,true,value);
       }else{

        if(node.left==null && node.right==null){
            if(ilc){
                parent.left=null;
            }
            else{
                parent.right=null;
            }
        }
        else if(node.left==null && node.right!=null){
            if(ilc){
                parent.left=node.right;
            }else{
            parent.right=node.right;
            }
        }
        else if(node.left!=null && node.right==null){
            if(ilc){
                parent.left=node.left;
            }else{
            parent.right=node.left;
            }
        }
        else {
            int max=max(node.left);
            node.data=max;
            remove(node.left,node,true,max);
        }
    }
   }


    public static void main(String[] args){ 
        int [] arr={1,2,3,5,6,7,8};
        BST bst=new BST(arr);
        bst.display();
        System.out.println();
        System.out.println(bst.search(3));
        System.out.println();
        System.out.println("Maximum element: "+bst.max());
        bst.add(4);
        System.out.println("After Adding new data.");
        bst.display();
        System.out.println("After removing the given data.");
        bst.remove(4);
        bst.display();

    }
    
}
