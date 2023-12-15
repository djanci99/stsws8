package com.mirhenge.jyl.spfp.model;

import java.io.Serializable;
import java.util.Date;

//com.mirhenge.jyl.spfp.model.SpfpDiary

public class SpfpDiaryTool  {

	private int seq;
	private String id;
	private Date wdate;
	private String content;
	private String ref;
	private String img;
	private int team;
	private String path;
	private String pair="";
	
	
	public SpfpDiaryTool(int seq, String id, Date wdate, String content, String ref, String img, int team, String path,
			String pair) {
		super();
		this.seq = seq;
		this.id = id;
		this.wdate = wdate;
		this.content = content;
		this.ref = ref;
		this.img = img;
		this.team = team;
		this.path = path;
		this.pair = pair;
	}
	public SpfpDiaryTool() {
		super();
	}
	public SpfpDiaryTool(SpfpDiary diary, String path) {
		super();
		this.seq = diary.getSeq();
		this.id = diary.getId();
		this.wdate = diary.getWdate();
		this.content = diary.getContent();
		this.ref = diary.getRef();
		if(diary.getImg().contains("back")) {
			this.img=null;
		}else{
			this.img = diary.getImg();
		}
		this.team=diary.getTeam();
		this.path = path;
		this.pair=pair;
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
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
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
	@Override
	public String toString() {
		return "SpfpDiaryTool [seq=" + seq + ", id=" + id + ", wdate=" + wdate + ", content=" + content + ", ref=" + ref
				+ ", img=" + img + ", team=" + team + ", path=" + path + ", pair=" + pair + "]";
	}
	
}
