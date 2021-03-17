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

import com.github.tran4f.annotation.Property;

import java.lang.module.Configuration;
import java.lang.module.FindException;
import java.lang.module.ModuleFinder;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>模块加载。
 *
 * @author 王帅
 * @since 1.0
 */
public final class ModuleLoader {

    private ModuleLoader() {
    }

    /**
     * 根据模块名称，加载模块。
     *
     * @param basePath 模块所在路径
     * @param names 模块名称
     * @return 加载之后的信息
     * @exception FindException 模块加载失败
     */
    public static Map<String, Property> load(Collection<String> basePath, Collection<String> names) {
        ModuleFinder finder = ModuleFinder.of(basePath.stream().map(Path::of).toArray(Path[]::new));
        ModuleLayer parent = ModuleLayer.boot();
        Configuration cf = parent.configuration().resolve(finder, ModuleFinder.of(), names);
        ClassLoader scl = ClassLoader.getSystemClassLoader();
        ModuleLayer layer = parent.defineModulesWithOneLoader(cf, scl);
        return layer.modules()
                .stream()
                .collect(Collectors.toMap(Module::getName, e -> e.getAnnotation(Property.class)));
    }

}
