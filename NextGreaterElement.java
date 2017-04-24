//http://www.geeksforgeeks.org/next-greater-element/

//more optimized solution than the one given in geeksforgeeks

public class NextGreaterElement {

public static void main(String[] args) {

// TODO Auto-generated method stub

int[] numbers = {2,4,5,3};

if(numbers == null || numbers.length == 0)

return;

int[] tempoutput = nges(numbers);

for(int i=0; i< tempoutput.length; i++)

{

System.out.print(tempoutput[i] +" ");

}

System.out.println();

int i=0;

for(; i< tempoutput.length-1; i++)

{

if(tempoutput[i] == numbers[i])

{

tempoutput[i] = -1;

}

}

tempoutput[i] = -1;

for( int j=0; j< tempoutput.length; j++)

{

System.out.print(tempoutput[j] +" ");

}

System.out.println();

}

public static int[] nges(int[] numbers) {

int[] output = new int[numbers.length];

// int[] numbers = {5,9,4,6,10};

// 11,13,21,3

int nextmax = 0;

for (int i = numbers.length - 1; i >= 0; i--) {

if (i == numbers.length - 1) {

output[i] = numbers[i];

nextmax = output[i];

} else {

if (numbers[i + 1] > numbers[i]) {

output[i] = numbers[i + 1];

}

else {

output[i] = nextmax;

}

if (numbers[i] > nextmax) {

output[i] = numbers[i];

nextmax = output[i];

}

}

}

return output;

}

}
