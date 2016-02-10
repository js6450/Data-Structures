import java.util.Scanner;

public class InputTree {
	
	public static void file(String s){
		String temp = "";
		Scanner in = new Scanner(s);
		BinarySearchTree bst = new BinarySearchTree();
		StackList stack = new StackList();
		while(in.hasNext()){
			temp = in.next();
			if(temp == "("){
				;
			}
			if(temp == ")"){
				TreeNode left_child = new TreeNode();
				TreeNode right_child = new TreeNode();
				TreeNode parent = new TreeNode();
				left_child = (TreeNode) stack.topAndPop();
				right_child = (TreeNode) stack.topAndPop();
				parent = (TreeNode) stack.topAndPop();
				parent.left = left_child;
				parent.right = right_child;
				stack.push(parent);
				
			}
			else{
				TreeNode newNode = new TreeNode();
				newNode.setElement(temp);
				newNode.distance = in.nextInt();
				stack.push(newNode);
				
			}
		}
		while(!stack.isEmpty()){
			bst.insert((Comparable) stack.topAndPop());
		}

	}

	public static void main(String[] args) {
		file("a 0 ( b 3 c 7 ( d 1 e 3 ) )");

	}

}
