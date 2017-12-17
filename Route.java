

public class Route {
	String network; 
	String mask;
	String gateway;
	String intface;

	Route (String network) {
		this.network = network;
	}

	Route (String[] array) {
		this.network = array[0];
		this.mask = array[1];
		this.gateway = array[2];
		this.intface = array[3];
    }
}