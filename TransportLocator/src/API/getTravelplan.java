package API;
import java.net.URL;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class getTravelplan {
	public static Document loadTestDocument(String url) throws Exception {
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    factory.setNamespaceAware(true);
	    return factory.newDocumentBuilder().parse(new URL(url).openStream());
	}
}
