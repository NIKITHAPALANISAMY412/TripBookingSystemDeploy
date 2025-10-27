export interface BookingPassengerDTO {
  id?: number;
  bookingId?: number;
  passengerName?: string;
  passengerEmail?: string;
  passengerPhone?: string;
  passengerAge?: number;
  passengerDob?: string;
  passengerGender?: string; // "MALE" | "FEMALE" | "OTHER"
}
