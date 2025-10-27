export interface TransportModeDTO {
  id?: number;
  packageId: number;
  transportType?: string; // "BUS" | "TRAIN" | "FLIGHT"
  transportProvider?: string;
  departureCity?: string;
  arrivalCity?: string;
  departureTime?: string;
  arrivalTime?: string;
  seatPrice?: number;
  availableSeats?: number;
  transportImageUrl?: string;
}
