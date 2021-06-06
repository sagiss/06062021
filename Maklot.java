import java.util.ArrayList;
public class Maklot {
private Boolean[] maklot;

	public Maklot(int num) {
		maklot = new Boolean[num];
		for(int i  = 0; i<num ; i++) {
			maklot[i] =  true;
		}
	}
		
	public void removeNumOfMaklot(int num) {
		int count = 0;
		for(int i  = 0; i<maklot.length && count < num ; i++) {
			if(maklot[i]) {
				maklot[i] = false;
				count++;
			}
		}
	}
	
	public boolean isEnough(int num) {
		int count= 0 ;
		for(int i  = 0; i<maklot.length ; i++) {
			if(maklot[i]) {
				count++;
			}
		}
		return count >= num;
	}
	
	public boolean isGotOne() {
		
		for(int i  = 0; i<maklot.length ; i++) {
			if(maklot[i]) {
			 return true;
				
			}
		}
		return false;
	}
	
	public boolean isAllOut() {
		for(int i  = 0; i<maklot.length ; i++) {
			if(maklot[i])
				return false;
		}
		return true;
	}
	
	public int getAmount() {
		return maklot.length;
	}
	
	public Boolean[] getMaklot() {
		return maklot;
	}
	
	public boolean isThere(int index) {
		return maklot[index];
	}
	public void addNumOfMaklot(int x) { 
		int count = 0;
		for (int i = 0; i<this.getMaklot().length;i++) {
			if (!this.getMaklot()[i]) {
				maklot[i] = true;
				count++;
				if (count == x) {
					return;
				}
			}
		}
	}
}
