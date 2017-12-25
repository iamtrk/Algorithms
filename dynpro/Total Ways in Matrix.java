Total Ways in Matrix from top left to bottom right:

T[i,j] = 1 for top row.
T[i,j] = 1 for first column.

For the rest : T[i,j] = T[i-1,j]+T[i,j+1]

If there are any obstacles, make it 0.
