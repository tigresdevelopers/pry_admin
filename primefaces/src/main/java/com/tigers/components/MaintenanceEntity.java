package com.tigers.components;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import javax.faces.component.FacesComponent;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;


@FacesComponent(value="maintenance")
public class MaintenanceEntity  extends UINamingContainer{
	
		
	public Field[] getEntityFields() {
		
		Object object=(Object)getAttributes().get("entity");
		Class<?> clase=object.getClass();
		Field[] fields=clase.getDeclaredFields();
		return fields;
	}

	public int getCountFields() {
		return getEntityFields().length;
	}
	
	public String[] getEntityFieldsToUpper() {
		
		Object object=(Object)getAttributes().get("entity");
		
		Class<?> clase=object.getClass();
		Field[] allFields=clase.getDeclaredFields();
		String[]fields=null;
		boolean existSerialVersion=false;
		
		for (Field field : allFields) {
			existSerialVersion=field.getName().equalsIgnoreCase("serialversionuid")?true:false;
			if(existSerialVersion)
				fields=new String[allFields.length-1];//Para eliminar el SerialVersionUID
			else
				fields=new String[allFields.length];//Para eliminar el SerialVersionUID
		}
		
		for (int i=0;i<allFields.length;i++) {
			if(!allFields[i].getName().equalsIgnoreCase("serialversionuid")){
				String cadena=(String)allFields[i].getName().toLowerCase();
				String aux=String.valueOf(cadena.charAt(0)).toUpperCase();
				//fields[i]=cadena.replace(String.valueOf(cadena.charAt(0)),aux);
				fields[i]=(String)allFields[i].getName();
			}
		}
		return fields;
	}
	
	public Field[] getObjectFields(String unknow){
		
		Field[] fields=null;
		try {
			Class<?> clase = Class.forName(unknow);
			fields=clase.getDeclaredFields();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fields;
	}
	

	public void create(){
		System.out.println("metodo invocado");
		RequestContext.getCurrentInstance().execute("alert('Prueba:');");
		
		
		Object obj=getAttributes().get("dao");
		Object entity=getAttributes().get("entity");
		Class<?> dao=obj.getClass();
		System.out.println("Metodo FacesComponente Create: "+dao);
		
		if (entity!=null) {
			try {
				Method[] methods=dao.getDeclaredMethods();
				for (Method method : methods) {
					if (method.getName().equals("persist")){
						Class[] params=method.getParameterTypes();
						for (Class class1 : params) {
							System.out.println(class1);
						}
						method.invoke(obj,entity);
					}
				}
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		} else {
			System.out.println("nulo");
		}
	}
	
	public List<Object> list(){
		
		Object obj=getAttributes().get("dao");
		Object entity=getAttributes().get("entity");
		
		Class<?> dao=obj.getClass();
		Class<?> clazz=entity.getClass();
		
		System.out.println(clazz.getSimpleName());
		
		List<Object> list=null;
		try {
			Method[] methods=dao.getDeclaredMethods();
			for (Method method : methods) {
				if (method.getName().equals("listAll")) {
					list=(List<Object>) method.invoke(obj,clazz);
				}
			}
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		return list;
	}
	
}
