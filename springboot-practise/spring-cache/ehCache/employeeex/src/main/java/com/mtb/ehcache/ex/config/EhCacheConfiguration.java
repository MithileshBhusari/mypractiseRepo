package com.mtb.ehcache.ex.config;

import org.aspectj.apache.bcel.util.ClassPath;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;

/**
 * @author MithileshB
 * @created 22/11/2021 - 10:41 PM
 * @project employeeex
 */
@EnableJpaRepositories(basePackages = "com.mtb.ehcache.ex.repository")
@EnableCaching
@Configuration
public class EhCacheConfiguration {

    @Bean
    public CacheManager cacheManager(){
        return new EhCacheCacheManager(cacheManagerFactory().getObject());
    }

    @Bean
    public EhCacheManagerFactoryBean cacheManagerFactory(){
        EhCacheManagerFactoryBean bean=new EhCacheManagerFactoryBean();
        bean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        bean.setShared(true);
        return bean;
    }
}
