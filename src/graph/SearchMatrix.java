package graph;

public class SearchMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        if (matrix==null || matrix.length==0) return false;
//        if (n==1) return binarySearch(matrix, 0, target, true);
//        if (m==1) return binarySearch(matrix, 0, target, false);
        
        int k=(n<=m)? n:m;
        System.out.println("k: "+k);
        for (int i=0;i<k;i++) {
        	System.out.println("i: "+i);
        	boolean v=binarySearch(matrix, i, target, true);
        	boolean h=binarySearch(matrix, i, target, false);
        	if (v||h) return true;
        }
        return false;
    }
    
	public boolean binarySearch(int[][] matrix, int start, int target, boolean vertical) {
		int low=start;
		int high= vertical? matrix.length-1:matrix[0].length-1;
		while (low<=high) {
			int mid=(low+high)/2;
			if(vertical) {
				if(matrix[mid][start]==target) return true;
				else if (matrix[mid][start]>target) {
					high=mid-1;
				}else {
					low=mid+1;
				}
			}else {
				if(matrix[start][mid]==target) return true;
				else if (matrix[start][mid]>target) {
					high=mid-1;
				}else {
					low=mid+1;
				}
			}
		}
		
		return false;
	}
	
	//-------------------Divide and Conquer
	public boolean searchRec(int left, int right, int up, int down, int[][] matrix, int target) {
		if(left>right || up>down) return false;
		else if (target<matrix[up][left]||target>matrix[down][right]) return false;
		int mid=(left+right)/2;
		int row=up;
		while (row<=down && matrix[row][mid]<=target) {
			if(matrix[row][mid]==target) return true;
			row++;
		}
		return searchRec(left, mid-1, row, down, matrix,target)||searchRec(mid+1, right, up, row-1, matrix,target);
	}
	
	public boolean searchMatrix1(int[][] matrix, int target) {
		if(matrix.length==0 || matrix==null) return false;
		return searchRec(0,matrix[0].length-1,0,matrix.length-1,matrix,target);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] matrix= {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
//		int target=5;
		
//		int[][] matrix= {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
//		int target=20;
		
//		int[][] matrix= {{-5}};
//		int target=-5;
		
		int[][] matrix= {{1,1}};
		int target=2;
		SearchMatrix test=new SearchMatrix();
		System.out.println(test.searchMatrix1(matrix, target));
	}

}
