package org.ssis.edu.member.model;

public class MemberDto {
   private String id;
   private String name;
   private String email;
   private String pwd;
   private int delflag;
   private int auth;
   private int team ;
   public MemberDto() {
		
   }
public MemberDto(String id, String name, String email, String pwd, int delflag, int auth, int team) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.pwd = pwd;
	this.delflag = delflag;
	this.auth = auth;
	this.team = team;
}
public MemberDto(String id, String name, String email, String pwd) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.pwd = pwd;
}
@Override
public String toString() {
	return "MemberDto [id=" + id + ", name=" + name + ", email=" + email + ", pwd=" + pwd + ", delflag=" + delflag
			+ ", auth=" + auth + ", team=" + team + "]";
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public int getDelflag() {
	return delflag;
}
public void setDelflag(int delflag) {
	this.delflag = delflag;
}
public int getAuth() {
	return auth;
}
public void setAuth(int auth) {
	this.auth = auth;
}
public int getTeam() {
	return team;
}
public void setTeam(int team) {
	this.team = team;
}
   
   
}
