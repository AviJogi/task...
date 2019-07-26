package domsax;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class createxmlfile {
	public static final	String xmlfilepath ="xmlfilepath.xml";
public static void main(String[] args) {

	try {
		DocumentBuilderFactory documentfactory=DocumentBuilderFactory.newInstance();
		DocumentBuilder documentbuilder=documentfactory.newDocumentBuilder();
		Document document=documentbuilder.newDocument();
		
		//root element
		Element root=document.createElement("company");
		document.appendChild(root);
//employee element
		Element employee=document.createElement("employee");
			root.appendChild(employee);
		
		//set an attribute to staff element
		Attr attr=document.createAttribute("id");
	attr.setValue("10");
	employee.setAttributeNode(attr);
	
	//firstname element
	Element firstname=document.createElement("firstname");
	firstname.appendChild(document.createTextNode("Riya"));
	employee.appendChild(firstname);
	
	//lastname element
	Element lastname=document.createElement("lastname");
	lastname.appendChild(document.createTextNode("Jogi"));
	employee.appendChild(lastname);
	
	//email element
	Element email=document.createElement("email");
	email.appendChild(document.createTextNode("monikapodey20@gmail.com"));
	employee.appendChild(email);
	
	//department element
	Element department=document.createElement("department");
	department.appendChild(document.createTextNode("Human Resources"));
	employee.appendChild(department);
	//create an xml file
	//transfer dom to xml file
	TransformerFactory transformerfactory=TransformerFactory.newInstance();
	Transformer transformer=transformerfactory.newTransformer();
	DOMSource domsource=new DOMSource(document);
	
	StreamResult streamresult=new StreamResult(new File(xmlfilepath));
	
	transformer.transform(domsource, streamresult);
	
	System.out.println("Done creating xml file");
	
	}catch(ParserConfigurationException pce) {
		pce.printStackTrace();
	}catch(TransformerException tfe) {
		tfe.printStackTrace();
	}
}
}