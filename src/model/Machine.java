package model;

public class Machine {

	private Content pointed;

	public Machine(Content pointed) {
		this.pointed = pointed;
	}

	public Content getPointed() {
		return pointed;
	}

	public void setPointed(Content pointed) {
		this.pointed = pointed;
	}

	public void add(Content newContent) {
		newContent.setNext(pointed);
		pointed = newContent;
	}

}
