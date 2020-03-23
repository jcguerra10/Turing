package model;

public class Content {
	private String letter;
	private Content next;

	public Content(String letter) {
		super();
		this.letter = letter;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public Content getNext() {
		return next;
	}

	public void setNext(Content next) {
		this.next = next;
	}
	
}
