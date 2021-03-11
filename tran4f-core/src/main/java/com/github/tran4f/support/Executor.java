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

/**
 * 文件操作的可拓展接口。
 * 
 * @author 王帅
 */
public interface Executor<S, T> extends Context {
	
	/**
	 * 执行文件操作。
	 * 
	 * @param source 导入文件驱动
	 * @param target 导出文件驱动
	 * @throws Tran4fException 用于提示用户的异常
	 */
	void handle(Driver<S> source, Driver<T> target) throws Tran4fException;
	
}
