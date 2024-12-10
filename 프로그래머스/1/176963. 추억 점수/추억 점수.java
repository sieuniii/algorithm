
/*
name : 이름을 담은 배열
yearning : 그리움 점수 배열
photo : 각 사진에 찍힌 이름을 담은 이차열 문자 배열
*/



class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = {};
        answer = new int[photo.length];
    
        for(int i =0; i<photo.length; i++){
           
            int sum = 0;
            
            for(int j =0; j<photo[i].length; j++){
                String findName = photo[i][j];
                
                for(int k =0; k<name.length; k++){
                    if(findName.equals(name[k])){
                        sum += yearning[k];
                    }
                    else{
                        continue;
                    }
                }

            }
              answer[i] = sum;
        }    
        
        return answer;
    }
}