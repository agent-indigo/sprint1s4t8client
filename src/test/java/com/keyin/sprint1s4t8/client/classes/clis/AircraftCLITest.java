package com.keyin.sprint1s4t8.client.classes.clis;

import com.keyin.sprint1s4t8.client.classes.clients.AircraftClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class AircraftCLITest {

    private AircraftCLI cliApp;
    private AircraftClient AircraftClientMock;

    @BeforeEach
    void setUp() {
        AircraftClientMock = Mockito.mock(AircraftClient.class);
        cliApp = new AircraftCLI() {
            {
                this.AircraftClient = AircraftClientMock;
            }
        };
    }

    @Test
    void testListEventsAtVenue() throws Exception {
        when(AircraftClientMock.sendGetRequest(anyString())).thenReturn("Mocked Events Response");

        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        cliApp.listEventsAtVenue();
        verify(AircraftClientMock, times(1)).sendGetRequest("/events?venueId=1");
    }

    @Test
    void testListAttendeesForEvent() throws Exception {
        when(AircraftClientMock.sendGetRequest(anyString())).thenReturn("Mocked Attendees Response");

        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        cliApp.listAttendeesForEvent();
        verify(AircraftClientMock, times(1)).sendGetRequest("/attendees?event=1");
    }

    @Test
    void testListSpeakersForEvent() throws Exception {
        when(AircraftClientMock.sendGetRequest(anyString())).thenReturn("Mocked Speakers Response");

        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        cliApp.listSpeakersForEvent();
        verify(AircraftClientMock, times(1)).sendGetRequest("/events_speakers?eventId=1");
    }

    @Test
    void testListEventsForSpecificDate() throws Exception {
        when(AircraftClientMock.sendGetRequest(anyString())).thenReturn("Mocked Events Response");

        String input = "2023-06-21\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        cliApp.listEventsForSpecificDate();
        verify(AircraftClientMock, times(1)).sendGetRequest("/events?date=2023-06-21");
    }
}