/**
 * this project is released under MIT license
 * @author Emanuele Paiano
 * 
 * 
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Generic Node
 * 
 * */
public class Node<T> {
	private T content;
	private Node<T> parent;
	private List<Node<T>> children;
	
	/**
	 * Build a node with given content
	 * @param content 
	 * 
	 * */
	public Node(T content) {
		this.setContent(content);
		this.children = new ArrayList<Node<T>>();
	}
	
	/**
	 * Build empty node
	 * 
	 * */
	public Node() {
		this.children = new ArrayList<Node<T>>();
	}

	/**
	 * return node's content
	 * 
	 * */
	public T getContent() {
		return content;
	}

	/**
	 * set node's content
	 * @param content 
	 * 
	 * */
	public void setContent(T content) {
		this.content = content;
	}

	/**
	 * Return node's parent
	 * 
	 * */
	public Node<T> getParent() {
		return parent;
	}

	/**
	 * Set parent
	 * @param parent new parent
	 * 
	 * */
	public void setParent(Node<T> parent) {
		this.parent = parent;
	}
	
	
	/**
	 * Return node children
	 * 
	 * */
	public List<Node<T>> getChildren(){
		return this.children;
	}
	
	/**
	 * Return node children number
	 * 
	 * */
	public int getChildrenSize(){
		return this.children.size();
	}
	
	/**
	 * return i-th node's child
	 * 
	 * */
	public Node<T> getChild(int i){
		return this.children.get(i);
	}
	
	/**
	 * add child to node
	 * 
	 * */
	public Node<T> addChild(Node<T> node)
	{
	 this.children.add(node);
	 node.setParent(this);
	 return node;
	}
	
	
	/**
	 * return node's last child 
	 * 
	 * */
	public Node<T> getLastChild()
	{
		if (children.size()>0) return (Node<T>) children.get(this.getChildrenSize()-1);
		else return new Node<T>();  
	}
	
	/**
	 * check if node has children
	 * @return true if has children, false otherwise
	 * 
	 * */
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	
	/**
	 * return first node's child
	 * 
	 * */
	public Node<T> getFirstChild()
	{
		if (children.size()>0) return (Node<T>) children.get(0);
		else return new Node<T>();  
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((children == null) ? 0 : children.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (children == null) {
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Node [ " + content + ", children=" + children + "]";
	}
	
	
}
