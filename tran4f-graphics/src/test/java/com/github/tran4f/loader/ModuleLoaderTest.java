/*
 * Copyright 2015-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.tran4f.loader;

import com.github.tran4f.annotation.Argument;
import com.github.tran4f.domain.Settings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;

/**
 * <p>模块加载器测试。
 *
 * @author 王帅
 * @since 1.0
 */
@SpringBootTest(classes = YamlLoader.class)
class ModuleLoaderTest {

    @Autowired
    Settings settings;

    @Test
    void load() throws Exception {
        ModuleLoader.load(settings.getBasePath(), settings.getModules())
                .forEach((k, v) -> System.out.println("name:" + k + " <===> " + "prop:" + v.description()));
        Class<?> aClass = ModuleLoader.moduleLayer
                .findLoader("tran4f.config")
                .loadClass("com.github.tran4f.mode.Capacity");
        Field field = aClass.getDeclaredField("capacity");
        System.out.println(field.getAnnotation(Argument.class).value());
    }

}