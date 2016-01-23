package example.boot.magic.service;

import java.util.List;

public class ResultsPage<T> {
	
	private List<T> rows;
	
	private Integer totalCount;
	
	public ResultsPage(){}

	public ResultsPage(List<T> rows, int totalCount) {
		this.rows = rows;
		this.totalCount = totalCount;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
	

}