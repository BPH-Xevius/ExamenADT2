package pars;


public class ParserAcciones {
	
	public static void main(String[] args) {
		Parser parser=new Parser();
		parser.parseFicheroXml("qwert.xml");
		parser.parseDocument();
		//parser.print();
		
	}

}
