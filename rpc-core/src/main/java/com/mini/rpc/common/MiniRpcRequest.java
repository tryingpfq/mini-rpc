package com.mini.rpc.common;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import lombok.Data;

import java.io.Serializable;

@Data
@ProtobufClass
public class MiniRpcRequest implements Serializable {
    @Protobuf(description = "版本号")
    private String serviceVersion;

    @Protobuf(description = "服务类名")
    private String className;

    @Protobuf(description = "方法名")
    private String methodName;

    @Protobuf(description = "参数")
    private Object[] params;

    @Protobuf(description = "参数类型")
    private Class<?>[] parameterTypes;
}
