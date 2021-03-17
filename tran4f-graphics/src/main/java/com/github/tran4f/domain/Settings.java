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

package com.github.tran4f.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * <p>封装配置信息。
 *
 * @author 王帅
 * @since 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Settings {

    /** 模块名称（默认模块 {@code tran4f.config}） */
    private Set<String> modules;
    /** 读取模块的路径位置（默认位置 {@code ./}） */
    private Set<String> basePath;

    /**
     * 初始化一些基本的配置。
     *
     * @return {@code this}
     */
    public Settings init() {
        if (modules == null) modules = new LinkedHashSet<>();
        if (basePath == null) basePath = new LinkedHashSet<>();
        // 基本的配置
        modules.add("tran4f.config");
        basePath.add("./");
        return this;
    }

}
