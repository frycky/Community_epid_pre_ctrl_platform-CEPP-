package com.agentp.cepp.configs;

import com.agentp.cepp.utils.MySqlInjector;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class MPConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }
    //多数据源时建议开启
//    @Bean
//    public MybatisSqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
//        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
//        //获取mybatis-plus全局配置
//        GlobalConfig globalConfig = GlobalConfigUtils.defaults();
//        //mybatis-plus全局配置设置元数据对象处理器为自己实现的那个
//        globalConfig.setMetaObjectHandler(new MyMetaObjectHandler());
//        mybatisSqlSessionFactoryBean.setDataSource(dataSource);
//        //mybatisSqlSessionFactoryBean关联设置全局配置
//        mybatisSqlSessionFactoryBean.setGlobalConfig(globalConfig);
//        return mybatisSqlSessionFactoryBean;
//    }

    @Bean
//    @Primary
    //批量插入配置
    public MySqlInjector mySqlInjector(){
        return new MySqlInjector();
    }

}
