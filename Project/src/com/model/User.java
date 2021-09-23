package com.model;

public class User {
int id;
String name;

User(){
}
public User(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}


@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + "]";
}
public void setPass(String string) {
	// TODO Auto-generated method stub
	
}

}
