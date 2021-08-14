class Solution {
    public void duplicateZeros(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                queue.add(0);
                queue.add(0);
            }else{
                queue.add(arr[i]);
            }
            Integer first = queue.poll();
            arr[i] = first;
        }
    }
}

/***
Brute force:
N^2

for num in arr
    if num is zero
        shift all elements on the right to the right by one
        
Optimized:
O(N)

arr = [1,0,0,2,3,0,0,4]
                     ^
Queue=[5,0,0]


    

***/
