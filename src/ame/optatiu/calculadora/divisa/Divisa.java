package ame.optatiu.calculadora.divisa;

public class Divisa {

	Float key;
	String value;
	
	public Divisa(Float key, String value){
		this.key = key;
		this.value = value;
	}
	
	public Float getKey(){
		return key;
	}
	
	public String getValue(){
		return value;
	}
	
	public String toString(){
		return Float.toString(key);
	}
	  
}
