package model;

public class Controller {

	private Content firstContent;
	private Machine c0;
	private Machine c1;
	private Machine c2;

	public Controller() {

	}

	public Content getFirstContent() {
		return firstContent;
	}

	public void setFirstContent(Content firstContent) {
		this.firstContent = firstContent;
	}

	private int size() {
		int size = 0;
		Content temp = firstContent;

		while (temp != null) {
			temp = temp.getNext();
			size += 1;
		}
		return size;
	}

	private void verify() {
		if (c0.getPointed() == null) {
			c0.setPointed(firstContent);
		}
		if (c1.getPointed() == null) {
			int i = size() / 2;
			Content temp = firstContent;
			while (i > 0) {
				temp = temp.getNext();
				i -= 1;
			}
			c1.setPointed(temp);
		}
		if (c2.getPointed() == null) {
			Content temp = firstContent;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			c2.setPointed(temp);
		}
	}

	public void addOnMachineC0(Content newContent) {
		c0.add(newContent);
		firstContent = newContent;
		verify();
	}

	public void addOnMachineC1(Content newContent) {
		Content c = c1.getPointed();
		if (size() > 1) {
			c1.add(newContent);
			Content ant = null;
			Content temp = firstContent;
			while (temp != null && temp != c) {
				ant = temp;
				temp = ant.getNext();
			}
			if (temp == c) {
				ant.setNext(newContent);
			}

		} else {
			if (c == null) {
				firstContent = newContent;
			} else {
				c1.setPointed(newContent);
				firstContent.setNext(newContent);
			}
		}
		verify();
	}

//	public void addOnMachineC2(Content newContent) {
//		Content c = c2.getPointed();
//		c2.add(newContent);
//		if (c == null) {
//			firstContent = newContent;
//		}else {
//			Content temp = firstContent;
//			while (temp != null && temp != c) {
//				temp = temp.getNext();
//			}
//			if (temp == c) {
//				temp.setNext(newContent);
//			}
//		}
//		Content temp = firstContent;
//		verify();
//	}
//	public void addContent(Content newContent) {
//		if (firstContent == null) {
//			firstContent = newContent;			
//		}else {
//			Content temp = firstContent;			
//			while (temp.getNext() != null) {
//				temp = temp.getNext();
//			}
//			temp.setNext(newContent);
//		}
//	}
}