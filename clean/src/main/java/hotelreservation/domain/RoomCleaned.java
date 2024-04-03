package hotelreservation.domain;

import hotelreservation.domain.*;
import hotelreservation.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class RoomCleaned extends AbstractEvent {

    private Long id;
    private String cleanStatus;
    private Long customerId;
    private Long reserveId;

    public RoomCleaned(Clean aggregate) {
        super(aggregate);
    }

    public RoomCleaned() {
        super();
    }
}
//>>> DDD / Domain Event
