package javaee.hiberante.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "reservation_arrived", schema = "library", catalog = "")
public class ReservationArrivedEntity {
    private int reservationArrivedId;

    @Id
    @Column(name = "reservation_arrived_id")
    public int getReservationArrivedId() {
        return reservationArrivedId;
    }

    public void setReservationArrivedId(int reservationArrivedId) {
        this.reservationArrivedId = reservationArrivedId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationArrivedEntity that = (ReservationArrivedEntity) o;
        return reservationArrivedId == that.reservationArrivedId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(reservationArrivedId);
    }
}
