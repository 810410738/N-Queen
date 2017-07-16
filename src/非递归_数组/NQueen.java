package 非递归_数组;

/*
 * 非递归，一维数组储存
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
	        if (x[i] == x[k] || Math.abs(i - k) == Math.abs(x[i] - x[k])) //第一个判断行不能相同，第二个判断对角线不能相同  
	            return false;  
	    }  
	    return true;  
	}  
	public void backtrack2()//迭代回溯  
	{  
		x = new int[EAGELENGTH+1];
	    int i;
	    x[1]=0;  
	    int k=1;  
	    while(k>0)  
	    {  
	        x[k]+=1;//当前列加1的位置开始搜索  
	        while((x[k]<=EAGELENGTH) && !place(k))//当前列位置是否满足条件  
	            x[k]+=1;//不满足条件，继续搜索下一个位置  
	  
	        if(x[k]<=EAGELENGTH)//存在满足条件的列  
	        {  
	            if(k==EAGELENGTH)//是最后一个皇后，完成搜索  
	            {  
	            	int xx[] = new int [EAGELENGTH+1];
	            	for(int j=0;j<EAGELENGTH+1;j++)
	            		xx[j] = x[j];
	            	resultList.add(xx);
	  
	            }  
	            else//不是，则处理下一个皇后  
	            {  
	                k++;  
	                x[k]=0;  
	            }  
	        }  
	        else//回溯  
	        {  
	            k--;  
	        }  
	  
	    }  
	}  
	

}
