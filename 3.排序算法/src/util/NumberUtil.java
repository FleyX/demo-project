package util;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/5/17 17:15
 */
public class NumberUtil {

    public static int getRandom(int min, int max) {
        return (int) Math.ceil(min + Math.random() * (max - min));
    }


}
