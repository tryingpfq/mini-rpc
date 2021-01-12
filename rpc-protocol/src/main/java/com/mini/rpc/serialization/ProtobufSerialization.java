package com.mini.rpc.serialization;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * protobuf
 *
 * @author tryingpfq
 * @date 2021/1/12
 **/
public class ProtobufSerialization implements RpcSerialization {

    private static final Map<String, Codec> codecCache = new ConcurrentHashMap<>();

    public static Codec getOrCreate(Class<?> clazz) {
        String simpleName = clazz.getSimpleName();
        return codecCache.computeIfAbsent(simpleName, s -> ProtobufProxy.create(clazz));
    }

    @Override
    public <T> byte[] serialize(T obj) throws IOException {
        Codec codec = getOrCreate(obj.getClass());
        return codec.encode(obj);
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clz) throws IOException {
        Codec codec = getOrCreate(clz);
        return (T) codec.decode(data);
    }
}
