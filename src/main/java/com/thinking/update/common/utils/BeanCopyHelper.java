package com.thinking.update.common.utils;

import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hanlizhi
 * @create 2017-11-06 20:25
 */

public class BeanCopyHelper {


    private static Map<String, BeanCopier> beanCopierMap = new ConcurrentHashMap<>();

    public static void copy(Object source, Object target) {
        if (source == null || target == null) {
            return;
        }
        Class sourceClass = source.getClass();
        Class targetClass = target.getClass();
        BeanCopier copier = getCopier(sourceClass, targetClass);
        copier.copy(source, target, null);
    }

    private static BeanCopier getCopier(Class sourceClass, Class targetClass) {
        String beanKey = generateKey(sourceClass, targetClass);
        BeanCopier copier = null;
        if (!beanCopierMap.containsKey(beanKey)) {
            copier = BeanCopier.create(sourceClass, targetClass, false);
            beanCopierMap.put(beanKey, copier);
        }
        return beanCopierMap.get(beanKey);

    }

    public static <T> List<T> copyList(List<?> sourceList, Class<?> clazzSource, Class<T> clazzTarget) {
        if (sourceList == null || sourceList.size() == 0) {
            return Collections.emptyList();
        } else {
            boolean sameClass = false;

            for (Object sourceItem : sourceList) {
                if (sourceItem != null) {
                    if (sourceItem.getClass() == clazzTarget) {
                        sameClass = true;
                    }
                    break;
                }
            }

            if (!sameClass) {

                List<T> tableClassResult = new ArrayList<>(sourceList.size());
                BeanCopier beanCopier = getCopier(clazzSource, clazzTarget);
                for (Object sourceItem : sourceList) {
                    try {
                        T targetObject = clazzTarget.newInstance();
                        beanCopier.copy(sourceItem, targetObject, null);
                        tableClassResult.add(targetObject);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
                return Collections.unmodifiableList(tableClassResult);
            }

        }
        return (List<T>) sourceList;
    }

    private static String generateKey(Class<?> class1, Class<?> class2) {
        return class1.toString() + class2.toString();
    }
}
