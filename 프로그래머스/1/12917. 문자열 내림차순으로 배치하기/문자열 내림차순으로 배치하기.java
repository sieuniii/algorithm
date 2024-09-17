import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        char arr[] = new char [s.length()];
        
        for(int i=0; i<s.length(); i++){
            arr[i] = s.charAt(i);
        }
        
        Arrays.sort(arr);
        
        for(int i=0; i<s.length(); i++){
            answer += arr[s.length()-1-i];
        }
        
        return answer;
    }
}