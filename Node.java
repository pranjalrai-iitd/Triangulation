
public class Node<T>{
	public T data;
	public Node next;
	Node(T input){
		data  = input;
	}
	public void setnext(Node next){
		this.next=next;
	}
}
