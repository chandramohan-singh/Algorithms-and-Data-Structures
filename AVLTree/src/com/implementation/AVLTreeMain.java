package com.implementation;

public class AVLTreeMain {

	public static void main(String[] args) {

		AVLTree tree = new AVLTree();
		
		tree.insert(30);
		tree.insert(10);
		tree.insert(5);
		tree.insert(3);
		tree.insert(4);
		tree.insert(50);
		tree.insert(65);
		tree.insert(1);
		
		tree.levelOrderTraversal();
		tree.printTreeGraphically();
		
		tree.deleteNodeOfAVLTree(5);//LL Condition
		tree.printTreeGraphically();
		
		tree.insert(2);
		tree.printTreeGraphically();
		
		tree.deleteNodeOfAVLTree(4);//LR Condition
		tree.printTreeGraphically();
		
		tree.insert(20);
		tree.deleteNodeOfAVLTree(65);//RR Condition
		tree.printTreeGraphically();
		
		tree.insert(40);
		tree.deleteNodeOfAVLTree(20);//RL Condition
		tree.printTreeGraphically();
		
	}
}
