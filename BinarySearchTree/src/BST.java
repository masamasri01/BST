
public class BST {
	Node root;
	BST(){
		root=null;
	}
	public void insert(int val) {
		
	 this.root= insert(this.root,val);
	}
	private Node insert(Node root, int val) {
		if (root==null) {
			root = new Node(val);
		}
		else if(val< root.val) {
			root.left = insert (root.left,val);
		}
		else root.right = insert (root.right,val);
		
		return root;
	}
	public void delete(int val) {
		root = delete(root, val);
	}
	private Node delete(Node root,int val) {
		if(root == null) return root;//if the val doesnt exist
		if (root.val == val) {
			if (root.left == null && root.right ==null) { //1. leaf node
				root = null;
			}
			//2. delete node with one child
			else if (root.left==null) {
				root = root.right;
			}
			else if (root.right==null) {
				root = root.left;
			}
			//3. with two children
			else {
				root.val = getPredecessor(root.left).val;
				root.left=delete(root.left, root.val);
				
			}
				
		}
		else if(root.val > val) {
			root.left = delete(root.left,val);
		}
		else if(root.val < val) {
			root.right =delete(root.right,val);
		}
		return root;
	}
	private Node getPredecessor(Node node) {
	
		if(node.right == null) {
			
			System.out.println("////"+ node.val);return node;
		}
		 return getPredecessor(node.right);
	}
	public void traverseTree() {
		traverseTree(root);
	}
	private void traverseTree(Node root) {
		
		if (root ==null) {
			return;
		}
		
		System.out.println(root.val);
		traverseTree(root.left);
		traverseTree(root.right);
		
	}
	public boolean search(int val) {
		return search(root,val);
	}
	private boolean search(Node root,int val) {
		if(root==null) {
			System.out.println("The value "+ val+" is not found");
			return false;
		}
		if(val<root.val)  search(root.left,val);
		else if(val> root.val) search(root.left,val);
		else {
			System.out.println("The value "+ val+" is found");
			return true;
		}
		
		 return false;
	}
	static void test() {
		BST bst = new BST();
		bst.insert(5);
		bst.insert(1);
		bst.insert(3);
		bst.insert(7);
		bst.insert(4);
		bst.insert(2);
		System.out.println("-------");
		bst.traverseTree();
		
		bst.delete(1);
		System.out.println("-------");
		bst.traverseTree();
		
		bst.search(5);
		System.out.print( bst.search(1));
		
	}
}
