
import java.util.*;

class NQueens {

    static String PM, Cont; // (Y/N)
    static int rowin, colin, n, sol; //number of rows & columns input, size of board (n*n)
    static ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    static boolean[] cols, leftDiagonal, rightDiagonal;
    static boolean g = false, conti = false; // g check if there is solution

    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        cols = new boolean[n];
        leftDiagonal = new boolean[2 * n];
        rightDiagonal = new boolean[2 * n];
        result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {    
            temp.add(0);
        }
        solveNQUtil(result, n, 0, temp); 

        return result;
    }

    private static void solveNQUtil(ArrayList<ArrayList<Integer>> result, int n, int row, ArrayList<Integer> comb) {
        if (row == n) {
            result.add(new ArrayList<>(comb));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (cols[col] || leftDiagonal[row + col] || rightDiagonal[row - col + n]) {
                continue;
            }
            cols[col] = leftDiagonal[row + col] = rightDiagonal[row - col + n] = true;
            comb.set(col, row + 1);
            solveNQUtil(result, n, row + 1, comb);
            cols[col] = leftDiagonal[row + col] = rightDiagonal[row - col + n] = false;
        }
    }

    private static void Print(ArrayList<ArrayList<Integer>> res, int sol) {
        System.out.println("============================");
        System.out.print("   ");
        for (int i = 0; i < n; i++) {
            System.out.print(i + 1 + "   ");
        }
        System.out.println();
        for (int t = 0; t < res.get(sol).size(); t++) {
            System.out.print(t + 1 + "| ");
            for (int k = 0; k < res.get(sol).size(); k++) {
                if (res.get(sol).get(t) == k + 1) {
                    System.out.print("Q" + "   ");
                } else {
                    System.out.print("_" + "   ");
                }
            }
            System.out.println("\n");
        }
        System.out.println("============================");
    }

    public static void Play() {
        Scanner Input = new Scanner(System.in);
        boolean success = false;
        while (!success) {
            try {
                System.out.println("Enter N for N*N (N must be at least 4)");
                n = Integer.parseInt(Input.next());
                NBoard(n);
                success = true;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        success = false;
        while (!conti) {
            while (!success) {
                try {
                    System.out.println("Place your first Queen manually ? (y for yes,n for no)");
                    PM = Input.next();
                    YesNo(PM);
                    success = true;
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            success = false;
            ArrayList<ArrayList<Integer>> res = nQueen(n);
            if (PM.equalsIgnoreCase("Y")) {
                while (!success) {
                    try {
                        System.out.println("Enter row of the First Queen");
                        rowin = Integer.parseInt(Input.next());
                        Bound(rowin);
                        success = true;
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                success = false;
                while (!success) {
                    try {
                        System.out.println("Enter column of the First Queen");
                        colin = Integer.parseInt(Input.next());
                        Bound(colin);
                        success = true;
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                success = false;
                System.out.println("Your First Queen Coordinates ([" + rowin + "," + colin + "] [row,column])");
                {
                    System.out.println("============================");
                    System.out.print("   ");
                    for (int i = 0; i < n; i++) {
                        System.out.print(i + 1 + "   ");
                    }
                    System.out.println();
                    for (int i = 0; i < n; i++) {
                        System.out.print(i + 1 + "| ");
                        for (int j = 0; j < n; j++) {
                            if (colin == j + 1 && rowin == i + 1) {
                                System.out.print("Q" + "   ");
                            } else {
                                System.out.print("_" + "   ");
                            }
                        }
                        System.out.println("\n");
                    }
                    System.out.println("============================");
                }
                for (int i = 0; i < res.size(); i++) {
                    if (res.get(i).get(rowin - 1) == colin) {
                        System.out.println(res.get(i)); //print
                        g = true;
                        sol = i;
                        Print(res, sol);
                    }
                }
                if (g == false) {
                    System.out.println("No solution");
                }
            } else {
                System.out.println("Solution");
                System.out.println(nQueen(n).get(0)); //print 
                Print(nQueen(n), 0);
            }
            while (!success) {
                try {
                    System.out.println("Continue ? (y for yes,n for no)");
                    Cont = Input.next();
                    YesNo(Cont);
                    success = true;
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            success = false;
            if (Cont.equalsIgnoreCase("N")) {
                System.out.println("All Solution");
                System.out.println(res); //print 
                for (int m = 0; m < res.size(); m++) {
                    Print(res, m);
                }
                conti = true;
            }
        }
    }

    static void NBoard(int N) throws CustomException {
        if (N < 4) {
            throw new CustomException("Number of N*N board is at least 4");
        }
    }

    static void YesNo(String Input) throws CustomException {
        if (!Input.equalsIgnoreCase("Y") && !Input.equalsIgnoreCase("N")) {
            throw new CustomException("Either Y or N !(Y = Yes,N = No)");
        }
    }

    static void Bound(int N) throws CustomException {
        if (N > n) {
            throw new CustomException("Coordinates out of bounds (" + n + ") ");
        }
        if (N < 1) {
            throw new CustomException("Number of row and columns cannot be below 1");
        }
    }

    // Driver code
    public static void main(String[] args) {
        Play();
    }
}

class CustomException extends Exception {

    public CustomException(String str) {
        super(str);
    }
}
