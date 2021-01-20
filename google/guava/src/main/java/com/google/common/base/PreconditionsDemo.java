package com.google.common.base;

/**
 * 前置条件判断
 * @author yuwen
 *
 */
public class PreconditionsDemo {
    public static void main(String[] args) {
        // checkArgumentTest();
        // checkNotNullTest();
        // checkStateTest();
        checkElementIndexTest();
    }

    /**
     * 检查 index 作为索引值对某个列表、字符串或数组是否有效。
     * index>=0 && index<size *
     */
    public static void checkElementIndexTest() {
        int index = 1;
        int size = 9;
        Preconditions.checkElementIndex(index, size);
        index = 10;
        Preconditions.checkElementIndex(index, size);
    }

    /**
     * 检查状态是否为true，否则抛出IllegalStateException异常，
     * 和checkArgument的区别在于，抛出的异常不一样为IllegalArgumentException
     */
    public static void checkStateTest() {
        Boolean state = true;
        Preconditions.checkState(state, "state [%s] should be true", state);
        state = false;
        Preconditions.checkState(state, "state [%s] should be true", state);
    }

    /*
     * 检查参数是否为null
     */
    public static void checkNotNullTest() {
        String name = "";
        // 能够将参数返回给调用者，也可以忽略返回参数
        name = Preconditions.checkNotNull(name);
        name = null;
        Preconditions.checkNotNull(name, "the name [%s] should not be null", name);
    }

    /**
     * 检查表达式是否为true,每个方法都有三个变种。
     */
    public static void checkArgumentTest() {
        int i = 3;
        // 1.没有额外参数：抛出的异常中没有错误消息
        Preconditions.checkArgument(i > 0);
        // 2.有一个 Object 对象作为额外参数：抛出的异常使用 Object.toString()作为错误消息
        Preconditions.checkArgument(i > 0, i);
        // 3.有一个 String 对象作为额外参数，并且有一组任意数量的附加 Object对象，只支持%s 指示符
        Preconditions.checkArgument(i > 0, "Expected %s greater than 0", i);

        i = -3;
        // Preconditions.checkArgument(i > 0);
        // Preconditions.checkArgument(i > 0, i);
        Preconditions.checkArgument(i > 0, "Expected %s greater than 0", i);
    }
}
