package com.mirhenge.jyl.spfp.model;

import java.io.Serializable;
import java.util.Date;

//com.mirhenge.jyl.spfp.model.SpfpDiary

public class SpfpDiary {

	private int seq;
	private String id;
	private Date wdate;
	private String content;
	private String ref;
	private String img;
	//  ---추가
	private int team;
	private String pair="";
	private String cname;
	
	//-- 시간 수정을 위해서
	private String yyyymmddhhmm;
	
	

	public String getYyyymmddhhmm() {
		return yyyymmddhhmm;
	}

	public void setYyyymmddhhmm(String yyyymmddhhmm) {
		this.yyyymmddhhmm = yyyymmddhhmm;
	}

	public SpfpDiary(int seq, String id, Date wdate, String content, String ref, String img, int team) {
		super();
		this.seq = seq;
		this.id = id;
		this.wdate = wdate;
		this.content = content;
		this.ref = ref;
		this.img = img;
		this.team = team;
	}

	public SpfpDiary(int seq, String id, Date wdate, String content, String ref, String img) {
		super();
		this.seq = seq;
		this.id = id;
		this.wdate = wdate;
		this.content = content;
		this.ref = ref;
		this.img = img;
	}

	public SpfpDiary(String id, String content, String ref, String img) {
		super();
		this.id = id;
		this.content = content;
		this.ref = ref;
		this.img = img;
	}

	public SpfpDiary() {
		super();
	}

	


	public SpfpDiary(int seq, String id, Date wdate, String content, String ref, String img, int team, String pair) {
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

	public SpfpDiary(int seq, String id, Date wdate, String content, String ref, String img, int team, String pair,
			String cname) {
		super();
		this.seq = seq;
		this.id = id;
		this.wdate = wdate;
		this.content = content;
		this.ref = ref;
		this.img = img;
		this.team = team;
		this.pair = pair;
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "SpfpDiary [seq=" + seq + ", id=" + id + ", wdate=" + wdate + ", content=" + content + ", ref=" + ref
				+ ", img=" + img + ", team=" + team + ", pair=" + pair + ", cname=" + cname + "]";
	}

	public String getPair() {
		return pair;
	}

	public void setPair(String pair) {
		this.pair = pair;
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

	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Date wdate) {
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

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	
	
}
