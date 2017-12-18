

public class Table {
	Route[] route;
	int index = 0;

	Table (int size) {
		route = new Route[size];
	}

	public void add (String[] array) {
		if(array.length == 1)
			return;

		route[index] = new Route(array);
		index = index + 1;
	}

	public Route route (String ip) {
		Route choice = new Route("default");

		for (Route value : route)
		{
			//Integer.parseInt(value.network.replaceAll(".", ""))
			//ip = ip.replace(".", "");
			//ip = ip.replace(" ", "");
			//System.out.println("------------- > " + ip.length());
			
			if((Integer.parseInt(value.network.replace(".", "")) & Integer.parseInt(value.mask.replace(".", ""))) == (Integer.parseInt(ip.replace(".", "")) & Integer.parseInt(value.mask.replace(".", ""))))
				choice = choose(value, choice);
		}
			
		
		return choice;
	} 

	private Route choose (Route value, Route choice) {
		if(choice.network.equals("default"))
			return value;
			
		if(Integer.parseInt(value.mask) > Integer.parseInt(choice.mask))
			return value;

		return choice;
	}
}