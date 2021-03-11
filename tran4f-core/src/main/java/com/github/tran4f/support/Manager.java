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
 * 驱动管理
 *
 * @author 王帅
 * @since  1.0
 * @param <S> 输入驱动
 * @param <T> 输出驱动
 */
public interface Manager<S, T> {

    /**
     *
     * @param arg 参数
     * @return 驱动
     * @throws IOException 如果发生 I/O 错误
     */
    Driver<S> source(String arg) throws IOException;

    /**
     *
     * @param parent 父
     * @param child  子
     * @return 驱动
     * @throws IOException 如果发生 I/O 错误
     */
    Driver<S> source(String parent, String child) throws IOException;

    /**
     *
     * @param arg 参数
     * @return 驱动
     * @throws IOException 如果发生 I/O 错误
     */
    Driver<T> target(String arg) throws IOException;

    /**
     *
     * @param parent 父
     * @param child  子
     * @return 驱动
     * @throws IOException 如果发生 I/O 错误
     */
    Driver<T> target(String parent, String child) throws IOException;

}
