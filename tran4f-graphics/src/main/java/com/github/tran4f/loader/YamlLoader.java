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

package com.github.tran4f.loader;

import com.github.tran4f.domain.Settings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.yaml.snakeyaml.Yaml;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * YAML 资源文件的加载器。
 *
 * @author 王帅
 */
@Configuration
public class YamlLoader {

    /**
     * 注册配置文件类。
     *
     * @return 设置
     */
    @Bean
    public Settings settings() {
        try (BufferedReader br = new BufferedReader(
                new FileReader("conf/settings.yml"))) {
            Settings settings = new Yaml().loadAs(br, Settings.class);
            if (settings == null)
                settings = new Settings();
            return settings.init();
        } catch (IOException e) {
            return new Settings().init();
        }
    }

}
