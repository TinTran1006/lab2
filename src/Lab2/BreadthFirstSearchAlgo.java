package Lab2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstSearchAlgo implements ISearchAlgo {
	private Queue<Node> frontier = new LinkedList<Node>();

	@Override
	public Node execute(Node root, String goal) {
		if (root.getLabel() == goal) {
			frontier.clear();
			return root;

		} else {
			for (Node node : root.getChildrenNodes()) {
				if (!frontier.contains(node)) {
					node.setParent(root);
					frontier.add(node);
				}

			}
			return execute(frontier.poll(), goal);
		}
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Node x = execute(root, start);
		x.setParent(null);
		return execute(x, goal);
	}

	@Override
	public Node executeTree(Node root, String goal) {
		while (root.getLabel() != goal) {
			for (Node node : root.getChildrenNodes()) {
				node.setParent(root);
				frontier.add(node);
			}
			root = frontier.poll();
		}
		frontier.clear();
		return root;
	}

	@Override
	public Node executeTree(Node root, String start, String goal) {
		Node x=execute(root, start);
		x.setParent(null);
		return execute(x, goal);
	}

}
