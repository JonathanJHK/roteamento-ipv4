/*
*	Classe representante de uma rota
*/

public class Route {
	String network; 
	int[] mask;
	Long iMask;
	String gateway;
	String intface;
	/*
	*	Método construtor default
	*/
	Route (String network) {
		this.network = network;
	}
	/*
	*	Método construtor
	*/
	Route (String[] array) {
		this.network = array[0];
		this.iMask = Long.parseLong(array[1].replace(".", ""));
		//this.mask = typeDefinition(Long.parseLong(array[1].replace(".", "")));
		this.mask = typeDefinition(array[1]);
		
		this.gateway = array[2];
		this.intface = array[3];
	}
	
	public boolean routeDefault () {
		if(network.equals("0.0.0.0"))
			return true;

		return false;
	}

	private int[] typeDefinition (String mask) {
		if(Long.parseLong(mask.replace(".", "")) < 40)
			return cidr (Integer.parseInt(mask)); 
		
		String[] firstParse = mask.split("\\\\");

		String[] ipParse = firstParse[0].split("\\.");
		int[] decimal = new int[4];//vector que ira' conter os decimais
		
        for(int z = 0; z < ipParse.length; z++) { // tambem se pode usar 3 directamente uma vez que um IP tem sempre 4 octetos.
            decimal[z] = Integer.parseInt(ipParse[z]);// tens agora um vector com os 4 octetos em decimal         
		}

		return decimal;
	}

	private int[] cidr (int mask) {
		int[] value = new int[4];
		if (mask < 9) {
			value[0] = (int) Math.pow(2, mask);
			return value;   
		}
		if (mask < 9) {
			value[1] = (int) Math.pow(2, mask);
			return value;   
		}
		value[2] = (int) Math.pow(2, mask);
		return value;   
	}
}