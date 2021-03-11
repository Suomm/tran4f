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
 * @since  1.0
 */
@SuppressWarnings("rawtypes")
public class PathManager implements Manager {

    @Override
    public Driver source(String arg) throws IOException {
        return new PathDriverImpl(arg);
    }

    @Override
    public Driver source(String parent, String child) throws IOException {
        return new PathDriverImpl(parent, child);
    }

    @Override
    public Driver target(String arg) throws IOException {
        return new PathDriverImpl(arg);
    }

    @Override
    public Driver target(String parent, String child) throws IOException {
        return new PathDriverImpl(parent, child);
    }

    private static class PathDriverImpl extends PathDriver<Path> {

        public PathDriverImpl(String arg) throws IOException {
            super(arg);
        }

        public PathDriverImpl(String parent, String child) throws IOException {
            super(parent, child);
        }

        @Override
        public void reset(String arg) {
            this.root = Path.of(arg);
        }

        @Override
        public void reset(String parent, String child) {
            this.root = Path.of(parent, child);
        }

        @Override
        public void close() {
        }

        @Override
        public boolean delete() {
            try {
                return Files.deleteIfExists(root);
            } catch (IOException e) {
                return false;
            }
        }

        @Override
        public boolean exists() {
            return Files.exists(root);
        }

        @Override
        public String name() {
            return this.root.getFileName().toString();
        }

        @Override
        public boolean rename(String name) {
            try {
                Files.move(this.root, this.root.resolve(name), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }

        @Override
        public String value() {
            return this.root.toString();
        }

        @Override
        public String parent() {
            return this.root.getParent().toString();
        }

        @Override
        public boolean isDirectory() {
            return Files.isDirectory(root);
        }

        @Override
        public String[] list() {
            try {
                return Files.list(root).map(Path::toString).toArray(String[]::new);
            } catch (IOException e) {
                return new String[]{ };
            }
        }

        @Override
        protected Path build() {
            return null;
        }
    }

}
