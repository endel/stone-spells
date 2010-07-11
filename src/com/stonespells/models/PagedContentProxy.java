package com.stonespells.models;

import org.puremvc.java.interfaces.IProxy;
import org.puremvc.java.patterns.proxy.Proxy;

/**
 * Classe responsável por lidar com a paginação de dados a serem escritos
 * na tela.
 */
public class PagedContentProxy extends Proxy implements IProxy {
	
	public static final String NAME = "InstructionsProxy";
	
	/**
	 * Construtor da classe. Instancia um novo contêiner de dados a serem
	 * escritos na tela.
	 */
	public PagedContentProxy() {
		super(NAME, new PagedContentVO());
	}
	/**
	 * Método que cria um novo contêiner de dados a serem escritos na tela.
	 */
	public void create() {
		this.setData(new PagedContentVO());
	}
	
	/**
	 * Método que configura o conteúdo do contêiner de dados a serem
	 * escritos na tela.
	 * @param content Especifica o conteúdo do contêiner
	 * @param charsPerPage Especifica o número de caracteres
	 * por página.
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
	 * Método que configura o tamanho e obtém uma linha de texto
	 * a ser escrita na tela.
	 * @param content Conteúdo total do texto.
	 * @param charsPerLine Número de caracteres por linha.
	 * @return Retorna as linhas de texto já parseadas.
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
	 * Método que obtém o conteúdo de uma página
	 * @return Conteúdo da página em questão.
	 */
	public int getCurrentPage() {
		return ((PagedContentVO) this.data).currentPage;
	}
	
	/**
	 * Método que retorna uma string com o conteúdo de uma página.
	 * @return String com o conteúdo de uma página.
	 */
	public String getContent() {
		return ((PagedContentVO) this.data).pagesContent[ this.getCurrentPage() ];
	}
	/**
	 * Método que retorna o número de páginas do contêiner.
	 * @return Inteiro que representa o número de páginas do contêiner.
	 */
	public int getNumberOfPages() {
		return ((PagedContentVO) this.data).numberOfPages;
	}
	
	/**
	 * Método que indica se determinada página é a última página do contêiner. 
	 * @return Booleana que verifica se a página corrente é a última
	 * do contêiner.
	 */
	public boolean isLastPage() {
		return this.getCurrentPage() == this.getNumberOfPages();
	}
	
	/**
	 * Método que configura o número de páginas do contâiner.
	 * @param numberOfPages O número de páginas a ser especificado
	 * no contâiner.
	 */
	private void setNumberOfPages(int numberOfPages) {
		((PagedContentVO) this.data).numberOfPages = numberOfPages-1;
		((PagedContentVO) this.data).pagesContent = new String[numberOfPages];
	}
	
	/**
	 * Método que configura o conteúdo de uma das páginas existentes no 
	 * contâiner.
	 * @param pageNumber O número da página a ser configurada.
	 * @param content O conteúdo a ser inserido na página.
	 */
	private void setPageContent(int pageNumber, String content) {
		((PagedContentVO) this.data).pagesContent[pageNumber] = content;
	}

	/**
	 * Método que especifica a página a ser tratada.
	 * @param num O número da página a ser tratada.
	 */
	public void setCurrentPage(int num) {
		((PagedContentVO) this.data).currentPage = num;
	}
}
