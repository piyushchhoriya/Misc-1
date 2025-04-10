// ## Problem1: Calculate Using Broken Calculator (https://leetcode.com/problems/broken-calculator/)

// when we go exhaustive and simulate both the operations then it forms a structure like a tree. So we can do a traversal on that 
// We will do a BFS traversal on it 

// so we will add the displayed element in a queue and carry out the * operation if and only if the current value is samller than the target

// Time Complexity : O(2^D)
// Space Complexity : O(2^D)
// In the above approach we can process the same element again and again so this is inefficient and it will give us Time Limit Excedded


class Solution {
    public int brokenCalc(int startValue, int target) {
        //if startvalue > target so no need of *
        if(startValue > target){
            return startValue - target;
        }
        Queue<Integer> q = new LinkedList<>();
        int lvl = 0 ;
        q.add(startValue);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int curr = q.poll();
                if(curr==target){
                    return lvl;
                }
                if(curr > target){
                    q.add(curr-1);
                }
                else{
                    q.add(curr*2);
                    q.add(curr-1);
                }
            }
            lvl++;
        }
        return 5445;
    }
}

//Optimal Approach
We will reverse the approach here instead of * & - we will do / and + and also we will go from target to startValue.
If the no is odd then we will add 1 to it and if it is even then /2 to it this we will keep doing until the target > startvalue

Time Complexity : O(log target)
// so here we are dividing and so log n and we are adding so it will be atmost log n times only

class Solution {
    public int brokenCalc(int startValue, int target) {
        //base condition if startValue > target then we will not do * and just we will subtract
        if(startValue > target){
            return startValue - target;
        }
        int cnt = 0;
        //we will do the reverse approach until the target > startValue
        while(target > startValue){
            cnt++;
            if(target % 2 == 0){
                target = target / 2;
            }
            else{
                target+=1;
            }
        }
        // if in case our target < startValue we can't divide it further instead we will add 1 so we are doing startValue-target
        return cnt + startValue-target;
    }
}
