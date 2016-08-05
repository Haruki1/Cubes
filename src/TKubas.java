public class TKubas {
	
	String name;
	private float x,y,z;
	public static short cubes = 0;
	
	TKubas(String name, float x, float y, float z){
		
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
	
	void cubeInfo(){
		System.out.printf("Kubo pavadinimas: %s    Dydis: %f; %f; %f    Pav. Plotas: %f    Turis: %f\n", 
				name, x, y, z, cubeSurfacePlot(), cubeVol()
			);
	}
	
	float cubeSurfacePlot(){
		
		return 2 * (x * y + x * z + y * z);
		
	}
	
}