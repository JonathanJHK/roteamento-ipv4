/*
*	Classe representante de uma rota
*/

public class Route {
	String network; 
	String mask;
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
		this.mask = typeDefinition(Long.parseLong(array[1].replace(".", "")));
		this.gateway = array[2];
		this.intface = array[3];
	}
	
	public boolean routeDefault () {
		if(network.equals("0.0.0.0"))
			return true;

		return false;
	}

	private String typeDefinition (Long mask) {
		if(mask < 40)
			return cidr (Integer.parseInt(mask + "")); 
		
		if (mask > 25525500) {
			return "C";
		}
		else if(mask > 25500000) {
			return "B";
		}
		return "A";
	}

	private String cidr (int mask) {
		switch (mask) {
			case 8 :
				iMask = Long.parseLong("255000");
				return "A";

			case 16 :
				iMask = Long.parseLong("25525500");
				return "B";

			default:
				iMask = Long.parseLong("2552552550");
				return "A";
		}
	}
}