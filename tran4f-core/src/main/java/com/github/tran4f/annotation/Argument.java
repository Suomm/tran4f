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

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.RECORD_COMPONENT;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 用于在配置界面中显示对标记属性的描述。
 * 
 * @author	王帅
 * @since	1.0
 */
@Documented
@Retention(RUNTIME)
@Target({FIELD, RECORD_COMPONENT})
public @interface Argument {

	/**
	 * 调用该方法会返回对属性的描述信息。
	 * 
	 * @return 属性的描述
	 */
	String value();
	
}
