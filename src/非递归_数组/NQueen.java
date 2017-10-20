package 非递归_数组;

/*
 * �ǵݹ飬һά���鴢��
 */
import java.util.ArrayList;
import java.util.LinkedList;

public class NQueen {

	private int EAGELENGTH ;
	public LinkedList<int[]> resultList = new LinkedList<>();
	public int x[] ;
	public NQueen() {}
	public NQueen(int n) {
		EAGELENGTH = n;
		backtrack2();
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
	public void backtrack2()
	{  
		x = new int[EAGELENGTH+1];
	    int i;
	    x[1]=0;  
	    int k=1;  
	    while(k>0)  
	    {  
	        x[k]+=1;//��ǰ�м�1��λ�ÿ�ʼ����  
	        while((x[k]<=EAGELENGTH) && !place(k))//��ǰ��λ���Ƿ���������  
	            x[k]+=1;//����������������������һ��λ��  
	  
	        if(x[k]<=EAGELENGTH)//����������������  
	        {  
	            if(k==EAGELENGTH)//�����һ���ʺ��������  
	            {  
	            	int xx[] = new int [EAGELENGTH+1];
	            	for(int j=0;j<EAGELENGTH+1;j++)
	            		xx[j] = x[j];
	            	resultList.add(xx);
	  
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
	

}
