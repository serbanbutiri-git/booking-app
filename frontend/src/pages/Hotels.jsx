import { useEffect, useState } from "react";
import { getHotels } from "../services/api";

export default function Hotels() {
  const [hotels, setHotels] = useState([]);

  useEffect(() => {
    getHotels().then(res => setHotels(res.data));
  }, []);

  return (
    <div>
      <h2>Available Hotels</h2>

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
          {hotels.map(h => (
            <tr key={h.id}>
              <td>{h.id}</td>
              <td>{h.name}</td>
              <td>
                {h.city.name} ({h.city.code})
              </td>
              <td>${h.pricePerNight}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
