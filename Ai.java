//import java.util.*;
//import java.util.ArrayList;
//public class Ai {
//	GameManager gm;
//	
//	public Ai(GameManager gm) {
//		this.gm = gm;
//	}
//	
//	public void playTurn() throws Exception {
//		int lineToPlay = 0;
//		int amountToTake = 0;
//		if(!gm.HasStarted()) {
//			Random rnd = new Random();
//			lineToPlay = 0;
//			amountToTake = 0;
//			gm.playTurn(lineToPlay, amountToTake);
//		}
//		else {
//			lineToPlay = getTheOnlyOneLineLeft();
//			if(lineToPlay != -1) {//	הא יש שורה אחת שאפשר להוציא ממנה
//				amountToTake =  getAmoutToRemove(lineToPlay);
//				gm.playTurn(lineToPlay, amountToTake);
//			}else {
//				makeAMove();
//			}
//		//}
//	}
//	
//	public void makeAMove() throws Exception {
//		ArrayList<Integer> goodLinesForTwo = new ArrayList(); 
//		ArrayList<Integer> goodLinesForOne = new ArrayList(); 
//		Integer[] amountLeft = new Integer[gm.getAmountOfLines()];
//		for (int i = 0;i<gm.getAmountOfLines(); i ++) {
//			int num = 0;
//			for ( int j = 0; j<gm.getAmountOfMaklotInLine(i);j++) {
//				if(gm.getLines()[i].getMaklot()[j]) {
//					num++;
//				}	
//			}
//			amountLeft[i] = num;
//			if (num > 2) {
//				goodLinesForTwo.add(i);
//			}else if (num == 1) {
//				goodLinesForOne.add(i);
//			}
//		} 
//		if(goodLinesForTwo.isEmpty() || goodLinesForOne.isEmpty()) {
//		Random rnd = new Random();
//		int line = -1;
//		int amountToTake = -1;
//		int whatToDo = rnd.nextInt(2);
//		if(whatToDo == 0 && !goodLinesForOne.isEmpty()) {
//			int index = rnd.nextInt(goodLinesForOne.size());
//			line = goodLinesForOne.get(index);
//			amountToTake = 1;
//		}
//		else if(!goodLinesForTwo.isEmpty()){
//	     	int index = rnd.nextInt(goodLinesForTwo.size());
//			line = goodLinesForTwo.get(index);
//		    amountToTake = amountLeft[line]-2;
//		}
//		else {
//			
//		}
//		gm.playTurn(line, amountToTake);
//
//		}
//	}
//	
//	public void removeRandom() {
//		
//	}
//	
//	
//	public int getAmountOfTwo () {
//		int count = 0;
//		for (int i = 0;i<gm.getAmountOfLines(); i ++) {
//			int num = 0;
//			for ( int j = 0; j<gm.getAmountOfMaklotInLine(i);j++) {
//				if(gm.getLines()[i].getMaklot()[j]) {
//					num++;
//				}	
//			}
//			if (num == 2) {
//				count++;
//			}
//		}
//		return count;
//			
//	}
//	
//	public int getTheOnlyOneLineLeft() {
//
//		int count = 0;
//		int index = -1;
//		for(int i = 0;i<gm.getAmountOfLines();i++) {
//			if(gm.getLines()[i].isAllOut()) {
//				count ++;
//				index = i;
//			}
//	
//		}
//		if(count > 1) {
//			return -1;
//		}
//		return index;
//	}
//	
//	public int getAmoutToRemove(int line) {
//		int count = -1;
//		for(int i = 0; i<gm.getAmountOfMaklotInLine(line);i++) {
//			if(gm.getLines()[line].getMaklot()[i]) {
//				count++;
//			}
//		}
//		return count;
//	}
//}


import java.time.temporal.IsoFields;
import java.util.ArrayList;

public class Ai {


    public Ai() {
    }

    //  ArrayList<ArrayList<String>> boards = new ArrayList<>();

    public Move playTurn(GameManager gameManager) {
        Move move = new Move(1, 1);
        int bestScore = Integer.MIN_VALUE;
        //  int count = 1;
        for (int i = 0; i < gameManager.getLines().size(); i++) {
            for (int j = 1; j < gameManager.getLines().get(i) + 1; j++) {
                GameManager boardToTry = new GameManager(gameManager);
//                System.out.println("++++++++++++++++++++++++++++++++++" + count);
//                System.out.println("INITIAL");
//                boardToTry.print();
//                count++;
//                System.out.println();
//                System.out.println("TRY");
                boardToTry.playTurn(i, j);
//                boardToTry.print();
//                System.out.println();
                int score = minimax(boardToTry, 0, false, Integer.MIN_VALUE, Integer.MAX_VALUE);

                //     printTree();

                // boards = new ArrayList<>();

                System.out.println("check -> " + i + "," + j + " Score:" + score);
                boardToTry.addNumToLine(i, j);
                if (bestScore < score) {
                    bestScore = score;
                    System.out.println("Better -------> " + i + "," + j + " Score:" + score);
                    move.row = i;
                    move.amount = j;
                }
            }
        }
        return move;
    }

    private int minimax(GameManager gameManager, int depth, boolean isMaximizing, int alpha, int beta) {
        if (!gameManager.getWinner().equals("none")) {
//            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=");
//            System.out.println(gameManager.getBoardGraphics());
//            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=");
            if (depth == 0)
                depth++;
            if (isMaximizing)
                return -1000 / depth;
            else
                return 1000 / depth;
        }
        if (!gameManager.isLegalBoard()){
            return -1000;
        }
            int bestScore;
        if (isMaximizing) {
            bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < gameManager.getLines().size(); i++) {
                for (int j = 1; j < gameManager.getLines().get(i) + 1; j++) {
                    gameManager.playTurn(i, j);

//                    if (boards.size() == (depth)) {
//                        boards.add(depth, new ArrayList<>());
//                    }
//                    boards.get(depth).add(gameManager.getBoardGraphics());

                    int score = minimax(gameManager, depth + 1, false, alpha, beta);
                    bestScore = Math.max(bestScore, score);

                    gameManager.addNumToLine(i, j);
                    alpha = Math.max(alpha, score);
                    if (beta <= alpha)
                        break;
                }
            }
        } else {
            bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < gameManager.getLines().size(); i++) {
                for (int j = 1; j < gameManager.getLines().get(i) + 1; j++) {
                    gameManager.playTurn(i, j);
//
//                    if (boards.size() == (depth)) {
//                        boards.add(depth, new ArrayList<>());
//                    }
//                    boards.get(depth).add(gameManager.getBoardGraphics());

                    int score = minimax(gameManager, depth + 1, true, alpha, beta);
                    bestScore = Math.min(bestScore, score);

                    gameManager.addNumToLine(i, j);
                    beta = Math.min(beta, score);
                    if (beta <= alpha)
                        break;
                }
            }
        }
        return bestScore;
    }


//    private void printTree() {
//        int count = 1;
//        for (ArrayList<String> arr : boards) {
//            System.out.println(count + ":=======:" + (count % 2 == 0 ? "ai" : "enemy"));
//            count++;
//            for (String str : arr) {
//                System.out.println(str);
//            }
//        }
//    }
}