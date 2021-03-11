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

package com.github.tran4f.mode;

import com.github.tran4f.annotation.Binding;
import com.github.tran4f.drive.BufferedStreamManager;
import com.github.tran4f.support.Driver;
import com.github.tran4f.support.Executor;
import com.github.tran4f.support.Tran4fException;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Serial;
import java.io.Serializable;

/**
 * 使用基本 Java IO 操作的文件读写类。
 *
 * @author 王帅
 */
@Binding(name = "常规复制", details = "常规的字节读写操作", argument = Capacity.class, manager = BufferedStreamManager.class)
public final class IOExecutor
		implements Executor<BufferedInputStream, BufferedOutputStream>, Serializable {

	@Serial
	private static final long serialVersionUID = -4415471203620584629L;

	/**
	 * 定义的容量大小，默认为：1024。
	 */
	private Capacity args;

	@Override
	public void handle(Driver<BufferedInputStream> source, Driver<BufferedOutputStream> target) throws Tran4fException {
		System.out.println("handle(Driver<BufferedInputStream> source, Driver<BufferedOutputStream> target)");
	}

}
