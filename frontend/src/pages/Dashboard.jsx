import { useEffect, useState } from "react";
import { getUsers, getBookings } from "../services/api";
import CreateUserModal from "../components/CreateUserModal";
import HotelBookingModal from "../components/HotelBookingModal";
import FlightBookingModal from "../components/FlightBookingModal";

export default function Dashboard() {
  const [users, setUsers] = useState([]);
  const [selectedUserId, setSelectedUserId] = useState("");
  const [hotelBookings, setHotelBookings] = useState([]);
  const [flightBookings, setFlightBookings] = useState([]);
  const [showCreateUserModal, setShowCreateUserModal] = useState(false);
  const [showHotelModal, setShowHotelModal] = useState(false);
  const [showFlightModal, setShowFlightModal] = useState(false);

  useEffect(() => {
    getUsers().then(res => setUsers(res.data));
  }, []);

  const loadBookings = async (userId) => {
    const res = await getBookings(userId);
    const all = res.data;
    setHotelBookings(all.filter(b => b.bookable?.type === "HOTEL"));
    setFlightBookings(all.filter(b => b.bookable?.type === "FLIGHT"));
  };

  useEffect(() => {
    if (selectedUserId) {
      loadBookings(selectedUserId);
    }
  }, [selectedUserId]);

  return (
    <div className="container">
      <h1>Travel Dashboard</h1>

      {/* User Dropdown */}
      <div className="card">
        <div className="row-space-between">
            <h3 style={{ margin: 0 }}>Select User</h3>
            <button onClick={() => setShowCreateUserModal(true)}>➕ Create User</button>
        </div>
        <div className="row">
            <select className="select-wide"
                value={selectedUserId}
                onChange={e => setSelectedUserId(e.target.value)}
            >
                <option value="">-- Select User --</option>
                {users.map(u => (
                  <option key={u.id} value={u.id}>
                    {u.name}
                  </option>
                ))}
            </select>
        </div>
      </div>

      {/* Hotel Header + Button */}
      {selectedUserId && (
        <div className="card">
          <div className="row-space-between">
              <h3 style={{ margin: 0 }}>Hotel Bookings</h3>
              <button onClick={() => setShowHotelModal(true)}>➕ Book Hotel</button>
          </div>

          {/* Hotel Table */}
          {hotelBookings.length > 0 && (
            <table border="1" cellPadding="8">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Hotel</th>
                  <th>City</th>
                  <th>Price / Night</th>
                </tr>
              </thead>
              <tbody>
                {hotelBookings.map(b => (
                  <tr key={b.id}>
                    <td>{b.id}</td>
                    <td>{b.bookable.name}</td>
                    <td>
                      {b.bookable.city.name} ({b.bookable.city.code})
                    </td>
                    <td>${b.bookable.pricePerNight}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          )}
        </div>
      )}

      {/* Flight Header + Button */}
      {selectedUserId && (
        <div className="card">
          <div className="row-space-between">
              <h3 style={{ margin: 0 }}>Flight Bookings</h3>
              <button onClick={() => setShowFlightModal(true)}>➕ Book Flight</button>
          </div>

          {/* Flight Table */}
          {flightBookings.length > 0 && (
              <table border="1" cellPadding="8">
                <thead>
                  <tr>
                    <th>ID</th>
                    <th>From</th>
                    <th>To</th>
                    <th>Departure</th>
                    <th>Arrival</th>
                    <th>Price</th>
                  </tr>
                </thead>
                <tbody>
                  {flightBookings.map(b => (
                    <tr key={b.id}>
                      <td>{b.id}</td>
                      <td>
                        {b.bookable.origin.name} ({b.bookable.origin.code})
                      </td>
                      <td>
                        {b.bookable.destination.name} ({b.bookable.destination.code})
                      </td>
                      <td>{new Date(b.bookable.departureTime).toLocaleString()}</td>
                      <td>{new Date(b.bookable.arrivalTime).toLocaleString()}</td>
                      <td>${b.bookable.price}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
          )}
        </div>
      )}

      {/* Modal */}
      {showCreateUserModal && (
        <CreateUserModal
          onClose={() => setShowCreateUserModal(false)}
          onCreated={() => getUsers().then(res => setUsers(res.data))}
        />
      )}
      {showHotelModal && (
        <HotelBookingModal
          userId={selectedUserId}
          onClose={() => setShowHotelModal(false)}
          onBooked={() => loadBookings(selectedUserId)}
        />
      )}
      {showFlightModal && (
        <FlightBookingModal
          userId={selectedUserId}
          onClose={() => setShowFlightModal(false)}
          onBooked={() => loadBookings(selectedUserId)}
        />
      )}
    </div>
  );
}
