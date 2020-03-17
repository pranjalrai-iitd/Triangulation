
public class Edge implements EdgeInterface {
	Point o1,o2; PointInterface [] arr; int edgecnt;
	//[(x1,y1,z1),(x2,y2,z2)]
		// 2 points for an edge which can be in any order
	public Edge(Point o1, Point o2) {
		this.o1=o1;
		this.o2=o2;
		arr=new PointInterface[2];
		edgecnt=1;
	}
	public float length() {
		float a=(this.o1.getX()-this.o2.getX())*(this.o1.getX()-this.o2.getX());
		float b=(this.o1.getY()-this.o2.getY())*(this.o1.getY()-this.o2.getY());
		float c=(this.o1.getZ()-this.o2.getZ())*(this.o1.getZ()-this.o2.getZ());
		return this.squareRoot(a+b+c);
	}
	public float squareRoot(float number) {
		float temp;

		float sr = number / 2;

		do {
			temp = sr;
			sr = (temp + (number / temp)) / 2;
		} while ((temp - sr) != 0);

		return sr;
	    }
	public boolean compare(Edge e) {
		if(this.o1.compare(e.o1)&&this.o2.compare(e.o2)){
			return true;
		}else if(this.o1.compare(e.o2)&&this.o2.compare(e.o1)){
			return true;
		}else {
			return false;
		}
	}
	public PointInterface [] edgeEndPoints() {
		arr[0]=o1; arr[1]=o2;
		return arr;
	}
}
