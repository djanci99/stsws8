package org.ssis.edu.board.model;

public class ResResult {
	private String status;

	public ResResult() {
	}

	public ResResult(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ResResult [status=" + status + "]";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
