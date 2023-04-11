package com.agentp.cepp.utils;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn;

import java.util.List;


/**
 * MyBats-Plus在一开始就给大家提供了很多通用的方法，
 * 在DefaultSqlInjector这个类中，在MethodList这个集合当中包含的都是通用方法类，
 * 如果想要使用自定义通用方法，也需要添加到这个集合当中。
 *
 * 自定义自己的通用方法可以实现接口 ISqlInjector
 * 也可以继承抽象类 AbstractSqlInjector 注入通用方法 SQL 语句
 * 然后继承 BaseMapper 添加自定义方法，
 * 全局配置 sqlInjector 注入 MP 会自动将类所有方法注入到 mybatis 容器中。
 *
 * 根据MybatisPlus 的 DefaultSqlInjector 和 AbstractMethod 可以自定义各种你想要的 sql ,注入到全局中，
 * 相当于自定义 Mybatisplus 自动注入的方法。
 * 之前需要在 xml 中进行配置的 SQL 语句，
 * 现在通过扩展 DefaultSqlInjector 和 AbstractMethod在加载 mybatis 环境时就注入。
 */
//sql注入器
//AlwaysUpdateSomeColumnById 根据Id更新每一个字段，全量更新不忽略null字段，解决mybatis-plus中updateById默认会自动忽略实体中null值字段不去更新的问题。
//InsertBatchSomeColumn 真实批量插入，通过单SQL的insert语句实现批量插入
//DeleteByIdWithFill 带自动填充的逻辑删除，比如自动填充更新时间、操作人
//Upsert 更新or插入，根据唯一约束判断是执行更新还是删除，相当于提供insert on duplicate key update支持

public class MySqlInjector extends DefaultSqlInjector {
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);
        methodList.add(new InsertBatchSomeColumn());//添加批量插入方法
        return methodList;
    }
}
