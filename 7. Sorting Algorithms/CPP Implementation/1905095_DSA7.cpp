#include<bits/stdc++.h>
#include<ctime>
#include<cstdlib>
using namespace std;

void Merge(int ara[], int left, int middle, int right)
{
    int length= right-left+1;
    int mergedAra[length];
    int i=left, j=middle+1, k=0 ;
    while(i<=middle && j<=right)
    {
        if(ara[i]<=ara[j])
        {
            mergedAra[k++]= ara[i++];
        }
        else
        {
            mergedAra[k++] = ara[j++];
        }
    }
    while(i<=middle)
    {
        mergedAra[k++]=ara[i++];
    }
    while(j<=right)
    {
        mergedAra[k++]= ara[j++];
    }
    while(length--)
    {
        ara[right--]= mergedAra[length];
    }
}
void partialMergeSort(int ara[], int left, int right)
{
    if(right<=left)
        return;
    int middle= left + ((right-left)/2);
    partialMergeSort(ara,left,middle);
    partialMergeSort(ara,middle+1,right);
    Merge(ara,left,middle,right);
}
void Mergesort(int ara[], int n)
{
    partialMergeSort(ara,0,n-1);
}

void InsertionSort(int ara[],int n)
{
    for(int i=1; i<n; i++)
    {
        for(int j=i; j>0 && ara[j]<ara[j-1]; j--)
        {
            swap(ara[j],ara[j-1]);
        }
    }
}

int Partition(int ara[], int left, int right, bool randomPivot = false)
{
    if(randomPivot)
    {
        int length = right-left+1;
        swap(ara[left+ (rand()%length)], ara[right]);
    }
    int smaller= left-1, larger=left, Pivot = ara[right];
    while(larger<=right)
    {
        if(ara[larger]<=Pivot)
        {
            swap(ara[++smaller], ara[larger]);
        }
        larger++;
    }
    return smaller;
}

void partialQuickSort(int ara[], int left, int right, bool randomPivot= false)
{
    if(right<=left)
        return;
    int Pivot= Partition(ara,left,right,randomPivot);
    partialQuickSort(ara,left,Pivot-1,randomPivot);
    partialQuickSort(ara,Pivot+1,right,randomPivot);
}

void QuickSort(int ara[], int n, bool randomPivot= false)
{
    partialQuickSort(ara,0,n-1,randomPivot);
}

int main()
{

    int inputString []= {5,10,100,1000,10000,100000};
    freopen("output.csv","w",stdout);
    cout<<"n,Merge Sort, Quicksort, Randomized Quicksort, Insertion Sort, Quicksort with Sorted Input, Randomized Quicksort with Sorted Input, STL function\n";
    for(int k=0; k<6; k++)
    {
        int testCount=20;
        int n=inputString[k];
        cout<<n<<",";
        int ara[n];
        int mergesortArray[n],quicksortArray[n],randomizedQuickSortArray[n],insertionsortArray[n];
        double timeCounter[7]= {0.0};
        for(int j=0; j<testCount; j++)
        {
            int seed=4;
            srand(seed);
            for (int i=0; i<n; i++)
                ara[i]=rand();
            for(int i=0; i<n; i++)
                mergesortArray[i]=quicksortArray[i]=randomizedQuickSortArray[i]=insertionsortArray[i]=ara[i];

            clock_t mergeTimeCount= clock();
            Mergesort(mergesortArray, n);
            timeCounter[0]+=((clock() - mergeTimeCount)*1000/(double)CLOCKS_PER_SEC);

            clock_t quickTimeCount= clock();
            QuickSort(quicksortArray,n);
            timeCounter[1]+=((clock() - quickTimeCount)*1000/(double)CLOCKS_PER_SEC);

            clock_t randomQuickTimeCount= clock();
            QuickSort(randomizedQuickSortArray,n, true);
            timeCounter[2]+=((clock() - randomQuickTimeCount)*1000/(double)CLOCKS_PER_SEC);

            clock_t insertionTimeCount = clock();
            InsertionSort(insertionsortArray, n);
            timeCounter[3]+=((clock() - insertionTimeCount)*1000/(double)CLOCKS_PER_SEC);

            clock_t sortedQuickTimeCount= clock();
            QuickSort(insertionsortArray,n);
            timeCounter[4]+=((clock() - sortedQuickTimeCount)*1000/(double)CLOCKS_PER_SEC);

            clock_t  SRandQuick= clock();
            QuickSort(insertionsortArray, n, true);
            timeCounter[5]+=((clock() - SRandQuick)*1000/(double)CLOCKS_PER_SEC);

            clock_t STLtimeCount= clock();
            sort(ara,ara+n);
            timeCounter[6]+=((clock() - STLtimeCount)*1000/(double)CLOCKS_PER_SEC);
        }
        for(int i=0; i<6; i++)
            cout<<(double)timeCounter[i]/testCount<<",";
        cout<<(double)timeCounter[6]/testCount;
        cout<<"\n";
    }

    return 0;
}

