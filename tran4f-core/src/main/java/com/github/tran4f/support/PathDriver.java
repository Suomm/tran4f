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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * <p>
 * 介绍信息
 *
 * @author 王帅
 * @since 1.0
 */
public non-sealed abstract class PathDriver<T> extends Driver<T> {

    protected Path value;

    protected PathDriver(String arg) throws IOException {
        super(arg);
    }

    protected PathDriver(String parent, String child) throws IOException {
        super(parent, child);
    }

    @Override
    public void reset(String arg) throws IOException {
        this.value = Path.of(arg);
        if (!Files.isDirectory(value))
            super.root = build();
    }

    @Override
    public void reset(String parent, String child) throws IOException {
        this.value = Path.of(parent, child);
        if (!Files.isDirectory(value))
            super.root = build();
    }

    @Override
    public boolean rename(String name) {
        try {
            Files.move(this.value, this.value.resolve(name), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete() {
        try {
            return Files.deleteIfExists(value);
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public boolean exists() {
        return Files.exists(value);
    }

    @Override
    public String name() {
        return this.value.getFileName().toString();
    }

    @Override
    public String value() {
        return this.value.toString();
    }

    @Override
    public String parent() {
        return this.value.getParent().toString();
    }

    @Override
    public boolean isDirectory() {
        return Files.isDirectory(value);
    }

    @Override
    public String[] list() {
        try {
            return Files.list(value).toArray(String[]::new);
        } catch (IOException e) {
            return new String[]{};
        }
    }

}
