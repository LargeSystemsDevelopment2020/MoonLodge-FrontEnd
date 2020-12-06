package moonlodge.frontend.moonlodgefrontend.controller;



import dk.cphbusiness.lsd.groupe.moonlogde.dto.BookingDTO;
import dk.cphbusiness.lsd.groupe.moonlogde.dto.VacantHotelRoomDTO;
import dk.cphbusiness.lsd.groupe.moonlogde.entitys.Room;
import moonlodge.frontend.moonlodgefrontend.service.HotelManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelManagerController {


    @Autowired
    HotelManagerService hotelManagerService;

    @GetMapping("/hello")
    public String getHello(){
        return "hello";
    }

    @GetMapping("/rooms")
    public List<VacantHotelRoomDTO> getVacantRooms(@RequestBody VacantRoomRequest vacantRoomRequest) throws RemoteException {
        return this.hotelManagerService.getHotelRoomList(vacantRoomRequest.city, vacantRoomRequest.dateFrom, vacantRoomRequest.getDateTo(), vacantRoomRequest.numberGuests, vacantRoomRequest.numberRooms);
    }

    @PostMapping("/booking/")
    public BookingDTO createBooking(@RequestBody BookingResponseBody bookingResponseBody) throws RemoteException {
        System.out.println(bookingResponseBody.toString());

        return this.hotelManagerService.createBooking(bookingResponseBody.getRooms(), bookingResponseBody.getPassportNumber(), bookingResponseBody.getDateFrom(), bookingResponseBody.getDateTo(), bookingResponseBody.isArrivalIsLate());
    }

    @GetMapping("/booking/{passportNumber}")
    public List<BookingDTO> findBookings(@PathVariable("passportNumber") String passportNumber) throws RemoteException{
        return this.hotelManagerService.findBookings(passportNumber);
    }

    @DeleteMapping("/booking/{bookingId}")
    public Boolean deleteBooking(@PathVariable("bookingId") long bookingId) throws RemoteException {
        return this.hotelManagerService.cancelBooking(bookingId);
    }

    static class VacantRoomRequest {
        private String city;
        private long dateFrom,  dateTo;
        private int numberGuests, numberRooms;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public long getDateFrom() {
            return dateFrom;
        }

        public void setDateFrom(long dateFrom) {
            this.dateFrom = dateFrom;
        }

        public long getDateTo() {
            return dateTo;
        }

        public void setDateTo(long dateTo) {
            this.dateTo = dateTo;
        }

        public int getNumberGuests() {
            return numberGuests;
        }

        public void setNumberGuests(int numberGuests) {
            this.numberGuests = numberGuests;
        }

        public int getNumberRooms() {
            return numberRooms;
        }

        public void setNumberRooms(int numberRooms) {
            this.numberRooms = numberRooms;
        }
    }

    static class BookingResponseBody {
        private List<Room> rooms;
        private String passportNumber;
        private long dateFrom;
        private long dateTo;
        private boolean arrivalIsLate;

        public String getPassportNumber() {
            return passportNumber;
        }

        public void setPassportNumber(String passportNumber) {
            this.passportNumber = passportNumber;
        }

        public List<Room> getRooms() {
            return rooms;
        }

        public void setRooms(List<Room> rooms) {
            this.rooms = rooms;
        }


        public long getDateFrom() {
            return dateFrom;
        }

        public void setDateFrom(long dateFrom) {
            this.dateFrom = dateFrom;
        }

        public long getDateTo() {
            return dateTo;
        }

        public void setDateTo(long dateTo) {
            this.dateTo = dateTo;
        }

        public boolean isArrivalIsLate() {
            return arrivalIsLate;
        }

        public void setArrivalIsLate(boolean arrivalIsLate) {
            this.arrivalIsLate = arrivalIsLate;
        }

        @Override
        public String toString() {
            return "BookingResponseBody{" +
                    "rooms=" + rooms +
                    ", passportNumber='" + passportNumber + '\'' +
                    ", dateFrom=" + dateFrom +
                    ", dateTo=" + dateTo +
                    ", arrivalIsLate=" + arrivalIsLate +
                    '}';
        }
    }

}
