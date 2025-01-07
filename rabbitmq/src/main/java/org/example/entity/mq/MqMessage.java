package org.example.entity.mq;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class MqMessage implements Serializable {
    private static final long serialVersionUID = -4465394232288598749L;
    private String name;
    private String code;
}
