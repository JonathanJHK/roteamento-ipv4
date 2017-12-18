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
		this.mask = array[1];
		this.gateway = array[2];
		this.intface = array[3];
    }
}