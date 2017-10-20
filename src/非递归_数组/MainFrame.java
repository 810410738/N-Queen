package 非递归_数组;

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
	public LinkedList resultlist1;
	
	public MainFrame(){
		 win = new JFrame("�ǵݹ�_�ʺ�����");
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
		show();//��ʾ����
		new Thread(new Runnable(){
			public void run(){
				//��ʼ��ʱ
				long begin = System.currentTimeMillis();
				NQueen queen = new NQueen(n);
				//��ʱ����
				long end = System.currentTimeMillis();
				
				resultlist1 = queen.resultList;
				int list[] = (int [])resultlist1.getFirst();
				n = list.length-1;
				num= resultlist1.size();
				JOptionPane.showMessageDialog(win,n+"�ʺ�����н��Ѿ�������ϣ�һ���и�"+num+"��\n��ʱ"+(end-begin)+"ms");
				String s1 = JOptionPane.showInputDialog(win,"��������鿴�ڼ�����");
				int x = 0;
				try {
				      x = Integer.parseInt(s1);
				} catch (NumberFormatException e) {
				    e.printStackTrace();
				}
				showNumber(x);
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
	public void showNumber(int x){//��ʾ����
		int list [] = (int [])resultlist1.get(x-1);
		imageIcon = new ImageIcon("./image/queen.PNG");
		for(int i=0;i<n;i++)
		{
			lab[i][list[i+1]-1] .setIcon(imageIcon);
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
