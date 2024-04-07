package com.fanxb.common.p100;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        List<String> strs = Stream.of(path.split("/+")).filter(item -> !item.isEmpty()).collect(Collectors.toList());
        for (String str : strs) {
            switch (str) {
                case ".":
                    break;
                case "..":
                    if (!stack.isEmpty()) stack.pop();
                    break;
                default:
                    stack.push(str);
            }
        }
        return stack.isEmpty() ? "/" : stack.stream().map(item -> "/" + item).collect(Collectors.joining());
    }
}
