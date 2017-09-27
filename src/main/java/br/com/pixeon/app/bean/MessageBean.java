package br.com.pixeon.app.bean;

import java.io.Serializable;

public class MessageBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String from;
	private String to;
	private String content;

	public MessageBean() {
		super();
	}

	public MessageBean(Integer id, String from, String to, String content) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.content = content;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

    @Override
    public String toString() {
        return super.toString();
    }

}
