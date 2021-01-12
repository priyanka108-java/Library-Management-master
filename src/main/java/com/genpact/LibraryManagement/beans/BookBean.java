package com.genpact.LibraryManagement.beans;

public class BookBean {

	
    private String title;
    private String author;
    private String isbn;
    private int cost;
    
	public BookBean() {
	}

	public BookBean(String title, String author, String isbn, int cost) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.cost = cost;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
    

	@Override
	public String toString() {
		return "BookBean [title=" + title + ", author=" + author + ", isbn=" + isbn + ", cost=" + cost + "]";
	} 
    
    
}
