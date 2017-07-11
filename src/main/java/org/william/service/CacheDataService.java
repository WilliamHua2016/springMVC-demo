package org.william.service;

/**
 * Created by huawai on 2017/7/11.
 * Description:
 */
public class CacheDataService {

    public<T> void testCacheData(T cacheDataParam){
        System.out.println("test @CacheData annotation  success!! @CacheDAtaParam:"+cacheDataParam);
    }
}
