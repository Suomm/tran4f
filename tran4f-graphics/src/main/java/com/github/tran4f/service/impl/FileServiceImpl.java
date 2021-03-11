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

package com.github.tran4f.service.impl;

import com.github.tran4f.service.FileService;
import com.github.tran4f.support.*;
import com.github.tran4f.utils.DiskUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * <p>
 * 2021/2/23
 * </p>
 *
 * @author 王帅
 * @since 1.0
 */
@Service
@SuppressWarnings("rawtypes")
public class FileServiceImpl implements FileService {

    /**
     * 前后端交互信息的队列。
     */
    private final transient LinkedBlockingQueue<String> message;

    private final transient LinkedList<Driver<?>> source;
    private final transient LinkedList<Driver<?>> target;

    private transient Manager manager;
    private transient Executor executor;
    private transient Collector collector;
    private transient Formatter formatter;

    public FileServiceImpl() {
        this.source  = new LinkedList<>();
        this.target  = new LinkedList<>();
        this.message = new LinkedBlockingQueue<>(1);
    }

    private boolean exists() {
        boolean temp;
        int i;
        boolean exists = false;
        for (i = 0; i < source.size(); i++) {
            temp = this.source.get(i).exists();
            if (!temp) continue;
            exists = true;
            break;
        }
        if (target.size() == 1 || !exists) {
            return exists;
        }
        exists = false;
        for (i = 0; i < target.size(); i++) {
            temp = this.target.get(i).exists();
            if (!temp) continue;
            exists = true;
            break;
        }
        return exists;
    }

    @Override
    public void run() {
        try {
            boolean finish = false;
            while (true) {
                if (finish) {
                    while (this.exists())
                        Thread.sleep(50);
                    if (DiskUtils.isUSBDriver('C'))
                        System.out.println("检测到您使用的是U盘，请插入您的U盘！");
                    continue;
                }
                if (target.size() == 1) {
                    this.delete();
                } else if (target.size() == 2) {
                    this.revise();
                } else {
                    this.copy();
                    break;
                }
                System.out.println("文件复制完成！请点击停止按钮完成文件操作！");
                finish = true;
                System.gc();
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getMessage() {
        try {
            return message.take();
        } catch (InterruptedException e) {
            return null;
        }
    }

    public void revise() throws IOException {
        System.out.println("[SOURCE VALUES]:");
        source.forEach(System.out::println);
        System.out.println("[TARGET VALUES]:");
        target.forEach(System.out::println);
    }

    private void copy() throws IOException {
        for (Driver<?> s : source) {
            for (Driver<?> t : target) {
                this.copyFolder(s, t);
            }
        }
    }

    private void copyFolder(Driver<?> source, Driver<?> target) throws IOException {
        if (!source.isDirectory()) {
            System.out.println("赋值操作");
        } else {
            Driver<?> newFile = manager.target(target.value(), source.name());
            String[] files = source.list();
            for (String s : files) {
                Driver<?> folder = manager.target(s);
                this.copyFolder(folder, newFile);
            }
        }
        source.delete();
    }

    private void delete() throws IOException {
        for (Driver<?> s : source)
            this.delete(s);
    }

    private void delete(Driver<?> source) throws IOException {
        if (source.isDirectory()) {
            String[] fs = source.list();
            for (String f : fs) {
                this.delete(manager.source(f));
            }
        } else {
            source.delete();
        }
    }

    public boolean getMatchedFiles(List<String> input, List<String> output, List<String> regexp) throws IOException {
        this.source.clear();
        this.target.clear();
        for (String p : input) {
            Driver<?> d = manager.source(p);
            for (String c : d.list()) {
                if (!this.push(p, c, regexp)) continue;
                for (String o : output) {
                    Driver<?> t = manager.target(o, c);
                    // 判断目标文件（目录）是否存在
                    if (!t.exists()) {
                        this.target.addLast(t);
                    } else {
                        this.target.addFirst(t);
                    }
                }
            }
        }
        return this.source.size() == 0;
    }

    private boolean push(String parent, String child, List<String> regexp) throws IOException {
        if (regexp.stream().anyMatch(child::matches))
            return this.source.add(manager.source(parent, child));
        return false;
    }

}
