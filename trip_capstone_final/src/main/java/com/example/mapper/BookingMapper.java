// package com.example.mapper;

// import com.example.dto.BookingDTO;
// import com.example.entity.BookingEntity;
// import com.example.entity.UserEntity;
// import com.example.entity.TravelPackageEntity;
// import com.example.entity.TransportModeEntity;
// import org.mapstruct.Mapper;
// import org.mapstruct.Mapping;
// import org.mapstruct.Named;

// @Mapper(componentModel = "spring")
// public interface BookingMapper {

//     // Entity → DTO
//     @Mapping(source = "bookedBy.id", target = "userId")
//     @Mapping(source = "bookedPackage.id", target = "packageId")
//     @Mapping(source = "transport.id", target = "transportId")
//     BookingDTO toDTO(BookingEntity entity);

//     // DTO → Entity
//     @Mapping(source = "userId", target = "bookedBy", qualifiedByName = "mapUserById")
//     @Mapping(source = "packageId", target = "bookedPackage", qualifiedByName = "mapPackageById")
//     @Mapping(source = "transportId", target = "transport", qualifiedByName = "mapTransportById")
//     BookingEntity toEntity(BookingDTO dto);

//     // Helper methods to map IDs to Entities
//     @Named("mapUserById")
//     default UserEntity mapUserById(Long id) {
//         if (id == null) return null;
//         UserEntity user = new UserEntity();
//         user.setId(id);
//         return user;
//     }

//     @Named("mapPackageById")
//     default TravelPackageEntity mapPackageById(Long id) {
//         if (id == null) return null;
//         TravelPackageEntity travelPackage = new TravelPackageEntity();
//         travelPackage.setId(id);
//         return travelPackage;
//     }

//     @Named("mapTransportById")
//     default TransportModeEntity mapTransportById(Long id) {
//         if (id == null) return null;
//         TransportModeEntity transport = new TransportModeEntity();
//         transport.setId(id);
//         return transport;
//     }
// }
package com.example.mapper;

import com.example.dto.*;
import com.example.entity.BookingEntity;
import com.example.entity.TransportModeEntity;
import com.example.entity.TravelPackageEntity;
import com.example.entity.UserEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
@Mapper(componentModel = "spring")
public interface BookingMapper {

    @Mapping(source = "bookedBy.id", target = "userId")
    @Mapping(source = "bookedPackage.id", target = "packageId")
    @Mapping(source = "transport.id", target = "transportId")
    @Mapping(target = "passengers", ignore = true)        // ignore nested collections
    @Mapping(target = "itineraryPlans", ignore = true)
    @Mapping(target = "hotelInfos", ignore = true)
    BookingDTO toDTO(BookingEntity entity);

    @Mapping(source = "userId", target = "bookedBy", qualifiedByName = "mapUserById")
    @Mapping(source = "packageId", target = "bookedPackage", qualifiedByName = "mapPackageById")
    @Mapping(source = "transportId", target = "transport", qualifiedByName = "mapTransportById")
    BookingEntity toEntity(BookingDTO dto);

    @Named("mapUserById")
    default UserEntity mapUserById(Long id) {
        if (id == null) return null;
        UserEntity user = new UserEntity();
        user.setId(id);
        return user;
    }

    @Named("mapPackageById")
    default TravelPackageEntity mapPackageById(Long id) {
        if (id == null) return null;
        TravelPackageEntity travelPackage = new TravelPackageEntity();
        travelPackage.setId(id);
        return travelPackage;
    }

    @Named("mapTransportById")
    default TransportModeEntity mapTransportById(Long id) {
        if (id == null) return null;
        TransportModeEntity transport = new TransportModeEntity();
        transport.setId(id);
        return transport;
    }
}
