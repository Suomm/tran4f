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

package com.github.tran4f.service;

/**
 * <p>
 * 2021/2/23
 * </p>
 *
 * @author 王帅
 * @since 1.0
 */
public interface FileService extends Runnable {

    /** 复制 */
    int COPY    = 0;
    /** 删除 */
    int DELETE  = 1;
    /** 移动 */
    int MOVE    = 2;
    /** 跳过 */
    int SKIP    = 3;
    /** 替换 */
    int REPLACE = 4;
    /** 新建 */
    int CREATE  = 5;
    /** 整合 */
    int MERGE   = 6;
    /** 修改 */
    int REVISE  = 7;
    /** 加密 */
    int ENCRYPT = 8;

    String getMessage();

}
