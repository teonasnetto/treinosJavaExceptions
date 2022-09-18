package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
        //adicionar checagem de erro no construtor
        if (!checkOut.after(checkIn)) {
            throw new DomainException("CheckOut tem que ser dps do checkIn");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getcheckIn() {
        return checkIn;
    }

    public Date getcheckOut() {
        return checkOut;
    }
    
    public long duration() {
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    //throws DomainException para propagar para quem chamar o método, deve ser tratato por quem chama o metodo
    public void updateDates(Date checkIn, Date checkOut) throws DomainException {

        Date now = new Date();

        //adicionar checagem de erros ao atualizar as datas
        if (checkIn.before(now) || checkOut.before(now)) {
            throw new DomainException("Datas de atualização do devem ser futuras a hoje.");
        }
        if (!checkOut.after(checkIn)) {
            throw new DomainException("CheckOut tem que ser dps do checkIn");
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + ", checkIn= " + sdf.format(checkIn) + ", checkOut= " + sdf.format(checkOut) + ", " + duration() + " Nigths.";
    }
}
