package hotelreservation.domain;

import hotelreservation.ReserveApplication;
import hotelreservation.domain.HotelCancelled;
import hotelreservation.domain.HotelReserved;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Reserve_table")
@Data
//<<< DDD / Aggregate Root
public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String roomId;

    private Long roomQty;

    @PostPersist
    public void onPostPersist() {
        HotelReserved hotelReserved = new HotelReserved(this);
        hotelReserved.publishAfterCommit();

        HotelCancelled hotelCancelled = new HotelCancelled(this);
        hotelCancelled.publishAfterCommit();
    }

    public static ReserveRepository repository() {
        ReserveRepository reserveRepository = ReserveApplication.applicationContext.getBean(
            ReserveRepository.class
        );
        return reserveRepository;
    }

    //<<< Clean Arch / Port Method
    public static void updateRoomQty(HotelReserved hotelReserved) {
        //implement business logic here:

        /** Example 1:  new item 
        Reserve reserve = new Reserve();
        repository().save(reserve);

        */

        /** Example 2:  finding and process
        
        repository().findById(hotelReserved.get???()).ifPresent(reserve->{
            
            reserve // do something
            repository().save(reserve);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void updateRoomQty(HotelCancelled hotelCancelled) {
        //implement business logic here:

        /** Example 1:  new item 
        Reserve reserve = new Reserve();
        repository().save(reserve);

        */

        /** Example 2:  finding and process
        
        repository().findById(hotelCancelled.get???()).ifPresent(reserve->{
            
            reserve // do something
            repository().save(reserve);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
