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

package com.github.tran4f.annotation;

import com.github.tran4f.support.Type;

import java.lang.annotation.*;

/**
 * 程序包的类别。
 * 
 * @author 王帅
 * @since  1.0
 * @see    Type
 */
@Documented
@Target(ElementType.PACKAGE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Engine {

	/**
	 * 返回该分组的程序类型描述。
	 *
	 * @return 程序包的功能描述
	 */
	String name();
	
	/**
	 * 获取该程序包分组的操作类型模式。
	 * 
	 * @return 操作模式
	 */
	Type type();
	
}
