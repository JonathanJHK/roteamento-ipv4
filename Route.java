/*
*	Classe representante de uma rota
*/

public class Route {
	String network; 
	String mask;
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
		this.mask = typeDefinition(Long.parseLong(array[1].replace(".", "")));
		this.gateway = array[2];
		this.intface = array[3];
	}
	
	private String typeDefinition (Long mask) {
		if (mask > 25525500) {
			return "C";
		}
		else if(mask > 25500000) {
			return "B";
		}
		return "A";
	}
}