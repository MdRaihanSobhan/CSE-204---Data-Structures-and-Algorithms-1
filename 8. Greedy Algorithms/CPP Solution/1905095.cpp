//
//  main.cpp
//  DSA Offline 8
//
//  Created by Md. Raihan Sobhan on 3/2/22.
//
#include <iostream>
#include <algorithm>
using namespace std;

long long int minCost(int ara[], int N, int K){
    
    long long int ret=0; // The minimum cost to buy all the plants
    
    sort(ara,ara+N);    // sorting the prices to buy higher price plants first, so that it will
                        // be multiplied by a factor as less as possible
    
    // t will keep the count of number of friends for each factor
    // j will iterate the array from last to first
    // i will be used to determine the increasing factor
    
    for(int i=0, j=N-1, t=0; j>=0; j--){
        ret+=ara[j]*(i+1);
        t++;
        if(t==K){
            t=0;
            i++;
        }
    }
    return ret;
}

int main() {
    int plantNumber, friends;
    
    cin>>plantNumber>>friends;
    
    int PriceOfPlants[100];
    
    for(int i=0;i<plantNumber;i++) cin>>PriceOfPlants[i];
    
    long long int minimumCost= minCost(PriceOfPlants,plantNumber ,friends);
    
    cout<<minimumCost<<endl;
}
