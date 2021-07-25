package com.company;

import java.util.ArrayList;
import java.util.TreeMap;

public class PostalOffice {
    TreeMap<String, ArrayList<Subscriber>> subscriptions = new TreeMap<>();
    void subscribe(Subscriber sub, String publishName) {
        if (!subscriptions.containsKey(publishName))
            subscriptions.put(publishName, new ArrayList<>());
        subscriptions.get(publishName).add(sub);
    }
    void receivePublishable(Publishable pub) {
        subscriptions.get(pub.publishName).forEach((s) -> s.receive(pub));
    }
}
