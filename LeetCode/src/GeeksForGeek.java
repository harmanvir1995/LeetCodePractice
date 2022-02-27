import java.util.ArrayList;

public class GeeksForGeek {
	public class Node {
		int data;
		Node left;
		Node right;
		Node() {}
		Node(int data) { this.data = data; }
		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		public String toString() {
			return this.data +"";
		}
	}
	
	/**
	 * Given a Binary Tree, find its Boundary Traversal.
	 */
	ArrayList <Integer> boundary(Node node)
	{
	    
	}
	//Adding leaves to the array list.
	ArrayList<Integer> leaves(ArrayList<Integer> alist, Node root){
		if(root == null) {
			return alist;
		}
	    leaves(alist, root.left);
	    if(root.left == null && root.right == null){
	        alist.add(root.data);
	    }
	    leaves(alist, root.right);
	    return alist;
	}
	//Adding left boundary nodes to the array list.
	// A function to print all left boundary nodes, except a leaf node.
    // Print the nodes in TOP DOWN manner
	ArrayList<Integer> leftBoundary(ArrayList<Integer> alist, Node root){
		if(root == null) {
			return alist;
		}
		if(root.left != null) {
			alist.add(root.data);
			leftBoundary(alist, root.left);
		}
		else if(root.right != null) {
			alist.add(root.data);
			leftBoundary(alist, root.right);
		}
		return alist;
	}
	
	/**
	 * Function to return the diameter of a Binary Tree.
	 * @param root
	 * @return
	 */
	// Function to return the diameter of a Binary Tree.
    int diameter(Node root) {
    	/* base case if tree is empty */
        if(root == null){
            return 0;
        }
        // get the height of left and right sub trees 
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        // get the diameter of left and right subtrees 
        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);
        /* Return max of following three 
        1) Diameter of left subtree 
       2) Diameter of right subtree 
       3) Height of left subtree + height of right subtree + 1 */
        return Math.max(leftHeight + rightHeight + 1, 
                        Math.max(leftDiameter, rightDiameter)); 
    }
    
   
	
	/**
	 * Function to find the height of a binary tree.
	 * @param node
	 * @return
	 */
	 //Function to find the height of a binary tree.
    int height(Node node){
        if(node == null){
            return 0;
        }
        int leftheight = height(node.left) + 1;
        int rightheight = height(node.right) + 1;
        if(leftheight > rightheight){
            return leftheight;
        }
        else{
            return rightheight;
        }
    }
	
	/**
	 * Prints the left view of the tree.
	 */
	 //Function to return list containing elements of left view of binary tree.
	 int maxlevel = 0;
	    //Function to return list containing elements of left view of binary tree.
	    ArrayList<Integer> leftView(Node root)
	    {
	      // Your code here
	      ArrayList<Integer> alist = new ArrayList<>();
	      return leftViewHelper(alist, root, 1);
	    }
	    
	    //Helper
	    ArrayList<Integer> leftViewHelper(ArrayList<Integer> alist, Node node, int level){
	        //Base case
	        if(node == null){
	            return alist;
	        }
	        //
	        if(maxlevel < level){
	            alist.add(node.data);
	            maxlevel = level;
	        }
	        
	        leftViewHelper(alist, node.left, level+1);
	        leftViewHelper(alist, node.right, level+1);
	        return alist;
	    }
	
	

	/**
	 * Function to check whether a Binary Tree is BST or not.
	 * 
	 * @param root
	 * @return
	 */
	boolean isBST(Node root)
	{
		// code here.
		return isBSThelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE );
	}
	//Helper Method for isBST
	boolean isBSThelper( Node node, int min, int max){
		//base case
		if(node == null){
			return true;
		}   
		//When data is out of range
		if(node.data <= min || node.data >= max){
			return false;
		}
		//When data is in range then recursive call
		return isBSThelper(node.left, min, node.data) && isBSThelper(node.right, node.data, max); 
	}
	
	/* Given a binary tree, print its nodes according to the
    "bottom-up" postorder traversal. */
  void printPostorder(Node node)
  {
      if (node == null)
          return;

      // first recur on left subtree
      printPostorder(node.left);

      // then recur on right subtree
      printPostorder(node.right);

      // now deal with the node
      System.out.print(node.data + " ");
  }

  /* Given a binary tree, print its nodes in inorder*/
  void printInorder(Node node)
  {
      if (node == null)
          return;

      /* first recur on left child */
      printInorder(node.left);

      /* then print the data of node */
      System.out.print(node.data + " ");

      /* now recur on right child */
      printInorder(node.right);
  }

  /* Given a binary tree, print its nodes in preorder*/
  void printPreorder(Node node)
  {
      if (node == null)
          return;

      /* first print data of node */
      System.out.print(node.data + " ");

      /* then recur on left subtree */
      printPreorder(node.left);

      /* now recur on right subtree */
      printPreorder(node.right);
  }
}
