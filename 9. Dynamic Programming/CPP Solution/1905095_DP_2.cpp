//
//  DP2_Bitmask.cpp
//  DP2
//
//  Created by Md. Raihan Sobhan on 11/2/22.
//
// C++ program to find minimum cost to visit all cities
#include <iostream>
#include <string>
#include <sstream>
#include <vector>
using namespace std;
#define MOD 1000000007

using namespace std;
int main(){
    
    int n;
    cin>>n;
    
    vector<vector<int>> grid(n,vector<int> (1<<n, 1000000007));
    vector<vector<int>> cityCost(n,vector<int>(n));
    
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            cin>>cityCost[i][j];
        }
    }
    
    for(int i=0;i<n;i++){
        grid[i][1<<i]= cityCost[i][i]; // storing the individual entry fee of each cities in i,i index
    }
    
    for(int bitmask=0; bitmask<(1<<n); bitmask++){
        for(int i =0 ; i<n; i++ ){
            if(!(bitmask & (1<<i))){
                continue; // the city I am entering must be shown visited i.e. marked by 1, if not skip that
            }
            for(int digit = 0;digit<n; digit++){
                if(!(bitmask & (1<<digit))){
                    int fee= 0;
                    for(int j=0;j<n;j++){
                        if(bitmask & (1<<j)){
                            fee+=cityCost[digit][j]; // adding the visiting cost of that city
                        }
                    }
                    grid[digit][bitmask | (1<<digit)] = min(grid[digit][bitmask | (1<<digit)], grid[i][bitmask] + fee+ cityCost[digit][digit]);
                    // If any previous total cost exists, I will take the minimum of that and present fee
                }
            }
        }
    }
    int minimum_Cost = INT_MAX;
    
    for(int i=0;i<n;i++){
        minimum_Cost= min(minimum_Cost,grid[i][(1<<n)-1]); // taking the minimum value of the rightmost column of the grid
    }
    cout<<minimum_Cost<<endl;
    return 0;
}
