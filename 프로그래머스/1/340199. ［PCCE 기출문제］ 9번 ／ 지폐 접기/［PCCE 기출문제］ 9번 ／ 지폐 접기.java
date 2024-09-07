class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        
        int wall_min = Math.min(wallet[0], wallet[1]);
        int wall_max = Math.max (wallet[0], wallet[1]);
    
        int bill_min = Math.min(bill[0], bill[1]);
        int bill_max = Math.max (bill[0], bill[1]);
        
       
        while(true) {
            
          
            if( bill_min <= wall_min && bill_max <= wall_max)
                break;
            
            if(bill[0] > bill[1])
                bill[0] = bill[0]/2;
            else
                bill[1] = bill[1]/2;
            
            
        wall_min = Math.min(wallet[0], wallet[1]);
        wall_max = Math.max (wallet[0], wallet[1]);
    
        bill_min = Math.min(bill[0], bill[1]);
        bill_max = Math.max (bill[0], bill[1]);
            
            answer ++;
        }
        
        return answer;
    }
}