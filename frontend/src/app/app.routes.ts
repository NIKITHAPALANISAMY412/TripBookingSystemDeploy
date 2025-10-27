import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Admindashboard } from './components/admindashboard/admindashboard';
import { GetAllHotels } from './components/HotelInfoController/get-all-hotels/get-all-hotels';
import { AddHotelComponent } from './components/HotelInfoController/add-hotel/add-hotel';
import { UpdateHotel } from './components/HotelInfoController/update-hotel/update-hotel';
import { GetAllItineraries } from './components/ItineraryPlanController/get-all-itineraries/get-all-itineraries';
import { AddItinerary } from './components/ItineraryPlanController/add-itinerary/add-itinerary';
import { UpdateItinerary } from './components/ItineraryPlanController/update-itinerary/update-itinerary';
import { GetAllTransportModes } from './components/TransportModeController/get-all-transport-modes/get-all-transport-modes';
import { AddTransportMode } from './components/TransportModeController/add-transport-mode/add-transport-mode';
import { UpdateTransportMode } from './components/TransportModeController/update-transport-mode/update-transport-mode';
import { GetTransportsByPackage } from './components/TransportModeController/get-transports-by-package/get-transports-by-package';
import { GetAvailableTransportsByPackage } from './components/TransportModeController/get-available-transports-by-package/get-available-transports-by-package';
import { GetAllPackages } from './components/TravelPackageController/get-all-packages/get-all-packages';
import { AddPackage } from './components/TravelPackageController/add-package/add-package';
import { UpdatePackage } from './components/TravelPackageController/update-package/update-package';
import { GetAllActivePackages } from './components/TravelPackageController/get-all-active-packages/get-all-active-packages';
import { GetAllUsers } from './components/UserController/get-all-users/get-all-users';
import { GetAllWallets } from './components/WalletController/get-all-wallets/get-all-wallets';
import { GetAllTransactions } from './components/WalletTransactionController/get-all-transactions/get-all-transactions';
import { GetAllPassengers } from './components/BookingPassengerController/get-all-passengers/get-all-passengers';
import { GetPassenger } from './components/BookingPassengerController/get-passenger/get-passenger';
import { Downloadreceipt } from './components/BookingReceiptController/downloadreceipt/downloadreceipt';
import { GetAllBookings } from './components/BookingController/get-all-bookings/get-all-bookings';
import { Viewdetailedbooking } from './components/BookingController/viewdetailedbooking/viewdetailedbooking';
import { GetBookingsByPackage } from './components/BookingController/get-bookings-by-package/get-bookings-by-package';
import { SearchPackagesComponent } from './components/TravelPackageController/search-packages/search-packages';
import { Userdashboard } from './components/userdashboard/userdashboard';
import { Entirepackage } from './usercomponent/entirepackage/entirepackage';
import { Viewdetails } from './usercomponent/viewdetails/viewdetails';
import { Bookingfinal } from './usercomponent/bookingfinal/bookingfinal';
import { AddMoneyToWallet } from './components/WalletController/add-money-to-wallet/add-money-to-wallet';
import { UserBookingsComponent } from './usercomponent/user-bookings-component/user-bookings-component';
import { Getwallettransactionbyeachuser } from './components/WalletController/getwallettransactionbyeachuser/getwallettransactionbyeachuser';
import { Login } from './Auth/login/login';
import { Signup } from './Auth/signup/signup';
import { Logout } from './Auth/logout/logout';
import { adminGuardGuard } from './gaurds/admin-guard-guard';
import { userGuardGuard } from './gaurds/user-guard-guard';
import { Myprofile } from './Myprofile/myprofile/myprofile';

export const routes: Routes = [
  {
    path: 'login',
    component: Login,
  },

  {
    path: 'signup',
    component: Signup,
  },

  {
    path: 'logout',
    component: Logout,
  },

  { path: '', redirectTo: 'userdashboard/packages', pathMatch: 'full' },

  { path: 'admindashboard', component: Admindashboard, canActivate: [adminGuardGuard] },

  { path: 'get-all-hotels', component: GetAllHotels, canActivate: [adminGuardGuard] },
        {path:'profile', component: Myprofile,canActivate: [adminGuardGuard] },
  {
    path: 'get-all-hotels/add-hotel',
    component: AddHotelComponent,
    canActivate: [adminGuardGuard],
  },
  {
    path: 'get-all-hotels/update-hotel/:id',
    component: UpdateHotel,
    canActivate: [adminGuardGuard],
  },

  { path: 'get-all-itineraries', component: GetAllItineraries, canActivate: [adminGuardGuard] },
  {
    path: 'get-all-itineraries/add-itinerary',
    component: AddItinerary,
    canActivate: [adminGuardGuard],
  },
  {
    path: 'get-all-itineraries/update-itinerary/:id',
    component: UpdateItinerary,
    canActivate: [adminGuardGuard],
  },

  {
    path: 'get-all-transport-modes',
    component: GetAllTransportModes,
    canActivate: [adminGuardGuard],
  },
  {
    path: 'get-all-transport-modes/add-transport-mode',
    component: AddTransportMode,
    canActivate: [adminGuardGuard],
  },
  {
    path: 'get-all-transport-modes/update-transport-mode/:id',
    component: UpdateTransportMode,
    canActivate: [adminGuardGuard],
  },
  {
    path: 'get-all-transport-modes/transports/package/:packageId',
    component: GetTransportsByPackage,
    canActivate: [adminGuardGuard],
  },
  {
    path: 'get-all-transport-modes/available-transports/package/:packageId',
    component: GetAvailableTransportsByPackage,
    canActivate: [adminGuardGuard],
  },

  { path: 'get-all-packages', component: GetAllPackages, canActivate: [adminGuardGuard] },
  { path: 'get-all-packages/add-package', component: AddPackage, canActivate: [adminGuardGuard] },
  {
    path: 'get-all-packages/update-package/:id',
    component: UpdatePackage,
    canActivate: [adminGuardGuard],
  },
  {
    path: 'get-all-packages/get-all-active-packages',
    component: GetAllActivePackages,
    canActivate: [adminGuardGuard],
  },
  { path: 'search-packages', component: SearchPackagesComponent, canActivate: [adminGuardGuard] },

  { path: 'get-all-users', component: GetAllUsers, canActivate: [adminGuardGuard] },

  { path: 'get-all-wallets', component: GetAllWallets, canActivate: [adminGuardGuard] },
  { path: 'get-all-transactions', component: GetAllTransactions },

  { path: 'get-all-passengers', component: GetAllPassengers, canActivate: [adminGuardGuard] },
  { path: 'get-passenger/:id', component: GetPassenger, canActivate: [adminGuardGuard] },

  { path: 'download-receipt', component: Downloadreceipt, canActivate: [adminGuardGuard] },

  { path: 'get-all-bookings', component: GetAllBookings },
  {
    path: 'view-detailed-booking/:id',
    component: Viewdetailedbooking,
    canActivate: [adminGuardGuard],
  },
  {
    path: 'get-bookings-by-package/:packageId',
    component: GetBookingsByPackage,
    canActivate: [adminGuardGuard],
  },
  { path: 'package/:id', component: Viewdetails, canActivate: [adminGuardGuard] },

  {
    path: 'userdashboard',
    component: Userdashboard,
    children: [
      { path: 'packages', component: Entirepackage },
      { path: 'package/:id', component: Viewdetails, canActivate: [userGuardGuard]},
      { path: 'booking/:id', component: Bookingfinal, canActivate: [userGuardGuard] },
      {
        path: 'userdashboard/packages/search-packages',
        component: SearchPackagesComponent,
        canActivate: [userGuardGuard],
      },
      { path: 'wallet', component: AddMoneyToWallet, canActivate: [userGuardGuard] },
      { path: 'bookings', component: UserBookingsComponent, canActivate: [userGuardGuard] },
      {
        path: 'Transaction',
        component: Getwallettransactionbyeachuser,
        canActivate: [userGuardGuard],
      },
      { path: 'download-receipt', component: Downloadreceipt, canActivate: [userGuardGuard] },
      {path:'profile', component: Myprofile, canActivate: [userGuardGuard] },
      { path: '', redirectTo: 'packages', pathMatch: 'full' },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
