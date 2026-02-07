import { NavLink, Routes, Route } from "react-router-dom";
import Dashboard from "./pages/Dashboard";
import Flights from "./pages/Flights";
import Hotels from "./pages/Hotels";

export default function App() {
  return (
    <div className="container">
      <nav className="nav-tabs">
        <NavLink to="/" end>
          Dashboard
        </NavLink>
        <NavLink to="/flights">
          Flights
        </NavLink>
        <NavLink to="/hotels">
          Hotels
        </NavLink>
      </nav>

      <Routes>
        <Route path="/" element={<Dashboard />} />
        <Route path="/flights" element={<Flights />} />
        <Route path="/hotels" element={<Hotels />} />
      </Routes>
    </div>
  );
}
