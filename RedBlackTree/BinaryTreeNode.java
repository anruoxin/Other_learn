package RedBlackTree;

import java.util.Objects;

public class BinaryTreeNode {
    private int color;
    private int data;
    private int height;
    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;

    public int getColor() {
        return color;
    }

    public void setColor(ColorEnum color) {
        this.color = color.getColor();
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null) {return false;}
        if (getClass() != obj.getClass()) {return false;}
        BinaryTreeNode node = (BinaryTreeNode)obj;
        return Objects.equals(node.getData() , data);
    }
}
