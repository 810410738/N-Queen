package �ݹ�_arraylist;

/*
 * �ݹ飬һάarraylist����
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
	
	public void calculateQueens(ArrayList<Integer> locationList) {//�ݹ�

		if (locationList.size() == EAGELENGTH) {//�Ѿ�������һ�����
			ArrayList<Integer> locationListClone = new ArrayList<>();
			locationListClone.addAll(locationList);
			resultList.add(locationListClone);
			return;
		}
		//i���У�size���У�jҲ����
		for (Integer i = 0; i < EAGELENGTH; i++) {
			if (!locationList.contains(i)) {//�ж�ͬһ��
				boolean flag = true;
				for (int j = 0; j < locationList.size() && flag; j++) {
					//�ж϶Խ���
					if (Math.abs(i - locationList.get(j)) == Math.abs(locationList.size() - j))
						flag = false;
				}
				if (flag) {
					//��λ�ÿ��ԷŻʺ�
					locationList.add(i);
					calculateQueens(locationList);
					locationList.remove(locationList.size() - 1);//����
				}
			}
		}
		return;

	}

}