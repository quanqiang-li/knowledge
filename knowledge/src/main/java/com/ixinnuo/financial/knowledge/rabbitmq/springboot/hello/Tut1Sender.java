/* Copyright 2015 the original author or authors. Licensed under the Apache
 * License, Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law
 * or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License. */
package com.ixinnuo.financial.knowledge.rabbitmq.springboot.hello;

import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Gary Russell
 * @author Scott Deeg
 */
public class Tut1Sender {

    @Autowired
    private RabbitTemplate template;

    @Resource(name = "helloQueue")
    private Queue queue;

    /**
     * 启动之后500毫秒开始执行，每1秒执行一次
     */
    public void send() {
        String message = "Hello 中国 from spring!" + Calendar.getInstance().getTimeInMillis();
        this.template.convertAndSend(queue.getName(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }

}
