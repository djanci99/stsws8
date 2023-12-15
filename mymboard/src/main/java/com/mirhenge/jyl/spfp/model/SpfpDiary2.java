package com.mirhenge.jyl.spfp.model;

import java.io.Serializable;
import java.util.Date;

//com.mirhenge.jyl.spfp.model.SpfpDiary2

public class SpfpDiary2 {

	private int seq;
	private String id;
	private String wdate;
	private String content;
	private String ref;
	private String img;
	//  ---추가
	private int team;
	private String pair="";
	public SpfpDiary2(int seq, String id, String wdate, String content, String ref, String img, int team, String pair) {
		super();
		this.seq = seq;
		this.id = id;
		this.wdate = wdate;
		this.content = content;
		this.ref = ref;
		this.img = img;
		this.team = team;
		this.pair = pair;
	}
	public SpfpDiary2() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SpfpDiary2 [seq=" + seq + ", id=" + id + ", wdate=" + wdate + ", content=" + content + ", ref=" + ref
				+ ", img=" + img + ", team=" + team + ", pair=" + pair + "]";
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getTeam() {
		return team;
	}
	public void setTeam(int team) {
		this.team = team;
	}
	public String getPair() {
		return pair;
	}
	public void setPair(String pair) {
		this.pair = pair;
	}
	
	
}
