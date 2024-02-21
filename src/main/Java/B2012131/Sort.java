/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B2012131;

import java.util.Scanner;


public class Sort{

    static void SelectionSort(int A[]){
        int i,j;
        int lowkey,lowindex;
        for(i=0;i< A.length;i++){
            lowkey=A[i];
            lowindex=i;
            for(j=i+1;j<A.length;j++){
                if(lowkey>A[j])
                    lowindex = j;
            }
        swap(A,i,lowindex);
        }
    }

    static void InsertionSort(int A[]){
        int i,j;
        for(i=1;i<A.length;i++){
            for(j=i;j>0;j--)
                if(A[j]<A[j-1])
                    swap(A,j,j-1);
        }
    }   
    static void BubbleSort(int A[]){
        int i;
        int j;
        for(i=0;i<A.length-1;i++){
            for(j=A.length-1;j>i;j--){
                if(A[j]<A[j-1])
                    swap(A,j,j-1);
            }
        }
    }
    
    //QuickSort
    static int FindPivot(int A[],int i,int j){
        int k=i+1;
        int firstkey =A[i];
        while((k<=j)&& (A[k]==firstkey))
               k++;
        if(k>j)
            return -1;
        else if(A[k]>firstkey)      
                return k;
        else return i;
    }
    static int Partition(int A[],int i, int j,int pivot){
        int L=i, R=j;
        while(L<=R){
            while(A[L]<pivot)
                L++;
            while(A[R]>=pivot)
                R--;
            if(L<R)
                swap(A,L,R);
        }
        return L;
    }
    static void QuickSort(int A[],int i,int j){
        int pivotindex =FindPivot(A,i,j);
        int pivot;
        int k;
        if(pivotindex !=-1){
            pivot=A[pivotindex];
            k=Partition(A,i,j,pivot);
            QuickSort(A,i,k-1);
            QuickSort(A,k,j);
        }
    }
    static void QuickSort(int[] A){
        QuickSort(A,0,A.length-1);
    }
    //mergesort
    static void merge(int A[],int l,int m, int r){
        int n1=m-l+1;
        int n2=r-m;
        
        int[] L=new int[n1];
        int[] R=new int[n2];
        
        int i=0,j=0;
        
        while(i<n1){
            L[i]=A[l+i];
            i++;
        }
        while(j<n2){
            R[j]=A[m+1+j];
            j++;
        }
        
        i=0; j=0;
        int k=l;
        while((i<n1)&&(j<n2)){
            if(L[i]<=R[j]){
                A[k]=L[i];
                i++;}
            else {A[k]=R[j];
                j++;}
            k++;
        }
        while(i<n1){
            A[k]=L[i];
            i++;
            k++;
        }
        while(j<n2){
            A[k]=R[j];
            j++;
            k++;
        }
    }
    static void MergeSort(int A[], int l, int r){
        if (l < r){
            int m = (l+r)/2;
            MergeSort(A, l, m);
            MergeSort(A, m+1, r);
            merge(A, l, m, r);
        }
        
    }
    static void MergeSort(int[] A){
        MergeSort(A,0,A.length-1);
    }
    
    //heapsort
    static void PushDown(int A[], int last,int first){
        int r;
        for(r=first;r<=(last-1)/2;r++){
            if(last==2*r+1){
                if(A[r]>A[last]) swap(A, r, last);
                r=last;
            }else if((A[r]>A[2*r+1])&&(A[2*r+1]<=A[2*r+2])){
                swap(A, r, 2*r+1);
                r=2*r+1;
            }else if((A[r]>A[2*r+2])&&(A[2*r+2]<A[2*r+1])){
                swap(A, r, 2*r+2);
                r=2*r+2;
            }else r=last;
        }
    }
    static void HeapSort(int A[]){
        int i;
        for(i=(A.length-2)/2;i>=0;i--)
            PushDown(A, i, A.length-1);
        for(i=A.length-1;i>=2;i--){
            swap(A, 0, i);
            PushDown(A, 0, i-1);
        }
        swap(A, 0, 1);
    }
    static void swap(int A[],int x,int y){
        int temp=A[x];
        A[x]=A[y];
        A[y]=temp;
    }
    static void printArray(int A[],int n){
        for (int i = 0; i < n; ++i)
            System.out.print(A[i] + " ");
        System.out.println();
    }

}
