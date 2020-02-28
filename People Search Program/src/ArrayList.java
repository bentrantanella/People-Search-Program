
public class ArrayList {
	
	int sizecount;
	People[] finalarr;
	
	
	public ArrayList() {
		sizecount = 0;
	}


	public int getSizecount() {
		return sizecount;
	}


	public void setSizecount(int sizecount) {
		this.sizecount = sizecount;
	}


	public People[] getFinalarr() {
		return finalarr;
	}


	public void setFinalarr(People[] finalarr) {
		this.finalarr = finalarr;
	}
	
	public void sort() {
		
		for (int i = 0; i < finalarr.length-1; i++) {
			int min_idx = i;
			for (int j = i+1; j < finalarr.length; j++) {
				if (finalarr[j].getName().compareTo(finalarr[min_idx].getName()) < 0)
					min_idx = j;
			}
			People temp = finalarr[min_idx];
			finalarr[min_idx] = finalarr[i];
			finalarr[i] = temp;
		}
	}
	
	public void addPerson(People p) {
		
		if (sizecount == 0) {
			finalarr = new People[1];
			finalarr[0] = p;
		} else {
			People[] temparr = new People[sizecount];
			for(int i = 0; i < finalarr.length; i++)
				temparr[i] = finalarr[i];
			
			finalarr = new People[sizecount + 1];
			for(int i = 0; i < finalarr.length - 1; i++)
				finalarr[i] = temparr[i];
			
			finalarr[sizecount] = p;
			
		}
		
		sizecount++;
	}
	
	public void removePerson(People p) {
		
	}
}
