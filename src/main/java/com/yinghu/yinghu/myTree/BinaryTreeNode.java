package com.yinghu.yinghu.myTree;

/**
 * @author
 * @describetion ${}
 * @date 2020-8-24
 */
public class BinaryTreeNode {

    int data;
    BinaryTreeNode leftNode = null, rightNode = null;

    public void setBinaryTreeNode(int data) {
        this.data = data;
    }
    public void setLeftNode(BinaryTreeNode leftNode) {
        this.leftNode = leftNode;
    }
    public void setRightNode(BinaryTreeNode rightNode) {
        this.rightNode = rightNode;
    }

}
