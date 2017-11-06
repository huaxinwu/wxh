/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * 1.@Target：Annotation可被用于 packages、types（类、接口、枚举、Annotation类型）、
 * 类型成员（方法、构造方法、成员变量、枚举值）、方法参数和本地变量（如循环变量、catch参数）。
 * 在Annotation类型的声明中使用了target可更加明晰其修饰的目标。
 * 2.@Retention:某些Annotation仅出现在源代码中，而被编译器丢弃；而另一些却被编译在class文件中；
 * 编译在class文件中的Annotation可能会被虚拟机忽略，而另一些在class被装载时将被读取
 * （请注意并不影响class的执行，因为Annotation与class在使用上是被分离的）。
 * 使用这个meta-Annotation可以对 Annotation的“生命周期”限制
 * 3.@Documented:用于描述其它类型的annotation应该被作为被标注的程序成员的公共API，因此可以被例如javadoc此类的工具文档化。Documented是一个标记注解，没有成员。
 * 4.@Inherited:阐述了某个被标注的类型是被继承的
 * @author wxh
 * @version $Id: NotThreadSafe.java, v 0.1 2017年10月23日 下午4:20:21 wxh Exp $
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotThreadSafe {
    /**
     * 取值(ElementType)有：
    *　1.CONSTRUCTOR:用于描述构造器
    *　2.FIELD:用于描述域
    *　3.LOCAL_VARIABLE:用于描述局部变量
    *　4.METHOD:用于描述方法
    *　5.PACKAGE:用于描述包
    *　6.PARAMETER:用于描述参数
    *　7.TYPE:用于描述类、接口(包括注解类型) 或enum声明
     *
     * @return
     */

    String value() default "";
}
