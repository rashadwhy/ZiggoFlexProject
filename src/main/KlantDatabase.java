import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

class KlantDatabase {
    private final List<Klant> klanten = new ArrayList<>();
    private final String xmlFilePath = "klantendatabase.xml";

    public boolean existsCustomer(String klantID) {
        for (Klant klant : klanten) {
            if (klant.getKlantID().equals(klantID)) {
                return true;
            }
        }
        return false;
    }

    public KlantDatabase() {
        loadFromXml();
    }

    private void loadFromXml() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFilePath);

            Element rootElement = document.getDocumentElement();
            NodeList klantNodes = rootElement.getElementsByTagName("klant");

            for (int i = 0; i < klantNodes.getLength(); i++) {
                Element klantElement = (Element) klantNodes.item(i);
                Klant klant = parseKlantFromElement(klantElement);
                klanten.add(klant);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Klant parseKlantFromElement(Element klantElement) {
        String klantID = getTextValue(klantElement, "klantID");
        String naam = getTextValue(klantElement, "naam");
        String postcode = getTextValue(klantElement, "postcode");
        String huisnummer = getTextValue(klantElement, "huisnummer");
        String aanmaakdatum = getTextValue(klantElement, "aanmaakdatum");

        List<String> pakketten = new ArrayList<>();
        Element pakkettenElement = (Element) klantElement.getElementsByTagName("pakketten").item(0);
        NodeList pakketNodes = pakkettenElement.getElementsByTagName("pakket");
        for (int i = 0; i < pakketNodes.getLength(); i++) {
            Element pakketElement = (Element) pakketNodes.item(i);
            String pakket = pakketElement.getTextContent();
            pakketten.add(pakket);
        }

        List<String> addons = new ArrayList<>();
        Element addonsElement = (Element) klantElement.getElementsByTagName("addons").item(0);
        NodeList addonNodes = addonsElement.getElementsByTagName("addon");
        for (int i = 0; i < addonNodes.getLength(); i++) {
            Element addonElement = (Element) addonNodes.item(i);
            String addon = addonElement.getTextContent();
            addons.add(addon);
        }

        return new Klant(klantID, naam, postcode, huisnummer, aanmaakdatum, pakketten, addons);
    }

    private String getTextValue(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList != null && nodeList.getLength() > 0) {
            StringBuilder textContent = new StringBuilder();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element tagElement = (Element) nodeList.item(i);
                textContent.append(tagElement.getTextContent());
            }
            return textContent.toString();
        }
        return "";
    }

    public Klant nieuweKlant(String klantID, String naam, String postcode, String huisnummer, String aanmaakdatum,
                             List<String> pakketten, List<String> addons) {
        Klant klant = new Klant(klantID, naam, postcode, huisnummer, aanmaakdatum, pakketten, addons);
        klanten.add(klant);
        saveToXml();
        return klant;
    }

    private void saveToXml() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element rootElement = document.createElement("klanten");
            document.appendChild(rootElement);

            for (Klant klant : klanten) {
                Element klantElement = createKlantElement(document, klant);
                rootElement.appendChild(klantElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(xmlFilePath);
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Element createKlantElement(Document document, Klant klant) {
        Element klantElement = document.createElement("klant");

        appendChildElement(document, klantElement, "klantID", klant.getKlantID());
        appendChildElement(document, klantElement, "naam", klant.getNaam());
        appendChildElement(document, klantElement, "postcode", klant.getPostcode());
        appendChildElement(document, klantElement, "huisnummer", klant.getHuisnummer());
        appendChildElement(document, klantElement, "aanmaakdatum", klant.getAanmaakdatum());

        Element pakkettenElement = document.createElement("pakketten");
        for (String pakket : klant.getPakketten()) {
            appendChildElement(document, pakkettenElement, "pakket", pakket);
        }
        klantElement.appendChild(pakkettenElement);

        Element addonsElement = document.createElement("addons");
        for (String addon : klant.getAddons()) {
            appendChildElement(document, addonsElement, "addon", addon);
        }
        klantElement.appendChild(addonsElement);

        return klantElement;
    }

    private void appendChildElement(Document document, Element parentElement, String tagName, String textContent) {
        Element childElement = document.createElement(tagName);
        childElement.setTextContent(textContent);
        parentElement.appendChild(childElement);
    }

    public Klant getKlant(String postcode, String huisnummer) {
        for (Klant klant : klanten) {
            if (klant.getPostcode().equals(postcode) && klant.getHuisnummer().equals(huisnummer)) {
                return klant;
            }
        }
        return null;
    }

    public Collection<Klant> getKlanten() {
        return klanten;
    }
}
