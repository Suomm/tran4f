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

import com.github.tran4f.support.Empty;
import com.github.tran4f.support.FileManager;
import com.github.tran4f.support.Manager;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 程序执行类与驱动管理的绑定注解。
 * 
 * @author	王帅
 * @since	1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Binding {
	
	/**
	 * 实际操作类的名称。
	 * 
	 * @return 操作方式名称
	 */
	String name();
	
	/**
	 * 实际操作类的描述信息。
	 * 
	 * @return 描述
	 */
	String details() default "";
	
	/**
	 * 实际操作类的配置对象。
	 * 
	 * @return 配置对象
	 */
	Class<?> argument() default Empty.class;

	/**
	 * 驱动管理者。
	 *
	 * @return 驱动管理
	 */
	Class<? extends Manager> manager() default FileManager.class;

}
