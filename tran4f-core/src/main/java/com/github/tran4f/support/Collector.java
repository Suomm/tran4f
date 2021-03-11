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
 * 文件收集操作。
 * 
 * @author	王帅
 * @since	1.0
 * @param <S> 输入
 * @param <T> 输出
 */
public interface Collector<S, T> extends Context {
	
	/**
	 * 
	 * @param source 源文件
	 * @throws Tran4fException 用于提示用户的异常
	 */
	void doFork(S source) throws Tran4fException;
	
	/**
	 * 目标目录。
	 * 
	 * @param target 目标目录
	 * @throws Tran4fException 用于提示用户的异常
	 */
	void doJoin(T target) throws Tran4fException;

}
