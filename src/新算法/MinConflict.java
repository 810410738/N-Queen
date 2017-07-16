package ���㷨;

public class MinConflict
{

	public MinConflict(int numOfQueens){
		m_QueenNum = numOfQueens;
		m_chessBoard = new int[m_QueenNum] ;
		
		
		m_columnConflict = new int[m_QueenNum] ;
		
		
		m_mainDiaConflict = new int[m_QueenNum * 2 - 1] ;
		
		
		m_counterDiaConflict = new int[m_QueenNum * 2 - 1] ;
		
		for (int row = 0; row < m_QueenNum; ++row)
		{
			int column = (int)(Math.random()*m_QueenNum); // �������һ����Ⱥ
			m_chessBoard[row]=column;
			PutQueen(row, column);
		}
	}
	public boolean  CheckSatus(){// ����Ƿ�ﵽ���Ž�
		// ÿһ��ֻ����һ����ÿһ���Խ��߷��򲻿��������������򲻿��������Ž�
		for (int column = 0; column < m_columnConflict.length; ++column)
		{
			if (m_columnConflict[column] != 1)
				return false;
		}
		for (int i = 0; i < m_mainDiaConflict.length; ++i)
		{
			if (m_mainDiaConflict[i] >= 2 || m_counterDiaConflict[i] >= 2)
				return false;
		}
		return true;
	}
	public int   CalcuConflicts(int row, int column){
		return (m_columnConflict[column]
				+ m_mainDiaConflict[m_QueenNum - 1 - row + column]
				+ m_counterDiaConflict[2 * m_QueenNum - 2 - row - column]);
	}
	public void  MinConflictAlgorithm(){
		
		
		boolean m_isOptimal = CheckSatus();
		int counter = 0;
		while (!m_isOptimal)
		{
			counter++;
			for (int row = 0; row < m_QueenNum; ++row)
			{
				int minConflict = 100000000;
				int tmpConflict = 100000000;
				int minColumn = 0;

				int curColumn = m_chessBoard[row];
				RemoveQueen(row, curColumn);

				for (int column = 0; column < m_QueenNum; ++column)
				{
					tmpConflict = CalcuConflicts(row, column);
					if (tmpConflict < minConflict)
					{
						minConflict = tmpConflict;  // �ҵ���С��ͻ
						minColumn = column;         // ������С��ͻʱ�������
					}
					else if (tmpConflict == minConflict && (int)(Math.random()*2)==1)
					{// �����С��ͻֵ��ȵĻ�����һ��Ŀ����ƶ�����ֹ����ֲ���ѣ�������ȫ�����
						minColumn = column;
					}
				}
				m_chessBoard[row]= minColumn ;
				
				PutQueen(row, minColumn);

				m_isOptimal = CheckSatus();
				if (m_isOptimal)
					break;

				if (counter > 200)
				{
					m_isOptimal = true;
					break;
				}
			}
		}
		//Print();
		System.out.println( " CSP����С��ͻ���ɹ��ҵ�" + m_QueenNum +"�ʺ�Ľ�! ������" + counter +"��" );
	}
	public void  PutQueen(int row, int column){
		//m_chessBoard[row] = column;  // ���Կ��ӻ�
		
		m_columnConflict[column]++ ;
		m_mainDiaConflict[m_QueenNum - 1 - row + column]++;
		m_counterDiaConflict[2 * m_QueenNum - 2 - row - column]++;
	}
	public void  RemoveQueen(int row, int column){
		//m_chessBoard[row] = m_QueenNum;  // ���Կ��ӻ�
		
		m_columnConflict[column]--;

		
		m_mainDiaConflict[m_QueenNum - 1 - row + column]--;
		
		m_counterDiaConflict[2 * m_QueenNum - 2 - row - column]-- ;
	}
	public int[]  Print(){// ��ӡ���Ž�
		//System.out.println("print");
		int a[] = new int[m_QueenNum];
		int k =0;
		for (int i = 0; i < m_QueenNum; ++i)
		{
			//System.out.println("   "+i+1+" ");
			
			for (int j = 0; j < m_QueenNum; ++j)
			{
				if (j == m_chessBoard[i]){
					System.out.print("Q ");
					a[k++] = j;
				}
				else{
					System.out.print(". ");
				}
					 
			}
			System.out.println("");
		}
		//System.out.println("");
//		for(k = 0 ;k<m_QueenNum;k++)
//		{
//			System.out.println(a[k]);
//		}
		return a;
	}
	public void  PrintConflict(){
		System.out.println("printConflict");
		System.out.print("    ");

		for (int i = 0; i < m_columnConflict.length; ++i)
			System.out.print(m_columnConflict[i]+" ");

		System.out.println("");

		System.out.print("    ");
		for (int i = 0; i < m_mainDiaConflict.length; ++i)
			System.out.print(m_mainDiaConflict[i]+" ");

		System.out.println("");

		System.out.print("    ");
		for (int i = 0; i < m_counterDiaConflict.length; ++i)

			System.out.print( m_counterDiaConflict[i]+" ");

			System.out.println("");
	}


	private int[] m_chessBoard;
	private int m_QueenNum;
	private int[] m_columnConflict;
	private int[] m_mainDiaConflict;       // ���Խ��߷����ӳ����� (i, j) --> m_QueenNum-1-i + j
	private int[] m_counterDiaConflict;    // ���Խ��߷����ӳ����� (i, j) --> m_QueenNum-1-i + m_QueenNum-1-j
};