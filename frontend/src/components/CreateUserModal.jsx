import { useState } from "react";
import { createUser } from "../services/api";

export default function CreateUserModal({ onClose, onCreated }) {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");

  const submit = async () => {
    await createUser({ name, email });
    onCreated();  // refresh users list
    onClose();    // close modal
  };

  return (
    <div className="modal-overlay">
      <div className="modal-box">
        <h3>Create User</h3>

        <input
          type="text"
          placeholder="Name"
          value={name}
          onChange={e => setName(e.target.value)}
        />

        <input
          type="email"
          placeholder="Email"
          value={email}
          onChange={e => setEmail(e.target.value)}
          style={{ marginTop: "8px" }}
        />

        <div className="modal-actions">
          <button disabled={!name || !email} onClick={submit}>
            Create
          </button>
          <button onClick={onClose}>Cancel</button>
        </div>
      </div>
    </div>
  );
}
