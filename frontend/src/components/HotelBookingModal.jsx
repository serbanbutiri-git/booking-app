import { useEffect, useState } from "react";
import { getHotels, createBooking } from "../services/api";

export default function HotelBookingModal({ userId, onClose, onBooked }) {
  const [hotels, setHotels] = useState([]);
  const [selectedHotelId, setSelectedHotelId] = useState("");

  useEffect(() => {
    getHotels().then(res => setHotels(res.data));
  }, []);

  const submit = async () => {
    await createBooking({
      userId,
      bookableId: selectedHotelId
    });

    onBooked();
    onClose();
  };

  return (
    <div className="modal-overlay">
      <div className="modal-box">
        <h3>Book Hotel</h3>

        <select
          value={selectedHotelId}
          onChange={e => setSelectedHotelId(e.target.value)}
        >
          <option value="">-- Select Hotel --</option>
          {hotels.map(h => (
            <option key={h.id} value={h.id}>
              {h.name} – {h.city.name} ({h.city.code}) – ${h.pricePerNight}
            </option>
          ))}
        </select>

        <div className="modal-actions">
          <button disabled={!selectedHotelId} onClick={submit}>
            Confirm Booking
          </button>
          <button onClick={onClose}>Cancel</button>
        </div>
      </div>
    </div>
  );
}
