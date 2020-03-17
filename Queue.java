// This class implements the Queue
public class Queue<T> {

    Node<T> head; int elecnt;
	
    public Queue() {    
    	head=null; elecnt=0;
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
    public boolean isEmpty() {
    	if(elecnt==0) {
    		return true;
    	}else {
    		return false;
    	}
    }


    public Node<T> dequeue() {
    	Node<T> node=head;
    	head=head.next;
    	elecnt--;
    	return node;
    }
}


