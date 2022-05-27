package com.foxmo.java;

public class MyMatrix {
    int[][]  myMax, targetMax;

    int m,n;

    public MyMatrix(int m,int n ) {
        myMax = new int[m][n] ;
        for (int i=0; i<m; i++) {
            for ( int j= 0 ; j < n ; j++ ) {
                // 随机产生0~100 整数
                myMax[i][j] = (int)(Math.random() * 100+0.5) ;
            }
        }
        this.m = m ;
        this.n = n ;
    }

    public void addMatrix(MyMatrix mt) {
        for (int i=0;i < m; i++) {
            for ( int j= 0 ; j < n ; j++ ) {
                // 此处应实现数组元素相加
                this.myMax[i][j] = this.myMax[i][j] + mt.myMax[i][j];
            }
        }
    }
    public void printMatrix() {
        for (int i=0; i<m; i++) {
            for ( int j= 0 ; j <n ; j++ ) {
                // 随机产生0~100 整数
                System.out.print(myMax[i][j] + " | ") ;
            }
            System.out.println() ;
        }
    }


    public static void main(String[] args) {
        MyMatrix m1 = new MyMatrix(3,4) ;
        MyMatrix m2 = new MyMatrix(3, 4);
        System.out.println("矩阵1") ;
        m1.printMatrix() ;
        System.out.println("矩阵2") ;
        m2.printMatrix();
        System.out.println("after added") ;

		//【填写矩阵对象m1与矩阵m2相加的代码】;// 注释：结果保存在m1中
        m1.addMatrix(m2);
        m1.printMatrix() ;
    }
}
