package 递归_arraylist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class nqueen_algorithm {
	int n;
	private int EAGELENGTH ;
	public int x[] ;
	public LinkedList<ArrayList<Integer>> resultList1 = new LinkedList<>();
	public LinkedList<int []> resultList2 = new LinkedList<>();
	public nqueen_algorithm(int n){
		EAGELENGTH = n;
		this.n = n;
	}
	 void nqueen1(ArrayList<Integer> list) {		 
		// TODO Auto-generated method stub
		if (list.size() == n) {//已经找完n行
			//为什么这样要复制才可以，直接add到resultList1，里面的内容为空？？
			ArrayList<Integer> ListClone = new ArrayList<>();
			ListClone.addAll(list);
			resultList1.add(ListClone);
			return;
		}
		//递归求解
		for (Integer i = 0; i < n; i++) {
			if (!list.contains(i)) {//同一列没有重复
				boolean flag = true;
				for (int j = 0; j < list.size() && flag; j++) {
					//对角线重复了，flag=false
					if (Math.abs(i - list.get(j)) == Math.abs(list.size() - j))
						flag = false;
				}
				if (flag) {
					//满足摆放条件
					list.add(i);
					nqueen1(list);
					list.remove(list.size() - 1);//回溯
				}
			}
		}
		return;

	}
	 void show(int select)
	 {
		 if(select == 1){
			 System.out.println("共找到"+resultList1.size()+"个解\n"+"分别是：\n"+resultList1);	 
		 }
		 else if(select == 2){
			 System.out.println("共找到"+resultList2.size()+"个解\n"+"分别是：\n");
			 for(int i=0;i<resultList2.size();i++){
				 System.out.print('[');
				 for(int j=0;j<n;j++){
					 System.out.print(resultList2.get(i)[j+1]-1+",");
				 }
				 System.out.println(']');
			 }
		 }
		 
	 }
	
	 public boolean place(int k)  
		{  
		    int i;  
		    for (i = 1; i < k; i++)  
		    {  
		        if (x[i] == x[k] || Math.abs(i - k) == Math.abs(x[i] - x[k])) //��һ���ж��в�����ͬ���ڶ����ж϶Խ��߲�����ͬ  
		            return false;  
		    }  
		    return true;  
		}  
		public void nqueen2()
		{  
			x = new int[EAGELENGTH+1];
		    int i;
		    x[1]=0;  
		    int k=1; 
		    int xx[] = new int [EAGELENGTH+1];
		    while(k>0)  
		    {  
		        x[k]+=1;//  
		        while((x[k]<=EAGELENGTH) && !place(k))//  
		            x[k]+=1;// 
		  
		        if(x[k]<=EAGELENGTH)//  
		        {  
		            if(k==EAGELENGTH)// 
		            {  
		            	//int xx[] = new int [EAGELENGTH+1];
		            	for(int j=0;j<EAGELENGTH+1;j++)
		            		xx[j] = x[j];
		            	resultList2.add(xx);
		  
		            }  
		            else//���ǣ�������һ���ʺ�  
		            {  
		                k++;  
		                x[k]=0;  
		            }  
		        }  
		        else//����  
		        {  
		            k--;  
		        }  
		  
		    }  
		}  
	public void violence(){
		x = new int[n];
		int i= 0;
		for(i=0;i<n;i++){
			
		}
		
	}
	 public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入n皇后的规模n：");
		n = scanner.nextInt();
		// TODO Auto-generated method stub
		nqueen_algorithm nqueen = new nqueen_algorithm(n);
		ArrayList<Integer> locationList = new ArrayList<>();
		long begin,end;
		//递归回溯法
//		begin = System.currentTimeMillis();
//		nqueen.nqueen1(locationList);
//		end = System.currentTimeMillis();
//		System.out.println("递归法求"+n+"皇后问题已经全部求解完成！\n"+"耗时："+(end-begin)+"ms\n");
//		nqueen.show(1);
		
		//优化的非递归回溯法
		begin = System.currentTimeMillis();
		nqueen.nqueen2();
		end = System.currentTimeMillis();
		System.out.println("非递归法求"+n+"皇后问题已经全部求解完成！\n"+"耗时："+(end-begin)+"ms\n");
		nqueen.show(2);
	}

 

}
