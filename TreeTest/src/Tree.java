/**
 * this project is released under MIT license
 * @author Emanuele Paiano
 * 
 * 
 */

import java.util.LinkedList;
import java.util.List;


/**
 * Generic Tree
 * 
 */
public class Tree<T> {
	private Node<T> root;
	int nodeNumber = 0;

	/**
	 * build a tree
	 * 
	 * @param rootContent root content
	 *            
	 * 
	 */
	public Tree(T rootContent) {
		this.root = new Node<T>(rootContent);
		this.nodeNumber = 1;
	}

	/**
	 * Build a tree with root given
	 * 
	 * @param root root node
	 * 
	 */
	public Tree(Node<T> root) {
		this.root = root;
		this.nodeNumber = 1;
	}

	/**
	 * return node's children
	 * 
	 * @param node node
	 *            
	 * 
	 */
	public List<Node<T>> getChildren(Node<T> node) {
		return node.getChildren();
	}

	/**
	 * count all nodes into subtrees (excluding root node)
	 * 
	 * @param node node
	 * 
	 */
	private int countChildrenTree(Node<T> parent) {
		int nodeCount = parent.getChildrenSize();

		for (int i = 0; i < parent.getChildrenSize(); i++) {
			Node<T> child = parent.getChild(i);
			this.nodeNumber += child.getChildrenSize();
			nodeCount = nodeCount + countChildrenTree(child);
		}

		return nodeCount;
	}

	/**
	 * count all nodes into subtree, using a given node as root
	 * 
	 * @param node input node
	 *            
	 * 
	 */
	public int countTreeNode(Node<T> parent) {
		return countChildrenTree(parent) + 1;
	}

	/**
	 * get node numbers
	 * 
	 */
	public int getNodesNumber() {
		return this.nodeNumber;
	}

	/**
	 * return all node's children
	 * 
	 * @param node node
	 *            
	 * 
	 */
	public int getChildrenSize(Node<T> node) {
		return node.getChildrenSize();
	}

	/**
	 * return node's parent
	 * 
	 * @param node node
	 *            
	 * 
	 */
	public Node<T> getParent(Node<T> node) {
		return node.getParent();
	}

	/**
	 * return root node
	 * 
	 */
	public Node<T> getRoot() {
		return this.root;
	}

	/**
	 * add child to generic parent
	 * 
	 * @param child
	 *            
	 * @param parent (existing into tree)
	 *            
	 * 
	 */
	public Node<T> addChildToParent(Node<T> child, Node<T> parent) {
		parent.addChild(child);
		child.setParent(parent);
		return child;
	}

	/**
	 * check if a given node is root node or not.
	 * 
	 * @param node
	 *            
	 * 
	 */
	public boolean isRoot(Node<T> node) {
		return node.equals(this.root);
	}

	/**
	 * set new root
	 * 
	 * @param node
	 *            
	 * 
	 */
	public Node<T> setRoot(Node<T> node) {
		this.root = node;
		return node;
	}

	/**
	 * Return (parent(child1, .... , childN)) tree structure
	 * 
	 * @param parent node used as root
	 *            
	 * 
	 * 
	 */
	public String getTreeList(Node<T> parent) {
		String list = "";
		if (parent.getParent() == null)
			list = (String) parent.getContent().toString();
		if (parent.hasChildren()) {
			list += "(";
			for (int i = 0; i < parent.getChildrenSize(); i++) {
				if (i > 0)
					list += ", ";
				list += parent.getChild(i).getContent().toString();
				list += getTreeList(parent.getChild(i));
			}
			list = list + ")";
		}
		return list;

	}

	/**
	 * tree deep visit 
	 */
	public LinkedList<Node<T>> visitDFS() {
		LinkedList<Node<T>> stack = new LinkedList<Node<T>>();
		LinkedList<Node<T>> treeNodeList = new LinkedList<Node<T>>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node<T> u = (Node<T>) stack.pop();
			if (u != null) {
				treeNodeList.add(u);

				// ciclo for "al contrario" perchè uso la pila

				for (int i = u.getChildrenSize() - 1; i >= 0; i--) {
					// Si inseriscono nella pila i nodo "aperti", da visitare.
					stack.push(u.getChild(i));
				}
			}

		}
		return treeNodeList;
	}

}
