package RedBlackTree;

/**
* @author anruoxin
* @date 2019/5/17 14:51
*/
public enum ColorEnum {
    /**
    *红色
     */
    RED(1),
    /**
     * 黑色
     */
    BLACK(0);

    private Integer color;

    ColorEnum(Integer color) {
        this.color = color;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }
}
