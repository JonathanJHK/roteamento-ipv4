/*
*	Classe que representa a tabela
*/

public class Table {
	Route[] route;
	int index = 0;

	/*
	*	Método construtor
	*/
	Table (int size) {
		route = new Route[size];
	}

	/*
	*	Método add, adiciona uma nova rota na tabela
	*/
	public void add (String[] array) {
		if(array.length == 1)
			return;

		route[index] = new Route(array);
		index = index + 1;
	}

	/*
	*	Método route, responsavel por decidir o roteamento
	*/
	public Route route (String ip) {
		Route choice = new Route("default");

		for (Route value : route)
		{
			//Integer.parseInt(value.network.replaceAll(".", ""))
			//ip = ip.replace(".", "");
			//ip = ip.replace(" ", "");
			//System.out.println("------------- > " + ip.length());
			//System.out.println("------------ > " + Long.parseLong(value.mask.replace(".", "")) );
			//System.out.println("------------ > " + Long.parseLong(ip.replace(".", "")) );
			System.out.println();
			System.out.println((Long.parseLong(value.network.replace(".", "")) & Long.parseLong(value.mask.replace(".", ""))) + "--------------" + (Long.parseLong(ip.replace(".", "")) & Long.parseLong(value.mask.replace(".", ""))));
			if((Long.parseLong(value.network.replace(".", "")) & Long.parseLong(value.mask.replace(".", ""))) == (Long.parseLong(ip.replace(".", "")) & Long.parseLong(value.mask.replace(".", ""))))
				choice = choose(value, choice);
		}
			
		
		return choice;
	} 

	/*
	*	Método choose, define a plioridade entre rotas, como destino.
	*/
	private Route choose (Route value, Route choice) {
		System.out.println(value.network);
		if(choice.network.equals("default"))
			return value;
			
		if(Long.parseLong(value.mask) > Long.parseLong(choice.mask))
			return value;

		return choice;
	}
}