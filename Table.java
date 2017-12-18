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

		route[index++] = new Route(array);
	}

	/*
	*	Método route, responsavel por decidir o roteamento
	*/
	public Route route (String ip) {
		Route choice = new Route("default");

		for (Route value : route)
		{
			//System.out.println(networkCalculation(ip, value.mask) + " ---- " + value.mask);
			//System.out.println(networkCalculation(value.network, value.mask));
			//System.out.println(networkCalculation(ip, value.mask) == networkCalculation(value.network, value.mask));
			if(networkCalculation(ip, value.mask).equals(networkCalculation(value.network, value.mask)))
				choice = choose(value, choice);
		}
			
		
		return choice;
	} 
	
	/*
	*	Método choose, define a plioridade entre rotas, como destino.
	*/
	private Route choose (Route value, Route choice) {
		if(choice.network.equals("default"))
			return value;
			
		if(value.iMask > choice.iMask)
			return value;

		return choice;
	}

	private String networkCalculation (String ip, String type) {
        String input = "195.156.87.98/20"; // obtido por parametro ou outra coisa qualquer.
        input = ip;
        /*A "\" é um caracter especial de Strings e de expressoes regulares, 
            se nao me engano sao mesmo precisas as 4 barras. 
         */
        String[] firstParse = input.split("\\\\");
        
        /* Novamente o ponto e' um caracter especial para expressoes regulares
            e tem de ser precedido de uma "\" para ser considerado um caracter normal.*/
        String[] ipParse = firstParse[0].split("\\.");
        int[] decimal = new int[4];//vector que ira' conter os decimais
        
        for(int z = 0; z < ipParse.length; z++) { // tambem se pode usar 3 directamente uma vez que um IP tem sempre 4 octetos.
            decimal[z] = Integer.parseInt(ipParse[z]);// tens agora um vector com os 4 octetos em decimal         
		}
		
		switch (type) {
			case "A":
				//AND logico, com reutilizacao de variavel
				decimal[0] = decimal[0] & 255;
				decimal[1] = decimal[1] & 0;
				decimal[2] = decimal[2] & 0;
				decimal[3] = decimal[3] & 0;		
				break;
			
			case "B":
				//AND logico, com reutilizacao de variavel
				decimal[0] = decimal[0] & 255;
				decimal[1] = decimal[1] & 255;
				decimal[2] = decimal[2] & 0;
				decimal[3] = decimal[3] & 0;
				break;
			
			default:
				//AND logico, com reutilizacao de variavel
				decimal[0] = decimal[0] & 255;
				decimal[1] = decimal[1] & 255;
				decimal[2] = decimal[2] & 255;
				decimal[3] = decimal[3] & 0;
				break;
		}
        
        /*AND logico, com reutilizacao de variavel
        decimal[0] = decimal[0] & 255;//hardcoded pelo exemplo que deste
        decimal[1] = decimal[1] & 0;
        decimal[2] = decimal[2] & 0;
		decimal[3] = decimal[3] & 0;//Integer.parseInt(firstParse[1]);// se nao te esueceste na segunda posicao do vector estava a MASK
		*/
		return decimal[0] + "" + decimal[1] + "" + decimal[2] + "" + decimal[3];
	}
}