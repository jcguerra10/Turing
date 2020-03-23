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
		if (pointed != null) {
			newContent.setNext(pointed);
		}
		pointed = newContent;
	}
	
	
	
}
