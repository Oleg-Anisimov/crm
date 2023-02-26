package me.stepanov.crm.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import me.stepanov.crm.domain.BaseEntity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@UtilityClass
public class ReflectionUtil {

    public Set<Class> getEntityClasses(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, packageName))
                .filter(clazz -> clazz.getSuperclass().equals(BaseEntity.class))
                .collect(Collectors.toSet());
    }

    public Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage());
        }
        return null;
    }
}
