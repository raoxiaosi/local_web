package com.rao.dao.resource;


import pojo.entity.resource.ResourceLocationsConfig;

import java.util.List;
import java.util.Map;

/**
 * DAO - ResourceLocationsConfig(本地映射路径配置)
 * 
 * @author zijing
 * @version 2.0
 */
public interface ResourceLocationsConfigDao{

    ResourceLocationsConfig find(Integer id);

    List<ResourceLocationsConfig> findAll();

    Integer count(Map<String, Object> var1);

    Integer insert(ResourceLocationsConfig resourceLocationsConfig);

    Integer update(ResourceLocationsConfig resourceLocationsConfig);

    Integer delete(Integer id);

    Integer deleteAll(Map<String, Object> var1);

    List<ResourceLocationsConfig> findByParams(Map<String, Object> var1);

    /**
     * insertSelective
     * @param resourceLocationsConfig
     * @return
     */
    Integer insertSelective(ResourceLocationsConfig resourceLocationsConfig);

}
