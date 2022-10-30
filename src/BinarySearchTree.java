public class BinarySearchTree {
    public Node root;

    static  class Node{
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public BinarySearchTree(){
        this.root = null;
    }

    public void insert(int newData){
        this.root = insert(root , newData);

    }
    public Node insert(Node root , int newData){
        if(root == null){
            root = new Node(newData);
            return root;
        }
        else if (root.data >= newData){
            root.left = insert(root.left , newData);
        }else{
            root.right = insert(root.right , newData);
        }
        return root;
    }

    public  void delete(Node node){
        delete(this.root , node);

    }

    public Node delete(Node root , Node node){
        if (root == null){
            return null;
        } else if (node.data < root.data){
            root.left = delete(root.left , node);
        }else if (node.data > root.data){
            root.right = delete(root.right , node);
        }else if(root.data == node.data){
            if(root.left != null && root.right !=null){
                int max = findMax(root.left);
                root.data = max ;
                root.left = delete(root.left , new Node(max));
                return root;
            }else if (root.left != null){
                return root.left;
            }else if (root.right !=null){
                return root.right;
            }else {
                return null;
            }

        }
        return root;
    }

    public boolean search(int data){
        return search(this.root ,data);
    }
    public boolean search(Node root , int data){
        if(root == null){
            return false;
        }else if(root.data == data){
            return true;
        }else if(root.data > data) {
            return search(root.left, data);
        }
        return search(root.right , data);
    }
    public int findMax(Node root){
        if(root.right != null){
            return findMax(root.right);
        }else {
            return root.data;
        }
    }


    public void preorder() {
        preorder(root);
    }

    public void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);

    }



    public static void main(String[] args){
        BinarySearchTree bt = new BinarySearchTree();
        bt.insert(2);
        bt.insert(4);
        bt.insert(1);
        bt.insert(3);
        bt.insert(5);
//        bt.preorder();
        bt.delete(new Node(4));
        bt.preorder();
        System.out.println("\n" + bt.search(3));
    }
}
