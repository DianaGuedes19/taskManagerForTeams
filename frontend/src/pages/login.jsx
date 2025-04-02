import React, { useState } from "react";
import axios from "axios";

function Login() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const handleLogin = async (e) => {
        e.preventDefault();

        try {
            const response = await axios.post("http://localhost:8080/auth/login", {
                email,
                password
            });

            const token = response.data.token;
            localStorage.setItem("token", token);

            alert("Login successful!");


        } catch (error) {
            console.error("Login error:", error.response?.data || error.message);
            alert("Invalid credentials!");
        }
    };

    return (
        <div className="d-flex align-items-center justify-content-center vh-100 bg-light">
            <div className="card p-4 shadow-sm" style={{ width: "400px" }}>
                <h2 className="mb-4 text-center">Login</h2>

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

                <button className="btn btn-primary w-100" onClick={handleLogin}>
                    Login
                </button>
            </div>
        </div>
    );
}

export default Login;
