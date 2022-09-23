//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.List;
//import java.util.stream.Collectors;
//
//class Solution {
//
//    public int solution(String[] E) {
//        int DAYS = 10;
//        // day, employees idx
//        HashMap<Integer, ArrayList<Integer>> distribution = new HashMap<>();
//        fillHashMap(distribution, DAYS);
//
//        for(int i = 0; i < E.length; i++){
//            char[] employeeAvailabilities = E[i].toCharArray();
//
//            for(int j = 0; j < employeeAvailabilities.length; j++){
//                int availableDay = Character.getNumericValue(employeeAvailabilities[j]);
//                ArrayList<Integer> dayAvailabilies = distribution.get(availableDay);
//                dayAvailabilies.add(i);
//                distribution.put(availableDay, dayAvailabilies);
//            }
//        }
//
//        // This solutions will check the number of max employees that can attend the
//        // training thake take place 2 consecutive days. released at the end that
//        // I missed that the day order does't matter
//        var daysDist = distribution.values().toArray(ArrayList[]::new);
//        Arrays.sort(daysDist);
//        int maxAttendance = 0;
//        int firstDay = daysDist.length - 1;
//        int secondDay = daysDist.length - 2;
//
//        while(firstDay > 0 && secondDay > 0){
//            var firstDayAttendace = daysDist.
//        }
//
//        for(int i = 0; i < DAYS - 1; i++){
//
//            // sort
//            // take from largest
//            // max = day1 + day2 distinct
//            // if max == day1 + day2 (all distict) return max;
//
//            // keep max move second pointer
//            // localMax = day1 + day2 distinct
//            //
//            ArrayList<Integer> dayOne = distribution.get(i);
//            ArrayList<Integer> dayTwo = distribution.get(i + 1);
//
//            dayOne.addAll(dayTwo);
//            int attendance = (int)dayOne.stream().distinct().count();
//
//            if(attendance > maxAttendance){
//                maxAttendance = attendance;
//            }
//        }
//
//        return maxAttendance;
//    }
//
//    private void fillHashMap(HashMap<Integer, ArrayList<Integer>> map, int entryCount){
//        for(int i = 0; i < entryCount; i++){
//            map.put(i, new ArrayList<Integer>());
//        }
//    }
//}