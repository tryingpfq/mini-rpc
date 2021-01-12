package com.mini.rpc.common;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import lombok.Data;

import java.io.Serializable;

@Data
@ProtobufClass
public class MiniRpcResponse implements Serializable {
    @Protobuf(description = "结果")
    private Object data;
    @Protobuf(description = "异常消息")
    private String message;
}
