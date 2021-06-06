
//import java.util.*;
//
//public class GameManager {
//	private Maklot[] lines;
//	private int turn; //0- p1 1 -p2
//	private boolean gameOver;
//	private boolean hasStarted;
//	// turns
//	//impl who wins
//	
//	
//	public GameManager(int lines) {
//		int numOfMaklot = 1; // reset lines in pyramid shape
//		this.lines = new Maklot[lines];
//		for(int i  = 0; i<lines ; i++) {
//			this.lines[i] = new Maklot(numOfMaklot);
//			numOfMaklot+=2;
//		}
//	
//		Random rand = new Random();
//		this.turn = 0;
//		this.gameOver = false;
//		this.hasStarted = false;
//	}
//	
//	
//	public void playTurn(int selectedRow, int amount) throws Exception {
//		if(!hasStarted) {
//			hasStarted = true;
//		}
//		if(this.lines[selectedRow].isEnough(amount)) {
//			this.lines[selectedRow].removeNumOfMaklot(amount);
//		}else {
//			throw new Exception("NOOOOOO");
//		}
//		
//		if(isWon()) {
//			this.gameOver = true;
//		}
//		else {
//			if(this.turn == 0) {
//				this.turn = 1;
//			}else {
//				this.turn = 0;
//		
//			}
//		}
//	}
//    
//
//	private boolean isWon() {
//		int count = 0;
//		for(int i  = 0; i<lines.length ; i++) {
//			if(this.lines[i].isGotOne()) {
//				count++;
//			}
//			if(count > 1) {
//				return false;
//			}
//		}
//		return true;
//	}
//
//
//	public int getTurn() {
//		return turn;
//	}
//
//
//	public void setTurn(int turn) {
//		this.turn = turn;
//	}
//
//
//	public boolean isGameOver() {
//		return gameOver;
//	}
//	
//	public boolean HasStarted() {
//		return hasStarted;
//	}
//
//	public void setGameOver(boolean gameOver) {
//		this.gameOver = gameOver;
//	}
//	
//	public int getAmountOfLines() {
//		return lines.length;
//	}
//	
//	public int getAmountOfMaklotInLine(int row) {
//		return lines[row].getAmount();
//	}
//	
//	public Maklot[] getLines() {
//		return lines;
//	}
//	
//	public void print() {
//		for(int i = 0 ; i<lines.length; i++) {
//			Maklot m  = lines[i];
//			for(int j  =0 ; j<m.getAmount();j++) {
//				if(m.isThere(j)) {
//					System.out.print("X");
//				}
//			}
//			System.out.println();
//		}
//	}
//	public int minimax(int depth,boolean isP1) {
//		int bestScore = Integer.MIN_VALUE;
//		int score = bestScore;
//		int bestRow = -1;
//		int bestAmmount = -1;
//		if (this.isGameOver()) {
//			if (!isP1)
//				return depth*-1;
//			else 
//				return depth*1;
//		}
//		if (depth == 0) 
//			return 0;
//		if (!isP1) {
//			
//		for (int i = 0; i<this.lines.length; i++) {
//			for (int j = 1; j<this.lines[i].getMaklot().length+1;j++) {
//				if (this.lines[i].isEnough(j)) {
//					this.lines[i].removeNumOfMaklot(j);
//					score = this.minimax(depth - 1,!isP1);
//					if (score > bestScore) {
//						bestScore = score;
//						bestRow = i+1;
//						bestAmmount = j;
//					}
//					this.lines[i].addNumOfMaklot(j);
//				}
//			}
//		}
//		}
//		else {
//			bestScore = Integer.MAX_VALUE;
//			score = bestScore;
//			for (int i = 0; i<this.lines.length; i++) {
//				for (int j = 1; j<this.lines[i].getMaklot().length+1;j++) {
//					if (this.lines[i].isEnough(j)) {
//						this.lines[i].removeNumOfMaklot(j);
//						score = this.minimax(depth - 1,!isP1);
//						if (score < bestScore) {
//							bestScore = score;
//							bestRow = i+1;
//							bestAmmount = j;
//						}
//						this.lines[i].addNumOfMaklot(j);
//					}
//				}
//			}
//		}
//		return bestScore;
//	}
//	public int bestRow() {
//		int bestRow = -1;
//		int bestAmmount = -1;
//		int bestScore = Integer.MIN_VALUE;
//		int score = bestScore;
//		for (int i = 0; i<this.lines.length; i++) {
//			for (int j = 1; j<this.lines[i].getMaklot().length+1;j++) {
//				if (this.lines[i].isEnough(j)) {
//					this.lines[i].removeNumOfMaklot(j);
//					score = this.minimax(7,true);
//					if (score > bestScore) {
//						bestScore = score;
//						bestRow = i+1;
//						bestAmmount = j;
//					}
//					this.lines[i].addNumOfMaklot(j);
//				}
//			}
//		}
//		return bestRow*10+bestAmmount;
//	}
//	
//}




import java.util.*;

public class GameManager {
    private final ArrayList<Integer> lines;
    private int turn; //0- p1 1 -p2

    public GameManager(int lines) {
        int numOfMaklot = 1; // reset lines in pyramid shape
        this.lines = new ArrayList<Integer>();
        for (int i = 0; i < lines; i++) {
            this.lines.add(numOfMaklot);
            numOfMaklot += 2;
        }
        Random rand = new Random();
        this.turn = rand.nextInt(2);
    }

    public GameManager(GameManager other) {
        this.lines = new ArrayList<Integer>();
        this.lines.addAll(other.lines);
        this.turn = other.turn;
    }

    public boolean playTurn(int selectedRow, int amount) {
        if (this.lines.get(selectedRow) >= amount) {
            this.lines.set(selectedRow,this.lines.get(selectedRow)-amount);
        } else {
            return false;
        }

        if (getWinner().equals("none")) {
            if (this.turn == 0) {
                this.turn = 1;
            } else {
                this.turn = 0;

            }
        }
        return true;

    }

    public void addNumToLine(int line,int amount){
        lines.set(line,lines.get(line)+amount);
    }

    public String getWinner() {
        int count = 0;
        for (int i = 0; i < lines.size(); i++) {
            if (!(lines.get(i) == 1) && !(lines.get(i) == 0))
                return "none";
            if (lines.get(i) == 1)
                count++;
        }
        if (count == 1) {
            return turn == 0 ? "ai" : "player";
        }
        return "none";
    }

    public boolean isLegalBoard(){
        int sum =0;
        for (Integer i:lines) {
            sum+=i;
        }
        return sum != 0;
    }

    public int getTurn() {
        return turn;
    }

    public ArrayList<Integer> getLines() {
        return lines;
    }


    public void print() {
        for (int i = 0; i < lines.size(); i++) {
            Integer m = lines.get(i);
            System.out.print(i + 1 + "  ");
            for (int j = 0; j < m; j++) {
                System.out.print("X");
            }
            System.out.println();
        }
    }

    public String getBoardGraphics(){
        StringBuilder output= new StringBuilder();
        for (int i = 0; i < lines.size(); i++) {
            Integer m = lines.get(i);
            output.append(i+1).append("  ");
            output.append("X".repeat(Math.max(0, m)));
            output.append("\n");
        }
        return output.toString();
    }
}