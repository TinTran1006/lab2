package Lab2;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo {
	private Stack<Node> frontier = new Stack<Node>();

	@Override
	public Node execute(Node root, String goal) {
		while (root.getLabel() != goal) {
			Stack<Node> stack = new Stack<Node>();
			for (Node node : root.getChildrenNodes()) {

				if (stack.contains(node)) {
					node.setParent(root);
					stack.add(node);
				}
			}
			while (!stack.isEmpty()) {
				frontier.add(stack.pop());
			}
		}
		return root;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Node x = execute(root, start);
		x.setParent(null);
		return execute(x, goal);
	}

	@Override
	public Node executeTree(Node root, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeTree(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

}
