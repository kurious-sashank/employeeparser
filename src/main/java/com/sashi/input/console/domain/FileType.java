package com.sashi.input.console.domain;

public enum FileType {
	UNSORTED("Unsorted"),
	ALL_DATA_SORTED("All-Data-Sorted"),
	EXPERIENCE_RATIO("Experience-Age-Ratio");

	private String fileName;

	private FileType(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName(){
		return fileName;
	}
}
