import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        Integer[] Bwrapper = new Integer[B.length];
        for(int i = 0; i < B.length; ++i) {
            Bwrapper[i] = B[i];
        }
        
        Arrays.sort(A);
        Arrays.sort(Bwrapper, Comparator.reverseOrder());
        
        for(int i = 0; i < A.length; ++i) {
            answer += (A[i] * Bwrapper[i]);
        }

        return answer;
    }
}