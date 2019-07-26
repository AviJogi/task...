package com.readwrite;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class writejson {
@SuppressWarnings("unchecked")
public static void main (String[] args)  {
	System.out.println("first student");
	JSONObject studentdetails1=new JSONObject();
	studentdetails1.put("name", "avinash jogi");
	studentdetails1.put("age","29");
	studentdetails1.put("location", "pune");
	JSONObject studentobject1=new JSONObject();
	studentobject1.put("student", studentdetails1);
	
	System.out.println("second student");
	JSONObject studentdetails2=new JSONObject();
	studentdetails2.put("name", "abhijeet pode");
	studentdetails2.put("age","21");
	studentdetails2.put("location", "nagpur");
	JSONObject studentobject2=new JSONObject();
	studentobject2.put("student", studentdetails2);
	
	JSONArray studentlist=new JSONArray();
	studentlist.add(studentobject1);
	studentlist.add(studentobject2);
	
	try(FileWriter file=new FileWriter("student.json")){
		file.write(studentlist.toString());
		file.flush();
	}catch(IOException e) {
		e.printStackTrace();
	}
}
}
