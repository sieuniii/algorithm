class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        
        int maxSide = Math.max(sides[0], sides[1]);
        int otherSide = Math.min(sides[0], sides[1]);
        
        //case1 : maxSide가 가장 긴 변 일때
        int minus = maxSide + 1 - otherSide ;
        int case1 = maxSide - minus + 1 ; 
        // System.out.println("case1 : " + case1);
        
        //case2 : 나머지 하나가 가장 긴 변일 때
        int sum = sides[0] + sides[1]; // 9
        int case2 = sum - maxSide -1 ; 
        // System.out.println("case2 : " + case2);
        
        answer = case1 + case2;
        
        return answer;
    }
}