import { BookingPassengerDTO } from "./BookingPassengerDTO.model";
import { HotelInfoDTO } from "./HotelInfoDTO.model";
import { ItineraryPlanDTO } from "./ItineraryPlanDTO.model";

export interface BookingDTO {
  id?: number;
  userId: number;
  packageId: number;
  transportId?: number;
  bookingTotalAmount?: number;
  bookingStatus?: string;
  bookingDate?: string;
  passengers?: BookingPassengerDTO[];
  itineraryPlans?: ItineraryPlanDTO[];
  hotelInfos?: HotelInfoDTO[];
}
