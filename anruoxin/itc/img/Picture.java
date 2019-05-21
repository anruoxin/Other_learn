package anruoxin.itc.img;



/***
 *      ┌─┐       ┌─┐
 *   ┌──┘ ┴───────┘ ┴──┐
 *   │                 │
 *   │       ───       │
 *   │  ─┬┘       └┬─  │
 *   │                 │
 *   │       ─┴─       │
 *   │                 │
 *   └───┐         ┌───┘
 *       │         │
 *       │         │
 *       │         │
 *       │         └──────────────┐
 *       │                        │
 *       │                        ├─┐
 *       │                        ┌─┘
 *       │                        │
 *       └─┐  ┐  ┌───────┬──┐  ┌──┘
 *         │ ─┤ ─┤       │ ─┤ ─┤
 *         └──┴──┘       └──┴──┘
 *                神兽保佑
 *               代码无BUG!
 * @author anruoxin
 * @date 2019/5/20 16:29
*/
public class Picture {

    public static class RGB{
        private int R;
        private int G;
        private int B;

        public RGB(int r, int g, int b) {
            R = r;
            G = g;
            B = b;
        }

        public int getR() {
            return R;
        }

        public void setR(int r) {
            R = r;
        }

        public int getG() {
            return G;
        }

        public void setG(int g) {
            G = g;
        }

        public int getB() {
            return B;
        }

        public void setB(int b) {
            B = b;
        }
    }
    private String name;
    private int height;
    private int width;
    private RGB[][] color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public RGB[][] getColor() {
        return color;
    }

    public void setColor(RGB[][] color) {
        this.color = color;
    }

}
