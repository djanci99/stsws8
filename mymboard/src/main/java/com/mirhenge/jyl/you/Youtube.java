package com.mirhenge.jyl.you;

public class Youtube {
	private String title;
	private String url;
	private String videoId;
	private String img="";

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Youtube [title=" + title + ", url=" + url + ", videoId=" + videoId + ", img=" + img + "]";
	}

	public Youtube(String title, String url, String videoId, String img) {
		super();
		this.title = title;
		this.url = url;
		this.videoId = videoId;
		this.img = img;
	}

	public Youtube() {
		super();
		// TODO Auto-generated constructor stub
	}

	//2017.4.12 /watch?v=
	public String toUrl(String msg){
		String tt="";
		if(msg.indexOf("=")==-1){
			tt=msg;
		}else{
			tt=msg.substring(msg.indexOf("=")+1);
		}
		return tt;
	}
}
