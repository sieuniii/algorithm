class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        
        answer = new int [4];
        
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        for(int i = 0; i < wallpaper.length; i++){
            
            for(int j=0; j < wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    if(minX > i) minX = i;
                    if(maxX < i) maxX = i;
                    if(minY > j) minY = j;
                    if(maxY < j) maxY = j;
                }
            }
        }

        
        answer[0] = minX;
        answer[1] = minY;
        answer[2] = maxX + 1;
        answer[3] = maxY + 1;
             
        
        return answer;
    }
}