//BinaryTree.java

package monika;

class Node{
int data;
Node left,right;
public Node(int data) {
	this.data=data;
}
}
public class BinaryTree {
Node root;
	public void insert(int data) {
		root = insertRec(root,data);
	}
		public Node insertRec(Node root, int data) {
			if (root == null)
				root = new Node(data);
			else if (data < root.data)
				root.left = insertRec(root.left,data);
			else if (data > root.data)
				root.right = insertRec(root.right,data);
		
			return root;
				
		}
		public void inorder() {
			System.out.println(" __INORDER TRAVERSAL__ ");
			System.out.println();
			inorderRec(root);
			System.out.println();
		}
		public void inorderRec(Node root) {
			
			if (root != null) {
				inorderRec(root.left);
				System.out.print(root.data+" ");
				inorderRec(root.right);
			}
		}
		public void preorder() {
			System.out.println();
			System.out.println(" __PREORDER TRAVERSAL__ ");
			
			preorderRec(root);
		}
		public void preorderRec(Node root) {
			
			if (root !=null) {
				System.out.print(root.data+" ");
				preorderRec(root.left);
				preorderRec(root.right);
			}
		}
		public void postorder() {
			System.out.println();
			System.out.println(" __POSTORDER TRAVERSAL__ ");
			System.out.println();
			postorderRec(root);
		}
		public void postorderRec(Node root) {
			
			if (root !=null) {
				postorderRec(root.left);
				postorderRec(root.right);
				System.out.print(root.data+" ");
				
			}
		}
	}

// Implementation of tree

package monika;

public class ImplementationOfBinarytree {

	public static void main(String[] args) {
		BinaryTree b = new BinaryTree();
		b.insert(7);
		b.insert(2);
		b.insert(15);
		b.insert(12);
		b.insert(10);
		b.insert(1);
		b.insert(81);
		b.inorder();
		b.preorder();
		b.postorder();

	}

}


