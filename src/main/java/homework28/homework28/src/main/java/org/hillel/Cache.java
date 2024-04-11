package org.hillel;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cache {
    private static final Logger LOGGER = LoggerFactory.getLogger("logger.info");
    private static Map<String, Map<String, Object>> cache = new HashMap<>();
    public static boolean isCacheExist(String cache) {
        return Cache.cache.get(cache) != null;
    }

    public static Object get(String cache, String key) {
        if (isCacheExist(cache)  &&
                Cache.cache.get(cache).get(key) != null) {
            Object obj = Cache.cache.get(cache).get(key);
            LOGGER.info("We received object from cache '{}' with key '{}'", cache, key);

            return obj;
        }
        return null;
    }

    public static boolean put(String cache, String key, Object o) {
        if (isCacheExist(cache)) {
            Cache.cache.get(cache).put(key, o);
        } else {
            Cache.cache.put(cache, new HashMap<>());
            Cache.cache.get(cache).put(key, o);
            LOGGER.info("We created cache '{}'", cache);
        }
        LOGGER.info("We added object  to cache: '{}'", cache);
        return true;
    }


    public static void clear() {
        cache.clear();
        LOGGER.info("We deleted all caches");
    }


}