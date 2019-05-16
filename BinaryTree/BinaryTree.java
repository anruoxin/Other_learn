public class BinaryTree {

    private BinaryTreeNode root;

    public BinaryTree() {
    }

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    public void clear(){
        clear(root);
    }

    public void clear(BinaryTreeNode node){
        if (node != null){
            clear(node.getLeftChild());
            clear(node.getRightChild());
            node = null;
        }
    }

    public boolean isEmpty(){
        return root == null;
    }

    public int height(){
        return height(root);
    }

    public int height(BinaryTreeNode node){
        if (node == null){
            return 0;
        } else {
            int l = height(node.getLeftChild());
            int r = height(node.getRightChild());
            return l < r ? r + 1 : l + 1;
        }
    }

    public int size(){
        return size(root);
    }

    public int size(BinaryTreeNode node){
        if (node == null){
            return 0;
        } else {
            return 1 + size(node.getLeftChild()) + size(node.getRightChild());
        }
    }
    public void insertLeft(BinaryTreeNode parent, BinaryTreeNode left){
        parent.setLeftChild(left);
    }

    public void insertRight(BinaryTreeNode parent, BinaryTreeNode right){
        parent.setRightChild(right);
    }

    public void visit(BinaryTreeNode node){
        System.out.println(node.getData());
    }
    public void preOrder(BinaryTreeNode node){
        if(node != null){
            visit(node);
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
    }

    public void inOrder(BinaryTreeNode node){
        if(node != null){
            inOrder(node.getLeftChild());
            visit(node);
            inOrder(node.getRightChild());
        }
    }

    public void postOrder(BinaryTreeNode node){
        if(node != null){
            postOrder(node.getLeftChild());
            postOrder(node.getRightChild());
            visit(node);
        }
    }
}
