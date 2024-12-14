/*
 * Copyright (c) 2022 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package javazoom.jl.player;

import org.junit.jupiter.api.Test;

import javazoom.jl.player.my.MyJavaSoundAudioDeviceFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;


/**
 * factory for MyJavaSoundAudioDevice.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 2022/10/15 nsano initial version <br>
 */
public class JavaSoundAudioDeviceTest {

    @Test
    void test() throws Exception {
        FactoryRegistry factoryRegistry = FactoryRegistry.systemRegistry();
        factoryRegistry.addFactory(new MyJavaSoundAudioDeviceFactory());
        assertEquals(3, factoryRegistry.factories.size()); // default 2 + my 1

        AudioDeviceFactory audioDeviceFactory = factoryRegistry.getFactoriesPriority()[2];
        assertInstanceOf(NullAudioDeviceFactory.class, audioDeviceFactory); // null is the lowest priority
    }
}

