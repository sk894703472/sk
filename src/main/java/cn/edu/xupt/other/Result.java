package cn.edu.xupt.other;

import java.util.Map;

public class Result {
	private int state;
	private String message;
	private Object content;
	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Result(int state, String message) {
		super();
		this.state = state;
		this.message = message;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public Result(String message, Map<String, Object> content) {
		super();
		this.message = message;
		this.content = content;
	}

	public Result(int state, String message, Object content) {
		super();
		this.state = state;
		this.message = message;
		this.content = content;
	}
	
}
