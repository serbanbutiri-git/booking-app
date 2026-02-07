import axios from "axios";

export const api = axios.create({
  baseURL: "http://localhost:8080/api",
});


export const getUsers = () => api.get("/users");
export const createUser = (user) => api.post("/users", user);

export const getFlights = () => api.get("/flights");

export const getHotels = () => api.get("/hotels");

export const getBookings = (userId) => api.get(`/bookings/${userId}`);
export const createBooking = (data) => api.post("/bookings", data);

