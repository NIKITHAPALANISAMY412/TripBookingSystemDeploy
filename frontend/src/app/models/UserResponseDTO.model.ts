export interface UserResponseDTO {
  userId: number;
  userName: string;
  userEmail: string;
  roles: string[];
  createdAt?: string;
  updatedAt?: string;
}
