import { useState } from "react";
import { createUser } from "../services/api";

export default function Users() {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");

  const submit = async (e) => {
    e.preventDefault();
    await createUser({ name, email });
    alert("User created!");
    setName("");
    setEmail("");
  };

  return (
    <div>
      <h2>Create User</h2>

      <form onSubmit={submit}>
        <div>
          <input
            placeholder="Name"
            value={name}
            onChange={(e) => setName(e.target.value)}
            required
          />
        </div>

        <div>
          <input
            placeholder="Email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </div>

        <button type="submit">Create User</button>
      </form>
    </div>
  );
}
