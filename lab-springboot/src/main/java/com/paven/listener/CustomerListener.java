package com.paven.listener;

import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author cpw
 * @date 2021/9/6 10:32 上午
 */
public class CustomerListener implements ApplicationListener<SpringApplicationEvent> {

    public CustomerListener() {
        System.out.println("----------------CustomerListener---------------");
    }

    @Override
    public void onApplicationEvent(SpringApplicationEvent springApplicationEvent) {
        System.out.println("----------------CustomerListener---------------" + springApplicationEvent.toString());
    }
}
