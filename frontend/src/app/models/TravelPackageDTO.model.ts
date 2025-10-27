export interface TravelPackageDTO {
  id?: number;
  packageTitle: string;
  packageDescription?: string;
  packageSourceCity?: string;
  packageDestinationCity?: string;
  packageBasePrice: number;
  packageDurationDays?: number;
  packageStartDate?: string;
  packageEndDate?: string;
  packageAvailableSlots?: number;
  packageImageUrl?: string;
  packageStatus?: string;
  createdAt?: string;
}
