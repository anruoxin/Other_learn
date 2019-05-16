public class BinarySearchingTree extends  BinaryTree{
    private BinaryTreeNode root;

    public BinarySearchingTree(BinaryTreeNode root) {
        this.root = root;
    }

    public BinaryTreeNode search(int data) {
        return search(root, data);
    }
    //二叉查找树的插入操作很简单，找到和待插入结点同样值的结点则不插入，
    //否则在树的末尾新建一个结点，不需要变动其他结点
    public void insert(int data) {
        if(root == null) {
            root = new BinaryTreeNode();
            root.setData(data);
        }else {
            searchAndInsert(null, root, data);
        }
    }
    //如果待删除的结点左右子树都不为空，
    //则选择右子树的最左结点或者左子树的最右结点来代替
    public void delete(int data) {
        if(root.getData() == data) {
            root = null;
            return;
        }
        //知道要删除那个结点的父结点很关键
        //但无法确定要删除的结点是其父结点的左还是右结点
        //需要特别判断一下
        BinaryTreeNode parent = searchParent(data);
        if(parent == null) {
            return;
        }
        BinaryTreeNode node = search(parent, data);
        if(node.getLeftChild() == null && node.getRightChild() == null) {
            //叶子结点，直接删除
            if(parent.getLeftChild() != null && parent.getLeftChild().getData() == data) {
                parent.setLeftChild(null);
            }else {
                parent.setRightChild(null);
            }
        }else if(node.getLeftChild() != null && node.getRightChild() == null) {
            //左子树不为空
            if(parent.getLeftChild()!= null && parent.getLeftChild().getData() ==data) {
                parent.setLeftChild(node.getLeftChild());
            }else {
                parent.setRightChild(node.getRightChild());
            }
        }else if(node.getLeftChild() == null && node.getClass() != null) {
            //右子树不为空
            if(parent.getLeftChild() != null && parent.getLeftChild().getData() == data) {
                parent.setLeftChild(node.getRightChild());
            }else {
                parent.setRightChild(node.getRightChild());
            }
        }else {
            //左右子树都不为空
            //查找右子树最左子节点
            BinaryTreeNode deleteNode = node;
            BinaryTreeNode temp = node.getRightChild();
            //1. 右子树没有左孩子，直接上移
            if(temp.getLeftChild() == null) {
                temp.setLeftChild(deleteNode.getLeftChild());
            }else {
                while(temp.getLeftChild() != null) {
                    node = temp;
                    temp = temp.getLeftChild();
                }
                //2. 继承节点原右子树上移
                node.setLeftChild(temp.getRightChild());
                //3. 继承节点就位
                temp.setLeftChild(deleteNode.getLeftChild());
                temp.setRightChild(deleteNode.getRightChild());
            }
            //4. 更新父节点为删除结点的原父节点
            if(parent.getLeftChild() != null && parent.getLeftChild().getData() == data) {
                parent.setLeftChild(temp);
            }else {
                parent.setRightChild(temp);
            }
        }
    }

    public BinaryTreeNode searchParent(int data) {
        return searchParent(null, root, data);
    }
    public BinaryTreeNode getRoot() {
        return root;
    }
    private BinaryTreeNode searchAndInsert(BinaryTreeNode parent, BinaryTreeNode node, int data) {
        if(node == null) {
            node = new BinaryTreeNode();
            node.setData(data);
            if(data > parent.getData()) {
                parent.setRightChild(node);
            }else {
                parent.setLeftChild(node);
            }
            return node;
        }else if(node.getData() == data) {
            return node;
        }else if(data > node.getData()) {
            return searchAndInsert(node, node.getRightChild(), data);
        }else {
            return searchAndInsert(node, node.getLeftChild(), data);
        }
    }
    private BinaryTreeNode search(BinaryTreeNode node, int data) {
        if(node == null) {
            return null;
        }else if(node.getData() == data) {
            return node;
        }else if(data > node.getData()) {
            return search(node.getRightChild(), data);
        }else {
            return search(node.getLeftChild(), data);
        }
    }
    private BinaryTreeNode searchParent(BinaryTreeNode parent, BinaryTreeNode node, int data) {
        if(node == null) {
            return null;
        }else if(node.getData() == data) {
            return parent;
        }else if(data > node.getData()) {
            return searchParent(node, node.getRightChild(), data);
        }else {
            return searchParent(node, node.getLeftChild(), data);
        }
    }
}
