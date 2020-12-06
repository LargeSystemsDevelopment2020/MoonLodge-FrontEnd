package moonlodge.frontend.moonlodgefrontend.registry;

import dk.cphbusiness.lsd.groupe.moonlogde.dto.BookingDTO;
import dk.cphbusiness.lsd.groupe.moonlogde.dto.VacantHotelRoomDTO;
import dk.cphbusiness.lsd.groupe.moonlogde.entitys.Room;
import dk.cphbusiness.lsd.groupe.moonlogde.interfaces.HotelManagerInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RMIMethodsImpl extends UnicastRemoteObject implements HotelManagerInterface {
    public RMIMethodsImpl() throws RemoteException {
    }
    @Override
    public List<VacantHotelRoomDTO> getHotelRoomList(String city, long dateFrom, long dateTo, int numberGuests, int numberRooms) {
        return null;
    }

    @Override
    public BookingDTO createBooking(List<Room> rooms, String passportNumber, long dateFrom, long dateTo, boolean arrivalIsLate) {
        return null;
    }

    @Override
    public List<BookingDTO> findBookings(String passportNumber) {
        System.out.println(passportNumber);
        return Collections.singletonList(new BookingDTO());
    }

    @Override
    public boolean cancelBooking(long bookingId) {
        System.out.println("cancelBooking");
        return false;
    }
}
