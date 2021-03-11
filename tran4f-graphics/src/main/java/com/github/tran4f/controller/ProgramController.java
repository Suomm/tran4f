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

package com.github.tran4f.controller;

import com.github.tran4f.service.FileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * <p>
 * 2021/2/17
 * </p>
 *
 * @author 王帅
 * @since 1.0
 */
@RestController
public class ProgramController {

    private final FileService fileService;

    public ProgramController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("get")
    public Mono<String> get() {
        return Mono.just(fileService.getMessage());
    }

    @GetMapping("put")
    public Mono<Void> put() {
        return Mono.fromRunnable(fileService);
    }

}
