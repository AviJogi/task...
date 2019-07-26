package domsax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class readSAXfile {
public static void main(String[] args) {
	try {
		
	
	SAXParserFactory factory=SAXParserFactory.newInstance();
	SAXParser saxparser=factory.newSAXParser();
	
	DefaultHandler handler=new DefaultHandler() {

	boolean bfname=false;
	boolean blname=false;
	boolean bemail=false;
	boolean bdepartment=false;
	String id;
	boolean bempl;
	employee empl;
	
	
	public void startElement(String uri,String localname,String qname,Attributes attributes) throws SAXException{
		
		System.out.println("start element: " +qname);
		
		if(qname.equalsIgnoreCase("employee")) {
			empl=new employee();
			empl.setid(attributes.getValue("id"));
			bempl=true;
			
		}
		if(qname.equalsIgnoreCase("firstname")) {
			bfname=true;
		}
		if(qname.equalsIgnoreCase("lastname")) {
			blname=true;
		}
		if(qname.equalsIgnoreCase("email")) {
			bemail=true;
			
		}
		if(qname.equalsIgnoreCase("department")) {
			bdepartment=true;
		}
	}
	public void endElement(String uri,String localname,String qname) throws SAXException{
		System.out.println("end element: " +qname);
	}
	public void characters (char ch[],int start, int length)throws SAXException{
		if(bfname) {
			System.out.println("firstname: " + new String(ch,start,length));
			bfname=false;
		}
		if(blname) {
			System.out.println("lasttname: " + new String(ch,start,length));
			blname=false;
	}
		if(bemail) {
			System.out.println("email: " + new String(ch,start,length));
			bemail=false;
}
		if(bdepartment) {
			System.out.println("department: " + new String(ch,start,length));
			bdepartment=false;
}
}};

saxparser.parse("xmlfilepath.xml",handler);

}catch(Exception e) {
	e.printStackTrace();
}

}}





