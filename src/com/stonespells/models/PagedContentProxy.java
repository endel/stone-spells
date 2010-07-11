package com.stonespells.models;

import org.puremvc.java.interfaces.IProxy;
import org.puremvc.java.patterns.proxy.Proxy;

/**
 * Classe respons�vel por lidar com a pagina��o de dados a serem escritos
 * na tela.
 */
public class PagedContentProxy extends Proxy implements IProxy {
	
	public static final String NAME = "InstructionsProxy";
	
	/**
	 * Construtor da classe. Instancia um novo cont�iner de dados a serem
	 * escritos na tela.
	 */
	public PagedContentProxy() {
		super(NAME, new PagedContentVO());
	}
	/**
	 * M�todo que cria um novo cont�iner de dados a serem escritos na tela.
	 */
	public void create() {
		this.setData(new PagedContentVO());
	}
	
	/**
	 * M�todo que configura o conte�do do cont�iner de dados a serem
	 * escritos na tela.
	 * @param content Especifica o conte�do do cont�iner
	 * @param charsPerPage Especifica o n�mero de caracteres
	 * por p�gina.
	 */
	public void setContent(String content, int charsPerPage) {
		this.setCurrentPage(0);
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
	
	/**
	 * M�todo que configura o tamanho e obt�m uma linha de texto
	 * a ser escrita na tela.
	 * @param content Conte�do total do texto.
	 * @param charsPerLine N�mero de caracteres por linha.
	 * @return Retorna as linhas de texto j� parseadas.
	 */
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
	
	/**
	 * M�todo que obt�m o conte�do de uma p�gina
	 * @return Conte�do da p�gina em quest�o.
	 */
	public int getCurrentPage() {
		return ((PagedContentVO) this.data).currentPage;
	}
	
	/**
	 * M�todo que retorna uma string com o conte�do de uma p�gina.
	 * @return String com o conte�do de uma p�gina.
	 */
	public String getContent() {
		return ((PagedContentVO) this.data).pagesContent[ this.getCurrentPage() ];
	}
	/**
	 * M�todo que retorna o n�mero de p�ginas do cont�iner.
	 * @return Inteiro que representa o n�mero de p�ginas do cont�iner.
	 */
	public int getNumberOfPages() {
		return ((PagedContentVO) this.data).numberOfPages;
	}
	
	/**
	 * M�todo que indica se determinada p�gina � a �ltima p�gina do cont�iner. 
	 * @return Booleana que verifica se a p�gina corrente � a �ltima
	 * do cont�iner.
	 */
	public boolean isLastPage() {
		return this.getCurrentPage() == this.getNumberOfPages();
	}
	
	/**
	 * M�todo que configura o n�mero de p�ginas do cont�iner.
	 * @param numberOfPages O n�mero de p�ginas a ser especificado
	 * no cont�iner.
	 */
	private void setNumberOfPages(int numberOfPages) {
		((PagedContentVO) this.data).numberOfPages = numberOfPages-1;
		((PagedContentVO) this.data).pagesContent = new String[numberOfPages];
	}
	
	/**
	 * M�todo que configura o conte�do de uma das p�ginas existentes no 
	 * cont�iner.
	 * @param pageNumber O n�mero da p�gina a ser configurada.
	 * @param content O conte�do a ser inserido na p�gina.
	 */
	private void setPageContent(int pageNumber, String content) {
		((PagedContentVO) this.data).pagesContent[pageNumber] = content;
	}

	/**
	 * M�todo que especifica a p�gina a ser tratada.
	 * @param num O n�mero da p�gina a ser tratada.
	 */
	public void setCurrentPage(int num) {
		((PagedContentVO) this.data).currentPage = num;
	}
}
