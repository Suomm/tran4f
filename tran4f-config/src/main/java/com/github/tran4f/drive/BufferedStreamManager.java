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

import com.github.tran4f.support.Driver;
import com.github.tran4f.support.Manager;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

/**
 * <p>
 * 介绍信息
 *
 * @author 王帅
 * @since 1.0
 */
public class BufferedStreamManager
        implements Manager<BufferedInputStream, BufferedOutputStream> {

    @Override
    public Driver<BufferedInputStream> source(String arg) throws IOException {
        return new BufferedInputStreamDriver(arg);
    }

    @Override
    public Driver<BufferedInputStream> source(String parent, String child) throws IOException {
        return new BufferedInputStreamDriver(parent, child);
    }

    @Override
    public Driver<BufferedOutputStream> target(String arg) throws IOException {
        return new BufferedOutputStreamDriver(arg);
    }

    @Override
    public Driver<BufferedOutputStream> target(String parent, String child) throws IOException {
        return new BufferedOutputStreamDriver(parent, child);
    }

}
