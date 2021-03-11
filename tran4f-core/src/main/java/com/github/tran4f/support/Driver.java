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

/**
 * <p>
 * 文件驱动。
 *
 * @author 王帅
 * @since  1.0
 * @param <T> 类型
 * @see FileDriver
 * @see PathDriver
 * @see Manager
 */
public sealed abstract class Driver<T> implements AutoCloseable permits FileDriver, PathDriver {

    /**
     * 根。
     */
    protected T root;

    /**
     *
     *
     * @param arg 参数
     * @throws IOException 如果发生 I/O 错误
     */
    protected Driver(String arg) throws IOException {
        this.reset(arg);
    }

    /**
     *
     * @param parent 父
     * @param child  子
     * @throws IOException 如果发生 I/O 错误
     */
    protected Driver(String parent, String child) throws IOException {
        this.reset(parent, child);
    }

    /**
     * 获取链接的值。
     *
     * @return 链接源
     */
    public T get() {
        return root;
    }

    @Override
    public String toString() {
        return this.value();
    }

    /**
     * 重命名文件
     * @param name 新文件名称
     * @return
     */
    public abstract boolean rename(String name);

    /**
     *
     * @param arg 参数
     * @throws IOException 如果发生 I/O 错误
     */
    public abstract void reset(String arg) throws IOException;

    /**
     *
     * @param parent 父
     * @param child  子
     * @throws IOException 如果发生 I/O 错误
     */
    public abstract void reset(String parent, String child) throws IOException;

    /**
     * 关闭此资源，放弃任何潜在资源。
     *
     * @throws IOException 如果发生 I/O 错误
     */
    public abstract void close() throws IOException;

    /**
     * 删除文件。
     *
     * @return {@code true}如果文件被该方法删除；{@code false}如果文件不存在，则无法删除
     */
    public abstract boolean delete();

    /**
     * 测试文件是否存在。
     *
     * @return {@code true}如果文件存在；{@code false}如果文件不存在或其存在无法确定
     */
    public abstract boolean exists();

    /**
     *
     *
     * @return 名称
     */
    public abstract String name();

    /**
     *
     * @return 值
     */
    public abstract String value();

    /**
     *
     * @return 父组件
     */
    public abstract String parent();

    /**
     * 测试文件是否包含其他元素。
     *
     * @return {@code true}如果文件是一个目录；{@code false}如果该文件不存在，不是一个目录，或者该文件是否是目录无法确定
     */
    public abstract boolean isDirectory();

    /**
     * 打开一个目录，返回一个数组来迭代目录中的所有条目。
     *
     * @return 其下的所有元素
     * @exception IOException 如果发生 I/O 错误
     */
    public abstract String[] list() throws IOException;

    /**
     * 构建根。
     *
     * @return 构建成功的根
     * @throws IOException 如果发生 I/O 错误
     */
    protected abstract T build() throws IOException;

}
