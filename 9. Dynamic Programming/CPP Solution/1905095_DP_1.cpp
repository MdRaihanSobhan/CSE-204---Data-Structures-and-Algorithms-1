//
//  1905095_DP1.cpp
//  DP1
//
//  Created by Md. Raihan Sobhan on 11/2/22.
//

#include <iostream>
#include <string>
using namespace std;

char* LCS(string str1, string str2){
    long long m= str1.size();
    long long n= str2.size();
    int lcs[51][51];
    for(long long i=0;i<=m;i++){
        for(long long j=0;j<=n;j++){
            if(i==0 || j==0){
                lcs[i][j]=0;
            }
            else if(str1[i-1]==str2[j-1]){
                lcs[i][j]= 1+ lcs[i-1][j-1];
            }
            else{
                lcs[i][j]= max(lcs[i][j-1], lcs[i-1][j]);
            }
        }
    }
    
    int temp= lcs[m][n];
    char* result = (char*)malloc((temp+1)*sizeof(char));
    result[temp]='\0';
    
    for(long long int i=m,j=n; i>0 && j>0; ){
        if(str1[i-1]==str2[j-1]){
            result[temp-1]=str1[i-1];
            i--;
            j--;
            temp--;
        }
        else if(lcs[i-1][j]> lcs[i][j-1]){
            i--;
        }
        else {
            j--;
        }
    }
    
    return result;
}


int main() {
    string st1, st2;
    cin>>st1>>st2;
    string result;
    result= LCS(st1,st2);
    cout<<result.size()<<endl;
    cout<<result<<endl;
    return 0;
}

