package learningalgorithms.algo.towerofhanoi;

public class TowerOfHanoi {
    /**
     * This is recursive solution, base case is with 2 disks.
     * To derive algorithm, write down steps for 3 disks.
     * @param n
     * @param source
     * @param auxiliary
     * @param destination
     */
    public void towerOfHanoi(int n,String source,String auxiliary,String destination){
        if(n>0){
            towerOfHanoi(n-1,source,destination,auxiliary);
            System.out.println("move a disk from "+source+" to "+destination);
            towerOfHanoi(n-1,auxiliary,source,destination);
        }
    }
}
