package binary_Search;
/*
* 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

示例:

输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]

* */
public class T59 {
    //实现
    public static void main(String[] args) {
T59 ache=new T59();
int n=5;
int [][] result= ache.generateMatrix(5);
        for (int i = 0; i < n; i++) { // 遍历行
            for (int j = 0; j < n; j++) { // 遍历列
                System.out.print(result[i][j] + "\t"); // 输出每个元素，并用制表符对齐
            }
            System.out.println(); // 每行结束后换行
        }
    }


    // 算法  元素按顺时针顺序螺旋排列
    public int[][] generateMatrix(int n) {
        int matrix[][] = new int[n][n];
        int num = 1;
        int top = 0, di = n - 1;
        int le = 0, ri = n - 1;
        while (top <= di && le <= ri) {
            for (int j = le; j <= ri; j++) {
                matrix[top][j] = num++;
            }
            top++;
            for (int i = top; i <= di; i++) {
                matrix[i][ri] = num++;
            }
            ri--;
            if (top <= di) {
                for(int j=ri;j>=le;j--){
                    matrix[di][j]=num++;
                }
                di--;
            }
            if(ri>=le){
                for(int i=di;i>=top;i--)
                {
                    matrix[i][le]=num++;
                }
                le++;
            }
        }
        return matrix;
    }
}
