import java.util.*;

public class BinaryTree {
    private class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root = null;
    private int size = 0;

    BinaryTree() {
        Scanner sc = new Scanner(System.in);
        this.root = takeInput(sc, null, false);
    }

    private Node takeInput(Scanner sc, Node parent, boolean isLeftOrRight) {
        if (parent == null) {
            System.out.println("Enter the data for root node:");
        } else {
            if (isLeftOrRight) {
                System.out.println("Enter the data for left child of " + parent.data);
            } else {
                System.out.println("Enter the data for right child of " + parent.data);
            }
        }
        int nodeData = sc.nextInt();
        Node node = new Node(nodeData, null, null);
        this.size++;
        boolean choice = false;
        System.out.println("Do you have left child of " + node.data);
        choice = sc.nextBoolean();
        if (choice) {
            node.left = takeInput(sc, node, true);
        }

        choice = false;
        System.out.println("Do you have right child of " + node.data);
        choice = sc.nextBoolean();
        if (choice) {
            node.right = takeInput(sc, node, false);
        }
        return node;
    }

    public void display() {
        this.display(this.root);
    }

    private void display(Node node) {
        String str = "";
        if (node.left != null) {
            str = str + node.left.data + "=>";
        } else {
            str = str + "END=>";
        }
        str = str + node.data;
        if (node.right != null) {
            str = str + "<=" + node.right.data;
        } else {
            str = str + "<=END";
        }
        System.out.println(str);
        if (node.left != null) {
            this.display(node.left);
        }
        if (node.right != null) {
            this.display(node.right);
        }
    }

    public int height() {
        return this.height(this.root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        int lheight = this.height(node.left);
        int rheight = this.height(node.right);
        int height = Math.max(lheight, rheight) + 1;
        return height;
    }

    public void preOrder() {
        this.preOrder(this.root);
    }

    private void preOrder(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " => ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        this.inOrder(this.root);
    }

    private void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print(node.data + " => ");
        inOrder(node.right);
    }

    public void postOrder() {
        this.postOrder(this.root);
    }

    private void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " => ");
    }

    public void levelOrder() {
        if (root == null)
            return;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            Node rv = queue.removeFirst();
            System.out.print(rv.data + " => ");
            if (rv.left != null) {
                queue.addLast(rv.left);
            }
            if (rv.right != null) {
                queue.addLast(rv.right);
            }
        }
        System.out.println("End");
    }

    public boolean isBST() {
        return this.isBST(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.data > max || node.data < min) {
            return false;
        } else if (!this.isBST(node.left, min, node.data)) {
            return false;
        } else if (!this.isBST(node.right, node.data, max)) {
            return false;
        }
        return true;

    }

    public List<Integer> inOrderTraversal() {
        return this.inOrderTraversal(this.root);
    }

    private List<Integer> inOrderTraversal(Node node) {
        if (node == null) {
            ArrayList<Integer> list = new ArrayList<>();
            return list;
        }
        Stack<Node> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                node = stack.pop();
                list.add(node.data);
                node = node.right;
            }
        }
        return list;
    }

    public int sumOfLeaf() {
        return this.sumOfLeaf(this.root);
    }

    private int sumOfLeaf(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return node.data;
        }
        int lsum = sumOfLeaf(node.left);
        int rsum = sumOfLeaf(node.right);
        return lsum + rsum;
    }


    //Time complexity for this approach of finding diameter of binary tree is O(n^2).
    public int diameter() {
        return this.diameter(this.root);
    }s

    private int diameter(Node node) {
        if (node == null) {
            return -1;
        }
        // when diameter passes through the root
        int case1 = this.height(node.left) + this.height(node.right) + 2;
        int case2 = this.diameter(node.left);
        int case3 = this.diameter(node.right);
        return Math.max(case1, Math.max(case2, case3));
    }

    public int diameterBtr() {
        return this.diameterBtr(this.root).diameter;
    }

    //Time complexity for this approach of finding diameter of binary tree is O(n).
    private DiaPair diameterBtr(Node node) {
        if (node == null) {
            DiaPair bp = new DiaPair(-1, 0);
            return bp;
        }
        DiaPair lp = this.diameterBtr(node.left);
        DiaPair rp = this.diameterBtr(node.right);
        DiaPair mp = new DiaPair();
        mp.height = Math.max(lp.height, rp.height) + 1;
        mp.diameter = Math.max(lp.height + rp.height + 2, Math.max(lp.diameter, rp.diameter));
        return mp;
    }

    public class DiaPair {
        int height;
        int diameter;

        DiaPair() {

        }

        DiaPair(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }

    }

    // 50 true 25 true 38 false false true 48 true 18 false false false true 45 true 85 false false true 60 false false
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.display();
        System.out.println("Height : " + tree.height());
        System.out.println("PreOrder Traversal:");
        tree.preOrder();
        System.out.println("End");
        System.out.println();
        System.out.println("InOrder Traversal:");
        tree.inOrder();
        System.out.println("End");
        System.out.println();
        System.out.println("PostOrder Traversal:");
        tree.postOrder();
        System.out.println("End");
        System.out.println();
        System.out.println("LevelOrder Traversal:");
        tree.levelOrder();
        System.out.println();
        System.out.println("Is BST : " + tree.isBST());
        System.out.println();
        System.out.println("Iterative InOrder Traversal:");
        List<Integer> arr = new ArrayList<>();
        arr = tree.inOrderTraversal();
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
        System.out.print("Sum of all the leaf Nodes:" + tree.sumOfLeaf());
        System.out.println();
        System.out.print("Diameter of Binary Tree:" + tree.diameter());

        System.out.println();
        System.out.print("Diameter of Binary Tree:" + tree.diameterBtr());
    }
}