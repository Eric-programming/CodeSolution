class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites){
        int[] table = new int[numCourses];
        for(int[] courses : prerequisites){
            int curCourse = courses[0];
            table[curCourse]++;
        }
        Set<Integer> hs = new HashSet<>();
        //find the element that has no incoming edges
        for(int i = 0; i < table.length; i++){
            if(table[i] == 0){
                hs.add(i);
            }
        }
        //If the set is empty that means we have cyclic graph
        if(hs.isEmpty() == true){
            return false;
        }
        while(hs.isEmpty() == false){
            Iterator<Integer> it = hs.iterator();
            Integer element = it.next();
            //Remove edges that element has
            for(int course = 0; course < prerequisites.length; course++){
                //check to see if preQ == element
                int preQ = prerequisites[course][1];
                //We found a connection
                if(preQ == element){
                    int curCourse = prerequisites[course][0];
                    //remove the incoming edges of this current course
                    table[curCourse]--;
                    if(table[curCourse] == 0){
                        hs.add(curCourse);
                    }
                }
            }
            hs.remove(element);
        }
        //check if there is cycle
        for(int course : table){
            if(course > 0) return false;
        }
        return true;
    }
}
