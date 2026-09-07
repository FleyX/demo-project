package com.fanxb.common.p100;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 *
 * @author fanxb
 * Date: 2020/6/10 10:49
 */
public class Q13 {
    private static Map<Character, Integer> map = new HashMap<>(7);

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        int res = 0;
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            int cur = map.get(chars[i]), next = i == length - 1 ? 0 : map.get(chars[i + 1]);
            if (cur < next) {
                res += next - cur;
                i++;
            } else {
                res += cur;
            }
        }
        return res;
    }

    public int romanToInt1(String s) {
        String[] sArr = s.split("");
        int res=0;
        for(int i=0;i<sArr.length;i++){
            switch(sArr[i]){
                case "I":
                    if(i<sArr.length-1){
                        if(sArr[i+1]=="V"){
                            res+=4;
                            i++;
                            break;
                        }else if(sArr[i+1]=="X"){
                            res+=9;
                            i++;
                            break;
                        }
                    }
                    res+=1;
                    break;
                case "V":
                    res+=5;
                    break;
                case "X":
                    if(i<sArr.length-1){
                        if(sArr[i+1]=="L"){
                            res+=40;
                            i++;
                            break;
                        }else if(sArr[i+1]=="C"){
                            res+=90;
                            i++;
                            break;
                        }
                    }
                    res+=10;
                    break;
                case "L":
                    res+=50;
                    break;
                case "C":
                    if(i<sArr.length-1){
                        if(sArr[i+1]=="D"){
                            res+=400;
                            i++;
                            break;
                        }else if(sArr[i+1]=="M"){
                            res+=900;
                            i++;
                            break;
                        }
                    }
                    res+=100;
                    break;
                case "D":
                    res+=500;
                    break;
                case "M":
                    res+=1000;
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Q13 instance = new Q13();
        System.out.println(instance.romanToInt1("MCMXCIV"));
    }
}
