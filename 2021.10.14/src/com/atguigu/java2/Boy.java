package com.atguigu.java2;

/**
 * @author lixhui
 * @create 2021-10-14:19
 */
public class Boy {
    private Gril gril;

    @Override
    public String toString() {
        return "Boy{" +
                "gril=" + gril +
                '}';
    }

    public Gril getGril() {
        return gril;
    }

    public void setGril(Gril gril) {
        this.gril = gril;
    }

    public Boy() {
    }

    public Boy(Gril gril) {
        this.gril = gril;
    }
}
