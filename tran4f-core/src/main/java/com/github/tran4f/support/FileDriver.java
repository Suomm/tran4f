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

package com.github.tran4f.support;

import java.io.File;
import java.io.IOException;

/**
 * <p>
 * 介绍信息
 *
 * @author 王帅
 * @since 1.0
 * @param <T> 类型
 */
public non-sealed abstract class FileDriver<T> extends Driver<T> {

    protected File value;

    protected FileDriver(String arg) throws IOException {
        super(arg);
    }

    protected FileDriver(String parent, String child) throws IOException {
        super(parent, child);
    }

    @Override
    public void reset(String arg) throws IOException {
        this.value = new File(arg);
        if (value.isFile())
            this.root = build();
    }

    @Override
    public void reset(String parent, String child) throws IOException {
        this.value = new File(parent, child);
        if (value.isFile())
            this.root = build();
    }

    @Override
    public boolean delete() {
        return this.value.delete();
    }

    @Override
    public boolean exists() {
        return value.exists();
    }

    @Override
    public String name() {
        return this.value.getName();
    }

    @Override
    public String value() {
        return this.value.getAbsolutePath();
    }

    @Override
    public boolean rename(String name) {
        return this.value.renameTo(new File(this.value.getParent(), name));
    }

    @Override
    public String parent() {
        return this.value.getParent();
    }

    @Override
    public boolean isDirectory() {
        return value.isDirectory();
    }

    @Override
    public String[] list() {
        return value.list();
    }

}
