/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.rfxcom.internal.messages;

import static org.junit.Assert.assertEquals;

import javax.xml.bind.DatatypeConverter;

import org.junit.Test;
import org.openhab.binding.rfxcom.internal.exceptions.RFXComException;

/**
 * Test for RFXCom-binding
 *
 * @author Martin van Wingerden
 * @since 1.9.0
 */
public class RFXComHumidityMessageTest {

    @Test
    public void testSomeMessages() throws RFXComException {
        String hexMessage = "085101027700360189";
        byte[] message = DatatypeConverter.parseHexBinary(hexMessage);
        RFXComHumidityMessage msg = (RFXComHumidityMessage) RFXComMessageFactory.createMessage(message);
        assertEquals("SubType", RFXComHumidityMessage.SubType.HUM1, msg.subType);
        assertEquals("Seq Number", 2, (short) (msg.seqNbr & 0xFF));
        assertEquals("Sensor Id", "30464", msg.getDeviceId());
        assertEquals("Humidity", 54, msg.humidity);
        assertEquals("Humidity status", RFXComHumidityMessage.HumidityStatus.COMFORT, msg.humidityStatus);
        assertEquals("Signal Level", (byte) 8, msg.signalLevel);
        assertEquals("Battery Level", (byte) 9, msg.batteryLevel);

        byte[] decoded = msg.decodeMessage();

        assertEquals("Message converted back", hexMessage, DatatypeConverter.printHexBinary(decoded));
    }
}