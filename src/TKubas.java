public class TKubas {
	
	String name;
	private float x,y,z;
	public static short cubes = 0;
	
	void createCube(String name, float x, float y, float z){
		
		this.name = name;
		this.x = x;
		this.y = y;
		this.z = z;
		cubes++;
	}
	
	String getName(){
		return name;
	}
	float getHeight(){
		return y;
	}
	float getWidth(){
		return x;
	}
	float getDepth(){
		return z;
	}
	
	float cubeVol(){
		
		return x * y * z;
		
	}
	
	float cubeSurfacePlot(){
		
		return 2 * (x * y + x * z + y * z);
		
	}
	
}