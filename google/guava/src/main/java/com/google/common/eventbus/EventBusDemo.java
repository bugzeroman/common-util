package com.google.common.eventbus;

/**
 * 1.EventBus 同步阻塞模式
 * 2.AsyncEventBus 异步非阻塞模式
 *
 * 基于 EventBus，不需要定义 Observer接口，
 * 任意类型的对象都可以注册到 EventBus中，
 * 通过 @Subscribe 注解来标明类中哪个函数可以接收被观察者发送的消息。
 *
 *Demo:用户注册后，通过观察者模式，发送邮件通知，以及发送优惠券等
 */
public class EventBusDemo {

}
