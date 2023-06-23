import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

class KortingChecker {
    private final String postcode;
    private final String huisnummer;

    public KortingChecker(String postcode, String huisnummer) {
        this.postcode = postcode;
        this.huisnummer = huisnummer;
    }

    public boolean isUniek() {
        try {
            File file = new File("klantendatabase.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("klant");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    String storedPostcode = element.getElementsByTagName("postcode").item(0).getTextContent();
                    String storedHuisnummer = element.getElementsByTagName("huisnummer").item(0).getTextContent();

                    if (postcode.equals(storedPostcode) && huisnummer.equals(storedHuisnummer)) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }
}
