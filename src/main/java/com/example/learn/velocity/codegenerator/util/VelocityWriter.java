package com.example.learn.velocity.codegenerator.util;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.example.learn.velocity.codegenerator.beans.Field;



public class VelocityWriter {
	static String modelName = "User";
    static String packageName = "com.companyname.projectname";
 
    public static void main(String[] args) {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init();
      
        Template t = velocityEngine.getTemplate("vtemplates/class.vm");
       
        VelocityContext context = new VelocityContext();
  
        if(packageName != null) {
            context.put("packagename", packageName);
        }
  
        List<Field> properties = new ArrayList<>();
        properties.add(new Field("id", "int"));
        properties.add(new Field("firstName", "String"));
        properties.add(new Field("lastName", "String"));
        properties.add(new Field("dob", "LocalDate"));
        context.put("className", modelName);
        context.put("properties", properties);
  
        StringWriter writer = new StringWriter();
        t.merge( context, writer );
  
        System.out.println(writer.toString());
    }

}
