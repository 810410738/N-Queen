package 递归_arraylist;

import java.util.Scanner;

public class TestData {
	int n;
	TestData(int n){
		this.n = n;
	}
	public boolean judge(int x[]){
		int i,j;
		int count = 0;
		for(i=0;i<n;i++){
			count = 0;
			//判断列重复
			for(j=i+1;j<n;j++){
				count ++;
				if(x[i] == x[j]){
					return false;
				}
				if(x[i]+count == x[j]||x[i]-count == x[j]){
					return false;
				}
			}
		}
		return true;
	}
	public void show(int x[]){
		System.out.print('[');
		for(int i=0;i<n;i++){
			System.out.print(x[i]+",");
		}
		System.out.println(']');
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = 8;
		TestData test = new TestData(n);
		System.out.println("请输入"+n+"皇后的测试数据：\n");
		int x[] = new int[8];
		int temp;
		for(int i =0;i<n;i++){
			System.out.println("请输入第"+(i+1)+"个点对：");
			temp = scanner.nextInt();
			x[i] = scanner.nextInt();
		}
		if(test.judge(x)){
			System.out.println("该解满足要求！");
			test.show(x);
		}
		else{
			System.out.println("该解不满足要求！");
		}
	}

}
