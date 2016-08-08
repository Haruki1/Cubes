import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		
		List<TKubas> kubas = new ArrayList<TKubas>();

		Scanner input = new Scanner(System.in);
		
		String choice = null;
		String cubeName;
		boolean finish = false;
		float x,y,z;
		String name;
		List<Integer> chosenOne = new ArrayList<Integer>();
		int j = 0; //chosenOne index
		boolean existingCube;

		while(!finish){
			System.out.println("Ka darysite?\n\tkurti nauja kuba-kurti;\n\tkubu sarasas-sarasas;\n\tkubo info-info;\n\tpamatyti salyga-salyga\n\tbaigti programa-baigti");
			choice = input.nextLine();
			switch(choice){
			case "salyga":{
				
				System.out.println("8. Sukurkite klasæ TKubas.\nGalimi laukai: ilgis, plotis, aukðtis, tûris, plotas.\nGalimi " +
                                   "metodai:\nkubo sukûrimas, paraðymas, tûrio ir pavirðiaus ploto apskaièiavimas, palyginimas.\n\nDarba atliko: Laurynas Narbutas IN14\n");
				break;				
			}
				case "kurti":{
					System.out.println("Parasykite kuriamo kubo varda: ");
					name = input.nextLine();
					System.out.println("Parasykite kuriamo kubo auksti: ");
					y = input.nextFloat();
					System.out.println("Parasykite kuriamo kubo ploti: ");
					x = input.nextFloat();
					System.out.println("Parasykite kuriamo kubo gyli: ");
					z = input.nextFloat();
					kubas.add(new TKubas(name, x, y, z));
					//kubas[TKubas.cubes].createCube(name, x, y, z);
					input.nextLine();
					break;
				}
				case "sarasas":{
					if(TKubas.cubes==0){
						System.out.println("Nera sukurtu kubu!");
					}else{
						for(int i = 0; i < TKubas.cubes; i++){
							System.out.println(i+1 + ". Kubo vardas: " + kubas.get(i).getName());
						}
					}
					break;
				}
				case "info":{
					existingCube = false;
					if(TKubas.cubes==0){
						System.out.println("Nera sukurtu kubu!");
					}else{
						while(!existingCube){
							for(int i = 0; i < TKubas.cubes; i++){
								System.out.println(i+1 + ". Kubo vardas: " + kubas.get(i).getName());
							}
							System.out.print("\n\n");
						    System.out.println("DEMESIO: Programoje yra maza beda,\ntodel cia ivedus ieskomo kubo varda\nreiks du kartus paspaust Enter klavisa!");
							System.out.println("Kurio kubo informacija norite pamatyti(veskite ne indexa o varda): ");
							cubeName = input.nextLine();
							for(int i = 0; i < TKubas.cubes; i++){
								if(cubeName.equals(kubas.get(i).getName())){
									chosenOne.add(i);
									j++;
								}
							}
							if(j==0){
								System.out.println("Ivedete neegzistuojanti kubo varda!");
							}else{
								existingCube = true;
							}
							for(int i = 0; i < j; i++){
								System.out.print((chosenOne.get(i)+1) + ". ");
								kubas.get(chosenOne.get(i)).cubeInfo();
							}
							j = 0;
						}
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
	
}