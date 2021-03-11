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

package com.github.tran4f.domain;

/**
 * <p>
 * 2021/2/24
 * </p>
 *
 * @author 王帅
 * @since 1.0
 */
public record Message(String message, String type, String color) {

    private static final String INFO = "[INFO]";
    private static final String ERROR = "[ERROR]";
    private static final String SUCCESS = "[SUCCESS]";
    private static final String WARNING = "[WARNING]";

    public static Message info(String message) {
        return new Message(message, INFO, INFO);
    }

    public static Message error(String message) {
        return new Message(message, ERROR, INFO);
    }

    public static Message success(String message) {
        return new Message(message, SUCCESS, INFO);
    }

    public static Message warning(String message) {
        return new Message(message, WARNING, INFO);
    }

}
