

public class Table {
	String network; 
	String mask;
	String gateway;
	String interface;


	Table (String[] array) {
		this.network = array[0];
		this.mask = array[1];
		this.gateway = array[2];
		this.interface = array[3];
	}
}