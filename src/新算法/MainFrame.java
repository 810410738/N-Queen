package ���㷨;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Scanner in = new Scanner(System.in);
	private int num;//��ĸ���
	private int n;//n�ʺ��n
	private JFrame win;
	private JLabel lab[][];
	public  ImageIcon imageIcon;
	public MainFrame(){
		 win = new JFrame("���㷨����");
		   lab =null;
		   win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   win.setSize(500, 500);
		    win.setResizable(false);
		    win.setLocation(200, 0);
		    win.setVisible(true);
		String s = JOptionPane.showInputDialog(win,"������n�ʺ������n��");
		try {
		     n = Integer.parseInt(s);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		//show();//��ʾ����
		new Thread(new Runnable(){
			public void run(){
				long begin = System.currentTimeMillis();
				MinConflict QueenConflict = new MinConflict(n);
				QueenConflict.MinConflictAlgorithm();
				//��ʱ����
				long end = System.currentTimeMillis();
				JOptionPane.showMessageDialog(win,n+"�ʺ�����н��Ѿ��������\n��ʱ"+(end-begin)+"ms");
				int list[] = QueenConflict.Print();
				//showNumber(list);
		}
		}).start();
		
	}
	public void show(){//��ʾ����

		win.setLayout(new GridLayout(n,n));
		win.setSize(n*50, n*50);
		lab = new JLabel[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				lab[i][j] = new JLabel();
				lab[i][j].setOpaque(true);//͸��
				if((i+j)%2==0){
					lab[i][j].setBackground(Color.black);
				}
				else{
					lab[i][j].setBackground(Color.white);
				}
				lab[i][j].setHorizontalAlignment(JLabel.CENTER);
				lab[i][j].setSize(50, 50);
				lab[i][j].setBorder((Border) new BevelBorder(BevelBorder.LOWERED));
				win.add(lab[i][j]);
			}
		}
	}
	public void showNumber(int list[]){//��ʾ����

		imageIcon = new ImageIcon("./image/queen.PNG");
		for(int i=0;i<n;i++)
		{
			lab[i][list[i]] .setIcon(imageIcon);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new MainFrame();
			}
		});
		
		
		
	

}


}
