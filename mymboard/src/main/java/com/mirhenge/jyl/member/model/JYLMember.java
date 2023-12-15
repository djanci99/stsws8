package com.mirhenge.jyl.member.model;

//com.mirhenge.jyl.member.model.JYLMember
public class JYLMember {

	private String id;
	private String name;
	private String email;
	private String pwd;
	private int delflag;
	//20160106 
	private int auth=3;
	
	// 20174
	private int team;
	
	//20230524
	private String npwd;
	
	public String getNpwd() {
		return npwd;
	}
	public void setNpwd(String npwd) {
		this.npwd = npwd;
	}
	/*
	 * 2023 private String cname; //color name for team
	 * 
	 * public String getCname() { return cname; } public void setCname(String cname)
	 * { this.cname = cname; }
	 */
	public JYLMember() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JYLMember(String id, String name, String email, String pwd,
			int delflag, int auth) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.delflag = delflag;
		this.auth = auth;
	}
	public JYLMember(String id, String name, String email, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
	}
	//�߰�
	public JYLMember(String id, String name, String email, String pwd, int delflag, int auth, int team) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.delflag = delflag;
		this.auth = auth;
		this.team = team;
	}
	public int getTeam() {
		return team;
	}
	public void setTeam(int team) {
		this.team = team;
	}
	@Override
	public String toString() {
		return "JYLMember [id=" + id + ", name=" + name + ", email=" + email + ", pwd=" + pwd + ", delflag=" + delflag
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

	
	
}