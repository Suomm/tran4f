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

import java.io.Serial;

/**
 * 用户自定义异常，用于提示用户错误原因。
 * 
 * @author	王帅
 * @since	1.0
 */
public class Tran4fException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = -1456552599741488702L;
	
	/**
	 * 用 {@code null} 作为其详细消息构造一个新的运行时异常。
	 * 原因尚未被初始化，可在以后通过调用 {@link #initCause(Throwable)} 对其进行初始化。
	 */
	public Tran4fException() {
		super(null, null, false, false);
	}
	
	/**
	 * 用指定的详细消息构造一个新的运行时异常。
	 * 原因尚未被初始化，可在以后通过调用 {@link #initCause(Throwable)} 对其进行初始化。
	 * 
	 * @param message 详细消息。保存详细消息以便以后通过 {@link #getMessage()} 方法获取它。
	 */
	public Tran4fException(String message) {
		super(message, null, false, false);
	}

	/**
	 * 用指定的原因和详细消息  <tt>(cause==null ? null : cause.toString())</tt>
	 * 构造一个新的运行时异常（它通常包含类和 <tt>cause</tt> 的详细消息）。
	 * 该构造方法对于那些与其他可抛出异常的包装器一样的运行时异常来说很有用。
	 * 
	 * @param cause 原因（保存此原因，以便以后通过 {@link #getCause()} 方法获取它）。
	 * 				（允许使用 <tt>null</tt> 值，这表明原因不存在或是未知的。）
	 */
	public Tran4fException(Throwable cause) {
		super(null, cause, false, false);
	}

	/**
	 * <p>
	 * 用指定的详细消息和原因构造一个新的运行时异常。
	 * 
	 * <p>
	 * 注意，与 {@code cause} 相关的详细消息<b>不</b>会自动地合并到此运行时异常的详细消息中。
	 * 
	 * @param message 详细消息。保存详细消息以便以后通过 {@link #getMessage()} 方法获取它。
	 * @param cause	原因（保存此原因，以便以后通过 {@link #getCause()} 方法获取它）。
	 * 				（允许使用 <tt>null</tt> 值，这表明原因不存在或是未知的。）
	 */
	public Tran4fException(String message, Throwable cause) {
		super(message, cause, false, false);
	}

}
