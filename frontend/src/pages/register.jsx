import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function Register() {
    const [username, setUsername] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const navigate = useNavigate();


    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await axios.post("http://localhost:8080/auth/register", {
                username,
                email,
                password,
                role: "MEMBERFREE"
            });

            console.log("Register with success:", response.data);
            alert("Registration successful!");
            navigate("/login");

        } catch (error) {
            console.error("Error in registration:", error.response?.data || error.message);
            alert("An error occurred while registering.");
        }
    };

    return (
        <div className="d-flex align-items-center justify-content-center vh-100 bg-light">
            <form onSubmit={handleSubmit} className="card p-4 shadow-sm" style={{ width: "400px" }}>
                <h2 className="mb-4 text-center">Create an Account</h2>

                <div className="mb-3">
                    <label className="form-label">Username</label>
                    <input
                        type="text"
                        className="form-control"
                        placeholder="Enter your username"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                    />
                </div>

                <div className="mb-3">
                    <label className="form-label">Email</label>
                    <input
                        type="email"
                        className="form-control"
                        placeholder="Enter your email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                    />
                </div>

                <div className="mb-4">
                    <label className="form-label">Password</label>
                    <input
                        type="password"
                        className="form-control"
                        placeholder="Enter your password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                </div>

                <button type="submit" className="btn btn-primary w-100">
                    Register
                </button>
            </form>
        </div>
    );
}

export default Register;
