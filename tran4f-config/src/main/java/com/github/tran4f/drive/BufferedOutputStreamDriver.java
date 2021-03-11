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

package com.github.tran4f.drive;

import com.github.tran4f.support.FileDriver;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <p>
 * 介绍信息
 *
 * @author 王帅
 * @since 1.0
 */
public class BufferedOutputStreamDriver extends FileDriver<BufferedOutputStream> {

    public BufferedOutputStreamDriver(String arg) throws IOException {
        super(arg);
    }

    public BufferedOutputStreamDriver(String parent, String child) throws IOException {
        super(parent, child);
    }

    @Override
    public void close() throws IOException {
        root.close();
    }

    @Override
    protected BufferedOutputStream build() throws IOException {
        return new BufferedOutputStream(new FileOutputStream(value));
    }
}
