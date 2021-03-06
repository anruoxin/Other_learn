package RedBlackTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class RedBlackTree {
    private BinaryTreeNode root;

    public RedBlackTree() {
    }

    public RedBlackTree(BinaryTreeNode root) {
        this.root = root;
    }

    public void remove(int data){
        BinaryTreeNode node = searchNode(data);
        this.root = remove(this.root, node);
    }

    public BinaryTreeNode searchNode(int data){
        BinaryTreeNode node = searchNode(this.root, data);
        if (node == null){
            System.out.println("无删除的节点");
            return null;
        }
        return node;
    }

    public BinaryTreeNode searchNode(BinaryTreeNode node, int data){
        if(node == null) {
            return null;
        }else if(node.getData() == data) {
            return node;
        }else if(data > node.getData()) {
            return searchNode(node.getRightChild(), data);
        }else {
            return searchNode(node.getLeftChild(), data);
        }
    }

    public BinaryTreeNode remove(BinaryTreeNode root, BinaryTreeNode node){
        BinaryTreeNode nodePanent = searchParent(null, root, node.getData());
        if (node.getLeftChild() != null && node.getRightChild() != null){
            BinaryTreeNode leftMaxNode = node.getLeftChild();
            while(leftMaxNode.getRightChild() != null){
                leftMaxNode = leftMaxNode.getRightChild();
            }
            BinaryTreeNode leftMaxChildNode = leftMaxNode.getLeftChild();
            BinaryTreeNode leftMaxPanentNode = searchParent(null, root, leftMaxNode.getData());
            node.setData(leftMaxNode.getData());

            // 改为待删除的节点;
            node = leftMaxNode;
            if (isRed(node)){
                leftMaxPanentNode.setRightChild(leftMaxChildNode);
            } else {
                // 当前节点是黑色的，子节点是红色，直接将子节点改为黑色的
                if (isRed(leftMaxChildNode)){
                    leftMaxChildNode.setColor(ColorEnum.BLACK);
                    leftMaxPanentNode.setRightChild(leftMaxChildNode);
                } else {
                    balanceRemove(node);
                }
            }
        } else if(node.getLeftChild() != null){
            // 删除的节点的左子树不为空
            BinaryTreeNode childNode = null;
            if (isRed(node)){
                // 当前节点是红色，直接删除
                childNode = node.getLeftChild();
            } else {
                // 当前节点是黑色，且孩子节点是红色，直接将孩子节点变为黑色
                if (isRed(node.getLeftChild())){
                    node.getLeftChild().setColor(ColorEnum.BLACK);
                    childNode = node.getLeftChild();
                } else {
                    // 当前节点是黑色，且孩子节点是黑色
                    childNode = balanceRemove(node);
                }
            }
            if (nodePanent.getLeftChild().equals(node)){
                nodePanent.setLeftChild(childNode);
            } else {
                nodePanent.setRightChild(childNode);
            }
        } else if(node.getRightChild() != null){
            // 删除的节点的右子树不为空
            BinaryTreeNode childNode = null;
            if (isRed(node)){
                // 当前节点是红色，直接删除
                childNode = node.getRightChild();
            } else {
                // 当前节点是黑色，且孩子节点是红色，直接将孩子节点变为黑色
                if (isRed(node.getRightChild())){
                    node.getRightChild().setColor(ColorEnum.BLACK);
                    childNode = node.getRightChild();
                } else {
                    // 当前节点是黑色，且孩子节点是黑色
                    childNode = balanceRemove(node);
                }
            }
            if (nodePanent.getLeftChild().equals(node)){
                nodePanent.setLeftChild(childNode);
            } else {
                nodePanent.setRightChild(childNode);
            }
        } else {
            if (nodePanent.getLeftChild().equals(node)){
                nodePanent.setLeftChild(null);
            } else {
                nodePanent.setRightChild(null);
            }
        }

    }

    public BinaryTreeNode balanceRemove(BinaryTreeNode node){


        while ((node == null || !isRed(node)) && node != this.root ){
            BinaryTreeNode parentNode = searchParent(null, this.root, node.getData());
            if (parentNode.getLeftChild().equals(node)){
                BinaryTreeNode brotherNode = parentNode.getRightChild();



            } else {

            }
        }
//        BinaryTreeNode parentNode = searchParent(null, root, node.getData());
//        BinaryTreeNode gParentNode = null;
//        BinaryTreeNode uncleNode = null;
//        if (parentNode != null){
//            gParentNode = searchParent(null, root, parentNode.getData());
//            if (gParentNode.getRightChild().equals(parentNode)){
//                uncleNode = gParentNode.getLeftChild();
//            } else {
//                uncleNode = gParentNode.getRightChild();
//            }
//        }

        return  null;
    }

    public void insert(int data){
        if (root == null){
            root = new BinaryTreeNode();
            root.setColor(ColorEnum.BLACK);
            root.setData(data);
        } else {
            BinaryTreeNode binaryTreeNode = searchAndInsert(root, data);
            adjustTree(binaryTreeNode);
        }
    }

    private void setBlack(BinaryTreeNode node){
        node.setColor(ColorEnum.BLACK);
    }

    private void setRed(BinaryTreeNode node){
        node.setColor(ColorEnum.RED);
    }

    private void adjustTree(BinaryTreeNode node){
        BinaryTreeNode gparent = null;
        BinaryTreeNode parent = null;
        while((parent = searchParent(null, root, node.getData())) != null && isRed(parent)){
            gparent = searchParent(null, root, parent.getData());
            BinaryTreeNode changeParent = searchParent(null,root, gparent.getData());

            //若“父节点”是“祖父节点的左孩子”
            if (parent.equals(gparent.getLeftChild())) {
                // Case 1条件：叔叔节点是红色
                BinaryTreeNode uncle = gparent.getRightChild();
                if ((uncle != null) && isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }
                // Case 2条件：叔叔是黑色，且当前节点是右孩子
                if (node.equals(parent.getRightChild())) {
                    parent = rightChange(parent);
                    node = parent.getLeftChild();
                    gparent.setLeftChild(parent);
                }
                // Case 3条件：叔叔是黑色，且当前节点是左孩子。
                setBlack(parent);
                setRed(gparent);
                node = leftChange(gparent);
                if (changeParent != null){
                    if (changeParent.getLeftChild().equals(node.getRightChild())){
                        changeParent.setLeftChild(node);
                    }else {
                        changeParent.setRightChild(node);
                    }
                } else {
                    this.root = node;
                }
                break;
            } else {    //若“z的父节点”是“z的祖父节点的右孩子”
                // Case 1条件：叔叔节点是红色
                BinaryTreeNode uncle = gparent.getLeftChild();
                if ((uncle != null) && isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }
                // Case 2条件：叔叔是黑色，且当前节点是左孩子
                if (node.equals(parent.getLeftChild())) {
                    parent = leftChange(parent);
                    node = parent.getRightChild();
                    gparent.setRightChild(parent);
                }
                // Case 3条件：叔叔是黑色，且当前节点是右孩子。
                setBlack(parent);
                setRed(gparent);
                node = rightChange(gparent);

                if (changeParent != null){
                    if (changeParent.getLeftChild().equals(node.getLeftChild())){
                        changeParent.setLeftChild(node);
                    }else {
                        changeParent.setRightChild(node);
                    }
                    //System.out.println("*****" + changeParent.getData() +"*************" );
                    //System.out.println("*****" + changeParent.getLeftChild().getData()+"--------" + changeParent.getRightChild().getData()+"*************" );

                } else {
                    this.root = node;
                }
                break;
            }

        }

        // 将根节点设为黑色
        setBlack(this.root);
    }

    private boolean isRed(BinaryTreeNode node){
        return isRed(node.getColor());
    }

    private boolean isRed(Integer color){
        return ColorEnum.RED.getColor().equals(color);
    }

    private BinaryTreeNode searchParent(BinaryTreeNode parent, BinaryTreeNode node, int data) {
        if(node == null) {
            return null;
        }else if(node.getData() == data) {
            return parent;
        }else if(data < node.getData()) {
            return searchParent(node, node.getLeftChild(), data);
        }else {
            return searchParent(node, node.getRightChild(), data);
        }
    }
    private BinaryTreeNode searchAndInsert(BinaryTreeNode node, Integer data){
        BinaryTreeNode parent = null;
        boolean isLeft = true;
        while(node != null){
            if (node.getData() > data){
                // 插入左子树
                isLeft = true;
                parent = node;
                node = node.getLeftChild();

            } else if (node.getData() < data){
                // 插入右子树
                isLeft = false;
                parent = node;
                node = node.getRightChild();
            } else {
                return node;
            }
        }

        node = new BinaryTreeNode();
        node.setData(data);
        node.setColor(ColorEnum.RED);

        if (isLeft && parent != null){
            parent.setLeftChild(node);
        } else if (parent != null){
            parent.setRightChild(node);
        }
        return node;
    }

    private BinaryTreeNode leftChange(BinaryTreeNode node){
        BinaryTreeNode changeNode = node.getLeftChild();
        node.setLeftChild(changeNode.getRightChild());
        changeNode.setRightChild(node);
        return changeNode;
    }
    private BinaryTreeNode rightChange(BinaryTreeNode node){
        BinaryTreeNode changeNode = node.getRightChild();
        node.setRightChild(changeNode.getLeftChild());
        changeNode.setLeftChild(node);
        return changeNode;
    }

    public void printRedBlacktree(){
        if (this.root == null){
            System.out.println("所有已经节点删除了");
            return;
        }
        Queue<BinaryTreeNode> binaryTreeNodes = new ArrayDeque<>();
        this.root.setHeight(0);
        binaryTreeNodes.add(this.root);
        while (binaryTreeNodes.size() > 0){
            BinaryTreeNode node = binaryTreeNodes.peek();
            binaryTreeNodes.remove();
            System.out.print("( data: " + node.getData()+", 颜色: " + getColor(node.getColor()) +", 高度: " + node.getHeight() + ") - ");
            BinaryTreeNode leftChild = node.getLeftChild();
            if (leftChild != null){
                leftChild.setHeight(node.getHeight() + 1);
                binaryTreeNodes.add(leftChild);
            }
            BinaryTreeNode rightChild = node.getRightChild();
            if (rightChild != null){
                rightChild.setHeight(node.getHeight() + 1);
                binaryTreeNodes.add(rightChild);
            }
        }
    }

    private String getColor(Integer color){
        return ColorEnum.RED.getColor().equals(color) ? "红" : "黑";
    }

    public void visit(BinaryTreeNode node){
        System.out.print(node.getData()+", ");
    }
    public void preOrder(){
        preOrder(this.root);
        System.out.println("");
    }
    public void preOrder(BinaryTreeNode node){
        if(node != null){
            visit(node);
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
    }
    public void inOrder(){
        inOrder(this.root);
        System.out.println("");
    }
    public void inOrder(BinaryTreeNode node){
        if(node != null){
            inOrder(node.getLeftChild());
            visit(node);
            inOrder(node.getRightChild());
        }
    }

    public void postOrder(){
        postOrder(this.root);
        System.out.println("");
    }
    public void postOrder(BinaryTreeNode node){
        if(node != null){
            postOrder(node.getLeftChild());
            postOrder(node.getRightChild());
            visit(node);
        }
    }
}
