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
 * @since  1.0
 */
@SuppressWarnings("rawtypes")
public class FileManager implements Manager {

    @Override
    public Driver source(String arg) throws IOException {
        return new FileDriverImpl(arg);
    }

    @Override
    public Driver source(String parent, String child) throws IOException {
        return new FileDriverImpl(parent, child);
    }

    @Override
    public Driver target(String arg) throws IOException {
        return new FileDriverImpl(arg);
    }

    @Override
    public Driver target(String parent, String child) throws IOException {
        return new FileDriverImpl(parent, child);
    }

    private static class FileDriverImpl extends FileDriver<File> {

        public FileDriverImpl(String arg) throws IOException {
            super(arg);
        }

        public FileDriverImpl(String parent, String child) throws IOException {
            super(parent, child);
        }

        @Override
        public void reset(String arg) {
            this.root = new File(arg);
        }

        @Override
        public void reset(String parent, String child) {
            this.root = new File(parent, child);
        }

        @Override
        public boolean rename(String name) {
            return this.root.renameTo(new File(this.root.getParent(), name));
        }

        @Override
        public void close() {
        }

        @Override
        public boolean delete() {
            if (this.root.exists())
                return this.root.delete();
            else
                return false;
        }

        @Override
        public boolean exists() {
            return this.root.exists();
        }

        @Override
        public String name() {
            return this.root.getName();
        }

        @Override
        public String value() {
            return this.root.getAbsolutePath();
        }

        @Override
        public String parent() {
            return this.root.getParent();
        }

        @Override
        public boolean isDirectory() {
            return this.root.isDirectory();
        }

        @Override
        public String[] list() {
            return this.root.list();
        }

        @Override
        protected File build() {
            return null;
        }
    }

}
