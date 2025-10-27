import { UserResponseDTO } from "./UserResponseDTO.model";


export interface TokenResponse{
    user:UserResponseDTO;
    token: string;
}