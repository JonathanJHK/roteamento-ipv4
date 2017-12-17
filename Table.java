

public class Table {
	Route[] route;
	int index = 0;

	Table (int size) {
		route = new Route[size];
	}

	public void add (String[] array) {
		if(array.length == 1)
			return;

		route[index++] = new Route(array);
	}

	public Route route (String ip) {
		Route choice = route[0];

		for (Route value : route)
			if((Integer.parseInt(value.network) & Integer.parseInt(value.mask)) == (Integer.parseInt(ip) & Integer.parseInt(value.mask)))
				choice = choose(value, choice);
		
		return choice;
	} 

	private Route choose (Route value, Route choice) {
		if(Integer.parseInt(value.mask) > Integer.parseInt(choice.mask))
			return value;

		return choice;
	}
}