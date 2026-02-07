import { useEffect, useState } from "react";
import { getFlights, createBooking } from "../services/api";

export default function FlightBookingModal({ userId, onClose, onBooked }) {
  const [flights, setFlights] = useState([]);
  const [selectedFlightId, setSelectedFlightId] = useState("");

  useEffect(() => {
    getFlights().then(res => setFlights(res.data));
  }, []);

  const submit = async () => {
    await createBooking({
      userId,
      bookableId: selectedFlightId
    });

    onBooked();
    onClose();
  };

  return (
    <div className="modal-overlay">
      <div className="modal-box">
        <h3>Book Flight</h3>

        <select
          value={selectedFlightId}
          onChange={e => setSelectedFlightId(e.target.value)}
        >
          <option value="">-- Select Flight --</option>
          {flights.map(f => (
            <option key={f.id} value={f.id}>
              {f.origin.code} → {f.destination.code} |{" "}
              {new Date(f.departureTime).toLocaleString()} | ${f.price}
            </option>
          ))}
        </select>

        <div className="modal-actions">
          <button disabled={!selectedFlightId} onClick={submit}>
            Confirm Booking
          </button>
          <button onClick={onClose}>Cancel</button>
        </div>
      </div>
    </div>
  );
}
