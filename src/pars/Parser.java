package pars;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parser {

	private Document dom = null;
	private ArrayList<Acciones> acciones = null;

	public Parser() {
		acciones = new ArrayList<Acciones>();
	}

	public void parseFicheroXml(String fichero) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			dom = db.parse(fichero);
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	public void parseDocument() {
		Element docEle = dom.getDocumentElement();

		NodeList nl = docEle.getElementsByTagName("accion");
		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {

				Element el1 = (Element) nl.item(i);

				String nombre = getTextValue(el1, "nombre");
				// System.out.println("Nombre: "+nombre);

				NodeList nl2 = el1.getElementsByTagName("operaciones");
				if (nl2 != null && nl2.getLength() > 0) {
					for (int j = 0; j < nl.getLength(); j++) {

						Element el2 = (Element) nl.item(j);

						NodeList nl3 = el2.getElementsByTagName("compras");
						if (nl3 != null && nl3.getLength() > 0) {
							for (int h = 0; h < nl.getLength(); h++) {

								Element el3 = (Element) nl.item(h);
								// System.out.println("Compra "+h+" :");

								NodeList nl4 = el3.getElementsByTagName("compra");
								if (nl4 != null && nl4.getLength() > 0) {

									for (int q = 0; q < nl.getLength(); q++) {

										Element el4 = (Element) nl.item(q);
										String compra_cant = getTextValue(el4, "cantidad");
										String compra_prec = getTextValue(el4, "precio");

										// System.out.println("Cantidad : "+compra_cant);
										// System.out.println("Precio: "+compra_prec);

									}
								}

							}
						}

						NodeList nl5 = docEle.getElementsByTagName("ventas");
						if (nl5 != null && nl5.getLength() > 0) {
							for (int w = 0; w < nl.getLength(); w++) {

								Element el5 = (Element) nl.item(w);
								// System.out.println("Venta "+w+" :");

								NodeList nl6 = docEle.getElementsByTagName("venta");
								if (nl6 != null && nl6.getLength() > 0) {
									for (int q = 0; q < nl.getLength(); q++) {

										Element el6 = (Element) nl.item(q);
										String venta_cant = getTextValue(el6, "cantidad");
										String venta_prec = getTextValue(el6, "precio");

										// System.out.println("Cantidad : "+venta_cant);
										// System.out.println("Precio: "+venta_prec);

									}
								}

							}
						}

					}

				}

				Acciones p = new Acciones();
				p.setNombre(nombre);

				acciones.add(p);
			}

		}
	}

	private String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if (nl != null && nl.getLength() > 0) {
			Element el = (Element) nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
			return textVal;
		}
		return null;
	}

	public void print() {

		Iterator it = acciones.iterator();
		while (it.hasNext()) {
			Acciones p = (Acciones) it.next();
			p.mostrar();
		}
	}

}
