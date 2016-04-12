import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args){
		
		TKubas kubas[] = null;
		short MAX = 20;
		
		if(args.length==0){
			kubas = new TKubas[20];
		}
		if(args.length!=0 && args.length!=2){
			System.out.println("Usage: -maxCubes <amount>");
			System.exit(0);
		}
		if(args.length==2 && args[0]!="-maxCubes"){
			System.out.println("Invalid parameter(s)! Usage: -maxCubes <amount>");
			System.exit(0);
		}
		if(args.length==2 && args[0]=="-maxCubes"){
			try{
				MAX = Short.parseShort(args[1]);
			}catch(Exception e){
				System.out.println("Amount must be a number! Usage: -maxCubes <amount>");
				System.exit(0);
			}
		}
		
		kubas = new TKubas[MAX];
		
		Scanner input = new Scanner(System.in);
		
		for(int i = 0; i < kubas.length ; i++){
			kubas[i] = new TKubas();
		}
		
		String choice = null;
		String cubeName;
		boolean finish = false;
		float x,y,z;
		String name;
		int chosenOne = 0;
		
		//For debugging
		System.out.println("Cube objects limit was set to: " + MAX);
		
		while(!finish){
			clearConsole();
			System.out.println("Ka darysite?\n\tkurti nauja kuba-kurti;\n\tkubu sarasas-sarasas;\n\tkubo info-info;\n\tbaigti programa-baigti");
			choice = input.nextLine();
			switch(choice){
				case "kurti":{
					System.out.println("Parasykite kuriamo kubo varda: ");
					name = input.nextLine();
					System.out.println("Parasykite kuriamo kubo auksti: ");
					y = input.nextFloat();
					System.out.println("Parasykite kuriamo kubo ploti: ");
					x = input.nextFloat();
					System.out.println("Parasykite kuriamo kubo gyli: ");
					z = input.nextFloat();
					kubas[TKubas.cubes].createCube(name, x, y, z);
					input.nextLine();
					break;
				}
				case "sarasas":{
					if(TKubas.cubes==0){
						System.out.println("Nera sukurtu kubu!");
					}else{
						for(int i = 0; i < TKubas.cubes; i++){
							System.out.println(i+1 + ". Kubo vardas: " + kubas[i].getName());
						}
					}
					break;
				}
				case "info":{
					if(TKubas.cubes==0){
						System.out.println("Nera sukurtu kubu!");
					}else{
						for(int i = 0; i < TKubas.cubes; i++){
							System.out.println(i+1 + ". Kubo vardas: " + kubas[i].getName());
						}
						System.out.println("Kelinto kubo informacija norite pamatyti: ");
						cubeName = input.nextLine();
						
						for(int i = 0; i < TKubas.cubes; i++){
							if(cubeName==kubas[i].getName()){
								chosenOne = i;
								break;
							}
						}
						
						System.out.printf("Kubo pavadinimas: %s\tDydis: %f; %f; %f\t Pav. Plotas: %f\tTuris: %f\n", 
							kubas[chosenOne].getName(),
							kubas[chosenOne].getWidth(),
							kubas[chosenOne].getHeight(),
							kubas[chosenOne].getDepth(),
							kubas[chosenOne].cubeSurfacePlot(),
							kubas[chosenOne].cubeVol()
						);
					}
					break;
				}
				case "baigti":{
					finish = true;
					break;
				}
				default:{
					System.out.println("Ivedete bloga pasirinkima!");
				}
			}
		}
		
		input.close();
	}
	
	public final static void clearConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    }
	}
	
}