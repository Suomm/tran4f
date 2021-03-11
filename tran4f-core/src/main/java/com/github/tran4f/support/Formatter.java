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
 * 对文件名的格式化。
 * 
 * @author 王帅
 * @since  1.0
 */
public interface Formatter extends Context {

	/**
	 * 格式化文件名。
	 *
	 * @param name 原有文件名
	 * @return 格式化后的文件名
	 * @throws Tran4fException 用于提示用户的异常
	 */
	String format(String name) throws Tran4fException;

}
