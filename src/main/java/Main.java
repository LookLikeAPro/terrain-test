import java.util.Random;

//class Noise {
//    /** Source of entropy */
//    private Random rand_;
//
//    /** Amount of roughness */
//    float roughness_;
//
//    /** Plasma fractal grid */
//    private float[][] grid_;
//
//
//    /** Generate a noise source based upon the midpoint displacement fractal.
//     *
//     * @param rand The random number generator
//     * @param roughness a roughness parameter
//     * @param width the width of the grid
//     * @param height the height of the grid
//     */
//    public Noise(Random rand, float roughness, int width, int height) {
////        roughness_ = roughness / width;
//        roughness_ = roughness;
//        grid_ = new float[width][height];
//        rand_ = (rand == null) ? new Random() : rand;
//    }
//
//
//    public void initialise() {
//        int xh = grid_.length - 1;
//        int yh = grid_[0].length - 1;
//
//        // set the corner points
////        grid_[0][0] = rand_.nextFloat() - 0.5f;
////        grid_[0][yh] = rand_.nextFloat() - 0.5f;
////        grid_[xh][0] = rand_.nextFloat() - 0.5f;
////        grid_[xh][yh] = rand_.nextFloat() - 0.5f;
//
//        grid_[0][0] = 1;
//        grid_[0][yh] = 0.5f;
//        grid_[xh][0] = 1;
//        grid_[xh][yh] = 0.5f;
//
//        // generate the fractal
//        generate(0, 0, xh, yh);
//    }
//    public void initialise1() {
//        int xh = grid_.length - 1;
//        int yh = grid_[0].length - 1;
//
//        grid_[0][0] = 0.5f;
//        grid_[0][yh] = 0;
//        grid_[xh][0] = 0.5f;
//        grid_[xh][yh] = 0;
//
//        // generate the fractal
//        generate(0, 0, xh, yh);
//    }
//
//
//    // Add a suitable amount of random displacement to a point
//    private float roughen(float v, int l, int h) {
//        return v + roughness_ * (float) (rand_.nextGaussian() * (h - l));
//    }
//
//
//    // generate the fractal
//    private void generate(int xl, int yl, int xh, int yh) {
//        int xm = (xl + xh) / 2;
//        int ym = (yl + yh) / 2;
//        if ((xl == xm) && (yl == ym)) return;
//
//        grid_[xm][yl] = 0.5f * (grid_[xl][yl] + grid_[xh][yl]);
//        grid_[xm][yh] = 0.5f * (grid_[xl][yh] + grid_[xh][yh]);
//        grid_[xl][ym] = 0.5f * (grid_[xl][yl] + grid_[xl][yh]);
//        grid_[xh][ym] = 0.5f * (grid_[xh][yl] + grid_[xh][yh]);
//
//        float v = roughen(0.5f * (grid_[xm][yl] + grid_[xm][yh]), xl + yl, yh
//                + xh);
//        grid_[xm][ym] = v;
//        grid_[xm][yl] = roughen(grid_[xm][yl], xl, xh);
//        grid_[xm][yh] = roughen(grid_[xm][yh], xl, xh);
//        grid_[xl][ym] = roughen(grid_[xl][ym], yl, yh);
//        grid_[xh][ym] = roughen(grid_[xh][ym], yl, yh);
//
//        generate(xl, yl, xm, ym);
//        generate(xm, yl, xh, ym);
//        generate(xl, ym, xm, yh);
//        generate(xm, ym, xh, yh);
//    }
//
//
//    /**
//     * Dump out as a CSV
//     */
//    public void printAsCSV() {
//        for(int i = 0;i < grid_.length;i++) {
//            for(int j = 0;j < grid_[0].length;j++) {
//                System.out.print(grid_[i][j]);
//                System.out.print(",");
//            }
//            System.out.println();
//        }
//    }
//
//
//    /**
//     * Convert to a Boolean array
//     * @return the boolean array
//     */
//    public boolean[][] toBooleans() {
//        int w = grid_.length;
//        int h = grid_[0].length;
//        boolean[][] ret = new boolean[w][h];
//        for(int i = 0;i < w;i++) {
//            for(int j = 0;j < h;j++) {
//                ret[i][j] = grid_[i][j] < 0;
//            }
//        }
//        return ret;
//    }
//
//    public void printAsBool() {
//        int w = grid_.length;
//        int h = grid_[0].length;
//        for(int i = 0;i < w;i++) {
//            for(int j = 0;j < h;j++) {
//                System.out.print(grid_[i][j] < 0? "1" : "-");
//            }
//            System.out.println();
//        }
//    }
//
//
//    /** For testing */
//    public static void main(String[] args) {
//        Noise n = new Noise(null, 1.0f, 250, 250);
//        n.initialise();
//        n.printAsCSV();
//    }
//}


import com.sudoplay.joise.module.ModuleBasisFunction.BasisType;
import com.sudoplay.joise.module.ModuleBasisFunction.InterpolationType;
import com.sudoplay.joise.module.ModuleFractal;
import com.sudoplay.joise.module.ModuleFractal.FractalType;

public class Main {
    public static void main(String[] args) {
//        Random r = new Random(1234);
//        Noise n = new Noise(r, 10, 20, 100);
//        n.initialise();
//        n.printAsBool();
//        System.out.println();
//
//        Noise n1 = new Noise(r, 10, 20, 100);
//        n1.initialise1();
//        n1.printAsBool();

//        ModuleFractal gen = new ModuleFractal();
//        gen.setAllSourceBasisTypes(BasisType.SIMPLEX);
//        gen.setAllSourceInterpolationTypes(InterpolationType.CUBIC);
//        gen.setNumOctaves(5);
//        gen.setFrequency(2.34);
//        gen.setType(FractalType.RIDGEMULTI);
//        gen.setSeed(896);
//        float maxp = 0;
//        float minp = 10;
//        for (int x = 0; x < 100; x++) {
//            for (int y = 0; y < 100; y++) {
//                float px = x / (float) 100 * 1;
//                float py = y / (float) 100 * 1;
//                float r = (float) gen.get(px, py);
//                maxp = Math.max(maxp, r);
//                minp = Math.min(minp, r);
//                System.out.print(r+",");
//            }
//            System.out.println();
//        }
//        System.out.println(maxp);
//        System.out.println(minp);


    }
}
