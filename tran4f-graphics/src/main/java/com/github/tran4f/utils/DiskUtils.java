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

package com.github.tran4f.utils;

/**
 * 磁盘工具类。
 *
 * @author 王帅
 * @since 1.0
 */
public final class DiskUtils {

    private DiskUtils() {
    }

    static {
        System.loadLibrary("./deployment");
    }

    /**
     * 判断设备是否为U盘。
     *
     * @param symbol 盘符
     * @return {@code true} U盘，{@code false} 其他类型磁盘
     */
    public static native boolean isUSBDriver(char symbol);

}
