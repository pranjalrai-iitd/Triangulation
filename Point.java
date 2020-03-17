
public class Point implements PointInterface {
	float x,y,z; float[] arr;
	public Point(float x, float y, float z) {
		this.x=x;
		this.y=y;
		this.z=z;
		arr=new float[3];
	}
	public float getX() {
		return x;
	}
   public float getY() {
		return y;
	 }
   public float getZ() {
		return z;
	 }
   public boolean compare(Point o) {
	   if(this.getX()==o.getX()&&this.getY()==o.getY()&&this.getZ()==o.getZ()) {
		   return true;
	   }else {
		   return false;
	   }
   }
 
		//[x,y,z]  3 dimensions first is x second y and third is z.
		// This order should be followed

   public float [] getXYZcoordinate() {
	    	arr[0]=x;
	    	arr[1]=y;
	    	arr[2]=z;
	    	return arr;
	    }

}
