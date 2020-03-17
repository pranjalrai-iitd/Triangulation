
public class LinkedList<T> {
	Node<T> head; int pcnt=0,cnt=0,elecnt=0;
	public LinkedList() {
		head=null;
	}
	public void add(T e) {
		Node<T> node = new Node(e);
		node.setnext(null);
		if(head==null) {
			head=node;
			elecnt++;
		}else {
			Node<T> tmp=head;
			while(tmp.next!=null) {
				tmp=tmp.next;
			}
			tmp.next=node; elecnt++;
		}
	}
	public Node<T> at(int cnt){
		if(cnt==-1) {
			return null;
		}else {
		Node<T> tmp=head; this.cnt=0;
		while(tmp!=null&&this.cnt!=cnt){
			tmp=tmp.next;
			this.cnt++;
		}
		if(tmp==null) {
			return null;
		}else {
			return tmp;
		}
	}
	}
	public Node<T> findp(T e){
		Node<T> tmp=head; pcnt=0; 
		while(tmp!=null&&!((Point)tmp.data).compare((Point)e)){
			tmp=tmp.next;
			pcnt++;
		}
		if(tmp==null) {
			pcnt=-1;
			return null;
		}else {
			return tmp;
		}
	}
	public Node<T> finde(T e){
		Node<T> tmp=head; 
		while(tmp!=null&&!((Edge)tmp.data).compare((Edge)e)){
			tmp=tmp.next;
		}
		if(tmp==null) {
			return null;
		}else {
			return tmp;
		}
	}
	public int size() {
		return elecnt;
	}
	public Node<T> dequeue() {
    	Node<T> node=head;
    	head=head.next;
    	elecnt--;
    	return node;
    }
	public void remove(int index) {
		if(index==0) {
			this.dequeue();
		}else {
		Node<T> node=this.at(index-1);
		Node<T> node1=this.at(index);
		node.next=node1.next; elecnt--;
	}
	}
}
