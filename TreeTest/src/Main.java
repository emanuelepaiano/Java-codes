/**
 * this project is released under MIT license
 * @author Emanuele Paiano
 * 
 * 
 */


public class Main {

	public static void main(String[] args) {
		Node<String> a = new Node<String>("A");
		Node<String> b = new Node<String>("B");
		Node<String> c = new Node<String>("C");
		Node<String> d = new Node<String>("D");
		Node<String> e = new Node<String>("E");
		Node<String> f = new Node<String>("F");
		Node<String> g = new Node<String>("G");
		Node<String> h = new Node<String>("H");
		Node<String> i = new Node<String>("I");
		Node<String> l = new Node<String>("L");
		
		Tree<String> tree = new Tree<String>(a);
		tree.addChildToParent(b, a);
		tree.addChildToParent(e, a);
		tree.addChildToParent(h, a);
		tree.addChildToParent(c, b);
		tree.addChildToParent(d, b);
		tree.addChildToParent(f, e);
		tree.addChildToParent(g, e);
		tree.addChildToParent(i, h);
		tree.addChildToParent(l, h);
		
		System.out.println("Numero di nodi: "+tree.countTreeNode(a));
		
		System.out.println(tree.getTreeList(a));
				
		tree.visitDFS().stream().map(u -> u.getContent()).forEach(System.out::println);


	}

}
