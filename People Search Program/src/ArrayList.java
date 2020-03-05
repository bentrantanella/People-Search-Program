
public class ArrayList {
	
	int sizecount;
	People[] finalarr;
	int bincount;
	int seqcount;
	
	
	public ArrayList() {
		sizecount = 0;
		bincount = 0;
		seqcount = 0;
	}


	public int getBincount() {
		return bincount;
	}


	public void setBincount(int bincount) {
		this.bincount = bincount;
	}


	public int getSeqcount() {
		return seqcount;
	}


	public void setSeqcount(int seqcount) {
		this.seqcount = seqcount;
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
		People[] temp = new People[finalarr.length];
		for(int i = 0; i < finalarr.length; i++)
			temp[i] = finalarr[i];
		
		finalarr = new People[sizecount - 1];
		int count = 0;
		for(int i = 0; i < temp.length; i++) {
			if (p == temp[i])
				continue;
			else {
				finalarr[count] = temp[i];
				count++;
			}
		
		}
		sizecount--;
	}
	
	public People searchArray(boolean isbin, String n) {
		bincount = 0;
		seqcount = 0;
		
		if (isbin == true) {
			sort();
			
			int left = 0;
			int right = finalarr.length - 1;
			
			int compareval;
			
			while (left <= right) {
				int middle = left + (right - left) / 2;
				bincount++;
				compareval = finalarr[middle].getName().toLowerCase().compareTo(n.toLowerCase());
				if (compareval == 0) {
					return finalarr[middle];
				} else if (compareval > 0) {
					right = middle - 1;
					
				} else {
					left = middle + 1;
				}
				
			}
			return null;
		} else {
			for(int i = 0; i < finalarr.length; i++) {
				seqcount++;
				if (finalarr[i].getName().equalsIgnoreCase(n))
					return finalarr[i];
			}
			
			return null;
		}
	}
}
