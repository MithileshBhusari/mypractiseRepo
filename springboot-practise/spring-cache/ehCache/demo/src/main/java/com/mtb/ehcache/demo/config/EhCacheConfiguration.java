package com.mtb.ehcache.demo.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author MithileshB
 * @created 20/11/2021 - 7:40 PM
 * @project demo
 */

@EnableJpaRepositories(basePackages = "com.mtb.ehcache.demo.repository")
@EnableCaching
@Configuration
public class EhCacheConfiguration {

    @Bean
    public CacheManager cacheManager(){
        return new EhCacheCacheManager(cacheManagerFactory().getObject());
    }

    @Bean
    public EhCacheManagerFactoryBean cacheManagerFactory() {
        EhCacheManagerFactoryBean bean=new EhCacheManagerFactoryBean();
        bean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        bean.setShared(true);
        return bean;
    }
}
