package com.stonespells.models;

import org.puremvc.java.interfaces.IProxy;
import org.puremvc.java.patterns.proxy.Proxy;

public class PagedContentProxy extends Proxy implements IProxy {
	
	public static final String NAME = "InstructionsProxy";
	
	public PagedContentProxy() {
		super(NAME, new PagedContentVO());
	}
	
	public void create() {
		this.setData(new PagedContentVO());
	}
	
	public void setContent(String content, int charsPerPage) {
		if (charsPerPage == 0) {
			charsPerPage = 118;
		}
		
		int totalChars = content.length();
		int numPages = totalChars / charsPerPage + 1;
		this.setNumberOfPages( numPages );
		
		for (int i=0;i<numPages;i++) {
			int beginIndex = i*charsPerPage;
			int pageLength = ((beginIndex + charsPerPage) > totalChars) ? totalChars : beginIndex + charsPerPage;
			this.setPageContent(i, content.substring(beginIndex, pageLength));
		}
	}
	
	public String[] getLines(String content, int charsPerLine) {
		int totalChars = content.length();
		int totalLines = totalChars/charsPerLine + 1;
		String lines[] = new String[totalLines];
		for (int i=0;i < totalLines;i++) {
			int beginIndex = i * charsPerLine;
			int pageLength = ((beginIndex + charsPerLine) > totalChars) ? totalChars : beginIndex + charsPerLine;
			lines[i] = content.substring(beginIndex, pageLength);
		}
		return lines;
	}
	
	public int getCurrentPage() {
		return ((PagedContentVO) this.data).currentPage;
	}
	
	public String getContent() {
		return ((PagedContentVO) this.data).pagesContent[ this.getCurrentPage() ];
	}
	
	public int getNumberOfPages() {
		return ((PagedContentVO) this.data).numberOfPages;
	}
	
	public boolean isLastPage() {
		return this.getCurrentPage() == this.getNumberOfPages();
	}
	
	private void setNumberOfPages(int numberOfPages) {
		((PagedContentVO) this.data).numberOfPages = numberOfPages-1;
		((PagedContentVO) this.data).pagesContent = new String[numberOfPages];
	}
	
	private void setPageContent(int pageNumber, String content) {
		((PagedContentVO) this.data).pagesContent[pageNumber] = content;
	}

	public void setCurrentPage(int num) {
		((PagedContentVO) this.data).currentPage = num;
	}
}
