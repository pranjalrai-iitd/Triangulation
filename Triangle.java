
public class Triangle implements TriangleInterface {
	
	Point o1,o2,o3; PointInterface [] arr; Edge e1,e2,e3; int vtn=0; float[] co; boolean visited;
	//[(x1,y1,z1),(x2,y2,z2)]
		// 2 points for an edge which can be in any order
	public Triangle(Point o1, Point o2, Point o3) {
		this.o1=o1;
		this.o2=o2;
		this.o3=o3;
		e1=new Edge(o2,o3);
		e2=new Edge(o1,o3);
		e3=new Edge(o1,o2);
		arr=new PointInterface[3];
		co=new float[9];
		visited=false;
	}
	public boolean compare(Triangle t) {
		if(this.o1.compare(t.o1)) {
			if(this.o2.compare(t.o2)&&this.o3.compare(t.o3)){
				return true;
			}else if(this.o2.compare(t.o3)&&this.o3.compare(t.o2)){
				return true;
			}else {
				vtn=1;
				return false;
			}
		}else if(this.o1.compare(t.o2)) {
			if(this.o2.compare(t.o1)&&this.o3.compare(t.o3)){
				return true;
			}else if(this.o2.compare(t.o3)&&this.o3.compare(t.o1)){
				return true;
			}else {
				vtn=1;
				return false;
			}
		}else if(this.o1.compare(t.o3)) {
			if(this.o2.compare(t.o1)&&this.o3.compare(t.o2)){
				return true;
			}else if(this.o2.compare(t.o2)&&this.o3.compare(t.o1)){
				return true;
			}else {
				vtn=1;
				return false;
			}
		}else {
		 vtn=-1;
			return false;
		}
	}
	public float[] coor() {
		co[0]=o1.x; co[1]=o1.y; co[2]=o1.z; co[3]=o2.x; co[4]=o2.y; co[5]=o2.z; co[6]=o3.x; co[7]=o3.y; co[8]=o3.z;
		return co;
	}
	public PointInterface [] triangle_coord() {
		arr[0]=o1; arr[1]=o2; arr[2]=o3;
		return arr;
	}
}
