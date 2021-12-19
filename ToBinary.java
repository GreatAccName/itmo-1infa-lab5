import java.io.PrintStream;

public class ToBinary {
    public static final PrintStream so = System.out;

    public static void main(String[] args) {
        int[] x = new int[] {
            5811,
            15553,
            21364,
            36917,
            9742,
            28619,
            -5811,
            -15553,
            -21364,
            -36917,
            -9742,
            -28619
        };
        final int S = 17;
        boolean[] b = new boolean[S];

        for (int i = 0; i < x.length; ++i) {
            so.print( (i + 1) + ":\t" + x[i] + "\t");
            makeB(b, x[i]);
            showB(b);
        }

        int[] d = new int[] {
            x[1-1] + x[2-1],
            x[2-1] + x[3-1],
            x[2-1] + x[7-1],
            x[7-1] + x[8-1],
            x[8-1] + x[9-1],
            x[1-1] + x[8-1],
            x[11-1] + x[3-1]
        };

        so.println();
        for (int i = 0; i < d.length; ++i) {
            so.print( (i + 1) + ":\t" + d[i] + "\t");
            makeB(b, d[i]);
            showB(b);
        }
    }

    public static void makeB(boolean[] b, int x) {
        int S = b.length;
        boolean base = true;
        if (x < 0) {
            x = ~x;
            base = false;
        }
        // MOD(QUOTIENT(x / POWER(2; c)); 2)
        for (int i = 0; i < S; ++i) {
            int dx = x >> i;
            if (dx % 2 == 1)
                { b[S-1 - i] = base; }
            else
                { b[S-1 - i] = !base; }
        }
    }
    public static void showB(boolean[] b) {
        int S = b.length;
        for (int i = 0; i < S; ++i) {
            if ( (i + 4 - (S%4)) % 4 == 0 )
                { so.print(" "); }
            if (b[i])
                { so.print(1); }
            else
                { so.print(0); }
        }
        so.println();
    }
}