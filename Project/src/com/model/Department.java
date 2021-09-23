package com.model;

public class Department {
private String dep_name;
private int dep_id;

Department(){
	
}

public Department(String dep_name, int dep_id) {
	super();
	this.dep_name = dep_name;
	this.dep_id = dep_id;
}

public String getDep_name() {
	return dep_name;
}
public void setDep_name(String dep_name) {
	this.dep_name = dep_name;
}
public int getDep_id() {
	return dep_id;
}
public void setDep_id(int dep_id) {
	this.dep_id = dep_id;
}
@Override
public String toString() {
	return "Department [dep_name=" + dep_name + ", dep_id=" + dep_id + "]";
}

}
