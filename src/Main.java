import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args){
		
		TKubas kubas[] = null;
		short MAX = 20;
		
		if(args.length==0){
			kubas = new TKubas[20];
		}else if(args.length==2){
			if(args[0].equals("-maxCubes")){
				try{
					MAX = Short.parseShort(args[1]);
				}catch(Exception e){
					System.out.println("Kubu kiekis turi buti integer tipo! Naudojimas: -maxCubes <kiekis>");
					System.exit(0);
				}
			}else{
				System.out.println("Blogas(-i) parametras(-ai)! Naudojimas: -maxCubes <kiekis>");
				System.exit(0);
			}
		}else{
			System.out.println("Naudojimas: -maxCubes <kiekis>");
			System.exit(0);
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
		int chosenOne[] = new int[MAX];
		int j = 0; //chosenOne index
		
		//For debugging
		System.out.println("Kubo objektu limitas buvo nustatytas i: " + MAX);
		
		System.out.println("Kad nustatyti kitoki kubo objektu limita naudokita parametra -maxCubes <kiekis>");
		System.out.print("Pavyzdziui:   Klases.jar -maxCubes 60\n\n\n");
		
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
						
						
						System.out.println("Kurio kubo informacija norite pamatyti: ");
						cubeName = input.nextLine();
						input.nextLine();
						
						for(int i = 0; i < TKubas.cubes; i++){
							if(cubeName.equals(kubas[i].getName())){
								chosenOne[j] = i;
								j++;
							}
						}
						if(j==0){
							System.out.println("Ivedete neegzistuojanti kubo varda!");
							break;
						}
						for(int i = 0; i < j; i++){
							System.out.printf("Kubo pavadinimas: %s\tDydis: %f; %f; %f\t Pav. Plotas: %f\tTuris: %f\n", 
								kubas[chosenOne[i]].getName(),
								kubas[chosenOne[i]].getWidth(),
								kubas[chosenOne[i]].getHeight(),
								kubas[chosenOne[i]].getDepth(),
								kubas[chosenOne[i]].cubeSurfacePlot(),
								kubas[chosenOne[i]].cubeVol()
							);
						}
						j = 0;
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