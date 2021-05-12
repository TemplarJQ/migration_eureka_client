package com.service;

public interface OpLogService {

    // 尚未决定采取何种日志打点方式，一般情况直接本地节点写sql即可。
    // 多节点可以发Kafka到离线日志中心统一处理，这个部分需要再看下，先写为空Bean。
}
