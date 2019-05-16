import java.util.ArrayDeque;
import java.util.Queue;

public class AVLTree {
    private BinaryTreeNode root;

    public AVLTree() {
    }

    public AVLTree(BinaryTreeNode root) {
        this.root = root;
    }

    public void insert(int data){
        if (root == null) {
            root = new BinaryTreeNode();
            root.setData(data);
            root.setHeight(1);
        } else {
            this.root = searchAndInsert(null, root, data);
        }
    }
    private BinaryTreeNode getRRchange(BinaryTreeNode node){
        BinaryTreeNode changeNode = node.getRightChild();
        node.setRightChild(changeNode.getLeftChild());
        changeNode.setLeftChild(node);
        node.setHeight(Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1);
        changeNode.setHeight(Math.max(height(changeNode.getLeftChild()), height(changeNode.getRightChild())) + 1);
        return changeNode;
    }
    private BinaryTreeNode getLLchange(BinaryTreeNode node){
        BinaryTreeNode changeNode = node.getLeftChild();
        node.setLeftChild(changeNode.getRightChild());
        changeNode.setRightChild(node);
        node.setHeight(Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1);
        changeNode.setHeight(Math.max(height(changeNode.getLeftChild()), height(changeNode.getRightChild())) + 1);
        return changeNode;
    }
    private BinaryTreeNode getRLchange(BinaryTreeNode node){
        node.setLeftChild(getRRchange(node.getLeftChild()));
        return getLLchange(node);
    }
    private BinaryTreeNode getLRchange(BinaryTreeNode node){
        node.setRightChild(getLLchange(node.getRightChild()));
        return getRRchange(node);
    }

    public void remove(int data){
        this.root = remove(this.root, data);
    }
    private BinaryTreeNode remove(BinaryTreeNode node, int data){
        if (node == null){
            return null;
        }
        if (node.getData() > data){
            node.setLeftChild(remove(node.getLeftChild(), data));
            if (height(node.getRightChild()) - height(node.getLeftChild()) == 2){
                BinaryTreeNode temp = node.getRightChild();
                if (height(temp.getRightChild()) >= height(temp.getLeftChild())){
                    node = getRRchange(node);
                } else {
                    node = getLRchange(node);
                }
            }
        } else if (node.getData() == data){
            //两个都不为空
            if (node.getLeftChild() != null && node.getRightChild() != null){
                if (height(node.getLeftChild()) > height(node.getRightChild())){
                    // 如果tree的左子树比右子树高；
                    // 则(01)找出tree的左子树中的最大节点
                    //   (02)将该最大节点的值赋值给tree。
                    //   (03)删除该最大节点。
                    // 这类似于用"tree的左子树中最大节点"做"tree"的替身；
                    // 采用这种方式的好处是：删除"tree的左子树中最大节点"之后，AVL树仍然是平衡的。
                    BinaryTreeNode maxNode = getMaxNode(node.getLeftChild());
                    node.setData(maxNode.getData());
                    node.setLeftChild(remove(node.getLeftChild(), maxNode.getData()));
                } else {
                    BinaryTreeNode minNode = getMinNode(node.getRightChild());
                    node.setData(minNode.getData());
                    node.setRightChild(remove(node.getRightChild(), minNode.getData()));
                }
            } else {
                node = node.getLeftChild() != null ? node.getLeftChild() : node.getRightChild();
            }

        } else {
            node.setRightChild(remove(node.getRightChild(), data));
            if (height(node.getLeftChild()) - height(node.getRightChild()) == 2){
                BinaryTreeNode temp = node.getLeftChild();
                if (height(temp.getLeftChild()) >= height(temp.getRightChild())){
                    node = getLLchange(node);
                } else {
                    node = getRLchange(node);
                }
            }
        }
        return node;
    }

    private BinaryTreeNode getMaxNode(BinaryTreeNode node){
        if (node == null){
            return null;
        }
        while(node.getRightChild() != null){
            node = node.getRightChild();
        }
        return node;
    }

    private BinaryTreeNode getMinNode(BinaryTreeNode node){
        if (node == null){
            return null;
        }
        while(node.getLeftChild() != null){
            node = node.getLeftChild();
        }
        return node;
    }

    private BinaryTreeNode searchAndInsert(BinaryTreeNode parent, BinaryTreeNode node, int data) {
        if(node == null) {
            node = new BinaryTreeNode();
            node.setData(data);
            node.setHeight(1);
            return node;
        }else if(node.getData() == data) {
            return node;
        }else if(node.getData() < data) {
            // 插到右子树
            node.setRightChild(searchAndInsert(node, node.getRightChild(), data));
            if (height(node.getRightChild()) - height(node.getLeftChild()) == 2){

                System.out.println("进行R翻转");
                if (data > node.getRightChild().getData()){
                    // RR
                    node = getRRchange(node);
                } else {
                    // LR
                    node = getLRchange(node);
                }
            }

        }else {
            //左子树
            node.setLeftChild(searchAndInsert(node, node.getLeftChild(), data));
            if (height(node.getLeftChild()) - height(node.getRightChild()) == 2){
                System.out.println("进行L翻转");
                if (data > node.getLeftChild().getData()){
                    // RL
                    node = getRLchange(node);
                } else {
                    // LL
                    node = getLLchange(node);
                }
            }
        }
        node.setHeight(Math.max(height(node.getRightChild()), height(node.getLeftChild())) + 1);
        return node;
    }

    public int height(BinaryTreeNode node){
        if (node == null){
            return 0;
        } else {
            return  node.getHeight();
        }
    }
    public int height(){
        return height(root);
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
    public void printAVLtree(){
        if (this.root == null){
            System.out.println("所有已经节点删除了");
            return;
        }
        Queue<BinaryTreeNode> binaryTreeNodes = new ArrayDeque<>();
        binaryTreeNodes.add(this.root);
        int lastHeight = 0;
        while (binaryTreeNodes.size() > 0){
            BinaryTreeNode node = binaryTreeNodes.peek();
            binaryTreeNodes.remove();
            if (node.getHeight() != lastHeight){
                System.out.println("");
            }
            System.out.print("( data: " + node.getData()+", height: " + node.getHeight() + ") - ");
            lastHeight = node.getHeight();
            if (node.getLeftChild() != null){
                binaryTreeNodes.add(node.getLeftChild());
            }
            if (node.getRightChild() != null){
                binaryTreeNodes.add(node.getRightChild());
            }
        }

    }
}
