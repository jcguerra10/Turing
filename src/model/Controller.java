package model;

public class Controller {

	private Content firstContent;
	private Machine c0;
	private Machine c1;
	private Machine c2;

	public Controller() {
		c0 = new Machine(null);
		c1 = new Machine(null);
		c2 = new Machine(null);
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

			if (ant != null) {
				newContent.setPrev(ant);
			}else {
				firstContent = newContent;
			}

		} else {
			c1.setPointed(newContent);
			if (c == null) {
				firstContent = newContent;
			} else {
				firstContent.setNext(newContent);
				newContent.setPrev(firstContent);
			}
		}
		verify();
	}

	public void addOnMachineC1second(Content newContent) {
		c1.add(newContent);
		firstContent = newContent;
		verify();
	}

	public void addOnMachineC2(Content newContent) {
		Content c = c2.getPointed();
		c2.setPointed(newContent);
		if (c == null) {
			firstContent = newContent;
		} else {
			c.setNext(newContent);
			newContent.setPrev(c);
		}
		verify();
	}

	public void removeOnMachineC0() {
		Content temp = c0.getPointed();
		if (temp != null) {
			Content sig = temp.getNext();
			if (sig != null) {
				sig.setPrev(null);
			}			
			firstContent = sig;
			c0.setPointed(sig);
			verify();
		}
	}

	public void removeOnMachineC1() {
		Content point = c1.getPointed();
		if (point != null) {
			Content ant = point.getPrev();
			Content sig = point.getNext();
			if (ant == null) {
				firstContent = null;
			}else {
				if (sig != null) {
					ant.setNext(sig);
					sig.setPrev(ant);
				}
			}					
			c1.setPointed(null);
			verify();
		}
	}

	public void removeOnMachineC2() {
		Content point = c2.getPointed();
		if (point != null) {
			Content ant = point.getPrev();
			if (ant == null) {
				firstContent = null;
			}else {
				c2.setPointed(ant);
				ant.setNext(null);
			}			
			verify();
		}
	}

	public String readOnMachineC0() {
		return c0.getPointed().getLetter();
	}

	public String readOnMachineC1() {
		return c1.getPointed().getLetter();
	}

	public String readOnMachineC2() {
		return c2.getPointed().getLetter();
	}

	public String show() {
		Content temp = firstContent;
		String msg = "";
		while (temp != null) {
			msg += temp + "\n";
			temp = temp.getNext();
		}
		return msg;
	}

	public boolean verifyForAdd() {
		Content temp = firstContent;
		boolean b = false;
		if (temp != null && temp.getNext() == null) {
			b = true;
		}
		return b;
	}
}