// Samantha Morris
// Break the Ice Problem, written in C
// 2016 Local Programming Contest Problem #3

#include <stdio.h>
#include <stdlib.h>

int main() {
	FILE *f;
	f = fopen("breakice.in","r");
	int b, dim, moves, r, c, i=0, j; 
	fscanf(f,"%d",&b);
	
	for(i; i < b; i++)
	{
		fscanf(f, "%d %d",&dim,&moves); 
		// Create 2D grid array. 
		int **freq = (int **)malloc(dim * sizeof(int *));
		int v; 
		for (v = 0; v < dim; v++)
		{
			freq[v] = (int *)malloc(dim*sizeof(int));
		}
		
		int o, p;
		for(o = 0; o < dim; o++)
		{
			for(p = 0; p < dim; p++)
			{
				freq[o][p] = 0;  
			}
		}
		
		int inValid = 0; 
		
		for(j=0; j < moves; j++)
		{
			fscanf(f,"%d %d",&r,&c); 
			int x, rowSum=0, colSum=0; 
			
			// Sum up row and column of given point on grid. 
			for(x = 0; x < dim; x++)
			{
				rowSum+=freq[r-1][x];
				colSum+=freq[x][c-1]; 
			}
			
			// Check if any other cells contain anything but zero in them for that row and column.
			// If they do, increment number of invalid points. 
			if(rowSum > freq[r-1][c-1] && colSum > freq[r-1][c-1])
				inValid++; 
			freq[r-1][c-1]++; 
		}
		
		printf("\nStrategy #%d: %d\n",i+1,inValid); 
		
		int l;
		for(l = 0; l < dim; l++)
		{
			free(freq[l]); 
		}
		free(freq); 
	}
	
	return 0; 
}