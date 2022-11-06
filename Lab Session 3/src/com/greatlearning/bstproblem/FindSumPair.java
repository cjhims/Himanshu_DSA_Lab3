package com.greatlearning.bstproblem;

class FindSumPair {
	// A binary tree node
	static class Node {
		int data;
		// can be called as pointers
		Node left, right;

		// creating a constructor
		Node(int val) {
			this.data = val;
			this.left = this.right = null;
		}
	}

	// Root of BST
	Node root;

	// Constructor
	FindSumPair() {
		root = null;
	}

	void insert(int key) {
		root = insertRec(root, key);
	}

	/* A recursive function to insert a new key in BST */
	Node insertRec(Node root, int data) {

		/* If the tree is empty, return a new node */
		if (root == null) {
			root = new Node(data);
			return root;
		}

		/* Otherwise, recur down the tree */
		if (data < root.data)
			root.left = insertRec(root.left, data);
		else if (data > root.data)
			root.right = insertRec(root.right, data);

		return root;
	}

	boolean isPairPresent(Node root, Node temp, int target) {
		if (temp == null)
			return false;

		return search(root, temp, target - temp.data) || isPairPresent(root, temp.left, target)
				|| isPairPresent(root, temp.right, target);
	}

	boolean search(Node root, Node temp, int k) {

		if (root == null)
			return false;

		Node c = root;
		boolean flag = false;
		while (c != null && flag != true) {
			if (c.data == k && temp != c) {
				flag = true;
				System.out.println("Pair Found: (" + c.data + ", " + temp.data+")");
				return true;
			} else if (k < c.data)
				c = c.left;
			else
				c = c.right;
		}

		return false;
	}

	public static void main(String[] args) {
		FindSumPair tree = new FindSumPair();
		/*
		 *               40 
		 *               / \ 
		 *             20   60 
		 *            / \   / \ 
		 *           10 30 50 70
		 */
		tree.insert(40);
		tree.insert(20);
		tree.insert(60);
		tree.insert(10);
		tree.insert(30);
		tree.insert(50);
		tree.insert(70);

		boolean test = tree.isPairPresent(tree.root, tree.root, 40);
		if (!test)
			System.out.println("No such values are found!");
	}
}
