package MNCQuestion2;

//class of node
	class Node {
		int val;
		Node left, right;

		// constructor
		Node (int item)
		{
			val = item;
			left = right = null;
		}
	}

public class Data_Transactions {

	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;

	//  to flatten the binary search tree into a skewed tree increasing order

	static void flattenBTToSkewed(Node root)
	{
		//Base Case
		if(root == null)
		{
			return;
		}
		else
		{
			flattenBTToSkewed(root.left);
		}


		Node rightNode = root.right;
		Node leftNode = root.left;


        // Condition to check if the root Node
        // of the skewed tree is not defined

		if(headNode == null)
		{
			headNode = root;
			root.left = null;
			prevNode = root;
		}
		else
		{
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		// Similarly recurse for the left / right
        // subtree 

			flattenBTToSkewed(rightNode);

	}

	 // Function to traverse the right
    // skewed tree using recursion
	static void traverseRightSkewed(Node root)
	{
		if(root == null)
		{
			return;
		}
		System.out.print(root.val + " ");
		traverseRightSkewed(root.right);
	}

	//driver code
	public static void main(String[] args) {

		//Given Binary Search Tree
		//        50
		//       /  \
		//      30   60     
		//     /     /
		//    10    55


		Data_Transactions tree = new Data_Transactions();
		//creating bst according to given data
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left = new Node(55);

		//required conversion
		//        10
		//         \
		//          30
		//           \
		//            50
		//             \
		//              55
		//               \
		//                60

		flattenBTToSkewed(node);  //flatten tree // BST to skewed tree (right )
		traverseRightSkewed(headNode); // traverse and display tree
	}
}