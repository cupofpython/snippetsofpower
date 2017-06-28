#include <stdio.h>
#include <stdlib.h>

int main() {
	int n; 
	FILE *f;
	f = fopen("majesticin.txt","r");
	// Number of players.
	fscanf(f,"%d",&n);
	int i = 0;
	
	
	// For each player... 
	for(i; i < n; i++)
	{
		// Scan in player vals. 
		int arr[3];  
		fscanf(f,"%d %d %d",&arr[0],&arr[1],&arr[2]);	
		printf("%d %d %d \n",arr[0],arr[1],arr[2]); 
		
		int freq[2] = {0,0}; 
		int j = 0;
		// Iterate through vals and populate frequency array. 
		for(j; j < 3; j++)
		{
			if(arr[j] < 10)
				freq[0]++;
			else
				freq[1]++; 		
		}
		
		// Print based on case. 
		if(freq[1] == 0)
			printf("zilch");
		else if(freq[1] == 1)
			printf("double"); 
		else if(freq[1] == 2)
			printf("double-double"); 
		else
			printf("triple-double"); 
		
		printf("\n\n"); 
	}
	
	fclose(f); 
	
	return 0; 
}