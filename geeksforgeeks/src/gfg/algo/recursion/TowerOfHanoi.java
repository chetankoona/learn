package gfg.algo.recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 4;
        towerOfHanoi(n, 'A','C','B');
    }

    private static void towerOfHanoi(int n, char from, char to, char aux) {
        /*If only 1 disk make the move and return*/
        if(n==1){
            System.out.println("Move disk 1 from "+from+" to "+to);
            return;
        }

        /*Move top n-1 disks from A to B using C as auxiliary*/
        towerOfHanoi(n-1,from,aux,to);

        /*Move the nth disk from A to C*/
        System.out.println("Move disk "+n+" from "+from+" to "+to);

        /*Move top n-1 disks from B to C using A as auxiliary*/
        towerOfHanoi(n-1,aux,to,from);
    }
}
