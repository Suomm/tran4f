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

import static java.lang.annotation.ElementType.MODULE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 拓展模块的描述信息。
 *
 * @author 王帅
 * @since  1.0
 */
@Documented
@Target(MODULE)
@Retention(RUNTIME)
public @interface Property {

    /**
     * 扩展模块的名称。
     *
     * @return 名称
     */
    String name();

    /**
     * 拓展模块的有关描述。
     *
     * @return 描述
     */
    String details() default "";

    /**
     * 拓展模块的版本信息。
     *
     * @return 版本
     */
    String version() default "";

    /**
     * 拓展模块的作者信息。
     *
     * @return 作者
     */
    String author() default "";

    /**
     * 拓展模块的官网信息。
     *
     * @return 网址
     */
    String website() default "";

}
