package 递归_arraylist;

/*
 * 递归，一维arraylist储存
 */
import java.util.ArrayList;
import java.util.LinkedList;

public class NQueen1 {

	private int EAGELENGTH ;
	public LinkedList<ArrayList<Integer>> resultList = new LinkedList<>();
	public int x[] ;
	public NQueen1() {}
	public NQueen1(int n) {
		EAGELENGTH = n;
		ArrayList<Integer> list = new ArrayList<>();
		calculateQueens(list);
	}
	
	public void calculateQueens(ArrayList<Integer> locationList) {//递归

		if (locationList.size() == EAGELENGTH) {//已经满足了一种情况
			ArrayList<Integer> locationListClone = new ArrayList<>();
			locationListClone.addAll(locationList);
			resultList.add(locationListClone);
			return;
		}
		//i是列，size是行，j也是行
		for (Integer i = 0; i < EAGELENGTH; i++) {
			if (!locationList.contains(i)) {//判断同一列
				boolean flag = true;
				for (int j = 0; j < locationList.size() && flag; j++) {
					//判断对角线
					if (Math.abs(i - locationList.get(j)) == Math.abs(locationList.size() - j))
						flag = false;
				}
				if (flag) {
					//该位置可以放皇后
					locationList.add(i);
					calculateQueens(locationList);
					locationList.remove(locationList.size() - 1);//回溯
				}
			}
		}
		return;

	}

}