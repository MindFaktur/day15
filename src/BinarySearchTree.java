public class BinarySearchTree {

    public static void main(String[] args) {
        TreeOperations<Integer> obj = new TreeOperations<>();
        obj.addKey(56);
        obj.addKey(30);
        obj.addKey(76);
        obj.addKey(80);
        obj.addKey(20);
        obj.addKey(90);
        obj.addKey(25);
        int size = obj.getSize();
        System.out.println("Size of binary tree is: "+size);
        System.out.println("Binary tree -> ");
        obj.print();
        obj.searchBST(80);
    }

}

class Node<K extends Comparable<K>>{

    K key;
    Node<K> left;
    Node<K> right;

    public Node(K key){
        this.key = key;
        this.left = null;
        this.right = null;
    }

}

class TreeOperations<K extends Comparable<K>>{

    Node<K> root;

    public void addKey(K key){
        this.root = addRecursivley(root,key);
    }

    public Node<K> addRecursivley(Node<K> current, K key){

        if( current == null ){
            return new Node<>(key);
        }
        int comparedResult = current.key.compareTo(key);
        if( comparedResult == 0 ){
            return current;
        }
        else if( comparedResult < 0 ){
            current.left = addRecursivley(current.left,key);
        }
        else {
            current.right = addRecursivley(current.right, key);
        }
        return current;
    }

    public int getSize(){
        return this.getSizeRecursively(root);
    }
    private int getSizeRecursively(Node<K> current) {
        return current == null ? 0 : 1 + this.getSizeRecursively(current.left) + this.getSizeRecursively(current.right);
    }
    public void print() {
        printRec(root);
    }
    void printRec(Node root) {
        if(root != null) {
            printRec(root.left);
            System.out.println(root.key);
            printRec(root.right);
        }
    }
    @Override
    public String toString() {
        return "MyBinaryTree [root=" + root + ", getSize()=" + getSize() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

    public void searchBST(K value) {
        int counter = 0;
        Node<K> temp=root;
        if(temp != null) {
            while(temp.key.compareTo(value) < 0) {
                System.out.println(temp.key);
                temp = temp.right;
            }
            if(root.key == value)
                counter++;
            while(temp.key.compareTo(value) > 0) {
                temp = temp.left;
            }
            if(temp.key == value) {
                counter++;
            }
            if(counter > 0) {
                System.out.println(true);
                System.out.println("Element is present");
            }
            else {
                System.out.println(false);
                System.out.println("Element is not present");
            }
        }

    }

}