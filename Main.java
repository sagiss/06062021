
// not ready yet 13.3.21



import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GameManager gm = new GameManager(4);
        gm.print();
        Ai ai = new Ai();

        Scanner sc = new Scanner(System.in);

        while (gm.getWinner().equals("none")) {
            if (gm.getTurn() == 0) {
                System.out.println("AI");
                Move move = ai.playTurn(gm);
                gm.playTurn(move.row,move.amount);
            } else {
                System.out.println("player " + (gm.getTurn() + 1) + " its your turn");
                System.out.println("choose row");
                int row = Integer.parseInt(sc.nextLine());
                row--;
                System.out.println("choose amount");
                int amount = Integer.parseInt(sc.nextLine());
                if (!gm.playTurn(row, amount)){
                    System.out.println("AGAIN");
                }
            }
            gm.print();
            System.out.println("\n");

        }
        System.out.println("Winner " + gm.getWinner());
    }
}
//public class Main {
//
//	public static void main(String[] args) throws Exception {
//		
//		
//		GameManager gm = new GameManager(4);
//		gm.print();
//		Ai ai = new Ai(gm);
//		Scanner sc = new Scanner(System.in);
//
//		while(!gm.isGameOver()) {
//			if(gm.getTurn() == 0) {
//				ai.playTurn();
//				System.out.println("AI");
//			
//			}else {
//			System.out.println("player " + (gm.getTurn() +1) + " its your turn");
//			System.out.println("choose row");
//			int row  = Integer.parseInt(sc.nextLine());
//			row--;
//			System.out.println("choose amount");
//			int amount  = Integer.parseInt(sc.nextLine());
//			gm.playTurn(row, amount);
//			System.out.println("Player");
//
//			}
//			gm.print();
//		}
//		
//		
//		//frame1 starts
//			JFrame theframe = new JFrame("start frame");
//			theframe.setLayout(new GridLayout(2,2));
//			theframe.setPreferredSize(new Dimension(1000,1000));
//			JButton nextframe = new JButton("start game!");
//			nextframe.setBackground(Color.green);
//			JButton nextframe2 = new JButton("help");
//			nextframe2.setBackground(Color.blue);
//			
//			theframe.add(nextframe);
//			theframe.add(nextframe2);
//			theframe.setVisible(true);
//			theframe.pack();
//			//frame1 ends 
//			JFrame thegame = new JFrame("sticks and lines");
//			thegame.setLayout(new GridLayout(5,7));
//			thegame.setPreferredSize(new Dimension(1000,1000));
//			
//			//frame2 starts
//			JFrame theframe2 = new JFrame("game play");
//			theframe2.setLayout(new GridLayout(4,7));
//			theframe2.setPreferredSize(new Dimension(1000,1000));
//			JLabel none = new JLabel("  ");
//			JLabel none1 = new JLabel("  ");
//			JLabel none2 = new JLabel("  ");
//			JLabel none3 = new JLabel("  ");
//			JLabel none4 = new JLabel("  ");
//			JLabel none5 = new JLabel("  ");
//			JLabel none6 = new JLabel("  ");
//			JLabel none7 = new JLabel("  ");
//			JLabel none8 = new JLabel("  ");
//			JLabel none9 = new JLabel("  ");
//			JLabel none10 = new JLabel("  ");
//			JLabel none11 = new JLabel("  ");
//			JLabel none12 = new JLabel("  ");
//			JLabel none13 = new JLabel("  ");
//			JLabel stick1 = new JLabel("  |");
//			JLabel stick2 = new JLabel("  |");
//			JLabel stick3 = new JLabel("  |");
//			JLabel stick4 = new JLabel("  |");
//			JLabel stick5 = new JLabel("  |");
//			JLabel stick6 = new JLabel("  |");
//			JLabel stick7 = new JLabel("  |");
//			JLabel stick8 = new JLabel("  |");
//			JLabel stick9 = new JLabel("  |");
//			JLabel stick10 = new JLabel("  |");
//			JLabel stick11 = new JLabel("  |");
//			JLabel stick12 = new JLabel("  |");
//			JLabel stick13 = new JLabel("  |");
//			JLabel stick14 = new JLabel("  |");
//			JLabel stick15 = new JLabel("  |");
//			JLabel stick16 = new JLabel("  |");
//			JLabel line = new JLabel("enter line numer");
//			line.setForeground(Color.RED);
//			JLabel sticks = new JLabel("enter sticks numer");
//			sticks.setForeground(Color.RED);
//			JTextField lineT = new JTextField();
//			JTextField sticksT = new JTextField();
//			JButton clear2 = new JButton("clear");
//			clear2.setBackground(Color.RED);
//			JButton back = new JButton("back");
//			back.setBackground(Color.RED);
//			stick1.setBackground(Color.RED);
//			stick2.setBackground(Color.RED);
//			stick3.setBackground(Color.RED);
//			stick4.setBackground(Color.RED);
//			stick5.setBackground(Color.RED);
//			stick6.setBackground(Color.RED);
//			stick7.setBackground(Color.RED);
//			stick8.setBackground(Color.RED);
//			stick9.setBackground(Color.RED);
//			stick10.setBackground(Color.RED);
//			stick11.setBackground(Color.RED);
//			stick12.setBackground(Color.RED);
//			stick13.setBackground(Color.RED);
//			stick14.setBackground(Color.RED);
//			stick15.setBackground(Color.RED);
//			stick16.setBackground(Color.RED);
//			
//			theframe2.add(none);
//			theframe2.add(none8);
//			theframe2.add(none9);
//			theframe2.add(stick1);
//			theframe2.add(none11);
//			theframe2.add(none12);
//			theframe2.add(none1);
//			theframe2.add(none2);
//			theframe2.add(none3);
//			theframe2.add(stick2);
//			theframe2.add(stick3);
//			theframe2.add(stick4);
//			theframe2.add(none4);
//			theframe2.add(none5);
//			theframe2.add(none6);
//			theframe2.add(stick5);
//			theframe2.add(stick6);
//			theframe2.add(stick7);
//			theframe2.add(stick8);
//			theframe2.add(stick9);
//			theframe2.add(none7);
//			theframe2.add(stick10);
//			theframe2.add(stick11);
//			theframe2.add(stick12);
//			theframe2.add(stick13);
//			theframe2.add(stick14);
//			theframe2.add(stick15);
//			theframe2.add(stick16);
//			theframe2.add(line);
//			theframe2.add(lineT);
//			theframe2.add(clear2);
//			theframe2.add(none13);
//			theframe2.add(back);
//			theframe2.add(sticks);
//			theframe2.add(sticksT);
//
//			
//			
//			
//			theframe2.setVisible(false);
//			theframe2.pack();
//			//frame2 ends
//			
//			JFrame helpframe = new JFrame("help");
//			helpframe.setLayout(new GridLayout(5,2));
//			helpframe.setPreferredSize(new Dimension(1000,1000));
//			JButton back2 = new JButton("back");
//			back2.setBackground(Color.RED);
//			JLabel helpl = new JLabel("in the game thers a unchangeable number of lines and sticks in each line.");
//			JLabel help2 = new JLabel(" each player can remove any number of lines from every line he choose only in term he remove sticks from juts line. ");
//			JLabel help3 = new JLabel("the goal for each player is to get to the point where he put the other player with only one line and in that line only one stick.");
//			helpframe.add(helpl);
//			helpframe.add(help2);
//			helpframe.add(help3);
//			helpframe.add(back2);
//			helpframe.setVisible(false);
//			helpframe.pack();
//
//			//the actions starts
//			nextframe.addActionListener((new ActionListener() {
//				public void actionPerfromed(ActionEvent e){
//					theframe.setVisible(false);
//					theframe2.setVisible(true);
//				}
//
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					theframe.setVisible(false);
//					theframe2.setVisible(true);
//
//				}
//			}));
//			back.addActionListener((new ActionListener() {
//				public void actionPerfromed(ActionEvent e){
//					theframe.setVisible(true);
//					theframe2.setVisible(false);
//				}
//
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					theframe.setVisible(true);
//					theframe2.setVisible(false);
//
//				}
//			}));
//			clear2.addActionListener((new ActionListener() {
//				public void actionPerfromed(ActionEvent e){
//					lineT.setText(null);
//					sticksT.setText(null);
//
//				}
//
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					lineT.setText(null);
//					sticksT.setText(null);
//
//				}
//			}));
//			/*clear2.addActionListener((new ActionListener() {
//				public void actionPerfromed(ActionEvent e){
//					nameT.setText(null);
//					lastnameT.setText(null);
//					ageT.setText(null);
//					artistT.setText(null);
//				}
//
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					nameT.setText(null);
//					lastnameT.setText(null);
//					ageT.setText(null);
//					artistT.setText(null);
//				}
//			}));*/
//			nextframe2.addActionListener((new ActionListener() {
//				public void actionPerfromed1(ActionEvent e){
//					theframe.setVisible(false);
//					theframe2.setVisible(false);
//					helpframe.setVisible(true);
//				}
//
//				public void actionPerfromed(ActionEvent e){
//				theframe.setVisible(false);
//				theframe2.setVisible(false);
//				helpframe.setVisible(true);
//			}
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				theframe.setVisible(false);
//				theframe2.setVisible(false);
//				helpframe.setVisible(true);
//
//			}
//		}));
//		back.addActionListener((new ActionListener() {
//			public void actionPerfromed(ActionEvent e){
//				theframe.setVisible(true);
//				theframe2.setVisible(false);
//				helpframe.setVisible(false);
//			}
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				theframe.setVisible(true);
//				theframe2.setVisible(false);
//				helpframe.setVisible(false);
//
//			}
//		}));
//		back2.addActionListener((new ActionListener() {
//			public void actionPerfromed(ActionEvent e){
//				theframe.setVisible(true);
//				theframe2.setVisible(false);
//				helpframe.setVisible(false);
//
//			}
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				theframe.setVisible(true);
//				theframe2.setVisible(false);
//				helpframe.setVisible(false);
//
//			}
//		}));
//
//	}
//
//}