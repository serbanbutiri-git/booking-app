import { useEffect, useState } from "react";
import { getFlights } from "../services/api";

export default function Flights() {
  const [flights, setFlights] = useState([]);

  useEffect(() => {
    getFlights().then(res => setFlights(res.data));
  }, []);

  return (
    <div>
      <h2>Available Flights</h2>

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
          {flights.map(f => (
            <tr key={f.id}>
              <td>{f.id}</td>
              <td>
                {f.origin.name} ({f.origin.code})
              </td>
              <td>
                {f.destination.name} ({f.destination.code})
              </td>
              <td>{new Date(f.departureTime).toLocaleString()}</td>
              <td>{new Date(f.arrivalTime).toLocaleString()}</td>
              <td>${f.price}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
