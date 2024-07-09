#include<bits/stdc++.h>
#include<vector>
using namespace std;

class Heap
{
private:
    int* heapArray;
    int heapSize;
    int heapLength;

    void swapElements(int i, int j)
    {
        int temp= heapArray[i];
        heapArray[i]= heapArray[j];
        heapArray[j]= temp;
    }

    int filterUp(int position)
    {
        if(this->heapLength<=position)
            return 0;
        while(position!=0 &&
                heapArray[position]>heapArray[getPrarent(position)])
        {
            swapElements(position, getPrarent(position));
            position= getPrarent(position);
        }
        return position;
    }

    void filterDown(int position)
    {
        while(!isLeaf(position))
        {
            int temp= getLeftChild(position);
            if(temp< this->heapLength-1 && heapArray[temp]<heapArray[temp+1])
                temp++;
            if(heapArray[position]>heapArray[temp])
                return;
            swapElements(position, temp);
            position= temp;
        }
    }

    bool isLeaf(int position)
    {
        bool ret = position>=heapLength/2 && position<heapLength;
        return ret;
    }
    int getPrarent(int position)
    {
        return (position-1)/2;
    }
    int getLeftChild(int position)
    {
        return 2*position+1;
    }
    int getRightChild(int position)
    {
        return 2*position +2;
    }


public:
    Heap(int maxHeapSize)
    {
        this-> heapSize= maxHeapSize;
        heapArray= new int[maxHeapSize];
        this->heapLength=0;
    }
    Heap(vector<int> &v)
    {
        int tempLength=v.size();
        this->heapArray= new int[tempLength];
        this->heapLength=0;
        for(int i=0; i<v.size(); i++)
        {
            insert(v[i]);
        }
    }

    int size()
    {
        return this->heapLength;
    }

    int getMax()
    {
        if(heapLength>0)
            return heapArray[0];
    }

    void insert(const int& item)
    {
        if(heapLength<heapSize)
        {
            heapArray[heapLength] = item;
            heapLength++;
            filterUp(heapLength - 1);

        }
    }

    int deleteKey()
    {
        if(heapLength>0)
        {
            heapLength--;
            swapElements(0, heapLength);
            if(heapLength != 0)
                filterDown(0);
            return heapArray[heapLength];
        }
    }
};

void heapsort(vector<int>&v)
{
    Heap heap(v);
    for(int i = 0; i < v.size(); i++)
    {
        v[i] = heap.deleteKey();
    }
}
