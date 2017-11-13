package com.jiayidai.assess.util;

public class JsonResult {
	private int status;
	private String responseText;
	private Object data;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getResponseText() {
		return responseText;
	}

	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "JsonResult [status=" + status + ", responseText="
				+ responseText + ", data=" + data + "]";
	}

}
