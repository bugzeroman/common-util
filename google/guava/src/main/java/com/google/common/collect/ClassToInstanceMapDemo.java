package com.google.common.collect;

/**
 * Class作为Key, 对应实例作为Value的数据结构，
 * 消除了元素类型转换的过程，
 * 并保证了元素在Map中是类型安全的。
 */
public class ClassToInstanceMapDemo {
    public static void main(String[] args) {
        // createMutableClassToInstanceMap();
        ClassToInstanceMap<Number> map = new ImmutableClassToInstanceMap.Builder<Number>().put(Integer.class, 100)
                .put(Float.class, 10.01f).build();

        System.out.println(map.getInstance(Integer.class));
        System.out.println(map.getInstance(Float.class));

        // 不可变map只能在builder时设置参数，
        // 如果创建好后，继续使用putInstance会抛出异常
        // throws UnsupportedOperationException
        // map.putInstance(Integer.class, 1000);
    }

    // 创建可变的map映射
    public static void createMutableClassToInstanceMap() {
        ClassToInstanceMap<Number> numbers = MutableClassToInstanceMap.create();
        numbers.putInstance(Integer.class, Integer.valueOf(1));
        numbers.putInstance(Long.class, Long.valueOf(2));
        numbers.putInstance(Long.class, Long.valueOf(3));
        System.out.println(numbers.getInstance(Integer.class));
        System.out.println(numbers.getInstance(Long.class));
    }
}
