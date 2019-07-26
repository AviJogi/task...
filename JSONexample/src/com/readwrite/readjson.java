package com.readwrite;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class readjson {
@SuppressWarnings("unchecked")
public static void main (String[] args) {
	JSONParser jsonparser=new JSONParser();
	try(FileReader reader=new FileReader("student.json"))
	{
		Object obj=jsonparser.parse(reader);
	JSONArray studentlist=(JSONArray) obj;
	System.out.println(studentlist);
	
	 studentlist.forEach(stu -> parsestudentobject( (JSONObject) stu ) );
	} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
private static void parsestudentobject(JSONObject student) {
	JSONObject studentobject=(JSONObject)student.get("student");
	String name=(String)studentobject.get("name");
	System.out.println("name : "+name);
	String age=(String)studentobject.get("age");
	System.out.println("age : "+age);
	String location=(String)studentobject.get("location");
	System.out.println("location : "+location);
}











}