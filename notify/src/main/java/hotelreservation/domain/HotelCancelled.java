package hotelreservation.domain;

import hotelreservation.domain.*;
import hotelreservation.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class HotelCancelled extends AbstractEvent {

    private Long id;
    private String roomId;
    private Long roomQty;
}
