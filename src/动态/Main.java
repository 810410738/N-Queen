package 动态;

import java.awt.Color;  
import java.awt.Font;  
import java.awt.GridLayout;  
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;



import java.awt.*;  
  
public class Main {  
    JFrame frame;  
    int n=15;            //问题规模  
    int waitTime=0;   //时间间隔  
    JLabel mp[][];  
    Thread thread;
    ImageIcon imageIcon ;
    public void create(){
    
    	frame = new JFrame(String.valueOf(n)+"皇后问题");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(50*n, 50*n);
    	frame.setLayout(new GridLayout(n,n));
    	frame.setResizable(false);
    	frame.setLocation(200, 0);
    	frame.setVisible(true);
    	 Font font=new Font("",Font.BOLD,32);  
    	mp = new JLabel[n][n];
    	for(int i=0;i<n;i++){
    		for(int j=0;j<n;j++){
    			mp[i][j] = new JLabel();
				mp[i][j].setOpaque(true);//透明
				if((i+j)%2==0){
					mp[i][j].setBackground(Color.black);
				}
				else{
					mp[i][j].setBackground(Color.white);
				}
				mp[i][j].setHorizontalAlignment(JLabel.CENTER);
				mp[i][j].setSize(50, 50);
				mp[i][j].setBorder((Border) new BevelBorder(BevelBorder.LOWERED));
				mp[i][j].setFont(font);  
				mp[i][j].setForeground(Color.blue);
				frame.add(mp[i][j]);
    		}
    	}
		thread = new Thread(new Runnable(){
			public void run(){
				 try {
					dfs(0);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
		}
		});
		thread.start();
          
     
    }  
      
    int vis[]=new int[n];  
    int ans=0;  
    public void dfs(int row) throws InterruptedException{
    	imageIcon= new ImageIcon("./image/queen.PNG");
        if(row==n){
        	
            ans++;  
            System.out.print("第"+ans+"种摆法为：");  
            //show
            for(int i=0;i<n;i++){  
                System.out.print(vis[i]+",");  
            }  
            System.out.println();  
        
            //thread.sleep(3*waitTime);
            JOptionPane.showMessageDialog(frame,"哈哈，找到第"+ans+"解啦！");
             
            return;  
        }  
        else{  
            for(int i=0;i<n;i++){  
                vis[row]=i;  
                if(i>0)  
                	 mp[row][i-1].setIcon(null);
                mp[row][i].setIcon(imageIcon);
           
               
               
                boolean state=check(row);  
                thread.sleep(waitTime*2);  
                for(int z=0;z<n;z++){  
                    for(int j=0;j<n;j++){  
                        if((z+j)%2==0){  
                            mp[z][j].setBackground(Color.black);  
                        }  
                        else{  
                            mp[z][j].setBackground(Color.white);  
                        }  
                    }  
                }  
                if(state){  
                    dfs(row+1); 
                   
                }  
                mp[row][i].setIcon(null);
            }  
        }  
    }  
      
    public boolean check(int row){  
        boolean flag1=true,flag2=true,flag3=true;  
        int row1=1,row2=1,row3=1;  
        for(int i=0;i<row;i++){  
            if(vis[i]==vis[row]){  
                flag1=false;  
                row1=i;  
            }  
            if( (i-row)==(vis[i]-vis[row])){      
                flag2=false;  
                row2=i;  
            }  
            if((i-row)==-(vis[i]-vis[row])){  
                flag3=false;  
                row3=i;  
            }  
        }  
        if(!flag1){  
            for(int i=row;i>=row1;i--)  
                mp[i][vis[row]].setBackground(Color.red);  
        }  
        if(!flag2){  
            for(int i=row,j=vis[row];i>=row2;i--,j--){     
                mp[i][j].setBackground(Color.red);  
            }  
        }  
        if(!flag3){  
            for(int i=row,j=vis[row];i>=row3;i--,j++){  
                mp[i][j].setBackground(Color.red);  
            }  
        }  
        if(!flag1 || !flag2 || !flag3)  
            return false;  
        return true;  
    }  
      
    public static void main(String args[]){  
        javax.swing.SwingUtilities.invokeLater(new Runnable(){  
            @Override  
            public void run() {  
                // TODO Auto-generated method stub  
                (new Main()).create();  
            }  
        });   
    }  
}  