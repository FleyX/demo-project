package com.fxb.licensingservice.event;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/2/22 16:53
 */
public interface CustomOutput {

    @Output("customOutput")
    MessageChannel out();
}
