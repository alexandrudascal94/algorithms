package merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MergeIntervals_MiroOverlappingFrames {
    // overlap frames
    public static void main(String[] args) {
        var frames =
                new ArrayList<List<Integer>>();

        frames.add(Arrays.asList(7,4,10,6));
        frames.add(Arrays.asList(2,2,6,6));
        frames.add(Arrays.asList(5,0,8,3));
        frames.add(Arrays.asList(1,1,2,4));
        System.out.println(areOverlappingFrames(frames));
    }

    // [x1, y1, x2, y2] [a1, b1, a1, b2]
    // [5, 5, 10, 15] [bottom left, upper right]
    private static boolean areOverlappingFrames(List<List<Integer>> frames) {
        // sort by bottom left corner on X axe
        //nlongn
        Collections.sort(frames, (f1, f2) ->{
            return Integer.compare(f1.get(0), f2.get(0));
        });

        // How to compare two frames
        // x2 > a1 overlap on x axe

        PriorityQueue<List<Integer>> pq =  new PriorityQueue<List<Integer>>((f1, f2) ->{
           return Integer.compare(f2.get(0), f1.get(1));
        });
       //n
        var current = frames.get(0);
        for (int i = 1; i <  frames.size(); ++i){
            var next  = frames.get(i);
            if(isOverlapX(current, next) && isOverlapY(current, next)){
                return true;
            }
            current = next;
        }
        return false;
    }

    private static boolean isOverlapY(List<Integer> current, List<Integer> next) {
        if(current.get(1) < next.get(1)){
            return current.get(3) > next.get(1);
        }
        else {
            return  next.get(3) > current.get(1);
        }
    }

    private static boolean isOverlapX(List<Integer> current, List<Integer> next) {
        return current.get(2) > next.get(0);
    }

}
