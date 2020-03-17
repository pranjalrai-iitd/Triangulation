

public class Shape implements ShapeInterface{
	LinkedList<Triangle> tr; Graph<Edge> eg; LinkedList<Point> po; LinkedList<Edge> ed; int pcnt1,pcnt2,pcnt3; 
	Triangle[] NOT; int NOTcnt;
	public Shape() {
		eg=new Graph<>();
		tr=new LinkedList<>();
		po=new LinkedList<>();
		ed=new LinkedList<>();
		NOT=null;
	}
	public void Edgecnt() {
		for(int i=0; i<ed.size(); i++) {
			Edge e=ed.at(i).data;
			for(int j=i+1; j<ed.size(); j++) {
				if(ed.at(j).data.compare(e)) {
					ed.remove(j);
					e.edgecnt++; j--;
				}
			}	
		}
	}
//#1
	 public boolean ADD_TRIANGLE(float [] triangle_coord){
		 Point o1=new Point(triangle_coord[0], triangle_coord[1], triangle_coord[2]);
		 Point o2=new Point(triangle_coord[3],triangle_coord[4], triangle_coord[5]);
		 Point o3=new Point(triangle_coord[6], triangle_coord[7], triangle_coord[8]);
		 Edge edge3=new Edge(o1,o2);
		 Edge edge1=new Edge(o2,o3);
		 Edge edge2=new Edge(o3,o1);
		
		 if(o1.compare(o2)||o2.compare(o3)||o3.compare(o1)) {
			 return false;
		 }else if(edge1.length()+edge2.length()<=edge3.length()||edge1.length()+edge3.length()<=edge2.length()||edge2.length()+edge3.length()<=edge1.length()){
			 return false;
		 }else {
			 Node<Point> n1=po.findp(o1); this.pcnt1=po.pcnt;
			 Node<Point> n2=po.findp(o2); this.pcnt2=po.pcnt;
			 Node<Point> n3=po.findp(o3); this.pcnt3=po.pcnt;
			 Node<LinkedList<Edge>> node=eg.graph.at(this.pcnt1);
			 Node<LinkedList<Edge>> node2=eg.graph.at(this.pcnt2);
			 Node<LinkedList<Edge>> node3=eg.graph.at(this.pcnt3);
			 if(n1==null&&n2==null&&n3==null) {
				po.add(o1); 
				LinkedList<Edge> l=new LinkedList<>();
				ed.add(edge3); ed.add(edge2); ed.add(edge1);
				l.add(edge1);
				eg.graph.add(l);
				Triangle t=new Triangle(o1,o2,o3); tr.add(t);
				return true;
			 }else if(n1!=null&&n2==null&&n3==null){
				 Node<Edge> node1=node.data.finde(edge1);
			if(node1==null) {
				ed.add(edge3); ed.add(edge2); ed.add(edge1);
				node.data.add(edge1);
				Triangle t=new Triangle(o1,o2,o3); tr.add(t);
				return true;
			}else {
			return false;
		 }
		}else if(n1==null&&n2!=null&&n3==null) {
				Node<Edge> node1=node2.data.finde(edge2);
				if(node1==null) {
					ed.add(edge3); ed.add(edge2); ed.add(edge1);
					node2.data.add(edge2);
					Triangle t=new Triangle(o1,o2,o3); tr.add(t);
					return true;
				}else {
				return false;
		 }
		 }else if(n1==null&&n2==null&&n3!=null) {
				Node<Edge> node1=node3.data.finde(edge3);
				if(node1==null) {
					ed.add(edge3); ed.add(edge2); ed.add(edge1);
					node3.data.add(edge3);
					Triangle t=new Triangle(o1,o2,o3); tr.add(t);
					return true;
				}else {
				return false;
		 }	 
		 }else if(n1!=null&&n2!=null&&n3==null) {
			 	Node<Edge> tmp1=node.data.finde(edge1);
				Node<Edge> tmp2=node2.data.finde(edge2);
				if(tmp1==null&&tmp2==null) {
					ed.add(edge3); ed.add(edge2); ed.add(edge1);
					node.data.add(edge1);
					Triangle t=new Triangle(o1,o2,o3); tr.add(t);
					return true;
				}else {
				return false;
			 } 
		 }else if(n1==null&&n2!=null&&n3!=null) {
			 	Node<Edge> tmp1=node2.data.finde(edge2);
				Node<Edge> tmp2=node3.data.finde(edge3);
				if(tmp1==null&&tmp2==null) {
					ed.add(edge3); ed.add(edge2); ed.add(edge1);
					node2.data.add(edge2);
					Triangle t=new Triangle(o1,o2,o3); tr.add(t);
					return true;
				}else {
				return false;
			 }	 
		 }else if(n1!=null&&n2==null&&n3!=null) {
				Node<Edge> tmp1=node.data.finde(edge1);
				Node<Edge> tmp2=node3.data.finde(edge3);
				if(tmp1==null&&tmp2==null) {
					ed.add(edge3); ed.add(edge2); ed.add(edge1);
					node.data.add(edge1);
					Triangle t=new Triangle(o1,o2,o3); tr.add(t);
					return true;
				}else {
				return false;
				}
		 }else{
			/* for(int i=0; i<ed.size(); i++) {
					Edge e=ed.at(i).data;
					if(e.compare(edge1)) {
						e.edgecnt++; edge1.edgecnt++;
					}else if(e.compare(edge2)) {
						e.edgecnt++; edge2.edgecnt++;
					}else if(e.compare(edge3)) {
						e.edgecnt++; edge3.edgecnt++;
					}
				}
				if(edge1.edgecnt==1) {
					ed.add(edge1);
				}
				if(edge2.edgecnt==1) {
					ed.add(edge2);
				}
				if(edge3.edgecnt==1) {
					ed.add(edge3);
				}*/
			 Node<Edge> tmp1=node.data.finde(edge1);
			 Node<Edge> tmp=node2.data.finde(edge2);
			 Node<Edge> tmp2=node3.data.finde(edge3);
				if(tmp1==null&&tmp2==null&&tmp==null) {
					ed.add(edge3); ed.add(edge2); ed.add(edge1);
					node.data.add(edge1);
					Triangle t=new Triangle(o1,o2,o3); tr.add(t);
					return true;
				}else {
				return false;
				}
		 } 
		 }	 
	 }
	 //#2
	 public int TYPE_MESH(){
		 Edge edge=null; int temp=0;
		 for(int i=0; i<ed.size(); i++) {
			  edge=ed.at(i).data;
			 if(edge.edgecnt==2) {
				 ;
			 }else if(edge.edgecnt==1){
				 temp=1;
			 }else if(edge.edgecnt>=3) {
				 break;
			 } 
		 }
		 if(edge!=null&&edge.edgecnt>=3) {
			 return 3;
		 }else if(edge!=null&&temp==1) {
			 return 2;
		 }else {
			 return 1;
		 }
	 }
	 //#3
	 public EdgeInterface [] BOUNDARY_EDGES(){
		 Edgecnt();
		 EdgeInterface[] arr=new Edge[40000]; int k=0;
		 for(int i=0; i<ed.size(); i++) {
			 Edge edge=ed.at(i).data;
			 if(edge.edgecnt==1) {
				 arr[k++]=edge;
			 }
		 }
		 this.bubbleSort(arr, k);
		System.out.println(k); //phaltu
		if(k!=0) {
		 return arr;
		}else {
			return null;
		}
	 }
		 void bubbleSort(EdgeInterface arr[], int n)  
	    {  
	        int i, j;  
	        for (i = 0; i < n-1; i++)      
	        for (j = 0; j < n-i-1; j++)  
	            if (((Edge)arr[j]).length()> ((Edge)arr[j+1]).length()) {  
	                EdgeInterface tmp=arr[j];
	                arr[j]=arr[j+1];
	                arr[j+1]=tmp;
	            } 
	    }
	 //#4
	 public TriangleInterface [] NEIGHBORS_OF_TRIANGLE(float [] triangle_coord){
		 Point o1=new Point(triangle_coord[0], triangle_coord[1], triangle_coord[2]);
		 Point o2=new Point(triangle_coord[3],triangle_coord[4], triangle_coord[5]);
		 Point o3=new Point(triangle_coord[6], triangle_coord[7], triangle_coord[8]);
		 Triangle tri=new Triangle(o1,o2,o3);
		 Edge edge3=new Edge(o1,o2); int edge3cnt=0,edge1cnt=0,edge2cnt=0;
		 Edge edge1=new Edge(o2,o3);
		 Edge edge2=new Edge(o3,o1);
		 TriangleInterface[] arr=new TriangleInterface[tr.size()]; int k=0; this.NOT=new Triangle[tr.size()];  this.NOTcnt=0;
		 Triangle temp=null;
		 for(int i=0; i<tr.size(); i++) {
			 Triangle t=tr.at(i).data;
			 if(!t.compare(tri)) {
			 if(t.e1.compare(edge3)||t.e1.compare(edge1)||t.e1.compare(edge2)) {
				 arr[k++]=t;
				 NOT[NOTcnt++]=t;
				 System.out.println(""+t.o1.getX()+t.o1.getY()+t.o1.getZ()+t.o2.getX()+t.o2.getY()+t.o2.getZ()+t.o3.getX()+t.o3.getY()+t.o3.getZ());
			 }else if(t.e2.compare(edge3)||t.e2.compare(edge1)||t.e2.compare(edge2)) {
				 arr[k++]=t;
				 NOT[NOTcnt++]=t;
				 System.out.println(""+t.o1.getX()+t.o1.getY()+t.o1.getZ()+t.o2.getX()+t.o2.getY()+t.o2.getZ()+t.o3.getX()+t.o3.getY()+t.o3.getZ());
			 }else if(t.e3.compare(edge3)||t.e3.compare(edge1)||t.e3.compare(edge2)) {
				 arr[k++]=t;
				 NOT[NOTcnt++]=t;
				 System.out.println(""+t.o1.getX()+t.o1.getY()+t.o1.getZ()+t.o2.getX()+t.o2.getY()+t.o2.getZ()+t.o3.getX()+t.o3.getY()+t.o3.getZ());
			 }
		 }else {
			 temp=t;
		 }
		 }
		 if(k==0||temp==null) {
		 return null;
		 }else {
			 return arr;
		 }
		 }
	 public EdgeInterface [] EDGE_NEIGHBOR_TRIANGLE(float [] triangle_coord){
		 Edgecnt();
		 Point o1=new Point(triangle_coord[0], triangle_coord[1], triangle_coord[2]);
		 Point o2=new Point(triangle_coord[3],triangle_coord[4], triangle_coord[5]);
		 Point o3=new Point(triangle_coord[6], triangle_coord[7], triangle_coord[8]);
		 Triangle tri=new Triangle(o1,o2,o3);
		 EdgeInterface[] arr=new EdgeInterface[3]; 
		 for(int i=0; i<tr.size(); i++) {
			 Triangle t=tr.at(i).data;
			 if(t.compare(tri)) {
				 arr[0]=t.e1;
				 arr[1]=t.e2;
				 arr[2]=t.e3;
				 return arr;
			 }
		 }
		 return null;
	 }
	 public PointInterface [] VERTEX_NEIGHBOR_TRIANGLE(float [] triangle_coord){
		 Edgecnt();
		 Point o1=new Point(triangle_coord[0], triangle_coord[1], triangle_coord[2]);
		 Point o2=new Point(triangle_coord[3],triangle_coord[4], triangle_coord[5]);
		 Point o3=new Point(triangle_coord[6], triangle_coord[7], triangle_coord[8]);
		 Triangle tri=new Triangle(o1,o2,o3);
		 PointInterface[] arr=new PointInterface[3]; 
		 for(int i=0; i<tr.size(); i++) {
			 Triangle t=tr.at(i).data;
			 if(t.compare(tri)) {
				 arr[0]=t.o1;
				 arr[1]=t.o2;
				 arr[2]=t.o3;
				 return arr;
			 }
		 }
		 return null;
	 }
	 public TriangleInterface [] EXTENDED_NEIGHBOR_TRIANGLE(float [] triangle_coord){
		 Edgecnt();
		 Point o1=new Point(triangle_coord[0], triangle_coord[1], triangle_coord[2]);
		 Point o2=new Point(triangle_coord[3],triangle_coord[4], triangle_coord[5]);
		 Point o3=new Point(triangle_coord[6], triangle_coord[7], triangle_coord[8]);
		 Triangle tri=new Triangle(o1,o2,o3); Triangle temp=null;
		 TriangleInterface[] arr=new TriangleInterface[tr.size()]; int k=0;
		 for(int i=0; i<tr.size(); i++) {
			 Triangle t=tr.at(i).data;
			 if(!t.compare(tri)) {
				if(t.vtn==1) {
					arr[k++]=t;
				}else if(t.o2.compare(o1)||t.o2.compare(o2)||t.o2.compare(o3)){
					arr[k++]=t;
				}else if(t.o3.compare(o1)||t.o3.compare(o2)||t.o3.compare(o3)) {
					arr[k++]=t;
				}
			 }else {
				 temp=t;
			 }
			}
		 if(k==0||temp==null) {
		 return null;
		 }else {
			 return arr;
		 }
		 }
	 public TriangleInterface [] INCIDENT_TRIANGLES(float [] point_coordinates){
		 Edgecnt();
		 Point o1=new Point(point_coordinates[0], point_coordinates[1], point_coordinates[2]);
		 TriangleInterface[] arr=new TriangleInterface[tr.size()]; int k=0;
		 for(int i=0; i<tr.size(); i++) {
			 Triangle t=tr.at(i).data;
			 if(t.o1.compare(o1)||t.o2.compare(o1)||t.o3.compare(o1)) {
				 arr[k++]=t;
			 }
		 }
		 if(k==0) {
		 return null;
		 }else {
			 return arr;
		 }
	 }
	 public PointInterface [] NEIGHBORS_OF_POINT(float [] point_coordinates){
		 Edgecnt();
		 Point o1=new Point(point_coordinates[0], point_coordinates[1], point_coordinates[2]);
		 PointInterface[] arr=new PointInterface[ed.size()]; int k=0;
		 for(int i=0; i<ed.size(); i++) {
			 Edge edge=ed.at(i).data;
			 if(edge.o1.compare(o1)) {
				 arr[k++]=edge.o2;
			 }else if(edge.o2.compare(o1)) {
				 arr[k++]=edge.o1;
			 }
		 }
		 if(k==0) {
		 return null;
		 }else {
			 return arr;
		 }
	 }
	 public EdgeInterface [] EDGE_NEIGHBORS_OF_POINT(float [] point_coordinates){
		 Edgecnt();
		 Point o1=new Point(point_coordinates[0], point_coordinates[1], point_coordinates[2]);
		 EdgeInterface[] arr=new EdgeInterface[ed.size()]; int k=0;
		 for(int i=0; i<ed.size(); i++) {
			 Edge edge=ed.at(i).data;
			 if(edge.o1.compare(o1)||edge.o2.compare(o1)) {
				 arr[k++]=edge;
			 }
		}
		 if(k==0) {
		 return null;
		 }else {
			 return arr;
		 }
	 }
	 public TriangleInterface [] FACE_NEIGHBORS_OF_POINT(float [] point_coordinates){ 
		 TriangleInterface[] arr=this.INCIDENT_TRIANGLES(point_coordinates);
		 return arr;		
	 }
	 public TriangleInterface [] TRIANGLE_NEIGHBOR_OF_EDGE(float [] edge_coordinates){ 
		 Point o1=new Point(edge_coordinates[0], edge_coordinates[1], edge_coordinates[2]);
		 Point o2=new Point(edge_coordinates[3],edge_coordinates[4], edge_coordinates[5]);
		 Edge edge=new Edge(o1,o2);
		 TriangleInterface[] arr=new TriangleInterface [tr.size()]; int k=0;
		 for(int i=0; i<tr.size(); i++) {
			 Triangle t=tr.at(i).data;
			 if(t.e1.compare(edge)||t.e2.compare(edge)||t.e3.compare(edge)) {
				 arr[k++]=t;
			 }
		 }
		 if(k==0) {
		 return null;
		 }else {
			 return arr;
		 }
	 }
	 public boolean IS_CONNECTED(float [] triangle_coord_1, float [] triangle_coord_2){
		 Point o1=new Point(triangle_coord_1[0], triangle_coord_1[1], triangle_coord_1[2]);
		 Point o2=new Point(triangle_coord_1[3],triangle_coord_1[4], triangle_coord_1[5]);
		 Point o3=new Point(triangle_coord_1[6], triangle_coord_1[7], triangle_coord_1[8]);
		 Point o4=new Point(triangle_coord_2[0], triangle_coord_2[1], triangle_coord_2[2]);
		 Point o5=new Point(triangle_coord_2[3],triangle_coord_2[4], triangle_coord_2[5]);
		 Point o6=new Point(triangle_coord_2[6], triangle_coord_2[7], triangle_coord_2[8]);
		 Triangle t1=new Triangle(o1,o2,o3);
		 Triangle t2=new Triangle(o4,o5,o6);
		 Triangle t=null;
		 for(int i=0; i<tr.size(); i++) {
			  t=tr.at(i).data;
			 if(t.compare(t1)||t.compare(t2)) {
				 break;
			 }
		 }
		 if(t==null) {
			 return false;
		 }else if(t1.compare(t2)||this.TYPE_MESH()==1){
			 return true;
		 }else {
		 Queue<Triangle> q=new Queue<>();
		 if(t.compare(t1)){
			 q.add(t1);
			 t.visited=true;
			 while(!q.isEmpty()) {
				 Triangle tr=q.dequeue().data; 
				 this.ISNeighbour(tr);
				 for(int i=0; i<this.NOTcnt; i++) {
					 Triangle t3=this.NOT[i];
					 if(t3.compare((t2))){
						 for( i=0; i<this.tr.size(); i++) {
							 this.tr.at(i).data.visited=false;
						 }
						 return true;
					 }
					 q.add(this.NOT[i]);
					 t3.visited=true;
				 }
			 }
			 for(int i=0; i<this.tr.size(); i++) {
				 this.tr.at(i).data.visited=false;
			 }
			 return false;
		 } else { 
			 q.add(t2);
			 t.visited=true;
			while(!q.isEmpty()) {
				 Triangle tr=q.dequeue().data; 
				 this.ISNeighbour(tr);
				 for(int i=0; i<this.NOTcnt; i++) {
					 Triangle t3=this.NOT[i];
					 if(t3.compare(t1)) {
						 for( i=0; i<this.tr.size(); i++) {
							 this.tr.at(i).data.visited=false;
						 }
						 return true;
					 }
					 q.add(this.NOT[i]);
					 t3.visited=true;
				 }	 
			 }
			for(int i=0; i<this.tr.size(); i++) {
				 this.tr.at(i).data.visited=false;
			 }
			 return false;
			 }

		 } 
	 }
	 public Boolean find(Boolean[] arr, int length, Triangle t) {
		for(int i=0; i<length; i++) {
			if(((Triangle)arr[i].t).compare((Triangle)t)) {
				return arr[i];
			}
		}
		return null;
	 }
	 public void ISNeighbour(Triangle t) {
		 this.NOT=new Triangle[tr.size()];  this.NOTcnt=0;
		 for(int i=0; i<tr.size(); i++) {
			 Triangle tri=tr.at(i).data; 
			 if(tri.visited==false) {
			 if(t.e1.compare(tri.e1)||t.e1.compare(tri.e2)||t.e1.compare(tri.e3)) {
				 NOT[NOTcnt++]=tri;
			 }else if(t.e2.compare(tri.e1)||t.e2.compare(tri.e2)||t.e2.compare(tri.e3)) {
				 NOT[NOTcnt++]=tri;
			 }else if(t.e3.compare(tri.e1)||t.e3.compare(tri.e2)||t.e3.compare(tri.e3)) {
				 NOT[NOTcnt++]=tri;
			 }
		 }
		 }
	 }
	public int COUNT_CONNECTED_COMPONENTS(){
		Triangle[] arr=new Triangle[tr.size()]; int compcnt=0; int length=tr.size();
		 for(int i=0; i<tr.size(); i++) {
			 arr[i]=tr.at(i).data;
		 }
		 while(length!=0) {
		compcnt++;
		 Queue<Triangle> q=new Queue<>();
		 for(int i=0; i<tr.size(); i++) {
			 Triangle t=arr[i];
			 if(t!=null) {
			 q.add(t);
			 arr[i]=null; length--; t.visited=true;
			 break;
			 }
		 }
			 while(!q.isEmpty()) {
				 Triangle tr=q.dequeue().data; int j;
				 this.ISNeighbour(tr);
				 for(j=0; j<this.NOTcnt; j++) {
					 Triangle t=this.NOT[j]; t.visited=true;
					 int index=this.find(arr, t);
					 q.add(t);
					 arr[index]=null; length--; 
					 }
				 }
		  }
		 for(int i=0; i<this.tr.size(); i++) {
			 this.tr.at(i).data.visited=false;
		 }

		 return compcnt;
	 }
	 
	public int find(Triangle[] arr, Triangle t) {
		for(int i=0; i<tr.size(); i++) {
			if(arr[i]!=null&&arr[i]==t) {
				return i;
			}
	}
	 return -1;
}	
	public PointInterface CENTROID_OF_COMPONENT (float [] point_coordinates){
		 Point o1=new Point(point_coordinates[0], point_coordinates[1], point_coordinates[2]); Triangle t=null; int i;
		 float X=0,Y=0,Z=0; LinkedList<Point> list=new LinkedList<>();
		 for(i=0; i<tr.size(); i++) {
			  t=tr.at(i).data;
			 if(t.o1.compare(o1)||t.o2.compare(o1)||t.o3.compare(o1)) {
				 break;
			 }
		 }
		 if(i==tr.size()) {
			 return null;
		 }else {
			 Queue<Triangle> q=new Queue<>();
			 q.add(t);
			 t.visited=true; list.add(t.o1); list.add(t.o2); list.add(t.o3);
			 while(!q.isEmpty()) {
				 Triangle tr=q.dequeue().data; 
				 this.ISNeighbour(tr);
				 for(int j=0; j<this.NOTcnt; j++) {
					 Triangle t3=this.NOT[j];
					 q.add(t3);
					 t3.visited=true;	 
					 if(list.findp(t3.o1)==null) {
						 list.add(t3.o1);
					 }
					 if(list.findp(t3.o2)==null) {
						 list.add(t3.o2);
					 }
					 if(list.findp(t3.o3)==null) {
						 list.add(t3.o3);
					 }					 
				 } 
			 }
		 }
		 for( i=0; i<list.size(); i++) {
			 Point p=list.at(i).data;
			 X+=p.x; Y+=p.y; Z+=p.z;
		 }
		 System.out.println(""+X/list.size()+ Y/list.size()+ Z/list.size());
		PointInterface p=new Point(X/list.size(), Y/list.size(), Z/list.size());
		return p;
		}
	public PointInterface [] CENTROID (){
		Triangle[] arr=new Triangle[tr.size()];  int length=tr.size();
		 for(int i=0; i<tr.size(); i++) {
			 arr[i]=tr.at(i).data;
		 }
		
		
	}
	
	
	
	
	
	
	}
	
	
	
	

