package 递归_arraylist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class nqueen_algorithm {
	int n;
	public LinkedList<ArrayList<Integer>> resultList = new LinkedList<>();
	public nqueen_algorithm(int n){
		this.n = n;
	}
	 void nqueen(ArrayList<Integer> list) {		 
		// TODO Auto-generated method stub
		if (list.size() == n) {//已经找完n行
			//为什么这样要复制才可以，直接add到resultlist，里面的内容为空？？
			ArrayList<Integer> ListClone = new ArrayList<>();
			ListClone.addAll(list);
			resultList.add(ListClone);
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
					nqueen(list);
					list.remove(list.size() - 1);//回溯
				}
			}
		}
		return;

	}
	 void show()
	 {
		 System.out.println("共找到"+resultList.size()+"个解\n"+"分别是：\n"+resultList);
	 }
	 public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入n皇后的规模n：");
		n = scanner.nextInt();
		// TODO Auto-generated method stub
		nqueen_algorithm nqueen = new nqueen_algorithm(n);
		ArrayList<Integer> locationList = new ArrayList<>();
		long begin = System.currentTimeMillis();
		nqueen.nqueen(locationList);
		long end = System.currentTimeMillis();
		System.out.println(n+"皇后问题已经全部求解完成！\n"+"耗时："+(end-begin)+"ms\n");
//		nqueen.show();
	}

 

}
